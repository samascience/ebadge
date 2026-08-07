package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class p0 implements r0 {
    private final /* synthetic */ o0 a;

    p0(o0 o0Var) {
        this.a = o0Var;
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void a(BasePendingResult basePendingResult) {
        this.a.a.remove(basePendingResult);
    }
}
