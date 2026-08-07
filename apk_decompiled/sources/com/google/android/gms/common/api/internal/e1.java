package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import defpackage.rr3;

/* JADX INFO: loaded from: classes.dex */
final class e1 implements rr3 {
    private final /* synthetic */ b1 a;

    private e1(b1 b1Var) {
        this.a = b1Var;
    }

    @Override // defpackage.rr3
    public final void a(ConnectionResult connectionResult) {
        this.a.o.lock();
        try {
            this.a.m = connectionResult;
            this.a.y();
        } finally {
            this.a.o.unlock();
        }
    }

    @Override // defpackage.rr3
    public final void b(Bundle bundle) {
        this.a.o.lock();
        try {
            this.a.m = ConnectionResult.e;
            this.a.y();
        } finally {
            this.a.o.unlock();
        }
    }

    @Override // defpackage.rr3
    public final void c(int i, boolean z) {
        this.a.o.lock();
        try {
            if (this.a.n) {
                this.a.n = false;
                this.a.j(i, z);
            } else {
                this.a.n = true;
                this.a.f.a(i);
            }
        } finally {
            this.a.o.unlock();
        }
    }

    /* synthetic */ e1(b1 b1Var, c1 c1Var) {
        this(b1Var);
    }
}
