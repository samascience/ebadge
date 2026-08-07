package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.a;
import defpackage.a7;
import defpackage.be3;
import defpackage.e6;
import defpackage.o23;
import defpackage.og1;
import defpackage.yg1;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.a> extends ProgressBar {
    static final int o = R$style.Widget_MaterialComponents_ProgressIndicator;
    com.google.android.material.progressindicator.a a;
    private int b;
    private boolean c;
    private boolean d;
    private final int e;
    private final int f;
    private long g;
    a7 h;
    private boolean i;
    private int j;
    private final Runnable k;
    private final Runnable l;
    private final e6 m;
    private final e6 n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.k();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.j();
            BaseProgressIndicator.this.g = -1L;
        }
    }

    class c extends e6 {
        c() {
        }

        @Override // defpackage.e6
        public void b(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.o(baseProgressIndicator.b, BaseProgressIndicator.this.c);
        }
    }

    class d extends e6 {
        d() {
        }

        @Override // defpackage.e6
        public void b(Drawable drawable) {
            super.b(drawable);
            if (BaseProgressIndicator.this.i) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.j);
        }
    }

    protected BaseProgressIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(yg1.c(context, attributeSet, i, o), attributeSet, i);
        this.g = -1L;
        this.i = false;
        this.j = 4;
        this.k = new a();
        this.l = new b();
        this.m = new c();
        this.n = new d();
        Context context2 = getContext();
        this.a = i(context2, attributeSet);
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.BaseProgressIndicator, i, i2, new int[0]);
        this.e = typedArrayI.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f = Math.min(typedArrayI.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayI.recycle();
        this.h = new a7();
        this.d = true;
    }

    private g getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().w();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((f) getCurrentDrawable()).q(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f > 0) {
            this.g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().v().d(this.m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m(this.n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m(this.n);
        }
    }

    private void p() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s(this.n);
            getIndeterminateDrawable().v().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().s(this.n);
        }
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.a.f;
    }

    public int[] getIndicatorColor() {
        return this.a.c;
    }

    public int getIndicatorTrackGapSize() {
        return this.a.g;
    }

    public int getShowAnimationBehavior() {
        return this.a.e;
    }

    public int getTrackColor() {
        return this.a.d;
    }

    public int getTrackCornerRadius() {
        return this.a.b;
    }

    public int getTrackThickness() {
        return this.a.a;
    }

    protected void h(boolean z) {
        if (this.d) {
            ((f) getCurrentDrawable()).q(q(), false, z);
        }
    }

    abstract com.google.android.material.progressindicator.a i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public void o(int i, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() == null || z) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.b = i;
            this.c = z;
            this.i = true;
            if (!getIndeterminateDrawable().isVisible() || this.h.a(getContext().getContentResolver()) == 0.0f) {
                this.m.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().v().f();
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (q()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.l);
        removeCallbacks(this.k);
        ((f) getCurrentDrawable()).i();
        p();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        try {
            g currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i2) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        h(i == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        h(false);
    }

    boolean q() {
        return be3.S(this) && getWindowVisibility() == 0 && l();
    }

    public void setAnimatorDurationScaleProvider(a7 a7Var) {
        this.h = a7Var;
        if (getProgressDrawable() != null) {
            getProgressDrawable().c = a7Var;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().c = a7Var;
        }
    }

    public void setHideAnimationBehavior(int i) {
        this.a.f = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            f fVar = (f) getCurrentDrawable();
            if (fVar != null) {
                fVar.i();
            }
            super.setIndeterminate(z);
            f fVar2 = (f) getCurrentDrawable();
            if (fVar2 != null) {
                fVar2.q(q(), false, false);
            }
            if ((fVar2 instanceof i) && q()) {
                ((i) fVar2).v().g();
            }
            this.i = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof i)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((f) drawable).i();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{og1.b(getContext(), R$attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.a.c = iArr;
        getIndeterminateDrawable().v().c();
        invalidate();
    }

    public void setIndicatorTrackGapSize(int i) {
        com.google.android.material.progressindicator.a aVar = this.a;
        if (aVar.g != i) {
            aVar.g = i;
            aVar.e();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        o(i, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof e)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            e eVar = (e) drawable;
            eVar.i();
            super.setProgressDrawable(eVar);
            eVar.B(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i) {
        this.a.e = i;
        invalidate();
    }

    public void setTrackColor(int i) {
        com.google.android.material.progressindicator.a aVar = this.a;
        if (aVar.d != i) {
            aVar.d = i;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i) {
        com.google.android.material.progressindicator.a aVar = this.a;
        if (aVar.b != i) {
            aVar.b = Math.min(i, aVar.a / 2);
            invalidate();
        }
    }

    public void setTrackThickness(int i) {
        com.google.android.material.progressindicator.a aVar = this.a;
        if (aVar.a != i) {
            aVar.a = i;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i != 0 && i != 4 && i != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.j = i;
    }

    @Override // android.widget.ProgressBar
    public i getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public e getProgressDrawable() {
        return (e) super.getProgressDrawable();
    }
}
