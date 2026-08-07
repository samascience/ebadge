package com.soundcloud.android.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
class e {
    private Bitmap a;
    private int b;

    public e(Bitmap bitmap, int i) {
        this.a = bitmap;
        this.b = i % 360;
    }

    public Bitmap a() {
        return this.a;
    }

    public int b() {
        if (this.a == null) {
            return 0;
        }
        return f() ? this.a.getWidth() : this.a.getHeight();
    }

    public Matrix c() {
        Matrix matrix = new Matrix();
        Bitmap bitmap = this.a;
        if (bitmap != null && this.b != 0) {
            matrix.preTranslate(-(bitmap.getWidth() / 2), -(this.a.getHeight() / 2));
            matrix.postRotate(this.b);
            matrix.postTranslate(e() / 2, b() / 2);
        }
        return matrix;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        if (this.a == null) {
            return 0;
        }
        return f() ? this.a.getHeight() : this.a.getWidth();
    }

    public boolean f() {
        return (this.b / 90) % 2 != 0;
    }

    public void g() {
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            bitmap.recycle();
            this.a = null;
        }
    }

    public void h(Bitmap bitmap) {
        this.a = bitmap;
    }

    public void i(int i) {
        this.b = i;
    }
}
