package defpackage;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
public final class s5 extends yw {
    public static final a d = new a(null);
    private final X509TrustManager b;
    private final X509TrustManagerExtensions c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final s5 a(X509TrustManager x509TrustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            p31.f(x509TrustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new s5(x509TrustManager, x509TrustManagerExtensions);
            }
            return null;
        }

        private a() {
        }
    }

    public s5(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        p31.f(x509TrustManager, "trustManager");
        p31.f(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.b = x509TrustManager;
        this.c = x509TrustManagerExtensions;
    }

    @Override // defpackage.yw
    public List a(List list, String str) throws SSLPeerUnverifiedException {
        p31.f(list, "chain");
        p31.f(str, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.c.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            p31.e(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof s5) && ((s5) obj).b == this.b;
    }

    public int hashCode() {
        return System.identityHashCode(this.b);
    }
}
