package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import defpackage.a52;

/* JADX INFO: loaded from: classes.dex */
final class x0 {
    private final int a;
    private final ConnectionResult b;

    x0(ConnectionResult connectionResult, int i) {
        a52.g(connectionResult);
        this.b = connectionResult;
        this.a = i;
    }

    final ConnectionResult a() {
        return this.b;
    }

    final int b() {
        return this.a;
    }
}
