package com.yanzhenjie.recyclerview.swipe;

import android.view.View;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
class c extends b {
    public c(View view) {
        super(1, view);
    }

    @Override // com.yanzhenjie.recyclerview.swipe.b
    public void a(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(-Math.abs(i), 0, Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.swipe.b
    public void b(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(Math.abs(i), 0, f().getWidth() - Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.swipe.b
    public b.a d(int i, int i2) {
        b.a aVar = this.c;
        aVar.a = i;
        aVar.b = i2;
        aVar.c = false;
        if (i == 0) {
            aVar.c = true;
        }
        if (i >= 0) {
            aVar.a = 0;
        }
        if (aVar.a <= (-f().getWidth())) {
            this.c.a = -f().getWidth();
        }
        return this.c;
    }

    @Override // com.yanzhenjie.recyclerview.swipe.b
    public boolean h(int i, float f) {
        return f > ((float) f().getWidth());
    }

    public boolean j(int i) {
        int iE = (-f().getWidth()) * e();
        return i <= iE && iE != 0;
    }

    public boolean k(int i) {
        return i < (-f().getWidth()) * e();
    }
}
