package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes4.dex */
class a {
    private volatile boolean a;

    a() {
    }

    synchronized void a() {
        while (!this.a) {
            wait();
        }
    }

    synchronized void b() {
        this.a = false;
    }

    synchronized void c() {
        boolean z = this.a;
        this.a = true;
        if (!z) {
            notify();
        }
    }

    synchronized void d(boolean z) {
        try {
            if (z) {
                c();
            } else {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
