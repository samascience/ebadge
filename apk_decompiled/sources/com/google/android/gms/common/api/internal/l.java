package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a52;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class l implements com.google.android.gms.common.internal.b.c {
    private final WeakReference a;
    private final com.google.android.gms.common.api.a b;
    private final boolean c;

    public l(j jVar, com.google.android.gms.common.api.a aVar, boolean z) {
        this.a = new WeakReference(jVar);
        this.b = aVar;
        this.c = z;
    }

    @Override // com.google.android.gms.common.internal.b.c
    public final void a(ConnectionResult connectionResult) {
        j jVar = (j) this.a.get();
        if (jVar == null) {
            return;
        }
        a52.j(Looper.myLooper() == jVar.a.p.m(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        jVar.b.lock();
        try {
            if (jVar.w(0)) {
                if (!connectionResult.J0()) {
                    jVar.s(connectionResult, this.b, this.c);
                }
                if (jVar.l()) {
                    jVar.m();
                }
            }
        } finally {
            jVar.b.unlock();
        }
    }
}
