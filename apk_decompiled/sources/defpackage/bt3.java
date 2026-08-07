package defpackage;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
final class bt3 implements Runnable {
    private final Runnable a;

    public bt3(Runnable runnable, int i) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.a.run();
    }
}
