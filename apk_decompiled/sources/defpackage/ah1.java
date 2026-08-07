package defpackage;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ah1 {
    public static void a(PointF pointF, float f, Double d, List list) {
        float fSin;
        if (d != null) {
            double dAtan = (float) Math.atan(d.doubleValue());
            double d2 = f;
            float fCos = (float) (Math.cos(dAtan) * d2);
            fSin = (float) (Math.sin(dAtan) * d2);
            f = fCos;
        } else {
            fSin = 0.0f;
        }
        list.add(new PointF(pointF.x + f, pointF.y + fSin));
        list.add(new PointF(pointF.x - f, pointF.y - fSin));
    }

    public static float b(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    public static int c(PointF pointF, PointF pointF2) {
        float f = pointF.x;
        float f2 = pointF2.x;
        if (f > f2) {
            float f3 = pointF.y;
            float f4 = pointF2.y;
            if (f3 > f4) {
                return 4;
            }
            return f3 < f4 ? 1 : -1;
        }
        if (f >= f2) {
            return -1;
        }
        float f5 = pointF.y;
        float f6 = pointF2.y;
        if (f5 > f6) {
            return 3;
        }
        return f5 < f6 ? 2 : -1;
    }

    public static double d(double d, int i) {
        if (d < 0.0d) {
            d += 1.5707963267948966d;
        }
        return d + (((double) (i - 1)) * 1.5707963267948966d);
    }

    public static double e(double d) {
        return (d / 6.283185307179586d) * 360.0d;
    }
}
