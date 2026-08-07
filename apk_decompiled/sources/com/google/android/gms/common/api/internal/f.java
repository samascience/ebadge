package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import defpackage.tz1;

/* JADX INFO: loaded from: classes.dex */
final class f implements tz1.a {
    private final /* synthetic */ BasePendingResult a;
    private final /* synthetic */ e b;

    f(e eVar, BasePendingResult basePendingResult) {
        this.b = eVar;
        this.a = basePendingResult;
    }

    @Override // tz1.a
    public final void a(Status status) {
        this.b.a.remove(this.a);
    }
}
