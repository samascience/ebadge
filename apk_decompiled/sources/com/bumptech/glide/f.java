package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import defpackage.ac0;
import defpackage.au0;
import defpackage.bb1;
import defpackage.ef2;
import defpackage.j03;
import defpackage.jf2;
import defpackage.na3;
import defpackage.of2;
import defpackage.pf2;
import defpackage.r03;
import defpackage.va1;
import defpackage.y10;
import defpackage.z10;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f implements ComponentCallbacks2, bb1 {
    private static final of2 l = (of2) of2.k0(Bitmap.class).N();
    private static final of2 m = (of2) of2.k0(au0.class).N();
    private static final of2 n = (of2) ((of2) of2.l0(ac0.c).W(Priority.LOW)).d0(true);
    protected final com.bumptech.glide.a a;
    protected final Context b;
    final va1 c;
    private final pf2 d;
    private final jf2 e;
    private final r03 f;
    private final Runnable g;
    private final y10 h;
    private final CopyOnWriteArrayList i;
    private of2 j;
    private boolean k;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.c.b(fVar);
        }
    }

    private class b implements y10.a {
        private final pf2 a;

        b(pf2 pf2Var) {
            this.a = pf2Var;
        }

        @Override // y10.a
        public void a(boolean z) {
            if (z) {
                synchronized (f.this) {
                    this.a.e();
                }
            }
        }
    }

    public f(com.bumptech.glide.a aVar, va1 va1Var, jf2 jf2Var, Context context) {
        this(aVar, va1Var, jf2Var, new pf2(), aVar.g(), context);
    }

    private void z(j03 j03Var) {
        boolean zY = y(j03Var);
        ef2 ef2VarG = j03Var.g();
        if (zY || this.a.p(j03Var) || ef2VarG == null) {
            return;
        }
        j03Var.c(null);
        ef2VarG.clear();
    }

    public e i(Class cls) {
        return new e(this.a, this, cls, this.b);
    }

    public e j() {
        return i(Bitmap.class).a(l);
    }

    public e k() {
        return i(Drawable.class);
    }

    public e l() {
        return i(au0.class).a(m);
    }

    public void m(j03 j03Var) {
        if (j03Var == null) {
            return;
        }
        z(j03Var);
    }

    List n() {
        return this.i;
    }

    synchronized of2 o() {
        return this.j;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // defpackage.bb1
    public synchronized void onDestroy() {
        try {
            this.f.onDestroy();
            Iterator it = this.f.j().iterator();
            while (it.hasNext()) {
                m((j03) it.next());
            }
            this.f.i();
            this.d.b();
            this.c.a(this);
            this.c.a(this.h);
            na3.u(this.g);
            this.a.s(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // defpackage.bb1
    public synchronized void onStart() {
        v();
        this.f.onStart();
    }

    @Override // defpackage.bb1
    public synchronized void onStop() {
        u();
        this.f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.k) {
            t();
        }
    }

    g p(Class cls) {
        return this.a.i().e(cls);
    }

    public e q(Uri uri) {
        return k().x0(uri);
    }

    public e r(String str) {
        return k().z0(str);
    }

    public synchronized void s() {
        this.d.c();
    }

    public synchronized void t() {
        s();
        Iterator it = this.e.a().iterator();
        while (it.hasNext()) {
            ((f) it.next()).s();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.d + ", treeNode=" + this.e + "}";
    }

    public synchronized void u() {
        this.d.d();
    }

    public synchronized void v() {
        this.d.f();
    }

    protected synchronized void w(of2 of2Var) {
        this.j = (of2) ((of2) of2Var.clone()).b();
    }

    synchronized void x(j03 j03Var, ef2 ef2Var) {
        this.f.k(j03Var);
        this.d.g(ef2Var);
    }

    synchronized boolean y(j03 j03Var) {
        ef2 ef2VarG = j03Var.g();
        if (ef2VarG == null) {
            return true;
        }
        if (!this.d.a(ef2VarG)) {
            return false;
        }
        this.f.l(j03Var);
        j03Var.c(null);
        return true;
    }

    f(com.bumptech.glide.a aVar, va1 va1Var, jf2 jf2Var, pf2 pf2Var, z10 z10Var, Context context) {
        this.f = new r03();
        a aVar2 = new a();
        this.g = aVar2;
        this.a = aVar;
        this.c = va1Var;
        this.e = jf2Var;
        this.d = pf2Var;
        this.b = context;
        y10 y10VarA = z10Var.a(context.getApplicationContext(), new b(pf2Var));
        this.h = y10VarA;
        if (na3.p()) {
            na3.t(aVar2);
        } else {
            va1Var.b(this);
        }
        va1Var.b(y10VarA);
        this.i = new CopyOnWriteArrayList(aVar.i().c());
        w(aVar.i().d());
        aVar.o(this);
    }
}
