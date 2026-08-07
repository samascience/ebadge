package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.a52;
import defpackage.di2;
import defpackage.gy0;
import defpackage.h00;
import defpackage.ou3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private int a;
    private long b;
    private long c;
    private int d;
    private long e;
    b0 g;
    private final Context h;
    private final Looper i;
    private final com.google.android.gms.common.internal.e j;
    private final com.google.android.gms.common.b k;
    final Handler l;
    private gy0 o;
    protected c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private IInterface f244q;
    private s s;
    private final a u;
    private final InterfaceC0081b v;
    private final int w;
    private final String x;
    private volatile String y;
    private static final Feature[] E = new Feature[0];
    public static final String[] D = {"service_esmobile", "service_googleme"};
    private volatile String f = null;
    private final Object m = new Object();
    private final Object n = new Object();
    private final ArrayList r = new ArrayList();
    private int t = 1;
    private ConnectionResult z = null;
    private boolean A = false;
    private volatile zzj B = null;
    protected AtomicInteger C = new AtomicInteger(0);

    public interface a {
        void a(int i);

        void b(Bundle bundle);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.b$b, reason: collision with other inner class name */
    public interface InterfaceC0081b {
        void d(ConnectionResult connectionResult);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    protected class d implements c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.b.c
        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.J0()) {
                b bVar = b.this;
                bVar.g(null, bVar.z());
            } else if (b.this.v != null) {
                b.this.v.d(connectionResult);
            }
        }
    }

    public interface e {
        void a();
    }

    protected b(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, com.google.android.gms.common.b bVar, int i, a aVar, InterfaceC0081b interfaceC0081b, String str) {
        a52.h(context, "Context must not be null");
        this.h = context;
        a52.h(looper, "Looper must not be null");
        this.i = looper;
        a52.h(eVar, "Supervisor must not be null");
        this.j = eVar;
        a52.h(bVar, "API availability must not be null");
        this.k = bVar;
        this.l = new p(this, looper);
        this.w = i;
        this.u = aVar;
        this.v = interfaceC0081b;
        this.x = str;
    }

    static /* bridge */ /* synthetic */ void V(b bVar, zzj zzjVar) {
        bVar.B = zzjVar;
        if (bVar.L()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.d;
            di2.a().b(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.K0());
        }
    }

    static /* bridge */ /* synthetic */ void W(b bVar, int i) {
        int i2;
        int i3;
        synchronized (bVar.m) {
            i2 = bVar.t;
        }
        if (i2 == 3) {
            bVar.A = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = bVar.l;
        handler.sendMessage(handler.obtainMessage(i3, bVar.C.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean Z(b bVar, int i, int i2, IInterface iInterface) {
        synchronized (bVar.m) {
            try {
                if (bVar.t != i) {
                    return false;
                }
                bVar.b0(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean a0(b bVar) {
        if (bVar.A || TextUtils.isEmpty(bVar.B()) || TextUtils.isEmpty(bVar.y())) {
            return false;
        }
        try {
            Class.forName(bVar.B());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(int i, IInterface iInterface) {
        b0 b0Var;
        a52.a((i == 4) == (iInterface != null));
        synchronized (this.m) {
            try {
                this.t = i;
                this.f244q = iInterface;
                if (i == 1) {
                    s sVar = this.s;
                    if (sVar != null) {
                        com.google.android.gms.common.internal.e eVar = this.j;
                        String strC = this.g.c();
                        a52.g(strC);
                        eVar.e(strC, this.g.b(), this.g.a(), sVar, Q(), this.g.d());
                        this.s = null;
                    }
                } else if (i == 2 || i == 3) {
                    s sVar2 = this.s;
                    if (sVar2 != null && (b0Var = this.g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + b0Var.c() + " on " + b0Var.b());
                        com.google.android.gms.common.internal.e eVar2 = this.j;
                        String strC2 = this.g.c();
                        a52.g(strC2);
                        eVar2.e(strC2, this.g.b(), this.g.a(), sVar2, Q(), this.g.d());
                        this.C.incrementAndGet();
                    }
                    s sVar3 = new s(this, this.C.get());
                    this.s = sVar3;
                    b0 b0Var2 = (this.t != 3 || y() == null) ? new b0(D(), C(), false, com.google.android.gms.common.internal.e.a(), E()) : new b0(w().getPackageName(), y(), true, com.google.android.gms.common.internal.e.a(), false);
                    this.g = b0Var2;
                    if (b0Var2.d() && l() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.g.c())));
                    }
                    com.google.android.gms.common.internal.e eVar3 = this.j;
                    String strC3 = this.g.c();
                    a52.g(strC3);
                    if (!eVar3.f(new ou3(strC3, this.g.b(), this.g.a(), this.g.d()), sVar3, Q(), v())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.g.c() + " on " + this.g.b());
                        X(16, null, this.C.get());
                    }
                } else if (i == 4) {
                    a52.g(iInterface);
                    F(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final IInterface A() {
        IInterface iInterface;
        synchronized (this.m) {
            try {
                if (this.t == 5) {
                    throw new DeadObjectException();
                }
                q();
                iInterface = this.f244q;
                a52.h(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    protected abstract String B();

    protected abstract String C();

    protected String D() {
        return "com.google.android.gms";
    }

    protected boolean E() {
        return l() >= 211700000;
    }

    protected void F(IInterface iInterface) {
        this.c = System.currentTimeMillis();
    }

    protected void G(ConnectionResult connectionResult) {
        this.d = connectionResult.F0();
        this.e = System.currentTimeMillis();
    }

    protected void H(int i) {
        this.a = i;
        this.b = System.currentTimeMillis();
    }

    protected void I(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new t(this, i, iBinder, bundle)));
    }

    public boolean J() {
        return false;
    }

    public void K(int i) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i));
    }

    public boolean L() {
        return false;
    }

    protected final String Q() {
        String str = this.x;
        return str == null ? this.h.getClass().getName() : str;
    }

    protected final void X(int i, Bundle bundle, int i2) {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new u(this, i, null)));
    }

    public Bundle d() {
        return null;
    }

    public void disconnect() {
        this.C.incrementAndGet();
        synchronized (this.r) {
            try {
                int size = this.r.size();
                for (int i = 0; i < size; i++) {
                    ((q) this.r.get(i)).d();
                }
                this.r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.n) {
            this.o = null;
        }
        b0(1, null);
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        gy0 gy0Var;
        synchronized (this.m) {
            i = this.t;
            iInterface = this.f244q;
        }
        synchronized (this.n) {
            gy0Var = this.o;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) B()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (gy0Var == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(gy0Var.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS, Locale.US);
        if (this.c > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.c;
            printWriterAppend.println(j + " " + simpleDateFormat.format(new Date(j)));
        }
        if (this.b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.a;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((CharSequence) String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.b;
            printWriterAppend2.println(j2 + " " + simpleDateFormat.format(new Date(j2)));
        }
        if (this.e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) h00.a(this.d));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j3 = this.e;
            printWriterAppend3.println(j3 + " " + simpleDateFormat.format(new Date(j3)));
        }
    }

    public boolean f() {
        return false;
    }

    public void g(f fVar, Set set) {
        Bundle bundleX = x();
        int i = this.w;
        String str = this.y;
        int i2 = com.google.android.gms.common.b.a;
        Scope[] scopeArr = GetServiceRequest.o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i, i2, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.d = this.h.getPackageName();
        getServiceRequest.g = bundleX;
        if (set != null) {
            getServiceRequest.f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (o()) {
            Account accountT = t();
            if (accountT == null) {
                accountT = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.h = accountT;
            if (fVar != null) {
                getServiceRequest.e = fVar.asBinder();
            }
        } else if (J()) {
            getServiceRequest.h = t();
        }
        getServiceRequest.i = E;
        getServiceRequest.j = u();
        if (L()) {
            getServiceRequest.m = true;
        }
        try {
            synchronized (this.n) {
                try {
                    gy0 gy0Var = this.o;
                    if (gy0Var != null) {
                        gy0Var.q(new r(this, this.C.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            K(3);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            I(8, null, null, this.C.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            I(8, null, null, this.C.get());
        }
    }

    public String h() {
        b0 b0Var;
        if (!isConnected() || (b0Var = this.g) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return b0Var.b();
    }

    public void i(c cVar) {
        a52.h(cVar, "Connection progress callbacks cannot be null.");
        this.p = cVar;
        b0(2, null);
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.m) {
            z = this.t == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.m) {
            int i = this.t;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public void j(e eVar) {
        eVar.a();
    }

    public boolean k() {
        return true;
    }

    public int l() {
        return com.google.android.gms.common.b.a;
    }

    public final Feature[] m() {
        zzj zzjVar = this.B;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.b;
    }

    public Intent n() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public boolean o() {
        return false;
    }

    public IBinder p() {
        synchronized (this.n) {
            try {
                gy0 gy0Var = this.o;
                if (gy0Var == null) {
                    return null;
                }
                return gy0Var.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void q() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract IInterface r(IBinder iBinder);

    protected boolean s() {
        return false;
    }

    public abstract Account t();

    public Feature[] u() {
        return E;
    }

    protected Executor v() {
        return null;
    }

    public final Context w() {
        return this.h;
    }

    protected Bundle x() {
        return new Bundle();
    }

    protected String y() {
        return null;
    }

    protected abstract Set z();
}
