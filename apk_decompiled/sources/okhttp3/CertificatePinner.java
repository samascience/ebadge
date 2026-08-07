package okhttp3;

import defpackage.e43;
import defpackage.p31;
import defpackage.y70;
import defpackage.yq0;
import defpackage.yw;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.j;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class CertificatePinner {
    public static final b c = new b(null);
    public static final CertificatePinner d = new a().a();
    private final Set a;
    private final yw b;

    public static final class a {
        private final List a = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner a() {
            return new CertificatePinner(j.a0(this.a), null, 2, 0 == true ? 1 : 0);
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final String a(Certificate certificate) {
            p31.f(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + b((X509Certificate) certificate).base64();
        }

        public final ByteString b(X509Certificate x509Certificate) {
            p31.f(x509Certificate, "<this>");
            ByteString.a aVar = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            p31.e(encoded, "publicKey.encoded");
            return ByteString.a.h(aVar, encoded, 0, 0, 3, null).sha256();
        }

        private b() {
        }
    }

    public CertificatePinner(Set set, yw ywVar) {
        p31.f(set, "pins");
        this.a = set;
        this.b = ywVar;
    }

    public final void a(final String str, final List list) {
        p31.f(str, "hostname");
        p31.f(list, "peerCertificates");
        b(str, new yq0() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // defpackage.yq0
            public final List<X509Certificate> invoke() {
                List<Certificate> listA;
                yw ywVarD = this.this$0.d();
                if (ywVarD == null || (listA = ywVarD.a(list, str)) == null) {
                    listA = list;
                }
                ArrayList arrayList = new ArrayList(j.t(listA, 10));
                for (Certificate certificate : listA) {
                    p31.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void b(String str, yq0 yq0Var) throws SSLPeerUnverifiedException {
        p31.f(str, "hostname");
        p31.f(yq0Var, "cleanedPeerCertificatesFn");
        List listC = c(str);
        if (listC.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) yq0Var.invoke();
        for (X509Certificate x509Certificate : list) {
            Iterator it = listC.iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(c.a(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        Iterator it2 = listC.iterator();
        while (it2.hasNext()) {
            e43.a(it2.next());
            sb.append("\n    ");
            sb.append((Object) null);
        }
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final List c(String str) {
        p31.f(str, "hostname");
        Set set = this.a;
        List listJ = j.j();
        Iterator it = set.iterator();
        if (!it.hasNext()) {
            return listJ;
        }
        e43.a(it.next());
        throw null;
    }

    public final yw d() {
        return this.b;
    }

    public final CertificatePinner e(yw ywVar) {
        p31.f(ywVar, "certificateChainCleaner");
        return p31.a(this.b, ywVar) ? this : new CertificatePinner(this.a, ywVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (p31.a(certificatePinner.a, this.a) && p31.a(certificatePinner.b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.a.hashCode()) * 41;
        yw ywVar = this.b;
        return iHashCode + (ywVar != null ? ywVar.hashCode() : 0);
    }

    public /* synthetic */ CertificatePinner(Set set, yw ywVar, int i, y70 y70Var) {
        this(set, (i & 2) != 0 ? null : ywVar);
    }
}
