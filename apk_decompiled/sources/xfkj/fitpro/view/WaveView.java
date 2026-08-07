package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public final class WaveView extends View {
    private final Paint a;
    private final Paint b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private final Path k;
    private final Path l;
    private final a m;
    private boolean n;

    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WaveView.this.i += WaveView.this.j;
            if (WaveView.this.i > WaveView.this.h) {
                WaveView.this.i -= WaveView.this.h;
            }
            if (WaveView.this.d < WaveView.this.e) {
                WaveView.this.d += 2.0f;
            } else if (WaveView.this.d > WaveView.this.e) {
                WaveView.this.d -= 2.0f;
            }
            WaveView.this.invalidate();
            WaveView.this.postDelayed(this, 16L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p31.f(context, "context");
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#0D73FD"));
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setAntiAlias(true);
        this.a = paint;
        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#800D73FD"));
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        this.b = paint2;
        this.c = 0.5f;
        this.d = 10.0f;
        this.e = 10.0f;
        this.f = 10.0f;
        this.g = 60.0f;
        this.h = 400.0f;
        this.j = 8.0f;
        this.k = new Path();
        this.l = new Path();
        this.m = new a();
    }

    private final void h(Canvas canvas, Path path, Paint paint, float f, float f2, float f3, float f4, float f5, float f6) {
        path.reset();
        path.moveTo(0.0f, f3);
        for (float f7 = 0.0f; f7 <= f; f7 += 2.0f) {
            path.lineTo(f7, f3 - ((float) (((double) f5) * Math.sin((6.283185307179586d / ((double) f6)) * ((double) (f7 + f4))))));
        }
        path.lineTo(f, f2);
        path.lineTo(0.0f, f2);
        path.close();
        canvas.drawPath(path, paint);
    }

    public final void i(float f) {
        float f2 = this.f;
        this.e = f2 + ((this.g - f2) * f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n) {
            post(this.m);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.m);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        p31.f(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float f = height * this.c;
        h(canvas, this.l, this.b, width, height, f, this.i * 0.8f, this.d * 0.7f, this.h * 1.2f);
        h(canvas, this.k, this.a, width, height, f, this.i, this.d, this.h);
    }

    public final void setBaseLineRatio(float f) {
        this.c = f;
        invalidate();
    }

    public final void setWaveAnimationRunning(boolean z) {
        if (this.n == z) {
            return;
        }
        this.n = z;
        removeCallbacks(this.m);
        if (z) {
            float f = this.f;
            this.e = f;
            this.d = f;
            post(this.m);
        }
    }

    public final void setWaveColor(int i) {
        this.a.setColor(i);
        this.b.setColor((i & 16777215) | Integer.MIN_VALUE);
        invalidate();
    }
}
