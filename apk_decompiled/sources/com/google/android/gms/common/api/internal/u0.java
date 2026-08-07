package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import defpackage.e43;
import defpackage.v03;
import defpackage.vb1;

/* JADX INFO: loaded from: classes.dex */
public final class u0 extends s0 {
    public u0(vb1 vb1Var, v03 v03Var) {
        super(4, v03Var);
    }

    @Override // com.google.android.gms.common.api.internal.s0, com.google.android.gms.common.api.internal.z
    public final /* bridge */ /* synthetic */ void b(Status status) {
        super.b(status);
    }

    @Override // com.google.android.gms.common.api.internal.z
    public final /* bridge */ /* synthetic */ void d(e eVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.s0, com.google.android.gms.common.api.internal.z
    public final /* bridge */ /* synthetic */ void e(RuntimeException runtimeException) {
        super.e(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.n0
    public final Feature[] g(c.a aVar) {
        e43.a(aVar.x().get(null));
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.n0
    public final boolean h(c.a aVar) {
        e43.a(aVar.x().get(null));
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void i(c.a aVar) {
        e43.a(aVar.x().remove(null));
        this.b.e(Boolean.FALSE);
    }
}
