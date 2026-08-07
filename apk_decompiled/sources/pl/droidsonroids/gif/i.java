package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
class i extends j {
    i(b bVar) {
        super(bVar);
    }

    @Override // pl.droidsonroids.gif.j
    public void a() {
        b bVar = this.a;
        long jU = bVar.g.u(bVar.f);
        if (jU >= 0) {
            this.a.c = SystemClock.uptimeMillis() + jU;
            if (this.a.isVisible() && this.a.b) {
                b bVar2 = this.a;
                if (!bVar2.l) {
                    bVar2.a.remove(this);
                    b bVar3 = this.a;
                    bVar3.p = bVar3.a.schedule(this, jU, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.a.h.isEmpty() && this.a.b() == this.a.g.l() - 1) {
                b bVar4 = this.a;
                bVar4.m.sendEmptyMessageAtTime(bVar4.c(), this.a.c);
            }
        } else {
            b bVar5 = this.a;
            bVar5.c = Long.MIN_VALUE;
            bVar5.b = false;
        }
        if (!this.a.isVisible() || this.a.m.hasMessages(-1)) {
            return;
        }
        this.a.m.sendEmptyMessageAtTime(-1, 0L);
    }
}
