package com.tenmeter.smlibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadUtils {
    private static final String TAG = "DownloadUtils";
    public static boolean isStop = false;
    private static Context mContext;
    private static DownloadUtils mDownloadUtils;
    private static ThreadUtils mThreadUtils;
    private String mDownloadUrl;
    private String mDriPath;
    private String mFileName;

    public interface OnDownloadListener {
        void onError(String str);

        void onFinish(File file);

        void onProgress(int i, int i2);

        void onStart();
    }

    private static class ThreadUtils {
        private Handler mHandler;

        private ThreadUtils() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        public boolean isMainThread() {
            return Looper.getMainLooper() == Looper.myLooper();
        }

        public void runOnSubThread(Runnable runnable) {
            new Thread(runnable).start();
        }

        public void runOnUiThread(Runnable runnable) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.mHandler.post(runnable);
            }
        }
    }

    private DownloadUtils() {
    }

    public static DownloadUtils getInstance() {
        if (mThreadUtils == null) {
            mThreadUtils = new ThreadUtils();
        }
        if (mDownloadUtils == null) {
            mDownloadUtils = new DownloadUtils();
        }
        return mDownloadUtils;
    }

    public Thread downLoadFile(final String str, final String str2, final String str3, final OnDownloadListener onDownloadListener) {
        Thread thread = new Thread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1

            /* JADX INFO: renamed from: com.tenmeter.smlibrary.utils.DownloadUtils$1$3, reason: invalid class name */
            class AnonymousClass3 implements Runnable {
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    onDownloadListener.onError("无法创建文件");
                }
            }

            /* JADX WARN: Code duplicated, block: B:105:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:74:0x01ba A[Catch: Exception -> 0x01b6, TryCatch #8 {Exception -> 0x01b6, blocks: (B:70:0x01b2, B:74:0x01ba, B:76:0x01bf), top: B:103:0x01b2 }] */
            /* JADX WARN: Code duplicated, block: B:76:0x01bf A[Catch: Exception -> 0x01b6, TRY_LEAVE, TryCatch #8 {Exception -> 0x01b6, blocks: (B:70:0x01b2, B:74:0x01ba, B:76:0x01bf), top: B:103:0x01b2 }] */
            /* JADX WARN: Code duplicated, block: B:85:0x01d8 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:86:0x01da A[Catch: Exception -> 0x01d6, TryCatch #9 {Exception -> 0x01d6, blocks: (B:82:0x01d2, B:86:0x01da, B:88:0x01df), top: B:105:0x01d2 }] */
            /* JADX WARN: Code duplicated, block: B:88:0x01df A[Catch: Exception -> 0x01d6, TRY_LEAVE, TryCatch #9 {Exception -> 0x01d6, blocks: (B:82:0x01d2, B:86:0x01da, B:88:0x01df), top: B:105:0x01d2 }] */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                HttpURLConnection httpURLConnection;
                FileOutputStream fileOutputStream;
                ThreadUtils threadUtils;
                Runnable runnable;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    throw new NullPointerException("downloadUrl is a null");
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    throw new NullPointerException("driPath is a null");
                }
                if (TextUtils.isEmpty(str3)) {
                    throw new NullPointerException("fileName is a null");
                }
                if (onDownloadListener == null) {
                    throw new NullPointerException("OnDownloadListener is a null object");
                }
                KLog.d("gLog", "DownloadUtils - 文件下载 ------>> 文件下载地址: " + str);
                KLog.d("gLog", "DownloadUtils - 文件下载 ------>> 文件保存路径: " + str2);
                KLog.d("gLog", "DownloadUtils - 文件下载 ------>> 文件保存名称: " + str3);
                DownloadUtils.mThreadUtils.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onDownloadListener.onStart();
                    }
                });
                File file = new File(str2);
                if (!file.exists() && !file.mkdirs()) {
                    DownloadUtils.mThreadUtils.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            onDownloadListener.onError("无法创建文件夹");
                        }
                    });
                    return;
                }
                final File file2 = new File(str2 + File.separator + str3);
                InputStream inputStream = null;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.connect();
                        final int contentLength = httpURLConnection.getContentLength();
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[4096];
                                int i = 0;
                                while (true) {
                                    int i2 = inputStream2.read(bArr);
                                    if (i2 <= 0 || DownloadUtils.isStop) {
                                        break;
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i2);
                                    i += i2;
                                    final int i3 = (int) (((i * 1.0f) / contentLength) * 100.0f);
                                    DownloadUtils.mThreadUtils.runOnSubThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.4
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            onDownloadListener.onProgress(contentLength, i3);
                                        }
                                    });
                                }
                                if (DownloadUtils.isStop) {
                                    KLog.d("gLog", "DownloadUtils - 取消下载 ------>> 文件下载地址: " + str);
                                    DownloadUtils.mThreadUtils.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.6
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            onDownloadListener.onError("取消下载 ");
                                        }
                                    });
                                } else {
                                    DownloadUtils.mThreadUtils.runOnSubThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.5
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            onDownloadListener.onFinish(file2);
                                        }
                                    });
                                }
                                try {
                                    inputStream2.close();
                                    fileOutputStream.close();
                                    httpURLConnection.disconnect();
                                } catch (Exception e) {
                                    threadUtils = DownloadUtils.mThreadUtils;
                                    runnable = new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.10
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            onDownloadListener.onError("IO流关闭失败, 失败信息: " + e.getMessage());
                                        }
                                    };
                                    threadUtils.runOnUiThread(runnable);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                inputStream = inputStream2;
                                try {
                                    if (!file2.exists()) {
                                        DownloadUtils.mThreadUtils.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.9
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                onDownloadListener.onError("下载失败, 失败信息: " + e.getMessage());
                                            }
                                        });
                                    } else if (file2.delete()) {
                                        DownloadUtils.mThreadUtils.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.7
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                onDownloadListener.onError("下载失败, 失败信息: " + e.getMessage());
                                            }
                                        });
                                    } else {
                                        DownloadUtils.mThreadUtils.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.8
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                onDownloadListener.onError("下载失败, 失败信息: " + e.getMessage());
                                            }
                                        });
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                        } catch (Exception e3) {
                                            threadUtils = DownloadUtils.mThreadUtils;
                                            runnable = new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.10
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    onDownloadListener.onError("IO流关闭失败, 失败信息: " + e3.getMessage());
                                                }
                                            };
                                            threadUtils.runOnUiThread(runnable);
                                        }
                                    } else {
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                        } catch (Exception e4) {
                                            DownloadUtils.mThreadUtils.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1.10
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    onDownloadListener.onError("IO流关闭失败, 失败信息: " + e4.getMessage());
                                                }
                                            });
                                            throw th;
                                        }
                                    } else {
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    inputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } else {
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                } catch (Exception e7) {
                    e = e7;
                    httpURLConnection = null;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = null;
                    fileOutputStream = null;
                }
                DownloadUtils.isStop = false;
            }
        });
        thread.start();
        return thread;
    }

    public DownloadUtils setDirPath(String str) {
        if (str == null) {
            throw new NullPointerException("dirPath is a null");
        }
        this.mDriPath = str;
        return mDownloadUtils;
    }

    public DownloadUtils setFileName(String str) {
        if (str == null) {
            throw new NullPointerException("fileName is a null");
        }
        this.mFileName = str;
        return mDownloadUtils;
    }

    public void setOnDownloadListener(OnDownloadListener onDownloadListener) {
        if (onDownloadListener == null) {
            throw new NullPointerException("OnDownloadListener is a null");
        }
        downLoadFile(this.mDownloadUrl, this.mDriPath, this.mFileName, onDownloadListener);
    }

    public Thread setOnDownloadListener1(OnDownloadListener onDownloadListener) {
        if (onDownloadListener != null) {
            return downLoadFile(this.mDownloadUrl, this.mDriPath, this.mFileName, onDownloadListener);
        }
        throw new NullPointerException("OnDownloadListener is a null");
    }

    public DownloadUtils setUrl(String str) {
        if (str == null) {
            throw new NullPointerException("url is a null");
        }
        this.mDownloadUrl = str;
        return mDownloadUtils;
    }
}
