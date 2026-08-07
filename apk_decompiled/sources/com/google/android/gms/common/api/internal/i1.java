package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import defpackage.qs3;
import defpackage.tu1;
import defpackage.u03;
import defpackage.u9;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class i1 implements tu1 {
    private final /* synthetic */ g1 a;

    private i1(g1 g1Var) {
        this.a = g1Var;
    }

    @Override // defpackage.tu1
    public final void a(u03 u03Var) {
        this.a.h.lock();
        try {
            if (this.a.p) {
                if (u03Var.g()) {
                    g1 g1Var = this.a;
                    g1Var.f241q = new u9(g1Var.c.size());
                    Iterator it = this.a.c.values().iterator();
                    while (it.hasNext()) {
                        this.a.f241q.put(((f1) it.next()).k(), ConnectionResult.e);
                    }
                } else if (u03Var.b() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) u03Var.b();
                    if (this.a.n) {
                        g1 g1Var2 = this.a;
                        g1Var2.f241q = new u9(g1Var2.c.size());
                        for (f1 f1Var : this.a.c.values()) {
                            qs3 qs3VarK = f1Var.k();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult(f1Var);
                            if (this.a.l(f1Var, connectionResult)) {
                                this.a.f241q.put(qs3VarK, new ConnectionResult(16));
                            } else {
                                this.a.f241q.put(qs3VarK, connectionResult);
                            }
                        }
                    } else {
                        this.a.f241q = availabilityException.zaj();
                    }
                    g1 g1Var3 = this.a;
                    g1Var3.t = g1Var3.r();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", u03Var.b());
                    this.a.f241q = Collections.emptyMap();
                    this.a.t = new ConnectionResult(8);
                }
                if (this.a.r != null) {
                    this.a.f241q.putAll(this.a.r);
                    g1 g1Var4 = this.a;
                    g1Var4.t = g1Var4.r();
                }
                if (this.a.t == null) {
                    this.a.p();
                    this.a.q();
                } else {
                    g1.n(this.a, false);
                    this.a.g.a(this.a.t);
                }
                this.a.k.signalAll();
            }
        } finally {
            this.a.h.unlock();
        }
    }
}
