package okhttp3.internal.connection;

import defpackage.b13;
import defpackage.df2;
import defpackage.eh2;
import defpackage.eq;
import defpackage.fi0;
import defpackage.gd2;
import defpackage.gx0;
import defpackage.h33;
import defpackage.hd2;
import defpackage.hu1;
import defpackage.ix0;
import defpackage.jd2;
import defpackage.jx0;
import defpackage.ki2;
import defpackage.md2;
import defpackage.nn2;
import defpackage.p10;
import defpackage.p31;
import defpackage.pa3;
import defpackage.qi0;
import defpackage.r32;
import defpackage.ri0;
import defpackage.ro;
import defpackage.so;
import defpackage.tx0;
import defpackage.u10;
import defpackage.v4;
import defpackage.y70;
import defpackage.yq0;
import defpackage.yt1;
import defpackage.yw;
import defpackage.zt1;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.j;
import kotlin.text.i;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: loaded from: classes4.dex */
public final class RealConnection extends okhttp3.internal.http2.b.c implements p10 {
    public static final a t = new a(null);
    private final hd2 c;
    private final ki2 d;
    private Socket e;
    private Socket f;
    private Handshake g;
    private Protocol h;
    private okhttp3.internal.http2.b i;
    private so j;
    private ro k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f367q;
    private final List r;
    private long s;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final class c extends md2.d {
        final /* synthetic */ qi0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(so soVar, ro roVar, qi0 qi0Var) {
            super(true, soVar, roVar);
            this.d = qi0Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.d.a(-1L, true, true, null);
        }
    }

    public RealConnection(hd2 hd2Var, ki2 ki2Var) {
        p31.f(hd2Var, "connectionPool");
        p31.f(ki2Var, "route");
        this.c = hd2Var;
        this.d = ki2Var;
        this.f367q = 1;
        this.r = new ArrayList();
        this.s = Long.MAX_VALUE;
    }

    private final boolean C(List list) {
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ki2 ki2Var = (ki2) it.next();
            Proxy.Type type = ki2Var.b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.d.b().type() == type2 && p31.a(this.d.d(), ki2Var.d())) {
                return true;
            }
        }
        return false;
    }

    private final void G(int i) throws SocketException {
        Socket socket = this.f;
        p31.c(socket);
        so soVar = this.j;
        p31.c(soVar);
        ro roVar = this.k;
        p31.c(roVar);
        socket.setSoTimeout(0);
        okhttp3.internal.http2.b bVarA = new okhttp3.internal.http2.b.a(true, b13.i).q(socket, this.d.a().l().h(), soVar, roVar).k(this).l(i).a();
        this.i = bVarA;
        this.f367q = okhttp3.internal.http2.b.H.a().d();
        okhttp3.internal.http2.b.h1(bVarA, false, null, 3, null);
    }

    private final boolean H(tx0 tx0Var) {
        Handshake handshake;
        if (pa3.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        tx0 tx0VarL = this.d.a().l();
        if (tx0Var.n() != tx0VarL.n()) {
            return false;
        }
        if (p31.a(tx0Var.h(), tx0VarL.h())) {
            return true;
        }
        if (this.m || (handshake = this.g) == null) {
            return false;
        }
        p31.c(handshake);
        return f(tx0Var, handshake);
    }

    private final boolean f(tx0 tx0Var, Handshake handshake) {
        List listD = handshake.d();
        if (listD.isEmpty()) {
            return false;
        }
        yt1 yt1Var = yt1.a;
        String strH = tx0Var.h();
        Object obj = listD.get(0);
        p31.d(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        return yt1Var.e(strH, (X509Certificate) obj);
    }

    private final void i(int i, int i2, eq eqVar, fi0 fi0Var) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.d.b();
        v4 v4VarA = this.d.a();
        Proxy.Type type = proxyB.type();
        int i3 = type == null ? -1 : b.a[type.ordinal()];
        if (i3 == 1 || i3 == 2) {
            socketCreateSocket = v4VarA.j().createSocket();
            p31.c(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxyB);
        }
        this.e = socketCreateSocket;
        fi0Var.i(eqVar, this.d.d(), proxyB);
        socketCreateSocket.setSoTimeout(i2);
        try {
            r32.a.g().f(socketCreateSocket, this.d.d(), i);
            try {
                this.j = hu1.b(hu1.g(socketCreateSocket));
                this.k = hu1.a(hu1.d(socketCreateSocket));
            } catch (NullPointerException e) {
                if (p31.a(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.d.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void j(u10 u10Var) throws Throwable {
        final v4 v4VarA = this.d.a();
        SSLSocketFactory sSLSocketFactoryK = v4VarA.k();
        SSLSocket sSLSocket = null;
        try {
            p31.c(sSLSocketFactoryK);
            Socket socketCreateSocket = sSLSocketFactoryK.createSocket(this.e, v4VarA.l().h(), v4VarA.l().n(), true);
            p31.d(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                okhttp3.b bVarA = u10Var.a(sSLSocket2);
                if (bVarA.h()) {
                    r32.a.g().e(sSLSocket2, v4VarA.l().h(), v4VarA.f());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.e;
                p31.e(session, "sslSocketSession");
                final Handshake handshakeA = companion.a(session);
                HostnameVerifier hostnameVerifierE = v4VarA.e();
                p31.c(hostnameVerifierE);
                if (hostnameVerifierE.verify(v4VarA.l().h(), session)) {
                    final CertificatePinner certificatePinnerA = v4VarA.a();
                    p31.c(certificatePinnerA);
                    this.g = new Handshake(handshakeA.e(), handshakeA.a(), handshakeA.c(), new yq0() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // defpackage.yq0
                        public final List<Certificate> invoke() {
                            yw ywVarD = certificatePinnerA.d();
                            p31.c(ywVarD);
                            return ywVarD.a(handshakeA.d(), v4VarA.l().h());
                        }
                    });
                    certificatePinnerA.b(v4VarA.l().h(), new yq0() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                        {
                            super(0);
                        }

                        @Override // defpackage.yq0
                        public final List<X509Certificate> invoke() {
                            Handshake handshake = this.this$0.g;
                            p31.c(handshake);
                            List<Certificate> listD = handshake.d();
                            ArrayList arrayList = new ArrayList(j.t(listD, 10));
                            for (Certificate certificate : listD) {
                                p31.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                                arrayList.add((X509Certificate) certificate);
                            }
                            return arrayList;
                        }
                    });
                    String strG = bVarA.h() ? r32.a.g().g(sSLSocket2) : null;
                    this.f = sSLSocket2;
                    this.j = hu1.b(hu1.g(sSLSocket2));
                    this.k = hu1.a(hu1.d(sSLSocket2));
                    this.h = strG != null ? Protocol.Companion.a(strG) : Protocol.HTTP_1_1;
                    r32.a.g().b(sSLSocket2);
                    return;
                }
                List listD = handshakeA.d();
                if (listD.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + v4VarA.l().h() + " not verified (no certificates)");
                }
                Object obj = listD.get(0);
                p31.d(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate x509Certificate = (X509Certificate) obj;
                throw new SSLPeerUnverifiedException(i.l("\n              |Hostname " + v4VarA.l().h() + " not verified:\n              |    certificate: " + CertificatePinner.c.a(x509Certificate) + "\n              |    DN: " + x509Certificate.getSubjectDN().getName() + "\n              |    subjectAltNames: " + yt1.a.a(x509Certificate) + "\n              ", null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    r32.a.g().b(sSLSocket);
                }
                if (sSLSocket != null) {
                    pa3.n(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void k(int i, int i2, int i3, eq eqVar, fi0 fi0Var) throws IOException {
        df2 df2VarM = m();
        tx0 tx0VarI = df2VarM.i();
        for (int i4 = 0; i4 < 21; i4++) {
            i(i, i2, eqVar, fi0Var);
            df2VarM = l(i2, i3, df2VarM, tx0VarI);
            if (df2VarM == null) {
                return;
            }
            Socket socket = this.e;
            if (socket != null) {
                pa3.n(socket);
            }
            this.e = null;
            this.k = null;
            this.j = null;
            fi0Var.g(eqVar, this.d.d(), this.d.b(), null);
        }
    }

    private final df2 l(int i, int i2, df2 df2Var, tx0 tx0Var) throws IOException {
        String str = "CONNECT " + pa3.S(tx0Var, true) + " HTTP/1.1";
        while (true) {
            so soVar = this.j;
            p31.c(soVar);
            ro roVar = this.k;
            p31.c(roVar);
            gx0 gx0Var = new gx0(null, this, soVar, roVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            soVar.timeout().g(i, timeUnit);
            roVar.timeout().g(i2, timeUnit);
            gx0Var.A(df2Var.e(), str);
            gx0Var.c();
            eh2.a aVarF = gx0Var.f(false);
            p31.c(aVarF);
            eh2 eh2VarC = aVarF.r(df2Var).c();
            gx0Var.z(eh2VarC);
            int iC = eh2VarC.C();
            if (iC == 200) {
                if (soVar.b().H() && roVar.b().H()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iC != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + eh2VarC.C());
            }
            df2 df2VarA = this.d.a().h().a(this.d, eh2VarC);
            if (df2VarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (i.v("close", eh2.g0(eh2VarC, "Connection", null, 2, null), true)) {
                return df2VarA;
            }
            df2Var = df2VarA;
        }
    }

    private final df2 m() {
        df2 df2VarB = new df2.a().l(this.d.a().l()).i("CONNECT", null).g("Host", pa3.S(this.d.a().l(), true)).g("Proxy-Connection", "Keep-Alive").g("User-Agent", "okhttp/4.12.0").b();
        df2 df2VarA = this.d.a().h().a(this.d, new eh2.a().r(df2VarB).p(Protocol.HTTP_1_1).g(407).m("Preemptive Authenticate").b(pa3.c).s(-1L).q(-1L).j("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return df2VarA == null ? df2VarB : df2VarA;
    }

    private final void n(u10 u10Var, int i, eq eqVar, fi0 fi0Var) throws Throwable {
        if (this.d.a().k() != null) {
            fi0Var.B(eqVar);
            j(u10Var);
            fi0Var.A(eqVar, this.g);
            if (this.h == Protocol.HTTP_2) {
                G(i);
                return;
            }
            return;
        }
        List listF = this.d.a().f();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(protocol)) {
            this.f = this.e;
            this.h = Protocol.HTTP_1_1;
        } else {
            this.f = this.e;
            this.h = protocol;
            G(i);
        }
    }

    public final synchronized void A() {
        this.l = true;
    }

    public ki2 B() {
        return this.d;
    }

    public final void D(long j) {
        this.s = j;
    }

    public final void E(boolean z) {
        this.l = z;
    }

    public Socket F() {
        Socket socket = this.f;
        p31.c(socket);
        return socket;
    }

    public final synchronized void I(gd2 gd2Var, IOException iOException) {
        try {
            p31.f(gd2Var, "call");
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.p + 1;
                    this.p = i;
                    if (i > 1) {
                        this.l = true;
                        this.n++;
                    }
                } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !gd2Var.isCanceled()) {
                    this.l = true;
                    this.n++;
                }
            } else if (!w() || (iOException instanceof ConnectionShutdownException)) {
                this.l = true;
                if (this.o == 0) {
                    if (iOException != null) {
                        h(gd2Var.j(), this.d, iOException);
                    }
                    this.n++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.p10
    public Protocol a() {
        Protocol protocol = this.h;
        p31.c(protocol);
        return protocol;
    }

    @Override // okhttp3.internal.http2.b.c
    public synchronized void b(okhttp3.internal.http2.b bVar, nn2 nn2Var) {
        p31.f(bVar, "connection");
        p31.f(nn2Var, "settings");
        this.f367q = nn2Var.d();
    }

    @Override // okhttp3.internal.http2.b.c
    public void c(jx0 jx0Var) {
        p31.f(jx0Var, "stream");
        jx0Var.d(ErrorCode.REFUSED_STREAM, null);
    }

    public final void e() {
        Socket socket = this.e;
        if (socket != null) {
            pa3.n(socket);
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0104  */
    /* JADX WARN: Code duplicated, block: B:50:0x010b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0136  */
    /* JADX WARN: Code duplicated, block: B:54:0x013c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0141  */
    /* JADX WARN: Code duplicated, block: B:72:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[LOOP:0: B:64:0x0094->B:74:?, LOOP_END, SYNTHETIC] */
    public final void g(int i, int i2, int i3, int i4, boolean z, eq eqVar, fi0 fi0Var) throws Throwable {
        Socket socket;
        Socket socket2;
        p31.f(eqVar, "call");
        p31.f(fi0Var, "eventListener");
        if (this.h != null) {
            throw new IllegalStateException("already connected");
        }
        List listB = this.d.a().b();
        u10 u10Var = new u10(listB);
        if (this.d.a().k() == null) {
            if (!listB.contains(okhttp3.b.k)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strH = this.d.a().l().h();
            if (!r32.a.g().i(strH)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + strH + " not permitted by network security policy"));
            }
        } else if (this.d.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                if (this.d.c()) {
                    k(i, i2, i3, eqVar, fi0Var);
                    if (this.e == null) {
                        break;
                    }
                } else {
                    try {
                        i(i, i2, eqVar, fi0Var);
                    } catch (IOException e) {
                        e = e;
                        socket = this.f;
                        if (socket != null) {
                            pa3.n(socket);
                        }
                        socket2 = this.e;
                        if (socket2 != null) {
                            pa3.n(socket2);
                        }
                        this.f = null;
                        this.e = null;
                        this.j = null;
                        this.k = null;
                        this.g = null;
                        this.h = null;
                        this.i = null;
                        this.f367q = 1;
                        fi0Var.h(eqVar, this.d.d(), this.d.b(), null, e);
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.addConnectException(e);
                        }
                        if (z) {
                            throw routeException;
                        }
                        if (u10Var.b(e)) {
                            throw routeException;
                        }
                    }
                }
                try {
                    n(u10Var, i4, eqVar, fi0Var);
                    fi0Var.g(eqVar, this.d.d(), this.d.b(), this.h);
                    break;
                } catch (IOException e2) {
                    e = e2;
                    socket = this.f;
                    if (socket != null) {
                        pa3.n(socket);
                    }
                    socket2 = this.e;
                    if (socket2 != null) {
                        pa3.n(socket2);
                    }
                    this.f = null;
                    this.e = null;
                    this.j = null;
                    this.k = null;
                    this.g = null;
                    this.h = null;
                    this.i = null;
                    this.f367q = 1;
                    fi0Var.h(eqVar, this.d.d(), this.d.b(), null, e);
                    if (routeException == null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.addConnectException(e);
                    }
                    if (z) {
                        throw routeException;
                    }
                    if (u10Var.b(e)) {
                        throw routeException;
                    }
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
        if (this.d.c() && this.e == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.s = System.nanoTime();
    }

    public final void h(zt1 zt1Var, ki2 ki2Var, IOException iOException) {
        p31.f(zt1Var, "client");
        p31.f(ki2Var, "failedRoute");
        p31.f(iOException, "failure");
        if (ki2Var.b().type() != Proxy.Type.DIRECT) {
            v4 v4VarA = ki2Var.a();
            v4VarA.i().connectFailed(v4VarA.l().s(), ki2Var.b().address(), iOException);
        }
        zt1Var.t().b(ki2Var);
    }

    public final List o() {
        return this.r;
    }

    public final long p() {
        return this.s;
    }

    public final boolean q() {
        return this.l;
    }

    public final int r() {
        return this.n;
    }

    public Handshake s() {
        return this.g;
    }

    public final synchronized void t() {
        this.o++;
    }

    public String toString() {
        Object objA;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.d.a().l().h());
        sb.append(':');
        sb.append(this.d.a().l().n());
        sb.append(", proxy=");
        sb.append(this.d.b());
        sb.append(" hostAddress=");
        sb.append(this.d.d());
        sb.append(" cipherSuite=");
        Handshake handshake = this.g;
        if (handshake == null || (objA = handshake.a()) == null) {
            objA = SchedulerSupport.NONE;
        }
        sb.append(objA);
        sb.append(" protocol=");
        sb.append(this.h);
        sb.append('}');
        return sb.toString();
    }

    public final boolean u(v4 v4Var, List list) {
        p31.f(v4Var, "address");
        if (pa3.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.r.size() >= this.f367q || this.l || !this.d.a().d(v4Var)) {
            return false;
        }
        if (p31.a(v4Var.l().h(), B().a().l().h())) {
            return true;
        }
        if (this.i == null || list == null || !C(list) || v4Var.e() != yt1.a || !H(v4Var.l())) {
            return false;
        }
        try {
            CertificatePinner certificatePinnerA = v4Var.a();
            p31.c(certificatePinnerA);
            String strH = v4Var.l().h();
            Handshake handshakeS = s();
            p31.c(handshakeS);
            certificatePinnerA.a(strH, handshakeS.d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean v(boolean z) {
        long j;
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.e;
        p31.c(socket);
        Socket socket2 = this.f;
        p31.c(socket2);
        so soVar = this.j;
        p31.c(soVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        okhttp3.internal.http2.b bVar = this.i;
        if (bVar != null) {
            return bVar.T0(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.s;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        return pa3.F(socket2, soVar);
    }

    public final boolean w() {
        return this.i != null;
    }

    public final ri0 x(zt1 zt1Var, jd2 jd2Var) throws SocketException {
        p31.f(zt1Var, "client");
        p31.f(jd2Var, "chain");
        Socket socket = this.f;
        p31.c(socket);
        so soVar = this.j;
        p31.c(soVar);
        ro roVar = this.k;
        p31.c(roVar);
        okhttp3.internal.http2.b bVar = this.i;
        if (bVar != null) {
            return new ix0(zt1Var, this, jd2Var, bVar);
        }
        socket.setSoTimeout(jd2Var.k());
        h33 h33VarTimeout = soVar.timeout();
        long jH = jd2Var.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h33VarTimeout.g(jH, timeUnit);
        roVar.timeout().g(jd2Var.j(), timeUnit);
        return new gx0(zt1Var, this, soVar, roVar);
    }

    public final md2.d y(qi0 qi0Var) throws SocketException {
        p31.f(qi0Var, "exchange");
        Socket socket = this.f;
        p31.c(socket);
        so soVar = this.j;
        p31.c(soVar);
        ro roVar = this.k;
        p31.c(roVar);
        socket.setSoTimeout(0);
        A();
        return new c(soVar, roVar, qi0Var);
    }

    public final synchronized void z() {
        this.m = true;
    }
}
