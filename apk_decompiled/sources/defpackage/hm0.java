package defpackage;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public abstract class hm0 implements Closeable {
    private final boolean a;
    private boolean b;
    private int c;
    private final ReentrantLock d = um3.b();

    private static final class a implements ks2 {
        private final hm0 a;
        private long b;
        private boolean c;

        public a(hm0 hm0Var, long j) {
            p31.f(hm0Var, "fileHandle");
            this.a = hm0Var;
            this.b = j;
        }

        @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.c) {
                return;
            }
            this.c = true;
            ReentrantLock reentrantLockC = this.a.C();
            reentrantLockC.lock();
            try {
                this.a.c--;
                if (this.a.c == 0 && this.a.b) {
                    k83 k83Var = k83.a;
                    reentrantLockC.unlock();
                    this.a.D();
                    return;
                }
                reentrantLockC.unlock();
            } catch (Throwable th) {
                reentrantLockC.unlock();
                throw th;
            }
        }

        @Override // defpackage.ks2
        public long read(fo foVar, long j) {
            p31.f(foVar, "sink");
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            long jE0 = this.a.e0(this.b, foVar, j);
            if (jE0 != -1) {
                this.b += jE0;
            }
            return jE0;
        }

        @Override // defpackage.ks2
        public h33 timeout() {
            return h33.e;
        }
    }

    public hm0(boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long e0(long j, fo foVar, long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        long j3 = j2 + j;
        long j4 = j;
        while (j4 < j3) {
            im2 im2VarL0 = foVar.L0(1);
            byte[] bArr = im2VarL0.a;
            int i = im2VarL0.c;
            int iV = V(j4, bArr, i, (int) Math.min(j3 - j4, 8192 - i));
            if (iV == -1) {
                if (im2VarL0.b == im2VarL0.c) {
                    foVar.a = im2VarL0.b();
                    jm2.b(im2VarL0);
                }
                if (j != j4) {
                    break;
                }
                return -1L;
            }
            im2VarL0.c += iV;
            long j5 = iV;
            j4 += j5;
            foVar.I0(foVar.size() + j5);
        }
        return j4 - j;
    }

    public final ReentrantLock C() {
        return this.d;
    }

    protected abstract void D();

    protected abstract int V(long j, byte[] bArr, int i, int i2);

    protected abstract long a0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            if (this.b) {
                reentrantLock.unlock();
                return;
            }
            this.b = true;
            if (this.c != 0) {
                reentrantLock.unlock();
                return;
            }
            k83 k83Var = k83.a;
            reentrantLock.unlock();
            D();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final ks2 g0(long j) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            this.c++;
            reentrantLock.unlock();
            return new a(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            k83 k83Var = k83.a;
            reentrantLock.unlock();
            return a0();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
