package xfkj.fitpro.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class CircleProgressView extends View {
    private float F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private Paint N;
    private boolean O;
    private Bitmap P;
    private float Q;
    private int R;
    private boolean S;
    private boolean T;
    private float U;
    private int V;
    private Paint a;
    private TextPaint b;
    private float c;
    private int d;
    private int e;
    private float f;
    private float g;
    private int h;
    private int i;
    private boolean j;
    private Shader k;
    private int[] l;
    private float m;
    private float n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f412q;
    private int r;
    private int s;
    private int t;
    private String u;
    private float v;
    private int w;
    private float x;
    private float y;
    private float z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleProgressView.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public interface b {
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        Shader shader;
        Shader shader2;
        Shader shader3;
        this.a.reset();
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        if (this.J) {
            this.a.setStrokeWidth(this.c / 2.0f);
            float strokeWidth = (((this.m - this.c) - this.a.getStrokeWidth()) - this.n) - 15.0f;
            float f = this.f;
            float f2 = this.g;
            RectF rectF = new RectF(f - strokeWidth, f2 - strokeWidth, f + strokeWidth, f2 + strokeWidth);
            int i = (int) ((this.G / 100.0f) * this.f412q);
            if (this.K) {
                for (int i2 = 0; i2 < this.f412q; i2++) {
                    this.a.setShader(null);
                    this.a.setColor(this.h);
                    int i3 = this.p;
                    canvas.drawArc(rectF, ((this.o + i3) * i2) + this.d, i3, false, this.a);
                }
                for (int i4 = i; i4 < i + i; i4++) {
                    if (!this.j || (shader3 = this.k) == null) {
                        this.a.setColor(this.i);
                    } else {
                        this.a.setShader(shader3);
                    }
                    int i5 = this.p;
                    canvas.drawArc(rectF, ((this.o + i5) * i4) + this.d, i5, false, this.a);
                }
            } else {
                for (int i6 = 0; i6 < this.f412q; i6++) {
                    if (i6 < i) {
                        if (!this.j || (shader2 = this.k) == null) {
                            this.a.setColor(this.i);
                        } else {
                            this.a.setShader(shader2);
                        }
                        int i7 = this.p;
                        canvas.drawArc(rectF, ((this.o + i7) * i6) + this.d, i7, false, this.a);
                    } else if (this.h != 0) {
                        this.a.setShader(null);
                        this.a.setColor(this.h);
                        int i8 = this.p;
                        canvas.drawArc(rectF, ((this.o + i8) * i6) + this.d, i8, false, this.a);
                    }
                }
            }
        }
        this.a.setShader(null);
        if (this.L) {
            this.a.setStrokeCap(Paint.Cap.ROUND);
        }
        float f3 = this.J ? (this.m - this.n) - this.c : this.m;
        float f4 = 2.0f * f3;
        float f5 = this.f - f3;
        float f6 = this.g - f3;
        RectF rectF2 = new RectF(f5, f6, f5 + f4, f4 + f6);
        this.a.setStrokeWidth(this.U);
        int i9 = this.h;
        if (i9 != 0) {
            this.a.setColor(i9);
            canvas.drawArc(rectF2, this.d, this.e, false, this.a);
        }
        if (!this.j || (shader = this.k) == null) {
            this.a.setColor(this.i);
        } else {
            this.a.setShader(shader);
        }
        this.a.setStrokeWidth(this.c);
        if (this.K) {
            canvas.drawArc(rectF2, this.d + (this.e * getRatio()), this.e * getRatio(), false, this.a);
        } else {
            canvas.drawArc(rectF2, this.d, this.e * getRatio(), false, this.a);
        }
        if (this.T) {
            double d = f3;
            double d2 = (((double) (-90.0f)) * 3.141592653589793d) / 180.0d;
            double width = ((double) (getWidth() / 2)) + (Math.cos(d2) * d);
            double height = ((double) (getHeight() / 2)) + (d * Math.sin(d2));
            if (this.S) {
                this.N.setShadowLayer(10.0f, 0.0f, 0.0f, -7829368);
            }
            if (this.P == null || !this.O) {
                return;
            }
            this.N.setColor(this.V);
            float f7 = (float) width;
            float f8 = (float) height;
            canvas.drawCircle(f7, f8, this.Q, this.N);
            int width2 = this.P.getWidth() > this.P.getHeight() ? this.P.getWidth() : this.P.getHeight();
            float f9 = (this.Q / 10.0f) * 9.8f;
            this.N.clearShadowLayer();
            float f10 = width2;
            if (f10 <= f9) {
                Bitmap bitmap = this.P;
                canvas.drawBitmap(bitmap, f7 - (bitmap.getWidth() / 2), f8 - (this.P.getHeight() / 2), this.N);
            } else {
                float f11 = f9 / f10;
                Bitmap bitmapC = ImageUtils.c(this.P, f11, f11);
                canvas.drawBitmap(bitmapC, f7 - (bitmapC.getWidth() / 2), f8 - (bitmapC.getHeight() / 2), this.N);
            }
        }
    }

    private void b(Canvas canvas) {
        if (this.H) {
            this.b.reset();
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.b.setTextSize(this.v);
            this.b.setColor(this.w);
            this.b.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
            float f = fontMetrics.bottom - fontMetrics.top;
            float width = ((getWidth() / 2) + this.x) - this.z;
            float height = (((getHeight() - ((getHeight() - f) / 2.0f)) - fontMetrics.bottom) + this.y) - this.F;
            if (!this.I) {
                if (TextUtils.isEmpty(this.u)) {
                    return;
                }
                canvas.drawText(this.u, width, height, this.b);
            } else {
                canvas.drawText(this.G + "%", width, height, this.b);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleProgressView);
        DisplayMetrics displayMetrics = getDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(1, 12.0f, displayMetrics);
        this.c = fApplyDimension;
        this.U = fApplyDimension / 2.0f;
        this.v = TypedValue.applyDimension(2, 30.0f, displayMetrics);
        this.n = TypedValue.applyDimension(1, 10.0f, displayMetrics);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 19) {
                this.c = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
            } else if (index == 16) {
                this.U = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
            } else if (index == 15) {
                this.h = typedArrayObtainStyledAttributes.getColor(index, -3618616);
            } else if (index == 18) {
                this.i = typedArrayObtainStyledAttributes.getColor(index, -11539796);
                this.j = false;
            } else if (index == 25) {
                this.d = typedArrayObtainStyledAttributes.getInt(index, 270);
            } else if (index == 26) {
                this.e = typedArrayObtainStyledAttributes.getInt(index, 360);
            } else if (index == 14) {
                this.r = typedArrayObtainStyledAttributes.getInt(index, 100);
            } else if (index == 17) {
                this.s = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == 3) {
                this.t = typedArrayObtainStyledAttributes.getInt(index, 500);
            } else if (index == 11) {
                this.u = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == 13) {
                this.v = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(2, 30.0f, displayMetrics));
            } else if (index == 12) {
                this.w = typedArrayObtainStyledAttributes.getColor(index, -13421773);
            } else if (index == 21) {
                this.H = typedArrayObtainStyledAttributes.getBoolean(index, this.H);
            } else if (index == 24) {
                this.J = typedArrayObtainStyledAttributes.getBoolean(index, this.J);
            } else if (index == 2) {
                this.n = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 10.0f, displayMetrics));
            } else if (index == 27) {
                this.o = typedArrayObtainStyledAttributes.getInt(index, this.o);
            } else if (index == 0) {
                this.p = typedArrayObtainStyledAttributes.getInt(index, this.p);
            } else if (index == 28) {
                this.K = typedArrayObtainStyledAttributes.getBoolean(index, this.K);
            } else if (index == 1) {
                this.L = typedArrayObtainStyledAttributes.getBoolean(index, this.L);
            } else if (index == 8) {
                this.x = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 10) {
                this.y = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 9) {
                this.z = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 7) {
                this.F = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 6) {
                this.Q = typedArrayObtainStyledAttributes.getDimension(index, 12.0f);
            } else if (index == 5) {
                this.R = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 22) {
                this.O = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == 4) {
                this.P = ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher));
            } else if (index == 23) {
                this.S = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == 20) {
                this.T = typedArrayObtainStyledAttributes.getBoolean(index, true);
            }
        }
        this.I = TextUtils.isEmpty(this.u);
        typedArrayObtainStyledAttributes.recycle();
        this.G = (int) ((this.s * 100.0f) / this.r);
        this.a = new Paint();
        this.b = new TextPaint();
        this.f412q = (int) ((this.e * 1.0f) / (this.o + this.p));
        Paint paint = new Paint();
        this.N = paint;
        paint.setAntiAlias(true);
    }

    private int d(int i, int i2) {
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

    private float getRatio() {
        return (this.s * 1.0f) / this.r;
    }

    public void e(int i, float f) {
        float fApplyDimension = TypedValue.applyDimension(i, f, getDisplayMetrics());
        if (this.v != fApplyDimension) {
            this.v = fApplyDimension;
            invalidate();
        }
    }

    public void f(int i, int i2, int i3) {
        g(i, i2, i3, null);
    }

    public void g(int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        this.t = i3;
        this.s = i;
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
        valueAnimatorOfInt.addUpdateListener(new a());
        valueAnimatorOfInt.start();
    }

    public float getCircleCenterX() {
        return this.f;
    }

    public float getCircleCenterY() {
        return this.g;
    }

    public String getLabelText() {
        return this.u;
    }

    public int getLabelTextColor() {
        return this.w;
    }

    public int getMax() {
        return this.r;
    }

    public int getProgress() {
        return this.s;
    }

    public int getProgressPercent() {
        return this.G;
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
        if (!this.I) {
            return this.u;
        }
        return this.G + "%";
    }

    public void h(int i) {
        f(this.s, i, this.t);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 200.0f, getDisplayMetrics());
        int iD = d(i, iApplyDimension);
        int iD2 = d(i2, iApplyDimension);
        this.f = ((getPaddingLeft() + iD) - getPaddingRight()) / 2.0f;
        this.g = ((getPaddingTop() + iD2) - getPaddingBottom()) / 2.0f;
        this.m = (((iD - Math.max(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom())) - this.c) / 2.0f) - this.n;
        float f = this.f;
        this.k = new SweepGradient(f, f, this.l, (float[]) null);
        this.M = true;
        setMeasuredDimension(iD, iD2);
    }

    public void setCapRound(boolean z) {
        this.L = z;
        invalidate();
    }

    public void setIconBgColor(int i) {
        this.V = i;
        invalidate();
    }

    public void setLabelPaddingBottom(float f) {
        this.F = f;
        invalidate();
    }

    public void setLabelPaddingLeft(float f) {
        this.x = f;
        invalidate();
    }

    public void setLabelPaddingRight(float f) {
        this.z = f;
        invalidate();
    }

    public void setLabelPaddingTop(float f) {
        this.y = f;
        invalidate();
    }

    public void setLabelText(String str) {
        this.u = str;
        this.I = TextUtils.isEmpty(str);
        invalidate();
    }

    public void setLabelTextColor(int i) {
        this.w = i;
        invalidate();
    }

    public void setLabelTextColorResource(int i) {
        setLabelTextColor(getResources().getColor(i));
    }

    public void setLabelTextSize(float f) {
        e(2, f);
    }

    public void setMax(int i) {
        this.r = i;
        invalidate();
    }

    public void setNormalColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setNormalStrokeWidth(float f) {
        this.U = f;
        invalidate();
    }

    public void setOnChangeListener(b bVar) {
    }

    public void setProgress(int i) {
        this.s = i;
        this.G = (int) ((i * 100.0f) / this.r);
        invalidate();
    }

    public void setProgressColor(int... iArr) {
        if (this.M) {
            float f = this.f;
            setShader(new SweepGradient(f, f, iArr, (float[]) null));
        } else {
            this.l = iArr;
            this.j = true;
        }
    }

    public void setProgressColorResource(int i) {
        setProgressColor(getResources().getColor(i));
    }

    public void setProgressStrokeWidth(float f) {
        this.c = f;
        invalidate();
    }

    public void setShader(Shader shader) {
        this.j = true;
        this.k = shader;
        invalidate();
    }

    public void setShowIcon(boolean z) {
        this.T = z;
        this.O = z;
        invalidate();
    }

    public void setShowTick(boolean z) {
        this.J = z;
        invalidate();
    }

    public void setStartAngle(int i) {
        this.d = i;
        invalidate();
    }

    public void setTurn(boolean z) {
        this.K = z;
        invalidate();
    }

    public void setmIcon(Bitmap bitmap) {
        this.P = bitmap;
        invalidate();
    }

    public void setmIconSize(float f) {
        this.Q = f;
        invalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 270;
        this.e = 360;
        this.h = -3618616;
        this.i = -11539796;
        this.j = true;
        this.l = new int[]{-506857, -303865, -366052, -366052, -506857};
        this.o = 5;
        this.p = 1;
        this.r = 100;
        this.s = 0;
        this.t = 500;
        this.w = -13421773;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = false;
        this.Q = d.c(12.0f);
        this.R = -1;
        this.T = true;
        this.V = -16777216;
        c(context, attributeSet);
    }

    public void setProgressColor(int i) {
        this.j = false;
        this.i = i;
        invalidate();
    }
}
