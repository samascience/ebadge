package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class h33 {
    public static final b d = new b(null);
    public static final h33 e = new a();
    private boolean a;
    private long b;
    private long c;

    public static final class a extends h33 {
        a() {
        }

        @Override // defpackage.h33
        public h33 d(long j) {
            return this;
        }

        @Override // defpackage.h33
        public void f() {
        }

        @Override // defpackage.h33
        public h33 g(long j, TimeUnit timeUnit) {
            p31.f(timeUnit, "unit");
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private b() {
        }
    }

    public h33 a() {
        this.a = false;
        return this;
    }

    public h33 b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public h33 d(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public boolean e() {
        return this.a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public h33 g(long j, TimeUnit timeUnit) {
        p31.f(timeUnit, "unit");
        if (j >= 0) {
            this.c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j).toString());
    }

    public long h() {
        return this.c;
    }
}
