package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.eh1;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends d {
    private static final int[] d = {1};
    private static final int[] e = {1, 0};
    private int c = 0;

    @Override // com.google.android.material.carousel.d
    f g(b bVar, View view) {
        float fB = bVar.b();
        if (bVar.d()) {
            fB = bVar.a();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.d()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f2 = f;
        float fD = d() + f2;
        float fMax = Math.max(c() + f2, fD);
        float fMin = Math.min(measuredHeight + f2, fB);
        float fA = eh1.a((measuredHeight / 3.0f) + f2, fD + f2, fMax + f2);
        float f3 = (fMin + fA) / 2.0f;
        int[] iArrA = d;
        if (fB < 2.0f * fD) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = e;
        if (bVar.c() == 1) {
            iArrA = d.a(iArrA);
            iArrA2 = d.a(iArrA2);
        }
        int[] iArr = iArrA;
        int[] iArr2 = iArrA2;
        int iMax = (int) Math.max(1.0d, Math.floor(((fB - (e.i(iArr2) * f3)) - (e.i(iArr) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(fB / fMin);
        int i = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr3[i2] = iCeil - i2;
        }
        a aVarC = a.c(fB, fA, fD, fMax, iArr, f3, iArr2, fMin, iArr3);
        this.c = aVarC.e();
        if (i(aVarC, bVar.getItemCount())) {
            aVarC = a.c(fB, fA, fD, fMax, new int[]{aVarC.c}, f3, new int[]{aVarC.d}, fMin, new int[]{aVarC.g});
        }
        return e.d(view.getContext(), f2, fB, aVarC, bVar.c());
    }

    @Override // com.google.android.material.carousel.d
    boolean h(b bVar, int i) {
        return (i < this.c && bVar.getItemCount() >= this.c) || (i >= this.c && bVar.getItemCount() < this.c);
    }

    boolean i(a aVar, int i) {
        int iE = aVar.e() - i;
        boolean z = iE > 0 && (aVar.c > 0 || aVar.d > 1);
        while (iE > 0) {
            int i2 = aVar.c;
            if (i2 > 0) {
                aVar.c = i2 - 1;
            } else {
                int i3 = aVar.d;
                if (i3 > 1) {
                    aVar.d = i3 - 1;
                }
            }
            iE--;
        }
        return z;
    }
}
