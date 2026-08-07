package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class iz extends l91 {
    public iz(List list) {
        super(list);
    }

    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer i(k91 k91Var, float f) {
        Integer num;
        Object obj = k91Var.b;
        if (obj == null || k91Var.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        Integer num2 = (Integer) obj;
        int iIntValue = num2.intValue();
        Integer num3 = (Integer) k91Var.c;
        int iIntValue2 = num3.intValue();
        re1 re1Var = this.e;
        return (re1Var == null || (num = (Integer) re1Var.b(k91Var.e, k91Var.f.floatValue(), num2, num3, f, e(), f())) == null) ? Integer.valueOf(us0.c(f, iIntValue, iIntValue2)) : num;
    }
}
