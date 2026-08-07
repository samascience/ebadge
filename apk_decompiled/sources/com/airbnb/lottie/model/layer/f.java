package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import defpackage.bb3;
import defpackage.je1;
import defpackage.ne1;
import defpackage.re1;
import defpackage.tg;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    private final Layer A;
    private tg B;
    private final RectF w;
    private final Paint x;
    private final float[] y;
    private final Path z;

    f(je1 je1Var, Layer layer) {
        super(je1Var, layer);
        this.w = new RectF();
        Paint paint = new Paint();
        this.x = paint;
        this.y = new float[8];
        this.z = new Path();
        this.A = layer;
        paint.setAlpha(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(layer.m());
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.w.set(0.0f, 0.0f, this.A.o(), this.A.n());
        this.m.mapRect(this.w);
        rectF.set(this.w);
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.e91
    public void f(Object obj, re1 re1Var) {
        super.f(obj, re1Var);
        if (obj == ne1.x) {
            if (re1Var == null) {
                this.B = null;
            } else {
                this.B = new bb3(re1Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void n(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.A.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * ((Integer) this.u.g().h()).intValue()) / 100.0f) * 255.0f);
        this.x.setAlpha(iIntValue);
        tg tgVar = this.B;
        if (tgVar != null) {
            this.x.setColorFilter((ColorFilter) tgVar.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.y;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.A.o();
            float[] fArr2 = this.y;
            fArr2[3] = 0.0f;
            fArr2[4] = this.A.o();
            this.y[5] = this.A.n();
            float[] fArr3 = this.y;
            fArr3[6] = 0.0f;
            fArr3[7] = this.A.n();
            matrix.mapPoints(this.y);
            this.z.reset();
            Path path = this.z;
            float[] fArr4 = this.y;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.z;
            float[] fArr5 = this.y;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.z;
            float[] fArr6 = this.y;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.z;
            float[] fArr7 = this.y;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.z;
            float[] fArr8 = this.y;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.z.close();
            canvas.drawPath(this.z, this.x);
        }
    }
}
