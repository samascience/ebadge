package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class u extends m {
    final /* synthetic */ b g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(b bVar, int i, Bundle bundle) {
        super(bVar, i, null);
        this.g = bVar;
    }

    @Override // com.google.android.gms.common.internal.m
    protected final void f(ConnectionResult connectionResult) {
        if (this.g.s() && b.a0(this.g)) {
            b.W(this.g, 16);
        } else {
            this.g.p.a(connectionResult);
            this.g.G(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.m
    protected final boolean g() {
        this.g.p.a(ConnectionResult.e);
        return true;
    }
}
