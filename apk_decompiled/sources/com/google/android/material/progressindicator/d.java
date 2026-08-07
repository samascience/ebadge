package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import defpackage.o23;
import defpackage.sg1;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {
    public int h;
    public int i;
    public int j;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, CircularProgressIndicator.p);
    }

    public d(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayI = o23.i(context, attributeSet, R$styleable.CircularProgressIndicator, i, i2, new int[0]);
        this.h = Math.max(sg1.d(context, typedArrayI, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.a * 2);
        this.i = sg1.d(context, typedArrayI, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.j = typedArrayI.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayI.recycle();
        e();
    }
}
