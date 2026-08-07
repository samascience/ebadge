package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.f10;
import defpackage.o23;
import defpackage.og1;
import defpackage.sg1;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int g = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;
    private static final int[][] h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private ColorStateList e;
    private boolean f;

    public MaterialRadioButton(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int iD = og1.d(this, R$attr.colorControlActivated);
            int iD2 = og1.d(this, R$attr.colorOnSurface);
            int iD3 = og1.d(this, R$attr.colorSurface);
            int[][] iArr = h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = og1.j(iD3, iD, 1.0f);
            iArr2[1] = og1.j(iD3, iD2, 0.54f);
            iArr2[2] = og1.j(iD3, iD2, 0.38f);
            iArr2[3] = og1.j(iD3, iD2, 0.38f);
            this.e = new ColorStateList(iArr, iArr2);
        }
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f && f10.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f = z;
        if (z) {
            f10.d(this, getMaterialThemeColorsTintList());
        } else {
            f10.d(this, null);
        }
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i) {
        int i2 = g;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.MaterialRadioButton, i, i2, new int[0]);
        int i3 = R$styleable.MaterialRadioButton_buttonTint;
        if (typedArrayI.hasValue(i3)) {
            f10.d(this, sg1.a(context2, typedArrayI, i3));
        }
        this.f = typedArrayI.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayI.recycle();
    }
}
