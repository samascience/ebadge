package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import defpackage.mr3;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class u implements mr3 {
    private final d0 a;

    public u(d0 d0Var) {
        this.a = d0Var;
    }

    @Override // defpackage.mr3
    public final void a(int i) {
    }

    @Override // defpackage.mr3
    public final void b(Bundle bundle) {
    }

    @Override // defpackage.mr3
    public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a aVar, boolean z) {
    }

    @Override // defpackage.mr3
    public final void connect() {
        this.a.l();
    }

    @Override // defpackage.mr3
    public final b d(b bVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // defpackage.mr3
    public final boolean disconnect() {
        return true;
    }

    @Override // defpackage.mr3
    public final void e() {
        Iterator it = this.a.h.values().iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.a.f) it.next()).disconnect();
        }
        this.a.p.f243q = Collections.emptySet();
    }
}
