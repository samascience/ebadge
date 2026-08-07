package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.hf0;
import defpackage.nf3;
import defpackage.o23;
import defpackage.og1;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int g0 = R$style.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] h0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private final hf0 c0;
    private ColorStateList d0;
    private ColorStateList e0;
    private boolean f0;

    public SwitchMaterial(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.d0 == null) {
            int iD = og1.d(this, R$attr.colorSurface);
            int iD2 = og1.d(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.c0.e()) {
                dimension += nf3.m(this);
            }
            int iC = this.c0.c(iD, dimension);
            int[][] iArr = h0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = og1.j(iD, iD2, 1.0f);
            iArr2[1] = iC;
            iArr2[2] = og1.j(iD, iD2, 0.38f);
            iArr2[3] = iC;
            this.d0 = new ColorStateList(iArr, iArr2);
        }
        return this.d0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.e0 == null) {
            int[][] iArr = h0;
            int[] iArr2 = new int[iArr.length];
            int iD = og1.d(this, R$attr.colorSurface);
            int iD2 = og1.d(this, R$attr.colorControlActivated);
            int iD3 = og1.d(this, R$attr.colorOnSurface);
            iArr2[0] = og1.j(iD, iD2, 0.54f);
            iArr2[1] = og1.j(iD, iD3, 0.32f);
            iArr2[2] = og1.j(iD, iD2, 0.12f);
            iArr2[3] = og1.j(iD, iD3, 0.12f);
            this.e0 = new ColorStateList(iArr, iArr2);
        }
        return this.e0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f0 = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(Context context, AttributeSet attributeSet, int i) {
        int i2 = g0;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        this.c0 = new hf0(context2);
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.SwitchMaterial, i, i2, new int[0]);
        this.f0 = typedArrayI.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayI.recycle();
    }
}
