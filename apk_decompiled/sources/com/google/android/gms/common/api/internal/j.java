package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zaj;
import defpackage.ds3;
import defpackage.e43;
import defpackage.ky;
import defpackage.mr3;
import defpackage.nr3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class j implements mr3 {
    private final d0 a;
    private final Lock b;
    private final Context c;
    private final com.google.android.gms.common.b d;
    private ConnectionResult e;
    private int f;
    private int h;
    private ds3 k;
    private boolean l;
    private boolean m;
    private boolean n;
    private com.google.android.gms.common.internal.f o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f242q;
    private final ky r;
    private final Map s;
    private final com.google.android.gms.common.api.a.AbstractC0075a t;
    private int g = 0;
    private final Bundle i = new Bundle();
    private final Set j = new HashSet();
    private ArrayList u = new ArrayList();

    public j(d0 d0Var, ky kyVar, Map map, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a, Lock lock, Context context) {
        this.a = d0Var;
        this.r = kyVar;
        this.s = map;
        this.d = bVar;
        this.t = abstractC0075a;
        this.b = lock;
        this.c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(ConnectionResult connectionResult) {
        p();
        t(!connectionResult.I0());
        this.a.p(connectionResult);
        this.a.f240q.a(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(zaj zajVar) {
        if (w(0)) {
            ConnectionResult connectionResultF0 = zajVar.F0();
            if (!connectionResultF0.J0()) {
                if (!z(connectionResultF0)) {
                    A(connectionResultF0);
                    return;
                } else {
                    o();
                    m();
                    return;
                }
            }
            ResolveAccountResponse resolveAccountResponseG0 = zajVar.G0();
            ConnectionResult connectionResultG0 = resolveAccountResponseG0.G0();
            if (connectionResultG0.J0()) {
                this.n = true;
                this.o = resolveAccountResponseG0.F0();
                this.p = resolveAccountResponseG0.H0();
                this.f242q = resolveAccountResponseG0.I0();
                m();
                return;
            }
            String strValueOf = String.valueOf(connectionResultG0);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(strValueOf);
            Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
            A(connectionResultG0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l() {
        int i = this.h - 1;
        this.h = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GoogleApiClientConnecting", this.a.p.D());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            A(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.e;
        if (connectionResult == null) {
            return true;
        }
        this.a.o = this.f;
        A(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (this.h != 0) {
            return;
        }
        if (!this.m || this.n) {
            ArrayList arrayList = new ArrayList();
            this.g = 1;
            this.h = this.a.h.size();
            for (com.google.android.gms.common.api.a.c cVar : this.a.h.keySet()) {
                if (!this.a.i.containsKey(cVar)) {
                    arrayList.add((com.google.android.gms.common.api.a.f) this.a.h.get(cVar));
                } else if (l()) {
                    n();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.u.add(nr3.a().submit(new p(this, arrayList)));
        }
    }

    private final void n() {
        this.a.o();
        nr3.a().execute(new k(this));
        ds3 ds3Var = this.k;
        if (ds3Var != null) {
            if (this.p) {
                ds3Var.a(this.o, this.f242q);
            }
            t(false);
        }
        Iterator it = this.a.i.keySet().iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.a.f) this.a.h.get((com.google.android.gms.common.api.a.c) it.next())).disconnect();
        }
        this.a.f240q.b(this.i.isEmpty() ? null : this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.m = false;
        this.a.p.f243q = Collections.emptySet();
        for (com.google.android.gms.common.api.a.c cVar : this.j) {
            if (!this.a.i.containsKey(cVar)) {
                this.a.i.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    private final void p() {
        ArrayList arrayList = this.u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set q() {
        if (this.r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.r.j());
        Map mapG = this.r.g();
        for (com.google.android.gms.common.api.a aVar : mapG.keySet()) {
            if (!this.a.i.containsKey(aVar.a())) {
                e43.a(mapG.get(aVar));
                throw null;
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ConnectionResult connectionResult, com.google.android.gms.common.api.a aVar, boolean z) {
        int iB = aVar.c().b();
        if ((!z || connectionResult.I0() || this.d.b(connectionResult.F0()) != null) && (this.e == null || iB < this.f)) {
            this.e = connectionResult;
            this.f = iB;
        }
        this.a.i.put(aVar.a(), connectionResult);
    }

    private final void t(boolean z) {
        ds3 ds3Var = this.k;
        if (ds3Var != null) {
            if (ds3Var.isConnected() && z) {
                this.k.c();
            }
            this.k.disconnect();
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w(int i) {
        if (this.g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.a.p.D());
        String strValueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(strValueOf);
        Log.w("GoogleApiClientConnecting", sb.toString());
        int i2 = this.h;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i2);
        Log.w("GoogleApiClientConnecting", sb2.toString());
        String strY = y(this.g);
        String strY2 = y(i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(strY).length() + 70 + String.valueOf(strY2).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(strY);
        sb3.append(" but received callback for step ");
        sb3.append(strY2);
        Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
        A(new ConnectionResult(8, null));
        return false;
    }

    private static String y(int i) {
        if (i != 0) {
            return i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE";
        }
        return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z(ConnectionResult connectionResult) {
        return this.l && !connectionResult.I0();
    }

    @Override // defpackage.mr3
    public final void a(int i) {
        A(new ConnectionResult(8, null));
    }

    @Override // defpackage.mr3
    public final void b(Bundle bundle) {
        if (w(1)) {
            if (bundle != null) {
                this.i.putAll(bundle);
            }
            if (l()) {
                n();
            }
        }
    }

    @Override // defpackage.mr3
    public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a aVar, boolean z) {
        if (w(1)) {
            s(connectionResult, aVar, z);
            if (l()) {
                n();
            }
        }
    }

    @Override // defpackage.mr3
    public final void connect() {
    }

    @Override // defpackage.mr3
    public final b d(b bVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // defpackage.mr3
    public final boolean disconnect() {
        p();
        t(true);
        this.a.p(null);
        return true;
    }

    @Override // defpackage.mr3
    public final void e() {
        this.a.i.clear();
        this.m = false;
        k kVar = null;
        this.e = null;
        this.g = 0;
        this.l = true;
        this.n = false;
        this.p = false;
        HashMap map = new HashMap();
        boolean z = false;
        for (com.google.android.gms.common.api.a aVar : this.s.keySet()) {
            com.google.android.gms.common.api.a.f fVar = (com.google.android.gms.common.api.a.f) this.a.h.get(aVar.a());
            z |= aVar.c().b() == 1;
            boolean zBooleanValue = ((Boolean) this.s.get(aVar)).booleanValue();
            if (fVar.o()) {
                this.m = true;
                if (zBooleanValue) {
                    this.j.add(aVar.a());
                } else {
                    this.l = false;
                }
            }
            map.put(fVar, new l(this, aVar, zBooleanValue));
        }
        if (z) {
            this.m = false;
        }
        if (this.m) {
            this.r.l(Integer.valueOf(System.identityHashCode(this.a.p)));
            s sVar = new s(this, kVar);
            com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a = this.t;
            Context context = this.c;
            Looper looperM = this.a.p.m();
            ky kyVar = this.r;
            this.k = (ds3) abstractC0075a.c(context, looperM, kyVar, kyVar.k(), sVar, sVar);
        }
        this.h = this.a.h.size();
        this.u.add(nr3.a().submit(new m(this, map)));
    }
}
