package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import defpackage.rk1;
import defpackage.w81;
import defpackage.y50;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class q implements e, y50.a {
    private final e.a a;
    private final f b;
    private int c;
    private int d = -1;
    private w81 e;
    private List f;
    private int g;
    private volatile rk1.a h;
    private File i;
    private r j;

    q(f fVar, e.a aVar) {
        this.b = fVar;
        this.a = aVar;
    }

    private boolean b() {
        return this.g < this.f.size();
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        List listC = this.b.c();
        boolean z = false;
        if (listC.isEmpty()) {
            return false;
        }
        List listM = this.b.m();
        if (listM.isEmpty()) {
            if (File.class.equals(this.b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.b.i() + " to " + this.b.q());
        }
        while (true) {
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
            if (i2 >= listM.size()) {
                int i3 = this.c + 1;
                this.c = i3;
                if (i3 >= listC.size()) {
                    return false;
                }
                this.d = 0;
            }
            w81 w81Var = (w81) listC.get(this.c);
            Class cls = (Class) listM.get(this.d);
            this.j = new r(this.b.b(), w81Var, this.b.o(), this.b.s(), this.b.f(), this.b.r(cls), cls, this.b.k());
            File fileA = this.b.d().a(this.j);
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
        this.a.c(this.j, exc, this.h.c, DataSource.RESOURCE_DISK_CACHE);
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
        this.a.b(this.e, obj, this.h.c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }
}
