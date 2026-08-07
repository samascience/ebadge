package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.R$styleable;
import com.tencent.connect.common.Constants;
import defpackage.a23;
import defpackage.cl1;
import defpackage.dd0;
import defpackage.nf3;
import defpackage.nv;
import defpackage.o23;
import defpackage.og1;
import defpackage.pz;
import defpackage.qd0;
import defpackage.qh;
import defpackage.sg1;
import defpackage.t13;
import defpackage.tg1;
import defpackage.v8;
import defpackage.zh2;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class a extends tg1 implements Drawable.Callback, a23.b {
    private static final int[] O0 = {R.attr.state_enabled};
    private static final ShapeDrawable P0 = new ShapeDrawable(new OvalShape());
    private int A0;
    private int B0;
    private ColorFilter C0;
    private PorterDuffColorFilter D0;
    private ColorStateList E0;
    private ColorStateList F;
    private PorterDuff.Mode F0;
    private float G;
    private int[] G0;
    private float H;
    private boolean H0;
    private ColorStateList I;
    private ColorStateList I0;
    private float J;
    private WeakReference J0;
    private ColorStateList K;
    private TextUtils.TruncateAt K0;
    private CharSequence L;
    private boolean L0;
    private boolean M;
    private int M0;
    private Drawable N;
    private boolean N0;
    private ColorStateList O;
    private float P;
    private boolean Q;
    private boolean R;
    private Drawable S;
    private Drawable T;
    private ColorStateList U;
    private float V;
    private CharSequence W;
    private boolean X;
    private boolean Y;
    private Drawable Z;
    private ColorStateList a0;
    private cl1 b0;
    private cl1 c0;
    private float d0;
    private float e0;
    private float f0;
    private float g0;
    private float h0;
    private float i0;
    private float j0;
    private float k0;
    private final Context l0;
    private final Paint m0;
    private final Paint n0;
    private final Paint.FontMetrics o0;
    private final RectF p0;
    private final PointF q0;
    private final Path r0;
    private final a23 s0;
    private int t0;
    private int u0;
    private int v0;
    private int w0;
    private int x0;
    private int y0;
    private ColorStateList z;
    private boolean z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0086a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.H = -1.0f;
        this.m0 = new Paint(1);
        this.o0 = new Paint.FontMetrics();
        this.p0 = new RectF();
        this.q0 = new PointF();
        this.r0 = new Path();
        this.B0 = 255;
        this.F0 = PorterDuff.Mode.SRC_IN;
        this.J0 = new WeakReference(null);
        Q(context);
        this.l0 = context;
        a23 a23Var = new a23(this);
        this.s0 = a23Var;
        this.L = Constants.STR_EMPTY;
        a23Var.g().density = context.getResources().getDisplayMetrics().density;
        this.n0 = null;
        int[] iArr = O0;
        setState(iArr);
        r2(iArr);
        this.L0 = true;
        if (zh2.a) {
            P0.setTint(-1);
        }
    }

    private boolean A0() {
        return this.Y && this.Z != null && this.X;
    }

    private void A1(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayI = o23.i(this.l0, attributeSet, R$styleable.Chip, i, i2, new int[0]);
        this.N0 = typedArrayI.hasValue(R$styleable.Chip_shapeAppearance);
        h2(sg1.a(this.l0, typedArrayI, R$styleable.Chip_chipSurfaceColor));
        L1(sg1.a(this.l0, typedArrayI, R$styleable.Chip_chipBackgroundColor));
        Z1(typedArrayI.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        int i3 = R$styleable.Chip_chipCornerRadius;
        if (typedArrayI.hasValue(i3)) {
            N1(typedArrayI.getDimension(i3, 0.0f));
        }
        d2(sg1.a(this.l0, typedArrayI, R$styleable.Chip_chipStrokeColor));
        f2(typedArrayI.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        E2(sg1.a(this.l0, typedArrayI, R$styleable.Chip_rippleColor));
        J2(typedArrayI.getText(R$styleable.Chip_android_text));
        t13 t13VarH = sg1.h(this.l0, typedArrayI, R$styleable.Chip_android_textAppearance);
        t13VarH.l(typedArrayI.getDimension(R$styleable.Chip_android_textSize, t13VarH.j()));
        K2(t13VarH);
        int i4 = typedArrayI.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            w2(TextUtils.TruncateAt.START);
        } else if (i4 == 2) {
            w2(TextUtils.TruncateAt.MIDDLE);
        } else if (i4 == 3) {
            w2(TextUtils.TruncateAt.END);
        }
        Y1(typedArrayI.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            Y1(typedArrayI.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        R1(sg1.e(this.l0, typedArrayI, R$styleable.Chip_chipIcon));
        int i5 = R$styleable.Chip_chipIconTint;
        if (typedArrayI.hasValue(i5)) {
            V1(sg1.a(this.l0, typedArrayI, i5));
        }
        T1(typedArrayI.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        u2(typedArrayI.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            u2(typedArrayI.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        i2(sg1.e(this.l0, typedArrayI, R$styleable.Chip_closeIcon));
        s2(sg1.a(this.l0, typedArrayI, R$styleable.Chip_closeIconTint));
        n2(typedArrayI.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        D1(typedArrayI.getBoolean(R$styleable.Chip_android_checkable, false));
        K1(typedArrayI.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            K1(typedArrayI.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        F1(sg1.e(this.l0, typedArrayI, R$styleable.Chip_checkedIcon));
        int i6 = R$styleable.Chip_checkedIconTint;
        if (typedArrayI.hasValue(i6)) {
            H1(sg1.a(this.l0, typedArrayI, i6));
        }
        H2(cl1.c(this.l0, typedArrayI, R$styleable.Chip_showMotionSpec));
        x2(cl1.c(this.l0, typedArrayI, R$styleable.Chip_hideMotionSpec));
        b2(typedArrayI.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        B2(typedArrayI.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        z2(typedArrayI.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        P2(typedArrayI.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        M2(typedArrayI.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        p2(typedArrayI.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        k2(typedArrayI.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        P1(typedArrayI.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        D2(typedArrayI.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayI.recycle();
    }

    public static a B0(Context context, AttributeSet attributeSet, int i, int i2) {
        a aVar = new a(context, attributeSet, i, i2);
        aVar.A1(attributeSet, i, i2);
        return aVar;
    }

    private void C0(Canvas canvas, Rect rect) {
        if (T2()) {
            r0(rect, this.p0);
            RectF rectF = this.p0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.Z.setBounds(0, 0, (int) this.p0.width(), (int) this.p0.height());
            this.Z.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private boolean C1(int[] iArr, int[] iArr2) {
        boolean z;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.z;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.t0) : 0);
        boolean state = true;
        if (this.t0 != iL) {
            this.t0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.F;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.u0) : 0);
        if (this.u0 != iL2) {
            this.u0 = iL2;
            zOnStateChange = true;
        }
        int i = og1.i(iL, iL2);
        if ((this.v0 != i) | (x() == null)) {
            this.v0 = i;
            b0(ColorStateList.valueOf(i));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.I;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.w0) : 0;
        if (this.w0 != colorForState) {
            this.w0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.I0 == null || !zh2.e(iArr)) ? 0 : this.I0.getColorForState(iArr, this.x0);
        if (this.x0 != colorForState2) {
            this.x0 = colorForState2;
            if (this.H0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.s0.e() == null || this.s0.e().i() == null) ? 0 : this.s0.e().i().getColorForState(iArr, this.y0);
        if (this.y0 != colorForState3) {
            this.y0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z2 = t1(getState(), R.attr.state_checked) && this.X;
        if (this.z0 == z2 || this.Z == null) {
            z = false;
        } else {
            float fS0 = s0();
            this.z0 = z2;
            if (fS0 != s0()) {
                zOnStateChange = true;
                z = true;
            } else {
                z = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.E0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.A0) : 0;
        if (this.A0 != colorForState4) {
            this.A0 = colorForState4;
            this.D0 = qd0.o(this, this.E0, this.F0);
        } else {
            state = zOnStateChange;
        }
        if (z1(this.N)) {
            state |= this.N.setState(iArr);
        }
        if (z1(this.Z)) {
            state |= this.Z.setState(iArr);
        }
        if (z1(this.S)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.S.setState(iArr3);
        }
        if (zh2.a && z1(this.T)) {
            state |= this.T.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z) {
            B1();
        }
        return state;
    }

    private void D0(Canvas canvas, Rect rect) {
        if (this.N0) {
            return;
        }
        this.m0.setColor(this.u0);
        this.m0.setStyle(Paint.Style.FILL);
        this.m0.setColorFilter(r1());
        this.p0.set(rect);
        canvas.drawRoundRect(this.p0, O0(), O0(), this.m0);
    }

    private void E0(Canvas canvas, Rect rect) {
        if (U2()) {
            r0(rect, this.p0);
            RectF rectF = this.p0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.N.setBounds(0, 0, (int) this.p0.width(), (int) this.p0.height());
            this.N.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void F0(Canvas canvas, Rect rect) {
        if (this.J <= 0.0f || this.N0) {
            return;
        }
        this.m0.setColor(this.w0);
        this.m0.setStyle(Paint.Style.STROKE);
        if (!this.N0) {
            this.m0.setColorFilter(r1());
        }
        RectF rectF = this.p0;
        float f = rect.left;
        float f2 = this.J;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.H - (this.J / 2.0f);
        canvas.drawRoundRect(this.p0, f3, f3, this.m0);
    }

    private void G0(Canvas canvas, Rect rect) {
        if (this.N0) {
            return;
        }
        this.m0.setColor(this.t0);
        this.m0.setStyle(Paint.Style.FILL);
        this.p0.set(rect);
        canvas.drawRoundRect(this.p0, O0(), O0(), this.m0);
    }

    private void H0(Canvas canvas, Rect rect) {
        if (V2()) {
            u0(rect, this.p0);
            RectF rectF = this.p0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.S.setBounds(0, 0, (int) this.p0.width(), (int) this.p0.height());
            if (zh2.a) {
                this.T.setBounds(this.S.getBounds());
                this.T.jumpToCurrentState();
                this.T.draw(canvas);
            } else {
                this.S.draw(canvas);
            }
            canvas.translate(-f, -f2);
        }
    }

    private void I0(Canvas canvas, Rect rect) {
        this.m0.setColor(this.x0);
        this.m0.setStyle(Paint.Style.FILL);
        this.p0.set(rect);
        if (!this.N0) {
            canvas.drawRoundRect(this.p0, O0(), O0(), this.m0);
        } else {
            h(new RectF(rect), this.r0);
            super.q(canvas, this.m0, this.r0, u());
        }
    }

    private void J0(Canvas canvas, Rect rect) {
        Paint paint = this.n0;
        if (paint != null) {
            paint.setColor(pz.k(-16777216, 127));
            canvas.drawRect(rect, this.n0);
            if (U2() || T2()) {
                r0(rect, this.p0);
                canvas.drawRect(this.p0, this.n0);
            }
            if (this.L != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.n0);
            }
            if (V2()) {
                u0(rect, this.p0);
                canvas.drawRect(this.p0, this.n0);
            }
            this.n0.setColor(pz.k(Opcodes.V_PREVIEW, 127));
            t0(rect, this.p0);
            canvas.drawRect(this.p0, this.n0);
            this.n0.setColor(pz.k(-16711936, 127));
            v0(rect, this.p0);
            canvas.drawRect(this.p0, this.n0);
        }
    }

    private void K0(Canvas canvas, Rect rect) {
        if (this.L != null) {
            Paint.Align alignZ0 = z0(rect, this.q0);
            x0(rect, this.p0);
            if (this.s0.e() != null) {
                this.s0.g().drawableState = getState();
                this.s0.n(this.l0);
            }
            this.s0.g().setTextAlign(alignZ0);
            int iSave = 0;
            boolean z = Math.round(this.s0.h(n1().toString())) > Math.round(this.p0.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.p0);
            }
            CharSequence charSequenceEllipsize = this.L;
            if (z && this.K0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.s0.g(), this.p0.width(), this.K0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.q0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.s0.g());
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean T2() {
        return this.Y && this.Z != null && this.z0;
    }

    private boolean U2() {
        return this.M && this.N != null;
    }

    private boolean V2() {
        return this.R && this.S != null;
    }

    private void W2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void X2() {
        this.I0 = this.H0 ? zh2.d(this.K) : null;
    }

    private void Y2() {
        this.T = new RippleDrawable(zh2.d(l1()), this.S, P0);
    }

    private float f1() {
        Drawable drawable = this.z0 ? this.Z : this.N;
        float fCeil = this.P;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(nf3.g(this.l0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    private float g1() {
        Drawable drawable = this.z0 ? this.Z : this.N;
        float f = this.P;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    private void h2(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            onStateChange(getState());
        }
    }

    private void q0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        dd0.m(drawable, dd0.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.S) {
            if (drawable.isStateful()) {
                drawable.setState(c1());
            }
            dd0.o(drawable, this.U);
            return;
        }
        Drawable drawable2 = this.N;
        if (drawable == drawable2 && this.Q) {
            dd0.o(drawable2, this.O);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void r0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (U2() || T2()) {
            float f = this.d0 + this.e0;
            float fG1 = g1();
            if (dd0.f(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + fG1;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - fG1;
            }
            float fF1 = f1();
            float fExactCenterY = rect.exactCenterY() - (fF1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fF1;
        }
    }

    private ColorFilter r1() {
        ColorFilter colorFilter = this.C0;
        return colorFilter != null ? colorFilter : this.D0;
    }

    private void t0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (V2()) {
            float f = this.k0 + this.j0 + this.V + this.i0 + this.h0;
            if (dd0.f(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    private static boolean t1(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void u0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V2()) {
            float f = this.k0 + this.j0;
            if (dd0.f(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.V;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.V;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.V;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    private void v0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V2()) {
            float f = this.k0 + this.j0 + this.V + this.i0 + this.h0;
            if (dd0.f(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void x0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.L != null) {
            float fS0 = this.d0 + s0() + this.g0;
            float fW0 = this.k0 + w0() + this.h0;
            if (dd0.f(this) == 0) {
                rectF.left = rect.left + fS0;
                rectF.right = rect.right - fW0;
            } else {
                rectF.left = rect.left + fW0;
                rectF.right = rect.right - fS0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean x1(t13 t13Var) {
        return (t13Var == null || t13Var.i() == null || !t13Var.i().isStateful()) ? false : true;
    }

    private float y0() {
        this.s0.g().getFontMetrics(this.o0);
        Paint.FontMetrics fontMetrics = this.o0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean y1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean z1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public void A2(int i) {
        z2(this.l0.getResources().getDimension(i));
    }

    protected void B1() {
        InterfaceC0086a interfaceC0086a = (InterfaceC0086a) this.J0.get();
        if (interfaceC0086a != null) {
            interfaceC0086a.a();
        }
    }

    public void B2(float f) {
        if (this.e0 != f) {
            float fS0 = s0();
            this.e0 = f;
            float fS1 = s0();
            invalidateSelf();
            if (fS0 != fS1) {
                B1();
            }
        }
    }

    public void C2(int i) {
        B2(this.l0.getResources().getDimension(i));
    }

    public void D1(boolean z) {
        if (this.X != z) {
            this.X = z;
            float fS0 = s0();
            if (!z && this.z0) {
                this.z0 = false;
            }
            float fS1 = s0();
            invalidateSelf();
            if (fS0 != fS1) {
                B1();
            }
        }
    }

    public void D2(int i) {
        this.M0 = i;
    }

    public void E1(int i) {
        D1(this.l0.getResources().getBoolean(i));
    }

    public void E2(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            X2();
            onStateChange(getState());
        }
    }

    public void F1(Drawable drawable) {
        if (this.Z != drawable) {
            float fS0 = s0();
            this.Z = drawable;
            float fS1 = s0();
            W2(this.Z);
            q0(this.Z);
            invalidateSelf();
            if (fS0 != fS1) {
                B1();
            }
        }
    }

    public void F2(int i) {
        E2(v8.a(this.l0, i));
    }

    public void G1(int i) {
        F1(v8.b(this.l0, i));
    }

    void G2(boolean z) {
        this.L0 = z;
    }

    public void H1(ColorStateList colorStateList) {
        if (this.a0 != colorStateList) {
            this.a0 = colorStateList;
            if (A0()) {
                dd0.o(this.Z, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void H2(cl1 cl1Var) {
        this.b0 = cl1Var;
    }

    public void I1(int i) {
        H1(v8.a(this.l0, i));
    }

    public void I2(int i) {
        H2(cl1.d(this.l0, i));
    }

    public void J1(int i) {
        K1(this.l0.getResources().getBoolean(i));
    }

    public void J2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = Constants.STR_EMPTY;
        }
        if (TextUtils.equals(this.L, charSequence)) {
            return;
        }
        this.L = charSequence;
        this.s0.m(true);
        invalidateSelf();
        B1();
    }

    public void K1(boolean z) {
        if (this.Y != z) {
            boolean zT2 = T2();
            this.Y = z;
            boolean zT3 = T2();
            if (zT2 != zT3) {
                if (zT3) {
                    q0(this.Z);
                } else {
                    W2(this.Z);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    public void K2(t13 t13Var) {
        this.s0.k(t13Var, this.l0);
    }

    public Drawable L0() {
        return this.Z;
    }

    public void L1(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            onStateChange(getState());
        }
    }

    public void L2(int i) {
        K2(new t13(this.l0, i));
    }

    public ColorStateList M0() {
        return this.a0;
    }

    public void M1(int i) {
        L1(v8.a(this.l0, i));
    }

    public void M2(float f) {
        if (this.h0 != f) {
            this.h0 = f;
            invalidateSelf();
            B1();
        }
    }

    public ColorStateList N0() {
        return this.F;
    }

    public void N1(float f) {
        if (this.H != f) {
            this.H = f;
            setShapeAppearanceModel(E().w(f));
        }
    }

    public void N2(int i) {
        M2(this.l0.getResources().getDimension(i));
    }

    public float O0() {
        return this.N0 ? J() : this.H;
    }

    public void O1(int i) {
        N1(this.l0.getResources().getDimension(i));
    }

    public void O2(float f) {
        t13 t13VarO1 = o1();
        if (t13VarO1 != null) {
            t13VarO1.l(f);
            this.s0.g().setTextSize(f);
            a();
        }
    }

    public float P0() {
        return this.k0;
    }

    public void P1(float f) {
        if (this.k0 != f) {
            this.k0 = f;
            invalidateSelf();
            B1();
        }
    }

    public void P2(float f) {
        if (this.g0 != f) {
            this.g0 = f;
            invalidateSelf();
            B1();
        }
    }

    public Drawable Q0() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return dd0.q(drawable);
        }
        return null;
    }

    public void Q1(int i) {
        P1(this.l0.getResources().getDimension(i));
    }

    public void Q2(int i) {
        P2(this.l0.getResources().getDimension(i));
    }

    public float R0() {
        return this.P;
    }

    public void R1(Drawable drawable) {
        Drawable drawableQ0 = Q0();
        if (drawableQ0 != drawable) {
            float fS0 = s0();
            this.N = drawable != null ? dd0.r(drawable).mutate() : null;
            float fS1 = s0();
            W2(drawableQ0);
            if (U2()) {
                q0(this.N);
            }
            invalidateSelf();
            if (fS0 != fS1) {
                B1();
            }
        }
    }

    public void R2(boolean z) {
        if (this.H0 != z) {
            this.H0 = z;
            X2();
            onStateChange(getState());
        }
    }

    public ColorStateList S0() {
        return this.O;
    }

    public void S1(int i) {
        R1(v8.b(this.l0, i));
    }

    boolean S2() {
        return this.L0;
    }

    public float T0() {
        return this.G;
    }

    public void T1(float f) {
        if (this.P != f) {
            float fS0 = s0();
            this.P = f;
            float fS1 = s0();
            invalidateSelf();
            if (fS0 != fS1) {
                B1();
            }
        }
    }

    public float U0() {
        return this.d0;
    }

    public void U1(int i) {
        T1(this.l0.getResources().getDimension(i));
    }

    public ColorStateList V0() {
        return this.I;
    }

    public void V1(ColorStateList colorStateList) {
        this.Q = true;
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (U2()) {
                dd0.o(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float W0() {
        return this.J;
    }

    public void W1(int i) {
        V1(v8.a(this.l0, i));
    }

    public Drawable X0() {
        Drawable drawable = this.S;
        if (drawable != null) {
            return dd0.q(drawable);
        }
        return null;
    }

    public void X1(int i) {
        Y1(this.l0.getResources().getBoolean(i));
    }

    public CharSequence Y0() {
        return this.W;
    }

    public void Y1(boolean z) {
        if (this.M != z) {
            boolean zU2 = U2();
            this.M = z;
            boolean zU3 = U2();
            if (zU2 != zU3) {
                if (zU3) {
                    q0(this.N);
                } else {
                    W2(this.N);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    public float Z0() {
        return this.j0;
    }

    public void Z1(float f) {
        if (this.G != f) {
            this.G = f;
            invalidateSelf();
            B1();
        }
    }

    @Override // a23.b
    public void a() {
        B1();
        invalidateSelf();
    }

    public float a1() {
        return this.V;
    }

    public void a2(int i) {
        Z1(this.l0.getResources().getDimension(i));
    }

    public float b1() {
        return this.i0;
    }

    public void b2(float f) {
        if (this.d0 != f) {
            this.d0 = f;
            invalidateSelf();
            B1();
        }
    }

    public int[] c1() {
        return this.G0;
    }

    public void c2(int i) {
        b2(this.l0.getResources().getDimension(i));
    }

    public ColorStateList d1() {
        return this.U;
    }

    public void d2(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (this.N0) {
                l0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.B0;
        int iA = i < 255 ? nv.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        G0(canvas, bounds);
        D0(canvas, bounds);
        if (this.N0) {
            super.draw(canvas);
        }
        F0(canvas, bounds);
        I0(canvas, bounds);
        E0(canvas, bounds);
        C0(canvas, bounds);
        if (this.L0) {
            K0(canvas, bounds);
        }
        H0(canvas, bounds);
        J0(canvas, bounds);
        if (this.B0 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public void e1(RectF rectF) {
        v0(getBounds(), rectF);
    }

    public void e2(int i) {
        d2(v8.a(this.l0, i));
    }

    public void f2(float f) {
        if (this.J != f) {
            this.J = f;
            this.m0.setStrokeWidth(f);
            if (this.N0) {
                super.m0(f);
            }
            invalidateSelf();
        }
    }

    public void g2(int i) {
        f2(this.l0.getResources().getDimension(i));
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.B0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.C0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.G;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.d0 + s0() + this.g0 + this.s0.h(n1().toString()) + this.h0 + w0() + this.k0), this.M0);
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.N0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.H);
        } else {
            outline.setRoundRect(bounds, this.H);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public TextUtils.TruncateAt h1() {
        return this.K0;
    }

    public cl1 i1() {
        return this.c0;
    }

    public void i2(Drawable drawable) {
        Drawable drawableX0 = X0();
        if (drawableX0 != drawable) {
            float fW0 = w0();
            this.S = drawable != null ? dd0.r(drawable).mutate() : null;
            if (zh2.a) {
                Y2();
            }
            float fW1 = w0();
            W2(drawableX0);
            if (V2()) {
                q0(this.S);
            }
            invalidateSelf();
            if (fW0 != fW1) {
                B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return y1(this.z) || y1(this.F) || y1(this.I) || (this.H0 && y1(this.I0)) || x1(this.s0.e()) || A0() || z1(this.N) || z1(this.Z) || y1(this.E0);
    }

    public float j1() {
        return this.f0;
    }

    public void j2(CharSequence charSequence) {
        if (this.W != charSequence) {
            this.W = qh.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float k1() {
        return this.e0;
    }

    public void k2(float f) {
        if (this.j0 != f) {
            this.j0 = f;
            invalidateSelf();
            if (V2()) {
                B1();
            }
        }
    }

    public ColorStateList l1() {
        return this.K;
    }

    public void l2(int i) {
        k2(this.l0.getResources().getDimension(i));
    }

    public cl1 m1() {
        return this.b0;
    }

    public void m2(int i) {
        i2(v8.b(this.l0, i));
    }

    public CharSequence n1() {
        return this.L;
    }

    public void n2(float f) {
        if (this.V != f) {
            this.V = f;
            invalidateSelf();
            if (V2()) {
                B1();
            }
        }
    }

    public t13 o1() {
        return this.s0.e();
    }

    public void o2(int i) {
        n2(this.l0.getResources().getDimension(i));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (U2()) {
            zOnLayoutDirectionChanged |= dd0.m(this.N, i);
        }
        if (T2()) {
            zOnLayoutDirectionChanged |= dd0.m(this.Z, i);
        }
        if (V2()) {
            zOnLayoutDirectionChanged |= dd0.m(this.S, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (U2()) {
            zOnLevelChange |= this.N.setLevel(i);
        }
        if (T2()) {
            zOnLevelChange |= this.Z.setLevel(i);
        }
        if (V2()) {
            zOnLevelChange |= this.S.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable, a23.b
    public boolean onStateChange(int[] iArr) {
        if (this.N0) {
            super.onStateChange(iArr);
        }
        return C1(iArr, c1());
    }

    public float p1() {
        return this.h0;
    }

    public void p2(float f) {
        if (this.i0 != f) {
            this.i0 = f;
            invalidateSelf();
            if (V2()) {
                B1();
            }
        }
    }

    public float q1() {
        return this.g0;
    }

    public void q2(int i) {
        p2(this.l0.getResources().getDimension(i));
    }

    public boolean r2(int[] iArr) {
        if (Arrays.equals(this.G0, iArr)) {
            return false;
        }
        this.G0 = iArr;
        if (V2()) {
            return C1(getState(), iArr);
        }
        return false;
    }

    float s0() {
        if (U2() || T2()) {
            return this.e0 + g1() + this.f0;
        }
        return 0.0f;
    }

    public boolean s1() {
        return this.H0;
    }

    public void s2(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (V2()) {
                dd0.o(this.S, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.B0 != i) {
            this.B0 = i;
            invalidateSelf();
        }
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.C0 != colorFilter) {
            this.C0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.E0 != colorStateList) {
            this.E0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.F0 != mode) {
            this.F0 = mode;
            this.D0 = qd0.o(this, this.E0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (U2()) {
            visible |= this.N.setVisible(z, z2);
        }
        if (T2()) {
            visible |= this.Z.setVisible(z, z2);
        }
        if (V2()) {
            visible |= this.S.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t2(int i) {
        s2(v8.a(this.l0, i));
    }

    public boolean u1() {
        return this.X;
    }

    public void u2(boolean z) {
        if (this.R != z) {
            boolean zV2 = V2();
            this.R = z;
            boolean zV3 = V2();
            if (zV2 != zV3) {
                if (zV3) {
                    q0(this.S);
                } else {
                    W2(this.S);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public boolean v1() {
        return z1(this.S);
    }

    public void v2(InterfaceC0086a interfaceC0086a) {
        this.J0 = new WeakReference(interfaceC0086a);
    }

    float w0() {
        if (V2()) {
            return this.i0 + this.V + this.j0;
        }
        return 0.0f;
    }

    public boolean w1() {
        return this.R;
    }

    public void w2(TextUtils.TruncateAt truncateAt) {
        this.K0 = truncateAt;
    }

    public void x2(cl1 cl1Var) {
        this.c0 = cl1Var;
    }

    public void y2(int i) {
        x2(cl1.d(this.l0, i));
    }

    Paint.Align z0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.L != null) {
            float fS0 = this.d0 + s0() + this.g0;
            if (dd0.f(this) == 0) {
                pointF.x = rect.left + fS0;
            } else {
                pointF.x = rect.right - fS0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - y0();
        }
        return align;
    }

    public void z2(float f) {
        if (this.f0 != f) {
            float fS0 = s0();
            this.f0 = f;
            float fS1 = s0();
            invalidateSelf();
            if (fS0 != fS1) {
                B1();
            }
        }
    }
}
