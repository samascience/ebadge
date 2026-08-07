package defpackage;

import kotlin.text.i;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes4.dex */
public final class up implements l31 {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final iw0 c(iw0 iw0Var, iw0 iw0Var2) {
            iw0.a aVar = new iw0.a();
            int size = iw0Var.size();
            for (int i = 0; i < size; i++) {
                String strB = iw0Var.b(i);
                String strG = iw0Var.g(i);
                if ((!i.v("Warning", strB, true) || !i.G(strG, "1", false, 2, null)) && (d(strB) || !e(strB) || iw0Var2.a(strB) == null)) {
                    aVar.c(strB, strG);
                }
            }
            int size2 = iw0Var2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strB2 = iw0Var2.b(i2);
                if (!d(strB2) && e(strB2)) {
                    aVar.c(strB2, iw0Var2.g(i2));
                }
            }
            return aVar.e();
        }

        private final boolean d(String str) {
            return i.v("Content-Length", str, true) || i.v("Content-Encoding", str, true) || i.v("Content-Type", str, true);
        }

        private final boolean e(String str) {
            return (i.v("Connection", str, true) || i.v("Keep-Alive", str, true) || i.v("Proxy-Authenticate", str, true) || i.v("Proxy-Authorization", str, true) || i.v("TE", str, true) || i.v("Trailers", str, true) || i.v("Transfer-Encoding", str, true) || i.v("Upgrade", str, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final eh2 f(eh2 eh2Var) {
            return (eh2Var != null ? eh2Var.n() : null) != null ? eh2Var.w0().b(null).c() : eh2Var;
        }

        private a() {
        }
    }

    public up(sp spVar) {
    }

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) {
        fi0 fi0VarL;
        p31.f(aVar, "chain");
        eq eqVarCall = aVar.call();
        vp vpVarB = new vp.b(System.currentTimeMillis(), aVar.request(), null).b();
        df2 df2VarB = vpVarB.b();
        eh2 eh2VarA = vpVarB.a();
        gd2 gd2Var = eqVarCall instanceof gd2 ? (gd2) eqVarCall : null;
        if (gd2Var == null || (fi0VarL = gd2Var.l()) == null) {
            fi0VarL = fi0.b;
        }
        if (df2VarB == null && eh2VarA == null) {
            eh2 eh2VarC = new eh2.a().r(aVar.request()).p(Protocol.HTTP_1_1).g(504).m("Unsatisfiable Request (only-if-cached)").b(pa3.c).s(-1L).q(System.currentTimeMillis()).c();
            fi0VarL.z(eqVarCall, eh2VarC);
            return eh2VarC;
        }
        if (df2VarB == null) {
            p31.c(eh2VarA);
            eh2 eh2VarC2 = eh2VarA.w0().d(a.f(eh2VarA)).c();
            fi0VarL.b(eqVarCall, eh2VarC2);
            return eh2VarC2;
        }
        if (eh2VarA != null) {
            fi0VarL.a(eqVarCall, eh2VarA);
        }
        eh2 eh2VarA2 = aVar.a(df2VarB);
        if (eh2VarA != null) {
            if (eh2VarA2 != null && eh2VarA2.C() == 304) {
                eh2.a aVarW0 = eh2VarA.w0();
                a aVar2 = a;
                aVarW0.k(aVar2.c(eh2VarA.j0(), eh2VarA2.j0())).s(eh2VarA2.H0()).q(eh2VarA2.F0()).d(aVar2.f(eh2VarA)).n(aVar2.f(eh2VarA2)).c();
                fh2 fh2VarN = eh2VarA2.n();
                p31.c(fh2VarN);
                fh2VarN.close();
                p31.c(null);
                throw null;
            }
            fh2 fh2VarN2 = eh2VarA.n();
            if (fh2VarN2 != null) {
                pa3.m(fh2VarN2);
            }
        }
        p31.c(eh2VarA2);
        eh2.a aVarW1 = eh2VarA2.w0();
        a aVar3 = a;
        return aVarW1.d(aVar3.f(eh2VarA)).n(aVar3.f(eh2VarA2)).c();
    }
}
