package defpackage;

import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class hd2 {
    public static final a f = new a(null);
    private final int a;
    private final long b;
    private final a13 c;
    private final b d;
    private final ConcurrentLinkedQueue e;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public static final class b extends t03 {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // defpackage.t03
        public long f() {
            return hd2.this.b(System.nanoTime());
        }
    }

    public hd2(b13 b13Var, int i, long j, TimeUnit timeUnit) {
        p31.f(b13Var, "taskRunner");
        p31.f(timeUnit, "timeUnit");
        this.a = i;
        this.b = timeUnit.toNanos(j);
        this.c = b13Var.i();
        this.d = new b(pa3.i + " ConnectionPool");
        this.e = new ConcurrentLinkedQueue();
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j).toString());
    }

    private final int d(RealConnection realConnection, long j) {
        if (pa3.h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List listO = realConnection.o();
        int i = 0;
        while (i < listO.size()) {
            Reference reference = (Reference) listO.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                p31.d(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                r32.a.g().l("A connection to " + realConnection.B().a().l() + " was leaked. Did you forget to close a response body?", ((gd2.b) reference).a());
                listO.remove(i);
                realConnection.E(true);
                if (listO.isEmpty()) {
                    realConnection.D(j - this.b);
                    return 0;
                }
            }
        }
        return listO.size();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0033 A[SYNTHETIC] */
    public final boolean a(v4 v4Var, gd2 gd2Var, List list, boolean z) {
        p31.f(v4Var, "address");
        p31.f(gd2Var, "call");
        for (RealConnection realConnection : this.e) {
            p31.e(realConnection, "connection");
            synchronized (realConnection) {
                if (z) {
                    try {
                        if (realConnection.w()) {
                            if (realConnection.u(v4Var, list)) {
                                gd2Var.c(realConnection);
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (realConnection.u(v4Var, list)) {
                    gd2Var.c(realConnection);
                    return true;
                }
                k83 k83Var = k83.a;
            }
        }
        return false;
    }

    public final long b(long j) {
        int i = 0;
        long j2 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i2 = 0;
        for (RealConnection realConnection2 : this.e) {
            p31.e(realConnection2, "connection");
            synchronized (realConnection2) {
                if (d(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long jP = j - realConnection2.p();
                    if (jP > j2) {
                        realConnection = realConnection2;
                        j2 = jP;
                    }
                    k83 k83Var = k83.a;
                }
            }
        }
        long j3 = this.b;
        if (j2 < j3 && i <= this.a) {
            if (i > 0) {
                return j3 - j2;
            }
            if (i2 > 0) {
                return j3;
            }
            return -1L;
        }
        p31.c(realConnection);
        synchronized (realConnection) {
            if (!realConnection.o().isEmpty()) {
                return 0L;
            }
            if (realConnection.p() + j2 != j) {
                return 0L;
            }
            realConnection.E(true);
            this.e.remove(realConnection);
            pa3.n(realConnection.F());
            if (this.e.isEmpty()) {
                this.c.a();
            }
            return 0L;
        }
    }

    public final boolean c(RealConnection realConnection) {
        p31.f(realConnection, "connection");
        if (pa3.h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        if (!realConnection.q() && this.a != 0) {
            a13.j(this.c, this.d, 0L, 2, null);
            return false;
        }
        realConnection.E(true);
        this.e.remove(realConnection);
        if (this.e.isEmpty()) {
            this.c.a();
        }
        return true;
    }

    public final void e(RealConnection realConnection) {
        p31.f(realConnection, "connection");
        if (!pa3.h || Thread.holdsLock(realConnection)) {
            this.e.add(realConnection);
            a13.j(this.c, this.d, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }
}
