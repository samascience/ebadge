package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import defpackage.a52;
import defpackage.c8;
import defpackage.ky;
import defpackage.or3;
import defpackage.qs3;
import defpackage.yt2;
import defpackage.zr3;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private final Context a;
    private final com.google.android.gms.common.api.a b;
    private final com.google.android.gms.common.api.a.d c;
    private final qs3 d;
    private final Looper e;
    private final int f;
    private final c g;
    private final yt2 h;
    protected final com.google.android.gms.common.api.internal.c i;

    public static class a {
        public static final a c = new C0077a().a();
        public final yt2 a;
        public final Looper b;

        /* JADX INFO: renamed from: com.google.android.gms.common.api.b$a$a, reason: collision with other inner class name */
        public static class C0077a {
            private yt2 a;
            private Looper b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.a == null) {
                    this.a = new c8();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new a(this.a, this.b);
            }

            public C0077a b(yt2 yt2Var) {
                a52.h(yt2Var, "StatusExceptionMapper must not be null.");
                this.a = yt2Var;
                return this;
            }
        }

        private a(yt2 yt2Var, Account account, Looper looper) {
            this.a = yt2Var;
            this.b = looper;
        }
    }

    protected b(Context context, com.google.android.gms.common.api.a aVar, Looper looper) {
        a52.h(context, "Null context is not permitted.");
        a52.h(aVar, "Api must not be null.");
        a52.h(looper, "Looper must not be null.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.c = null;
        this.e = looper;
        this.d = qs3.a(aVar);
        this.g = new or3(this);
        com.google.android.gms.common.api.internal.c cVarJ = com.google.android.gms.common.api.internal.c.j(applicationContext);
        this.i = cVarJ;
        this.f = cVarJ.m();
        this.h = new c8();
    }

    private final com.google.android.gms.common.api.internal.b i(int i, com.google.android.gms.common.api.internal.b bVar) {
        bVar.p();
        this.i.h(this, i, bVar);
        return bVar;
    }

    protected ky.a a() {
        return new ky.a().c(null).a(Collections.emptySet()).d(this.a.getClass().getName()).e(this.a.getPackageName());
    }

    public com.google.android.gms.common.api.internal.b b(com.google.android.gms.common.api.internal.b bVar) {
        return i(1, bVar);
    }

    public final com.google.android.gms.common.api.a c() {
        return this.b;
    }

    public com.google.android.gms.common.api.a.d d() {
        return this.c;
    }

    public Context e() {
        return this.a;
    }

    public final int f() {
        return this.f;
    }

    public Looper g() {
        return this.e;
    }

    public com.google.android.gms.common.api.a.f h(Looper looper, com.google.android.gms.common.api.internal.c.a aVar) {
        return this.b.d().c(this.a, looper, a().b(), this.c, aVar, aVar);
    }

    public zr3 j(Context context, Handler handler) {
        return new zr3(context, handler, a().b());
    }

    public final qs3 k() {
        return this.d;
    }

    public b(Context context, com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.a.d dVar, a aVar2) {
        a52.h(context, "Null context is not permitted.");
        a52.h(aVar, "Api must not be null.");
        a52.h(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.c = dVar;
        this.e = aVar2.b;
        this.d = qs3.b(aVar, dVar);
        this.g = new or3(this);
        com.google.android.gms.common.api.internal.c cVarJ = com.google.android.gms.common.api.internal.c.j(applicationContext);
        this.i = cVarJ;
        this.f = cVarJ.m();
        this.h = aVar2.a;
        cVarJ.g(this);
    }

    public b(Context context, com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.a.d dVar, yt2 yt2Var) {
        this(context, aVar, dVar, new a.C0077a().b(yt2Var).a());
    }
}
