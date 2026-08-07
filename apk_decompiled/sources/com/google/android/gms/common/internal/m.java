package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
abstract class m extends q {
    public final int d;
    public final Bundle e;
    final /* synthetic */ b f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected m(b bVar, int i, Bundle bundle) {
        super(bVar, Boolean.TRUE);
        this.f = bVar;
        this.d = i;
        this.e = bundle;
    }

    @Override // com.google.android.gms.common.internal.q
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.d != 0) {
            this.f.b0(1, null);
            Bundle bundle = this.e;
            f(new ConnectionResult(this.d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (g()) {
                return;
            }
            this.f.b0(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.q
    protected final void b() {
    }

    protected abstract void f(ConnectionResult connectionResult);

    protected abstract boolean g();
}
