package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.material.R$attr;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
public class tg1 extends Drawable implements ho2 {
    private static final String x = "tg1";
    private static final Paint y;
    private c a;
    private final co2.g[] b;
    private final co2.g[] c;
    private final BitSet d;
    private boolean e;
    private final Matrix f;
    private final Path g;
    private final Path h;
    private final RectF i;
    private final RectF j;
    private final Region k;
    private final Region l;
    private sn2 m;
    private final Paint n;
    private final Paint o;
    private final qn2 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final tn2.b f388q;
    private final tn2 r;
    private PorterDuffColorFilter s;
    private PorterDuffColorFilter t;
    private int u;
    private final RectF v;
    private boolean w;

    class a implements tn2.b {
        a() {
        }

        @Override // tn2.b
        public void a(co2 co2Var, Matrix matrix, int i) {
            tg1.this.d.set(i + 4, co2Var.e());
            tg1.this.c[i] = co2Var.f(matrix);
        }

        @Override // tn2.b
        public void b(co2 co2Var, Matrix matrix, int i) {
            tg1.this.d.set(i, co2Var.e());
            tg1.this.b[i] = co2Var.f(matrix);
        }
    }

    class b implements sn2.c {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        @Override // sn2.c
        public l40 a(l40 l40Var) {
            return l40Var instanceof ue2 ? l40Var : new w4(this.a, l40Var);
        }
    }

    static {
        Paint paint = new Paint(1);
        y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public tg1() {
        this(new sn2());
    }

    private float G() {
        if (P()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean N() {
        c cVar = this.a;
        int i = cVar.f389q;
        return i != 1 && cVar.r > 0 && (i == 2 || X());
    }

    private boolean O() {
        Paint.Style style = this.a.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean P() {
        Paint.Style style = this.a.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    private void R() {
        super.invalidateSelf();
    }

    private void U(Canvas canvas) {
        if (N()) {
            canvas.save();
            W(canvas);
            if (!this.w) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.v.width() - getBounds().width());
            int iHeight = (int) (this.v.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.v.width()) + (this.a.r * 2) + iWidth, ((int) this.v.height()) + (this.a.r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f = (getBounds().left - this.a.r) - iWidth;
            float f2 = (getBounds().top - this.a.r) - iHeight;
            canvas2.translate(-f, -f2);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f, f2, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int V(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private void W(Canvas canvas) {
        canvas.translate(B(), C());
    }

    private PorterDuffColorFilter f(Paint paint, boolean z) {
        if (!z) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.u = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.a.j != 1.0f) {
            this.f.reset();
            Matrix matrix = this.f;
            float f = this.a.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f);
        }
        path.computeBounds(this.v, true);
    }

    private void i() {
        sn2 sn2VarY = E().y(new b(-G()));
        this.m = sn2VarY;
        this.r.e(sn2VarY, this.a.k, v(), this.h);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        this.u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? f(paint, z) : j(colorStateList, mode, z);
    }

    public static tg1 m(Context context, float f, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(og1.c(context, R$attr.colorSurface, tg1.class.getSimpleName()));
        }
        tg1 tg1Var = new tg1();
        tg1Var.Q(context);
        tg1Var.b0(colorStateList);
        tg1Var.a0(f);
        return tg1Var;
    }

    private void n(Canvas canvas) {
        if (this.d.cardinality() > 0) {
            Log.w(x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.a.s != 0) {
            canvas.drawPath(this.g, this.p.c());
        }
        for (int i = 0; i < 4; i++) {
            this.b[i].a(this.p, this.a.r, canvas);
            this.c[i].a(this.p, this.a.r, canvas);
        }
        if (this.w) {
            int iB = B();
            int iC = C();
            canvas.translate(-iB, -iC);
            canvas.drawPath(this.g, y);
            canvas.translate(iB, iC);
        }
    }

    private boolean n0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.a.d == null || color2 == (colorForState2 = this.a.d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.a.e == null || color == (colorForState = this.a.e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }

    private void o(Canvas canvas) {
        p(canvas, this.n, this.g, this.a.a, u());
    }

    private boolean o0() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        c cVar = this.a;
        this.s = k(cVar.g, cVar.h, this.n, true);
        c cVar2 = this.a;
        this.t = k(cVar2.f, cVar2.h, this.o, false);
        c cVar3 = this.a;
        if (cVar3.u) {
            this.p.d(cVar3.g.getColorForState(getState(), 0));
        }
        return (tt1.a(porterDuffColorFilter, this.s) && tt1.a(porterDuffColorFilter2, this.t)) ? false : true;
    }

    private void p(Canvas canvas, Paint paint, Path path, sn2 sn2Var, RectF rectF) {
        if (!sn2Var.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = sn2Var.t().a(rectF) * this.a.k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    private void p0() {
        float fM = M();
        this.a.r = (int) Math.ceil(0.75f * fM);
        this.a.s = (int) Math.ceil(fM * 0.25f);
        o0();
        R();
    }

    private RectF v() {
        this.j.set(u());
        float fG = G();
        this.j.inset(fG, fG);
        return this.j;
    }

    public int A() {
        return this.u;
    }

    public int B() {
        c cVar = this.a;
        return (int) (((double) cVar.s) * Math.sin(Math.toRadians(cVar.t)));
    }

    public int C() {
        c cVar = this.a;
        return (int) (((double) cVar.s) * Math.cos(Math.toRadians(cVar.t)));
    }

    public int D() {
        return this.a.r;
    }

    public sn2 E() {
        return this.a.a;
    }

    public ColorStateList F() {
        return this.a.e;
    }

    public float H() {
        return this.a.l;
    }

    public ColorStateList I() {
        return this.a.g;
    }

    public float J() {
        return this.a.a.r().a(u());
    }

    public float K() {
        return this.a.a.t().a(u());
    }

    public float L() {
        return this.a.p;
    }

    public float M() {
        return w() + L();
    }

    public void Q(Context context) {
        this.a.b = new hf0(context);
        p0();
    }

    public boolean S() {
        hf0 hf0Var = this.a.b;
        return hf0Var != null && hf0Var.e();
    }

    public boolean T() {
        return this.a.a.u(u());
    }

    public boolean X() {
        return (T() || this.g.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void Y(float f) {
        setShapeAppearanceModel(this.a.a.w(f));
    }

    public void Z(l40 l40Var) {
        setShapeAppearanceModel(this.a.a.x(l40Var));
    }

    public void a0(float f) {
        c cVar = this.a;
        if (cVar.o != f) {
            cVar.o = f;
            p0();
        }
    }

    public void b0(ColorStateList colorStateList) {
        c cVar = this.a;
        if (cVar.d != colorStateList) {
            cVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void c0(float f) {
        c cVar = this.a;
        if (cVar.k != f) {
            cVar.k = f;
            this.e = true;
            invalidateSelf();
        }
    }

    public void d0(int i, int i2, int i3, int i4) {
        c cVar = this.a;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.a.i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.n.setColorFilter(this.s);
        int alpha = this.n.getAlpha();
        this.n.setAlpha(V(alpha, this.a.m));
        this.o.setColorFilter(this.t);
        this.o.setStrokeWidth(this.a.l);
        int alpha2 = this.o.getAlpha();
        this.o.setAlpha(V(alpha2, this.a.m));
        if (this.e) {
            i();
            g(u(), this.g);
            this.e = false;
        }
        U(canvas);
        if (O()) {
            o(canvas);
        }
        if (P()) {
            r(canvas);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    public void e0(Paint.Style style) {
        this.a.v = style;
        R();
    }

    public void f0(float f) {
        c cVar = this.a;
        if (cVar.n != f) {
            cVar.n = f;
            p0();
        }
    }

    public void g0(boolean z) {
        this.w = z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.a.m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.a.f389q == 2) {
            return;
        }
        if (T()) {
            outline.setRoundRect(getBounds(), J() * this.a.k);
        } else {
            g(u(), this.g);
            qd0.l(outline, this.g);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.a.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.k.set(getBounds());
        g(u(), this.g);
        this.l.setPath(this.g, this.k);
        this.k.op(this.l, Region.Op.DIFFERENCE);
        return this.k;
    }

    protected final void h(RectF rectF, Path path) {
        tn2 tn2Var = this.r;
        c cVar = this.a;
        tn2Var.d(cVar.a, cVar.k, rectF, this.f388q, path);
    }

    public void h0(int i) {
        this.p.d(i);
        this.a.u = false;
        R();
    }

    public void i0(int i) {
        c cVar = this.a;
        if (cVar.f389q != i) {
            cVar.f389q = i;
            R();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.a.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.a.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.a.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.a.d) != null && colorStateList4.isStateful())));
    }

    public void j0(float f, int i) {
        m0(f);
        l0(ColorStateList.valueOf(i));
    }

    public void k0(float f, ColorStateList colorStateList) {
        m0(f);
        l0(colorStateList);
    }

    protected int l(int i) {
        float fM = M() + z();
        hf0 hf0Var = this.a.b;
        return hf0Var != null ? hf0Var.c(i, fM) : i;
    }

    public void l0(ColorStateList colorStateList) {
        c cVar = this.a;
        if (cVar.e != colorStateList) {
            cVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public void m0(float f) {
        this.a.l = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.a = new c(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, a23.b
    protected boolean onStateChange(int[] iArr) {
        boolean z = n0(iArr) || o0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    protected void q(Canvas canvas, Paint paint, Path path, RectF rectF) {
        p(canvas, paint, path, this.a.a, rectF);
    }

    protected void r(Canvas canvas) {
        p(canvas, this.o, this.h, this.m, v());
    }

    public float s() {
        return this.a.a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        c cVar = this.a;
        if (cVar.m != i) {
            cVar.m = i;
            R();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.c = colorFilter;
        R();
    }

    @Override // defpackage.ho2
    public void setShapeAppearanceModel(sn2 sn2Var) {
        this.a.a = sn2Var;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.a.g = colorStateList;
        o0();
        R();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.a;
        if (cVar.h != mode) {
            cVar.h = mode;
            o0();
            R();
        }
    }

    public float t() {
        return this.a.a.l().a(u());
    }

    protected RectF u() {
        this.i.set(getBounds());
        return this.i;
    }

    public float w() {
        return this.a.o;
    }

    public ColorStateList x() {
        return this.a.d;
    }

    public float y() {
        return this.a.k;
    }

    public float z() {
        return this.a.n;
    }

    public tg1(Context context, AttributeSet attributeSet, int i, int i2) {
        this(sn2.e(context, attributeSet, i, i2).m());
    }

    public tg1(sn2 sn2Var) {
        this(new c(sn2Var, null));
    }

    protected tg1(c cVar) {
        tn2 tn2Var;
        this.b = new co2.g[4];
        this.c = new co2.g[4];
        this.d = new BitSet(8);
        this.f = new Matrix();
        this.g = new Path();
        this.h = new Path();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Region();
        this.l = new Region();
        Paint paint = new Paint(1);
        this.n = paint;
        Paint paint2 = new Paint(1);
        this.o = paint2;
        this.p = new qn2();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            tn2Var = tn2.k();
        } else {
            tn2Var = new tn2();
        }
        this.r = tn2Var;
        this.v = new RectF();
        this.w = true;
        this.a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        o0();
        n0(getState());
        this.f388q = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static class c extends Drawable.ConstantState {
        sn2 a;
        hf0 b;
        ColorFilter c;
        ColorStateList d;
        ColorStateList e;
        ColorStateList f;
        ColorStateList g;
        PorterDuff.Mode h;
        Rect i;
        float j;
        float k;
        float l;
        int m;
        float n;
        float o;
        float p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f389q;
        int r;
        int s;
        int t;
        boolean u;
        Paint.Style v;

        public c(sn2 sn2Var, hf0 hf0Var) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.f389q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = sn2Var;
            this.b = hf0Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            tg1 tg1Var = new tg1(this);
            tg1Var.e = true;
            return tg1Var;
        }

        public c(c cVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.f389q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.b = cVar.b;
            this.l = cVar.l;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.h = cVar.h;
            this.g = cVar.g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.f389q = cVar.f389q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f = cVar.f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }
    }
}
