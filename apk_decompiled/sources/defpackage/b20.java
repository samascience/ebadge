package defpackage;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: loaded from: classes4.dex */
public final class b20 extends r32 {
    public static final a e;
    private static final boolean f;
    private final Provider d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final boolean a(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i) {
                return version.major() > i;
            }
            if (version.minor() != i2) {
                return version.minor() > i2;
            }
            return version.patch() >= i3;
        }

        public final b20 b() {
            y70 y70Var = null;
            if (c()) {
                return new b20(y70Var);
            }
            return null;
        }

        public final boolean c() {
            return b20.f;
        }

        private a() {
        }
    }

    public static final class b implements ConscryptHostnameVerifier {
        public static final b a = new b();

        private b() {
        }
    }

    static {
        a aVar = new a(null);
        e = aVar;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && aVar.a(2, 1, 0)) {
                z = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f = z;
    }

    public /* synthetic */ b20(y70 y70Var) {
        this();
    }

    @Override // defpackage.r32
    public void e(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.e(sSLSocket, str, list);
        } else {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) r32.a.b(list).toArray(new String[0]));
        }
    }

    @Override // defpackage.r32
    public String g(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.g(sSLSocket);
    }

    @Override // defpackage.r32
    public SSLContext m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.d);
        p31.e(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // defpackage.r32
    public SSLSocketFactory n(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        p31.f(x509TrustManager, "trustManager");
        SSLContext sSLContextM = m();
        sSLContextM.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContextM.getSocketFactory();
        p31.e(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // defpackage.r32
    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        p31.c(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                p31.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                Conscrypt.setHostnameVerifier(x509TrustManager, b.a);
                return x509TrustManager;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        p31.e(string, "toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    private b20() {
        Provider providerNewProvider = Conscrypt.newProvider();
        p31.e(providerNewProvider, "newProvider()");
        this.d = providerNewProvider;
    }
}
