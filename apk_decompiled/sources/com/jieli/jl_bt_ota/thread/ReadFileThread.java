package com.jieli.jl_bt_ota.thread;

import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.util.FileUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ReadFileThread extends Thread {
    private final String a;
    private final IActionCallback<byte[]> b;
    private final Handler c = new Handler(Looper.getMainLooper());

    public ReadFileThread(String str, IActionCallback<byte[]> iActionCallback) {
        this.a = str;
        this.b = iActionCallback;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.c.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        ?? r1;
        Throwable th;
        FileInputStream fileInputStream;
        FileNotFoundException e;
        Object obj;
        JL_Log.d("ReadFileThread", "file path : " + this.a);
        if (!FileUtil.checkFileExist(this.a)) {
            b(OTAError.buildError(4097, "File path does not exist."));
            return;
        }
        Object obj2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream3 = new FileInputStream(this.a);
                    try {
                        byte[] bArr = new byte[fileInputStream3.available()];
                        int i = fileInputStream3.read(bArr);
                        if (i >= 0) {
                            byte[] bArr2 = new byte[i];
                            System.arraycopy(bArr, 0, bArr2, 0, i);
                            b(bArr2);
                            obj = bArr;
                        } else {
                            BaseError baseErrorBuildError = OTAError.buildError(ErrorCode.SUB_ERR_DATA_NOT_FOUND);
                            b(baseErrorBuildError);
                            obj = baseErrorBuildError;
                        }
                        fileInputStream3.close();
                        obj2 = obj;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream = fileInputStream3;
                        try {
                            e.printStackTrace();
                            b(OTAError.buildError(ErrorCode.SUB_ERR_FILE_NOT_FOUND));
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (Throwable th2) {
                            FileInputStream fileInputStream4 = fileInputStream;
                            th = th2;
                            obj2 = fileInputStream4;
                            Throwable th3 = th;
                            r1 = obj2;
                            th = th3;
                            if (r1 == 0) {
                                throw th;
                            }
                            try {
                                r1.close();
                                throw th;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        fileInputStream2 = fileInputStream3;
                        e.printStackTrace();
                        b(OTAError.buildError(ErrorCode.SUB_ERR_IO_EXCEPTION, e.getMessage()));
                        obj2 = fileInputStream2;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                            obj2 = fileInputStream2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r1 = fileInputStream3;
                        if (r1 == 0) {
                            throw th;
                        }
                        r1.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    Throwable th6 = th;
                    r1 = obj2;
                    th = th6;
                    if (r1 == 0) {
                        throw th;
                    }
                    r1.close();
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                fileInputStream = null;
                e = e5;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            obj2 = e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(byte[] bArr) {
        IActionCallback<byte[]> iActionCallback = this.b;
        if (iActionCallback != null) {
            iActionCallback.onSuccess(bArr);
        }
    }

    private void b(final byte[] bArr) {
        this.c.post(new Runnable() { // from class: yc2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(bArr);
            }
        });
    }

    private void b(final BaseError baseError) {
        if (baseError == null) {
            return;
        }
        this.c.post(new Runnable() { // from class: xc2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(baseError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseError baseError) {
        IActionCallback<byte[]> iActionCallback = this.b;
        if (iActionCallback != null) {
            iActionCallback.onError(baseError);
        }
    }
}
