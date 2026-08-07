package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.ho2;
import defpackage.o23;
import defpackage.sn2;
import defpackage.ug1;
import defpackage.v8;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, ho2 {
    private static final int[] n = {R.attr.state_checkable};
    private static final int[] o = {R.attr.state_checked};
    private static final int[] p = {R$attr.state_dragged};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f252q = R$style.Widget_MaterialComponents_CardView;
    private final b j;
    private boolean k;
    private boolean l;
    private boolean m;

    public interface a {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.j.l().getBounds());
        return rectF;
    }

    private void h() {
        if (Build.VERSION.SDK_INT > 26) {
            this.j.k();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.j.m();
    }

    public ColorStateList getCardForegroundColor() {
        return this.j.n();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.j.o();
    }

    public int getCheckedIconGravity() {
        return this.j.p();
    }

    public int getCheckedIconMargin() {
        return this.j.q();
    }

    public int getCheckedIconSize() {
        return this.j.r();
    }

    public ColorStateList getCheckedIconTint() {
        return this.j.s();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.j.C().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.j.C().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.j.C().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.j.C().top;
    }

    public float getProgress() {
        return this.j.w();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.j.u();
    }

    public ColorStateList getRippleColor() {
        return this.j.x();
    }

    public sn2 getShapeAppearanceModel() {
        return this.j.y();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.j.z();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.j.A();
    }

    public int getStrokeWidth() {
        return this.j.B();
    }

    public boolean i() {
        b bVar = this.j;
        return bVar != null && bVar.F();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.l;
    }

    public boolean j() {
        return this.m;
    }

    void k(int i, int i2, int i3, int i4) {
        super.f(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j.g0();
        ug1.f(this, this.j.l());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (i()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, n);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, o);
        }
        if (j()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, p);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(i());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.j.K(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.k) {
            if (!this.j.E()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.j.L(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        this.j.M(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        this.j.i0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.j.N(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.j.O(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.l != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.j.R(drawable);
    }

    public void setCheckedIconGravity(int i) {
        if (this.j.p() != i) {
            this.j.S(i);
        }
    }

    public void setCheckedIconMargin(int i) {
        this.j.T(i);
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.j.T(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCheckedIconResource(int i) {
        this.j.R(v8.b(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.j.U(i);
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.j.U(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.j.V(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        b bVar = this.j;
        if (bVar != null) {
            bVar.g0();
        }
    }

    public void setDragged(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
            h();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.j.k0();
    }

    public void setOnCheckedChangeListener(a aVar) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.j.k0();
        this.j.h0();
    }

    public void setProgress(float f) {
        this.j.X(f);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        this.j.W(f);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.j.Y(colorStateList);
    }

    public void setRippleColorResource(int i) {
        this.j.Y(v8.a(getContext(), i));
    }

    @Override // defpackage.ho2
    public void setShapeAppearanceModel(sn2 sn2Var) {
        setClipToOutline(sn2Var.u(getBoundsAsRectF()));
        this.j.Z(sn2Var);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        this.j.b0(i);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.j.k0();
        this.j.h0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (i() && isEnabled()) {
            this.l = !this.l;
            refreshDrawableState();
            h();
            this.j.Q(this.l, true);
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.j.M(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.j.a0(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        int i2 = f252q;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.l = false;
        this.m = false;
        this.k = true;
        TypedArray typedArrayI = o23.i(getContext(), attributeSet, R$styleable.MaterialCardView, i, i2, new int[0]);
        b bVar = new b(this, attributeSet, i, i2);
        this.j = bVar;
        bVar.M(super.getCardBackgroundColor());
        bVar.c0(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        bVar.J(typedArrayI);
        typedArrayI.recycle();
    }
}
