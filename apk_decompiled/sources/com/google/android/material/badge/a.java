package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.tencent.connect.common.Constants;
import defpackage.a23;
import defpackage.be3;
import defpackage.o23;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.t13;
import defpackage.tg1;
import defpackage.y6;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Drawable implements a23.b {
    private static final int n = R$style.Widget_MaterialComponents_Badge;
    private static final int o = R$attr.badgeStyle;
    private final WeakReference a;
    private final tg1 b;
    private final a23 c;
    private final Rect d;
    private final BadgeState e;
    private float f;
    private float g;
    private int h;
    private float i;
    private float j;
    private float k;
    private WeakReference l;
    private WeakReference m;

    /* JADX INFO: renamed from: com.google.android.material.badge.a$a, reason: collision with other inner class name */
    class RunnableC0084a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FrameLayout b;

        RunnableC0084a(View view, FrameLayout frameLayout) {
            this.a = view;
            this.b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.Q(this.a, this.b);
        }
    }

    private a(Context context, int i, int i2, int i3, BadgeState.State state) {
        this.a = new WeakReference(context);
        o23.c(context);
        this.d = new Rect();
        a23 a23Var = new a23(this);
        this.c = a23Var;
        a23Var.g().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i, i2, i3, state);
        this.e = badgeState;
        this.b = new tg1(sn2.b(context, A() ? badgeState.m() : badgeState.i(), A() ? badgeState.l() : badgeState.h()).m());
        N();
    }

    private boolean A() {
        return C() || B();
    }

    private boolean D() {
        FrameLayout frameLayoutJ = j();
        return frameLayoutJ != null && frameLayoutJ.getId() == R$id.mtrl_anchor_parent;
    }

    private void E() {
        this.c.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void F() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.e.e());
        if (this.b.x() != colorStateListValueOf) {
            this.b.b0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    private void G() {
        this.c.l(true);
        I();
        R();
        invalidateSelf();
    }

    private void H() {
        WeakReference weakReference = this.l;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.l.get();
        WeakReference weakReference2 = this.m;
        Q(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
    }

    private void I() {
        Context context = (Context) this.a.get();
        if (context == null) {
            return;
        }
        this.b.setShapeAppearanceModel(sn2.b(context, A() ? this.e.m() : this.e.i(), A() ? this.e.l() : this.e.h()).m());
        invalidateSelf();
    }

    private void J() {
        t13 t13Var;
        Context context = (Context) this.a.get();
        if (context == null || this.c.e() == (t13Var = new t13(context, this.e.A()))) {
            return;
        }
        this.c.k(t13Var, context);
        K();
        R();
        invalidateSelf();
    }

    private void K() {
        this.c.g().setColor(this.e.j());
        invalidateSelf();
    }

    private void L() {
        S();
        this.c.l(true);
        R();
        invalidateSelf();
    }

    private void M() {
        boolean zG = this.e.G();
        setVisible(zG, false);
        if (!b.a || j() == null || zG) {
            return;
        }
        ((ViewGroup) j().getParent()).invalidate();
    }

    private void N() {
        I();
        J();
        L();
        G();
        E();
        F();
        K();
        H();
        R();
        M();
    }

    private void O(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference weakReference = this.m;
            if (weakReference == null || weakReference.get() != viewGroup) {
                P(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R$id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.m = new WeakReference(frameLayout);
                frameLayout.post(new RunnableC0084a(view, frameLayout));
            }
        }
    }

    private static void P(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void R() {
        Context context = (Context) this.a.get();
        WeakReference weakReference = this.l;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference weakReference2 = this.m;
        ViewGroup viewGroup = weakReference2 != null ? (ViewGroup) weakReference2.get() : null;
        if (viewGroup != null || b.a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        c(rect2, view);
        b.f(this.d, this.f, this.g, this.j, this.k);
        float f = this.i;
        if (f != -1.0f) {
            this.b.Y(f);
        }
        if (rect.equals(this.d)) {
            return;
        }
        this.b.setBounds(this.d);
    }

    private void S() {
        if (n() != -2) {
            this.h = ((int) Math.pow(10.0d, ((double) n()) - 1.0d)) - 1;
        } else {
            this.h = o();
        }
    }

    private void b(View view) {
        float y;
        float x;
        View viewJ = j();
        if (viewJ == null) {
            if (!(view.getParent() instanceof View)) {
                return;
            }
            float y2 = view.getY();
            x = view.getX();
            viewJ = (View) view.getParent();
            y = y2;
        } else if (!D()) {
            y = 0.0f;
            x = 0.0f;
        } else {
            if (!(viewJ.getParent() instanceof View)) {
                return;
            }
            y = viewJ.getY();
            x = viewJ.getX();
            viewJ = (View) viewJ.getParent();
        }
        float fX = x(viewJ, y);
        float fM = m(viewJ, x);
        float fH = h(viewJ, y);
        float fS = s(viewJ, x);
        if (fX < 0.0f) {
            this.g += Math.abs(fX);
        }
        if (fM < 0.0f) {
            this.f += Math.abs(fM);
        }
        if (fH > 0.0f) {
            this.g -= Math.abs(fH);
        }
        if (fS > 0.0f) {
            this.f -= Math.abs(fS);
        }
    }

    private void c(Rect rect, View view) {
        float f = A() ? this.e.d : this.e.c;
        this.i = f;
        if (f != -1.0f) {
            this.j = f;
            this.k = f;
        } else {
            this.j = Math.round((A() ? this.e.g : this.e.e) / 2.0f);
            this.k = Math.round((A() ? this.e.h : this.e.f) / 2.0f);
        }
        if (A()) {
            String strG = g();
            this.j = Math.max(this.j, (this.c.h(strG) / 2.0f) + this.e.g());
            float fMax = Math.max(this.k, (this.c.f(strG) / 2.0f) + this.e.k());
            this.k = fMax;
            this.j = Math.max(this.j, fMax);
        }
        int iZ = z();
        int iF = this.e.f();
        if (iF == 8388691 || iF == 8388693) {
            this.g = rect.bottom - iZ;
        } else {
            this.g = rect.top + iZ;
        }
        int iY = y();
        int iF2 = this.e.f();
        if (iF2 == 8388659 || iF2 == 8388691) {
            this.f = be3.A(view) == 0 ? (rect.left - this.j) + iY : (rect.right + this.j) - iY;
        } else {
            this.f = be3.A(view) == 0 ? (rect.right + this.j) - iY : (rect.left - this.j) + iY;
        }
        if (this.e.F()) {
            b(view);
        }
    }

    public static a d(Context context) {
        return new a(context, 0, o, n, null);
    }

    static a e(Context context, BadgeState.State state) {
        return new a(context, 0, o, n, state);
    }

    private void f(Canvas canvas) {
        String strG = g();
        if (strG != null) {
            Rect rect = new Rect();
            this.c.g().getTextBounds(strG, 0, strG.length(), rect);
            float fExactCenterY = this.g - rect.exactCenterY();
            canvas.drawText(strG, this.f, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), this.c.g());
        }
    }

    private String g() {
        if (C()) {
            return v();
        }
        if (B()) {
            return q();
        }
        return null;
    }

    private float h(View view, float f) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.g + this.k) - (((View) view.getParent()).getHeight() - view.getY())) + f;
    }

    private CharSequence k() {
        return this.e.p();
    }

    private float m(View view, float f) {
        return (this.f - this.j) + view.getX() + f;
    }

    private String q() {
        if (this.h == -2 || p() <= this.h) {
            return NumberFormat.getInstance(this.e.x()).format(p());
        }
        Context context = (Context) this.a.get();
        return context == null ? Constants.STR_EMPTY : String.format(this.e.x(), context.getString(R$string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.h), Marker.ANY_NON_NULL_MARKER);
    }

    private String r() {
        Context context;
        if (this.e.q() == 0 || (context = (Context) this.a.get()) == null) {
            return null;
        }
        return (this.h == -2 || p() <= this.h) ? context.getResources().getQuantityString(this.e.q(), p(), Integer.valueOf(p())) : context.getString(this.e.n(), Integer.valueOf(this.h));
    }

    private float s(View view, float f) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f + this.j) - (((View) view.getParent()).getWidth() - view.getX())) + f;
    }

    private String v() {
        String strU = u();
        int iN = n();
        if (iN == -2 || strU == null || strU.length() <= iN) {
            return strU;
        }
        Context context = (Context) this.a.get();
        if (context == null) {
            return Constants.STR_EMPTY;
        }
        return String.format(context.getString(R$string.m3_exceed_max_badge_text_suffix), strU.substring(0, iN - 1), "…");
    }

    private CharSequence w() {
        CharSequence charSequenceO = this.e.o();
        return charSequenceO != null ? charSequenceO : u();
    }

    private float x(View view, float f) {
        return (this.g - this.k) + view.getY() + f;
    }

    private int y() {
        int iR = A() ? this.e.r() : this.e.s();
        if (this.e.k == 1) {
            iR += A() ? this.e.j : this.e.i;
        }
        return iR + this.e.b();
    }

    private int z() {
        int iC = this.e.C();
        if (A()) {
            iC = this.e.B();
            Context context = (Context) this.a.get();
            if (context != null) {
                iC = y6.c(iC, iC - this.e.t(), y6.b(0.0f, 1.0f, 0.3f, 1.0f, sg1.f(context) - 1.0f));
            }
        }
        if (this.e.k == 0) {
            iC -= Math.round(this.k);
        }
        return iC + this.e.c();
    }

    public boolean B() {
        return !this.e.E() && this.e.D();
    }

    public boolean C() {
        return this.e.E();
    }

    public void Q(View view, FrameLayout frameLayout) {
        this.l = new WeakReference(view);
        boolean z = b.a;
        if (z && frameLayout == null) {
            O(view);
        } else {
            this.m = new WeakReference(frameLayout);
        }
        if (!z) {
            P(view);
        }
        R();
        invalidateSelf();
    }

    @Override // a23.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.b.draw(canvas);
        if (A()) {
            f(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CharSequence i() {
        if (!isVisible()) {
            return null;
        }
        if (C()) {
            return w();
        }
        return B() ? r() : k();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public FrameLayout j() {
        WeakReference weakReference = this.m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public int l() {
        return this.e.s();
    }

    public int n() {
        return this.e.u();
    }

    public int o() {
        return this.e.v();
    }

    @Override // android.graphics.drawable.Drawable, a23.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public int p() {
        if (this.e.D()) {
            return this.e.w();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.I(i);
        E();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    BadgeState.State t() {
        return this.e.y();
    }

    public String u() {
        return this.e.z();
    }
}
