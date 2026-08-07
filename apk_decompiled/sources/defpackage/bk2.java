package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bk2 extends l91 {
    public bk2(List list) {
        super(list);
    }

    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ck2 i(k91 k91Var, float f) {
        Object obj;
        ck2 ck2Var;
        Object obj2 = k91Var.b;
        if (obj2 == null || (obj = k91Var.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ck2 ck2Var2 = (ck2) obj2;
        ck2 ck2Var3 = (ck2) obj;
        re1 re1Var = this.e;
        return (re1Var == null || (ck2Var = (ck2) re1Var.b(k91Var.e, k91Var.f.floatValue(), ck2Var2, ck2Var3, f, e(), f())) == null) ? new ck2(ok1.j(ck2Var2.a(), ck2Var3.a(), f), ok1.j(ck2Var2.b(), ck2Var3.b(), f)) : ck2Var;
    }
}
