package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class CircleImageView extends ImageView {
    private static final ImageView.ScaleType u = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config v = Bitmap.Config.ARGB_8888;
    private final RectF a;
    private final RectF b;
    private final Matrix c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private int g;
    private int h;
    private int i;
    private Bitmap j;
    private BitmapShader k;
    private int l;
    private int m;
    private float n;
    private float o;
    private ColorFilter p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f323q;
    private boolean r;
    private boolean s;
    private boolean t;

    private class b extends ViewOutlineProvider {
        private b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.b.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = -16777216;
        this.h = 0;
        this.i = 0;
        e();
    }

    private void b() {
        Paint paint = this.d;
        if (paint != null) {
            paint.setColorFilter(this.p);
        }
    }

    private RectF c() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int iMin = Math.min(width, height);
        float paddingLeft = getPaddingLeft() + ((width - iMin) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - iMin) / 2.0f);
        float f = iMin;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    private Bitmap d(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, v) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), v);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void e() {
        super.setScaleType(u);
        this.f323q = true;
        setOutlineProvider(new b());
        if (this.r) {
            g();
            this.r = false;
        }
    }

    private void f() {
        if (this.t) {
            this.j = null;
        } else {
            this.j = d(getDrawable());
        }
        g();
    }

    private void g() {
        int i;
        if (!this.f323q) {
            this.r = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.j == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.j;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.k = new BitmapShader(bitmap, tileMode, tileMode);
        this.d.setAntiAlias(true);
        this.d.setShader(this.k);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        this.e.setColor(this.g);
        this.e.setStrokeWidth(this.h);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
        this.f.setColor(this.i);
        this.m = this.j.getHeight();
        this.l = this.j.getWidth();
        this.b.set(c());
        this.o = Math.min((this.b.height() - this.h) / 2.0f, (this.b.width() - this.h) / 2.0f);
        this.a.set(this.b);
        if (!this.s && (i = this.h) > 0) {
            this.a.inset(i - 1.0f, i - 1.0f);
        }
        this.n = Math.min(this.a.height() / 2.0f, this.a.width() / 2.0f);
        b();
        h();
        invalidate();
    }

    private void h() {
        float fWidth;
        float fHeight;
        this.c.set(null);
        float fWidth2 = 0.0f;
        if (this.l * this.a.height() > this.a.width() * this.m) {
            fWidth = this.a.height() / this.m;
            fHeight = 0.0f;
            fWidth2 = (this.a.width() - (this.l * fWidth)) * 0.5f;
        } else {
            fWidth = this.a.width() / this.l;
            fHeight = (this.a.height() - (this.m * fWidth)) * 0.5f;
        }
        this.c.setScale(fWidth, fWidth);
        Matrix matrix = this.c;
        RectF rectF = this.a;
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF.left, ((int) (fHeight + 0.5f)) + rectF.top);
        this.k.setLocalMatrix(this.c);
    }

    public int getBorderColor() {
        return this.g;
    }

    public int getBorderWidth() {
        return this.h;
    }

    public int getCircleBackgroundColor() {
        return this.i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.p;
    }

    @Deprecated
    public int getFillColor() {
        return getCircleBackgroundColor();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return u;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.t) {
            super.onDraw(canvas);
            return;
        }
        if (this.j == null) {
            return;
        }
        if (this.i != 0) {
            canvas.drawCircle(this.a.centerX(), this.a.centerY(), this.n, this.f);
        }
        canvas.drawCircle(this.a.centerX(), this.a.centerY(), this.n, this.d);
        if (this.h > 0) {
            canvas.drawCircle(this.b.centerX(), this.b.centerY(), this.o, this.e);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        g();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        this.e.setColor(i);
        invalidate();
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public void setBorderOverlay(boolean z) {
        if (z == this.s) {
            return;
        }
        this.s = z;
        g();
    }

    public void setBorderWidth(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        g();
    }

    public void setCircleBackgroundColor(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        this.f.setColor(i);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.p) {
            return;
        }
        this.p = colorFilter;
        b();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.t == z) {
            return;
        }
        this.t = z;
        f();
    }

    @Deprecated
    public void setFillColor(int i) {
        setCircleBackgroundColor(i);
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setCircleBackgroundColorResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        f();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        f();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        f();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        f();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        g();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        g();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != u) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = -16777216;
        this.h = 0;
        this.i = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleImageView, i, 0);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleImageView_civ_border_width, 0);
        this.g = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleImageView_civ_border_color, -16777216);
        this.s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CircleImageView_civ_border_overlay, false);
        int i2 = R$styleable.CircleImageView_civ_circle_background_color;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.i = typedArrayObtainStyledAttributes.getColor(i2, 0);
        } else {
            int i3 = R$styleable.CircleImageView_civ_fill_color;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.i = typedArrayObtainStyledAttributes.getColor(i3, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        e();
    }
}
