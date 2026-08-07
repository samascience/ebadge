package com.luck.picture.lib.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class TypeButton extends View {
    private int a;
    private int b;
    private float c;
    private float d;
    private float e;
    private Paint f;
    private Path g;
    private float h;
    private float i;
    private RectF j;

    public TypeButton(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a == 1) {
            this.f.setAntiAlias(true);
            this.f.setColor(-287515428);
            Paint paint = this.f;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            canvas.drawCircle(this.c, this.d, this.e, this.f);
            this.f.setColor(-16777216);
            this.f.setStyle(Paint.Style.STROKE);
            this.f.setStrokeWidth(this.h);
            Path path = this.g;
            float f = this.c;
            float f2 = this.i;
            path.moveTo(f - (f2 / 7.0f), this.d + f2);
            Path path2 = this.g;
            float f3 = this.c;
            float f4 = this.i;
            path2.lineTo(f3 + f4, this.d + f4);
            this.g.arcTo(this.j, 90.0f, -180.0f);
            Path path3 = this.g;
            float f5 = this.c;
            float f6 = this.i;
            path3.lineTo(f5 - f6, this.d - f6);
            canvas.drawPath(this.g, this.f);
            this.f.setStyle(style);
            this.g.reset();
            Path path4 = this.g;
            float f7 = this.c;
            float f8 = this.i;
            path4.moveTo(f7 - f8, (float) (((double) this.d) - (((double) f8) * 1.5d)));
            Path path5 = this.g;
            float f9 = this.c;
            float f10 = this.i;
            path5.lineTo(f9 - f10, (float) (((double) this.d) - (((double) f10) / 2.3d)));
            Path path6 = this.g;
            double d = this.c;
            float f11 = this.i;
            path6.lineTo((float) (d - (((double) f11) * 1.6d)), this.d - f11);
            this.g.close();
            canvas.drawPath(this.g, this.f);
        }
        if (this.a == 2) {
            this.f.setAntiAlias(true);
            this.f.setColor(-1);
            this.f.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.c, this.d, this.e, this.f);
            this.f.setAntiAlias(true);
            this.f.setStyle(Paint.Style.STROKE);
            this.f.setColor(-16724992);
            this.f.setStrokeWidth(this.h);
            this.g.moveTo(this.c - (this.b / 6.0f), this.d);
            Path path7 = this.g;
            float f12 = this.c;
            int i = this.b;
            path7.lineTo(f12 - (i / 21.2f), this.d + (i / 7.7f));
            Path path8 = this.g;
            float f13 = this.c;
            int i2 = this.b;
            path8.lineTo(f13 + (i2 / 4.0f), this.d - (i2 / 8.5f));
            Path path9 = this.g;
            float f14 = this.c;
            int i3 = this.b;
            path9.lineTo(f14 - (i3 / 21.2f), this.d + (i3 / 9.4f));
            this.g.close();
            canvas.drawPath(this.g, this.f);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.b;
        setMeasuredDimension(i3, i3);
    }

    public TypeButton(Context context, int i, int i2) {
        super(context);
        this.a = i;
        this.b = i2;
        float f = i2;
        float f2 = f / 2.0f;
        this.e = f2;
        this.c = f2;
        this.d = f2;
        this.f = new Paint();
        this.g = new Path();
        this.h = f / 50.0f;
        this.i = this.b / 12.0f;
        float f3 = this.c;
        float f4 = this.d;
        float f5 = this.i;
        this.j = new RectF(f3, f4 - f5, (2.0f * f5) + f3, f4 + f5);
    }
}
