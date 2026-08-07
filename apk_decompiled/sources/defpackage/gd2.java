package defpackage;

import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.j;
import okhttp3.CertificatePinner;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class gd2 implements eq {
    private final zt1 a;
    private final df2 b;
    private final boolean c;
    private final hd2 d;
    private final fi0 e;
    private final c f;
    private final AtomicBoolean g;
    private Object h;
    private si0 i;
    private RealConnection j;
    private boolean k;
    private qi0 l;
    private boolean m;
    private boolean n;
    private boolean o;
    private volatile boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile qi0 f337q;
    private volatile RealConnection r;

    public final class a implements Runnable {
        private final gq a;
        private volatile AtomicInteger b;
        final /* synthetic */ gd2 c;

        public a(gd2 gd2Var, gq gqVar) {
            p31.f(gqVar, "responseCallback");
            this.c = gd2Var;
            this.a = gqVar;
            this.b = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            p31.f(executorService, "executorService");
            hc0 hc0VarO = this.c.j().o();
            if (pa3.h && Thread.holdsLock(hc0VarO)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + hc0VarO);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.c.t(interruptedIOException);
                    this.a.onFailure(this.c, interruptedIOException);
                    this.c.j().o().f(this);
                }
            } catch (Throwable th) {
                this.c.j().o().f(this);
                throw th;
            }
        }

        public final gd2 b() {
            return this.c;
        }

        public final AtomicInteger c() {
            return this.b;
        }

        public final String d() {
            return this.c.p().i().h();
        }

        public final void e(a aVar) {
            p31.f(aVar, "other");
            this.b = aVar.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Throwable th;
            IOException e;
            hc0 hc0VarO;
            String str = "OkHttp " + this.c.u();
            gd2 gd2Var = this.c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                gd2Var.f.v();
                try {
                    try {
                        z = true;
                        try {
                            this.a.onResponse(gd2Var, gd2Var.q());
                            hc0VarO = gd2Var.j().o();
                        } catch (IOException e2) {
                            e = e2;
                            if (z) {
                                r32.a.g().j("Callback failure for " + gd2Var.A(), 4, e);
                            } else {
                                this.a.onFailure(gd2Var, e);
                            }
                            hc0VarO = gd2Var.j().o();
                        } catch (Throwable th2) {
                            th = th2;
                            gd2Var.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                oi0.a(iOException, th);
                                this.a.onFailure(gd2Var, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        gd2Var.j().o().f(this);
                        throw th3;
                    }
                } catch (IOException e3) {
                    z = false;
                    e = e3;
                } catch (Throwable th4) {
                    z = false;
                    th = th4;
                }
                hc0VarO.f(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th5) {
                threadCurrentThread.setName(name);
                throw th5;
            }
        }
    }

    public static final class b extends WeakReference {
        private final Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gd2 gd2Var, Object obj) {
            super(gd2Var);
            p31.f(gd2Var, "referent");
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }
    }

    public static final class c extends bb {
        c() {
        }

        @Override // defpackage.bb
        protected void B() {
            gd2.this.cancel();
        }
    }

    public gd2(zt1 zt1Var, df2 df2Var, boolean z) {
        p31.f(zt1Var, "client");
        p31.f(df2Var, "originalRequest");
        this.a = zt1Var;
        this.b = df2Var;
        this.c = z;
        this.d = zt1Var.k().a();
        this.e = zt1Var.q().a(this);
        c cVar = new c();
        cVar.g(zt1Var.g(), TimeUnit.MILLISECONDS);
        this.f = cVar;
        this.g = new AtomicBoolean();
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String A() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : Constants.STR_EMPTY);
        sb.append(this.c ? "web socket" : "call");
        sb.append(" to ");
        sb.append(u());
        return sb.toString();
    }

    private final IOException d(IOException iOException) {
        Socket socketV;
        boolean z = pa3.h;
        if (z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        RealConnection realConnection = this.j;
        if (realConnection != null) {
            if (z && Thread.holdsLock(realConnection)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
            }
            synchronized (realConnection) {
                socketV = v();
            }
            if (this.j == null) {
                if (socketV != null) {
                    pa3.n(socketV);
                }
                this.e.k(this, realConnection);
            } else if (socketV != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        IOException iOExceptionZ = z(iOException);
        if (iOException != null) {
            fi0 fi0Var = this.e;
            p31.c(iOExceptionZ);
            fi0Var.d(this, iOExceptionZ);
        } else {
            this.e.c(this);
        }
        return iOExceptionZ;
    }

    private final void e() {
        this.h = r32.a.g().h("response.body().close()");
        this.e.e(this);
    }

    private final v4 g(tx0 tx0Var) {
        SSLSocketFactory sSLSocketFactoryI;
        HostnameVerifier hostnameVerifierU;
        CertificatePinner certificatePinnerI;
        if (tx0Var.i()) {
            sSLSocketFactoryI = this.a.I();
            hostnameVerifierU = this.a.u();
            certificatePinnerI = this.a.i();
        } else {
            sSLSocketFactoryI = null;
            hostnameVerifierU = null;
            certificatePinnerI = null;
        }
        return new v4(tx0Var.h(), tx0Var.n(), this.a.p(), this.a.H(), sSLSocketFactoryI, hostnameVerifierU, certificatePinnerI, this.a.D(), this.a.C(), this.a.B(), this.a.l(), this.a.E());
    }

    private final IOException z(IOException iOException) {
        if (this.k || !this.f.w()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void c(RealConnection realConnection) {
        p31.f(realConnection, "connection");
        if (!pa3.h || Thread.holdsLock(realConnection)) {
            if (this.j != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.j = realConnection;
            realConnection.o().add(new b(this, this.h));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    @Override // defpackage.eq
    public void cancel() {
        if (this.p) {
            return;
        }
        this.p = true;
        qi0 qi0Var = this.f337q;
        if (qi0Var != null) {
            qi0Var.b();
        }
        RealConnection realConnection = this.r;
        if (realConnection != null) {
            realConnection.e();
        }
        this.e.f(this);
    }

    @Override // defpackage.eq
    public eh2 execute() {
        if (!this.g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.f.v();
        e();
        try {
            this.a.o().b(this);
            return q();
        } finally {
            this.a.o().g(this);
        }
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public gd2 clone() {
        return new gd2(this.a, this.b, this.c);
    }

    public final void h(df2 df2Var, boolean z) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        if (this.l != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.n) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
            if (this.m) {
                throw new IllegalStateException("Check failed.");
            }
            k83 k83Var = k83.a;
        }
        if (z) {
            this.i = new si0(this.d, g(df2Var.i()), this, this.e);
        }
    }

    public final void i(boolean z) {
        qi0 qi0Var;
        synchronized (this) {
            if (!this.o) {
                throw new IllegalStateException("released");
            }
            k83 k83Var = k83.a;
        }
        if (z && (qi0Var = this.f337q) != null) {
            qi0Var.d();
        }
        this.l = null;
    }

    @Override // defpackage.eq
    public boolean isCanceled() {
        return this.p;
    }

    public final zt1 j() {
        return this.a;
    }

    public final RealConnection k() {
        return this.j;
    }

    public final fi0 l() {
        return this.e;
    }

    public final boolean m() {
        return this.c;
    }

    @Override // defpackage.eq
    public void n(gq gqVar) {
        p31.f(gqVar, "responseCallback");
        if (!this.g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        e();
        this.a.o().a(new a(this, gqVar));
    }

    public final qi0 o() {
        return this.l;
    }

    public final df2 p() {
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009d  */
    public final eh2 q() throws Throwable {
        ArrayList arrayList = new ArrayList();
        j.w(arrayList, this.a.v());
        arrayList.add(new ph2(this.a));
        arrayList.add(new pn(this.a.m()));
        this.a.f();
        arrayList.add(new up(null));
        arrayList.add(n10.a);
        if (!this.c) {
            j.w(arrayList, this.a.x());
        }
        arrayList.add(new fq(this.c));
        boolean z = false;
        try {
            eh2 eh2VarA = new jd2(this, arrayList, 0, null, this.b, this.a.j(), this.a.F(), this.a.K()).a(this.b);
            if (isCanceled()) {
                pa3.m(eh2VarA);
                throw new IOException("Canceled");
            }
            t(null);
            return eh2VarA;
        } catch (IOException e) {
            try {
                IOException iOExceptionT = t(e);
                p31.d(iOExceptionT, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionT;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    t(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                t(null);
            }
            throw th;
        }
    }

    public final qi0 r(jd2 jd2Var) throws IOException {
        p31.f(jd2Var, "chain");
        synchronized (this) {
            if (!this.o) {
                throw new IllegalStateException("released");
            }
            if (this.n) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.m) {
                throw new IllegalStateException("Check failed.");
            }
            k83 k83Var = k83.a;
        }
        si0 si0Var = this.i;
        p31.c(si0Var);
        qi0 qi0Var = new qi0(this, this.e, si0Var, si0Var.a(this.a, jd2Var));
        this.l = qi0Var;
        this.f337q = qi0Var;
        synchronized (this) {
            this.m = true;
            this.n = true;
        }
        if (this.p) {
            throw new IOException("Canceled");
        }
        return qi0Var;
    }

    @Override // defpackage.eq
    public df2 request() {
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final IOException s(qi0 qi0Var, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        p31.f(qi0Var, "exchange");
        if (!p31.a(qi0Var, this.f337q)) {
            return iOException;
        }
        synchronized (this) {
            z3 = false;
            if (z) {
                try {
                    if (this.m) {
                        if (z) {
                            this.m = false;
                        }
                        if (z2) {
                            this.n = false;
                        }
                        z5 = this.m;
                        if (z5) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        if (!z5) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                    } else if (z2 || !this.n) {
                        z4 = false;
                    } else {
                        if (z) {
                            this.m = false;
                        }
                        if (z2) {
                            this.n = false;
                        }
                        z5 = this.m;
                        if (z5 || this.n) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (!z5 && !this.n && !this.o) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z2) {
                }
                z4 = false;
            }
            k83 k83Var = k83.a;
        }
        if (z3) {
            this.f337q = null;
            RealConnection realConnection = this.j;
            if (realConnection != null) {
                realConnection.t();
            }
        }
        return z4 ? d(iOException) : iOException;
    }

    public final IOException t(IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.o) {
                    this.o = false;
                    if (!this.m && !this.n) {
                        z = true;
                    }
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z ? d(iOException) : iOException;
    }

    public final String u() {
        return this.b.i().p();
    }

    public final Socket v() {
        RealConnection realConnection = this.j;
        p31.c(realConnection);
        if (pa3.h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List listO = realConnection.o();
        Iterator it = listO.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (p31.a(((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.");
        }
        listO.remove(i);
        this.j = null;
        if (listO.isEmpty()) {
            realConnection.D(System.nanoTime());
            if (this.d.c(realConnection)) {
                return realConnection.F();
            }
        }
        return null;
    }

    public final boolean w() {
        si0 si0Var = this.i;
        p31.c(si0Var);
        return si0Var.e();
    }

    public final void x(RealConnection realConnection) {
        this.r = realConnection;
    }

    public final void y() {
        if (this.k) {
            throw new IllegalStateException("Check failed.");
        }
        this.k = true;
        this.f.w();
    }
}
