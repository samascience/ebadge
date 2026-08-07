package defpackage;

import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
abstract class sg {
    private final Queue a = na3.e(20);

    sg() {
    }

    abstract g42 a();

    g42 b() {
        g42 g42Var = (g42) this.a.poll();
        return g42Var == null ? a() : g42Var;
    }

    public void c(g42 g42Var) {
        if (this.a.size() < 20) {
            this.a.offer(g42Var);
        }
    }
}
