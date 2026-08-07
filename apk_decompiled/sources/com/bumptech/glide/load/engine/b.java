package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import defpackage.rk1;
import defpackage.w81;
import defpackage.y50;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b implements e, y50.a {
    private final List a;
    private final f b;
    private final e.a c;
    private int d;
    private w81 e;
    private List f;
    private int g;
    private volatile rk1.a h;
    private File i;

    b(f fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    private boolean b() {
        return this.g < this.f.size();
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f != null && b()) {
                this.h = null;
                while (!z && b()) {
                    List list = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = ((rk1) list.get(i)).b(this.i, this.b.s(), this.b.f(), this.b.k());
                    if (this.h != null && this.b.t(this.h.c.a())) {
                        this.h.c.e(this.b.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= this.a.size()) {
                return false;
            }
            w81 w81Var = (w81) this.a.get(this.d);
            File fileA = this.b.d().a(new c(w81Var, this.b.o()));
            this.i = fileA;
            if (fileA != null) {
                this.e = w81Var;
                this.f = this.b.j(fileA);
                this.g = 0;
            }
        }
    }

    @Override // y50.a
    public void c(Exception exc) {
        this.c.c(this.e, exc, this.h.c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        rk1.a aVar = this.h;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // y50.a
    public void f(Object obj) {
        this.c.b(this.e, obj, this.h.c, DataSource.DATA_DISK_CACHE, this.e);
    }

    b(List list, f fVar, e.a aVar) {
        this.d = -1;
        this.a = list;
        this.b = fVar;
        this.c = aVar;
    }
}
