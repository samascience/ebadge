package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$dimen;
import defpackage.q30;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalProgressWheelView extends View {
    private final Rect a;
    private a b;
    private float c;
    private Paint d;
    private Paint e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private float j;
    private int k;

    public interface a {
        void a();

        void b(float f, float f2);

        void c();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    private void a() {
        this.k = q30.c(getContext(), R$color.ucrop_color_widget_rotate_mid_line);
        this.f = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_width_horizontal_wheel_progress_line);
        this.g = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_height_horizontal_wheel_progress_line);
        this.h = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.f);
        this.d.setColor(getResources().getColor(R$color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.d);
        this.e = paint2;
        paint2.setColor(this.k);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        this.e.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_width_middle_wheel_progress_line));
    }

    private void b(MotionEvent motionEvent, float f) {
        this.j -= f;
        postInvalidate();
        this.c = motionEvent.getX();
        a aVar = this.b;
        if (aVar != null) {
            aVar.b(-f, this.j);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.a);
        int iWidth = this.a.width();
        int i = this.f;
        int i2 = this.h;
        int i3 = iWidth / (i + i2);
        float f = this.j % (i2 + i);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i3 / 4;
            if (i4 < i5) {
                this.d.setAlpha((int) ((i4 / i5) * 255.0f));
            } else if (i4 > (i3 * 3) / 4) {
                this.d.setAlpha((int) (((i3 - i4) / i5) * 255.0f));
            } else {
                this.d.setAlpha(255);
            }
            float f2 = -f;
            Rect rect = this.a;
            float f3 = rect.left + f2 + ((this.f + this.h) * i4);
            float fCenterY = rect.centerY() - (this.g / 4.0f);
            Rect rect2 = this.a;
            canvas.drawLine(f3, fCenterY, f2 + rect2.left + ((this.f + this.h) * i4), rect2.centerY() + (this.g / 4.0f), this.d);
        }
        canvas.drawLine(this.a.centerX(), this.a.centerY() - (this.g / 2.0f), this.a.centerX(), (this.g / 2.0f) + this.a.centerY(), this.e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
        } else if (action == 1) {
            a aVar = this.b;
            if (aVar != null) {
                this.i = false;
                aVar.a();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.c;
            if (x != 0.0f) {
                if (!this.i) {
                    this.i = true;
                    a aVar2 = this.b;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                }
                b(motionEvent, x);
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i) {
        this.k = i;
        invalidate();
    }

    public void setScrollingListener(a aVar) {
        this.b = aVar;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Rect();
        a();
    }
}
