package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.cw0;
import defpackage.e43;
import defpackage.ky;
import defpackage.qr3;
import defpackage.u9;
import defpackage.wo2;
import defpackage.ys3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class g1 implements qr3 {
    private final Map e;
    private final c f;
    private final v g;
    private final Lock h;
    private final Looper i;
    private final com.google.android.gms.common.b j;
    private final Condition k;
    private final ky l;
    private final boolean m;
    private final boolean n;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map f241q;
    private Map r;
    private d s;
    private ConnectionResult t;
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Queue o = new LinkedList();

    public g1(Context context, Lock lock, Looper looper, com.google.android.gms.common.b bVar, Map map, ky kyVar, Map map2, com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a, ArrayList arrayList, v vVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.h = lock;
        this.i = looper;
        this.k = lock.newCondition();
        this.j = bVar;
        this.g = vVar;
        this.e = map2;
        this.l = kyVar;
        this.m = z;
        HashMap map3 = new HashMap();
        for (com.google.android.gms.common.api.a aVar : map2.keySet()) {
            map3.put(aVar.a(), aVar);
        }
        HashMap map4 = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ys3 ys3Var = (ys3) obj;
            map4.put(ys3Var.c, ys3Var);
        }
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = false;
        for (Map.Entry entry : map.entrySet()) {
            com.google.android.gms.common.api.a aVar2 = (com.google.android.gms.common.api.a) map3.get(entry.getKey());
            com.google.android.gms.common.api.a.f fVar = (com.google.android.gms.common.api.a.f) entry.getValue();
            if (fVar.k()) {
                z4 = z5;
                if (((Boolean) this.e.get(aVar2)).booleanValue()) {
                    z3 = z7;
                    z2 = true;
                } else {
                    z2 = true;
                    z3 = true;
                }
            } else {
                z2 = z6;
                z3 = z7;
                z4 = false;
            }
            f1 f1Var = new f1(context, aVar2, looper, fVar, (ys3) map4.get(aVar2), kyVar, abstractC0075a);
            this.c.put((com.google.android.gms.common.api.a.c) entry.getKey(), f1Var);
            if (fVar.o()) {
                this.d.put((com.google.android.gms.common.api.a.c) entry.getKey(), f1Var);
            }
            z6 = z2;
            z5 = z4;
            z7 = z3;
        }
        this.n = (!z6 || z5 || z7) ? false : true;
        this.f = c.l();
    }

    private final ConnectionResult c(com.google.android.gms.common.api.a.c cVar) {
        this.h.lock();
        try {
            f1 f1Var = (f1) this.c.get(cVar);
            Map map = this.f241q;
            if (map == null || f1Var == null) {
                return null;
            }
            return (ConnectionResult) map.get(f1Var.k());
        } finally {
            this.h.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(f1 f1Var, ConnectionResult connectionResult) {
        return !connectionResult.J0() && !connectionResult.I0() && ((Boolean) this.e.get(f1Var.c())).booleanValue() && f1Var.l().k() && this.j.k(connectionResult.F0());
    }

    static /* synthetic */ boolean n(g1 g1Var, boolean z) {
        g1Var.p = false;
        return false;
    }

    private final boolean o() {
        this.h.lock();
        try {
            if (this.p && this.m) {
                Iterator it = this.d.keySet().iterator();
                while (it.hasNext()) {
                    ConnectionResult connectionResultC = c((com.google.android.gms.common.api.a.c) it.next());
                    if (connectionResultC == null || !connectionResultC.J0()) {
                        this.h.unlock();
                        return false;
                    }
                }
                this.h.unlock();
                return true;
            }
            this.h.unlock();
            return false;
        } catch (Throwable th) {
            this.h.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (this.l == null) {
            this.g.f243q = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(this.l.j());
        Map mapG = this.l.g();
        for (com.google.android.gms.common.api.a aVar : mapG.keySet()) {
            ConnectionResult connectionResultA = a(aVar);
            if (connectionResultA != null && connectionResultA.J0()) {
                e43.a(mapG.get(aVar));
                throw null;
            }
        }
        this.g.f243q = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        while (!this.o.isEmpty()) {
            d((b) this.o.remove());
        }
        this.g.b(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectionResult r() {
        ConnectionResult connectionResult = null;
        int i = 0;
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        for (f1 f1Var : this.c.values()) {
            com.google.android.gms.common.api.a aVarC = f1Var.c();
            ConnectionResult connectionResult3 = (ConnectionResult) this.f241q.get(f1Var.k());
            if (!connectionResult3.J0() && (!((Boolean) this.e.get(aVarC)).booleanValue() || connectionResult3.I0() || this.j.k(connectionResult3.F0()))) {
                if (connectionResult3.F0() == 4 && this.m) {
                    int iB = aVarC.c().b();
                    if (connectionResult2 == null || i2 > iB) {
                        connectionResult2 = connectionResult3;
                        i2 = iB;
                    }
                } else {
                    int iB2 = aVarC.c().b();
                    if (connectionResult == null || i > iB2) {
                        connectionResult = connectionResult3;
                        i = iB2;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    private final boolean t(b bVar) {
        com.google.android.gms.common.api.a.c cVarS = bVar.s();
        ConnectionResult connectionResultC = c(cVarS);
        if (connectionResultC == null || connectionResultC.F0() != 4) {
            return false;
        }
        bVar.w(new Status(4, null, this.f.d(((f1) this.c.get(cVarS)).k(), System.identityHashCode(this.g))));
        return true;
    }

    public final ConnectionResult a(com.google.android.gms.common.api.a aVar) {
        return c(aVar.a());
    }

    public final boolean b() {
        this.h.lock();
        try {
            return this.f241q == null && this.p;
        } finally {
            this.h.unlock();
        }
    }

    @Override // defpackage.qr3
    public final void connect() {
        this.h.lock();
        try {
            if (this.p) {
                return;
            }
            this.p = true;
            this.f241q = null;
            this.r = null;
            this.s = null;
            this.t = null;
            this.f.x();
            this.f.c(this.c.values()).a(new cw0(this.i), new i1(this));
        } finally {
            this.h.unlock();
        }
    }

    @Override // defpackage.qr3
    public final b d(b bVar) {
        com.google.android.gms.common.api.a.c cVarS = bVar.s();
        if (this.m && t(bVar)) {
            return bVar;
        }
        this.g.y.b(bVar);
        return ((f1) this.c.get(cVarS)).b(bVar);
    }

    @Override // defpackage.qr3
    public final void disconnect() {
        this.h.lock();
        try {
            this.p = false;
            this.f241q = null;
            this.r = null;
            d dVar = this.s;
            if (dVar != null) {
                dVar.b();
                this.s = null;
            }
            this.t = null;
            while (!this.o.isEmpty()) {
                b bVar = (b) this.o.remove();
                bVar.l(null);
                bVar.c();
            }
            this.k.signalAll();
        } finally {
            this.h.unlock();
        }
    }

    @Override // defpackage.qr3
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // defpackage.qr3
    public final boolean f(wo2 wo2Var) {
        Lock lock;
        this.h.lock();
        try {
            if (!this.p || o()) {
                return false;
            }
            this.f.x();
            this.s = new d(this, wo2Var);
            this.f.c(this.d.values()).a(new cw0(this.i), this.s);
            return true;
        } finally {
            this.h.unlock();
        }
    }

    @Override // defpackage.qr3
    public final void g() {
        this.h.lock();
        try {
            this.f.a();
            d dVar = this.s;
            if (dVar != null) {
                dVar.b();
                this.s = null;
            }
            if (this.r == null) {
                this.r = new u9(this.d.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            Iterator it = this.d.values().iterator();
            while (it.hasNext()) {
                this.r.put(((f1) it.next()).k(), connectionResult);
            }
            Map map = this.f241q;
            if (map != null) {
                map.putAll(this.r);
            }
        } finally {
            this.h.unlock();
        }
    }

    @Override // defpackage.qr3
    public final ConnectionResult h() {
        connect();
        while (b()) {
            try {
                this.k.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.e;
        }
        ConnectionResult connectionResult = this.t;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // defpackage.qr3
    public final boolean isConnected() {
        this.h.lock();
        try {
            return this.f241q != null && this.t == null;
        } finally {
            this.h.unlock();
        }
    }
}
