package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import defpackage.gg1;
import defpackage.sg1;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    private void q(Resources.Theme theme, int i) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i, R$styleable.MaterialTextAppearance);
        int iU = u(getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iU >= 0) {
            setLineHeight(iU);
        }
    }

    private static boolean r(Context context) {
        return gg1.b(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    private static int s(Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private void t(AttributeSet attributeSet, int i, int i2) {
        int iS;
        Context context = getContext();
        if (r(context)) {
            Resources.Theme theme = context.getTheme();
            if (v(context, theme, attributeSet, i, i2) || (iS = s(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            q(theme, iS);
        }
    }

    private static int u(Context context, TypedArray typedArray, int... iArr) {
        int iD = -1;
        for (int i = 0; i < iArr.length && iD < 0; i++) {
            iD = sg1.d(context, typedArray, iArr[i], -1);
        }
        return iD;
    }

    private static boolean v(Context context, Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i, i2);
        int iU = u(context, typedArrayObtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iU != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (r(context)) {
            q(context.getTheme(), i);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i) {
        super(yg1.c(context, attributeSet, i, 0), attributeSet, i);
        t(attributeSet, i, 0);
    }
}
