package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class g80 implements pi2 {
    private final Handler a = zv0.a(Looper.getMainLooper());

    @Override // defpackage.pi2
    public void a(long j, Runnable runnable) {
        this.a.postDelayed(runnable, j);
    }

    @Override // defpackage.pi2
    public void b(Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }
}
