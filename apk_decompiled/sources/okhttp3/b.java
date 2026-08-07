package okhttp3;

import com.jieli.jl_rcsp.BuildConfig;
import defpackage.o00;
import defpackage.p31;
import defpackage.pa3;
import defpackage.y70;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final C0152b e = new C0152b(null);
    private static final okhttp3.a[] f;
    private static final okhttp3.a[] g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    private final boolean a;
    private final boolean b;
    private final String[] c;
    private final String[] d;

    /* JADX INFO: renamed from: okhttp3.b$b, reason: collision with other inner class name */
    public static final class C0152b {
        public /* synthetic */ C0152b(y70 y70Var) {
            this();
        }

        private C0152b() {
        }
    }

    static {
        okhttp3.a aVar = okhttp3.a.o1;
        okhttp3.a aVar2 = okhttp3.a.p1;
        okhttp3.a aVar3 = okhttp3.a.q1;
        okhttp3.a aVar4 = okhttp3.a.a1;
        okhttp3.a aVar5 = okhttp3.a.e1;
        okhttp3.a aVar6 = okhttp3.a.b1;
        okhttp3.a aVar7 = okhttp3.a.f1;
        okhttp3.a aVar8 = okhttp3.a.l1;
        okhttp3.a aVar9 = okhttp3.a.k1;
        okhttp3.a[] aVarArr = {aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9};
        f = aVarArr;
        okhttp3.a[] aVarArr2 = {aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, okhttp3.a.L0, okhttp3.a.M0, okhttp3.a.j0, okhttp3.a.k0, okhttp3.a.H, okhttp3.a.L, okhttp3.a.l};
        g = aVarArr2;
        a aVarC = new a(true).c((okhttp3.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        h = aVarC.f(tlsVersion, tlsVersion2).d(true).a();
        i = new a(true).c((okhttp3.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length)).f(tlsVersion, tlsVersion2).d(true).a();
        j = new a(true).c((okhttp3.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length)).f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).d(true).a();
        k = new a(false).a();
    }

    public b(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.a = z;
        this.b = z2;
        this.c = strArr;
        this.d = strArr2;
    }

    private final b g(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.c != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            p31.e(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = pa3.E(enabledCipherSuites2, this.c, okhttp3.a.b.c());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.d != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            p31.e(enabledProtocols2, "sslSocket.enabledProtocols");
            enabledProtocols = pa3.E(enabledProtocols2, this.d, o00.b());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        p31.e(supportedCipherSuites, "supportedCipherSuites");
        int iX = pa3.x(supportedCipherSuites, "TLS_FALLBACK_SCSV", okhttp3.a.b.c());
        if (z && iX != -1) {
            p31.e(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iX];
            p31.e(str, "supportedCipherSuites[indexOfFallbackScsv]");
            enabledCipherSuites = pa3.o(enabledCipherSuites, str);
        }
        a aVar = new a(this);
        p31.e(enabledCipherSuites, "cipherSuitesIntersection");
        a aVarB = aVar.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        p31.e(enabledProtocols, "tlsVersionsIntersection");
        return aVarB.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).a();
    }

    public final void c(SSLSocket sSLSocket, boolean z) {
        p31.f(sSLSocket, "sslSocket");
        b bVarG = g(sSLSocket, z);
        if (bVarG.i() != null) {
            sSLSocket.setEnabledProtocols(bVarG.d);
        }
        if (bVarG.d() != null) {
            sSLSocket.setEnabledCipherSuites(bVarG.c);
        }
    }

    public final List d() {
        String[] strArr = this.c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(okhttp3.a.b.b(str));
        }
        return j.X(arrayList);
    }

    public final boolean e(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "socket");
        if (!this.a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !pa3.u(strArr, sSLSocket.getEnabledProtocols(), o00.b())) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || pa3.u(strArr2, sSLSocket.getEnabledCipherSuites(), okhttp3.a.b.c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.a;
        b bVar = (b) obj;
        if (z != bVar.a) {
            return false;
        }
        return !z || (Arrays.equals(this.c, bVar.c) && Arrays.equals(this.d, bVar.d) && this.b == bVar.b);
    }

    public final boolean f() {
        return this.a;
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        if (!this.a) {
            return 17;
        }
        String[] strArr = this.c;
        int iHashCode = (BuildConfig.VERSION_CODE + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.b ? 1 : 0);
    }

    public final List i() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.Companion.a(str));
        }
        return j.X(arrayList);
    }

    public String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(d(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ')';
    }

    public static final class a {
        private boolean a;
        private String[] b;
        private String[] c;
        private boolean d;

        public a(boolean z) {
            this.a = z;
        }

        public final b a() {
            return new b(this.a, this.d, this.b, this.c);
        }

        public final a b(String... strArr) {
            p31.f(strArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (String[]) strArr.clone();
            return this;
        }

        public final a c(okhttp3.a... aVarArr) {
            p31.f(aVarArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(aVarArr.length);
            for (okhttp3.a aVar : aVarArr) {
                arrayList.add(aVar.c());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return b((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a d(boolean z) {
            if (!this.a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public final a e(String... strArr) {
            p31.f(strArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (String[]) strArr.clone();
            return this;
        }

        public final a f(TlsVersion... tlsVersionArr) {
            p31.f(tlsVersionArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.javaName());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return e((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public a(b bVar) {
            p31.f(bVar, "connectionSpec");
            this.a = bVar.f();
            this.b = bVar.c;
            this.c = bVar.d;
            this.d = bVar.h();
        }
    }
}
