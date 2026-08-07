package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h31 extends l91 {
    public h31(List list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer i(k91 k91Var, float f) {
        Integer num;
        if (k91Var.b == null || k91Var.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        re1 re1Var = this.e;
        return (re1Var == null || (num = (Integer) re1Var.b(k91Var.e, k91Var.f.floatValue(), k91Var.b, k91Var.c, f, e(), f())) == null) ? Integer.valueOf(ok1.k(((Integer) k91Var.b).intValue(), ((Integer) k91Var.c).intValue(), f)) : num;
    }
}
