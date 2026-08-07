package androidx.camera.camera2.internal;

import defpackage.xl3;

/* JADX INFO: loaded from: classes.dex */
class i3 implements xl3 {
    private float a;
    private final float b;
    private final float c;
    private float d;

    i3(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    private float e(float f) {
        float f2 = this.b;
        float f3 = this.c;
        if (f2 == f3) {
            return 0.0f;
        }
        if (f == f2) {
            return 1.0f;
        }
        if (f == f3) {
            return 0.0f;
        }
        float f4 = 1.0f / f3;
        return ((1.0f / f) - f4) / ((1.0f / f2) - f4);
    }

    @Override // defpackage.xl3
    public float a() {
        return this.b;
    }

    @Override // defpackage.xl3
    public float b() {
        return this.c;
    }

    @Override // defpackage.xl3
    public float c() {
        return this.a;
    }

    @Override // defpackage.xl3
    public float d() {
        return this.d;
    }

    void f(float f) {
        if (f <= this.b && f >= this.c) {
            this.a = f;
            this.d = e(f);
            return;
        }
        throw new IllegalArgumentException("Requested zoomRatio " + f + " is not within valid range [" + this.c + " , " + this.b + "]");
    }
}
