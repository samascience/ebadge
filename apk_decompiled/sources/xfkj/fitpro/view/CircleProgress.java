package xfkj.fitpro.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.q30;
import java.math.BigDecimal;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class CircleProgress extends View {
    private int a;
    private int b;
    private Paint c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private final int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f410q;
    private boolean r;
    private int s;
    private double t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private int y;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleProgress.this.p = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            CircleProgress.this.invalidate();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleProgress.this.o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            CircleProgress circleProgress = CircleProgress.this;
            circleProgress.l = (circleProgress.o * CircleProgress.this.m) / 3600;
            CircleProgress.this.invalidate();
            CircleProgress circleProgress2 = CircleProgress.this;
            circleProgress2.p(circleProgress2.l, CircleProgress.this.m);
        }
    }

    public interface c {
    }

    public CircleProgress(Context context) {
        super(context);
        this.j = -90;
        this.k = true;
        this.l = 10;
        this.m = 100;
        this.n = 3600;
        this.o = (10 * 3600) / 100;
        this.p = 0;
        this.f410q = true;
        this.r = true;
        this.s = 1000;
        this.u = true;
        this.v = 1;
        this.w = true;
        n(null);
    }

    private int i(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void j(Canvas canvas) {
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(this.d);
        this.c.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.a, this.b, this.e - (this.f / 2), this.c);
    }

    private void k(Canvas canvas) {
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(this.h);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.f);
        this.c.setShader(null);
        int i = this.a;
        int i2 = this.e;
        int i3 = this.b;
        RectF rectF = new RectF(i - i2, i3 - i2, i + i2, i3 + i2);
        this.c.setShader(new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.h, this.i, Shader.TileMode.MIRROR));
        if (this.f410q) {
            this.c.setStrokeCap(Paint.Cap.ROUND);
        }
        float fH = (float) h(this.o * getEffectiveDegree(), 3600.0d, 2);
        if (!this.k) {
            fH *= -1.0f;
        }
        canvas.drawArc(rectF, this.j, fH, false, this.c);
        this.c.reset();
    }

    private void l(Canvas canvas) {
        this.c.reset();
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.t = h(this.l * 100, this.m, this.v);
        String str = this.t + "%";
        if (!this.u) {
            str = ((int) this.t) + "%";
        }
        Rect rect = new Rect();
        this.c.setTextSize(this.y);
        this.c.setColor(this.x);
        this.c.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str + Constants.STR_EMPTY, this.a - (rect.width() / 2), this.b + (Math.abs(this.c.getFontMetrics().ascent) / 2.0f), this.c);
    }

    private void m(Canvas canvas) {
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.f);
        this.c.setColor(this.g);
        int i = this.a;
        int i2 = this.e;
        int i3 = this.b;
        RectF rectF = new RectF(i - i2, i3 - i2, i + i2, i3 + i2);
        if (this.f410q) {
            this.c.setStrokeCap(Paint.Cap.ROUND);
        }
        float effectiveDegree = getEffectiveDegree();
        if (!this.k) {
            effectiveDegree *= -1.0f;
        }
        canvas.drawArc(rectF, this.j, effectiveDegree, false, this.c);
    }

    private void n(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CircleProgress);
        this.d = typedArrayObtainStyledAttributes.getColor(10, q30.c(getContext(), R.color.transparent));
        this.e = (int) typedArrayObtainStyledAttributes.getDimension(15, -1.0f);
        this.f = (int) typedArrayObtainStyledAttributes.getDimension(16, 30.0f);
        this.g = typedArrayObtainStyledAttributes.getColor(12, q30.c(getContext(), R.color.white));
        int color = typedArrayObtainStyledAttributes.getColor(13, q30.c(getContext(), R.color.theme_color));
        this.h = color;
        this.i = typedArrayObtainStyledAttributes.getColor(14, color);
        this.j = typedArrayObtainStyledAttributes.getInteger(17, -90);
        this.k = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.l = typedArrayObtainStyledAttributes.getInteger(11, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(7, 100);
        this.m = integer;
        this.o = (this.l * 3600) / integer;
        this.p = typedArrayObtainStyledAttributes.getInteger(1, 0);
        this.f410q = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.r = typedArrayObtainStyledAttributes.getBoolean(18, true);
        this.s = typedArrayObtainStyledAttributes.getInteger(2, 1000);
        this.u = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.v = typedArrayObtainStyledAttributes.getInteger(0, 1);
        this.w = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.x = typedArrayObtainStyledAttributes.getColor(8, q30.c(getContext(), R.color.black));
        this.y = (int) typedArrayObtainStyledAttributes.getDimension(9, i(getContext(), 17.0f));
        typedArrayObtainStyledAttributes.recycle();
        o();
    }

    private void o() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(-1);
        this.c.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, int i2) {
    }

    public int getDecimalPointLength() {
        return this.v;
    }

    public int getDisableAngle() {
        return this.p;
    }

    public int getDuration() {
        return this.s;
    }

    public int getEffectiveDegree() {
        return 360 - this.p;
    }

    public int getMaxProgress() {
        return this.m;
    }

    public int getNeiYuanColor() {
        return this.d;
    }

    public c getOnCircleProgressInter() {
        return null;
    }

    public int getProgress() {
        return this.l;
    }

    public double getProgressPercent() {
        return this.t;
    }

    public int getRingColor() {
        return this.g;
    }

    public int getRingProgressColor() {
        return this.h;
    }

    public int getRingProgressSecondColor() {
        return this.i;
    }

    public int getRingRadius() {
        return this.e;
    }

    public int getRingWidth() {
        return this.f;
    }

    public int getStartAngle() {
        return this.j;
    }

    public int getTextColor() {
        return this.x;
    }

    public int getTextSize() {
        return this.y;
    }

    public double h(double d, double d2, int i) {
        if (d2 == 0.0d) {
            try {
                throw new Exception("分母不能为0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 4).doubleValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (this.e < 0) {
            this.e = (iMin - this.f) / 2;
        }
        this.a = getWidth() / 2;
        this.b = getHeight() / 2;
        m(canvas);
        j(canvas);
        k(canvas);
        if (this.w) {
            l(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (getLayoutParams().width == -2 && getLayoutParams().height == -2) {
            setMeasuredDimension(200, 200);
        } else if (getLayoutParams().width == -2) {
            setMeasuredDimension(200, size2);
        } else if (getLayoutParams().height == -2) {
            setMeasuredDimension(size, 200);
        }
    }

    public void q(int i, boolean z) {
        int i2 = this.o;
        int i3 = this.m;
        if (i > i3) {
            this.l = i3;
        } else if (i < 0) {
            this.l = 0;
        } else {
            this.l = i;
        }
        int i4 = (i * 3600) / i3;
        this.o = i4;
        if (!z) {
            invalidate();
            p(this.l, this.m);
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i4);
        valueAnimatorOfInt.addUpdateListener(new b());
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.setDuration(this.s);
        valueAnimatorOfInt.start();
    }

    public void setDisableAngle(int i) {
        int i2 = this.p;
        if (i > 360) {
            this.p = 360;
        } else if (i < 0) {
            this.p = 0;
        } else {
            this.p = i;
        }
        if (!this.r) {
            invalidate();
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i);
        valueAnimatorOfInt.addUpdateListener(new a());
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.setDuration(this.s);
        valueAnimatorOfInt.start();
    }

    public void setProgress(int i) {
        q(i, this.r);
    }

    public CircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = -90;
        this.k = true;
        this.l = 10;
        this.m = 100;
        this.n = 3600;
        this.o = (10 * 3600) / 100;
        this.p = 0;
        this.f410q = true;
        this.r = true;
        this.s = 1000;
        this.u = true;
        this.v = 1;
        this.w = true;
        n(attributeSet);
    }

    public CircleProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = -90;
        this.k = true;
        this.l = 10;
        this.m = 100;
        this.n = 3600;
        this.o = (10 * 3600) / 100;
        this.p = 0;
        this.f410q = true;
        this.r = true;
        this.s = 1000;
        this.u = true;
        this.v = 1;
        this.w = true;
        n(attributeSet);
    }
}
