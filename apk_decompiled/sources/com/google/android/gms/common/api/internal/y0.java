package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
final class y0 implements Runnable {
    private final x0 a;
    final /* synthetic */ w0 b;

    y0(w0 w0Var, x0 x0Var) {
        this.b = w0Var;
        this.a = x0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.b) {
            ConnectionResult connectionResultA = this.a.a();
            if (connectionResultA.I0()) {
                w0 w0Var = this.b;
                w0Var.a.startActivityForResult(GoogleApiActivity.b(w0Var.b(), connectionResultA.H0(), this.a.b(), false), 1);
            } else if (this.b.e.k(connectionResultA.F0())) {
                w0 w0Var2 = this.b;
                w0Var2.e.w(w0Var2.b(), this.b.a, connectionResultA.F0(), 2, this.b);
            } else {
                if (connectionResultA.F0() != 18) {
                    this.b.l(connectionResultA, this.a.b());
                    return;
                }
                Dialog dialogQ = com.google.android.gms.common.a.q(this.b.b(), this.b);
                w0 w0Var3 = this.b;
                w0Var3.e.s(w0Var3.b().getApplicationContext(), new z0(this, dialogQ));
            }
        }
    }
}
