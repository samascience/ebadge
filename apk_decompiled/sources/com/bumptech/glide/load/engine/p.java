package com.bumptech.glide.load.engine;

import defpackage.ak0;
import defpackage.h42;
import defpackage.qg2;
import defpackage.tt2;
import defpackage.z42;

/* JADX INFO: loaded from: classes.dex */
final class p implements qg2, ak0.f {
    private static final h42 e = ak0.d(20, new a());
    private final tt2 a = tt2.a();
    private qg2 b;
    private boolean c;
    private boolean d;

    class a implements ak0.d {
        a() {
        }

        @Override // ak0.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p create() {
            return new p();
        }
    }

    p() {
    }

    private void b(qg2 qg2Var) {
        this.d = false;
        this.c = true;
        this.b = qg2Var;
    }

    static p c(qg2 qg2Var) {
        p pVar = (p) z42.d((p) e.b());
        pVar.b(qg2Var);
        return pVar;
    }

    private void d() {
        this.b = null;
        e.a(this);
    }

    @Override // defpackage.qg2
    public synchronized void a() {
        this.a.c();
        this.d = true;
        if (!this.c) {
            this.b.a();
            d();
        }
    }

    @Override // ak0.f
    public tt2 e() {
        return this.a;
    }

    synchronized void f() {
        this.a.c();
        if (!this.c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.c = false;
        if (this.d) {
            a();
        }
    }

    @Override // defpackage.qg2
    public Object get() {
        return this.b.get();
    }

    @Override // defpackage.qg2
    public int o() {
        return this.b.o();
    }

    @Override // defpackage.qg2
    public Class p() {
        return this.b.p();
    }
}
