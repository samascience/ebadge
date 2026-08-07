package com.luck.picture.lib.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class ReturnButton extends View {
    private int a;
    private int b;
    private int c;
    private float d;
    private Paint e;
    Path f;

    public ReturnButton(Context context, int i) {
        this(context);
        this.a = i;
        int i2 = i / 2;
        this.b = i2;
        this.c = i2;
        this.d = i / 15.0f;
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(-1);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.d);
        this.f = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.f;
        float f = this.d;
        path.moveTo(f, f / 2.0f);
        this.f.lineTo(this.b, this.c - (this.d / 2.0f));
        Path path2 = this.f;
        float f2 = this.a;
        float f3 = this.d;
        path2.lineTo(f2 - f3, f3 / 2.0f);
        canvas.drawPath(this.f, this.e);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.a;
        setMeasuredDimension(i3, i3 / 2);
    }

    public ReturnButton(Context context) {
        super(context);
    }
}
