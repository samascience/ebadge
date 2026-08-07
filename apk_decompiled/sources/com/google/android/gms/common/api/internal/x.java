package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import defpackage.au2;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class x implements com.google.android.gms.common.api.c.b {
    private final /* synthetic */ AtomicReference c;
    private final /* synthetic */ au2 d;
    private final /* synthetic */ v e;

    x(v vVar, AtomicReference atomicReference, au2 au2Var) {
        this.e = vVar;
        this.c = atomicReference;
        this.d = au2Var;
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void a(int i) {
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void b(Bundle bundle) {
        this.e.w((com.google.android.gms.common.api.c) this.c.get(), this.d, true);
    }
}
