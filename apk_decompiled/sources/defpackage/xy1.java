package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.v;

/* JADX INFO: loaded from: classes.dex */
public abstract class xy1 {
    public static xy1 j(Bitmap bitmap, bj0 bj0Var, Rect rect, int i, Matrix matrix, cs csVar) {
        return new md(bitmap, bj0Var, 42, new Size(bitmap.getWidth(), bitmap.getHeight()), rect, i, matrix, csVar);
    }

    public static xy1 k(v vVar, bj0 bj0Var, Rect rect, int i, Matrix matrix, cs csVar) {
        return l(vVar, bj0Var, new Size(vVar.getWidth(), vVar.getHeight()), rect, i, matrix, csVar);
    }

    public static xy1 l(v vVar, bj0 bj0Var, Size size, Rect rect, int i, Matrix matrix, cs csVar) {
        if (ImageUtil.i(vVar.q())) {
            b52.h(bj0Var, "JPEG image must have Exif.");
        }
        return new md(vVar, bj0Var, vVar.q(), size, rect, i, matrix, csVar);
    }

    public static xy1 m(byte[] bArr, bj0 bj0Var, int i, Size size, Rect rect, int i2, Matrix matrix, cs csVar) {
        return new md(bArr, bj0Var, i, size, rect, i2, matrix, csVar);
    }

    public abstract cs a();

    public abstract Rect b();

    public abstract Object c();

    public abstract bj0 d();

    public abstract int e();

    public abstract int f();

    public abstract Matrix g();

    public abstract Size h();

    public boolean i() {
        return y43.h(b(), h());
    }
}
