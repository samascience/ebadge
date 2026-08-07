package com.weigan.loopview;

/* JADX INFO: loaded from: classes3.dex */
final class d implements Runnable {
    int a = Integer.MAX_VALUE;
    int b = 0;
    int c;
    final LoopView d;

    d(LoopView loopView, int i) {
        this.d = loopView;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a == Integer.MAX_VALUE) {
            this.a = this.c;
        }
        int i = this.a;
        int i2 = (int) (i * 0.1f);
        this.b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.b = -1;
            } else {
                this.b = 1;
            }
        }
        if (Math.abs(i) <= 0) {
            this.d.a();
            this.d.c.sendEmptyMessage(3000);
        } else {
            LoopView loopView = this.d;
            loopView.t += this.b;
            loopView.c.sendEmptyMessage(1000);
            this.a -= this.b;
        }
    }
}
