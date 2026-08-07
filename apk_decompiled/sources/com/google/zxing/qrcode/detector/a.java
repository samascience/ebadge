package com.google.zxing.qrcode.detector;

import defpackage.nh2;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends nh2 {
    private final float c;

    a(float f, float f2, float f3) {
        super(f, f2);
        this.c = f3;
    }

    boolean f(float f, float f2, float f3) {
        if (Math.abs(f2 - d()) > f || Math.abs(f3 - c()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.c);
        return fAbs <= 1.0f || fAbs <= this.c;
    }

    a g(float f, float f2, float f3) {
        return new a((c() + f2) / 2.0f, (d() + f) / 2.0f, (this.c + f3) / 2.0f);
    }
}
