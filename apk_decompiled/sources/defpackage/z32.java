package defpackage;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class z32 extends l91 {
    private final PointF g;

    public z32(List list) {
        super(list);
        this.g = new PointF();
    }

    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF i(k91 k91Var, float f) {
        Object obj;
        PointF pointF;
        Object obj2 = k91Var.b;
        if (obj2 == null || (obj = k91Var.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) obj2;
        PointF pointF3 = (PointF) obj;
        re1 re1Var = this.e;
        if (re1Var != null && (pointF = (PointF) re1Var.b(k91Var.e, k91Var.f.floatValue(), pointF2, pointF3, f, e(), f())) != null) {
            return pointF;
        }
        PointF pointF4 = this.g;
        float f2 = pointF2.x;
        float f3 = f2 + ((pointF3.x - f2) * f);
        float f4 = pointF2.y;
        pointF4.set(f3, f4 + (f * (pointF3.y - f4)));
        return this.g;
    }
}
