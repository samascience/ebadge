package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.connect.common.Constants;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class MyCircleBar extends View {
    private Paint F;
    private RectF G;
    private int H;
    private int I;
    private int J;
    private String K;
    private int L;
    private Paint M;
    private int N;
    private boolean O;
    private Bitmap P;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Paint h;
    private Paint i;
    private Paint j;
    private RectF k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f416q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private SweepGradient v;
    private PaintFlagsDrawFilter w;
    private a x;
    private float y;
    private Paint z;

    public class a extends Animation {
        public a() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            if (f < 1.0f) {
                MyCircleBar myCircleBar = MyCircleBar.this;
                myCircleBar.y = (myCircleBar.p / MyCircleBar.this.f416q) * MyCircleBar.this.g * f;
                MyCircleBar myCircleBar2 = MyCircleBar.this;
                myCircleBar2.J = (int) (myCircleBar2.p * f);
            } else {
                MyCircleBar myCircleBar3 = MyCircleBar.this;
                myCircleBar3.y = (myCircleBar3.p / MyCircleBar.this.f416q) * MyCircleBar.this.g;
                MyCircleBar myCircleBar4 = MyCircleBar.this;
                myCircleBar4.J = myCircleBar4.p;
            }
            MyCircleBar.this.postInvalidate();
        }
    }

    public MyCircleBar(Context context) {
        this(context, null);
    }

    private int f(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private SweepGradient g() {
        if (this.v == null) {
            int i = this.b;
            if (i == 1) {
                float f = this.n;
                float f2 = this.o;
                int i2 = this.s;
                this.v = new SweepGradient(f, f2, new int[]{i2, this.t, this.u, i2}, (float[]) null);
            } else if (i == 2) {
                float f3 = this.n;
                float f4 = this.o;
                int i3 = this.s;
                int i4 = this.t;
                this.v = new SweepGradient(f3, f4, new int[]{i3, i4, this.u, i4, i3}, (float[]) null);
            }
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f, this.n, this.o);
            this.v.setLocalMatrix(matrix);
        }
        return this.v;
    }

    private void h() {
        int i = this.b;
        this.f = i == 2 ? 270 : Opcodes.I2D;
        this.g = i == 2 ? 360 : 270;
        this.k = new RectF();
        this.m = (this.c >> 1) + f(2);
        this.L = this.c + f(2);
        this.x = new a();
        this.G = new RectF();
    }

    private void i() {
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.h.setDither(true);
        this.h.setStrokeWidth(this.c);
        this.h.setColor(this.d);
        Paint paint2 = this.h;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = this.h;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.i = paint4;
        paint4.setAntiAlias(true);
        this.i.setDither(true);
        this.i.setStrokeWidth(this.c);
        this.i.setStyle(style);
        this.i.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.z = paint5;
        paint5.setAntiAlias(true);
        this.z.setColor(this.H);
        Paint paint6 = this.z;
        Paint.Align align = Paint.Align.CENTER;
        paint6.setTextAlign(align);
        Paint paint7 = this.z;
        Paint.Style style2 = Paint.Style.FILL;
        paint7.setStyle(style2);
        Paint paint8 = new Paint();
        this.F = paint8;
        paint8.setAntiAlias(true);
        this.F.setColor(this.I);
        this.F.setTextAlign(align);
        this.F.setStyle(style2);
        Paint paint9 = new Paint();
        this.M = paint9;
        paint9.setAntiAlias(true);
        this.M.setDither(true);
        this.M.setColor(this.N);
        this.w = new PaintFlagsDrawFilter(0, 3);
        Paint paint10 = new Paint();
        this.j = paint10;
        paint10.setAntiAlias(true);
        this.j.setDither(true);
        this.j.setStyle(style2);
        this.j.setStrokeWidth(1.0f);
    }

    private void j(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MyCircleBar);
        this.b = typedArrayObtainStyledAttributes.getInt(5, 2);
        this.c = f((int) typedArrayObtainStyledAttributes.getDimension(8, 20.0f));
        this.d = typedArrayObtainStyledAttributes.getColor(7, -1);
        this.e = typedArrayObtainStyledAttributes.getColor(6, -5509811);
        this.p = typedArrayObtainStyledAttributes.getInt(9, 0);
        this.f416q = typedArrayObtainStyledAttributes.getInt(4, 6000);
        this.r = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.s = typedArrayObtainStyledAttributes.getColor(13, -16711936);
        this.t = typedArrayObtainStyledAttributes.getColor(0, -256);
        this.u = typedArrayObtainStyledAttributes.getColor(1, Opcodes.V_PREVIEW);
        this.H = typedArrayObtainStyledAttributes.getColor(3, -1);
        this.I = typedArrayObtainStyledAttributes.getColor(12, -1);
        this.N = typedArrayObtainStyledAttributes.getColor(10, -65281);
        this.O = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private int k(int i, int i2) {
        if (i == 1073741824) {
            return i2;
        }
        if (i == Integer.MIN_VALUE) {
            return Math.min(i2, 200);
        }
        return 0;
    }

    public int getProgress() {
        return this.p;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        RectF rectF = this.k;
        int i3 = this.m;
        rectF.left = i3;
        rectF.top = i3;
        int i4 = this.a;
        rectF.right = i4 - i3;
        rectF.bottom = i4 - i3;
        this.l = (i4 >> 1) - i3;
        this.G.left = (int) (((double) ((((int) Math.sqrt(Math.pow(i4, 2.0d) + Math.pow(this.a, 2.0d))) / 2) - this.l)) * Math.sin(45.0d));
        RectF rectF2 = this.G;
        float f = rectF2.left;
        rectF2.top = f;
        int i5 = this.a;
        rectF2.right = i5 - f;
        float f2 = i5 - f;
        rectF2.bottom = f2;
        int i6 = ((int) (f2 - f)) / 5;
        int i7 = i6 / 2;
        this.z.setTextSize(i7 + 5);
        Paint paint = this.z;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        paint.setTypeface(typeface);
        canvas.drawText("目标:" + this.K, this.a / 2, (i6 * 5) + this.G.top, this.z);
        this.F.setTextSize((float) (i6 * 2));
        this.F.setTypeface(typeface);
        canvas.drawText(this.J + Constants.STR_EMPTY, this.a / 2, (i7 * 5.0f) + 20.0f + this.G.top, this.F);
        int i8 = this.a >> 1;
        this.n = i8;
        this.o = i8;
        int i9 = this.b;
        if (i9 == 1) {
            canvas.drawArc(this.k, this.f, this.g, false, this.h);
        } else if (i9 == 2) {
            canvas.drawCircle(i8, i8, this.l, this.h);
        }
        if (this.r) {
            this.i.setShader(g());
        } else {
            this.i.setColor(this.e);
        }
        int i10 = this.J;
        int i11 = this.f416q;
        if (i10 <= i11) {
            RectF rectF3 = this.k;
            float f3 = this.f;
            float f4 = this.y;
            if (f4 == 0.0f) {
                f4 = (this.p / i11) * this.g;
            }
            canvas.drawArc(rectF3, f3, f4, false, this.i);
        } else {
            canvas.drawArc(this.k, this.f, this.g, false, this.i);
        }
        if (this.P != null && (i2 = this.p) > 0) {
            int i12 = this.g;
            float f5 = i12;
            int i13 = this.J;
            int i14 = this.f416q;
            if (i13 <= i14) {
                f5 = this.y;
                if (f5 == 0.0f) {
                    f5 = (i2 / i14) * i12;
                }
            }
            double dAbs = (float) Math.abs((((double) f5) * 3.141592653589793d) / 180.0d);
            double dSin = Math.sin(dAbs);
            int i15 = this.l;
            float fAbs = (float) Math.abs((dSin * ((double) i15)) + ((double) i15) + 24.0d);
            float fAbs2 = (float) Math.abs(((double) (this.l + 24)) - (Math.cos(dAbs) * ((double) this.l)));
            canvas.drawCircle(fAbs, fAbs2, 20.0f, this.j);
            float width = this.P.getWidth() / 2;
            canvas.drawBitmap(this.P, fAbs - width, fAbs2 - width, this.j);
        }
        if (this.O) {
            int i16 = ((int) (this.G.top - this.L)) / 2;
            float f6 = (this.g * 1.0f) / 100.0f;
            canvas.save();
            if (this.b == 2) {
                canvas.rotate(-180.0f, this.n, this.o);
                i = 100;
            } else {
                canvas.rotate(-135.0f, this.n, this.o);
                i = 101;
            }
            int i17 = i;
            canvas.translate(this.n, this.L);
            for (int i18 = 0; i18 < i17; i18++) {
                if (i18 % 10 == 0) {
                    canvas.drawLine(0.0f, 0.0f, 0.0f, i16, this.M);
                } else {
                    canvas.drawLine(0.0f, 0.0f, 0.0f, i16 / 2, this.M);
                }
                canvas.rotate(f6, 0.0f, this.o - this.L);
            }
            canvas.restore();
        }
        canvas.setDrawFilter(this.w);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int iMin = Math.min(k(mode, View.MeasureSpec.getSize(i)), k(mode2, View.MeasureSpec.getSize(i2)));
        this.a = iMin;
        setMeasuredDimension(iMin, iMin);
    }

    public void setMaxProgress(int i) {
        this.f416q = i;
        this.K = i + Constants.STR_EMPTY;
        this.K = i + Constants.STR_EMPTY;
    }

    public MyCircleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyCircleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.P = null;
        j(attributeSet);
        h();
        i();
    }
}
