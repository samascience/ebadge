package defpackage;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.j;
import kotlin.text.i;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
public final class yt1 implements HostnameVerifier {
    public static final yt1 a = new yt1();

    private yt1() {
    }

    private final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale locale = Locale.US;
        p31.e(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        p31.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List c(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return j.j();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && p31.a(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return j.j();
        }
    }

    private final boolean d(String str) {
        return str.length() == ((int) ja3.b(str, 0, 0, 3, null));
    }

    private final boolean f(String str, String str2) {
        if (str != null && str.length() != 0 && !i.G(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null) && !i.u(str, "..", false, 2, null) && str2 != null && str2.length() != 0 && !i.G(str2, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null) && !i.u(str2, "..", false, 2, null)) {
            if (!i.u(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                str = str + '.';
            }
            String str3 = str;
            if (!i.u(str2, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                str2 = str2 + '.';
            }
            String strB = b(str2);
            if (!i.M(strB, Marker.ANY_MARKER, false, 2, null)) {
                return p31.a(str3, strB);
            }
            if (!i.G(strB, "*.", false, 2, null) || i.V(strB, '*', 1, false, 4, null) != -1 || str3.length() < strB.length() || p31.a("*.", strB)) {
                return false;
            }
            String strSubstring = strB.substring(1);
            p31.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (!i.u(str3, strSubstring, false, 2, null)) {
                return false;
            }
            int length = str3.length() - strSubstring.length();
            return length <= 0 || i.b0(str3, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }

    private final boolean g(String str, X509Certificate x509Certificate) {
        String strB = b(str);
        List listC = c(x509Certificate, 2);
        if (listC != null && listC.isEmpty()) {
            return false;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (a.f(strB, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(String str, X509Certificate x509Certificate) {
        String strE = fx0.e(str);
        List listC = c(x509Certificate, 7);
        if (listC != null && listC.isEmpty()) {
            return false;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (p31.a(strE, fx0.e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List a(X509Certificate x509Certificate) {
        p31.f(x509Certificate, "certificate");
        return j.Q(c(x509Certificate, 7), c(x509Certificate, 2));
    }

    public final boolean e(String str, X509Certificate x509Certificate) {
        p31.f(str, "host");
        p31.f(x509Certificate, "certificate");
        return pa3.i(str) ? h(str, x509Certificate) : g(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        p31.f(str, "host");
        p31.f(sSLSession, "session");
        if (!d(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            p31.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return e(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }
}
