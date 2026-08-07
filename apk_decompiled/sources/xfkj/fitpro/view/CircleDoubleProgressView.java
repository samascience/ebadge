package xfkj.fitpro.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.blankj.utilcode.util.ImageUtils;
import com.legend.smartwatch.electronicbadge.android.R;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class CircleDoubleProgressView extends View {
    private float F;
    private float G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private Paint O;
    private boolean P;
    private Bitmap Q;
    private Bitmap R;
    private float S;
    private int T;
    private boolean U;
    private boolean V;
    private float W;
    private Paint a;
    int a0;
    private TextPaint b;
    private int b0;
    private float c;
    private int c0;
    private int d;
    private int e;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private float m;
    private float n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f409q;
    private int r;
    private int s;
    private int t;
    private int u;
    private String v;
    private float w;
    private int x;
    private float y;
    private float z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleDoubleProgressView.this.setProgressAnim1(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleDoubleProgressView.this.setProgressAnim2(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public interface c {
    }

    public CircleDoubleProgressView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        this.a.reset();
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setShader(null);
        if (this.M) {
            this.a.setStrokeCap(Paint.Cap.ROUND);
        }
        float f = this.K ? (this.m - this.n) - this.c : this.m;
        float f2 = 2.0f * f;
        float f3 = this.f - f;
        float f4 = this.g - f;
        RectF rectF = new RectF(f3, f4, f3 + f2, f2 + f4);
        this.a.setStrokeWidth(this.W);
        this.a.setStrokeWidth(this.c);
        int i = this.d;
        int i2 = this.a0;
        int i3 = i + i2;
        int i4 = this.e - (i2 * 2);
        int i5 = this.h;
        if (i5 != 0) {
            this.a.setColor(i5);
            canvas.drawArc(rectF, i3, this.e - (this.a0 * 2), false, this.a);
        }
        this.a.setColor(this.j);
        float f5 = i3;
        float f6 = i4;
        canvas.drawArc(rectF, f5, f6 * d(this.f409q, this.s), false, this.a);
        int i6 = (-this.d) - this.a0;
        int i7 = this.i;
        if (i7 != 0) {
            this.a.setColor(i7);
            canvas.drawArc(rectF, i6, (-this.e) + (this.a0 * 2), false, this.a);
        }
        this.a.setColor(this.k);
        canvas.drawArc(rectF, i6, -(f6 * d(this.r, this.t)), false, this.a);
        if (this.V) {
            if (this.U) {
                this.O.setShadowLayer(10.0f, 0.0f, 0.0f, -7829368);
            }
            if (this.P) {
                Bitmap bitmap = this.Q;
                if (bitmap != null) {
                    b(canvas, f, this.a0 - 180, bitmap, this.b0);
                }
                Bitmap bitmap2 = this.R;
                if (bitmap2 != null) {
                    b(canvas, f, (-180) - this.a0, bitmap2, this.c0);
                }
            }
        }
    }

    private void b(Canvas canvas, float f, float f2, Bitmap bitmap, int i) {
        double d = f;
        double d2 = (((double) f2) * 3.141592653589793d) / 180.0d;
        double width = ((double) (getWidth() / 2)) + (Math.cos(d2) * d);
        double height = ((double) (getHeight() / 2)) + (d * Math.sin(d2));
        this.O.setColor(i);
        float f3 = (float) width;
        float f4 = (float) height;
        canvas.drawCircle(f3, f4, this.S, this.O);
        int width2 = bitmap.getWidth() > bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        float f5 = (this.S / 10.0f) * 9.8f;
        float f6 = width2;
        if (f6 > f5) {
            float f7 = f5 / f6;
            bitmap = ImageUtils.c(bitmap, f7, f7);
        }
        this.O.clearShadowLayer();
        canvas.drawBitmap(bitmap, f3 - (bitmap.getWidth() / 2), f4 - (bitmap.getHeight() / 2), this.O);
    }

    private void c(Canvas canvas) {
        if (this.I) {
            this.b.reset();
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.b.setTextSize(this.w);
            this.b.setColor(this.x);
            this.b.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
            float f = fontMetrics.bottom - fontMetrics.top;
            float width = ((getWidth() / 2) + this.y) - this.F;
            float height = (((getHeight() - ((getHeight() - f) / 2.0f)) - fontMetrics.bottom) + this.z) - this.G;
            if (!this.J) {
                if (TextUtils.isEmpty(this.v)) {
                    return;
                }
                canvas.drawText(this.v, width, height, this.b);
            } else {
                canvas.drawText(this.H + "%", width, height, this.b);
            }
        }
    }

    private float d(int i, int i2) {
        return (i2 * 1.0f) / i;
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleDoubleProgressView);
        DisplayMetrics displayMetrics = getDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(1, 12.0f, displayMetrics);
        this.c = fApplyDimension;
        this.W = fApplyDimension / 2.0f;
        int i = 2;
        float f = 30.0f;
        this.w = TypedValue.applyDimension(2, 30.0f, displayMetrics);
        this.n = TypedValue.applyDimension(1, 10.0f, displayMetrics);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        int i2 = 0;
        while (i2 < indexCount) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == 23) {
                this.c = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
            } else if (index == 18) {
                this.W = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
            } else if (index == 16) {
                this.h = typedArrayObtainStyledAttributes.getColor(index, -3618616);
            } else if (index == 17) {
                this.i = typedArrayObtainStyledAttributes.getColor(index, -3618616);
            } else if (index == 20) {
                this.j = typedArrayObtainStyledAttributes.getColor(index, -11539796);
            } else if (index == 22) {
                this.k = typedArrayObtainStyledAttributes.getColor(index, -11539796);
            } else if (index == 30) {
                this.d = typedArrayObtainStyledAttributes.getInt(index, -180);
            } else if (index == 31) {
                this.e = typedArrayObtainStyledAttributes.getInt(index, Opcodes.GETFIELD);
            } else if (index == 14) {
                this.f409q = typedArrayObtainStyledAttributes.getInt(index, 100);
            } else if (index == 15) {
                this.r = typedArrayObtainStyledAttributes.getInt(index, 100);
            } else if (index == 19) {
                this.s = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == 21) {
                this.t = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == 3) {
                this.u = typedArrayObtainStyledAttributes.getInt(index, 500);
            } else if (index == 11) {
                this.v = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == 13) {
                this.w = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(i, f, displayMetrics));
            } else if (index == 12) {
                this.x = typedArrayObtainStyledAttributes.getColor(index, -13421773);
            } else if (index == 25) {
                this.I = typedArrayObtainStyledAttributes.getBoolean(index, this.I);
            } else if (index == 28) {
                this.K = typedArrayObtainStyledAttributes.getBoolean(index, this.K);
            } else if (index == i) {
                this.n = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 10.0f, displayMetrics));
            } else if (index == 32) {
                this.o = typedArrayObtainStyledAttributes.getInt(index, this.o);
            } else if (index == 0) {
                this.p = typedArrayObtainStyledAttributes.getInt(index, this.p);
            } else if (index == 33) {
                this.L = typedArrayObtainStyledAttributes.getBoolean(index, this.L);
            } else if (index == 1) {
                this.M = typedArrayObtainStyledAttributes.getBoolean(index, this.M);
            } else if (index == 8) {
                this.y = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 10) {
                this.z = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 9) {
                this.F = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 7) {
                this.G = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 5) {
                this.T = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 29) {
                this.a0 = typedArrayObtainStyledAttributes.getInt(index, 3);
            } else if (index == 6) {
                this.S = typedArrayObtainStyledAttributes.getDimension(index, 12.0f);
            } else if (index == 5) {
                this.T = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 22) {
                this.P = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == 4) {
                this.Q = ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher));
            } else if (index == 23) {
                this.U = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == 20) {
                this.V = typedArrayObtainStyledAttributes.getBoolean(index, true);
            }
            i2++;
            i = 2;
            f = 30.0f;
        }
        this.J = TextUtils.isEmpty(this.v);
        typedArrayObtainStyledAttributes.recycle();
        this.H = (int) ((this.s * 100.0f) / this.f409q);
        this.a = new Paint();
        this.b = new TextPaint();
        Paint paint = new Paint();
        this.O = paint;
        paint.setColor(this.T);
        this.O.setAntiAlias(true);
    }

    private int f(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public void g(int i, float f) {
        float fApplyDimension = TypedValue.applyDimension(i, f, getDisplayMetrics());
        if (this.w != fApplyDimension) {
            this.w = fApplyDimension;
            invalidate();
        }
    }

    public float getCircleCenterX() {
        return this.f;
    }

    public float getCircleCenterY() {
        return this.g;
    }

    public String getLabelText() {
        return this.v;
    }

    public int getLabelTextColor() {
        return this.x;
    }

    public int getMax1() {
        return this.f409q;
    }

    public int getMax2() {
        return this.r;
    }

    public int getProgress1() {
        return this.s;
    }

    public int getProgress2() {
        return this.t;
    }

    public int getProgressPercent() {
        return this.H;
    }

    public float getRadius() {
        return this.m;
    }

    public int getStartAngle() {
        return this.d;
    }

    public int getSweepAngle() {
        return this.e;
    }

    public String getText() {
        if (!this.J) {
            return this.v;
        }
        return this.H + "%";
    }

    public void h(int i, int i2, int i3) {
        i(i, i2, i3, null);
    }

    public void i(int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        this.u = i3;
        this.s = i;
        int i4 = this.f409q;
        if (i2 > i4) {
            i2 = i4;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(i3);
        if (animatorListener != null) {
            valueAnimatorOfInt.removeAllUpdateListeners();
            valueAnimatorOfInt.addListener(animatorListener);
        }
        valueAnimatorOfInt.addUpdateListener(new a());
        valueAnimatorOfInt.start();
    }

    public void j(int i, int i2, int i3) {
        k(i, i2, i3, null);
    }

    public void k(int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        this.u = i3;
        this.t = i;
        int i4 = this.r;
        if (i2 > i4) {
            i2 = i4;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(i3);
        if (animatorListener != null) {
            valueAnimatorOfInt.removeAllUpdateListeners();
            valueAnimatorOfInt.addListener(animatorListener);
        }
        valueAnimatorOfInt.addUpdateListener(new b());
        valueAnimatorOfInt.start();
    }

    public void l(int i) {
        h(this.s, i, this.u);
    }

    public void m(int i) {
        j(this.t, i, this.u);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 200.0f, getDisplayMetrics());
        int iF = f(i, iApplyDimension);
        int iF2 = f(i2, iApplyDimension);
        this.f = ((getPaddingLeft() + iF) - getPaddingRight()) / 2.0f;
        this.g = ((getPaddingTop() + iF2) - getPaddingBottom()) / 2.0f;
        this.m = (((iF - Math.max(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom())) - this.c) / 2.0f) - this.n;
        this.N = true;
        setMeasuredDimension(iF, iF2);
    }

    public void setCapRound(boolean z) {
        this.M = z;
        invalidate();
    }

    public void setIconBgColor1(int i) {
        this.b0 = i;
        invalidate();
    }

    public void setIconBgColor2(int i) {
        this.c0 = i;
        invalidate();
    }

    public void setLabelPaddingBottom(float f) {
        this.G = f;
        invalidate();
    }

    public void setLabelPaddingLeft(float f) {
        this.y = f;
        invalidate();
    }

    public void setLabelPaddingRight(float f) {
        this.F = f;
        invalidate();
    }

    public void setLabelPaddingTop(float f) {
        this.z = f;
        invalidate();
    }

    public void setLabelText(String str) {
        this.v = str;
        this.J = TextUtils.isEmpty(str);
        invalidate();
    }

    public void setLabelTextColor(int i) {
        this.x = i;
        invalidate();
    }

    public void setLabelTextColorResource(int i) {
        setLabelTextColor(getResources().getColor(i));
    }

    public void setLabelTextSize(float f) {
        g(2, f);
    }

    public void setMax1(int i) {
        this.f409q = i;
        invalidate();
    }

    public void setMax2(int i) {
        this.r = i;
        invalidate();
    }

    public void setNormal1Color(int i) {
        this.h = i;
        invalidate();
    }

    public void setNormal2Color(int i) {
        this.i = i;
        invalidate();
    }

    public void setNormalStrokeWidth(float f) {
        this.W = f;
        invalidate();
    }

    public void setOnChangeListener(c cVar) {
    }

    public void setProgress1(int i) {
        this.s = i;
        invalidate();
    }

    public void setProgress1Color(int i) {
        this.j = i;
        invalidate();
    }

    public void setProgress2(int i) {
        this.t = i;
        invalidate();
    }

    public void setProgress2Color(int i) {
        this.k = i;
        invalidate();
    }

    public void setProgressAnim1(int i) {
        this.s = i;
        this.H = (int) ((i * 100.0f) / this.f409q);
        invalidate();
    }

    public void setProgressAnim2(int i) {
        this.t = i;
        this.H = (int) ((i * 100.0f) / this.r);
        invalidate();
    }

    public void setProgressColorResource(int i) {
        setProgress1Color(getResources().getColor(i));
    }

    public void setProgressStrokeWidth(float f) {
        this.c = f;
        invalidate();
    }

    public void setShowIcon(boolean z) {
        this.V = z;
        this.P = z;
        invalidate();
    }

    public void setShowTick(boolean z) {
        this.K = z;
        invalidate();
    }

    public void setStartAngle(int i) {
        this.d = i;
        invalidate();
    }

    public void setTurn(boolean z) {
        this.L = z;
        invalidate();
    }

    public void setmIcon1(Bitmap bitmap) {
        this.Q = bitmap;
        invalidate();
    }

    public void setmIcon2(Bitmap bitmap) {
        this.R = bitmap;
        invalidate();
    }

    public void setmIconSize(float f) {
        this.S = f;
        invalidate();
    }

    public CircleDoubleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleDoubleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -180;
        this.e = Opcodes.GETFIELD;
        this.h = -3618616;
        this.i = -3618616;
        this.j = -11539796;
        this.k = -11539796;
        this.l = new int[]{-506857, -303865, -366052, -366052, -506857};
        this.o = 5;
        this.p = 1;
        this.f409q = 100;
        this.r = 100;
        this.s = 0;
        this.t = 0;
        this.u = 500;
        this.x = -13421773;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = false;
        this.S = 12.0f;
        this.T = -1;
        this.V = true;
        this.a0 = 6;
        this.b0 = -16777216;
        this.c0 = -16777216;
        e(context, attributeSet);
    }
}
