package cn.bertsir.zbar.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import cn.bertsir.zbar.R$color;

/* JADX INFO: loaded from: classes.dex */
public class ScanLineView extends View {
    private Rect a;
    private Paint b;
    private Paint c;
    private Paint d;
    private Path e;
    private Path f;
    private LinearGradient g;
    private LinearGradient h;
    private LinearGradient i;
    private float j;
    private int k;
    private float l;
    private Matrix m;
    private ValueAnimator n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f208q;
    private float r;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (ScanLineView.this.h == null) {
                ScanLineView.this.l();
            }
            if (ScanLineView.this.g == null) {
                ScanLineView.this.n();
            }
            if (ScanLineView.this.i == null) {
                ScanLineView.this.m();
            }
            if (ScanLineView.this.m != null) {
                ScanLineView.this.r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScanLineView.this.m.setTranslate(0.0f, ScanLineView.this.r);
                ScanLineView.this.h.setLocalMatrix(ScanLineView.this.m);
                ScanLineView.this.g.setLocalMatrix(ScanLineView.this.m);
                ScanLineView.this.i.setLocalMatrix(ScanLineView.this.m);
                ScanLineView.this.invalidate();
            }
        }
    }

    public ScanLineView(Context context) {
        this(context, null);
    }

    private void j() {
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.j);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.p = getResources().getColor(R$color.common_color);
        Paint paint3 = new Paint();
        this.d = paint3;
        paint3.setStyle(style);
        this.d.setStrokeWidth(10.0f);
        this.d.setAntiAlias(true);
        Matrix matrix = new Matrix();
        this.m = matrix;
        matrix.setTranslate(0.0f, 30.0f);
    }

    private void k() {
        if (this.e == null) {
            Path path = new Path();
            this.e = path;
            Rect rect = this.a;
            path.moveTo(rect.left, rect.top + this.l);
            Path path2 = this.e;
            Rect rect2 = this.a;
            path2.lineTo(rect2.left, rect2.top);
            Path path3 = this.e;
            Rect rect3 = this.a;
            path3.lineTo(rect3.left + this.l, rect3.top);
            Path path4 = this.e;
            Rect rect4 = this.a;
            path4.moveTo(rect4.right - this.l, rect4.top);
            Path path5 = this.e;
            Rect rect5 = this.a;
            path5.lineTo(rect5.right, rect5.top);
            Path path6 = this.e;
            Rect rect6 = this.a;
            path6.lineTo(rect6.right, rect6.top + this.l);
            Path path7 = this.e;
            Rect rect7 = this.a;
            path7.moveTo(rect7.right, rect7.bottom - this.l);
            Path path8 = this.e;
            Rect rect8 = this.a;
            path8.lineTo(rect8.right, rect8.bottom);
            Path path9 = this.e;
            Rect rect9 = this.a;
            path9.lineTo(rect9.right - this.l, rect9.bottom);
            Path path10 = this.e;
            Rect rect10 = this.a;
            path10.moveTo(rect10.left + this.l, rect10.bottom);
            Path path11 = this.e;
            Rect rect11 = this.a;
            path11.lineTo(rect11.left, rect11.bottom);
            Path path12 = this.e;
            Rect rect12 = this.a;
            path12.lineTo(rect12.left, rect12.bottom - this.l);
        }
        if (this.n == null) {
            o(this.a.height());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f == null) {
            this.f = new Path();
            float fWidth = this.a.width() / (this.k + 0.0f);
            float fHeight = this.a.height() / (this.k + 0.0f);
            for (int i = 0; i <= this.k; i++) {
                Path path = this.f;
                Rect rect = this.a;
                float f = i * fWidth;
                path.moveTo(rect.left + f, rect.top);
                Path path2 = this.f;
                Rect rect2 = this.a;
                path2.lineTo(rect2.left + f, rect2.bottom);
            }
            for (int i2 = 0; i2 <= this.k; i2++) {
                Path path3 = this.f;
                Rect rect3 = this.a;
                float f2 = i2 * fHeight;
                path3.moveTo(rect3.left, rect3.top + f2);
                Path path4 = this.f;
                Rect rect4 = this.a;
                path4.lineTo(rect4.right, rect4.top + f2);
            }
        }
        if (this.h == null) {
            Rect rect5 = this.a;
            LinearGradient linearGradient = new LinearGradient(0.0f, rect5.top, 0.0f, rect5.bottom + (rect5.height() * 0.01f), new int[]{0, 0, this.p, 0}, new float[]{0.0f, 0.5f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.h = linearGradient;
            linearGradient.setLocalMatrix(this.m);
            this.b.setShader(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.i == null) {
            String strValueOf = String.valueOf(Integer.toHexString(this.p));
            String strSubstring = strValueOf.substring(strValueOf.length() - 6, strValueOf.length());
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{Color.parseColor("#00" + strSubstring), this.p, Color.parseColor("#00" + strSubstring)}, (float[]) null, Shader.TileMode.CLAMP);
            this.i = linearGradient;
            linearGradient.setLocalMatrix(this.m);
            this.d.setShader(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.g == null) {
            Rect rect = this.a;
            LinearGradient linearGradient = new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom + (rect.height() * 0.01f), new int[]{0, 0, this.p, 0}, new float[]{0.0f, 0.85f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.g = linearGradient;
            linearGradient.setLocalMatrix(this.m);
            this.c.setShader(this.g);
        }
    }

    public void o(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.n = valueAnimator;
        valueAnimator.setDuration(this.o);
        this.n.setFloatValues(-i, 0.0f);
        this.n.setRepeatMode(1);
        this.n.setInterpolator(new DecelerateInterpolator());
        this.n.setRepeatCount(-1);
        this.n.addUpdateListener(new a());
        this.n.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.n.cancel();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.a == null || this.e == null) {
            return;
        }
        int i = this.f208q;
        if (i == 0) {
            l();
            canvas.drawPath(this.f, this.b);
            return;
        }
        if (i == 1) {
            n();
            canvas.drawRect(this.a, this.c);
        } else if (i == 3) {
            m();
            canvas.drawLine(0.0f, this.a.height() - Math.abs(this.r), getMeasuredWidth(), this.a.height() - Math.abs(this.r), this.d);
        } else {
            l();
            n();
            canvas.drawPath(this.f, this.b);
            canvas.drawRect(this.a, this.c);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a = new Rect(i, i2, i3, i4);
        k();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setScanAnimatorDuration(int i) {
        this.o = i;
    }

    public void setScanStyle(int i) {
        this.f208q = i;
    }

    public void setScancolor(int i) {
        this.p = i;
    }

    public ScanLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 2.0f;
        this.k = 40;
        this.l = 50.0f;
        this.o = 1800;
        this.f208q = 0;
        j();
    }
}
