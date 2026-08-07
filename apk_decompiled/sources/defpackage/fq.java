package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.text.i;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: loaded from: classes4.dex */
public final class fq implements l31 {
    private final boolean a;

    public fq(boolean z) {
        this.a = z;
    }

    private final boolean a(int i) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0099 A[Catch: IOException -> 0x006a, TRY_LEAVE, TryCatch #0 {IOException -> 0x006a, blocks: (B:17:0x0055, B:19:0x005b, B:30:0x0093, B:32:0x0099, B:22:0x006c, B:23:0x007b, B:25:0x0088), top: B:83:0x002c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3, types: [eh2$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v4, types: [eh2$a] */
    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) throws IOException {
        boolean z;
        ?? r9;
        ?? R;
        eh2.a aVar2;
        p31.f(aVar, "chain");
        jd2 jd2Var = (jd2) aVar;
        qi0 qi0VarG = jd2Var.g();
        p31.c(qi0VarG);
        df2 df2VarI = jd2Var.i();
        ff2 ff2VarA = df2VarI.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            qi0VarG.w(df2VarI);
            ?? A = rx0.a(df2VarI.g());
            try {
                if (A == 0 || ff2VarA == null) {
                    qi0VarG.p();
                    z = true;
                    A = 0;
                } else {
                    if (i.v("100-continue", df2VarI.d("Expect"), true)) {
                        qi0VarG.f();
                        eh2.a aVarR = qi0VarG.r(true);
                        try {
                            qi0VarG.t();
                            z = false;
                            aVar2 = aVarR;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            r9 = aVarR;
                            if (e instanceof ConnectionShutdownException) {
                                throw e;
                            }
                            if (!qi0VarG.k()) {
                                R = r9;
                                throw e;
                            }
                        }
                    } else {
                        z = true;
                        aVar2 = null;
                    }
                    if (aVar2 != null) {
                        qi0VarG.p();
                        if (!qi0VarG.h().w()) {
                            A = aVar2;
                            qi0VarG.o();
                            A = aVar2;
                        }
                    } else if (ff2VarA.isDuplex()) {
                        qi0VarG.f();
                        ff2VarA.writeTo(hu1.a(qi0VarG.c(df2VarI, true)));
                    } else {
                        ro roVarA = hu1.a(qi0VarG.c(df2VarI, false));
                        ff2VarA.writeTo(roVarA);
                        roVarA.close();
                    }
                }
                if (ff2VarA != null) {
                    A = aVar2;
                    if (!ff2VarA.isDuplex()) {
                        A = aVar2;
                        A = aVar2;
                        A = aVar2;
                        qi0VarG.e();
                    }
                } else {
                    A = aVar2;
                    A = aVar2;
                    A = aVar2;
                    qi0VarG.e();
                }
                A = aVar2;
                e = null;
                R = A;
            } catch (IOException e2) {
                e = e2;
                r9 = A;
            }
        } catch (IOException e3) {
            e = e3;
            z = true;
            r9 = 0;
        }
        if (R == 0) {
            try {
                R = qi0VarG.r(false);
                p31.c(R);
                if (z) {
                    qi0VarG.t();
                    z = false;
                }
            } catch (IOException e4) {
                if (e == null) {
                    throw e4;
                }
                oi0.a(e, e4);
                throw e;
            }
        }
        eh2 eh2VarC = R.r(df2VarI).i(qi0VarG.h().s()).s(jCurrentTimeMillis).q(System.currentTimeMillis()).c();
        int iC = eh2VarC.C();
        if (a(iC)) {
            eh2.a aVarR2 = qi0VarG.r(false);
            p31.c(aVarR2);
            if (z) {
                qi0VarG.t();
            }
            eh2VarC = aVarR2.r(df2VarI).i(qi0VarG.h().s()).s(jCurrentTimeMillis).q(System.currentTimeMillis()).c();
            iC = eh2VarC.C();
        }
        qi0VarG.s(eh2VarC);
        eh2 eh2VarC2 = (this.a && iC == 101) ? eh2VarC.w0().b(pa3.c).c() : eh2VarC.w0().b(qi0VarG.q(eh2VarC)).c();
        if (i.v("close", eh2VarC2.G0().d("Connection"), true) || i.v("close", eh2.g0(eh2VarC2, "Connection", null, 2, null), true)) {
            qi0VarG.o();
        }
        if (iC == 204 || iC == 205) {
            fh2 fh2VarN = eh2VarC2.n();
            if ((fh2VarN != null ? fh2VarN.contentLength() : -1L) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(iC);
                sb.append(" had non-zero Content-Length: ");
                fh2 fh2VarN2 = eh2VarC2.n();
                sb.append(fh2VarN2 != null ? Long.valueOf(fh2VarN2.contentLength()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return eh2VarC2;
    }
}
