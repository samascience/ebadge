package org.libjpegturbo.turbojpeg;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class TJException extends IOException {
    private static final long serialVersionUID = 1;
    private int errorCode;

    public TJException() {
        this.errorCode = 1;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public TJException(String str, Throwable th) {
        super(str, th);
        this.errorCode = 1;
    }

    public TJException(String str) {
        super(str);
        this.errorCode = 1;
    }

    public TJException(String str, int i) {
        super(str);
        this.errorCode = 1;
        this.errorCode = i;
    }

    public TJException(Throwable th) {
        super(th);
        this.errorCode = 1;
    }
}
