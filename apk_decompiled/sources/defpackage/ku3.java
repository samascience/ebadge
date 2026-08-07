package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class ku3 implements wu3 {
    private final Executor a;
    private final Object b = new Object();
    private tu1 c;

    public ku3(Executor executor, tu1 tu1Var) {
        this.a = executor;
        this.c = tu1Var;
    }

    @Override // defpackage.wu3
    public final void a(u03 u03Var) {
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new iu3(this, u03Var));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
