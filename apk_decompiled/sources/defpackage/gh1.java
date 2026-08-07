package defpackage;

import android.opengl.Matrix;

/* JADX INFO: loaded from: classes.dex */
public abstract class gh1 {
    private static final float[] a = new float[16];

    private static void a(float[] fArr, float f, float f2) {
        Matrix.translateM(fArr, 0, -f, -f2, 0.0f);
    }

    private static void b(float[] fArr, float f, float f2) {
        Matrix.translateM(fArr, 0, f, f2, 0.0f);
    }

    public static void c(float[] fArr, float f, float f2, float f3) {
        b(fArr, f2, f3);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        a(fArr, f2, f3);
    }

    public static void d(float[] fArr, float f) {
        b(fArr, 0.0f, f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        a(fArr, 0.0f, f);
    }
}
