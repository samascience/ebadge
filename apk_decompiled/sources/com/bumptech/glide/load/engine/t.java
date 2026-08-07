package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import defpackage.ac0;
import defpackage.cd1;
import defpackage.fg0;
import defpackage.rk1;
import defpackage.w81;
import defpackage.y50;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class t implements e, e.a {
    private final f a;
    private final e.a b;
    private int c;
    private b d;
    private Object e;
    private volatile rk1.a f;
    private c g;

    class a implements y50.a {
        final /* synthetic */ rk1.a a;

        a(rk1.a aVar) {
            this.a = aVar;
        }

        @Override // y50.a
        public void c(Exception exc) {
            if (t.this.g(this.a)) {
                t.this.i(this.a, exc);
            }
        }

        @Override // y50.a
        public void f(Object obj) {
            if (t.this.g(this.a)) {
                t.this.h(this.a, obj);
            }
        }
    }

    t(f fVar, e.a aVar) {
        this.a = fVar;
        this.b = aVar;
    }

    private void e(Object obj) {
        long jB = cd1.b();
        try {
            fg0 fg0VarP = this.a.p(obj);
            d dVar = new d(fg0VarP, obj, this.a.k());
            this.g = new c(this.f.a, this.a.o());
            this.a.d().b(this.g, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.g + ", data: " + obj + ", encoder: " + fg0VarP + ", duration: " + cd1.a(jB));
            }
            this.f.c.b();
            this.d = new b(Collections.singletonList(this.f.a), this.a, this);
        } catch (Throwable th) {
            this.f.c.b();
            throw th;
        }
    }

    private boolean f() {
        return this.c < this.a.g().size();
    }

    private void j(rk1.a aVar) {
        this.f.c.e(this.a.l(), new a(aVar));
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        Object obj = this.e;
        if (obj != null) {
            this.e = null;
            e(obj);
        }
        b bVar = this.d;
        if (bVar != null && bVar.a()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean z = false;
        while (!z && f()) {
            List listG = this.a.g();
            int i = this.c;
            this.c = i + 1;
            this.f = (rk1.a) listG.get(i);
            if (this.f != null && (this.a.e().c(this.f.c.d()) || this.a.t(this.f.c.a()))) {
                j(this.f);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void b(w81 w81Var, Object obj, y50 y50Var, DataSource dataSource, w81 w81Var2) {
        this.b.b(w81Var, obj, y50Var, this.f.c.d(), w81Var);
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c(w81 w81Var, Exception exc, y50 y50Var, DataSource dataSource) {
        this.b.c(w81Var, exc, y50Var, this.f.c.d());
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        rk1.a aVar = this.f;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void d() {
        throw new UnsupportedOperationException();
    }

    boolean g(rk1.a aVar) {
        rk1.a aVar2 = this.f;
        return aVar2 != null && aVar2 == aVar;
    }

    void h(rk1.a aVar, Object obj) {
        ac0 ac0VarE = this.a.e();
        if (obj != null && ac0VarE.c(aVar.c.d())) {
            this.e = obj;
            this.b.d();
        } else {
            e.a aVar2 = this.b;
            w81 w81Var = aVar.a;
            y50 y50Var = aVar.c;
            aVar2.b(w81Var, obj, y50Var, y50Var.d(), this.g);
        }
    }

    void i(rk1.a aVar, Exception exc) {
        e.a aVar2 = this.b;
        c cVar = this.g;
        y50 y50Var = aVar.c;
        aVar2.c(cVar, exc, y50Var, y50Var.d());
    }
}
