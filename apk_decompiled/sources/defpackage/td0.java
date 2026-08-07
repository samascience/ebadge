package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class td0 extends Drawable {
    private static final float m = (float) Math.toRadians(45.0d);
    private final Paint a;
    private float b;
    private float c;
    private float d;
    private float e;
    private boolean f;
    private final Path g;
    private final int h;
    private boolean i;
    private float j;
    private float k;
    private int l;

    public td0(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        this.g = new Path();
        this.i = false;
        this.l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R$attr.drawerArrowStyle, R$style.Base_Widget_AppCompat_DrawerArrowToggle);
        c(typedArrayObtainStyledAttributes.getColor(R$styleable.DrawerArrowToggle_color, 0));
        b(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_thickness, 0.0f));
        f(typedArrayObtainStyledAttributes.getBoolean(R$styleable.DrawerArrowToggle_spinBars, true));
        d(Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DrawerArrowToggle_drawableSize, 0);
        this.c = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_barLength, 0.0f));
        this.b = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.d = typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float a(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public void b(float f) {
        if (this.a.getStrokeWidth() != f) {
            this.a.setStrokeWidth(f);
            this.k = (float) (((double) (f / 2.0f)) * Math.cos(m));
            invalidateSelf();
        }
    }

    public void c(int i) {
        if (i != this.a.getColor()) {
            this.a.setColor(i);
            invalidateSelf();
        }
    }

    public void d(float f) {
        if (f != this.e) {
            this.e = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.l;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? dd0.f(this) == 0 : dd0.f(this) == 1))) {
            z = true;
        }
        float f = this.b;
        float fA = a(this.c, (float) Math.sqrt(f * f * 2.0f), this.j);
        float fA2 = a(this.c, this.d, this.j);
        float fRound = Math.round(a(0.0f, this.k, this.j));
        float fA3 = a(0.0f, m, this.j);
        float fA4 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.j);
        double d = fA;
        double d2 = fA3;
        boolean z2 = z;
        float fRound2 = Math.round(Math.cos(d2) * d);
        float fRound3 = Math.round(d * Math.sin(d2));
        this.g.rewind();
        float fA5 = a(this.e + this.a.getStrokeWidth(), -this.k, this.j);
        float f2 = (-fA2) / 2.0f;
        this.g.moveTo(f2 + fRound, 0.0f);
        this.g.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.g.moveTo(f2, fA5);
        this.g.rLineTo(fRound2, fRound3);
        this.g.moveTo(f2, -fA5);
        this.g.rLineTo(fRound2, -fRound3);
        this.g.close();
        canvas.save();
        float strokeWidth = this.a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        float f3 = this.e;
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * f3))) / 4) * 2) + (strokeWidth * 1.5f) + f3);
        if (this.f) {
            canvas.rotate(fA4 * (this.i ^ z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.g, this.a);
        canvas.restore();
    }

    public void e(float f) {
        if (this.j != f) {
            this.j = f;
            invalidateSelf();
        }
    }

    public void f(boolean z) {
        if (this.f != z) {
            this.f = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.a.getAlpha()) {
            this.a.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
