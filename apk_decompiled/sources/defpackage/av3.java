package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
final class av3 {
    private final Object a = new Object();
    private Queue b;
    private boolean c;

    av3() {
    }

    public final void a(wu3 wu3Var) {
        synchronized (this.a) {
            try {
                if (this.b == null) {
                    this.b = new ArrayDeque();
                }
                this.b.add(wu3Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(u03 u03Var) {
        wu3 wu3Var;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        try {
                            wu3Var = (wu3) this.b.poll();
                            if (wu3Var == null) {
                                this.c = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    wu3Var.a(u03Var);
                }
            }
        }
    }
}
