package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import defpackage.a52;
import defpackage.py0;
import defpackage.rt1;
import defpackage.rv3;
import defpackage.tv3;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class l extends rv3 {
    private final int c;

    protected l(byte[] bArr) {
        a52.a(bArr.length == 25);
        this.c = Arrays.hashCode(bArr);
    }

    protected static byte[] c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.tv3
    public final int G() {
        return this.c;
    }

    abstract byte[] d();

    public final boolean equals(Object obj) {
        py0 py0VarX;
        if (obj != null && (obj instanceof tv3)) {
            try {
                tv3 tv3Var = (tv3) obj;
                if (tv3Var.G() == this.c && (py0VarX = tv3Var.x()) != null) {
                    return Arrays.equals(d(), (byte[]) rt1.c(py0VarX));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c;
    }

    @Override // defpackage.tv3
    public final py0 x() {
        return rt1.d(d());
    }
}
