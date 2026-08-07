package com.jieli.jl_fatfs.tool;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ReadFileThread extends Thread {
    public static final String d = "ReadFileThread";
    public final String a;
    public final OnFatFsOpResultListener<byte[]> b;
    public final Handler c = new Handler(Looper.getMainLooper());

    public ReadFileThread(String str, OnFatFsOpResultListener<byte[]> onFatFsOpResultListener) {
        this.a = str;
        this.b = onFatFsOpResultListener;
    }

    public final /* synthetic */ void a(byte[] bArr) {
        OnFatFsOpResultListener<byte[]> onFatFsOpResultListener = this.b;
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(bArr);
        }
    }

    public final void b(final byte[] bArr) {
        this.c.post(new Runnable() { // from class: wc2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(bArr);
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.c.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileInputStream] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        IOException e;
        FileInputStream fileInputStream;
        FileNotFoundException e2;
        Log.d("ReadFileThread", "mUpgradeFilePath : " + this.a);
        File file = new File(this.a);
        FileInputStream fileInputStream2 = null;
        if (file.exists()) {
            ?? IsFile = file.isFile();
            try {
                try {
                    if (IsFile != 0) {
                        try {
                            fileInputStream = new FileInputStream(this.a);
                            try {
                                byte[] bArr = new byte[fileInputStream.available()];
                                int i = fileInputStream.read(bArr);
                                if (i > 0) {
                                    byte[] bArr2 = new byte[i];
                                    System.arraycopy(bArr, 0, bArr2, 0, i);
                                    b(bArr2);
                                }
                                fileInputStream.close();
                            } catch (FileNotFoundException e3) {
                                e2 = e3;
                                try {
                                    e2.printStackTrace();
                                    Log.w(d, "file not found");
                                    b(null);
                                    if (fileInputStream == null) {
                                        return;
                                    } else {
                                        fileInputStream.close();
                                    }
                                } catch (Throwable th) {
                                    fileInputStream2 = fileInputStream;
                                    th = th;
                                    th = th;
                                    IsFile = fileInputStream2;
                                    if (IsFile != 0) {
                                        try {
                                            IsFile.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                e.printStackTrace();
                                Log.w(d, "error : " + e.getMessage());
                                b(null);
                                if (fileInputStream == null) {
                                    return;
                                } else {
                                    fileInputStream.close();
                                }
                            }
                        } catch (FileNotFoundException e6) {
                            e2 = e6;
                            fileInputStream = null;
                        } catch (IOException e7) {
                            e = e7;
                            fileInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            IsFile = fileInputStream2;
                            if (IsFile != 0) {
                                IsFile.close();
                            }
                            throw th;
                        }
                        return;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        Log.w(d, "file path not exist.");
        b(null);
    }
}
