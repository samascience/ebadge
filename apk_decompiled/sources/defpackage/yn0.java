package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yn0 extends l91 {
    public yn0(List list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Float i(k91 k91Var, float f) {
        Float f2;
        if (k91Var.b == null || k91Var.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        re1 re1Var = this.e;
        return (re1Var == null || (f2 = (Float) re1Var.b(k91Var.e, k91Var.f.floatValue(), k91Var.b, k91Var.c, f, e(), f())) == null) ? Float.valueOf(ok1.j(((Float) k91Var.b).floatValue(), ((Float) k91Var.c).floatValue(), f)) : f2;
    }
}
