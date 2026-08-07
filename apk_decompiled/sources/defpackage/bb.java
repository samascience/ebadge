package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class bb extends h33 {
    public static final a i = new a(null);
    private static final ReentrantLock j;
    private static final Condition k;
    private static final long l;
    private static final long m;
    private static bb n;
    private boolean f;
    private bb g;
    private long h;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(bb bbVar) {
            ReentrantLock reentrantLockF = bb.i.f();
            reentrantLockF.lock();
            try {
                if (!bbVar.f) {
                    return false;
                }
                bbVar.f = false;
                for (bb bbVar2 = bb.n; bbVar2 != null; bbVar2 = bbVar2.g) {
                    if (bbVar2.g == bbVar) {
                        bbVar2.g = bbVar.g;
                        bbVar.g = null;
                        return false;
                    }
                }
                return true;
            } finally {
                reentrantLockF.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(bb bbVar, long j, boolean z) {
            ReentrantLock reentrantLockF = bb.i.f();
            reentrantLockF.lock();
            try {
                if (bbVar.f) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                bbVar.f = true;
                if (bb.n == null) {
                    bb.n = new bb();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z) {
                    bbVar.h = Math.min(j, bbVar.c() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    bbVar.h = j + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    bbVar.h = bbVar.c();
                }
                long jY = bbVar.y(jNanoTime);
                bb bbVar2 = bb.n;
                p31.c(bbVar2);
                while (bbVar2.g != null) {
                    bb bbVar3 = bbVar2.g;
                    p31.c(bbVar3);
                    if (jY < bbVar3.y(jNanoTime)) {
                        break;
                    }
                    bbVar2 = bbVar2.g;
                    p31.c(bbVar2);
                }
                bbVar.g = bbVar2.g;
                bbVar2.g = bbVar;
                if (bbVar2 == bb.n) {
                    bb.i.e().signal();
                }
                k83 k83Var = k83.a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public final bb c() throws InterruptedException {
            bb bbVar = bb.n;
            p31.c(bbVar);
            bb bbVar2 = bbVar.g;
            if (bbVar2 == null) {
                long jNanoTime = System.nanoTime();
                e().await(bb.l, TimeUnit.MILLISECONDS);
                bb bbVar3 = bb.n;
                p31.c(bbVar3);
                if (bbVar3.g != null || System.nanoTime() - jNanoTime < bb.m) {
                    return null;
                }
                return bb.n;
            }
            long jY = bbVar2.y(System.nanoTime());
            if (jY > 0) {
                e().await(jY, TimeUnit.NANOSECONDS);
                return null;
            }
            bb bbVar4 = bb.n;
            p31.c(bbVar4);
            bbVar4.g = bbVar2.g;
            bbVar2.g = null;
            return bbVar2;
        }

        public final Condition e() {
            return bb.k;
        }

        public final ReentrantLock f() {
            return bb.j;
        }

        private a() {
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    a aVar = bb.i;
                    ReentrantLock reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        bb bbVarC = aVar.c();
                        if (bbVarC == bb.n) {
                            bb.n = null;
                            reentrantLockF.unlock();
                            return;
                        } else {
                            k83 k83Var = k83.a;
                            reentrantLockF.unlock();
                            if (bbVarC != null) {
                                bbVarC.B();
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLockF.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static final class c implements er2 {
        final /* synthetic */ er2 b;

        c(er2 er2Var) {
            this.b = er2Var;
        }

        @Override // defpackage.er2
        public void b0(fo foVar, long j) throws IOException {
            p31.f(foVar, SocialConstants.PARAM_SOURCE);
            f.b(foVar.size(), 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                im2 im2Var = foVar.a;
                p31.c(im2Var);
                while (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    j2 += (long) (im2Var.c - im2Var.b);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    } else {
                        im2Var = im2Var.f;
                        p31.c(im2Var);
                    }
                }
                bb bbVar = bb.this;
                er2 er2Var = this.b;
                bbVar.v();
                try {
                    try {
                        er2Var.b0(foVar, j2);
                        k83 k83Var = k83.a;
                        if (bbVar.w()) {
                            throw bbVar.p(null);
                        }
                        j -= j2;
                    } catch (IOException e) {
                        if (!bbVar.w()) {
                            throw e;
                        }
                        throw bbVar.p(e);
                    }
                } catch (Throwable th) {
                    bbVar.w();
                    throw th;
                }
            }
        }

        @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            bb bbVar = bb.this;
            er2 er2Var = this.b;
            bbVar.v();
            try {
                try {
                    er2Var.close();
                    k83 k83Var = k83.a;
                    if (bbVar.w()) {
                        throw bbVar.p(null);
                    }
                } catch (IOException e) {
                    if (!bbVar.w()) {
                        throw e;
                    }
                    throw bbVar.p(e);
                }
            } catch (Throwable th) {
                bbVar.w();
                throw th;
            }
        }

        @Override // defpackage.er2, java.io.Flushable
        public void flush() throws IOException {
            bb bbVar = bb.this;
            er2 er2Var = this.b;
            bbVar.v();
            try {
                try {
                    er2Var.flush();
                    k83 k83Var = k83.a;
                    if (bbVar.w()) {
                        throw bbVar.p(null);
                    }
                } catch (IOException e) {
                    if (!bbVar.w()) {
                        throw e;
                    }
                    throw bbVar.p(e);
                }
            } catch (Throwable th) {
                bbVar.w();
                throw th;
            }
        }

        @Override // defpackage.er2
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public bb timeout() {
            return bb.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.b + ')';
        }
    }

    public static final class d implements ks2 {
        final /* synthetic */ ks2 b;

        d(ks2 ks2Var) {
            this.b = ks2Var;
        }

        @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            bb bbVar = bb.this;
            ks2 ks2Var = this.b;
            bbVar.v();
            try {
                try {
                    ks2Var.close();
                    k83 k83Var = k83.a;
                    if (bbVar.w()) {
                        throw bbVar.p(null);
                    }
                } catch (IOException e) {
                    if (!bbVar.w()) {
                        throw e;
                    }
                    throw bbVar.p(e);
                }
            } catch (Throwable th) {
                bbVar.w();
                throw th;
            }
        }

        @Override // defpackage.ks2
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public bb timeout() {
            return bb.this;
        }

        @Override // defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            p31.f(foVar, "sink");
            bb bbVar = bb.this;
            ks2 ks2Var = this.b;
            bbVar.v();
            try {
                try {
                    long j2 = ks2Var.read(foVar, j);
                    if (bbVar.w()) {
                        throw bbVar.p(null);
                    }
                    return j2;
                } catch (IOException e) {
                    if (bbVar.w()) {
                        throw bbVar.p(e);
                    }
                    throw e;
                }
            } catch (Throwable th) {
                bbVar.w();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        p31.e(conditionNewCondition, "newCondition(...)");
        k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        l = millis;
        m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long y(long j2) {
        return this.h - j2;
    }

    public final ks2 A(ks2 ks2Var) {
        p31.f(ks2Var, SocialConstants.PARAM_SOURCE);
        return new d(ks2Var);
    }

    protected void B() {
    }

    public final IOException p(IOException iOException) {
        return x(iOException);
    }

    public final void v() {
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            i.g(this, jH, zE);
        }
    }

    public final boolean w() {
        return i.d(this);
    }

    protected IOException x(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final er2 z(er2 er2Var) {
        p31.f(er2Var, "sink");
        return new c(er2Var);
    }
}
