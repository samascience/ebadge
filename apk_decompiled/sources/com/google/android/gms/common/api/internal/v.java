package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.baji.protocol.model.ProtocolConstants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.tencent.connect.common.Constants;
import defpackage.a52;
import defpackage.au2;
import defpackage.hy;
import defpackage.ky;
import defpackage.qr3;
import defpackage.rr3;
import defpackage.tz1;
import defpackage.wb1;
import defpackage.wo2;
import defpackage.yz;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class v extends com.google.android.gms.common.api.c implements rr3 {
    private final Lock b;
    private boolean c;
    private final com.google.android.gms.common.internal.d d;
    private final int f;
    private final Context g;
    private final Looper h;
    private volatile boolean j;
    private long k;
    private long l;
    private final b0 m;
    private final com.google.android.gms.common.a n;
    private zabq o;
    final Map p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Set f243q;
    private final ky r;
    private final Map s;
    private final com.google.android.gms.common.api.a.AbstractC0075a t;
    private final wb1 u;
    private final ArrayList v;
    private Integer w;
    Set x;
    final o0 y;
    private final com.google.android.gms.common.internal.d.a z;
    private qr3 e = null;
    final Queue i = new LinkedList();

    public v(Context context, Lock lock, Looper looper, ky kyVar, com.google.android.gms.common.a aVar, com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList, boolean z) {
        this.k = hy.a() ? ProtocolConstants.CONNECTION_TIMEOUT_MS : 120000L;
        this.l = 5000L;
        this.f243q = new HashSet();
        this.u = new wb1();
        this.w = null;
        this.x = null;
        w wVar = new w(this);
        this.z = wVar;
        this.g = context;
        this.b = lock;
        this.c = false;
        this.d = new com.google.android.gms.common.internal.d(looper, wVar);
        this.h = looper;
        this.m = new b0(this, looper);
        this.n = aVar;
        this.f = i;
        if (i >= 0) {
            this.w = Integer.valueOf(i2);
        }
        this.s = map;
        this.p = map2;
        this.v = arrayList;
        this.y = new o0(map2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.d.f((com.google.android.gms.common.api.c.b) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.d.g((com.google.android.gms.common.api.c.InterfaceC0078c) it2.next());
        }
        this.r = kyVar;
        this.t = abstractC0075a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        this.b.lock();
        try {
            if (B()) {
                z();
            }
        } finally {
            this.b.unlock();
        }
    }

    private final void G(int i) {
        Integer num = this.w;
        if (num == null) {
            this.w = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String strH = H(i);
            String strH2 = H(this.w.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(strH).length() + 51 + String.valueOf(strH2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(strH);
            sb.append(". Mode was already set to ");
            sb.append(strH2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.e != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (com.google.android.gms.common.api.a.f fVar : this.p.values()) {
            if (fVar.o()) {
                z = true;
            }
            if (fVar.f()) {
                z2 = true;
            }
        }
        int iIntValue = this.w.intValue();
        if (iIntValue == 1) {
            if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (iIntValue == 2 && z) {
            if (this.c) {
                this.e = new g1(this.g, this.b, this.h, this.n, this.p, this.r, this.s, this.t, this.v, this, true);
                return;
            } else {
                this.e = b1.c(this.g, this, this.b, this.h, this.n, this.p, this.r, this.s, this.t, this.v);
                return;
            }
        }
        if (!this.c || z2) {
            this.e = new d0(this.g, this, this.b, this.h, this.n, this.p, this.r, this.s, this.t, this.v, this);
        } else {
            this.e = new g1(this.g, this.b, this.h, this.n, this.p, this.r, this.s, this.t, this.v, this, false);
        }
    }

    private static String H(int i) {
        if (i == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (i != 2) {
            return i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE";
        }
        return "SIGN_IN_MODE_OPTIONAL";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.b.lock();
        try {
            if (this.j) {
                z();
            }
        } finally {
            this.b.unlock();
        }
    }

    public static int v(Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            com.google.android.gms.common.api.a.f fVar = (com.google.android.gms.common.api.a.f) it.next();
            if (fVar.o()) {
                z2 = true;
            }
            if (fVar.f()) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(com.google.android.gms.common.api.c cVar, au2 au2Var, boolean z) {
        yz.d.a(cVar).e(new a0(this, au2Var, z, cVar));
    }

    private final void z() {
        this.d.b();
        this.e.connect();
    }

    final boolean B() {
        if (!this.j) {
            return false;
        }
        this.j = false;
        this.m.removeMessages(2);
        this.m.removeMessages(1);
        zabq zabqVar = this.o;
        if (zabqVar != null) {
            zabqVar.a();
            this.o = null;
        }
        return true;
    }

    final boolean C() {
        Lock lock;
        this.b.lock();
        try {
            Set set = this.x;
            if (set == null) {
                return false;
            }
            return !set.isEmpty();
        } finally {
            this.b.unlock();
        }
    }

    final String D() {
        StringWriter stringWriter = new StringWriter();
        i(Constants.STR_EMPTY, null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // defpackage.rr3
    public final void a(ConnectionResult connectionResult) {
        if (!this.n.i(this.g, connectionResult.F0())) {
            B();
        }
        if (this.j) {
            return;
        }
        this.d.c(connectionResult);
        this.d.a();
    }

    @Override // defpackage.rr3
    public final void b(Bundle bundle) {
        while (!this.i.isEmpty()) {
            j((b) this.i.remove());
        }
        this.d.d(bundle);
    }

    @Override // defpackage.rr3
    public final void c(int i, boolean z) {
        if (i == 1 && !z && !this.j) {
            this.j = true;
            if (this.o == null && !hy.a()) {
                this.o = this.n.s(this.g.getApplicationContext(), new c0(this));
            }
            b0 b0Var = this.m;
            b0Var.sendMessageDelayed(b0Var.obtainMessage(1), this.k);
            b0 b0Var2 = this.m;
            b0Var2.sendMessageDelayed(b0Var2.obtainMessage(2), this.l);
        }
        this.y.c();
        this.d.e(i);
        this.d.a();
        if (i == 2) {
            z();
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final ConnectionResult d() {
        boolean z = true;
        a52.j(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.b.lock();
        try {
            if (this.f >= 0) {
                if (this.w == null) {
                    z = false;
                }
                a52.j(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.w;
                if (num == null) {
                    this.w = Integer.valueOf(v(this.p.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            G(this.w.intValue());
            this.d.b();
            ConnectionResult connectionResultH = this.e.h();
            this.b.unlock();
            return connectionResultH;
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final tz1 e() {
        a52.j(n(), "GoogleApiClient is not connected yet.");
        a52.j(this.w.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        au2 au2Var = new au2(this);
        if (this.p.containsKey(yz.a)) {
            w(this, au2Var, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            com.google.android.gms.common.api.c cVarE = new com.google.android.gms.common.api.c.a(this.g).a(yz.c).c(new x(this, atomicReference, au2Var)).d(new y(this, au2Var)).g(this.m).e();
            atomicReference.set(cVarE);
            cVarE.f();
        }
        return au2Var;
    }

    @Override // com.google.android.gms.common.api.c
    public final void f() {
        this.b.lock();
        try {
            if (this.f >= 0) {
                a52.j(this.w != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.w;
                if (num == null) {
                    this.w = Integer.valueOf(v(this.p.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            g(this.w.intValue());
            this.b.unlock();
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final void g(int i) {
        this.b.lock();
        boolean z = true;
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            a52.b(z, sb.toString());
            G(i);
            z();
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final void h() {
        this.b.lock();
        try {
            this.y.a();
            qr3 qr3Var = this.e;
            if (qr3Var != null) {
                qr3Var.disconnect();
            }
            this.u.a();
            for (b bVar : this.i) {
                bVar.l(null);
                bVar.c();
            }
            this.i.clear();
            if (this.e == null) {
                return;
            }
            B();
            this.d.a();
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.g);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.j);
        printWriter.append(" mWorkQueue.size()=").print(this.i.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.y.a.size());
        qr3 qr3Var = this.e;
        if (qr3Var != null) {
            qr3Var.e(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final b j(b bVar) {
        a52.b(bVar.s() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean zContainsKey = this.p.containsKey(bVar.s());
        String strB = bVar.r() != null ? bVar.r().b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(strB);
        sb.append(" required for this call.");
        a52.b(zContainsKey, sb.toString());
        this.b.lock();
        try {
            if (this.e == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (!this.j) {
                b bVarD = this.e.d(bVar);
                this.b.unlock();
                return bVarD;
            }
            this.i.add(bVar);
            while (!this.i.isEmpty()) {
                b bVar2 = (b) this.i.remove();
                this.y.b(bVar2);
                bVar2.w(Status.i);
            }
            this.b.unlock();
            return bVar;
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final Context l() {
        return this.g;
    }

    @Override // com.google.android.gms.common.api.c
    public final Looper m() {
        return this.h;
    }

    @Override // com.google.android.gms.common.api.c
    public final boolean n() {
        qr3 qr3Var = this.e;
        return qr3Var != null && qr3Var.isConnected();
    }

    @Override // com.google.android.gms.common.api.c
    public final boolean o(wo2 wo2Var) {
        qr3 qr3Var = this.e;
        return qr3Var != null && qr3Var.f(wo2Var);
    }

    @Override // com.google.android.gms.common.api.c
    public final void p() {
        qr3 qr3Var = this.e;
        if (qr3Var != null) {
            qr3Var.g();
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final void q() {
        h();
        f();
    }

    @Override // com.google.android.gms.common.api.c
    public final void r(com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        this.d.g(interfaceC0078c);
    }

    @Override // com.google.android.gms.common.api.c
    public final void s(com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        this.d.h(interfaceC0078c);
    }
}
