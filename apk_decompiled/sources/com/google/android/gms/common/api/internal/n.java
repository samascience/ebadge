package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import defpackage.mr3;

/* JADX INFO: loaded from: classes.dex */
final class n extends e0 {
    private final /* synthetic */ ConnectionResult b;
    private final /* synthetic */ m c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n(m mVar, mr3 mr3Var, ConnectionResult connectionResult) {
        super(mr3Var);
        this.c = mVar;
        this.b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final void a() {
        this.c.c.A(this.b);
    }
}
