package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.R$dimen;

/* JADX INFO: loaded from: classes3.dex */
abstract class e {
    static float a(float f, float f2, int i) {
        return f + (Math.max(0, i - 1) * f2);
    }

    static float b(float f, float f2, int i) {
        return i > 0 ? f + (f2 / 2.0f) : f;
    }

    static f c(Context context, float f, float f2, a aVar) {
        float f3;
        float fMin = Math.min(f(context) + f, aVar.f);
        float f4 = fMin / 2.0f;
        float f5 = 0.0f - f4;
        float fB = b(0.0f, aVar.b, aVar.c);
        float fJ = j(0.0f, a(fB, aVar.b, (int) Math.floor(aVar.c / 2.0f)), aVar.b, aVar.c);
        float fB2 = b(fJ, aVar.e, aVar.d);
        float fJ2 = j(fJ, a(fB2, aVar.e, (int) Math.floor(aVar.d / 2.0f)), aVar.e, aVar.d);
        float fB3 = b(fJ2, aVar.f, aVar.g);
        float fJ3 = j(fJ2, a(fB3, aVar.f, aVar.g), aVar.f, aVar.g);
        float fB4 = b(fJ3, aVar.e, aVar.d);
        float fB5 = b(j(fJ3, a(fB4, aVar.e, (int) Math.ceil(aVar.d / 2.0f)), aVar.e, aVar.d), aVar.b, aVar.c);
        float f6 = f4 + f2;
        float fB6 = d.b(fMin, aVar.f, f);
        float fB7 = d.b(aVar.b, aVar.f, f);
        float fB8 = d.b(aVar.e, aVar.f, f);
        f.b bVarA = new f.b(aVar.f, f2).a(f5, fB6, fMin);
        int i = aVar.c;
        if (i > 0) {
            bVarA.g(fB, fB7, aVar.b, (int) Math.floor(i / 2.0f));
        }
        int i2 = aVar.d;
        if (i2 > 0) {
            bVarA.g(fB2, fB8, aVar.e, (int) Math.floor(i2 / 2.0f));
        }
        bVarA.h(fB3, 0.0f, aVar.f, aVar.g, true);
        int i3 = aVar.d;
        if (i3 > 0) {
            f3 = 2.0f;
            bVarA.g(fB4, fB8, aVar.e, (int) Math.ceil(i3 / 2.0f));
        } else {
            f3 = 2.0f;
        }
        int i4 = aVar.c;
        if (i4 > 0) {
            bVarA.g(fB5, fB7, aVar.b, (int) Math.ceil(i4 / f3));
        }
        bVarA.a(f6, fB6, fMin);
        return bVarA.i();
    }

    static f d(Context context, float f, float f2, a aVar, int i) {
        return i == 1 ? c(context, f, f2, aVar) : e(context, f, f2, aVar);
    }

    static f e(Context context, float f, float f2, a aVar) {
        float fMin = Math.min(f(context) + f, aVar.f);
        float f3 = fMin / 2.0f;
        float f4 = 0.0f - f3;
        float fB = b(0.0f, aVar.f, aVar.g);
        float fJ = j(0.0f, a(fB, aVar.f, aVar.g), aVar.f, aVar.g);
        float fB2 = b(fJ, aVar.e, aVar.d);
        float fB3 = b(j(fJ, fB2, aVar.e, aVar.d), aVar.b, aVar.c);
        float f5 = f3 + f2;
        float fB4 = d.b(fMin, aVar.f, f);
        float fB5 = d.b(aVar.b, aVar.f, f);
        float fB6 = d.b(aVar.e, aVar.f, f);
        f.b bVarH = new f.b(aVar.f, f2).a(f4, fB4, fMin).h(fB, 0.0f, aVar.f, aVar.g, true);
        if (aVar.d > 0) {
            bVarH.b(fB2, fB6, aVar.e);
        }
        int i = aVar.c;
        if (i > 0) {
            bVarH.g(fB3, fB5, aVar.b, i);
        }
        bVarH.a(f5, fB4, fMin);
        return bVarH.i();
    }

    static float f(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_gone_size);
    }

    static float g(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_max);
    }

    static float h(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_min);
    }

    static int i(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    static float j(float f, float f2, float f3, int i) {
        return i > 0 ? f2 + (f3 / 2.0f) : f;
    }
}
