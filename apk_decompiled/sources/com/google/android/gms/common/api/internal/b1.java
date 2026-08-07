package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.a52;
import defpackage.ky;
import defpackage.qr3;
import defpackage.u9;
import defpackage.vs3;
import defpackage.wo2;
import defpackage.ys3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class b1 implements qr3 {
    private final Context c;
    private final v d;
    private final Looper e;
    private final d0 f;
    private final d0 g;
    private final Map h;
    private final com.google.android.gms.common.api.a.f j;
    private Bundle k;
    private final Lock o;
    private final Set i = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult l = null;
    private ConnectionResult m = null;
    private boolean n = false;
    private int p = 0;

    private b1(Context context, v vVar, Lock lock, Looper looper, com.google.android.gms.common.b bVar, Map map, Map map2, ky kyVar, com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a, com.google.android.gms.common.api.a.f fVar, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.c = context;
        this.d = vVar;
        this.o = lock;
        this.e = looper;
        this.j = fVar;
        this.f = new d0(context, vVar, lock, looper, bVar, map2, null, map4, null, arrayList2, new d1(this, null));
        this.g = new d0(context, vVar, lock, looper, bVar, map, kyVar, map3, abstractC0075a, arrayList, new e1(this, null));
        u9 u9Var = new u9();
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            u9Var.put((com.google.android.gms.common.api.a.c) it.next(), this.f);
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            u9Var.put((com.google.android.gms.common.api.a.c) it2.next(), this.g);
        }
        this.h = Collections.unmodifiableMap(u9Var);
    }

    private final boolean A() {
        ConnectionResult connectionResult = this.m;
        return connectionResult != null && connectionResult.F0() == 4;
    }

    public static b1 c(Context context, v vVar, Lock lock, Looper looper, com.google.android.gms.common.b bVar, Map map, ky kyVar, Map map2, com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a, ArrayList arrayList) {
        u9 u9Var = new u9();
        u9 u9Var2 = new u9();
        com.google.android.gms.common.api.a.f fVar = null;
        for (Map.Entry entry : map.entrySet()) {
            com.google.android.gms.common.api.a.f fVar2 = (com.google.android.gms.common.api.a.f) entry.getValue();
            if (fVar2.f()) {
                fVar = fVar2;
            }
            if (fVar2.o()) {
                u9Var.put((com.google.android.gms.common.api.a.c) entry.getKey(), fVar2);
            } else {
                u9Var2.put((com.google.android.gms.common.api.a.c) entry.getKey(), fVar2);
            }
        }
        a52.j(!u9Var.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        u9 u9Var3 = new u9();
        u9 u9Var4 = new u9();
        for (com.google.android.gms.common.api.a aVar : map2.keySet()) {
            com.google.android.gms.common.api.a.c cVarA = aVar.a();
            if (u9Var.containsKey(cVarA)) {
                u9Var3.put(aVar, (Boolean) map2.get(aVar));
            } else {
                if (!u9Var2.containsKey(cVarA)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                u9Var4.put(aVar, (Boolean) map2.get(aVar));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ys3 ys3Var = (ys3) obj;
            if (u9Var3.containsKey(ys3Var.c)) {
                arrayList2.add(ys3Var);
            } else {
                if (!u9Var4.containsKey(ys3Var.c)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(ys3Var);
            }
        }
        return new b1(context, vVar, lock, looper, bVar, u9Var, u9Var2, kyVar, abstractC0075a, fVar, arrayList2, arrayList3, u9Var3, u9Var4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int i, boolean z) {
        this.d.c(i, z);
        this.m = null;
        this.l = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Bundle bundle) {
        Bundle bundle2 = this.k;
        if (bundle2 == null) {
            this.k = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private final void l(ConnectionResult connectionResult) {
        int i = this.p;
        if (i == 1) {
            z();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.d.a(connectionResult);
            z();
        }
        this.p = 0;
    }

    private final boolean o(b bVar) {
        com.google.android.gms.common.api.a.c cVarS = bVar.s();
        a52.b(this.h.containsKey(cVarS), "GoogleApiClient is not configured to use the API required for this call.");
        return ((d0) this.h.get(cVarS)).equals(this.g);
    }

    private final PendingIntent q() {
        if (this.j == null) {
            return null;
        }
        return PendingIntent.getActivity(this.c, System.identityHashCode(this.d), this.j.n(), 134217728);
    }

    private static boolean t(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        ConnectionResult connectionResult;
        if (!t(this.l)) {
            if (this.l != null && t(this.m)) {
                this.g.disconnect();
                l(this.l);
                return;
            }
            ConnectionResult connectionResult2 = this.l;
            if (connectionResult2 == null || (connectionResult = this.m) == null) {
                return;
            }
            if (this.g.o < this.f.o) {
                connectionResult2 = connectionResult;
            }
            l(connectionResult2);
            return;
        }
        if (t(this.m) || A()) {
            int i = this.p;
            if (i == 1) {
                z();
            } else if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                this.d.b(this.k);
                z();
            }
            this.p = 0;
            return;
        }
        ConnectionResult connectionResult3 = this.m;
        if (connectionResult3 != null) {
            if (this.p == 1) {
                z();
            } else {
                l(connectionResult3);
                this.f.disconnect();
            }
        }
    }

    private final void z() {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            ((wo2) it.next()).onComplete();
        }
        this.i.clear();
    }

    public final boolean a() {
        this.o.lock();
        try {
            return this.p == 2;
        } finally {
            this.o.unlock();
        }
    }

    @Override // defpackage.qr3
    public final void connect() {
        this.p = 2;
        this.n = false;
        this.m = null;
        this.l = null;
        this.f.connect();
        this.g.connect();
    }

    @Override // defpackage.qr3
    public final b d(b bVar) {
        if (!o(bVar)) {
            return this.f.d(bVar);
        }
        if (!A()) {
            return this.g.d(bVar);
        }
        bVar.w(new Status(4, null, q()));
        return bVar;
    }

    @Override // defpackage.qr3
    public final void disconnect() {
        this.m = null;
        this.l = null;
        this.p = 0;
        this.f.disconnect();
        this.g.disconnect();
        z();
    }

    @Override // defpackage.qr3
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.g.e(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f.e(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // defpackage.qr3
    public final boolean f(wo2 wo2Var) {
        this.o.lock();
        try {
            if (a() || isConnected()) {
                if (!this.g.isConnected()) {
                    this.i.add(wo2Var);
                    if (this.p == 0) {
                        this.p = 1;
                    }
                    this.m = null;
                    this.g.connect();
                    return true;
                }
            }
            return false;
        } finally {
            this.o.unlock();
        }
    }

    @Override // defpackage.qr3
    public final void g() {
        this.o.lock();
        try {
            boolean zA = a();
            this.g.disconnect();
            this.m = new ConnectionResult(4);
            if (zA) {
                new vs3(this.e).post(new c1(this));
            } else {
                z();
            }
        } finally {
            this.o.unlock();
        }
    }

    @Override // defpackage.qr3
    public final ConnectionResult h() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    @Override // defpackage.qr3
    public final boolean isConnected() {
        boolean z;
        this.o.lock();
        try {
            if (this.f.isConnected()) {
                z = true;
                if (!this.g.isConnected() && !A() && this.p != 1) {
                    z = false;
                }
            } else {
                z = false;
            }
            return z;
        } finally {
            this.o.unlock();
        }
    }
}
