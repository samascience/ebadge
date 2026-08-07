package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import defpackage.o23;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends a {
    public int h;
    public int i;
    boolean j;
    public int k;

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.a
    void e() {
        super.e();
        if (this.k < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        }
        if (this.h == 0) {
            if (this.b > 0 && this.g == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            if (this.c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, LinearProgressIndicator.p);
    }

    public m(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayI = o23.i(context, attributeSet, R$styleable.LinearProgressIndicator, R$attr.linearProgressIndicatorStyle, LinearProgressIndicator.p, new int[0]);
        this.h = typedArrayI.getInt(R$styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.i = typedArrayI.getInt(R$styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        this.k = Math.min(typedArrayI.getDimensionPixelSize(R$styleable.LinearProgressIndicator_trackStopIndicatorSize, 0), this.a);
        typedArrayI.recycle();
        e();
        this.j = this.i == 1;
    }
}
