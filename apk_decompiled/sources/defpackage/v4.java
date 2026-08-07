package defpackage;

import com.jieli.jl_rcsp.BuildConfig;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CertificatePinner;

/* JADX INFO: loaded from: classes4.dex */
public final class v4 {
    private final qc0 a;
    private final SocketFactory b;
    private final SSLSocketFactory c;
    private final HostnameVerifier d;
    private final CertificatePinner e;
    private final mc f;
    private final Proxy g;
    private final ProxySelector h;
    private final tx0 i;
    private final List j;
    private final List k;

    public v4(String str, int i, qc0 qc0Var, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, mc mcVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        p31.f(str, "uriHost");
        p31.f(qc0Var, "dns");
        p31.f(socketFactory, "socketFactory");
        p31.f(mcVar, "proxyAuthenticator");
        p31.f(list, "protocols");
        p31.f(list2, "connectionSpecs");
        p31.f(proxySelector, "proxySelector");
        this.a = qc0Var;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = certificatePinner;
        this.f = mcVar;
        this.g = proxy;
        this.h = proxySelector;
        this.i = new tx0.a().q(sSLSocketFactory != null ? "https" : "http").g(str).m(i).c();
        this.j = pa3.U(list);
        this.k = pa3.U(list2);
    }

    public final CertificatePinner a() {
        return this.e;
    }

    public final List b() {
        return this.k;
    }

    public final qc0 c() {
        return this.a;
    }

    public final boolean d(v4 v4Var) {
        p31.f(v4Var, "that");
        return p31.a(this.a, v4Var.a) && p31.a(this.f, v4Var.f) && p31.a(this.j, v4Var.j) && p31.a(this.k, v4Var.k) && p31.a(this.h, v4Var.h) && p31.a(this.g, v4Var.g) && p31.a(this.c, v4Var.c) && p31.a(this.d, v4Var.d) && p31.a(this.e, v4Var.e) && this.i.n() == v4Var.i.n();
    }

    public final HostnameVerifier e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof v4) {
            v4 v4Var = (v4) obj;
            if (p31.a(this.i, v4Var.i) && d(v4Var)) {
                return true;
            }
        }
        return false;
    }

    public final List f() {
        return this.j;
    }

    public final Proxy g() {
        return this.g;
    }

    public final mc h() {
        return this.f;
    }

    public int hashCode() {
        return ((((((((((((((((((BuildConfig.VERSION_CODE + this.i.hashCode()) * 31) + this.a.hashCode()) * 31) + this.f.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.h.hashCode()) * 31) + Objects.hashCode(this.g)) * 31) + Objects.hashCode(this.c)) * 31) + Objects.hashCode(this.d)) * 31) + Objects.hashCode(this.e);
    }

    public final ProxySelector i() {
        return this.h;
    }

    public final SocketFactory j() {
        return this.b;
    }

    public final SSLSocketFactory k() {
        return this.c;
    }

    public final tx0 l() {
        return this.i;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.i.h());
        sb2.append(':');
        sb2.append(this.i.n());
        sb2.append(", ");
        if (this.g != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.g;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.h;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append('}');
        return sb2.toString();
    }
}
