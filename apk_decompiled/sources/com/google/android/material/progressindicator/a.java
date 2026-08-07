package com.google.android.material.progressindicator;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import defpackage.o23;
import defpackage.og1;
import defpackage.sg1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public int a;
    public int b;
    public int[] c = new int[0];
    public int d;
    public int e;
    public int f;
    public int g;

    protected a(Context context, AttributeSet attributeSet, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray typedArrayI = o23.i(context, attributeSet, R$styleable.BaseProgressIndicator, i, i2, new int[0]);
        this.a = sg1.d(context, typedArrayI, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.b = Math.min(sg1.d(context, typedArrayI, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.e = typedArrayI.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f = typedArrayI.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.g = typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        c(context, typedArrayI);
        d(context, typedArrayI);
        typedArrayI.recycle();
    }

    private void c(Context context, TypedArray typedArray) {
        int i = R$styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i)) {
            this.c = new int[]{og1.b(context, R$attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i).type != 1) {
            this.c = new int[]{typedArray.getColor(i, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i, -1));
        this.c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void d(Context context, TypedArray typedArray) {
        int i = R$styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i)) {
            this.d = typedArray.getColor(i, -1);
            return;
        }
        this.d = this.c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.d = og1.a(this.d, (int) (f * 255.0f));
    }

    public boolean a() {
        return this.f != 0;
    }

    public boolean b() {
        return this.e != 0;
    }

    void e() {
        if (this.g < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
