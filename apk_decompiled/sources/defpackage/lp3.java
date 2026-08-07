package defpackage;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
class lp3 extends TimerTask {
    final /* synthetic */ Timer a;
    final /* synthetic */ dp3.c b;

    lp3(dp3.c cVar, Timer timer) {
        this.b = cVar;
        this.a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        dp3.c cVar = this.b;
        if (!cVar.n) {
            cVar.i();
        }
        this.a.cancel();
        this.a.purge();
    }
}
