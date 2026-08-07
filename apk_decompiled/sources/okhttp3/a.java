package okhttp3;

import defpackage.p31;
import defpackage.y70;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.i;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final a A;
    public static final a A0;
    public static final a B;
    public static final a B0;
    public static final a C;
    public static final a C0;
    public static final a D;
    public static final a D0;
    public static final a E;
    public static final a E0;
    public static final a F;
    public static final a F0;
    public static final a G;
    public static final a G0;
    public static final a H;
    public static final a H0;
    public static final a I;
    public static final a I0;
    public static final a J;
    public static final a J0;
    public static final a K;
    public static final a K0;
    public static final a L;
    public static final a L0;
    public static final a M;
    public static final a M0;
    public static final a N;
    public static final a N0;
    public static final a O;
    public static final a O0;
    public static final a P;
    public static final a P0;
    public static final a Q;
    public static final a Q0;
    public static final a R;
    public static final a R0;
    public static final a S;
    public static final a S0;
    public static final a T;
    public static final a T0;
    public static final a U;
    public static final a U0;
    public static final a V;
    public static final a V0;
    public static final a W;
    public static final a W0;
    public static final a X;
    public static final a X0;
    public static final a Y;
    public static final a Y0;
    public static final a Z;
    public static final a Z0;
    public static final a a0;
    public static final a a1;
    public static final b b;
    public static final a b0;
    public static final a b1;
    private static final Comparator c;
    public static final a c0;
    public static final a c1;
    private static final Map d;
    public static final a d0;
    public static final a d1;
    public static final a e;
    public static final a e0;
    public static final a e1;
    public static final a f;
    public static final a f0;
    public static final a f1;
    public static final a g;
    public static final a g0;
    public static final a g1;
    public static final a h;
    public static final a h0;
    public static final a h1;
    public static final a i;
    public static final a i0;
    public static final a i1;
    public static final a j;
    public static final a j0;
    public static final a j1;
    public static final a k;
    public static final a k0;
    public static final a k1;
    public static final a l;
    public static final a l0;
    public static final a l1;
    public static final a m;
    public static final a m0;
    public static final a m1;
    public static final a n;
    public static final a n0;
    public static final a n1;
    public static final a o;
    public static final a o0;
    public static final a o1;
    public static final a p;
    public static final a p0;
    public static final a p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f366q;
    public static final a q0;
    public static final a q1;
    public static final a r;
    public static final a r0;
    public static final a r1;
    public static final a s;
    public static final a s0;
    public static final a s1;
    public static final a t;
    public static final a t0;
    public static final a u;
    public static final a u0;
    public static final a v;
    public static final a v0;
    public static final a w;
    public static final a w0;
    public static final a x;
    public static final a x0;
    public static final a y;
    public static final a y0;
    public static final a z;
    public static final a z0;
    private final String a;

    /* JADX INFO: renamed from: okhttp3.a$a, reason: collision with other inner class name */
    public static final class C0151a implements Comparator {
        C0151a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            p31.f(str, "a");
            p31.f(str2, "b");
            int iMin = Math.min(str.length(), str2.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt != cCharAt2) {
                    return p31.g(cCharAt, cCharAt2) < 0 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final a d(String str, int i) {
            a aVar = new a(str, null);
            a.d.put(str, aVar);
            return aVar;
        }

        private final String e(String str) {
            if (i.G(str, "TLS_", false, 2, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SSL_");
                String strSubstring = str.substring(4);
                p31.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                return sb.toString();
            }
            if (!i.G(str, "SSL_", false, 2, null)) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TLS_");
            String strSubstring2 = str.substring(4);
            p31.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(strSubstring2);
            return sb2.toString();
        }

        public final synchronized a b(String str) {
            a aVar;
            try {
                p31.f(str, "javaName");
                aVar = (a) a.d.get(str);
                if (aVar == null) {
                    aVar = (a) a.d.get(e(str));
                    if (aVar == null) {
                        aVar = new a(str, null);
                    }
                    a.d.put(str, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
            return aVar;
        }

        public final Comparator c() {
            return a.c;
        }

        private b() {
        }
    }

    static {
        b bVar = new b(null);
        b = bVar;
        c = new C0151a();
        d = new LinkedHashMap();
        e = bVar.d("SSL_RSA_WITH_NULL_MD5", 1);
        f = bVar.d("SSL_RSA_WITH_NULL_SHA", 2);
        g = bVar.d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        h = bVar.d("SSL_RSA_WITH_RC4_128_MD5", 4);
        i = bVar.d("SSL_RSA_WITH_RC4_128_SHA", 5);
        j = bVar.d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        k = bVar.d("SSL_RSA_WITH_DES_CBC_SHA", 9);
        l = bVar.d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m = bVar.d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        n = bVar.d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        o = bVar.d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        p = bVar.d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        f366q = bVar.d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        r = bVar.d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        s = bVar.d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        t = bVar.d("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        u = bVar.d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        v = bVar.d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        w = bVar.d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        x = bVar.d("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        y = bVar.d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        z = bVar.d("TLS_KRB5_WITH_RC4_128_SHA", 32);
        A = bVar.d("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        B = bVar.d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        C = bVar.d("TLS_KRB5_WITH_RC4_128_MD5", 36);
        D = bVar.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        E = bVar.d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        F = bVar.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        G = bVar.d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        H = bVar.d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        I = bVar.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        J = bVar.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        K = bVar.d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        L = bVar.d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        M = bVar.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        N = bVar.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        O = bVar.d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        P = bVar.d("TLS_RSA_WITH_NULL_SHA256", 59);
        Q = bVar.d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        R = bVar.d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        S = bVar.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        T = bVar.d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        U = bVar.d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        V = bVar.d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        W = bVar.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        X = bVar.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        Y = bVar.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        Z = bVar.d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        a0 = bVar.d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b0 = bVar.d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.IINC);
        c0 = bVar.d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", Opcodes.I2D);
        d0 = bVar.d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.L2I);
        e0 = bVar.d("TLS_PSK_WITH_RC4_128_SHA", Opcodes.L2D);
        f0 = bVar.d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", Opcodes.F2I);
        g0 = bVar.d("TLS_PSK_WITH_AES_128_CBC_SHA", Opcodes.F2L);
        h0 = bVar.d("TLS_PSK_WITH_AES_256_CBC_SHA", Opcodes.F2D);
        i0 = bVar.d("TLS_RSA_WITH_SEED_CBC_SHA", Opcodes.FCMPG);
        j0 = bVar.d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        k0 = bVar.d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        l0 = bVar.d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        m0 = bVar.d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
        n0 = bVar.d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        o0 = bVar.d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        p0 = bVar.d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        q0 = bVar.d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", Opcodes.GOTO);
        r0 = bVar.d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        s0 = bVar.d("TLS_FALLBACK_SCSV", 22016);
        t0 = bVar.d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        u0 = bVar.d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        v0 = bVar.d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        w0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        x0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        y0 = bVar.d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        z0 = bVar.d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        A0 = bVar.d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        B0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        C0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        D0 = bVar.d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        E0 = bVar.d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        F0 = bVar.d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        G0 = bVar.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        H0 = bVar.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        I0 = bVar.d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        J0 = bVar.d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        K0 = bVar.d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        L0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        M0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        N0 = bVar.d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        O0 = bVar.d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        P0 = bVar.d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        Q0 = bVar.d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        R0 = bVar.d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        S0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        T0 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        U0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        V0 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        W0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        X0 = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        Y0 = bVar.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        Z0 = bVar.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        a1 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        b1 = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        c1 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        d1 = bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        e1 = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f1 = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        g1 = bVar.d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        h1 = bVar.d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        i1 = bVar.d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        j1 = bVar.d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        k1 = bVar.d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        l1 = bVar.d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        m1 = bVar.d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        n1 = bVar.d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        o1 = bVar.d("TLS_AES_128_GCM_SHA256", 4865);
        p1 = bVar.d("TLS_AES_256_GCM_SHA384", 4866);
        q1 = bVar.d("TLS_CHACHA20_POLY1305_SHA256", 4867);
        r1 = bVar.d("TLS_AES_128_CCM_SHA256", 4868);
        s1 = bVar.d("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public /* synthetic */ a(String str, y70 y70Var) {
        this(str);
    }

    public final String c() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }

    private a(String str) {
        this.a = str;
    }
}
