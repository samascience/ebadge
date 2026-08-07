package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.h;
import defpackage.df1;
import defpackage.ji1;
import defpackage.ki1;
import defpackage.m31;
import defpackage.nu0;
import defpackage.of2;
import defpackage.oi;
import defpackage.pi;
import defpackage.u9;
import defpackage.v9;
import defpackage.we1;
import defpackage.x70;
import defpackage.yb0;
import defpackage.ye1;
import defpackage.z10;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private h c;
    private oi d;
    private v9 e;
    private ji1 f;
    private nu0 g;
    private nu0 h;
    private yb0.a i;
    private ki1 j;
    private z10 k;
    private com.bumptech.glide.manager.h.b n;
    private nu0 o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List f223q;
    private final Map a = new u9();
    private final com.bumptech.glide.d.a b = new com.bumptech.glide.d.a();
    private int l = 4;
    private com.bumptech.glide.a.InterfaceC0057a m = new a();

    class a implements com.bumptech.glide.a.InterfaceC0057a {
        a() {
        }

        @Override // com.bumptech.glide.a.InterfaceC0057a
        public of2 a() {
            return new of2();
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.b$b, reason: collision with other inner class name */
    static final class C0058b {
    }

    public static final class c {
    }

    public static final class d {
    }

    com.bumptech.glide.a a(Context context) {
        if (this.g == null) {
            this.g = nu0.g();
        }
        if (this.h == null) {
            this.h = nu0.e();
        }
        if (this.o == null) {
            this.o = nu0.c();
        }
        if (this.j == null) {
            this.j = new ki1.a(context).a();
        }
        if (this.k == null) {
            this.k = new x70();
        }
        if (this.d == null) {
            int iB = this.j.b();
            if (iB > 0) {
                this.d = new ye1(iB);
            } else {
                this.d = new pi();
            }
        }
        if (this.e == null) {
            this.e = new we1(this.j.a());
        }
        if (this.f == null) {
            this.f = new df1(this.j.d());
        }
        if (this.i == null) {
            this.i = new m31(context);
        }
        if (this.c == null) {
            this.c = new h(this.f, this.i, this.h, this.g, nu0.h(), this.o, this.p);
        }
        List list = this.f223q;
        if (list == null) {
            this.f223q = Collections.emptyList();
        } else {
            this.f223q = Collections.unmodifiableList(list);
        }
        com.bumptech.glide.d dVarB = this.b.b();
        return new com.bumptech.glide.a(context, this.c, this.f, this.d, this.e, new com.bumptech.glide.manager.h(this.n, dVarB), this.k, this.l, this.m, this.a, this.f223q, dVarB);
    }

    void b(com.bumptech.glide.manager.h.b bVar) {
        this.n = bVar;
    }
}
