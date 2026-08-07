package defpackage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.j;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes4.dex */
public class r32 {
    public static final a a;
    private static volatile r32 b;
    private static final Logger c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private final r32 d() {
            t5.a.b();
            r32 r32VarA = o5.e.a();
            if (r32VarA != null) {
                return r32VarA;
            }
            r32 r32VarA2 = w5.f.a();
            p31.c(r32VarA2);
            return r32VarA2;
        }

        private final r32 e() {
            sw1 sw1VarA;
            hn hnVarA;
            b20 b20VarB;
            if (j() && (b20VarB = b20.e.b()) != null) {
                return b20VarB;
            }
            if (i() && (hnVarA = hn.e.a()) != null) {
                return hnVarA;
            }
            if (k() && (sw1VarA = sw1.e.a()) != null) {
                return sw1VarA;
            }
            s41 s41VarA = s41.d.a();
            if (s41VarA != null) {
                return s41VarA;
            }
            r32 r32VarA = p41.i.a();
            return r32VarA != null ? r32VarA : new r32();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final r32 f() {
            return h() ? d() : e();
        }

        private final boolean i() {
            return p31.a("BC", Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return p31.a("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return p31.a("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final List b(List list) {
            p31.f(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(j.t(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] c(List list) {
            p31.f(list, "protocols");
            fo foVar = new fo();
            for (String str : b(list)) {
                foVar.I(str.length());
                foVar.S(str);
            }
            return foVar.G();
        }

        public final r32 g() {
            return r32.b;
        }

        public final boolean h() {
            return p31.a("Dalvik", System.getProperty("java.vm.name"));
        }

        private a() {
        }
    }

    static {
        a aVar = new a(null);
        a = aVar;
        b = aVar.f();
        c = Logger.getLogger(zt1.class.getName());
    }

    public static /* synthetic */ void k(r32 r32Var, String str, int i, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        r32Var.j(str, i, th);
    }

    public void b(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
    }

    public yw c(X509TrustManager x509TrustManager) {
        p31.f(x509TrustManager, "trustManager");
        return new bh(d(x509TrustManager));
    }

    public c63 d(X509TrustManager x509TrustManager) {
        p31.f(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        p31.e(acceptedIssuers, "trustManager.acceptedIssuers");
        return new eh((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        p31.f(socket, "socket");
        p31.f(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public String g(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return null;
    }

    public Object h(String str) {
        p31.f(str, "closer");
        if (c.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean i(String str) {
        p31.f(str, "hostname");
        return true;
    }

    public void j(String str, int i, Throwable th) {
        p31.f(str, "message");
        c.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void l(String str, Object obj) {
        p31.f(str, "message");
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        j(str, 5, (Throwable) obj);
    }

    public SSLContext m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        p31.e(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory n(X509TrustManager x509TrustManager) {
        p31.f(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextM = m();
            sSLContextM.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextM.getSocketFactory();
            p31.e(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public String toString() {
        String simpleName = getClass().getSimpleName();
        p31.e(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
