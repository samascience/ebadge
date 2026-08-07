package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    private float a;
    private float b;

    static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = iArr[i] * 2;
        }
        return iArr2;
    }

    static float b(float f, float f2, float f3) {
        return 1.0f - ((f - f3) / (f2 - f3));
    }

    public float c() {
        return this.b;
    }

    public float d() {
        return this.a;
    }

    void e(Context context) {
        float fH = this.a;
        if (fH <= 0.0f) {
            fH = e.h(context);
        }
        this.a = fH;
        float fG = this.b;
        if (fG <= 0.0f) {
            fG = e.g(context);
        }
        this.b = fG;
    }

    boolean f() {
        return true;
    }

    abstract f g(b bVar, View view);

    abstract boolean h(b bVar, int i);
}
