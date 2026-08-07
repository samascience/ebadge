package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tencent.open.SocialConstants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.j;
import okhttp3.CertificatePinner;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes4.dex */
public class zt1 implements Cloneable, eq.a {
    public static final b I = new b(null);
    private static final List J = pa3.w(Protocol.HTTP_2, Protocol.HTTP_1_1);
    private static final List K = pa3.w(okhttp3.b.i, okhttp3.b.k);
    private final int F;
    private final long G;
    private final li2 H;
    private final hc0 a;
    private final t10 b;
    private final List c;
    private final List d;
    private final fi0.c e;
    private final boolean f;
    private final mc g;
    private final boolean h;
    private final boolean i;
    private final i40 j;
    private final qc0 k;
    private final Proxy l;
    private final ProxySelector m;
    private final mc n;
    private final SocketFactory o;
    private final SSLSocketFactory p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final X509TrustManager f462q;
    private final List r;
    private final List s;
    private final HostnameVerifier t;
    private final CertificatePinner u;
    private final yw v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final List a() {
            return zt1.K;
        }

        public final List b() {
            return zt1.J;
        }

        private b() {
        }
    }

    public zt1(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelectorF;
        p31.f(aVar, "builder");
        this.a = aVar.s();
        this.b = aVar.p();
        this.c = pa3.U(aVar.y());
        this.d = pa3.U(aVar.A());
        this.e = aVar.u();
        this.f = aVar.H();
        this.g = aVar.j();
        this.h = aVar.v();
        this.i = aVar.w();
        this.j = aVar.r();
        aVar.k();
        this.k = aVar.t();
        this.l = aVar.D();
        if (aVar.D() != null) {
            proxySelectorF = fs1.a;
        } else {
            proxySelectorF = aVar.F();
            proxySelectorF = proxySelectorF == null ? ProxySelector.getDefault() : proxySelectorF;
            if (proxySelectorF == null) {
                proxySelectorF = fs1.a;
            }
        }
        this.m = proxySelectorF;
        this.n = aVar.E();
        this.o = aVar.J();
        List listQ = aVar.q();
        this.r = listQ;
        this.s = aVar.C();
        this.t = aVar.x();
        this.w = aVar.l();
        this.x = aVar.o();
        this.y = aVar.G();
        this.z = aVar.L();
        this.F = aVar.B();
        this.G = aVar.z();
        li2 li2VarI = aVar.I();
        this.H = li2VarI == null ? new li2() : li2VarI;
        if (listQ == null || !listQ.isEmpty()) {
            Iterator it = listQ.iterator();
            while (it.hasNext()) {
                if (((okhttp3.b) it.next()).f()) {
                    if (aVar.K() != null) {
                        this.p = aVar.K();
                        yw ywVarM = aVar.m();
                        p31.c(ywVarM);
                        this.v = ywVarM;
                        X509TrustManager x509TrustManagerM = aVar.M();
                        p31.c(x509TrustManagerM);
                        this.f462q = x509TrustManagerM;
                        CertificatePinner certificatePinnerN = aVar.n();
                        p31.c(ywVarM);
                        this.u = certificatePinnerN.e(ywVarM);
                    } else {
                        r32.a aVar2 = r32.a;
                        X509TrustManager x509TrustManagerO = aVar2.g().o();
                        this.f462q = x509TrustManagerO;
                        r32 r32VarG = aVar2.g();
                        p31.c(x509TrustManagerO);
                        this.p = r32VarG.n(x509TrustManagerO);
                        yw.a aVar3 = yw.a;
                        p31.c(x509TrustManagerO);
                        yw ywVarA = aVar3.a(x509TrustManagerO);
                        this.v = ywVarA;
                        CertificatePinner certificatePinnerN2 = aVar.n();
                        p31.c(ywVarA);
                        this.u = certificatePinnerN2.e(ywVarA);
                    }
                }
            }
            this.p = null;
            this.v = null;
            this.f462q = null;
            this.u = CertificatePinner.d;
        } else {
            this.p = null;
            this.v = null;
            this.f462q = null;
            this.u = CertificatePinner.d;
        }
        J();
    }

    private final void J() {
        List list = this.c;
        p31.d(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.c).toString());
        }
        List list2 = this.d;
        p31.d(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.d).toString());
        }
        List list3 = this.r;
        if (list3 == null || !list3.isEmpty()) {
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                if (((okhttp3.b) it.next()).f()) {
                    if (this.p == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (this.v == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (this.f462q == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (this.p != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.v != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f462q != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!p31.a(this.u, CertificatePinner.d)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int A() {
        return this.F;
    }

    public final List B() {
        return this.s;
    }

    public final Proxy C() {
        return this.l;
    }

    public final mc D() {
        return this.n;
    }

    public final ProxySelector E() {
        return this.m;
    }

    public final int F() {
        return this.y;
    }

    public final boolean G() {
        return this.f;
    }

    public final SocketFactory H() {
        return this.o;
    }

    public final SSLSocketFactory I() {
        SSLSocketFactory sSLSocketFactory = this.p;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int K() {
        return this.z;
    }

    public final X509TrustManager L() {
        return this.f462q;
    }

    @Override // eq.a
    public eq a(df2 df2Var) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        return new gd2(this, df2Var, false);
    }

    public Object clone() {
        return super.clone();
    }

    public final mc e() {
        return this.g;
    }

    public final sp f() {
        return null;
    }

    public final int g() {
        return this.w;
    }

    public final yw h() {
        return this.v;
    }

    public final CertificatePinner i() {
        return this.u;
    }

    public final int j() {
        return this.x;
    }

    public final t10 k() {
        return this.b;
    }

    public final List l() {
        return this.r;
    }

    public final i40 m() {
        return this.j;
    }

    public final hc0 o() {
        return this.a;
    }

    public final qc0 p() {
        return this.k;
    }

    public final fi0.c q() {
        return this.e;
    }

    public final boolean r() {
        return this.h;
    }

    public final boolean s() {
        return this.i;
    }

    public final li2 t() {
        return this.H;
    }

    public final HostnameVerifier u() {
        return this.t;
    }

    public final List v() {
        return this.c;
    }

    public final long w() {
        return this.G;
    }

    public final List x() {
        return this.d;
    }

    public a y() {
        return new a(this);
    }

    public qh3 z(df2 df2Var, sh3 sh3Var) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        p31.f(sh3Var, "listener");
        md2 md2Var = new md2(b13.i, df2Var, sh3Var, new Random(), this.F, null, this.G);
        md2Var.p(this);
        return md2Var;
    }

    public static final class a {
        private int A;
        private long B;
        private li2 C;
        private hc0 a;
        private t10 b;
        private final List c;
        private final List d;
        private fi0.c e;
        private boolean f;
        private mc g;
        private boolean h;
        private boolean i;
        private i40 j;
        private qc0 k;
        private Proxy l;
        private ProxySelector m;
        private mc n;
        private SocketFactory o;
        private SSLSocketFactory p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private X509TrustManager f463q;
        private List r;
        private List s;
        private HostnameVerifier t;
        private CertificatePinner u;
        private yw v;
        private int w;
        private int x;
        private int y;
        private int z;

        public a() {
            this.a = new hc0();
            this.b = new t10();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.e = pa3.g(fi0.b);
            this.f = true;
            mc mcVar = mc.b;
            this.g = mcVar;
            this.h = true;
            this.i = true;
            this.j = i40.b;
            this.k = qc0.b;
            this.n = mcVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            p31.e(socketFactory, "getDefault()");
            this.o = socketFactory;
            b bVar = zt1.I;
            this.r = bVar.a();
            this.s = bVar.b();
            this.t = yt1.a;
            this.u = CertificatePinner.d;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.B = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }

        public final List A() {
            return this.d;
        }

        public final int B() {
            return this.A;
        }

        public final List C() {
            return this.s;
        }

        public final Proxy D() {
            return this.l;
        }

        public final mc E() {
            return this.n;
        }

        public final ProxySelector F() {
            return this.m;
        }

        public final int G() {
            return this.y;
        }

        public final boolean H() {
            return this.f;
        }

        public final li2 I() {
            return this.C;
        }

        public final SocketFactory J() {
            return this.o;
        }

        public final SSLSocketFactory K() {
            return this.p;
        }

        public final int L() {
            return this.z;
        }

        public final X509TrustManager M() {
            return this.f463q;
        }

        public final a N(List list) {
            p31.f(list, "protocols");
            List listZ = j.Z(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!listZ.contains(protocol) && !listZ.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + listZ).toString());
            }
            if (listZ.contains(protocol) && listZ.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + listZ).toString());
            }
            if (listZ.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + listZ).toString());
            }
            p31.d(listZ, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if (listZ.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            listZ.remove(Protocol.SPDY_3);
            if (!p31.a(listZ, this.s)) {
                this.C = null;
            }
            List listUnmodifiableList = Collections.unmodifiableList(listZ);
            p31.e(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
            this.s = listUnmodifiableList;
            return this;
        }

        public final a O(Proxy proxy) {
            if (!p31.a(proxy, this.l)) {
                this.C = null;
            }
            this.l = proxy;
            return this;
        }

        public final a P(mc mcVar) {
            p31.f(mcVar, "proxyAuthenticator");
            if (!p31.a(mcVar, this.n)) {
                this.C = null;
            }
            this.n = mcVar;
            return this;
        }

        public final a Q(long j, TimeUnit timeUnit) {
            p31.f(timeUnit, "unit");
            this.y = pa3.k("timeout", j, timeUnit);
            return this;
        }

        public final a R(Duration duration) {
            p31.f(duration, "duration");
            Q(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final a S(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            p31.f(sSLSocketFactory, "sslSocketFactory");
            p31.f(x509TrustManager, "trustManager");
            if (!p31.a(sSLSocketFactory, this.p) || !p31.a(x509TrustManager, this.f463q)) {
                this.C = null;
            }
            this.p = sSLSocketFactory;
            this.v = yw.a.a(x509TrustManager);
            this.f463q = x509TrustManager;
            return this;
        }

        public final a T(long j, TimeUnit timeUnit) {
            p31.f(timeUnit, "unit");
            this.z = pa3.k("timeout", j, timeUnit);
            return this;
        }

        public final a U(Duration duration) {
            p31.f(duration, "duration");
            T(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final a a(l31 l31Var) {
            p31.f(l31Var, "interceptor");
            this.c.add(l31Var);
            return this;
        }

        public final zt1 b() {
            return new zt1(this);
        }

        public final a c(sp spVar) {
            return this;
        }

        public final a d(long j, TimeUnit timeUnit) {
            p31.f(timeUnit, "unit");
            this.x = pa3.k("timeout", j, timeUnit);
            return this;
        }

        public final a e(Duration duration) {
            p31.f(duration, "duration");
            d(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final a f(t10 t10Var) {
            p31.f(t10Var, "connectionPool");
            this.b = t10Var;
            return this;
        }

        public final a g(List list) {
            p31.f(list, "connectionSpecs");
            if (!p31.a(list, this.r)) {
                this.C = null;
            }
            this.r = pa3.U(list);
            return this;
        }

        public final a h(hc0 hc0Var) {
            p31.f(hc0Var, "dispatcher");
            this.a = hc0Var;
            return this;
        }

        public final a i(fi0 fi0Var) {
            p31.f(fi0Var, "eventListener");
            this.e = pa3.g(fi0Var);
            return this;
        }

        public final mc j() {
            return this.g;
        }

        public final sp k() {
            return null;
        }

        public final int l() {
            return this.w;
        }

        public final yw m() {
            return this.v;
        }

        public final CertificatePinner n() {
            return this.u;
        }

        public final int o() {
            return this.x;
        }

        public final t10 p() {
            return this.b;
        }

        public final List q() {
            return this.r;
        }

        public final i40 r() {
            return this.j;
        }

        public final hc0 s() {
            return this.a;
        }

        public final qc0 t() {
            return this.k;
        }

        public final fi0.c u() {
            return this.e;
        }

        public final boolean v() {
            return this.h;
        }

        public final boolean w() {
            return this.i;
        }

        public final HostnameVerifier x() {
            return this.t;
        }

        public final List y() {
            return this.c;
        }

        public final long z() {
            return this.B;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(zt1 zt1Var) {
            this();
            p31.f(zt1Var, "okHttpClient");
            this.a = zt1Var.o();
            this.b = zt1Var.k();
            j.w(this.c, zt1Var.v());
            j.w(this.d, zt1Var.x());
            this.e = zt1Var.q();
            this.f = zt1Var.G();
            this.g = zt1Var.e();
            this.h = zt1Var.r();
            this.i = zt1Var.s();
            this.j = zt1Var.m();
            zt1Var.f();
            this.k = zt1Var.p();
            this.l = zt1Var.C();
            this.m = zt1Var.E();
            this.n = zt1Var.D();
            this.o = zt1Var.H();
            this.p = zt1Var.p;
            this.f463q = zt1Var.L();
            this.r = zt1Var.l();
            this.s = zt1Var.B();
            this.t = zt1Var.u();
            this.u = zt1Var.i();
            this.v = zt1Var.h();
            this.w = zt1Var.g();
            this.x = zt1Var.j();
            this.y = zt1Var.F();
            this.z = zt1Var.K();
            this.A = zt1Var.A();
            this.B = zt1Var.w();
            this.C = zt1Var.t();
        }
    }

    public zt1() {
        this(new a());
    }
}
