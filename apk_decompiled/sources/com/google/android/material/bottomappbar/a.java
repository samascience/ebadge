package com.google.android.material.bottomappbar;

import defpackage.co2;
import defpackage.ef0;

/* JADX INFO: loaded from: classes3.dex */
public class a extends ef0 implements Cloneable {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f = -1.0f;

    public a(float f, float f2, float f3) {
        this.b = f;
        this.a = f2;
        i(f3);
        this.e = 0.0f;
    }

    @Override // defpackage.ef0
    public void b(float f, float f2, float f3, co2 co2Var) {
        float f4;
        float f5;
        float f6 = this.c;
        if (f6 == 0.0f) {
            co2Var.m(f, 0.0f);
            return;
        }
        float f7 = ((this.b * 2.0f) + f6) / 2.0f;
        float f8 = f3 * this.a;
        float f9 = f2 + this.e;
        float f10 = (this.d * f3) + ((1.0f - f3) * f7);
        if (f10 / f7 >= 1.0f) {
            co2Var.m(f, 0.0f);
            return;
        }
        float f11 = this.f;
        float f12 = f11 * f3;
        boolean z = f11 == -1.0f || Math.abs((f11 * 2.0f) - f6) < 0.1f;
        if (z) {
            f4 = f10;
            f5 = 0.0f;
        } else {
            f5 = 1.75f;
            f4 = 0.0f;
        }
        float f13 = f7 + f8;
        float f14 = f4 + f8;
        float fSqrt = (float) Math.sqrt((f13 * f13) - (f14 * f14));
        float f15 = f9 - fSqrt;
        float f16 = f9 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f14));
        float f17 = (90.0f - degrees) + f5;
        co2Var.m(f15, 0.0f);
        float f18 = f8 * 2.0f;
        co2Var.a(f15 - f8, 0.0f, f15 + f8, f18, 270.0f, degrees);
        if (z) {
            co2Var.a(f9 - f7, (-f7) - f4, f9 + f7, f7 - f4, 180.0f - f17, (f17 * 2.0f) - 180.0f);
        } else {
            float f19 = this.b;
            float f20 = f12 * 2.0f;
            float f21 = f9 - f7;
            co2Var.a(f21, -(f12 + f19), f21 + f19 + f20, f19 + f12, 180.0f - f17, ((f17 * 2.0f) - 180.0f) / 2.0f);
            float f22 = f9 + f7;
            float f23 = this.b;
            co2Var.m(f22 - ((f23 / 2.0f) + f12), f23 + f12);
            float f24 = this.b;
            co2Var.a(f22 - (f20 + f24), -(f12 + f24), f22, f24 + f12, 90.0f, f17 - 90.0f);
        }
        co2Var.a(f16 - f8, 0.0f, f16 + f8, f18, 270.0f - degrees, degrees);
        co2Var.m(f, 0.0f);
    }

    float c() {
        return this.d;
    }

    public float d() {
        return this.f;
    }

    float e() {
        return this.b;
    }

    float f() {
        return this.a;
    }

    public float g() {
        return this.c;
    }

    public float h() {
        return this.e;
    }

    void i(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.d = f;
    }

    public void j(float f) {
        this.f = f;
    }

    void k(float f) {
        this.b = f;
    }

    void l(float f) {
        this.a = f;
    }

    public void m(float f) {
        this.c = f;
    }

    void o(float f) {
        this.e = f;
    }
}
