package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class j0 implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ c.a b;

    j0(c.a aVar, ConnectionResult connectionResult) {
        this.b = aVar;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d(this.a);
    }
}
