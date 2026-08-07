package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.x;
import defpackage.b52;
import defpackage.pu;
import defpackage.y43;

/* JADX INFO: loaded from: classes.dex */
final class e {
    private static final PreviewView.ScaleType i = PreviewView.ScaleType.FILL_CENTER;
    private Size a;
    private Rect b;
    private int c;
    private Matrix d;
    private int e;
    private boolean f;
    private boolean g;
    private PreviewView.ScaleType h = i;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PreviewView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PreviewView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PreviewView.ScaleType.FILL_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PreviewView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[PreviewView.ScaleType.FILL_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    e() {
    }

    private static RectF b(RectF rectF, float f) {
        float f2 = f + f;
        return new RectF(f2 - rectF.right, rectF.top, f2 - rectF.left, rectF.bottom);
    }

    private int e() {
        return !this.g ? this.c : -pu.b(this.e);
    }

    private Size f() {
        return y43.i(this.c) ? new Size(this.b.height(), this.b.width()) : new Size(this.b.width(), this.b.height());
    }

    private RectF l(Size size, int i2) {
        b52.i(m());
        Matrix matrixJ = j(size, i2);
        RectF rectF = new RectF(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight());
        matrixJ.mapRect(rectF);
        return rectF;
    }

    private boolean m() {
        return (this.b == null || this.a == null || !(!this.g || this.e != -1)) ? false : true;
    }

    private static void p(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.ScaleType scaleType) {
        Matrix.ScaleToFit scaleToFit;
        switch (a.a[scaleType.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                x.c("PreviewTransform", "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
        } else {
            matrix.setRectToRect(rectF2, rectF, scaleToFit);
            matrix.invert(matrix);
        }
    }

    Bitmap a(Bitmap bitmap, Size size, int i2) {
        if (!m()) {
            return bitmap;
        }
        Matrix matrixK = k();
        RectF rectFL = l(size, i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(matrixK);
        matrix.postScale(rectFL.width() / this.a.getWidth(), rectFL.height() / this.a.getHeight());
        matrix.postTranslate(rectFL.left, rectFL.top);
        canvas.drawBitmap(bitmap, matrix, new Paint(7));
        return bitmapCreateBitmap;
    }

    Matrix c(Size size, int i2) {
        if (!m()) {
            return null;
        }
        Matrix matrix = new Matrix();
        j(size, i2).invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    RectF d(Size size, int i2) {
        RectF rectF = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        Size sizeF = f();
        RectF rectF2 = new RectF(0.0f, 0.0f, sizeF.getWidth(), sizeF.getHeight());
        Matrix matrix = new Matrix();
        p(matrix, rectF2, rectF, this.h);
        matrix.mapRect(rectF2);
        return i2 == 1 ? b(rectF2, size.getWidth() / 2.0f) : rectF2;
    }

    PreviewView.ScaleType g() {
        return this.h;
    }

    Matrix h(Size size, int i2) {
        if (!m()) {
            return null;
        }
        Matrix matrix = new Matrix(this.d);
        matrix.postConcat(j(size, i2));
        return matrix;
    }

    Rect i() {
        return this.b;
    }

    Matrix j(Size size, int i2) {
        b52.i(m());
        Matrix matrixD = y43.d(new RectF(this.b), n(size) ? new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()) : d(size, i2), this.c);
        if (this.f && this.g) {
            if (y43.i(this.c)) {
                matrixD.preScale(1.0f, -1.0f, this.b.centerX(), this.b.centerY());
            } else {
                matrixD.preScale(-1.0f, 1.0f, this.b.centerX(), this.b.centerY());
            }
        }
        return matrixD;
    }

    Matrix k() {
        b52.i(m());
        RectF rectF = new RectF(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight());
        return y43.d(rectF, rectF, e());
    }

    boolean n(Size size) {
        return y43.k(size, true, f(), false);
    }

    void o(int i2, int i3) {
        if (this.g) {
            this.c = i2;
            this.e = i3;
        }
    }

    void q(PreviewView.ScaleType scaleType) {
        this.h = scaleType;
    }

    void r(SurfaceRequest.g gVar, Size size, boolean z) {
        x.a("PreviewTransform", "Transformation info set: " + gVar + " " + size + " " + z);
        this.b = gVar.a();
        this.c = gVar.b();
        this.e = gVar.d();
        this.a = size;
        this.f = z;
        this.g = gVar.e();
        this.d = gVar.c();
    }

    void s(Size size, int i2, View view) {
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            x.k("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
            return;
        }
        if (m()) {
            if (view instanceof TextureView) {
                ((TextureView) view).setTransform(k());
            } else {
                Display display = view.getDisplay();
                boolean z = false;
                boolean z2 = (!this.g || display == null || display.getRotation() == this.e) ? false : true;
                if (!this.g && e() != 0) {
                    z = true;
                }
                if (z2 || z) {
                    x.c("PreviewTransform", "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                }
            }
            RectF rectFL = l(size, i2);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(rectFL.width() / this.a.getWidth());
            view.setScaleY(rectFL.height() / this.a.getHeight());
            view.setTranslationX(rectFL.left - view.getLeft());
            view.setTranslationY(rectFL.top - view.getTop());
        }
    }
}
