package defpackage;

import com.tencent.open.SocialConstants;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class jd2 implements l31.a {
    private final gd2 a;
    private final List b;
    private final int c;
    private final qi0 d;
    private final df2 e;
    private final int f;
    private final int g;
    private final int h;
    private int i;

    public jd2(gd2 gd2Var, List list, int i, qi0 qi0Var, df2 df2Var, int i2, int i3, int i4) {
        p31.f(gd2Var, "call");
        p31.f(list, "interceptors");
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        this.a = gd2Var;
        this.b = list;
        this.c = i;
        this.d = qi0Var;
        this.e = df2Var;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    public static /* synthetic */ jd2 d(jd2 jd2Var, int i, qi0 qi0Var, df2 df2Var, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = jd2Var.c;
        }
        if ((i5 & 2) != 0) {
            qi0Var = jd2Var.d;
        }
        qi0 qi0Var2 = qi0Var;
        if ((i5 & 4) != 0) {
            df2Var = jd2Var.e;
        }
        df2 df2Var2 = df2Var;
        if ((i5 & 8) != 0) {
            i2 = jd2Var.f;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = jd2Var.g;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = jd2Var.h;
        }
        return jd2Var.c(i, qi0Var2, df2Var2, i6, i7, i4);
    }

    @Override // l31.a
    public eh2 a(df2 df2Var) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        if (this.c >= this.b.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.i++;
        qi0 qi0Var = this.d;
        if (qi0Var != null) {
            if (!qi0Var.j().g(df2Var.i())) {
                throw new IllegalStateException(("network interceptor " + this.b.get(this.c - 1) + " must retain the same host and port").toString());
            }
            if (this.i != 1) {
                throw new IllegalStateException(("network interceptor " + this.b.get(this.c - 1) + " must call proceed() exactly once").toString());
            }
        }
        jd2 jd2VarD = d(this, this.c + 1, null, df2Var, 0, 0, 0, 58, null);
        l31 l31Var = (l31) this.b.get(this.c);
        eh2 eh2VarIntercept = l31Var.intercept(jd2VarD);
        if (eh2VarIntercept == null) {
            throw new NullPointerException("interceptor " + l31Var + " returned null");
        }
        if (this.d != null && this.c + 1 < this.b.size() && jd2VarD.i != 1) {
            throw new IllegalStateException(("network interceptor " + l31Var + " must call proceed() exactly once").toString());
        }
        if (eh2VarIntercept.n() != null) {
            return eh2VarIntercept;
        }
        throw new IllegalStateException(("interceptor " + l31Var + " returned a response with no body").toString());
    }

    @Override // l31.a
    public p10 b() {
        qi0 qi0Var = this.d;
        if (qi0Var != null) {
            return qi0Var.h();
        }
        return null;
    }

    public final jd2 c(int i, qi0 qi0Var, df2 df2Var, int i2, int i3, int i4) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        return new jd2(this.a, this.b, i, qi0Var, df2Var, i2, i3, i4);
    }

    @Override // l31.a
    public eq call() {
        return this.a;
    }

    public final gd2 e() {
        return this.a;
    }

    public final int f() {
        return this.f;
    }

    public final qi0 g() {
        return this.d;
    }

    public final int h() {
        return this.g;
    }

    public final df2 i() {
        return this.e;
    }

    public final int j() {
        return this.h;
    }

    public int k() {
        return this.g;
    }

    @Override // l31.a
    public df2 request() {
        return this.e;
    }
}
