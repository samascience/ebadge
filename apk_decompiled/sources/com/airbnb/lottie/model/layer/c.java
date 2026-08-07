package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.bb3;
import defpackage.je1;
import defpackage.ne1;
import defpackage.re1;
import defpackage.tg;
import defpackage.ya3;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private final Paint w;
    private final Rect x;
    private final Rect y;
    private tg z;

    c(je1 je1Var, Layer layer) {
        super(je1Var, layer);
        this.w = new Paint(3);
        this.x = new Rect();
        this.y = new Rect();
    }

    private Bitmap D() {
        return this.n.n(this.o.k());
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        Bitmap bitmapD = D();
        if (bitmapD != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, bitmapD.getWidth()), Math.min(rectF.bottom, bitmapD.getHeight()));
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.e91
    public void f(Object obj, re1 re1Var) {
        super.f(obj, re1Var);
        if (obj == ne1.x) {
            if (re1Var == null) {
                this.z = null;
            } else {
                this.z = new bb3(re1Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void n(Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapD = D();
        if (bitmapD == null || bitmapD.isRecycled()) {
            return;
        }
        float fE = ya3.e();
        this.w.setAlpha(i);
        tg tgVar = this.z;
        if (tgVar != null) {
            this.w.setColorFilter((ColorFilter) tgVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.x.set(0, 0, bitmapD.getWidth(), bitmapD.getHeight());
        this.y.set(0, 0, (int) (bitmapD.getWidth() * fE), (int) (bitmapD.getHeight() * fE));
        canvas.drawBitmap(bitmapD, this.x, this.y, this.w);
        canvas.restore();
    }
}
