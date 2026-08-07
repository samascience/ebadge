package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.a52;
import defpackage.e43;
import defpackage.mr3;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class g implements mr3 {
    private final d0 a;
    private boolean b = false;

    public g(d0 d0Var) {
        this.a = d0Var;
    }

    @Override // defpackage.mr3
    public final void a(int i) {
        this.a.p(null);
        this.a.f240q.c(i, this.b);
    }

    @Override // defpackage.mr3
    public final void b(Bundle bundle) {
    }

    @Override // defpackage.mr3
    public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a aVar, boolean z) {
    }

    @Override // defpackage.mr3
    public final void connect() {
        if (this.b) {
            this.b = false;
            this.a.k(new i(this, this));
        }
    }

    @Override // defpackage.mr3
    public final b d(b bVar) {
        try {
            this.a.p.y.b(bVar);
            v vVar = this.a.p;
            com.google.android.gms.common.api.a.f fVar = (com.google.android.gms.common.api.a.f) vVar.p.get(bVar.s());
            a52.h(fVar, "Appropriate Api was not requested.");
            if (fVar.isConnected() || !this.a.i.containsKey(bVar.s())) {
                bVar.u(fVar);
            } else {
                bVar.w(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.a.k(new h(this, this));
        }
        return bVar;
    }

    @Override // defpackage.mr3
    public final boolean disconnect() {
        if (this.b) {
            return false;
        }
        if (!this.a.p.C()) {
            this.a.p(null);
            return true;
        }
        this.b = true;
        Iterator it = this.a.p.x.iterator();
        if (!it.hasNext()) {
            return false;
        }
        e43.a(it.next());
        throw null;
    }

    @Override // defpackage.mr3
    public final void e() {
    }
}
