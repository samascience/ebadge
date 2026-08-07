package defpackage;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes.dex */
public final class yy2 {
    final vv0 a;
    final gn2 b;

    public yy2(gn2 gn2Var) {
        this.a = jy.b(gn2Var.h().getValue());
        this.b = gn2Var;
    }

    public u50 a(wv0 wv0Var) {
        return this.a.b(new xv0(wv0Var, this.b));
    }

    public Flowable b(wv0 wv0Var) {
        return this.a.a(new xv0(wv0Var, this.b));
    }
}
