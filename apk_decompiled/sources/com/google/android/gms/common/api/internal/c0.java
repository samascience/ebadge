package com.google.android.gms.common.api.internal;

import defpackage.pr3;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class c0 extends pr3 {
    private WeakReference a;

    c0(v vVar) {
        this.a = new WeakReference(vVar);
    }

    @Override // defpackage.pr3
    public final void a() {
        v vVar = (v) this.a.get();
        if (vVar == null) {
            return;
        }
        vVar.u();
    }
}
