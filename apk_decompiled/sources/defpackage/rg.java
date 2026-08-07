package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
abstract class rg {
    private final Queue a = b(20);

    rg() {
    }

    public static Queue b(int i) {
        return new ArrayDeque(i);
    }

    abstract f42 a();

    f42 c() {
        f42 f42Var = (f42) this.a.poll();
        return f42Var == null ? a() : f42Var;
    }

    public void d(f42 f42Var) {
        if (this.a.size() < 20) {
            this.a.offer(f42Var);
        }
    }
}
