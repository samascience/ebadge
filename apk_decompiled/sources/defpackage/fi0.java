package defpackage;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes4.dex */
public abstract class fi0 {
    public static final b a = new b(null);
    public static final fi0 b = new a();

    public static final class a extends fi0 {
        a() {
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private b() {
        }
    }

    public interface c {
        fi0 a(eq eqVar);
    }

    public void A(eq eqVar, Handshake handshake) {
        p31.f(eqVar, "call");
    }

    public void B(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void a(eq eqVar, eh2 eh2Var) {
        p31.f(eqVar, "call");
        p31.f(eh2Var, "cachedResponse");
    }

    public void b(eq eqVar, eh2 eh2Var) {
        p31.f(eqVar, "call");
        p31.f(eh2Var, "response");
    }

    public void c(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void d(eq eqVar, IOException iOException) {
        p31.f(eqVar, "call");
        p31.f(iOException, "ioe");
    }

    public void e(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void f(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void g(eq eqVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        p31.f(eqVar, "call");
        p31.f(inetSocketAddress, "inetSocketAddress");
        p31.f(proxy, "proxy");
    }

    public void h(eq eqVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        p31.f(eqVar, "call");
        p31.f(inetSocketAddress, "inetSocketAddress");
        p31.f(proxy, "proxy");
        p31.f(iOException, "ioe");
    }

    public void i(eq eqVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        p31.f(eqVar, "call");
        p31.f(inetSocketAddress, "inetSocketAddress");
        p31.f(proxy, "proxy");
    }

    public void j(eq eqVar, p10 p10Var) {
        p31.f(eqVar, "call");
        p31.f(p10Var, "connection");
    }

    public void k(eq eqVar, p10 p10Var) {
        p31.f(eqVar, "call");
        p31.f(p10Var, "connection");
    }

    public void l(eq eqVar, String str, List list) {
        p31.f(eqVar, "call");
        p31.f(str, "domainName");
        p31.f(list, "inetAddressList");
    }

    public void m(eq eqVar, String str) {
        p31.f(eqVar, "call");
        p31.f(str, "domainName");
    }

    public void n(eq eqVar, tx0 tx0Var, List list) {
        p31.f(eqVar, "call");
        p31.f(tx0Var, SocialConstants.PARAM_URL);
        p31.f(list, "proxies");
    }

    public void o(eq eqVar, tx0 tx0Var) {
        p31.f(eqVar, "call");
        p31.f(tx0Var, SocialConstants.PARAM_URL);
    }

    public void p(eq eqVar, long j) {
        p31.f(eqVar, "call");
    }

    public void q(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void r(eq eqVar, IOException iOException) {
        p31.f(eqVar, "call");
        p31.f(iOException, "ioe");
    }

    public void s(eq eqVar, df2 df2Var) {
        p31.f(eqVar, "call");
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
    }

    public void t(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void u(eq eqVar, long j) {
        p31.f(eqVar, "call");
    }

    public void v(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void w(eq eqVar, IOException iOException) {
        p31.f(eqVar, "call");
        p31.f(iOException, "ioe");
    }

    public void x(eq eqVar, eh2 eh2Var) {
        p31.f(eqVar, "call");
        p31.f(eh2Var, "response");
    }

    public void y(eq eqVar) {
        p31.f(eqVar, "call");
    }

    public void z(eq eqVar, eh2 eh2Var) {
        p31.f(eqVar, "call");
        p31.f(eh2Var, "response");
    }
}
