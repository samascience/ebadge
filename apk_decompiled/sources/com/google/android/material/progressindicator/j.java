package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.ch1;
import defpackage.eh1;
import defpackage.og1;

/* JADX INFO: loaded from: classes3.dex */
final class j extends g {
    private float b;
    private float c;
    private float d;
    private boolean e;
    private float f;

    j(m mVar) {
        super(mVar);
        this.b = 300.0f;
    }

    private void h(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        float fA = eh1.a(f, 0.0f, 1.0f);
        float fA2 = eh1.a(f2, 0.0f, 1.0f);
        float fD = ch1.d(1.0f - this.f, 1.0f, fA);
        float fD2 = ch1.d(1.0f - this.f, 1.0f, fA2);
        int iA = (int) ((i2 * eh1.a(fD, 0.0f, 0.01f)) / 0.01f);
        int iA2 = (int) ((i3 * (1.0f - eh1.a(fD2, 0.99f, 1.0f))) / 0.01f);
        float f3 = this.b;
        int i4 = (int) ((fD * f3) + iA);
        int i5 = (int) ((fD2 * f3) - iA2);
        float f4 = (-f3) / 2.0f;
        if (i4 <= i5) {
            float f5 = this.d;
            float f6 = i4 + f5;
            float f7 = i5 - f5;
            float f8 = f5 * 2.0f;
            paint.setColor(i);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.c);
            if (f6 >= f7) {
                j(canvas, paint, new PointF(f6 + f4, 0.0f), new PointF(f7 + f4, 0.0f), f8, this.c);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f9 = f6 + f4;
            float f10 = f7 + f4;
            canvas.drawLine(f9, 0.0f, f10, 0.0f, paint);
            if (this.e || this.d <= 0.0f) {
                return;
            }
            paint.setStyle(Paint.Style.FILL);
            if (f6 > 0.0f) {
                i(canvas, paint, new PointF(f9, 0.0f), f8, this.c);
            }
            if (f7 < this.b) {
                i(canvas, paint, new PointF(f10, 0.0f), f8, this.c);
            }
        }
    }

    private void i(Canvas canvas, Paint paint, PointF pointF, float f, float f2) {
        j(canvas, paint, pointF, null, f, f2);
    }

    private void j(Canvas canvas, Paint paint, PointF pointF, PointF pointF2, float f, float f2) {
        float fMin = Math.min(f2, this.c);
        float f3 = f / 2.0f;
        float fMin2 = Math.min(f3, (this.d * fMin) / this.c);
        RectF rectF = new RectF((-f) / 2.0f, (-fMin) / 2.0f, f3, fMin / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.g
    void a(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        this.b = rect.width();
        float f2 = ((m) this.a).a;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - f2) / 2.0f));
        if (((m) this.a).j) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f3 = this.b / 2.0f;
        float f4 = f2 / 2.0f;
        canvas.clipRect(-f3, -f4, f3, f4);
        a aVar = this.a;
        this.e = ((m) aVar).a / 2 == ((m) aVar).b;
        this.c = ((m) aVar).a * f;
        this.d = Math.min(((m) aVar).a / 2, ((m) aVar).b) * f;
        if (z || z2) {
            if ((z && ((m) this.a).e == 2) || (z2 && ((m) this.a).f == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && ((m) this.a).f != 3)) {
                canvas.translate(0.0f, (((m) this.a).a * (1.0f - f)) / 2.0f);
            }
        }
        if (z2 && ((m) this.a).f == 3) {
            this.f = f;
        } else {
            this.f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.g
    void b(Canvas canvas, Paint paint, int i, int i2) {
        int iA = og1.a(i, i2);
        if (((m) this.a).k <= 0 || iA == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iA);
        PointF pointF = new PointF((this.b / 2.0f) - (this.c / 2.0f), 0.0f);
        a aVar = this.a;
        i(canvas, paint, pointF, ((m) aVar).k, ((m) aVar).k);
    }

    @Override // com.google.android.material.progressindicator.g
    void c(Canvas canvas, Paint paint, g.a aVar, int i) {
        int iA = og1.a(aVar.c, i);
        float f = aVar.a;
        float f2 = aVar.b;
        int i2 = aVar.d;
        h(canvas, paint, f, f2, iA, i2, i2);
    }

    @Override // com.google.android.material.progressindicator.g
    void d(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        h(canvas, paint, f, f2, og1.a(i, i2), i3, i3);
    }

    @Override // com.google.android.material.progressindicator.g
    int e() {
        return ((m) this.a).a;
    }

    @Override // com.google.android.material.progressindicator.g
    int f() {
        return -1;
    }
}
