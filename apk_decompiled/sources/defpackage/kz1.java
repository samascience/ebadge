package defpackage;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class kz1 extends k91 {
    private Path k;

    public kz1(fe1 fe1Var, k91 k91Var) {
        Object obj;
        super(fe1Var, k91Var.b, k91Var.c, k91Var.d, k91Var.e, k91Var.f);
        Object obj2 = this.c;
        boolean z = (obj2 == null || (obj = this.b) == null || !((PointF) obj).equals(((PointF) obj2).x, ((PointF) obj2).y)) ? false : true;
        Object obj3 = this.c;
        if (obj3 == null || z) {
            return;
        }
        this.k = ya3.d((PointF) this.b, (PointF) obj3, k91Var.i, k91Var.j);
    }

    Path e() {
        return this.k;
    }
}
