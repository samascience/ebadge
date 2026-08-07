package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R$attr;
import androidx.constraintlayout.widget.R$styleable;
import defpackage.d70;
import defpackage.zn0;

/* JADX INFO: loaded from: classes.dex */
public class MotionLabel extends View implements zn0 {
    static String d0 = "MotionLabel";
    private float F;
    private float G;
    private float H;
    private Drawable I;
    Matrix J;
    private Bitmap K;
    private BitmapShader L;
    private Matrix M;
    private float N;
    private float O;
    private float P;
    private float Q;
    Paint R;
    private int S;
    Rect T;
    Paint U;
    float V;
    float W;
    TextPaint a;
    float a0;
    Path b;
    float b0;
    private int c;
    float c0;
    private int d;
    private boolean e;
    private float f;
    private float g;
    ViewOutlineProvider h;
    RectF i;
    private float j;
    private float k;
    private int l;
    private int m;
    private float n;
    private String o;
    boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Rect f183q;
    private int r;
    private int s;
    private int t;
    private int u;
    private String v;
    private Layout w;
    private int x;
    private int y;
    private boolean z;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = MotionLabel.this.getWidth();
            int height = MotionLabel.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionLabel.this.f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.g);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.j = 48.0f;
        this.k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.f183q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.x = 8388659;
        this.y = 0;
        this.z = false;
        this.N = Float.NaN;
        this.O = Float.NaN;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = new Paint();
        this.S = 0;
        this.W = Float.NaN;
        this.a0 = Float.NaN;
        this.b0 = Float.NaN;
        this.c0 = Float.NaN;
        g(context, null);
    }

    private void d(float f, float f2, float f3, float f4) {
        if (this.M == null) {
            return;
        }
        this.G = f3 - f;
        this.H = f4 - f2;
        l();
    }

    private void g(Context context, AttributeSet attributeSet) {
        i(context, attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLabel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionLabel_android_text) {
                    setText(typedArrayObtainStyledAttributes.getText(index));
                } else if (index == R$styleable.MotionLabel_android_fontFamily) {
                    this.v = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MotionLabel_scaleFromTextSize) {
                    this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.k);
                } else if (index == R$styleable.MotionLabel_android_textSize) {
                    this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.j);
                } else if (index == R$styleable.MotionLabel_android_textStyle) {
                    this.l = typedArrayObtainStyledAttributes.getInt(index, this.l);
                } else if (index == R$styleable.MotionLabel_android_typeface) {
                    this.m = typedArrayObtainStyledAttributes.getInt(index, this.m);
                } else if (index == R$styleable.MotionLabel_android_textColor) {
                    this.c = typedArrayObtainStyledAttributes.getColor(index, this.c);
                } else if (index == R$styleable.MotionLabel_borderRound) {
                    float dimension = typedArrayObtainStyledAttributes.getDimension(index, this.g);
                    this.g = dimension;
                    setRound(dimension);
                } else if (index == R$styleable.MotionLabel_borderRoundPercent) {
                    float f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    this.f = f;
                    setRoundPercent(f);
                } else if (index == R$styleable.MotionLabel_android_gravity) {
                    setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
                } else if (index == R$styleable.MotionLabel_android_autoSizeTextType) {
                    this.y = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.MotionLabel_textOutlineColor) {
                    this.d = typedArrayObtainStyledAttributes.getInt(index, this.d);
                    this.e = true;
                } else if (index == R$styleable.MotionLabel_textOutlineThickness) {
                    this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                    this.e = true;
                } else if (index == R$styleable.MotionLabel_textBackground) {
                    this.I = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.e = true;
                } else if (index == R$styleable.MotionLabel_textBackgroundPanX) {
                    this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                } else if (index == R$styleable.MotionLabel_textBackgroundPanY) {
                    this.a0 = typedArrayObtainStyledAttributes.getFloat(index, this.a0);
                } else if (index == R$styleable.MotionLabel_textPanX) {
                    this.P = typedArrayObtainStyledAttributes.getFloat(index, this.P);
                } else if (index == R$styleable.MotionLabel_textPanY) {
                    this.Q = typedArrayObtainStyledAttributes.getFloat(index, this.Q);
                } else if (index == R$styleable.MotionLabel_textBackgroundRotate) {
                    this.c0 = typedArrayObtainStyledAttributes.getFloat(index, this.c0);
                } else if (index == R$styleable.MotionLabel_textBackgroundZoom) {
                    this.b0 = typedArrayObtainStyledAttributes.getFloat(index, this.b0);
                } else if (index == R$styleable.MotionLabel_textureHeight) {
                    this.N = typedArrayObtainStyledAttributes.getDimension(index, this.N);
                } else if (index == R$styleable.MotionLabel_textureWidth) {
                    this.O = typedArrayObtainStyledAttributes.getDimension(index, this.O);
                } else if (index == R$styleable.MotionLabel_textureEffect) {
                    this.S = typedArrayObtainStyledAttributes.getInt(index, this.S);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    private float getHorizontalOffset() {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        TextPaint textPaint = this.a;
        String str = this.o;
        return (((((Float.isNaN(this.G) ? getMeasuredWidth() : this.G) - getPaddingLeft()) - getPaddingRight()) - (f * textPaint.measureText(str, 0, str.length()))) * (this.P + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.H) ? getMeasuredHeight() : this.H) - getPaddingTop()) - getPaddingBottom();
        float f2 = fontMetrics.descent;
        float f3 = fontMetrics.ascent;
        return (((measuredHeight - ((f2 - f3) * f)) * (1.0f - this.Q)) / 2.0f) - (f * f3);
    }

    private void h(String str, int i, int i2) {
        Typeface typefaceCreate;
        if (str != null) {
            typefaceCreate = Typeface.create(str, i2);
            if (typefaceCreate != null) {
                setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (i == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (i == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        if (i2 <= 0) {
            this.a.setFakeBoldText(false);
            this.a.setTextSkewX(0.0f);
            setTypeface(typefaceCreate);
        } else {
            Typeface typefaceDefaultFromStyle = typefaceCreate == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typefaceCreate, i2);
            setTypeface(typefaceDefaultFromStyle);
            int i3 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i2;
            this.a.setFakeBoldText((i3 & 1) != 0);
            this.a.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    private void i(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.a;
        int i = typedValue.data;
        this.c = i;
        textPaint.setColor(i);
    }

    private void k() {
        if (this.I != null) {
            this.M = new Matrix();
            int intrinsicWidth = this.I.getIntrinsicWidth();
            int intrinsicHeight = this.I.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.O) ? 128 : (int) this.O;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.N) ? 128 : (int) this.N;
            }
            if (this.S != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.K = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.K);
            this.I.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.I.setFilterBitmap(true);
            this.I.draw(canvas);
            if (this.S != 0) {
                this.K = e(this.K, 4);
            }
            Bitmap bitmap = this.K;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.L = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void l() {
        float f = Float.isNaN(this.W) ? 0.0f : this.W;
        float f2 = Float.isNaN(this.a0) ? 0.0f : this.a0;
        float f3 = Float.isNaN(this.b0) ? 1.0f : this.b0;
        float f4 = Float.isNaN(this.c0) ? 0.0f : this.c0;
        this.M.reset();
        float width = this.K.getWidth();
        float height = this.K.getHeight();
        float f5 = Float.isNaN(this.O) ? this.G : this.O;
        float f6 = Float.isNaN(this.N) ? this.H : this.N;
        float f7 = f3 * (width * f6 < height * f5 ? f5 / width : f6 / height);
        this.M.postScale(f7, f7);
        float f8 = width * f7;
        float f9 = f5 - f8;
        float f10 = f7 * height;
        float f11 = f6 - f10;
        if (!Float.isNaN(this.N)) {
            f11 = this.N / 2.0f;
        }
        if (!Float.isNaN(this.O)) {
            f9 = this.O / 2.0f;
        }
        this.M.postTranslate((((f * f9) + f5) - f8) * 0.5f, (((f2 * f11) + f6) - f10) * 0.5f);
        this.M.postRotate(f4, f5 / 2.0f, f6 / 2.0f);
        this.L.setLocalMatrix(this.M);
    }

    @Override // defpackage.zn0
    public void a(float f, float f2, float f3, float f4) {
        int i = (int) (f + 0.5f);
        this.F = f - i;
        int i2 = (int) (f3 + 0.5f);
        int i3 = i2 - i;
        int i4 = (int) (f4 + 0.5f);
        int i5 = (int) (0.5f + f2);
        int i6 = i4 - i5;
        float f5 = f3 - f;
        this.G = f5;
        float f6 = f4 - f2;
        this.H = f6;
        d(f, f2, f3, f4);
        if (getMeasuredHeight() == i6 && getMeasuredWidth() == i3) {
            super.layout(i, i5, i2, i4);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            super.layout(i, i5, i2, i4);
        }
        if (this.z) {
            if (this.T == null) {
                this.U = new Paint();
                this.T = new Rect();
                this.U.set(this.a);
                this.V = this.U.getTextSize();
            }
            this.G = f5;
            this.H = f6;
            Paint paint = this.U;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.T);
            int iWidth = this.T.width();
            float fHeight = this.T.height() * 1.3f;
            float f7 = (f5 - this.s) - this.r;
            float f8 = (f6 - this.u) - this.t;
            float f9 = iWidth;
            if (f9 * f8 > fHeight * f7) {
                this.a.setTextSize((this.V * f7) / f9);
            } else {
                this.a.setTextSize((this.V * f8) / fHeight);
            }
            if (this.e || !Float.isNaN(this.k)) {
                f(Float.isNaN(this.k) ? 1.0f : this.j / this.k);
            }
        }
    }

    Bitmap e(Bitmap bitmap, int i) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i2 = 0; i2 < i && width >= 32 && height >= 32; i2++) {
            width /= 2;
            height /= 2;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, width, height, true);
        }
        return bitmapCreateScaledBitmap;
    }

    void f(float f) {
        if (this.e || f != 1.0f) {
            this.b.reset();
            String str = this.o;
            int length = str.length();
            this.a.getTextBounds(str, 0, length, this.f183q);
            this.a.getTextPath(str, 0, length, 0.0f, 0.0f, this.b);
            if (f != 1.0f) {
                Log.v(d0, d70.a() + " scale " + f);
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                this.b.transform(matrix);
            }
            Rect rect = this.f183q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.p = false;
        }
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getScaleFromTextSize() {
        return this.k;
    }

    public float getTextBackgroundPanX() {
        return this.W;
    }

    public float getTextBackgroundPanY() {
        return this.a0;
    }

    public float getTextBackgroundRotate() {
        return this.c0;
    }

    public float getTextBackgroundZoom() {
        return this.b0;
    }

    public int getTextOutlineColor() {
        return this.d;
    }

    public float getTextPanX() {
        return this.P;
    }

    public float getTextPanY() {
        return this.Q;
    }

    public float getTextureHeight() {
        return this.N;
    }

    public float getTextureWidth() {
        return this.O;
    }

    public Typeface getTypeface() {
        return this.a.getTypeface();
    }

    void j() {
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        h(this.v, this.m, this.l);
        this.a.setColor(this.c);
        this.a.setStrokeWidth(this.n);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setFlags(128);
        setTextSize(this.j);
        this.a.setAntiAlias(true);
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        boolean zIsNaN = Float.isNaN(this.k);
        float f = zIsNaN ? 1.0f : this.j / this.k;
        this.G = i3 - i;
        this.H = i4 - i2;
        if (this.z) {
            if (this.T == null) {
                this.U = new Paint();
                this.T = new Rect();
                this.U.set(this.a);
                this.V = this.U.getTextSize();
            }
            Paint paint = this.U;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.T);
            int iWidth = this.T.width();
            int iHeight = (int) (this.T.height() * 1.3f);
            float f2 = (this.G - this.s) - this.r;
            float f3 = (this.H - this.u) - this.t;
            if (zIsNaN) {
                float f4 = iWidth;
                float f5 = iHeight;
                if (f4 * f3 > f5 * f2) {
                    this.a.setTextSize((this.V * f2) / f4);
                } else {
                    this.a.setTextSize((this.V * f3) / f5);
                }
            } else {
                float f6 = iWidth;
                float f7 = iHeight;
                f = f6 * f3 > f7 * f2 ? f2 / f6 : f3 / f7;
            }
        }
        if (this.e || !zIsNaN) {
            d(i, i2, i3, i4);
            f(f);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        super.onDraw(canvas);
        if (!this.e && f == 1.0f) {
            canvas.drawText(this.o, this.F + this.r + getHorizontalOffset(), this.t + getVerticalOffset(), this.a);
            return;
        }
        if (this.p) {
            f(f);
        }
        if (this.J == null) {
            this.J = new Matrix();
        }
        if (!this.e) {
            float horizontalOffset = this.r + getHorizontalOffset();
            float verticalOffset = this.t + getVerticalOffset();
            this.J.reset();
            this.J.preTranslate(horizontalOffset, verticalOffset);
            this.b.transform(this.J);
            this.a.setColor(this.c);
            this.a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.a.setStrokeWidth(this.n);
            canvas.drawPath(this.b, this.a);
            this.J.reset();
            this.J.preTranslate(-horizontalOffset, -verticalOffset);
            this.b.transform(this.J);
            return;
        }
        this.R.set(this.a);
        this.J.reset();
        float horizontalOffset2 = this.r + getHorizontalOffset();
        float verticalOffset2 = this.t + getVerticalOffset();
        this.J.postTranslate(horizontalOffset2, verticalOffset2);
        this.J.preScale(f, f);
        this.b.transform(this.J);
        if (this.L != null) {
            this.a.setFilterBitmap(true);
            this.a.setShader(this.L);
        } else {
            this.a.setColor(this.c);
        }
        this.a.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(this.n);
        canvas.drawPath(this.b, this.a);
        if (this.L != null) {
            this.a.setShader(null);
        }
        this.a.setColor(this.d);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.n);
        canvas.drawPath(this.b, this.a);
        this.J.reset();
        this.J.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.b.transform(this.J);
        this.a.set(this.R);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.z = false;
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.a;
            String str = this.o;
            textPaint.getTextBounds(str, 0, str.length(), this.f183q);
            if (mode != 1073741824) {
                size = (int) (this.f183q.width() + 0.99999f);
            }
            size += this.r + this.s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.t + this.u + fontMetricsInt;
            }
        } else if (this.y != 0) {
            this.z = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i) {
        if ((i & 8388615) == 0) {
            i |= 8388611;
        }
        if ((i & 112) == 0) {
            i |= 48;
        }
        if (i != this.x) {
            invalidate();
        }
        this.x = i;
        int i2 = i & 112;
        if (i2 == 48) {
            this.Q = -1.0f;
        } else if (i2 != 80) {
            this.Q = 0.0f;
        } else {
            this.Q = 1.0f;
        }
        int i3 = i & 8388615;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 8388611) {
                    if (i3 != 8388613) {
                        this.P = 0.0f;
                        return;
                    }
                }
            }
            this.P = 1.0f;
            return;
        }
        this.P = -1.0f;
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.g = f;
            float f2 = this.f;
            this.f = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.g != f;
        this.g = f;
        if (f != 0.0f) {
            if (this.b == null) {
                this.b = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                b bVar = new b();
                this.h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.b.reset();
            Path path = this.b;
            RectF rectF = this.i;
            float f3 = this.g;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.f != f;
        this.f = f;
        if (f != 0.0f) {
            if (this.b == null) {
                this.b = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                a aVar = new a();
                this.h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f) / 2.0f;
            this.i.set(0.0f, 0.0f, width, height);
            this.b.reset();
            this.b.addRoundRect(this.i, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f) {
        this.k = f;
    }

    public void setText(CharSequence charSequence) {
        this.o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f) {
        this.W = f;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float f) {
        this.a0 = f;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float f) {
        this.c0 = f;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float f) {
        this.b0 = f;
        l();
        invalidate();
    }

    public void setTextFillColor(int i) {
        this.c = i;
        invalidate();
    }

    public void setTextOutlineColor(int i) {
        this.d = i;
        this.e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f) {
        this.n = f;
        this.e = true;
        if (Float.isNaN(f)) {
            this.n = 1.0f;
            this.e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f) {
        this.P = f;
        invalidate();
    }

    public void setTextPanY(float f) {
        this.Q = f;
        invalidate();
    }

    public void setTextSize(float f) {
        this.j = f;
        Log.v(d0, d70.a() + "  " + f + " / " + this.k);
        TextPaint textPaint = this.a;
        if (!Float.isNaN(this.k)) {
            f = this.k;
        }
        textPaint.setTextSize(f);
        f(Float.isNaN(this.k) ? 1.0f : this.j / this.k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f) {
        this.N = f;
        l();
        invalidate();
    }

    public void setTextureWidth(float f) {
        this.O = f;
        l();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.a.getTypeface() != typeface) {
            this.a.setTypeface(typeface);
            if (this.w != null) {
                this.w = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.j = 48.0f;
        this.k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.f183q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.x = 8388659;
        this.y = 0;
        this.z = false;
        this.N = Float.NaN;
        this.O = Float.NaN;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = new Paint();
        this.S = 0;
        this.W = Float.NaN;
        this.a0 = Float.NaN;
        this.b0 = Float.NaN;
        this.c0 = Float.NaN;
        g(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 65535;
        this.d = 65535;
        this.e = false;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.j = 48.0f;
        this.k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.f183q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.x = 8388659;
        this.y = 0;
        this.z = false;
        this.N = Float.NaN;
        this.O = Float.NaN;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = new Paint();
        this.S = 0;
        this.W = Float.NaN;
        this.a0 = Float.NaN;
        this.b0 = Float.NaN;
        this.c0 = Float.NaN;
        g(context, attributeSet);
    }
}
