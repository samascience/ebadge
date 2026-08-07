package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ok1 {
    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean d(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    private static int e(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    static int f(float f, float f2) {
        return g((int) f, (int) f2);
    }

    private static int g(int i, int i2) {
        return i - (i2 * e(i, i2));
    }

    public static void h(vn2 vn2Var, Path path) {
        path.reset();
        PointF pointFB = vn2Var.b();
        path.moveTo(pointFB.x, pointFB.y);
        PointF pointF = new PointF(pointFB.x, pointFB.y);
        for (int i = 0; i < vn2Var.a().size(); i++) {
            d50 d50Var = (d50) vn2Var.a().get(i);
            PointF pointFA = d50Var.a();
            PointF pointFB2 = d50Var.b();
            PointF pointFC = d50Var.c();
            if (pointFA.equals(pointF) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            pointF.set(pointFC.x, pointFC.y);
        }
        if (vn2Var.d()) {
            path.close();
        }
    }

    public static double i(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float j(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int k(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static void l(d91 d91Var, int i, List list, d91 d91Var2, f91 f91Var) {
        if (d91Var.c(f91Var.getName(), i)) {
            list.add(d91Var2.a(f91Var.getName()).i(f91Var));
        }
    }
}
