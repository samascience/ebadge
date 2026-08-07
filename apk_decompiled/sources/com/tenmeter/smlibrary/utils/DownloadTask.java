package com.tenmeter.smlibrary.utils;

import android.os.AsyncTask;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.listener.IDownloadLister;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
    private DownloadThread[] downloadThreads;
    private String downloadUrl;
    private IDownloadLister listener;
    private String savePath;
    private int threadNum;
    private boolean isCanceled = false;
    private boolean isPaused = false;
    private long downloadedSize = 0;
    private float old = 0.0f;
    private long fileTotalSize = 0;
    private Object object = new Object();

    private class DownloadThread extends Thread {
        private int endPos;
        private boolean isFinished = false;
        private int startPos;
        private int threadId;

        public DownloadThread(int i, int i2, int i3) {
            this.threadId = i;
            this.startPos = i2;
            this.endPos = i3;
        }

        /* JADX WARN: Code duplicated, block: B:55:0x0161 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:56:0x0163 A[Catch: IOException -> 0x015f, TryCatch #6 {IOException -> 0x015f, blocks: (B:52:0x015b, B:56:0x0163, B:58:0x0168), top: B:66:0x015b }] */
        /* JADX WARN: Code duplicated, block: B:58:0x0168 A[Catch: IOException -> 0x015f, TRY_LEAVE, TryCatch #6 {IOException -> 0x015f, blocks: (B:52:0x015b, B:56:0x0163, B:58:0x0168), top: B:66:0x015b }] */
        /* JADX WARN: Code duplicated, block: B:66:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            InputStream inputStream;
            RandomAccessFile randomAccessFile;
            Throwable th;
            HttpURLConnection httpURLConnection;
            Exception e;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(DownloadTask.this.downloadUrl).openConnection();
                    try {
                        httpURLConnection.setRequestMethod(Constants.HTTP_GET);
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setRequestProperty("Range", "bytes=" + this.startPos + "-" + this.endPos);
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            randomAccessFile = new RandomAccessFile(new File(DownloadTask.this.savePath), "rwd");
                            try {
                                try {
                                    randomAccessFile.seek(this.startPos);
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int i = inputStream.read(bArr);
                                        if (i == -1 || DownloadTask.this.isCanceled) {
                                            break;
                                            break;
                                        }
                                        randomAccessFile.write(bArr, 0, i);
                                        if (DownloadTask.this.old == 0.0f) {
                                            DownloadTask downloadTask = DownloadTask.this;
                                            downloadTask.old = ((downloadTask.downloadedSize * 100) * 1.0f) / DownloadTask.this.fileTotalSize;
                                        }
                                        DownloadTask.this.downloadedSize += (long) i;
                                        if ((((DownloadTask.this.downloadedSize * 100) * 1.0f) / DownloadTask.this.fileTotalSize) - DownloadTask.this.old >= 0.5d) {
                                            DownloadTask downloadTask2 = DownloadTask.this;
                                            downloadTask2.old = ((downloadTask2.downloadedSize * 100) * 1.0f) / DownloadTask.this.fileTotalSize;
                                            DownloadTask downloadTask3 = DownloadTask.this;
                                            downloadTask3.publishProgress(Integer.valueOf((int) (((downloadTask3.downloadedSize * 100) * 1.0f) / DownloadTask.this.fileTotalSize)));
                                        }
                                    }
                                    if (!DownloadTask.this.isCanceled && !DownloadTask.this.isPaused) {
                                        this.isFinished = true;
                                    }
                                    httpURLConnection.disconnect();
                                    inputStream.close();
                                    randomAccessFile.close();
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    DownloadTask.this.listener.onError(e.getMessage());
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (randomAccessFile != null) {
                                        randomAccessFile.close();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                } else {
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (randomAccessFile != null) {
                                        randomAccessFile.close();
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e4) {
                            randomAccessFile = null;
                            e = e4;
                        } catch (Throwable th3) {
                            randomAccessFile = null;
                            th = th3;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                            } else {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        randomAccessFile = null;
                        e = e5;
                        inputStream = null;
                    } catch (Throwable th4) {
                        randomAccessFile = null;
                        th = th4;
                        inputStream = null;
                    }
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            } catch (Exception e7) {
                inputStream = null;
                randomAccessFile = null;
                e = e7;
                httpURLConnection = null;
            } catch (Throwable th5) {
                inputStream = null;
                randomAccessFile = null;
                th = th5;
                httpURLConnection = null;
            }
        }
    }

    public DownloadTask(String str, String str2, int i, IDownloadLister iDownloadLister) {
        this.downloadUrl = str;
        this.savePath = str2;
        this.threadNum = i;
        this.downloadThreads = new DownloadThread[i];
        this.listener = iDownloadLister;
    }

    public void cancelDownload() {
        this.isCanceled = true;
    }

    public long getDownloadedSize() {
        return this.downloadedSize;
    }

    public void pauseDownload() {
        this.isPaused = true;
    }

    public void resumeDownload() {
        this.isPaused = false;
        synchronized (this) {
            notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd A[Catch: IOException -> 0x00c9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00c9, blocks: (B:68:0x00c5, B:72:0x00cd), top: B:87:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00e2 A[Catch: IOException -> 0x00de, TRY_LEAVE, TryCatch #10 {IOException -> 0x00de, blocks: (B:79:0x00da, B:83:0x00e2), top: B:97:0x00da }] */
    /* JADX WARN: Code duplicated, block: B:97:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void... voidArr) throws Throwable {
        RandomAccessFile randomAccessFile;
        boolean z;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.downloadUrl).openConnection();
            try {
                httpURLConnection2.setRequestMethod(Constants.HTTP_GET);
                httpURLConnection2.setConnectTimeout(5000);
                int contentLength = httpURLConnection2.getContentLength();
                if (contentLength <= 0) {
                    Boolean bool = Boolean.FALSE;
                    try {
                        httpURLConnection2.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return bool;
                }
                long j = contentLength;
                this.fileTotalSize = j;
                randomAccessFile = new RandomAccessFile(new File(this.savePath), "rwd");
                try {
                    randomAccessFile.setLength(j);
                    int i = contentLength / this.threadNum;
                    boolean z2 = false;
                    int i2 = 0;
                    while (true) {
                        int i3 = this.threadNum;
                        if (i2 >= i3) {
                            break;
                        }
                        int i4 = i2 * i;
                        int i5 = i2 + 1;
                        int i6 = (i5 * i) - 1;
                        if (i2 == i3 - 1) {
                            i6 = contentLength - 1;
                        }
                        this.downloadThreads[i2] = new DownloadThread(i2, i4, i6);
                        this.downloadThreads[i2].start();
                        i2 = i5;
                    }
                    boolean z3 = false;
                    while (true) {
                        if (!z3) {
                            synchronized (this.object) {
                                try {
                                    if (!this.isPaused && !this.isCanceled) {
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= this.threadNum) {
                                                z = true;
                                                break;
                                            }
                                            if (!this.downloadThreads[i7].isFinished) {
                                                z = false;
                                                break;
                                            }
                                            i7++;
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            break;
                        }
                        z2 = z3;
                        break;
                        z3 = z;
                    }
                    Boolean boolValueOf = Boolean.valueOf(z2);
                    try {
                        httpURLConnection2.disconnect();
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return boolValueOf;
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = httpURLConnection2;
                    try {
                        this.listener.onError(e.getMessage());
                        e.printStackTrace();
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return Boolean.FALSE;
                            }
                        } else if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return Boolean.FALSE;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                throw th;
                            }
                        } else if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                    } else if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
            }
        } catch (Exception e7) {
            e = e7;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            this.listener.onFinish(this.savePath);
        } else {
            this.listener.onError("Error");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
        this.listener.onProgress(this.fileTotalSize, numArr[0].intValue());
        KLog.a("onProgressUpdate===" + this.fileTotalSize + "--------onProgressUpdate====" + this.downloadedSize);
    }
}
