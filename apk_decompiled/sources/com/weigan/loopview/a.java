package com.weigan.loopview;

/* JADX INFO: loaded from: classes3.dex */
final class a implements Runnable {
    float a = 2.1474836E9f;
    final float b;
    final LoopView c;

    a(LoopView loopView, float f) {
        this.c = loopView;
        this.b = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a == 2.1474836E9f) {
            if (Math.abs(this.b) <= 2000.0f) {
                this.a = this.b;
            } else if (this.b > 0.0f) {
                this.a = 2000.0f;
            } else {
                this.a = -2000.0f;
            }
        }
        if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
            this.c.a();
            this.c.c.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.a * 10.0f) / 1000.0f);
        LoopView loopView = this.c;
        int i2 = loopView.t - i;
        loopView.t = i2;
        if (!loopView.f315q) {
            float f = loopView.p * loopView.l;
            int i3 = loopView.u;
            if (i2 <= ((int) ((-i3) * f))) {
                this.a = 40.0f;
                loopView.t = (int) ((-i3) * f);
            } else {
                int size = loopView.j.size() - 1;
                LoopView loopView2 = this.c;
                if (i2 >= ((int) ((size - loopView2.u) * f))) {
                    loopView2.t = (int) (((loopView2.j.size() - 1) - this.c.u) * f);
                    this.a = -40.0f;
                }
            }
        }
        float f2 = this.a;
        if (f2 < 0.0f) {
            this.a = f2 + 20.0f;
        } else {
            this.a = f2 - 20.0f;
        }
        this.c.c.sendEmptyMessage(1000);
    }
}
