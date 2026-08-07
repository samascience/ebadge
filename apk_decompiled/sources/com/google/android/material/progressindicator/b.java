package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.ch1;
import defpackage.og1;

/* JADX INFO: loaded from: classes3.dex */
final class b extends g {
    private float b;
    private float c;
    private float d;
    private boolean e;
    private float f;

    b(d dVar) {
        super(dVar);
    }

    private void h(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        float f3 = f2 >= f ? f2 - f : (f2 + 1.0f) - f;
        float f4 = f % 1.0f;
        if (this.f < 1.0f) {
            float f5 = f4 + f3;
            if (f5 > 1.0f) {
                h(canvas, paint, f4, 1.0f, i, i2, 0);
                h(canvas, paint, 1.0f, f5, i, 0, i3);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.c / this.d);
        if (f4 == 0.0f && f3 >= 0.99f) {
            f3 += ((f3 - 0.99f) * ((degrees * 2.0f) / 360.0f)) / 0.01f;
        }
        float fD = ch1.d(1.0f - this.f, 1.0f, f4);
        float fD2 = ch1.d(0.0f, this.f, f3);
        float degrees2 = (float) Math.toDegrees(i2 / this.d);
        float degrees3 = ((fD2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i3 / this.d));
        float f6 = (fD * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.b);
        float f7 = degrees * 2.0f;
        if (degrees3 < f7) {
            float f8 = degrees3 / f7;
            paint.setStyle(Paint.Style.FILL);
            j(canvas, paint, f6 + (degrees * f8), this.c * 2.0f, this.b, f8);
            return;
        }
        float f9 = this.d;
        RectF rectF = new RectF(-f9, -f9, f9, f9);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f10 = f6 + degrees;
        canvas.drawArc(rectF, f10, degrees3 - f7, false, paint);
        if (this.e || this.c <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        i(canvas, paint, f10, this.c * 2.0f, this.b);
        i(canvas, paint, (f6 + degrees3) - degrees, this.c * 2.0f, this.b);
    }

    private void i(Canvas canvas, Paint paint, float f, float f2, float f3) {
        j(canvas, paint, f, f2, f3, 1.0f);
    }

    private void j(Canvas canvas, Paint paint, float f, float f2, float f3, float f4) {
        float fMin = (int) Math.min(f3, this.b);
        float f5 = f2 / 2.0f;
        float fMin2 = Math.min(f5, (this.c * fMin) / this.b);
        RectF rectF = new RectF((-fMin) / 2.0f, (-f2) / 2.0f, fMin / 2.0f, f5);
        canvas.save();
        double d = f;
        canvas.translate((float) (((double) this.d) * Math.cos(Math.toRadians(d))), (float) (((double) this.d) * Math.sin(Math.toRadians(d))));
        canvas.rotate(f);
        canvas.scale(f4, f4);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    private int k() {
        a aVar = this.a;
        return ((d) aVar).h + (((d) aVar).i * 2);
    }

    @Override // com.google.android.material.progressindicator.g
    void a(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        float fWidth = rect.width() / f();
        float fHeight = rect.height() / e();
        a aVar = this.a;
        float f2 = (((d) aVar).h / 2.0f) + ((d) aVar).i;
        canvas.translate((f2 * fWidth) + rect.left, (f2 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((d) this.a).j != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        a aVar2 = this.a;
        this.e = ((d) aVar2).a / 2 <= ((d) aVar2).b;
        this.b = ((d) aVar2).a * f;
        this.c = Math.min(((d) aVar2).a / 2, ((d) aVar2).b) * f;
        a aVar3 = this.a;
        float f4 = (((d) aVar3).h - ((d) aVar3).a) / 2.0f;
        this.d = f4;
        if (z || z2) {
            if ((z && ((d) aVar3).e == 2) || (z2 && ((d) aVar3).f == 1)) {
                this.d = f4 + (((1.0f - f) * ((d) aVar3).a) / 2.0f);
            } else if ((z && ((d) aVar3).e == 1) || (z2 && ((d) aVar3).f == 2)) {
                this.d = f4 - (((1.0f - f) * ((d) aVar3).a) / 2.0f);
            }
        }
        if (z2 && ((d) aVar3).f == 3) {
            this.f = f;
        } else {
            this.f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.g
    void b(Canvas canvas, Paint paint, int i, int i2) {
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
        return k();
    }

    @Override // com.google.android.material.progressindicator.g
    int f() {
        return k();
    }
}
