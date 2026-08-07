package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
final class m0 implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ c.C0080c b;

    m0(c.C0080c c0080c, ConnectionResult connectionResult) {
        this.b = c0080c;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.a.J0()) {
            ((c.a) c.this.i.get(this.b.b)).d(this.a);
            return;
        }
        c.C0080c.e(this.b, true);
        if (this.b.a.o()) {
            this.b.g();
            return;
        }
        try {
            this.b.a.g(null, Collections.emptySet());
        } catch (SecurityException unused) {
            ((c.a) c.this.i.get(this.b.b)).d(new ConnectionResult(10));
        }
    }
}
