package xfkj.fitpro.view.polygon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.b42;
import defpackage.c42;
import defpackage.te2;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class PolygonImageView extends AppCompatImageView {
    private Paint d;
    private Paint e;
    private Path f;
    private b42 g;
    private c42 h;
    private int i;
    private int j;

    public PolygonImageView(Context context) {
        this(context, null);
    }

    private static Bitmap c(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError unused) {
            Log.e("PolygonImageView", "OutOfMemory during bitmap creation");
            return null;
        }
    }

    private void d() {
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setPathEffect(new CornerPathEffect(this.h.f()));
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.e.setPathEffect(new CornerPathEffect(this.h.f()));
        if (this.h.n()) {
            this.e.setColor(this.h.b());
            this.e.setStrokeWidth(this.h.c());
        }
        if (this.h.o()) {
            this.e.setShadowLayer(this.h.k(), this.h.l(), this.h.m(), this.h.j());
        }
        setLayerType(1, null);
        this.g = new te2();
    }

    private int e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return (mode == 1073741824 || mode == Integer.MIN_VALUE) ? size : Math.min(this.i, this.j);
    }

    private int f(int i) {
        return e(i) + 2;
    }

    private int g(int i) {
        return e(i);
    }

    private void h() {
        float fC = this.h.n() ? this.h.c() : 0.0f;
        float fK = this.h.o() ? this.h.k() : 0.0f;
        c42 c42Var = this.h;
        c42Var.r((c42Var.g() / 2.0f) + ((getPaddingLeft() + getPaddingRight()) / 2.0f) + fC + fK);
        c42 c42Var2 = this.h;
        c42Var2.s((c42Var2.g() / 2.0f) + ((getPaddingTop() + getPaddingBottom()) / 2.0f) + fC + fK);
        if (this.h.h() < 3) {
            return;
        }
        this.f = this.g.a(this.h);
    }

    private void i() {
        Bitmap bitmapC = c(getDrawable());
        int iMin = Math.min(this.i, this.j);
        if (iMin <= 0 || bitmapC == null) {
            return;
        }
        Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(bitmapC, iMin, iMin);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.d.setShader(new BitmapShader(bitmapExtractThumbnail, tileMode, tileMode));
    }

    private void j() {
        if (this.h.n()) {
            this.e.setStrokeWidth(this.h.c());
            this.e.setColor(this.h.b());
        } else {
            this.e.setStrokeWidth(0.0f);
            this.e.setColor(0);
        }
        k();
        invalidate();
    }

    private void k() {
        l(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    private void l(int i, int i2, int i3, int i4) {
        c42 c42Var = this.h;
        if (c42Var == null) {
            return;
        }
        float fC = (c42Var.n() ? this.h.c() : 0.0f) * 2.0f;
        float fK = (this.h.o() ? this.h.k() : 0.0f) * 2.0f;
        float fMin = Math.min(this.i - (((i + i3) + fC) + fK), this.j - (((i2 + i4) + fC) + fK));
        if (fMin != this.h.g()) {
            this.h.u(fMin);
            h();
        }
    }

    public b42 getPolygonShape() {
        return this.g;
    }

    public c42 getPolygonShapeSpec() {
        return this.h;
    }

    public float getRotationAngle() {
        return this.h.i();
    }

    public int getVertices() {
        return this.h.h();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null || getDrawable().getIntrinsicWidth() == 0 || getDrawable().getIntrinsicHeight() == 0) {
            return;
        }
        int iH = this.h.h();
        if (iH == 0) {
            if (this.h.o() || this.h.n()) {
                canvas.drawCircle(this.h.d(), this.h.e(), this.h.g() / 2.0f, this.e);
            }
            canvas.drawCircle(this.h.d(), this.h.e(), this.h.g() / 2.0f, this.d);
            return;
        }
        if (iH == 1) {
            super.onDraw(canvas);
            return;
        }
        if (iH != 2) {
            if (this.h.o() || this.h.n()) {
                canvas.drawPath(this.f, this.e);
            }
            canvas.drawPath(this.f, this.d);
            return;
        }
        if (this.h.o() || this.h.n()) {
            canvas.drawRect(this.h.d() - (this.h.g() / 2.0f), this.h.e() - (this.h.g() / 2.0f), this.h.d() + (this.h.g() / 2.0f), this.h.e() + (this.h.g() / 2.0f), this.e);
        }
        canvas.drawRect(this.h.d() - (this.h.g() / 2.0f), this.h.e() - (this.h.g() / 2.0f), this.h.d() + (this.h.g() / 2.0f), this.h.e() + (this.h.g() / 2.0f), this.d);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(g(i), f(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = i;
        this.j = i2;
        k();
        if (Math.min(this.i, this.j) != Math.min(i3, i4)) {
            i();
        }
    }

    public void setBorder(boolean z) {
        this.h.v(z);
        j();
    }

    public void setBorderColor(int i) {
        this.h.p(i);
        this.e.setColor(i);
        invalidate();
    }

    public void setBorderColorResource(int i) {
        setBorderColor(getResources().getColor(i));
    }

    public void setBorderWidth(float f) {
        this.h.q(f * getResources().getDisplayMetrics().density);
        j();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        invalidate();
    }

    public void setColorFilterWithBorder(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        this.e.setColorFilter(colorFilter);
        invalidate();
    }

    public void setCornerRadius(float f) {
        this.h.t(f);
        this.e.setPathEffect(new CornerPathEffect(f));
        this.d.setPathEffect(new CornerPathEffect(f));
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        i();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        i();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        i();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        i();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        l(i, i2, i3, i4);
        invalidate(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        k();
        invalidate();
    }

    public void setPolygonShape(b42 b42Var) {
        this.g = b42Var;
        h();
        invalidate();
    }

    public void setPolygonShapeSpec(c42 c42Var) {
        this.h = c42Var;
    }

    public void setRotationAngle(float f) {
        this.h.y(f);
        h();
        invalidate();
    }

    public void setVertices(int i) {
        this.h.x(i);
        h();
        invalidate();
    }

    public PolygonImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.polygonImageViewStyle);
    }

    public PolygonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new c42();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PolygonImageView, i, 0);
        try {
            this.h.y(typedArrayObtainStyledAttributes.getFloat(4, 0.0f));
            this.h.x(typedArrayObtainStyledAttributes.getInteger(7, 6));
            this.h.t(typedArrayObtainStyledAttributes.getFloat(3, 0.0f));
            this.h.w(typedArrayObtainStyledAttributes.getBoolean(5, false));
            this.h.z(typedArrayObtainStyledAttributes.getColor(6, -16777216));
            this.h.v(typedArrayObtainStyledAttributes.getBoolean(0, false));
            this.h.p(typedArrayObtainStyledAttributes.getColor(1, -1));
            this.h.q(typedArrayObtainStyledAttributes.getDimension(2, 4.0f));
            typedArrayObtainStyledAttributes.recycle();
            d();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
