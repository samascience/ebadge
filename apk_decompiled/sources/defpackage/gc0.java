package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.d;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class gc0 {
    private boolean b;
    private boolean c;
    private boolean a = true;
    private final Queue d = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(gc0 gc0Var, Runnable runnable) {
        p31.f(gc0Var, "this$0");
        p31.f(runnable, "$runnable");
        gc0Var.f(runnable);
    }

    private final void f(Runnable runnable) {
        if (!this.d.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables");
        }
        e();
    }

    public final boolean b() {
        return this.b || !this.a;
    }

    public final void c(d dVar, final Runnable runnable) {
        p31.f(dVar, "context");
        p31.f(runnable, "runnable");
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        if (immediate.isDispatchNeeded(dVar) || b()) {
            immediate.mo149dispatch(dVar, new Runnable() { // from class: fc0
                @Override // java.lang.Runnable
                public final void run() {
                    gc0.d(this.a, runnable);
                }
            });
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (this.c) {
            return;
        }
        try {
            this.c = true;
            while (!this.d.isEmpty() && b()) {
                Runnable runnable = (Runnable) this.d.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
            this.c = false;
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    public final void g() {
        this.b = true;
        e();
    }

    public final void h() {
        this.a = true;
    }

    public final void i() {
        if (this.a) {
            if (this.b) {
                throw new IllegalStateException("Cannot resume a finished dispatcher");
            }
            this.a = false;
            e();
        }
    }
}
