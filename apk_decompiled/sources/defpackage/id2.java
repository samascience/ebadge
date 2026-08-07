package defpackage;

import com.tencent.open.SocialConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class id2 implements hi0, cn2.a, gq {
    private final df2 a;
    private final ii0 b;
    private gd2 c;

    public id2(df2 df2Var, ii0 ii0Var) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        p31.f(ii0Var, "listener");
        this.a = df2Var;
        this.b = ii0Var;
    }

    private final boolean d(fh2 fh2Var) {
        fi1 fi1VarContentType = fh2Var.contentType();
        return fi1VarContentType != null && p31.a(fi1VarContentType.i(), "text") && p31.a(fi1VarContentType.h(), "event-stream");
    }

    @Override // cn2.a
    public void a(long j) {
    }

    @Override // cn2.a
    public void b(String str, String str2, String str3) {
        p31.f(str3, "data");
        this.b.b(this, str, str2, str3);
    }

    public final void c(zt1 zt1Var) {
        p31.f(zt1Var, "client");
        eq eqVarA = zt1Var.y().i(fi0.b).b().a(this.a);
        p31.d(eqVarA, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall");
        gd2 gd2Var = (gd2) eqVarA;
        this.c = gd2Var;
        if (gd2Var == null) {
            p31.t("call");
            gd2Var = null;
        }
        gd2Var.n(this);
    }

    public final void e(eh2 eh2Var) throws IOException {
        p31.f(eh2Var, "response");
        try {
            if (!eh2Var.k0()) {
                this.b.c(this, null, eh2Var);
                ty.a(eh2Var, null);
                return;
            }
            fh2 fh2VarN = eh2Var.n();
            p31.c(fh2VarN);
            if (!d(fh2VarN)) {
                this.b.c(this, new IllegalStateException("Invalid content-type: " + fh2VarN.contentType()), eh2Var);
                ty.a(eh2Var, null);
                return;
            }
            gd2 gd2Var = this.c;
            if (gd2Var == null) {
                p31.t("call");
                gd2Var = null;
            }
            gd2Var.y();
            eh2 eh2VarC = eh2Var.w0().b(pa3.c).c();
            cn2 cn2Var = new cn2(fh2VarN.source(), this);
            try {
                this.b.d(this, eh2VarC);
                do {
                } while (cn2Var.d());
                this.b.a(this);
                k83 k83Var = k83.a;
                ty.a(eh2Var, null);
            } catch (Exception e) {
                this.b.c(this, e, eh2VarC);
                ty.a(eh2Var, null);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ty.a(eh2Var, th);
                throw th2;
            }
        }
    }

    @Override // defpackage.gq
    public void onFailure(eq eqVar, IOException iOException) {
        p31.f(eqVar, "call");
        p31.f(iOException, "e");
        this.b.c(this, iOException, null);
    }

    @Override // defpackage.gq
    public void onResponse(eq eqVar, eh2 eh2Var) throws IOException {
        p31.f(eqVar, "call");
        p31.f(eh2Var, "response");
        e(eh2Var);
    }
}
