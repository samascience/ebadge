package defpackage;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class m91 {
    private static final Interpolator a = new LinearInterpolator();
    private static ns2 b;

    private static WeakReference a(int i) {
        WeakReference weakReference;
        synchronized (m91.class) {
            weakReference = (WeakReference) e().d(i);
        }
        return weakReference;
    }

    static k91 b(JsonReader jsonReader, fe1 fe1Var, float f, eb3 eb3Var, boolean z) {
        return z ? c(fe1Var, jsonReader, f, eb3Var) : d(jsonReader, f, eb3Var);
    }

    private static k91 c(fe1 fe1Var, JsonReader jsonReader, float f, eb3 eb3Var) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFE = null;
        PointF pointFE2 = null;
        Object objA = null;
        Object objA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    objA2 = eb3Var.a(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "i":
                    pointFE2 = s71.e(jsonReader, f);
                    break;
                case "o":
                    pointFE = s71.e(jsonReader, f);
                    break;
                case "s":
                    objA = eb3Var.a(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFE4 = s71.e(jsonReader, f);
                    break;
                case "to":
                    pointFE3 = s71.e(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = a;
            objA2 = objA;
        } else if (pointFE == null || pointFE2 == null) {
            interpolator = a;
        } else {
            float f2 = -f;
            pointFE.x = ok1.b(pointFE.x, f2, f);
            pointFE.y = ok1.b(pointFE.y, -100.0f, 100.0f);
            pointFE2.x = ok1.b(pointFE2.x, f2, f);
            float fB = ok1.b(pointFE2.y, -100.0f, 100.0f);
            pointFE2.y = fB;
            int iG = ya3.g(pointFE.x, pointFE.y, pointFE2.x, fB);
            WeakReference weakReferenceA = a(iG);
            Interpolator interpolatorA = weakReferenceA != null ? (Interpolator) weakReferenceA.get() : null;
            if (weakReferenceA == null || interpolatorA == null) {
                interpolatorA = jz1.a(pointFE.x / f, pointFE.y / f, pointFE2.x / f, pointFE2.y / f);
                try {
                    f(iG, new WeakReference(interpolatorA));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            interpolator = interpolatorA;
        }
        k91 k91Var = new k91(fe1Var, objA, objA2, interpolator, fNextDouble, null);
        k91Var.i = pointFE3;
        k91Var.j = pointFE4;
        return k91Var;
    }

    private static k91 d(JsonReader jsonReader, float f, eb3 eb3Var) {
        return new k91(eb3Var.a(jsonReader, f));
    }

    private static ns2 e() {
        if (b == null) {
            b = new ns2();
        }
        return b;
    }

    private static void f(int i, WeakReference weakReference) {
        synchronized (m91.class) {
            b.g(i, weakReference);
        }
    }
}
