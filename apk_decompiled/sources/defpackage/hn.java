package defpackage;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class hn extends r32 {
    public static final a e;
    private static final boolean f;
    private final Provider d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final hn a() {
            y70 y70Var = null;
            if (b()) {
                return new hn(y70Var);
            }
            return null;
        }

        public final boolean b() {
            return hn.f;
        }

        private a() {
        }
    }

    static {
        a aVar = new a(null);
        e = aVar;
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        f = z;
    }

    public /* synthetic */ hn(y70 y70Var) {
        this();
    }

    @Override // defpackage.r32
    public void e(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        super.e(sSLSocket, str, list);
    }

    @Override // defpackage.r32
    public String g(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return super.g(sSLSocket);
    }

    @Override // defpackage.r32
    public SSLContext m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.d);
        p31.e(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // defpackage.r32
    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        p31.c(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                p31.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        p31.e(string, "toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    private hn() {
        this.d = new BouncyCastleJsseProvider();
    }
}
