package androidx.work;

import defpackage.f21;
import defpackage.fl3;
import defpackage.g80;
import defpackage.pi2;
import defpackage.t21;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    final Executor a;
    final Executor b;
    final fl3 c;
    final t21 d;
    final pi2 e;
    final String f;
    final int g;
    final int h;
    final int i;
    final int j;
    private final boolean k;

    /* JADX INFO: renamed from: androidx.work.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0042a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(0);
        final /* synthetic */ boolean b;

        ThreadFactoryC0042a(boolean z) {
            this.b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.b ? "WM.task-" : "androidx.work-") + this.a.incrementAndGet());
        }
    }

    public static final class b {
        Executor a;
        fl3 b;
        t21 c;
        Executor d;
        pi2 e;
        String f;
        int g = 4;
        int h = 0;
        int i = Integer.MAX_VALUE;
        int j = 20;

        public a a() {
            return new a(this);
        }
    }

    a(b bVar) {
        Executor executor = bVar.a;
        if (executor == null) {
            this.a = a(false);
        } else {
            this.a = executor;
        }
        Executor executor2 = bVar.d;
        if (executor2 == null) {
            this.k = true;
            this.b = a(true);
        } else {
            this.k = false;
            this.b = executor2;
        }
        fl3 fl3Var = bVar.b;
        if (fl3Var == null) {
            this.c = fl3.c();
        } else {
            this.c = fl3Var;
        }
        t21 t21Var = bVar.c;
        if (t21Var == null) {
            this.d = t21.c();
        } else {
            this.d = t21Var;
        }
        pi2 pi2Var = bVar.e;
        if (pi2Var == null) {
            this.e = new g80();
        } else {
            this.e = pi2Var;
        }
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.f = bVar.f;
    }

    private Executor a(boolean z) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z));
    }

    private ThreadFactory b(boolean z) {
        return new ThreadFactoryC0042a(z);
    }

    public String c() {
        return this.f;
    }

    public f21 d() {
        return null;
    }

    public Executor e() {
        return this.a;
    }

    public t21 f() {
        return this.d;
    }

    public int g() {
        return this.i;
    }

    public int h() {
        return this.j;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.g;
    }

    public pi2 k() {
        return this.e;
    }

    public Executor l() {
        return this.b;
    }

    public fl3 m() {
        return this.c;
    }
}
