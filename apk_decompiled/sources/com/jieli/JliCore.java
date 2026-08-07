package com.jieli;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.jieli.JliCore;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.otasdk.util.OtaConstant;
import com.jieli.util.AppUtil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class JliCore {
    public static long FILE_SIZE_LIMIT = 314572800;
    private static JliCore instance;

    @SuppressLint({"StaticFieldLeak"})
    private static SaveLogFileThread mSaveLogFileThread;
    private final boolean isDebug = false;
    private Application mApplication;

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

        private void createFile(Context context) {
            if (context == null) {
                return;
            }
            try {
                this.mLogFileOutputStream = new FileOutputStream(JliCore.getLogFileDir() + "/ota_log_app_" + currentTimeString() + ".txt", true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private String currentTimeString() {
            return new SimpleDateFormat("yyyyMMddHHmmss.SSS", Locale.getDefault()).format(Calendar.getInstance().getTime());
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
            createFile(this.mContext);
            synchronized (this.mQueue) {
                while (this.isSaving) {
                    try {
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
                                if (this.fileSize >= JliCore.FILE_SIZE_LIMIT) {
                                    try {
                                        this.mLogFileOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                    this.fileSize = 0L;
                                    createFile(this.mContext);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
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
            }
            SaveLogFileThread unused = JliCore.mSaveLogFileThread = null;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.fileSize = 0L;
            this.isSaving = this.mContext != null;
            super.start();
        }
    }

    public static synchronized JliCore getInstance() {
        try {
            if (instance == null) {
                instance = new JliCore();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    public static String getLogFileDir() {
        return AppUtil.createFilePath(getInstance().getApplication(), "logcat");
    }

    public static String getOTAFileDir() {
        return AppUtil.createDownloadFolderFilePath(getInstance().getApplication(), OtaConstant.DIR_ROOT, OtaConstant.DIR_UPGRADE);
    }

    private void handleLog(boolean z) {
        SaveLogFileThread saveLogFileThread = new SaveLogFileThread(getInstance().getApplication());
        mSaveLogFileThread = saveLogFileThread;
        saveLogFileThread.start();
        JL_Log.setLog(z);
        JL_Log.setIsSaveLogFile(getInstance().getApplication(), false);
        JL_Log.setLogOutput(new JL_Log.ILogOutput() { // from class: t41
            @Override // com.jieli.jl_bt_ota.util.JL_Log.ILogOutput
            public final void output(String str) {
                JliCore.lambda$handleLog$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleLog$0(String str) {
        mSaveLogFileThread.addLog(str.getBytes());
    }

    protected void finalize() throws Throwable {
        super.finalize();
        handleLog(false);
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public void init(Application application) {
        this.mApplication = application;
        CommonUtil.setMainContext(application);
        handleLog(false);
    }
}
