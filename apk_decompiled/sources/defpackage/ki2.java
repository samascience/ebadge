package defpackage;

import com.jieli.jl_rcsp.BuildConfig;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes4.dex */
public final class ki2 {
    private final v4 a;
    private final Proxy b;
    private final InetSocketAddress c;

    public ki2(v4 v4Var, Proxy proxy, InetSocketAddress inetSocketAddress) {
        p31.f(v4Var, "address");
        p31.f(proxy, "proxy");
        p31.f(inetSocketAddress, "socketAddress");
        this.a = v4Var;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final v4 a() {
        return this.a;
    }

    public final Proxy b() {
        return this.b;
    }

    public final boolean c() {
        return this.a.k() != null && this.b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ki2) {
            ki2 ki2Var = (ki2) obj;
            if (p31.a(ki2Var.a, this.a) && p31.a(ki2Var.b, this.b) && p31.a(ki2Var.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((BuildConfig.VERSION_CODE + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + '}';
    }
}
