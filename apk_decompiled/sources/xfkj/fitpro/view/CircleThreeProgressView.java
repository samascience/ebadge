package xfkj.fitpro.view;

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
public class CircleThreeProgressView extends View {
    private float F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private Paint T;
    private boolean U;
    private Bitmap V;
    private Bitmap W;
    private Paint a;
    private Bitmap a0;
    private TextPaint b;
    private float b0;
    private float c;
    private int c0;
    private int d;
    private boolean d0;
    private int e;
    private boolean e0;
    private float f;
    private float f0;
    private float g;
    int g0;
    private int h;
    private int h0;
    private int i;
    private int i0;
    private int j;
    private int j0;
    private int k;
    private int l;
    private int m;
    private int[] n;
    private float o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f413q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private String z;

    public interface a {
    }

    public CircleThreeProgressView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        this.a.reset();
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setShader(null);
        if (this.Q) {
            this.a.setStrokeCap(Paint.Cap.ROUND);
        }
        float f = this.O ? (this.o - this.p) - this.c : this.o;
        float f2 = 2.0f * f;
        float f3 = this.f - f;
        float f4 = this.g - f;
        RectF rectF = new RectF(f3, f4, f3 + f2, f2 + f4);
        this.a.setStrokeWidth(this.f0);
        this.a.setStrokeWidth(this.c);
        int i = this.d;
        int i2 = this.g0;
        int i3 = i + i2;
        int i4 = this.e - (i2 * 2);
        int i5 = this.h;
        if (i5 != 0) {
            this.a.setColor(i5);
            canvas.drawArc(rectF, i3, this.e - (this.g0 * 2), false, this.a);
        }
        this.a.setColor(this.k);
        float f5 = i3;
        float f6 = i4;
        canvas.drawArc(rectF, f5, f6 * d(this.s, this.v), false, this.a);
        int i6 = i3 + this.e;
        int i7 = this.i;
        if (i7 != 0) {
            this.a.setColor(i7);
            canvas.drawArc(rectF, i6, this.e - (this.g0 * 2), false, this.a);
        }
        this.a.setColor(this.l);
        float f7 = i6;
        canvas.drawArc(rectF, f7, f6 * d(this.t, this.w), false, this.a);
        int i8 = i6 + this.e;
        int i9 = this.j;
        if (i9 != 0) {
            this.a.setColor(i9);
            canvas.drawArc(rectF, i8, this.e - (this.g0 * 2), false, this.a);
        }
        this.a.setColor(this.m);
        float f8 = i8;
        canvas.drawArc(rectF, f8, f6 * d(this.t, this.x), false, this.a);
        if (this.e0) {
            if (this.d0) {
                this.T.setShadowLayer(10.0f, 0.0f, 0.0f, -7829368);
            }
            if (this.U) {
                Bitmap bitmap = this.V;
                if (bitmap != null) {
                    b(canvas, f, f5, bitmap, this.h0);
                }
                Bitmap bitmap2 = this.W;
                if (bitmap2 != null) {
                    b(canvas, f, f7, bitmap2, this.i0);
                }
                Bitmap bitmap3 = this.a0;
                if (bitmap3 != null) {
                    b(canvas, f, f8, bitmap3, this.j0);
                }
            }
        }
    }

    private void b(Canvas canvas, float f, float f2, Bitmap bitmap, int i) {
        double d = f;
        double d2 = (((double) f2) * 3.141592653589793d) / 180.0d;
        double width = ((double) (getWidth() / 2)) + (Math.cos(d2) * d);
        double height = ((double) (getHeight() / 2)) + (d * Math.sin(d2));
        this.T.setColor(i);
        if (this.S) {
            canvas.drawCircle((float) width, (float) height, this.b0, this.T);
        }
        int width2 = bitmap.getWidth() > bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        float f3 = (this.b0 / 10.0f) * 9.8f;
        float f4 = width2;
        if (f4 > f3) {
            float f5 = f3 / f4;
            bitmap = ImageUtils.c(bitmap, f5, f5);
        }
        this.T.clearShadowLayer();
        canvas.drawBitmap(bitmap, ((float) width) - (bitmap.getWidth() / 2), ((float) height) - (bitmap.getHeight() / 2), this.T);
    }

    private void c(Canvas canvas) {
        if (this.M) {
            this.b.reset();
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.b.setTextSize(this.F);
            this.b.setColor(this.G);
            this.b.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
            float f = fontMetrics.bottom - fontMetrics.top;
            float width = ((getWidth() / 2) + this.H) - this.J;
            float height = (((getHeight() - ((getHeight() - f) / 2.0f)) - fontMetrics.bottom) + this.I) - this.K;
            if (!this.N) {
                if (TextUtils.isEmpty(this.z)) {
                    return;
                }
                canvas.drawText(this.z, width, height, this.b);
            } else {
                canvas.drawText(this.L + "%", width, height, this.b);
            }
        }
    }

    private float d(int i, int i2) {
        return (i2 * 1.0f) / i;
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleThreeProgressView);
        DisplayMetrics displayMetrics = getDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(1, 12.0f, displayMetrics);
        this.c = fApplyDimension;
        this.f0 = fApplyDimension / 2.0f;
        this.F = TypedValue.applyDimension(2, 30.0f, displayMetrics);
        this.p = TypedValue.applyDimension(1, 10.0f, displayMetrics);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 33) {
                this.c = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
            } else if (index == 26) {
                this.f0 = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
            } else if (index == 23) {
                this.h = typedArrayObtainStyledAttributes.getColor(index, -3618616);
            } else if (index == 24) {
                this.i = typedArrayObtainStyledAttributes.getColor(index, -3618616);
            } else if (index == 25) {
                this.j = typedArrayObtainStyledAttributes.getColor(index, -3618616);
            } else if (index == 28) {
                this.k = typedArrayObtainStyledAttributes.getColor(index, -11539796);
            } else if (index == 30) {
                this.l = typedArrayObtainStyledAttributes.getColor(index, -11539796);
            } else if (index == 32) {
                this.m = typedArrayObtainStyledAttributes.getColor(index, -11539796);
            } else if (index == 41) {
                this.d = typedArrayObtainStyledAttributes.getInt(index, -180);
            } else if (index == 42) {
                this.e = typedArrayObtainStyledAttributes.getInt(index, Opcodes.GETFIELD);
            } else if (index == 20) {
                this.s = typedArrayObtainStyledAttributes.getInt(index, 100);
            } else if (index == 21) {
                this.t = typedArrayObtainStyledAttributes.getInt(index, 100);
            } else if (index == 22) {
                this.u = typedArrayObtainStyledAttributes.getInt(index, 100);
            } else if (index == 27) {
                this.v = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == 29) {
                this.w = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == 31) {
                this.x = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == 3) {
                this.y = typedArrayObtainStyledAttributes.getInt(index, 500);
            } else if (index == 17) {
                this.z = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == 19) {
                this.F = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(2, 30.0f, displayMetrics));
            } else if (index == 18) {
                this.G = typedArrayObtainStyledAttributes.getColor(index, -13421773);
            } else if (index == 36) {
                this.M = typedArrayObtainStyledAttributes.getBoolean(index, this.M);
            } else if (index == 39) {
                this.O = typedArrayObtainStyledAttributes.getBoolean(index, this.O);
            } else if (index == 2) {
                this.p = typedArrayObtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 10.0f, displayMetrics));
            } else if (index == 43) {
                this.f413q = typedArrayObtainStyledAttributes.getInt(index, this.f413q);
            } else if (index == 0) {
                this.r = typedArrayObtainStyledAttributes.getInt(index, this.r);
            } else if (index == 44) {
                this.P = typedArrayObtainStyledAttributes.getBoolean(index, this.P);
            } else if (index == 1) {
                this.Q = typedArrayObtainStyledAttributes.getBoolean(index, this.Q);
            } else if (index == 14) {
                this.H = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 16) {
                this.I = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 15) {
                this.J = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 13) {
                this.K = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 11) {
                this.c0 = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 40) {
                this.g0 = typedArrayObtainStyledAttributes.getInt(index, 3);
            } else if (index == 12) {
                this.b0 = typedArrayObtainStyledAttributes.getDimension(index, 12.0f);
            } else if (index == 37) {
                this.U = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == 38) {
                this.d0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == 34) {
                this.e0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == 4) {
                this.V = ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher));
            } else if (index == 6) {
                this.W = ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher));
            } else if (index == 8) {
                this.a0 = ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher));
            } else if (index == 5) {
                this.h0 = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 5) {
                this.i0 = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 5) {
                this.j0 = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 35) {
                this.S = typedArrayObtainStyledAttributes.getBoolean(index, this.S);
            }
        }
        this.N = TextUtils.isEmpty(this.z);
        typedArrayObtainStyledAttributes.recycle();
        this.L = (int) ((this.v * 100.0f) / this.s);
        this.a = new Paint();
        this.b = new TextPaint();
        Paint paint = new Paint();
        this.T = paint;
        paint.setColor(this.c0);
        this.T.setAntiAlias(true);
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
        if (this.F != fApplyDimension) {
            this.F = fApplyDimension;
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
        return this.z;
    }

    public int getLabelTextColor() {
        return this.G;
    }

    public int getMax1() {
        return this.s;
    }

    public int getMax2() {
        return this.t;
    }

    public int getProgress1() {
        return this.v;
    }

    public int getProgress2() {
        return this.w;
    }

    public int getProgressPercent() {
        return this.L;
    }

    public float getRadius() {
        return this.o;
    }

    public int getStartAngle() {
        return this.d;
    }

    public int getSweepAngle() {
        return this.e;
    }

    public String getText() {
        if (!this.N) {
            return this.z;
        }
        return this.L + "%";
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
        this.o = (((iF - Math.max(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom())) - this.c) / 2.0f) - this.p;
        this.R = true;
        setMeasuredDimension(iF, iF2);
    }

    public void setCapRound(boolean z) {
        this.Q = z;
        invalidate();
    }

    public void setIconBgColor1(int i) {
        this.h0 = i;
        invalidate();
    }

    public void setIconBgColor2(int i) {
        this.i0 = i;
        invalidate();
    }

    public void setLabelPaddingBottom(float f) {
        this.K = f;
        invalidate();
    }

    public void setLabelPaddingLeft(float f) {
        this.H = f;
        invalidate();
    }

    public void setLabelPaddingRight(float f) {
        this.J = f;
        invalidate();
    }

    public void setLabelPaddingTop(float f) {
        this.I = f;
        invalidate();
    }

    public void setLabelText(String str) {
        this.z = str;
        this.N = TextUtils.isEmpty(str);
        invalidate();
    }

    public void setLabelTextColor(int i) {
        this.G = i;
        invalidate();
    }

    public void setLabelTextColorResource(int i) {
        setLabelTextColor(getResources().getColor(i));
    }

    public void setLabelTextSize(float f) {
        g(2, f);
    }

    public void setMax1(int i) {
        this.s = i;
        invalidate();
    }

    public void setMax2(int i) {
        this.t = i;
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
        this.f0 = f;
        invalidate();
    }

    public void setOnChangeListener(a aVar) {
    }

    public void setProgress1(int i) {
        this.v = i;
        invalidate();
    }

    public void setProgress1Color(int i) {
        this.k = i;
        invalidate();
    }

    public void setProgress2(int i) {
        this.w = i;
        invalidate();
    }

    public void setProgress2Color(int i) {
        this.l = i;
        invalidate();
    }

    public void setProgress3(int i) {
        this.x = i;
        invalidate();
    }

    public void setProgressAnim1(int i) {
        this.v = i;
        this.L = (int) ((i * 100.0f) / this.s);
        invalidate();
    }

    public void setProgressAnim2(int i) {
        this.w = i;
        this.L = (int) ((i * 100.0f) / this.t);
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
        this.e0 = z;
        this.U = z;
        invalidate();
    }

    public void setShowTick(boolean z) {
        this.O = z;
        invalidate();
    }

    public void setStartAngle(int i) {
        this.d = i;
        invalidate();
    }

    public void setTurn(boolean z) {
        this.P = z;
        invalidate();
    }

    public void setmIcon1(Bitmap bitmap) {
        this.V = bitmap;
        invalidate();
    }

    public void setmIcon2(Bitmap bitmap) {
        this.W = bitmap;
        invalidate();
    }

    public void setmIcon3(Bitmap bitmap) {
        this.a0 = bitmap;
        invalidate();
    }

    public void setmIconSize(float f) {
        this.b0 = f;
        invalidate();
    }

    public CircleThreeProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleThreeProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -150;
        this.e = 120;
        this.h = -3618616;
        this.i = -3618616;
        this.j = -3618616;
        this.k = -11539796;
        this.l = -11539796;
        this.m = -11539796;
        this.n = new int[]{-506857, -303865, -366052, -366052, -506857};
        this.f413q = 5;
        this.r = 1;
        this.s = 100;
        this.t = 100;
        this.u = 100;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 500;
        this.G = -13421773;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = false;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.b0 = 12.0f;
        this.c0 = -1;
        this.e0 = true;
        this.g0 = 6;
        this.h0 = -16777216;
        this.i0 = -16777216;
        this.j0 = -16777216;
        e(context, attributeSet);
    }
}
