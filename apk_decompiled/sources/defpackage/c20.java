package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes4.dex */
public final class c20 implements ur2 {
    public static final b a = new b(null);
    private static final e90.a b = new a();

    public static final class a implements e90.a {
        a() {
        }

        @Override // e90.a
        public boolean a(SSLSocket sSLSocket) {
            p31.f(sSLSocket, "sslSocket");
            return b20.e.c() && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // e90.a
        public ur2 b(SSLSocket sSLSocket) {
            p31.f(sSLSocket, "sslSocket");
            return new c20();
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final e90.a a() {
            return c20.b;
        }

        private b() {
        }
    }

    @Override // defpackage.ur2
    public boolean a(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.ur2
    public boolean b() {
        return b20.e.c();
    }

    @Override // defpackage.ur2
    public String c(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.ur2
    public void d(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) r32.a.b(list).toArray(new String[0]));
        }
    }
}
