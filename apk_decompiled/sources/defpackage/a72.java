package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class a72 implements uw1 {
    a72() {
    }

    private static xy1 b(k72 k72Var, bj0 bj0Var, v vVar) {
        return xy1.k(vVar, bj0Var, k72Var.b(), k72Var.f(), k72Var.g(), d(vVar));
    }

    private static xy1 c(k72 k72Var, bj0 bj0Var, v vVar) {
        Size size = new Size(vVar.getWidth(), vVar.getHeight());
        int iF = k72Var.f() - bj0Var.s();
        Size sizeE = e(iF, size);
        Matrix matrixD = y43.d(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), new RectF(0.0f, 0.0f, sizeE.getWidth(), sizeE.getHeight()), iF);
        return xy1.l(vVar, bj0Var, sizeE, f(k72Var.b(), matrixD), bj0Var.s(), g(k72Var.g(), matrixD), d(vVar));
    }

    private static cs d(v vVar) {
        return vVar.h0() instanceof ds ? ((ds) vVar.h0()).e() : cs.a.l();
    }

    private static Size e(int i, Size size) {
        return y43.i(y43.v(i)) ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    private static Rect f(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    private static Matrix g(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    @Override // defpackage.uw1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public xy1 apply(j72.b bVar) throws ImageCaptureException {
        bj0 bj0VarJ;
        v vVarA = bVar.a();
        k72 k72VarB = bVar.b();
        if (ImageUtil.i(vVarA.q())) {
            try {
                bj0VarJ = bj0.j(vVarA);
                vVarA.r()[0].b().rewind();
            } catch (IOException e) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e);
            }
        } else {
            bj0VarJ = null;
        }
        if (!r01.g.b(vVarA)) {
            return b(k72VarB, bj0VarJ, vVarA);
        }
        b52.h(bj0VarJ, "JPEG image must have exif.");
        return c(k72VarB, bj0VarJ, vVarA);
    }
}
