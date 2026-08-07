package defpackage;

import com.tencent.connect.common.Constants;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: loaded from: classes4.dex */
public final class in implements ur2 {
    public static final b a = new b(null);
    private static final e90.a b = new a();

    public static final class a implements e90.a {
        a() {
        }

        @Override // e90.a
        public boolean a(SSLSocket sSLSocket) {
            p31.f(sSLSocket, "sslSocket");
            hn.e.b();
            return false;
        }

        @Override // e90.a
        public ur2 b(SSLSocket sSLSocket) {
            p31.f(sSLSocket, "sslSocket");
            return new in();
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final e90.a a() {
            return in.b;
        }

        private b() {
        }
    }

    @Override // defpackage.ur2
    public boolean a(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return false;
    }

    @Override // defpackage.ur2
    public boolean b() {
        return hn.e.b();
    }

    @Override // defpackage.ur2
    public String c(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : p31.a(applicationProtocol, Constants.STR_EMPTY)) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.ur2
    public void d(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) r32.a.b(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
