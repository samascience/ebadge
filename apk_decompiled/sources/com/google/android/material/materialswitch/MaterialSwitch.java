package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.e0;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.dd0;
import defpackage.nf3;
import defpackage.o23;
import defpackage.pz;
import defpackage.qd0;
import defpackage.v8;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialSwitch extends SwitchCompat {
    private static final int p0 = R$style.Widget_Material3_CompoundButton_MaterialSwitch;
    private static final int[] q0 = {R$attr.state_with_icon};
    private Drawable c0;
    private Drawable d0;
    private int e0;
    private Drawable f0;
    private Drawable g0;
    private ColorStateList h0;
    private ColorStateList i0;
    private PorterDuff.Mode j0;
    private ColorStateList k0;
    private ColorStateList l0;
    private PorterDuff.Mode m0;
    private int[] n0;
    private int[] o0;

    public MaterialSwitch(Context context) {
        this(context, null);
    }

    private void r() {
        this.c0 = qd0.c(this.c0, this.h0, getThumbTintMode());
        this.d0 = qd0.c(this.d0, this.i0, this.j0);
        u();
        Drawable drawable = this.c0;
        Drawable drawable2 = this.d0;
        int i = this.e0;
        super.setThumbDrawable(qd0.b(drawable, drawable2, i, i));
        refreshDrawableState();
    }

    private void s() {
        this.f0 = qd0.c(this.f0, this.k0, getTrackTintMode());
        this.g0 = qd0.c(this.g0, this.l0, this.m0);
        u();
        Drawable layerDrawable = this.f0;
        if (layerDrawable != null && this.g0 != null) {
            layerDrawable = new LayerDrawable(new Drawable[]{this.f0, this.g0});
        } else if (layerDrawable == null) {
            layerDrawable = this.g0;
        }
        if (layerDrawable != null) {
            setSwitchMinWidth(layerDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(layerDrawable);
    }

    private static void t(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        dd0.n(drawable, pz.c(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f));
    }

    private void u() {
        if (this.h0 == null && this.i0 == null && this.k0 == null && this.l0 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.h0;
        if (colorStateList != null) {
            t(this.c0, colorStateList, this.n0, this.o0, thumbPosition);
        }
        ColorStateList colorStateList2 = this.i0;
        if (colorStateList2 != null) {
            t(this.d0, colorStateList2, this.n0, this.o0, thumbPosition);
        }
        ColorStateList colorStateList3 = this.k0;
        if (colorStateList3 != null) {
            t(this.f0, colorStateList3, this.n0, this.o0, thumbPosition);
        }
        ColorStateList colorStateList4 = this.l0;
        if (colorStateList4 != null) {
            t(this.g0, colorStateList4, this.n0, this.o0, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.c0;
    }

    public Drawable getThumbIconDrawable() {
        return this.d0;
    }

    public int getThumbIconSize() {
        return this.e0;
    }

    public ColorStateList getThumbIconTintList() {
        return this.i0;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.j0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.h0;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.g0;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.l0;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.m0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.f0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.k0;
    }

    @Override // android.view.View
    public void invalidate() {
        u();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.d0 != null) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, q0);
        }
        this.n0 = qd0.j(iArrOnCreateDrawableState);
        this.o0 = qd0.f(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.c0 = drawable;
        r();
    }

    public void setThumbIconDrawable(Drawable drawable) {
        this.d0 = drawable;
        r();
    }

    public void setThumbIconResource(int i) {
        setThumbIconDrawable(v8.b(getContext(), i));
    }

    public void setThumbIconSize(int i) {
        if (this.e0 != i) {
            this.e0 = i;
            r();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList) {
        this.i0 = colorStateList;
        r();
    }

    public void setThumbIconTintMode(PorterDuff.Mode mode) {
        this.j0 = mode;
        r();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList) {
        this.h0 = colorStateList;
        r();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        r();
    }

    public void setTrackDecorationDrawable(Drawable drawable) {
        this.g0 = drawable;
        s();
    }

    public void setTrackDecorationResource(int i) {
        setTrackDecorationDrawable(v8.b(getContext(), i));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList) {
        this.l0 = colorStateList;
        s();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode mode) {
        this.m0 = mode;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable) {
        this.f0 = drawable;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList) {
        this.k0 = colorStateList;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        s();
    }

    public MaterialSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSwitchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialSwitch(Context context, AttributeSet attributeSet, int i) {
        int i2 = p0;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.e0 = -1;
        Context context2 = getContext();
        this.c0 = super.getThumbDrawable();
        this.h0 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.f0 = super.getTrackDrawable();
        this.k0 = super.getTrackTintList();
        super.setTrackTintList(null);
        e0 e0VarJ = o23.j(context2, attributeSet, R$styleable.MaterialSwitch, i, i2, new int[0]);
        this.d0 = e0VarJ.g(R$styleable.MaterialSwitch_thumbIcon);
        this.e0 = e0VarJ.f(R$styleable.MaterialSwitch_thumbIconSize, -1);
        this.i0 = e0VarJ.c(R$styleable.MaterialSwitch_thumbIconTint);
        int iK = e0VarJ.k(R$styleable.MaterialSwitch_thumbIconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.j0 = nf3.q(iK, mode);
        this.g0 = e0VarJ.g(R$styleable.MaterialSwitch_trackDecoration);
        this.l0 = e0VarJ.c(R$styleable.MaterialSwitch_trackDecorationTint);
        this.m0 = nf3.q(e0VarJ.k(R$styleable.MaterialSwitch_trackDecorationTintMode, -1), mode);
        e0VarJ.x();
        setEnforceSwitchWidth(false);
        r();
        s();
    }
}
