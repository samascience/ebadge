package com.bumptech.glide.load.engine;

import defpackage.qg2;
import defpackage.w81;
import defpackage.z42;

/* JADX INFO: loaded from: classes.dex */
class m implements qg2 {
    private final boolean a;
    private final boolean b;
    private final qg2 c;
    private final a d;
    private final w81 e;
    private int f;
    private boolean g;

    interface a {
        void b(w81 w81Var, m mVar);
    }

    m(qg2 qg2Var, boolean z, boolean z2, w81 w81Var, a aVar) {
        this.c = (qg2) z42.d(qg2Var);
        this.a = z;
        this.b = z2;
        this.e = w81Var;
        this.d = (a) z42.d(aVar);
    }

    @Override // defpackage.qg2
    public synchronized void a() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.g = true;
        if (this.b) {
            this.c.a();
        }
    }

    synchronized void b() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f++;
    }

    qg2 c() {
        return this.c;
    }

    boolean d() {
        return this.a;
    }

    void e() {
        boolean z;
        synchronized (this) {
            int i = this.f;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.d.b(this.e, this);
        }
    }

    @Override // defpackage.qg2
    public Object get() {
        return this.c.get();
    }

    @Override // defpackage.qg2
    public int o() {
        return this.c.o();
    }

    @Override // defpackage.qg2
    public Class p() {
        return this.c.p();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + '}';
    }
}
