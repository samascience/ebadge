package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import defpackage.ac0;
import defpackage.fg0;
import defpackage.q83;
import defpackage.qg2;
import defpackage.rk1;
import defpackage.rx1;
import defpackage.v9;
import defpackage.w81;
import defpackage.xg2;
import defpackage.yb0;
import defpackage.z43;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class f {
    private final List a = new ArrayList();
    private final List b = new ArrayList();
    private com.bumptech.glide.c c;
    private Object d;
    private int e;
    private int f;
    private Class g;
    private DecodeJob.e h;
    private rx1 i;
    private Map j;
    private Class k;
    private boolean l;
    private boolean m;
    private w81 n;
    private Priority o;
    private ac0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f225q;
    private boolean r;

    f() {
    }

    void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    v9 b() {
        return this.c.b();
    }

    List c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List listG = g();
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                rk1.a aVar = (rk1.a) listG.get(i);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add(aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }

    yb0 d() {
        return this.h.a();
    }

    ac0 e() {
        return this.p;
    }

    int f() {
        return this.f;
    }

    List g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List listI = this.c.i().i(this.d);
            int size = listI.size();
            for (int i = 0; i < size; i++) {
                rk1.a aVarB = ((rk1) listI.get(i)).b(this.d, this.e, this.f, this.i);
                if (aVarB != null) {
                    this.a.add(aVarB);
                }
            }
        }
        return this.a;
    }

    o h(Class cls) {
        return this.c.i().h(cls, this.g, this.k);
    }

    Class i() {
        return this.d.getClass();
    }

    List j(File file) {
        return this.c.i().i(file);
    }

    rx1 k() {
        return this.i;
    }

    Priority l() {
        return this.o;
    }

    List m() {
        return this.c.i().j(this.d.getClass(), this.g, this.k);
    }

    xg2 n(qg2 qg2Var) {
        return this.c.i().k(qg2Var);
    }

    w81 o() {
        return this.n;
    }

    fg0 p(Object obj) {
        return this.c.i().m(obj);
    }

    Class q() {
        return this.k;
    }

    z43 r(Class cls) {
        z43 z43Var = (z43) this.j.get(cls);
        if (z43Var == null) {
            for (Map.Entry entry : this.j.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    z43Var = (z43) entry.getValue();
                    break;
                }
            }
        }
        if (z43Var != null) {
            return z43Var;
        }
        if (!this.j.isEmpty() || !this.f225q) {
            return q83.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int s() {
        return this.e;
    }

    boolean t(Class cls) {
        return h(cls) != null;
    }

    void u(com.bumptech.glide.c cVar, Object obj, w81 w81Var, int i, int i2, ac0 ac0Var, Class cls, Class cls2, Priority priority, rx1 rx1Var, Map map, boolean z, boolean z2, DecodeJob.e eVar) {
        this.c = cVar;
        this.d = obj;
        this.n = w81Var;
        this.e = i;
        this.f = i2;
        this.p = ac0Var;
        this.g = cls;
        this.h = eVar;
        this.k = cls2;
        this.o = priority;
        this.i = rx1Var;
        this.j = map;
        this.f225q = z;
        this.r = z2;
    }

    boolean v(qg2 qg2Var) {
        return this.c.i().n(qg2Var);
    }

    boolean w() {
        return this.r;
    }

    boolean x(w81 w81Var) {
        List listG = g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (((rk1.a) listG.get(i)).a.equals(w81Var)) {
                return true;
            }
        }
        return false;
    }
}
