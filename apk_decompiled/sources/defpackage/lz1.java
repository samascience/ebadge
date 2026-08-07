package defpackage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class lz1 extends l91 {
    private final PointF g;
    private final float[] h;
    private kz1 i;
    private PathMeasure j;

    public lz1(List list) {
        super(list);
        this.g = new PointF();
        this.h = new float[2];
    }

    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF i(k91 k91Var, float f) {
        PointF pointF;
        kz1 kz1Var = (kz1) k91Var;
        Path pathE = kz1Var.e();
        if (pathE == null) {
            return (PointF) k91Var.b;
        }
        re1 re1Var = this.e;
        if (re1Var != null && (pointF = (PointF) re1Var.b(kz1Var.e, kz1Var.f.floatValue(), kz1Var.b, kz1Var.c, e(), f, f())) != null) {
            return pointF;
        }
        if (this.i != kz1Var) {
            this.j = new PathMeasure(pathE, false);
            this.i = kz1Var;
        }
        PathMeasure pathMeasure = this.j;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.h, null);
        PointF pointF2 = this.g;
        float[] fArr = this.h;
        pointF2.set(fArr[0], fArr[1]);
        return this.g;
    }
}
