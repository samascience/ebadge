package defpackage;

import com.tencent.open.SocialConstants;
import java.io.EOFException;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class cn2 {
    public static final b d = new b(null);
    private static final qx1 e;
    private static final ByteString f;
    private final so a;
    private final a b;
    private String c;

    public interface a {
        void a(long j);

        void b(String str, String str2, String str3);
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(so soVar, fo foVar) {
            foVar.I(10);
            soVar.X(foVar, soVar.K(cn2.f));
            soVar.J(c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long e(so soVar) {
            return pa3.W(soVar.n0(), -1L);
        }

        public final qx1 c() {
            return cn2.e;
        }

        private b() {
        }
    }

    static {
        qx1.a aVar = qx1.c;
        ByteString.a aVar2 = ByteString.Companion;
        e = aVar.d(aVar2.d("\r\n"), aVar2.d("\r"), aVar2.d("\n"), aVar2.d("data: "), aVar2.d("data:"), aVar2.d("data\r\n"), aVar2.d("data\r"), aVar2.d("data\n"), aVar2.d("id: "), aVar2.d("id:"), aVar2.d("id\r\n"), aVar2.d("id\r"), aVar2.d("id\n"), aVar2.d("event: "), aVar2.d("event:"), aVar2.d("event\r\n"), aVar2.d("event\r"), aVar2.d("event\n"), aVar2.d("retry: "), aVar2.d("retry:"));
        f = aVar2.d("\r\n");
    }

    public cn2(so soVar, a aVar) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        p31.f(aVar, "callback");
        this.a = soVar;
        this.b = aVar;
    }

    private final void c(String str, String str2, fo foVar) throws EOFException {
        if (foVar.size() != 0) {
            this.c = str;
            foVar.a(1L);
            this.b.b(str, str2, foVar.G0());
        }
    }

    public final boolean d() throws EOFException {
        String strN0 = this.c;
        fo foVar = new fo();
        while (true) {
            String strN1 = null;
            while (true) {
                so soVar = this.a;
                qx1 qx1Var = e;
                int iJ = soVar.J(qx1Var);
                if (iJ >= 0 && iJ < 3) {
                    c(strN0, strN1, foVar);
                    return true;
                }
                if (3 <= iJ && iJ < 5) {
                    d.d(this.a, foVar);
                } else if (5 <= iJ && iJ < 8) {
                    foVar.I(10);
                } else if (8 <= iJ && iJ < 10) {
                    strN0 = this.a.n0();
                    if (strN0.length() <= 0) {
                        strN0 = null;
                    }
                } else if (10 <= iJ && iJ < 13) {
                    strN0 = null;
                } else if (13 <= iJ && iJ < 15) {
                    strN1 = this.a.n0();
                    if (strN1.length() <= 0) {
                        break;
                    }
                } else {
                    if (15 <= iJ && iJ < 18) {
                        break;
                    }
                    if (18 <= iJ && iJ < 20) {
                        long jE = d.e(this.a);
                        if (jE != -1) {
                            this.b.a(jE);
                        }
                    } else {
                        if (iJ != -1) {
                            throw new AssertionError();
                        }
                        long jK = this.a.K(f);
                        if (jK == -1) {
                            return false;
                        }
                        this.a.a(jK);
                        this.a.J(qx1Var);
                    }
                }
            }
        }
    }
}
