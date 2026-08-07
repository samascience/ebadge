package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.au2;

/* JADX INFO: loaded from: classes.dex */
final class y implements com.google.android.gms.common.api.c.InterfaceC0078c {
    private final /* synthetic */ au2 c;

    y(v vVar, au2 au2Var) {
        this.c = au2Var;
    }

    @Override // com.google.android.gms.common.api.c.InterfaceC0078c
    public final void d(ConnectionResult connectionResult) {
        this.c.j(new Status(8));
    }
}
