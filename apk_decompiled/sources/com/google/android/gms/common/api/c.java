package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.v0;
import defpackage.a52;
import defpackage.er3;
import defpackage.ky;
import defpackage.tz1;
import defpackage.u9;
import defpackage.wo2;
import defpackage.xo2;
import defpackage.ys3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    private static final Set a = Collections.newSetFromMap(new WeakHashMap());

    public static final class a {
        private Account a;
        private int d;
        private View e;
        private String f;
        private String g;
        private final Context i;
        private InterfaceC0078c l;
        private Looper m;
        private final Set b = new HashSet();
        private final Set c = new HashSet();
        private final Map h = new u9();
        private final Map j = new u9();
        private int k = -1;
        private com.google.android.gms.common.a n = com.google.android.gms.common.a.n();
        private com.google.android.gms.common.api.a.AbstractC0075a o = er3.c;
        private final ArrayList p = new ArrayList();

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final ArrayList f239q = new ArrayList();
        private boolean r = false;

        public a(Context context) {
            this.i = context;
            this.m = context.getMainLooper();
            this.f = context.getPackageName();
            this.g = context.getClass().getName();
        }

        public final a a(com.google.android.gms.common.api.a aVar) {
            a52.h(aVar, "Api must not be null");
            this.j.put(aVar, null);
            List listA = aVar.c().a(null);
            this.c.addAll(listA);
            this.b.addAll(listA);
            return this;
        }

        public final a b(com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.a.d.InterfaceC0076a interfaceC0076a) {
            a52.h(aVar, "Api must not be null");
            a52.h(interfaceC0076a, "Null options are not permitted for this Api");
            this.j.put(aVar, interfaceC0076a);
            List listA = aVar.c().a(interfaceC0076a);
            this.c.addAll(listA);
            this.b.addAll(listA);
            return this;
        }

        public final a c(b bVar) {
            a52.h(bVar, "Listener must not be null");
            this.p.add(bVar);
            return this;
        }

        public final a d(InterfaceC0078c interfaceC0078c) {
            a52.h(interfaceC0078c, "Listener must not be null");
            this.f239q.add(interfaceC0078c);
            return this;
        }

        public final c e() {
            a52.b(!this.j.isEmpty(), "must call addApi() to add at least one API");
            ky kyVarF = f();
            Map mapG = kyVarF.g();
            u9 u9Var = new u9();
            u9 u9Var2 = new u9();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            com.google.android.gms.common.api.a aVar = null;
            for (com.google.android.gms.common.api.a aVar2 : this.j.keySet()) {
                Object obj = this.j.get(aVar2);
                boolean z2 = mapG.get(aVar2) != null;
                u9Var.put(aVar2, Boolean.valueOf(z2));
                ys3 ys3Var = new ys3(aVar2, z2);
                arrayList.add(ys3Var);
                com.google.android.gms.common.api.a.AbstractC0075a abstractC0075aD = aVar2.d();
                com.google.android.gms.common.api.a.f fVarC = abstractC0075aD.c(this.i, this.m, kyVarF, obj, ys3Var, ys3Var);
                u9Var2.put(aVar2.a(), fVarC);
                if (abstractC0075aD.b() == 1) {
                    z = obj != null;
                }
                if (fVarC.f()) {
                    if (aVar != null) {
                        String strB = aVar2.b();
                        String strB2 = aVar.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 21 + String.valueOf(strB2).length());
                        sb.append(strB);
                        sb.append(" cannot be used with ");
                        sb.append(strB2);
                        throw new IllegalStateException(sb.toString());
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                if (z) {
                    String strB3 = aVar.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strB3).length() + 82);
                    sb2.append("With using ");
                    sb2.append(strB3);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
                a52.k(this.a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar.b());
                a52.k(this.b.equals(this.c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar.b());
            }
            v vVar = new v(this.i, new ReentrantLock(), this.m, kyVarF, this.n, this.o, u9Var, this.p, this.f239q, u9Var2, this.k, v.v(u9Var2.values(), true), arrayList, false);
            synchronized (c.a) {
                c.a.add(vVar);
            }
            if (this.k >= 0) {
                v0.p(null).r(this.k, vVar, this.l);
            }
            return vVar;
        }

        public final ky f() {
            xo2 xo2Var = xo2.i;
            Map map = this.j;
            com.google.android.gms.common.api.a aVar = er3.g;
            if (map.containsKey(aVar)) {
                xo2Var = (xo2) this.j.get(aVar);
            }
            return new ky(this.a, this.b, this.h, this.d, this.e, this.f, this.g, xo2Var);
        }

        public final a g(Handler handler) {
            a52.h(handler, "Handler must not be null");
            this.m = handler.getLooper();
            return this;
        }
    }

    public interface b {
        void a(int i);

        void b(Bundle bundle);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.api.c$c, reason: collision with other inner class name */
    public interface InterfaceC0078c {
        void d(ConnectionResult connectionResult);
    }

    public static Set k() {
        Set set = a;
        synchronized (set) {
        }
        return set;
    }

    public abstract ConnectionResult d();

    public abstract tz1 e();

    public abstract void f();

    public void g(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void h();

    public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract com.google.android.gms.common.api.internal.b j(com.google.android.gms.common.api.internal.b bVar);

    public abstract Context l();

    public abstract Looper m();

    public abstract boolean n();

    public boolean o(wo2 wo2Var) {
        throw new UnsupportedOperationException();
    }

    public void p() {
        throw new UnsupportedOperationException();
    }

    public abstract void q();

    public abstract void r(InterfaceC0078c interfaceC0078c);

    public abstract void s(InterfaceC0078c interfaceC0078c);
}
