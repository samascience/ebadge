package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import defpackage.ky;
import defpackage.ys3;
import defpackage.zr3;

/* JADX INFO: loaded from: classes.dex */
public final class f1 extends com.google.android.gms.common.api.b {
    private final com.google.android.gms.common.api.a.f j;
    private final ys3 k;
    private final ky l;
    private final com.google.android.gms.common.api.a.AbstractC0075a m;

    public f1(Context context, com.google.android.gms.common.api.a aVar, Looper looper, com.google.android.gms.common.api.a.f fVar, ys3 ys3Var, ky kyVar, com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a) {
        super(context, aVar, looper);
        this.j = fVar;
        this.k = ys3Var;
        this.l = kyVar;
        this.m = abstractC0075a;
        this.i.g(this);
    }

    @Override // com.google.android.gms.common.api.b
    public final com.google.android.gms.common.api.a.f h(Looper looper, c.a aVar) {
        this.k.e(aVar);
        return this.j;
    }

    @Override // com.google.android.gms.common.api.b
    public final zr3 j(Context context, Handler handler) {
        return new zr3(context, handler, this.l, this.m);
    }

    public final com.google.android.gms.common.api.a.f l() {
        return this.j;
    }
}
