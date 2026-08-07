package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class n extends l {
    private static final WeakReference e = new WeakReference(null);
    private WeakReference d;

    n(byte[] bArr) {
        super(bArr);
        this.d = e;
    }

    protected abstract byte[] H();

    @Override // com.google.android.gms.common.l
    final byte[] d() {
        byte[] bArrH;
        synchronized (this) {
            try {
                bArrH = (byte[]) this.d.get();
                if (bArrH == null) {
                    bArrH = H();
                    this.d = new WeakReference(bArrH);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrH;
    }
}
