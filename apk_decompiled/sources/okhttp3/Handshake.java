package okhttp3;

import com.jieli.jl_rcsp.BuildConfig;
import com.tencent.open.SocialConstants;
import defpackage.ja1;
import defpackage.p31;
import defpackage.pa3;
import defpackage.y70;
import defpackage.yq0;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class Handshake {
    public static final Companion e = new Companion(null);
    private final TlsVersion a;
    private final a b;
    private final List c;
    private final ja1 d;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        private final List b(Certificate[] certificateArr) {
            return certificateArr != null ? pa3.w(Arrays.copyOf(certificateArr, certificateArr.length)) : j.j();
        }

        public final Handshake a(SSLSession sSLSession) throws IOException {
            final List listJ;
            p31.f(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (p31.a(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : p31.a(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            a aVarB = a.b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if (p31.a("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionA = TlsVersion.Companion.a(protocol);
            try {
                listJ = b(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listJ = j.j();
            }
            return new Handshake(tlsVersionA, aVarB, b(sSLSession.getLocalCertificates()), new yq0() { // from class: okhttp3.Handshake$Companion$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // defpackage.yq0
                public final List<Certificate> invoke() {
                    return listJ;
                }
            });
        }

        private Companion() {
        }
    }

    public Handshake(TlsVersion tlsVersion, a aVar, List list, final yq0 yq0Var) {
        p31.f(tlsVersion, "tlsVersion");
        p31.f(aVar, "cipherSuite");
        p31.f(list, "localCertificates");
        p31.f(yq0Var, "peerCertificatesFn");
        this.a = tlsVersion;
        this.b = aVar;
        this.c = list;
        this.d = kotlin.a.a(new yq0() { // from class: okhttp3.Handshake$peerCertificates$2
            {
                super(0);
            }

            @Override // defpackage.yq0
            public final List<Certificate> invoke() {
                try {
                    return (List) yq0Var.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return j.j();
                }
            }
        });
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        p31.e(type, SocialConstants.PARAM_TYPE);
        return type;
    }

    public final a a() {
        return this.b;
    }

    public final List c() {
        return this.c;
    }

    public final List d() {
        return (List) this.d.getValue();
    }

    public final TlsVersion e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.a == this.a && p31.a(handshake.b, this.b) && p31.a(handshake.d(), d()) && p31.a(handshake.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((BuildConfig.VERSION_CODE + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + d().hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        List listD = d();
        ArrayList arrayList = new ArrayList(j.t(listD, 10));
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.a);
        sb.append(" cipherSuite=");
        sb.append(this.b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List list = this.c;
        ArrayList arrayList2 = new ArrayList(j.t(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
