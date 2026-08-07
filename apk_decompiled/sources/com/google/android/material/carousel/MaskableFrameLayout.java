package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.google.android.material.carousel.MaskableFrameLayout;
import defpackage.eh1;
import defpackage.ho2;
import defpackage.io2;
import defpackage.l40;
import defpackage.mv1;
import defpackage.nv;
import defpackage.sn2;
import defpackage.tx;
import defpackage.v0;
import defpackage.y6;

/* JADX INFO: loaded from: classes3.dex */
public class MaskableFrameLayout extends FrameLayout implements h, ho2 {
    private float a;
    private final RectF b;
    private sn2 c;
    private final io2 d;
    private Boolean e;

    public MaskableFrameLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l40 d(l40 l40Var) {
        return l40Var instanceof v0 ? tx.b((v0) l40Var) : l40Var;
    }

    private void e() {
        this.d.f(this, this.b);
    }

    private void f() {
        if (this.a != -1.0f) {
            float fB = y6.b(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.a);
            setMaskRectF(new RectF(fB, 0.0f, getWidth() - fB, getHeight()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.d.e(canvas, new nv.a() { // from class: ag1
            @Override // nv.a
            public final void a(Canvas canvas2) {
                this.a.c(canvas2);
            }
        });
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        RectF rectF = this.b;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public RectF getMaskRectF() {
        return this.b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.a;
    }

    public sn2 getShapeAppearanceModel() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.e;
        if (bool != null) {
            this.d.h(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.e = Boolean.valueOf(this.d.c());
        this.d.h(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a != -1.0f) {
            f();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.b.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.b.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceCompatClipping(boolean z) {
        this.d.h(this, z);
    }

    @Override // com.google.android.material.carousel.h
    public void setMaskRectF(RectF rectF) {
        this.b.set(rectF);
        e();
    }

    @Deprecated
    public void setMaskXPercentage(float f) {
        float fA = eh1.a(f, 0.0f, 1.0f);
        if (this.a != fA) {
            this.a = fA;
            f();
        }
    }

    public void setOnMaskChangedListener(mv1 mv1Var) {
    }

    @Override // defpackage.ho2
    public void setShapeAppearanceModel(sn2 sn2Var) {
        sn2 sn2VarY = sn2Var.y(new sn2.c() { // from class: zf1
            @Override // sn2.c
            public final l40 a(l40 l40Var) {
                return MaskableFrameLayout.d(l40Var);
            }
        });
        this.c = sn2VarY;
        this.d.g(this, sn2VarY);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1.0f;
        this.b = new RectF();
        this.d = io2.a(this);
        this.e = null;
        setShapeAppearanceModel(sn2.f(context, attributeSet, i, 0, 0).m());
    }
}
