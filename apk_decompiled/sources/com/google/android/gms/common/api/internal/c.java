package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import defpackage.a52;
import defpackage.ca;
import defpackage.cs3;
import defpackage.ds3;
import defpackage.e43;
import defpackage.gr3;
import defpackage.qs3;
import defpackage.sr3;
import defpackage.st1;
import defpackage.u03;
import defpackage.u9;
import defpackage.us3;
import defpackage.v03;
import defpackage.vb1;
import defpackage.vs3;
import defpackage.wu0;
import defpackage.x32;
import defpackage.y9;
import defpackage.zr3;
import defpackage.zs3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements Handler.Callback {
    public static final Status m = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status n = new Status(4, "The user must be signed in to make this API call.");
    private static final Object o = new Object();
    private static c p;
    private final Context d;
    private final com.google.android.gms.common.a e;
    private final wu0 f;
    private final Handler l;
    private long a = 5000;
    private long b = 120000;
    private long c = ProtocolConstants.CONNECTION_TIMEOUT_MS;
    private final AtomicInteger g = new AtomicInteger(1);
    private final AtomicInteger h = new AtomicInteger(0);
    private final Map i = new ConcurrentHashMap(5, 0.75f, 1);
    private final Set j = new y9();
    private final Set k = new y9();

    public class a implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.InterfaceC0078c, zs3 {
        private final com.google.android.gms.common.api.a.f d;
        private final com.google.android.gms.common.api.a.b e;
        private final qs3 f;
        private final e g;
        private final int j;
        private final zr3 k;
        private boolean l;
        private final Queue c = new LinkedList();
        private final Set h = new HashSet();
        private final Map i = new HashMap();
        private final List m = new ArrayList();
        private ConnectionResult n = null;

        public a(com.google.android.gms.common.api.b bVar) {
            com.google.android.gms.common.api.a.f fVarH = bVar.h(c.this.l.getLooper(), this);
            this.d = fVarH;
            this.e = fVarH;
            this.f = bVar.k();
            this.g = new e();
            this.j = bVar.f();
            if (fVarH.o()) {
                this.k = bVar.j(c.this.d, c.this.l);
            } else {
                this.k = null;
            }
        }

        private final void A() {
            if (this.l) {
                c.this.l.removeMessages(11, this.f);
                c.this.l.removeMessages(9, this.f);
                this.l = false;
            }
        }

        private final void B() {
            c.this.l.removeMessages(12, this.f);
            c.this.l.sendMessageDelayed(c.this.l.obtainMessage(12, this.f), c.this.c);
        }

        private final void F(z zVar) {
            zVar.d(this.g, h());
            try {
                zVar.c(this);
            } catch (DeadObjectException unused) {
                a(1);
                this.d.disconnect();
            }
        }

        private final boolean G(boolean z) {
            a52.d(c.this.l);
            if (!this.d.isConnected() || this.i.size() != 0) {
                return false;
            }
            if (!this.g.d()) {
                this.d.disconnect();
                return true;
            }
            if (z) {
                B();
            }
            return false;
        }

        private final boolean L(ConnectionResult connectionResult) {
            synchronized (c.o) {
                c.t(c.this);
            }
            return false;
        }

        private final void M(ConnectionResult connectionResult) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                ((us3) it.next()).b(this.f, connectionResult, st1.a(connectionResult, ConnectionResult.e) ? this.d.h() : null);
            }
            this.h.clear();
        }

        private final Feature j(Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] featureArrM = this.d.m();
                if (featureArrM == null) {
                    featureArrM = new Feature[0];
                }
                u9 u9Var = new u9(featureArrM.length);
                for (Feature feature : featureArrM) {
                    u9Var.put(feature.F0(), Long.valueOf(feature.G0()));
                }
                for (Feature feature2 : featureArr) {
                    if (!u9Var.containsKey(feature2.F0()) || ((Long) u9Var.get(feature2.F0())).longValue() < feature2.G0()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(b bVar) {
            if (this.m.contains(bVar) && !this.l) {
                if (this.d.isConnected()) {
                    v();
                } else {
                    e();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r(b bVar) {
            Feature[] featureArrG;
            if (this.m.remove(bVar)) {
                c.this.l.removeMessages(15, bVar);
                c.this.l.removeMessages(16, bVar);
                Feature feature = bVar.b;
                ArrayList arrayList = new ArrayList(this.c.size());
                for (z zVar : this.c) {
                    if ((zVar instanceof n0) && (featureArrG = ((n0) zVar).g(this)) != null && ca.a(featureArrG, feature)) {
                        arrayList.add(zVar);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    z zVar2 = (z) obj;
                    this.c.remove(zVar2);
                    zVar2.e(new UnsupportedApiCallException(feature));
                }
            }
        }

        private final boolean s(z zVar) {
            if (!(zVar instanceof n0)) {
                F(zVar);
                return true;
            }
            n0 n0Var = (n0) zVar;
            Feature featureJ = j(n0Var.g(this));
            if (featureJ == null) {
                F(zVar);
                return true;
            }
            if (!n0Var.h(this)) {
                n0Var.e(new UnsupportedApiCallException(featureJ));
                return false;
            }
            b bVar = new b(this.f, featureJ, null);
            int iIndexOf = this.m.indexOf(bVar);
            if (iIndexOf >= 0) {
                b bVar2 = (b) this.m.get(iIndexOf);
                c.this.l.removeMessages(15, bVar2);
                c.this.l.sendMessageDelayed(Message.obtain(c.this.l, 15, bVar2), c.this.a);
                return false;
            }
            this.m.add(bVar);
            c.this.l.sendMessageDelayed(Message.obtain(c.this.l, 15, bVar), c.this.a);
            c.this.l.sendMessageDelayed(Message.obtain(c.this.l, 16, bVar), c.this.b);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (L(connectionResult)) {
                return false;
            }
            c.this.q(connectionResult, this.j);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t() {
            y();
            M(ConnectionResult.e);
            A();
            Iterator it = this.i.values().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
            v();
            B();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u() {
            y();
            this.l = true;
            this.g.f();
            c.this.l.sendMessageDelayed(Message.obtain(c.this.l, 9, this.f), c.this.a);
            c.this.l.sendMessageDelayed(Message.obtain(c.this.l, 11, this.f), c.this.b);
            c.this.f.a();
        }

        private final void v() {
            ArrayList arrayList = new ArrayList(this.c);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                z zVar = (z) obj;
                if (!this.d.isConnected()) {
                    return;
                }
                if (s(zVar)) {
                    this.c.remove(zVar);
                }
            }
        }

        public final boolean C() {
            return G(true);
        }

        final ds3 D() {
            zr3 zr3Var = this.k;
            if (zr3Var == null) {
                return null;
            }
            return zr3Var.L();
        }

        public final void E(Status status) {
            a52.d(c.this.l);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((z) it.next()).b(status);
            }
            this.c.clear();
        }

        public final void K(ConnectionResult connectionResult) {
            a52.d(c.this.l);
            this.d.disconnect();
            d(connectionResult);
        }

        @Override // com.google.android.gms.common.api.c.b
        public final void a(int i) {
            if (Looper.myLooper() == c.this.l.getLooper()) {
                u();
            } else {
                c.this.l.post(new i0(this));
            }
        }

        @Override // com.google.android.gms.common.api.c.b
        public final void b(Bundle bundle) {
            if (Looper.myLooper() == c.this.l.getLooper()) {
                t();
            } else {
                c.this.l.post(new h0(this));
            }
        }

        @Override // defpackage.zs3
        public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a aVar, boolean z) {
            if (Looper.myLooper() == c.this.l.getLooper()) {
                d(connectionResult);
            } else {
                c.this.l.post(new j0(this, connectionResult));
            }
        }

        @Override // com.google.android.gms.common.api.c.InterfaceC0078c
        public final void d(ConnectionResult connectionResult) {
            a52.d(c.this.l);
            zr3 zr3Var = this.k;
            if (zr3Var != null) {
                zr3Var.M();
            }
            y();
            c.this.f.a();
            M(connectionResult);
            if (connectionResult.F0() == 4) {
                E(c.n);
                return;
            }
            if (this.c.isEmpty()) {
                this.n = connectionResult;
                return;
            }
            if (L(connectionResult) || c.this.q(connectionResult, this.j)) {
                return;
            }
            if (connectionResult.F0() == 18) {
                this.l = true;
            }
            if (this.l) {
                c.this.l.sendMessageDelayed(Message.obtain(c.this.l, 9, this.f), c.this.a);
                return;
            }
            String strC = this.f.c();
            StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 38);
            sb.append("API: ");
            sb.append(strC);
            sb.append(" is not available on this device.");
            E(new Status(17, sb.toString()));
        }

        public final void e() {
            a52.d(c.this.l);
            if (this.d.isConnected() || this.d.isConnecting()) {
                return;
            }
            int iB = c.this.f.b(c.this.d, this.d);
            if (iB != 0) {
                d(new ConnectionResult(iB, null));
                return;
            }
            C0080c c0080c = c.this.new C0080c(this.d, this.f);
            if (this.d.o()) {
                this.k.K(c0080c);
            }
            this.d.i(c0080c);
        }

        public final int f() {
            return this.j;
        }

        final boolean g() {
            return this.d.isConnected();
        }

        public final boolean h() {
            return this.d.o();
        }

        public final void i() {
            a52.d(c.this.l);
            if (this.l) {
                e();
            }
        }

        public final void m(z zVar) {
            a52.d(c.this.l);
            if (this.d.isConnected()) {
                if (s(zVar)) {
                    B();
                    return;
                } else {
                    this.c.add(zVar);
                    return;
                }
            }
            this.c.add(zVar);
            ConnectionResult connectionResult = this.n;
            if (connectionResult == null || !connectionResult.I0()) {
                e();
            } else {
                d(this.n);
            }
        }

        public final void n(us3 us3Var) {
            a52.d(c.this.l);
            this.h.add(us3Var);
        }

        public final com.google.android.gms.common.api.a.f o() {
            return this.d;
        }

        public final void p() {
            a52.d(c.this.l);
            if (this.l) {
                A();
                E(c.this.e.g(c.this.d) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.d.disconnect();
            }
        }

        public final void w() {
            a52.d(c.this.l);
            E(c.m);
            this.g.e();
            for (vb1 vb1Var : (vb1[]) this.i.keySet().toArray(new vb1[this.i.size()])) {
                m(new u0(null, new v03()));
            }
            M(new ConnectionResult(4));
            if (this.d.isConnected()) {
                this.d.j(new k0(this));
            }
        }

        public final Map x() {
            return this.i;
        }

        public final void y() {
            a52.d(c.this.l);
            this.n = null;
        }

        public final ConnectionResult z() {
            a52.d(c.this.l);
            return this.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.c$c, reason: collision with other inner class name */
    class C0080c implements cs3, com.google.android.gms.common.internal.b.c {
        private final com.google.android.gms.common.api.a.f a;
        private final qs3 b;
        private com.google.android.gms.common.internal.f c = null;
        private Set d = null;
        private boolean e = false;

        public C0080c(com.google.android.gms.common.api.a.f fVar, qs3 qs3Var) {
            this.a = fVar;
            this.b = qs3Var;
        }

        static /* synthetic */ boolean e(C0080c c0080c, boolean z) {
            c0080c.e = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            com.google.android.gms.common.internal.f fVar;
            if (!this.e || (fVar = this.c) == null) {
                return;
            }
            this.a.g(fVar, this.d);
        }

        @Override // com.google.android.gms.common.internal.b.c
        public final void a(ConnectionResult connectionResult) {
            c.this.l.post(new m0(this, connectionResult));
        }

        @Override // defpackage.cs3
        public final void b(com.google.android.gms.common.internal.f fVar, Set set) {
            if (fVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                c(new ConnectionResult(4));
            } else {
                this.c = fVar;
                this.d = set;
                g();
            }
        }

        @Override // defpackage.cs3
        public final void c(ConnectionResult connectionResult) {
            ((a) c.this.i.get(this.b)).K(connectionResult);
        }
    }

    private c(Context context, Looper looper, com.google.android.gms.common.a aVar) {
        this.d = context;
        vs3 vs3Var = new vs3(looper, this);
        this.l = vs3Var;
        this.e = aVar;
        this.f = new wu0(aVar);
        vs3Var.sendMessage(vs3Var.obtainMessage(6));
    }

    public static void b() {
        synchronized (o) {
            try {
                c cVar = p;
                if (cVar != null) {
                    cVar.h.incrementAndGet();
                    Handler handler = cVar.l;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static c j(Context context) {
        c cVar;
        synchronized (o) {
            try {
                if (p == null) {
                    HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                    handlerThread.start();
                    p = new c(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.a.n());
                }
                cVar = p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    private final void k(com.google.android.gms.common.api.b bVar) {
        qs3 qs3VarK = bVar.k();
        a aVar = (a) this.i.get(qs3VarK);
        if (aVar == null) {
            aVar = new a(bVar);
            this.i.put(qs3VarK, aVar);
        }
        if (aVar.h()) {
            this.k.add(qs3VarK);
        }
        aVar.e();
    }

    public static c l() {
        c cVar;
        synchronized (o) {
            a52.h(p, "Must guarantee manager is non-null before using getInstance");
            cVar = p;
        }
        return cVar;
    }

    static /* synthetic */ gr3 t(c cVar) {
        cVar.getClass();
        return null;
    }

    final void a() {
        this.h.incrementAndGet();
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(10));
    }

    public final u03 c(Iterable iterable) {
        us3 us3Var = new us3(iterable);
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(2, us3Var));
        return us3Var.a();
    }

    final PendingIntent d(qs3 qs3Var, int i) {
        ds3 ds3VarD;
        a aVar = (a) this.i.get(qs3Var);
        if (aVar == null || (ds3VarD = aVar.D()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.d, i, ds3VarD.n(), 134217728);
    }

    public final void f(ConnectionResult connectionResult, int i) {
        if (q(connectionResult, i)) {
            return;
        }
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    public final void g(com.google.android.gms.common.api.b bVar) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(7, bVar));
    }

    public final void h(com.google.android.gms.common.api.b bVar, int i, com.google.android.gms.common.api.internal.b bVar2) {
        t0 t0Var = new t0(i, bVar2);
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(4, new sr3(t0Var, this.h.get(), bVar)));
    }

    /* JADX WARN: Code duplicated, block: B:43:0x013f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0185  */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        a aVar = null;
        switch (i) {
            case 1:
                this.c = ((Boolean) message.obj).booleanValue() ? ProtocolConstants.CONNECTION_TIMEOUT_MS : 300000L;
                this.l.removeMessages(12);
                for (qs3 qs3Var : this.i.keySet()) {
                    Handler handler = this.l;
                    handler.sendMessageDelayed(handler.obtainMessage(12, qs3Var), this.c);
                }
                return true;
            case 2:
                us3 us3Var = (us3) message.obj;
                for (qs3 qs3Var2 : us3Var.c()) {
                    a aVar2 = (a) this.i.get(qs3Var2);
                    if (aVar2 == null) {
                        us3Var.b(qs3Var2, new ConnectionResult(13), null);
                        return true;
                    }
                    if (aVar2.g()) {
                        us3Var.b(qs3Var2, ConnectionResult.e, aVar2.o().h());
                    } else if (aVar2.z() != null) {
                        us3Var.b(qs3Var2, aVar2.z(), null);
                    } else {
                        aVar2.n(us3Var);
                        aVar2.e();
                    }
                }
                return true;
            case 3:
                for (a aVar3 : this.i.values()) {
                    aVar3.y();
                    aVar3.e();
                }
                return true;
            case 4:
            case 8:
            case 13:
                sr3 sr3Var = (sr3) message.obj;
                a aVar4 = (a) this.i.get(sr3Var.c.k());
                if (aVar4 == null) {
                    k(sr3Var.c);
                    aVar4 = (a) this.i.get(sr3Var.c.k());
                }
                if (!aVar4.h() || this.h.get() == sr3Var.b) {
                    aVar4.m(sr3Var.a);
                } else {
                    sr3Var.a.b(m);
                    aVar4.w();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (a aVar5 : this.i.values()) {
                    if (aVar5.f() == i2) {
                        aVar = aVar5;
                        if (aVar != null) {
                            String strF = this.e.f(connectionResult.F0());
                            String strG0 = connectionResult.G0();
                            StringBuilder sb = new StringBuilder(String.valueOf(strF).length() + 69 + String.valueOf(strG0).length());
                            sb.append("Error resolution was canceled by the user, original error message: ");
                            sb.append(strF);
                            sb.append(": ");
                            sb.append(strG0);
                            aVar.E(new Status(17, sb.toString()));
                        } else {
                            StringBuilder sb2 = new StringBuilder(76);
                            sb2.append("Could not find API instance ");
                            sb2.append(i2);
                            sb2.append(" while trying to fail enqueued calls.");
                            Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                        }
                        return true;
                    }
                }
                if (aVar != null) {
                    String strF2 = this.e.f(connectionResult.F0());
                    String strG1 = connectionResult.G0();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(strF2).length() + 69 + String.valueOf(strG1).length());
                    sb3.append("Error resolution was canceled by the user, original error message: ");
                    sb3.append(strF2);
                    sb3.append(": ");
                    sb3.append(strG1);
                    aVar.E(new Status(17, sb3.toString()));
                } else {
                    StringBuilder sb4 = new StringBuilder(76);
                    sb4.append("Could not find API instance ");
                    sb4.append(i2);
                    sb4.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb4.toString(), new Exception());
                }
                return true;
            case 6:
                if (x32.a() && (this.d.getApplicationContext() instanceof Application)) {
                    com.google.android.gms.common.api.internal.a.c((Application) this.d.getApplicationContext());
                    com.google.android.gms.common.api.internal.a.b().a(new g0(this));
                    if (!com.google.android.gms.common.api.internal.a.b().e(true)) {
                        this.c = 300000L;
                    }
                }
                return true;
            case 7:
                k((com.google.android.gms.common.api.b) message.obj);
                return true;
            case 9:
                if (this.i.containsKey(message.obj)) {
                    ((a) this.i.get(message.obj)).i();
                }
                return true;
            case 10:
                Iterator it = this.k.iterator();
                while (it.hasNext()) {
                    ((a) this.i.remove((qs3) it.next())).w();
                }
                this.k.clear();
                return true;
            case 11:
                if (this.i.containsKey(message.obj)) {
                    ((a) this.i.get(message.obj)).p();
                }
                return true;
            case 12:
                if (this.i.containsKey(message.obj)) {
                    ((a) this.i.get(message.obj)).C();
                }
                return true;
            case 14:
                e43.a(message.obj);
                throw null;
            case 15:
                b bVar = (b) message.obj;
                if (this.i.containsKey(bVar.a)) {
                    ((a) this.i.get(bVar.a)).l(bVar);
                }
                return true;
            case 16:
                b bVar2 = (b) message.obj;
                if (this.i.containsKey(bVar2.a)) {
                    ((a) this.i.get(bVar2.a)).r(bVar2);
                }
                return true;
            default:
                StringBuilder sb5 = new StringBuilder(31);
                sb5.append("Unknown message id: ");
                sb5.append(i);
                Log.w("GoogleApiManager", sb5.toString());
                return false;
        }
    }

    public final int m() {
        return this.g.getAndIncrement();
    }

    final boolean q(ConnectionResult connectionResult, int i) {
        return this.e.x(this.d, connectionResult, i);
    }

    public final void x() {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(3));
    }

    private static class b {
        private final qs3 a;
        private final Feature b;

        private b(qs3 qs3Var, Feature feature) {
            this.a = qs3Var;
            this.b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (st1.a(this.a, bVar.a) && st1.a(this.b, bVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return st1.b(this.a, this.b);
        }

        public final String toString() {
            return st1.c(this).a("key", this.a).a("feature", this.b).toString();
        }

        /* synthetic */ b(qs3 qs3Var, Feature feature, g0 g0Var) {
            this(qs3Var, feature);
        }
    }
}
