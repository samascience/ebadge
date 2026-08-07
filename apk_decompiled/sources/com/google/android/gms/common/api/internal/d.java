package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import defpackage.qs3;
import defpackage.tu1;
import defpackage.u03;
import defpackage.u9;
import defpackage.wo2;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class d implements tu1 {
    private wo2 a;
    private final /* synthetic */ g1 b;

    d(g1 g1Var, wo2 wo2Var) {
        this.b = g1Var;
        this.a = wo2Var;
    }

    @Override // defpackage.tu1
    public final void a(u03 u03Var) {
        this.b.h.lock();
        try {
            if (!this.b.p) {
                this.a.onComplete();
                this.b.h.unlock();
                return;
            }
            if (u03Var.g()) {
                g1 g1Var = this.b;
                g1Var.r = new u9(g1Var.d.size());
                Iterator it = this.b.d.values().iterator();
                while (it.hasNext()) {
                    this.b.r.put(((f1) it.next()).k(), ConnectionResult.e);
                }
            } else if (u03Var.b() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) u03Var.b();
                if (this.b.n) {
                    g1 g1Var2 = this.b;
                    g1Var2.r = new u9(g1Var2.d.size());
                    for (f1 f1Var : this.b.d.values()) {
                        qs3 qs3VarK = f1Var.k();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(f1Var);
                        if (this.b.l(f1Var, connectionResult)) {
                            this.b.r.put(qs3VarK, new ConnectionResult(16));
                        } else {
                            this.b.r.put(qs3VarK, connectionResult);
                        }
                    }
                } else {
                    this.b.r = availabilityException.zaj();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", u03Var.b());
                this.b.r = Collections.emptyMap();
            }
            if (this.b.isConnected()) {
                this.b.f241q.putAll(this.b.r);
                if (this.b.r() == null) {
                    this.b.p();
                    this.b.q();
                    this.b.k.signalAll();
                }
            }
            this.a.onComplete();
            this.b.h.unlock();
        } catch (Throwable th) {
            this.b.h.unlock();
            throw th;
        }
    }

    final void b() {
        this.a.onComplete();
    }
}
