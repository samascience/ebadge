package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import defpackage.mr3;

/* JADX INFO: loaded from: classes.dex */
final class o extends e0 {
    private final /* synthetic */ com.google.android.gms.common.internal.b.c b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    o(m mVar, mr3 mr3Var, com.google.android.gms.common.internal.b.c cVar) {
        super(mr3Var);
        this.b = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final void a() {
        this.b.a(new ConnectionResult(16, null));
    }
}
