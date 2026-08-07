package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import defpackage.b52;
import defpackage.be3;
import defpackage.eh1;
import defpackage.hv;
import defpackage.iv0;
import defpackage.og1;
import defpackage.s73;
import defpackage.t13;
import defpackage.ut2;
import defpackage.y6;
import defpackage.z13;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final boolean t0 = false;
    private static final Paint u0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private hv D;
    private hv E;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean K;
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    private final TextPaint V;
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;
    private final View a;
    private float a0;
    private float b;
    private float b0;
    private boolean c;
    private ColorStateList c0;
    private float d;
    private float d0;
    private float e;
    private float e0;
    private int f;
    private float f0;
    private final Rect g;
    private ColorStateList g0;
    private final Rect h;
    private float h0;
    private final RectF i;
    private float i0;
    private float j0;
    private StaticLayout k0;
    private float l0;
    private float m0;
    private ColorStateList n;
    private float n0;
    private ColorStateList o;
    private CharSequence o0;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f262q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private Typeface w;
    private Typeface x;
    private Typeface y;
    private Typeface z;
    private int j = 16;
    private int k = 16;
    private float l = 15.0f;
    private float m = 15.0f;
    private TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    private boolean J = true;
    private int p0 = 1;
    private float q0 = 0.0f;
    private float r0 = 1.0f;
    private int s0 = StaticLayoutBuilderCompat.n;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    class C0090a implements hv.a {
        C0090a() {
        }

        @Override // hv.a
        public void a(Typeface typeface) {
            a.this.l0(typeface);
        }
    }

    class b implements hv.a {
        b() {
        }

        @Override // hv.a
        public void a(Typeface typeface) {
            a.this.w0(typeface);
        }
    }

    public a(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(Opcodes.LOR);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.h = new Rect();
        this.g = new Rect();
        this.i = new RectF();
        this.e = e();
        Y(view.getContext().getResources().getConfiguration());
    }

    private void C0(float f) {
        h(f);
        boolean z = t0 && this.N != 1.0f;
        this.K = z;
        if (z) {
            n();
        }
        be3.g0(this.a);
    }

    private Layout.Alignment M() {
        int iB = iv0.b(this.j, this.I ? 1 : 0) & 7;
        if (iB == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (iB != 5) {
            return this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
    }

    private boolean O0() {
        return this.p0 > 1 && (!this.I || this.c) && !this.K;
    }

    private void P(TextPaint textPaint) {
        textPaint.setTextSize(this.m);
        textPaint.setTypeface(this.w);
        textPaint.setLetterSpacing(this.h0);
    }

    private void Q(TextPaint textPaint) {
        textPaint.setTextSize(this.l);
        textPaint.setTypeface(this.z);
        textPaint.setLetterSpacing(this.i0);
    }

    private void S(float f) {
        if (this.c) {
            this.i.set(f < this.e ? this.g : this.h);
            return;
        }
        this.i.left = X(this.g.left, this.h.left, f, this.X);
        this.i.top = X(this.f262q, this.r, f, this.X);
        this.i.right = X(this.g.right, this.h.right, f, this.X);
        this.i.bottom = X(this.g.bottom, this.h.bottom, f, this.X);
    }

    private static boolean T(float f, float f2) {
        return Math.abs(f - f2) < 1.0E-5f;
    }

    private boolean U() {
        return be3.A(this.a) == 1;
    }

    private boolean W(CharSequence charSequence, boolean z) {
        return (z ? z13.d : z13.c).a(charSequence, 0, charSequence.length());
    }

    private static float X(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return y6.a(f, f2, f3);
    }

    private float Z(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), Math.round((Color.red(i) * f2) + (Color.red(i2) * f)), Math.round((Color.green(i) * f2) + (Color.green(i2) * f)), Math.round((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    private void b(boolean z) {
        StaticLayout staticLayout;
        i(1.0f, z);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.k0) != null) {
            this.o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.o0;
        float fZ = 0.0f;
        if (charSequence2 != null) {
            this.l0 = Z(this.V, charSequence2);
        } else {
            this.l0 = 0.0f;
        }
        int iB = iv0.b(this.k, this.I ? 1 : 0);
        int i = iB & 112;
        if (i == 48) {
            this.r = this.h.top;
        } else if (i != 80) {
            this.r = this.h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.r = this.h.bottom + this.V.ascent();
        }
        int i2 = iB & 8388615;
        if (i2 == 1) {
            this.t = this.h.centerX() - (this.l0 / 2.0f);
        } else if (i2 != 5) {
            this.t = this.h.left;
        } else {
            this.t = this.h.right - this.l0;
        }
        i(0.0f, z);
        StaticLayout staticLayout2 = this.k0;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.k0;
        if (staticLayout3 == null || this.p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                fZ = Z(this.V, charSequence3);
            }
        } else {
            fZ = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.k0;
        this.p = staticLayout4 != null ? staticLayout4.getLineCount() : 0;
        int iB2 = iv0.b(this.j, this.I ? 1 : 0);
        int i3 = iB2 & 112;
        if (i3 == 48) {
            this.f262q = this.g.top;
        } else if (i3 != 80) {
            this.f262q = this.g.centerY() - (height / 2.0f);
        } else {
            this.f262q = (this.g.bottom - height) + this.V.descent();
        }
        int i4 = iB2 & 8388615;
        if (i4 == 1) {
            this.s = this.g.centerX() - (fZ / 2.0f);
        } else if (i4 != 5) {
            this.s = this.g.left;
        } else {
            this.s = this.g.right - fZ;
        }
        j();
        C0(this.b);
    }

    private void c() {
        g(this.b);
    }

    private static boolean c0(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private float d(float f) {
        float f2 = this.e;
        return f <= f2 ? y6.b(1.0f, 0.0f, this.d, f2, f) : y6.b(0.0f, 1.0f, f2, 1.0f, f);
    }

    private float e() {
        float f = this.d;
        return f + ((1.0f - f) * 0.5f);
    }

    private boolean f(CharSequence charSequence) {
        boolean zU = U();
        return this.J ? W(charSequence, zU) : zU;
    }

    private void g(float f) {
        float f2;
        S(f);
        if (!this.c) {
            this.u = X(this.s, this.t, f, this.X);
            this.v = X(this.f262q, this.r, f, this.X);
            C0(f);
            f2 = f;
        } else if (f < this.e) {
            this.u = this.s;
            this.v = this.f262q;
            C0(0.0f);
            f2 = 0.0f;
        } else {
            this.u = this.t;
            this.v = this.r - Math.max(0, this.f);
            C0(1.0f);
            f2 = 1.0f;
        }
        TimeInterpolator timeInterpolator = y6.b;
        h0(1.0f - X(0.0f, 1.0f, 1.0f - f, timeInterpolator));
        s0(X(1.0f, 0.0f, f, timeInterpolator));
        if (this.o != this.n) {
            this.V.setColor(a(y(), w(), f2));
        } else {
            this.V.setColor(w());
        }
        int i = Build.VERSION.SDK_INT;
        float f3 = this.h0;
        float f4 = this.i0;
        if (f3 != f4) {
            this.V.setLetterSpacing(X(f4, f3, f, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f3);
        }
        this.P = X(this.d0, this.Z, f, null);
        this.Q = X(this.e0, this.a0, f, null);
        this.R = X(this.f0, this.b0, f, null);
        int iA = a(x(this.g0), x(this.c0), f);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.c) {
            this.V.setAlpha((int) (d(f) * this.V.getAlpha()));
            if (i >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, og1.a(this.S, textPaint.getAlpha()));
            }
        }
        be3.g0(this.a);
    }

    private void h(float f) {
        i(f, false);
    }

    private void h0(float f) {
        this.m0 = f;
        be3.g0(this.a);
    }

    private void i(float f, boolean z) {
        float f2;
        float f3;
        Typeface typeface;
        if (this.G == null) {
            return;
        }
        float fWidth = this.h.width();
        float fWidth2 = this.g.width();
        if (T(f, 1.0f)) {
            f2 = this.m;
            f3 = this.h0;
            this.N = 1.0f;
            typeface = this.w;
        } else {
            float f4 = this.l;
            float f5 = this.i0;
            Typeface typeface2 = this.z;
            if (T(f, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = X(this.l, this.m, f, this.Y) / this.l;
            }
            float f6 = this.m / this.l;
            fWidth = (z || this.c || fWidth2 * f6 <= fWidth) ? fWidth2 : Math.min(fWidth / f6, fWidth2);
            f2 = f4;
            f3 = f5;
            typeface = typeface2;
        }
        boolean z2 = false;
        if (fWidth > 0.0f) {
            boolean z3 = this.O != f2;
            boolean z4 = this.j0 != f3;
            boolean z5 = this.C != typeface;
            StaticLayout staticLayout = this.k0;
            boolean z6 = z3 || z4 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z5 || this.U;
            this.O = f2;
            this.j0 = f3;
            this.C = typeface;
            this.U = false;
            this.V.setLinearText(this.N != 1.0f);
            z2 = z6;
        }
        if (this.H == null || z2) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.j0);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(O0() ? this.p0 : 1, fWidth, this.I);
            this.k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i, float f, boolean z) {
        StaticLayout staticLayoutA = null;
        try {
            staticLayoutA = StaticLayoutBuilderCompat.b(this.G, this.V, (int) f).d(this.F).g(z).c(i == 1 ? Layout.Alignment.ALIGN_NORMAL : M()).f(false).i(i).h(this.q0, this.r0).e(this.s0).j(null).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
            Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
        }
        return (StaticLayout) b52.g(staticLayoutA);
    }

    private void m(Canvas canvas, float f, float f2) {
        int alpha = this.V.getAlpha();
        canvas.translate(f, f2);
        if (!this.c) {
            this.V.setAlpha((int) (this.n0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, og1.a(this.S, textPaint.getAlpha()));
            }
            this.k0.draw(canvas);
        }
        if (!this.c) {
            this.V.setAlpha((int) (this.m0 * alpha));
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, og1.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.k0.getLineBaseline(0);
        CharSequence charSequence = this.o0;
        float f3 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f3, this.V);
        if (i >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.c) {
            return;
        }
        String strTrim = this.o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.k0.getLineEnd(0), str.length()), 0.0f, f3, (Paint) this.V);
    }

    private boolean m0(Typeface typeface) {
        hv hvVar = this.E;
        if (hvVar != null) {
            hvVar.c();
        }
        if (this.y == typeface) {
            return false;
        }
        this.y = typeface;
        Typeface typefaceB = s73.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.y;
        }
        this.w = typefaceB;
        return true;
    }

    private void n() {
        if (this.L != null || this.g.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.k0.getWidth();
        int height = this.k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    private float s(int i, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (i / 2.0f) - (this.l0 / 2.0f);
        }
        if ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) {
            return this.I ? this.h.left : this.h.right - this.l0;
        }
        return this.I ? this.h.right - this.l0 : this.h.left;
    }

    private void s0(float f) {
        this.n0 = f;
        be3.g0(this.a);
    }

    private float t(RectF rectF, int i, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (i / 2.0f) + (this.l0 / 2.0f);
        }
        if ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) {
            return this.I ? rectF.left + this.l0 : this.h.right;
        }
        return this.I ? this.h.right : rectF.left + this.l0;
    }

    private int x(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private boolean x0(Typeface typeface) {
        hv hvVar = this.D;
        if (hvVar != null) {
            hvVar.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceB = s73.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.B;
        }
        this.z = typefaceB;
        return true;
    }

    private int y() {
        return x(this.n);
    }

    public float A() {
        Q(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void A0(float f) {
        this.d = f;
        this.e = e();
    }

    public int B() {
        return this.j;
    }

    public void B0(int i) {
        this.s0 = i;
    }

    public float C() {
        Q(this.W);
        return -this.W.ascent();
    }

    public float D() {
        return this.l;
    }

    public void D0(float f) {
        this.q0 = f;
    }

    public Typeface E() {
        Typeface typeface = this.z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void E0(float f) {
        this.r0 = f;
    }

    public float F() {
        return this.b;
    }

    public void F0(int i) {
        if (i != this.p0) {
            this.p0 = i;
            j();
            a0();
        }
    }

    public float G() {
        return this.e;
    }

    public void G0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        a0();
    }

    public int H() {
        return this.s0;
    }

    public void H0(boolean z) {
        this.J = z;
    }

    public int I() {
        StaticLayout staticLayout = this.k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public final boolean I0(int[] iArr) {
        this.T = iArr;
        if (!V()) {
            return false;
        }
        a0();
        return true;
    }

    public float J() {
        return this.k0.getSpacingAdd();
    }

    public void J0(ut2 ut2Var) {
        if (ut2Var != null) {
            b0(true);
        }
    }

    public float K() {
        return this.k0.getSpacingMultiplier();
    }

    public void K0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            a0();
        }
    }

    public int L() {
        return this.p0;
    }

    public void L0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        a0();
    }

    public void M0(TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        a0();
    }

    public TimeInterpolator N() {
        return this.X;
    }

    public void N0(Typeface typeface) {
        boolean zM0 = m0(typeface);
        boolean zX0 = x0(typeface);
        if (zM0 || zX0) {
            a0();
        }
    }

    public CharSequence O() {
        return this.G;
    }

    public TextUtils.TruncateAt R() {
        return this.F;
    }

    public final boolean V() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.n) != null && colorStateList.isStateful());
    }

    public void Y(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.y;
            if (typeface != null) {
                this.x = s73.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = s73.b(configuration, typeface2);
            }
            Typeface typeface3 = this.x;
            if (typeface3 == null) {
                typeface3 = this.y;
            }
            this.w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.z = typeface4;
            b0(true);
        }
    }

    public void a0() {
        b0(false);
    }

    public void b0(boolean z) {
        if ((this.a.getHeight() <= 0 || this.a.getWidth() <= 0) && !z) {
            return;
        }
        b(z);
        c();
    }

    public void d0(ColorStateList colorStateList) {
        if (this.o == colorStateList && this.n == colorStateList) {
            return;
        }
        this.o = colorStateList;
        this.n = colorStateList;
        a0();
    }

    public void e0(int i, int i2, int i3, int i4) {
        if (c0(this.h, i, i2, i3, i4)) {
            return;
        }
        this.h.set(i, i2, i3, i4);
        this.U = true;
    }

    public void f0(Rect rect) {
        e0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void g0(int i) {
        t13 t13Var = new t13(this.a.getContext(), i);
        if (t13Var.i() != null) {
            this.o = t13Var.i();
        }
        if (t13Var.j() != 0.0f) {
            this.m = t13Var.j();
        }
        ColorStateList colorStateList = t13Var.c;
        if (colorStateList != null) {
            this.c0 = colorStateList;
        }
        this.a0 = t13Var.h;
        this.b0 = t13Var.i;
        this.Z = t13Var.j;
        this.h0 = t13Var.l;
        hv hvVar = this.E;
        if (hvVar != null) {
            hvVar.c();
        }
        this.E = new hv(new C0090a(), t13Var.e());
        t13Var.g(this.a.getContext(), this.E);
        a0();
    }

    public void i0(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            a0();
        }
    }

    public void j0(int i) {
        if (this.k != i) {
            this.k = i;
            a0();
        }
    }

    public void k0(float f) {
        if (this.m != f) {
            this.m = f;
            a0();
        }
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || this.i.width() <= 0.0f || this.i.height() <= 0.0f) {
            return;
        }
        this.V.setTextSize(this.O);
        float f = this.u;
        float f2 = this.v;
        boolean z = this.K && this.L != null;
        float f3 = this.N;
        if (f3 != 1.0f && !this.c) {
            canvas.scale(f3, f3, f, f2);
        }
        if (z) {
            canvas.drawBitmap(this.L, f, f2, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!O0() || (this.c && this.b <= this.e)) {
            canvas.translate(f, f2);
            this.k0.draw(canvas);
        } else {
            m(canvas, this.u - this.k0.getLineStart(0), f2);
        }
        canvas.restoreToCount(iSave);
    }

    public void l0(Typeface typeface) {
        if (m0(typeface)) {
            a0();
        }
    }

    public void n0(int i) {
        this.f = i;
    }

    public void o(RectF rectF, int i, int i2) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i, i2), this.h.left);
        rectF.top = this.h.top;
        rectF.right = Math.min(t(rectF, i, i2), this.h.right);
        rectF.bottom = this.h.top + r();
    }

    public void o0(int i, int i2, int i3, int i4) {
        if (c0(this.g, i, i2, i3, i4)) {
            return;
        }
        this.g.set(i, i2, i3, i4);
        this.U = true;
    }

    public ColorStateList p() {
        return this.o;
    }

    public void p0(Rect rect) {
        o0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public int q() {
        return this.k;
    }

    public void q0(float f) {
        if (this.i0 != f) {
            this.i0 = f;
            a0();
        }
    }

    public float r() {
        P(this.W);
        return -this.W.ascent();
    }

    public void r0(int i) {
        t13 t13Var = new t13(this.a.getContext(), i);
        if (t13Var.i() != null) {
            this.n = t13Var.i();
        }
        if (t13Var.j() != 0.0f) {
            this.l = t13Var.j();
        }
        ColorStateList colorStateList = t13Var.c;
        if (colorStateList != null) {
            this.g0 = colorStateList;
        }
        this.e0 = t13Var.h;
        this.f0 = t13Var.i;
        this.d0 = t13Var.j;
        this.i0 = t13Var.l;
        hv hvVar = this.D;
        if (hvVar != null) {
            hvVar.c();
        }
        this.D = new hv(new b(), t13Var.e());
        t13Var.g(this.a.getContext(), this.D);
        a0();
    }

    public void t0(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            a0();
        }
    }

    public float u() {
        return this.m;
    }

    public void u0(int i) {
        if (this.j != i) {
            this.j = i;
            a0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void v0(float f) {
        if (this.l != f) {
            this.l = f;
            a0();
        }
    }

    public int w() {
        return x(this.o);
    }

    public void w0(Typeface typeface) {
        if (x0(typeface)) {
            a0();
        }
    }

    public void y0(float f) {
        float fA = eh1.a(f, 0.0f, 1.0f);
        if (fA != this.b) {
            this.b = fA;
            c();
        }
    }

    public int z() {
        return this.p;
    }

    public void z0(boolean z) {
        this.c = z;
    }
}
