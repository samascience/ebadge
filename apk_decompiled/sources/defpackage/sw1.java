package defpackage;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: loaded from: classes4.dex */
public final class sw1 extends r32 {
    public static final a e;
    private static final boolean f;
    private final Provider d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final sw1 a() {
            y70 y70Var = null;
            if (b()) {
                return new sw1(y70Var);
            }
            return null;
        }

        public final boolean b() {
            return sw1.f;
        }

        private a() {
        }
    }

    static {
        a aVar = new a(null);
        e = aVar;
        boolean z = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        f = z;
    }

    public /* synthetic */ sw1(y70 y70Var) {
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
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.d);
        p31.e(sSLContext, "getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // defpackage.r32
    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.d);
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

    private sw1() {
        this.d = new OpenJSSE();
    }
}
