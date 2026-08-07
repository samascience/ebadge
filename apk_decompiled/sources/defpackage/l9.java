package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class l9 extends x03 {
    private static volatile l9 c;
    private static final Executor d = new Executor() { // from class: j9
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            l9.h(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: k9
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            l9.i(runnable);
        }
    };
    private x03 a;
    private final x03 b;

    private l9() {
        x80 x80Var = new x80();
        this.b = x80Var;
        this.a = x80Var;
    }

    public static Executor f() {
        return e;
    }

    public static l9 g() {
        if (c != null) {
            return c;
        }
        synchronized (l9.class) {
            try {
                if (c == null) {
                    c = new l9();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Runnable runnable) {
        g().c(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Runnable runnable) {
        g().a(runnable);
    }

    @Override // defpackage.x03
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override // defpackage.x03
    public boolean b() {
        return this.a.b();
    }

    @Override // defpackage.x03
    public void c(Runnable runnable) {
        this.a.c(runnable);
    }
}
