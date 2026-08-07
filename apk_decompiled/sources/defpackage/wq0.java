package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class wq0 {
    private final Executor a;
    private final yq0 b;
    private final Object c;
    private int d;
    private boolean e;
    private boolean f;
    private final List g;
    private final Runnable h;

    public wq0(Executor executor, yq0 yq0Var) {
        p31.f(executor, "executor");
        p31.f(yq0Var, "reportFullyDrawn");
        this.a = executor;
        this.b = yq0Var;
        this.c = new Object();
        this.g = new ArrayList();
        this.h = new Runnable() { // from class: vq0
            @Override // java.lang.Runnable
            public final void run() {
                wq0.g(this.a);
            }
        };
    }

    private final void e() {
        if (this.e || this.d != 0) {
            return;
        }
        this.e = true;
        this.a.execute(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(wq0 wq0Var) {
        p31.f(wq0Var, "this$0");
        synchronized (wq0Var.c) {
            try {
                wq0Var.e = false;
                if (wq0Var.d == 0 && !wq0Var.f) {
                    wq0Var.b.invoke();
                    wq0Var.c();
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.c) {
            try {
                if (!this.f) {
                    this.d++;
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.c) {
            try {
                this.f = true;
                Iterator it = this.g.iterator();
                while (it.hasNext()) {
                    ((yq0) it.next()).invoke();
                }
                this.g.clear();
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        boolean z;
        synchronized (this.c) {
            z = this.f;
        }
        return z;
    }

    public final void f() {
        int i;
        synchronized (this.c) {
            try {
                if (!this.f && (i = this.d) > 0) {
                    this.d = i - 1;
                    e();
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
