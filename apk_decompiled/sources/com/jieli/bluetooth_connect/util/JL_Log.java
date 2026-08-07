package com.jieli.bluetooth_connect.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class JL_Log {
    private static final String DIR_LOGCAT = "logcat";
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_WARN = 4;
    public static int LOG_FILE_SIZE_LIMIT = 62914560;
    public static int SAVE_LOG_LEVEL = 1;
    private static final String TAG_PREFIX = "bt:";
    private static boolean isLog = true;
    private static boolean isSaveLogFile = false;
    private static ILogOutput logOutput;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    @SuppressLint({"StaticFieldLeak"})
    private static SaveLogFileThread mSaveLogFileThread;
    private static String saveLogFilePath;

    @SuppressLint({"ConstantLocale"})
    private static final SimpleDateFormat yyyyMMdd_HHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmss.SSS", Locale.ENGLISH);

    public interface ILogOutput {
        void output(String str);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    private static class SaveLogFileThread extends Thread {
        private long fileSize;
        private volatile boolean isSaving;
        private volatile boolean isWaiting;
        private final Context mContext;
        private FileOutputStream mLogFileOutputStream;
        private final LinkedBlockingQueue<byte[]> mQueue;

        public SaveLogFileThread(Context context) {
            super("SaveLogFileThread");
            this.mQueue = new LinkedBlockingQueue<>();
            this.mContext = context;
        }

        private boolean createFile(Context context) {
            if (context == null) {
                return false;
            }
            if (TextUtils.isEmpty(JL_Log.saveLogFilePath)) {
                String unused = JL_Log.saveLogFilePath = JL_Log.getSaveLogPath(context);
            }
            try {
                this.mLogFileOutputStream = new FileOutputStream(JL_Log.saveLogFilePath + "/bluetooth_log_app_" + JL_Log.currentTimeString() + ".txt", true);
                this.fileSize = 0L;
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }

        private void wakeupSaveThread() {
            if (this.isWaiting) {
                synchronized (this.mQueue) {
                    this.mQueue.notify();
                }
            }
        }

        public void addLog(byte[] bArr) {
            if (bArr != null) {
                try {
                    this.mQueue.put(bArr);
                    wakeupSaveThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void closeSaveFile() {
            this.isSaving = false;
            wakeupSaveThread();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            this.isSaving = createFile(this.mContext);
            synchronized (this.mQueue) {
                while (this.isSaving) {
                    if (this.mQueue.isEmpty()) {
                        this.isWaiting = true;
                        try {
                            this.mQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.isWaiting = false;
                        byte[] bArrPoll = this.mQueue.poll();
                        if (bArrPoll != null && (fileOutputStream = this.mLogFileOutputStream) != null) {
                            try {
                                fileOutputStream.write(bArrPoll);
                                this.fileSize += (long) bArrPoll.length;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            if (this.fileSize >= JL_Log.LOG_FILE_SIZE_LIMIT) {
                                try {
                                    this.mLogFileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                this.isSaving = createFile(this.mContext);
                                break;
                            }
                        }
                    }
                }
            }
            this.isSaving = false;
            this.isWaiting = false;
            this.mQueue.clear();
            FileOutputStream fileOutputStream2 = this.mLogFileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                this.mLogFileOutputStream = null;
            }
            SaveLogFileThread unused = JL_Log.mSaveLogFileThread = null;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.fileSize = 0L;
            this.isSaving = this.mContext != null;
            super.start();
        }
    }

    public static void addLogOutput(String str) {
        if (isSaveLogFile) {
            if (mSaveLogFileThread == null) {
                openLogFileStream(mContext);
                SystemClock.sleep(20L);
            }
            mSaveLogFileThread.addLog(str.getBytes());
        }
    }

    private static void closeLogFile() {
        SaveLogFileThread saveLogFileThread = mSaveLogFileThread;
        if (saveLogFileThread != null) {
            saveLogFileThread.closeSaveFile();
            mSaveLogFileThread = null;
        }
    }

    public static String createFilePath(Context context, String... strArr) {
        File externalFilesDir;
        if (context == null || strArr == null || strArr.length == 0 || (externalFilesDir = context.getExternalFilesDir(null)) == null || !externalFilesDir.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(externalFilesDir.getPath());
        if (sb.toString().endsWith(WatchConstant.FAT_FS_ROOT)) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(WatchConstant.FAT_FS_ROOT)));
        }
        for (String str : strArr) {
            sb.append(WatchConstant.FAT_FS_ROOT);
            sb.append(str);
            File file = new File(sb.toString());
            if ((!file.exists() || file.isFile()) && !file.mkdir()) {
                w("jieli", "createFilePath", "create dir failed. filePath = " + ((Object) sb));
                break;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String currentTimeString() {
        return yyyyMMdd_HHmmssSSS.format(Calendar.getInstance().getTime());
    }

    public static void d(String str, String str2) {
        logFormat(2, str, str2);
    }

    public static void e(String str, String str2) {
        logFormat(5, str, str2);
    }

    private static String formatLog(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeString());
        sb.append("   ");
        sb.append(str);
        sb.append("   ");
        if (str2 == null) {
            str2 = "null";
        }
        sb.append(str2);
        sb.append(" :  ");
        if (str3 == null) {
            str3 = "null";
        }
        sb.append(str3);
        sb.append("\n");
        return sb.toString();
    }

    private static String formatMethod(String str, String str2) {
        return String.format(Locale.ENGLISH, "[%s] >>> %s", str, str2);
    }

    private static String formatTag(String str) {
        return TAG_PREFIX + str;
    }

    private static String getLevelString(int i) {
        if (i == 1) {
            return "v";
        }
        if (i == 2) {
            return "d";
        }
        if (i == 3) {
            return "i";
        }
        if (i != 4) {
            return i != 5 ? Constants.STR_EMPTY : "e";
        }
        return "w";
    }

    public static boolean getSaveLogFile() {
        return isSaveLogFile;
    }

    public static String getSaveLogPath(Context context) {
        return createFilePath(context, "logcat");
    }

    public static void i(String str, String str2) {
        logFormat(3, str, str2);
    }

    public static boolean isLog() {
        return isLog;
    }

    private static void logFormat(int i, String str, String str2) {
        String tag = formatTag(str);
        if (isLog) {
            if (i == 1) {
                Log.v(tag, str2);
            } else if (i == 2) {
                Log.d(tag, str2);
            } else if (i == 3) {
                Log.i(tag, str2);
            } else if (i == 4) {
                Log.w(tag, str2);
            } else if (i != 5) {
                return;
            } else {
                Log.e(tag, str2);
            }
        }
        saveLogInFile(i, tag, str2);
    }

    private static void openLogFileStream(Context context) {
        SaveLogFileThread saveLogFileThread = mSaveLogFileThread;
        if (saveLogFileThread == null || !saveLogFileThread.isSaving) {
            SaveLogFileThread saveLogFileThread2 = new SaveLogFileThread(context);
            mSaveLogFileThread = saveLogFileThread2;
            saveLogFileThread2.start();
        }
    }

    private static void saveLogInFile(int i, String str, String str2) {
        String log = formatLog(getLevelString(i), str, str2);
        ILogOutput iLogOutput = logOutput;
        if (iLogOutput != null) {
            iLogOutput.output(log);
        } else {
            if (i < SAVE_LOG_LEVEL) {
                return;
            }
            addLogOutput(log);
        }
    }

    public static void setIsSaveLogFile(boolean z, Context context) {
        isSaveLogFile = z;
        if (z) {
            mContext = context;
            openLogFileStream(context);
        } else {
            mContext = null;
            closeLogFile();
        }
    }

    public static void setLog(boolean z) {
        isLog = z;
    }

    public static void setLogOutput(ILogOutput iLogOutput) {
        logOutput = iLogOutput;
    }

    public static void v(String str, String str2) {
        logFormat(1, str, str2);
    }

    public static void w(String str, String str2) {
        logFormat(4, str, str2);
    }

    public static void d(String str, String str2, String str3) {
        d(str, formatMethod(str2, str3));
    }

    public static void e(String str, String str2, String str3) {
        e(str, formatMethod(str2, str3));
    }

    public static void i(String str, String str2, String str3) {
        i(str, formatMethod(str2, str3));
    }

    public static void v(String str, String str2, String str3) {
        v(str, formatMethod(str2, str3));
    }

    public static void w(String str, String str2, String str3) {
        w(str, formatMethod(str2, str3));
    }
}
