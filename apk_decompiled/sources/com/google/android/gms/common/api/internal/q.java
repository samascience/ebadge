package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zaj;
import defpackage.xr3;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class q extends xr3 {
    private final WeakReference c;

    q(j jVar) {
        this.c = new WeakReference(jVar);
    }

    @Override // defpackage.es3
    public final void g(zaj zajVar) {
        j jVar = (j) this.c.get();
        if (jVar == null) {
            return;
        }
        jVar.a.k(new r(this, jVar, jVar, zajVar));
    }
}
