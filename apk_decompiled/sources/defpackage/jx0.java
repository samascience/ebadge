package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: loaded from: classes4.dex */
public final class jx0 {
    public static final a o = new a(null);
    private final int a;
    private final okhttp3.internal.http2.b b;
    private long c;
    private long d;
    private long e;
    private long f;
    private final ArrayDeque g;
    private boolean h;
    private final c i;
    private final b j;
    private final d k;
    private final d l;
    private ErrorCode m;
    private IOException n;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public final class b implements er2 {
        private boolean a;
        private final fo b = new fo();
        private iw0 c;
        private boolean d;

        public b(boolean z) {
            this.a = z;
        }

        private final void n(boolean z) throws IOException {
            long jMin;
            boolean z2;
            jx0 jx0Var = jx0.this;
            synchronized (jx0Var) {
                try {
                    jx0Var.s().v();
                    while (jx0Var.r() >= jx0Var.q() && !this.a && !this.d && jx0Var.h() == null) {
                        try {
                            jx0Var.D();
                        } catch (Throwable th) {
                            jx0Var.s().C();
                            throw th;
                        }
                    }
                    jx0Var.s().C();
                    jx0Var.c();
                    jMin = Math.min(jx0Var.q() - jx0Var.r(), this.b.size());
                    jx0Var.B(jx0Var.r() + jMin);
                    z2 = z && jMin == this.b.size();
                    k83 k83Var = k83.a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            jx0.this.s().v();
            try {
                jx0.this.g().j1(jx0.this.j(), z2, this.b, jMin);
            } finally {
                jx0.this.s().C();
            }
        }

        @Override // defpackage.er2
        public void b0(fo foVar, long j) throws IOException {
            p31.f(foVar, SocialConstants.PARAM_SOURCE);
            jx0 jx0Var = jx0.this;
            if (!pa3.h || !Thread.holdsLock(jx0Var)) {
                this.b.b0(foVar, j);
                while (this.b.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                    n(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jx0Var);
            }
        }

        @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            jx0 jx0Var = jx0.this;
            if (pa3.h && Thread.holdsLock(jx0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jx0Var);
            }
            jx0 jx0Var2 = jx0.this;
            synchronized (jx0Var2) {
                if (this.d) {
                    return;
                }
                boolean z = jx0Var2.h() == null;
                k83 k83Var = k83.a;
                if (!jx0.this.o().a) {
                    boolean z2 = this.b.size() > 0;
                    if (this.c != null) {
                        while (this.b.size() > 0) {
                            n(false);
                        }
                        okhttp3.internal.http2.b bVarG = jx0.this.g();
                        int iJ = jx0.this.j();
                        iw0 iw0Var = this.c;
                        p31.c(iw0Var);
                        bVarG.k1(iJ, z, pa3.O(iw0Var));
                    } else if (z2) {
                        while (this.b.size() > 0) {
                            n(true);
                        }
                    } else if (z) {
                        jx0.this.g().j1(jx0.this.j(), true, null, 0L);
                    }
                }
                synchronized (jx0.this) {
                    this.d = true;
                    k83 k83Var2 = k83.a;
                }
                jx0.this.g().flush();
                jx0.this.b();
            }
        }

        @Override // defpackage.er2, java.io.Flushable
        public void flush() throws IOException {
            jx0 jx0Var = jx0.this;
            if (pa3.h && Thread.holdsLock(jx0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jx0Var);
            }
            jx0 jx0Var2 = jx0.this;
            synchronized (jx0Var2) {
                jx0Var2.c();
                k83 k83Var = k83.a;
            }
            while (this.b.size() > 0) {
                n(false);
                jx0.this.g().flush();
            }
        }

        @Override // defpackage.er2
        public h33 timeout() {
            return jx0.this.s();
        }

        public final boolean u() {
            return this.d;
        }

        public final boolean w() {
            return this.a;
        }
    }

    public final class c implements ks2 {
        private final long a;
        private boolean b;
        private final fo c = new fo();
        private final fo d = new fo();
        private iw0 e;
        private boolean f;

        public c(long j, boolean z) {
            this.a = j;
            this.b = z;
        }

        private final void D(long j) {
            jx0 jx0Var = jx0.this;
            if (!pa3.h || !Thread.holdsLock(jx0Var)) {
                jx0.this.g().i1(j);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jx0Var);
        }

        public final void C(iw0 iw0Var) {
            this.e = iw0Var;
        }

        @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            jx0 jx0Var = jx0.this;
            synchronized (jx0Var) {
                this.f = true;
                size = this.d.size();
                this.d.u();
                p31.d(jx0Var, "null cannot be cast to non-null type java.lang.Object");
                jx0Var.notifyAll();
                k83 k83Var = k83.a;
            }
            if (size > 0) {
                D(size);
            }
            jx0.this.b();
        }

        public final boolean n() {
            return this.f;
        }

        @Override // defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            IOException iOExceptionI;
            boolean z;
            long j2;
            p31.f(foVar, "sink");
            long j3 = 0;
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            while (true) {
                jx0 jx0Var = jx0.this;
                synchronized (jx0Var) {
                    jx0Var.m().v();
                    try {
                        if (jx0Var.h() == null || this.b) {
                            iOExceptionI = null;
                        } else {
                            iOExceptionI = jx0Var.i();
                            if (iOExceptionI == null) {
                                ErrorCode errorCodeH = jx0Var.h();
                                p31.c(errorCodeH);
                                iOExceptionI = new StreamResetException(errorCodeH);
                            }
                        }
                        if (this.f) {
                            throw new IOException("stream closed");
                        }
                        z = false;
                        if (this.d.size() > j3) {
                            fo foVar2 = this.d;
                            j2 = foVar2.read(foVar, Math.min(j, foVar2.size()));
                            jx0Var.A(jx0Var.l() + j2);
                            long jL = jx0Var.l() - jx0Var.k();
                            if (iOExceptionI == null && jL >= jx0Var.g().N0().c() / 2) {
                                jx0Var.g().o1(jx0Var.j(), jL);
                                jx0Var.z(jx0Var.l());
                            }
                        } else {
                            if (!this.b && iOExceptionI == null) {
                                jx0Var.D();
                                z = true;
                            }
                            j2 = -1;
                        }
                        jx0Var.m().C();
                        k83 k83Var = k83.a;
                    } catch (Throwable th) {
                        jx0Var.m().C();
                        throw th;
                    }
                    throw th;
                }
                if (!z) {
                    if (j2 != -1) {
                        return j2;
                    }
                    if (iOExceptionI == null) {
                        return -1L;
                    }
                    throw iOExceptionI;
                }
                j3 = 0;
            }
        }

        @Override // defpackage.ks2
        public h33 timeout() {
            return jx0.this.m();
        }

        public final boolean u() {
            return this.b;
        }

        public final void w(so soVar, long j) throws EOFException {
            boolean z;
            boolean z2;
            p31.f(soVar, SocialConstants.PARAM_SOURCE);
            jx0 jx0Var = jx0.this;
            if (pa3.h && Thread.holdsLock(jx0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jx0Var);
            }
            long j2 = j;
            while (j2 > 0) {
                synchronized (jx0.this) {
                    z = this.b;
                    z2 = this.d.size() + j2 > this.a;
                    k83 k83Var = k83.a;
                }
                if (z2) {
                    soVar.a(j2);
                    jx0.this.f(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    soVar.a(j2);
                    return;
                }
                long j3 = soVar.read(this.c, j2);
                if (j3 == -1) {
                    throw new EOFException();
                }
                j2 -= j3;
                jx0 jx0Var2 = jx0.this;
                synchronized (jx0Var2) {
                    try {
                        if (this.f) {
                            this.c.u();
                        } else {
                            boolean z3 = this.d.size() == 0;
                            this.d.L(this.c);
                            if (z3) {
                                p31.d(jx0Var2, "null cannot be cast to non-null type java.lang.Object");
                                jx0Var2.notifyAll();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            D(j);
        }

        public final void y(boolean z) {
            this.b = z;
        }
    }

    public final class d extends bb {
        public d() {
        }

        @Override // defpackage.bb
        protected void B() {
            jx0.this.f(ErrorCode.CANCEL);
            jx0.this.g().c1();
        }

        public final void C() throws IOException {
            if (w()) {
                throw x(null);
            }
        }

        @Override // defpackage.bb
        protected IOException x(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public jx0(int i, okhttp3.internal.http2.b bVar, boolean z, boolean z2, iw0 iw0Var) {
        p31.f(bVar, "connection");
        this.a = i;
        this.b = bVar;
        this.f = bVar.O0().c();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.g = arrayDeque;
        this.i = new c(bVar.N0().c(), z2);
        this.j = new b(z);
        this.k = new d();
        this.l = new d();
        if (iw0Var == null) {
            if (!t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (t()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(iw0Var);
        }
    }

    private final boolean e(ErrorCode errorCode, IOException iOException) {
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.m != null) {
                return false;
            }
            this.m = errorCode;
            this.n = iOException;
            p31.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (this.i.u() && this.j.w()) {
                return false;
            }
            k83 k83Var = k83.a;
            this.b.b1(this.a);
            return true;
        }
    }

    public final void A(long j) {
        this.c = j;
    }

    public final void B(long j) {
        this.e = j;
    }

    public final synchronized iw0 C() {
        Object objRemoveFirst;
        this.k.v();
        while (this.g.isEmpty() && this.m == null) {
            try {
                D();
            } catch (Throwable th) {
                this.k.C();
                throw th;
            }
        }
        this.k.C();
        if (this.g.isEmpty()) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.m;
            p31.c(errorCode);
            throw new StreamResetException(errorCode);
        }
        objRemoveFirst = this.g.removeFirst();
        p31.e(objRemoveFirst, "headersQueue.removeFirst()");
        return (iw0) objRemoveFirst;
    }

    public final void D() throws InterruptedIOException {
        try {
            p31.d(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final h33 E() {
        return this.l;
    }

    public final void a(long j) {
        this.f += j;
        if (j > 0) {
            p31.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void b() {
        boolean z;
        boolean zU;
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                z = !this.i.u() && this.i.n() && (this.j.w() || this.j.u());
                zU = u();
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            d(ErrorCode.CANCEL, null);
        } else {
            if (zU) {
                return;
            }
            this.b.b1(this.a);
        }
    }

    public final void c() throws IOException {
        if (this.j.u()) {
            throw new IOException("stream closed");
        }
        if (this.j.w()) {
            throw new IOException("stream finished");
        }
        if (this.m != null) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.m;
            p31.c(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void d(ErrorCode errorCode, IOException iOException) {
        p31.f(errorCode, "rstStatusCode");
        if (e(errorCode, iOException)) {
            this.b.m1(this.a, errorCode);
        }
    }

    public final void f(ErrorCode errorCode) {
        p31.f(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.b.n1(this.a, errorCode);
        }
    }

    public final okhttp3.internal.http2.b g() {
        return this.b;
    }

    public final synchronized ErrorCode h() {
        return this.m;
    }

    public final IOException i() {
        return this.n;
    }

    public final int j() {
        return this.a;
    }

    public final long k() {
        return this.d;
    }

    public final long l() {
        return this.c;
    }

    public final d m() {
        return this.k;
    }

    public final er2 n() {
        synchronized (this) {
            try {
                if (!this.h && !t()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.j;
    }

    public final b o() {
        return this.j;
    }

    public final c p() {
        return this.i;
    }

    public final long q() {
        return this.f;
    }

    public final long r() {
        return this.e;
    }

    public final d s() {
        return this.l;
    }

    public final boolean t() {
        return this.b.I0() == ((this.a & 1) == 1);
    }

    public final synchronized boolean u() {
        try {
            if (this.m != null) {
                return false;
            }
            if (this.i.u() || this.i.n()) {
                if ((this.j.w() || this.j.u()) && this.h) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final h33 v() {
        return this.k;
    }

    public final void w(so soVar, int i) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        if (!pa3.h || !Thread.holdsLock(this)) {
            this.i.w(soVar, i);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void x(iw0 iw0Var, boolean z) {
        boolean zU;
        p31.f(iw0Var, "headers");
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.h && z) {
                    this.i.C(iw0Var);
                } else {
                    this.h = true;
                    this.g.add(iw0Var);
                }
                if (z) {
                    this.i.y(true);
                }
                zU = u();
                p31.d(this, "null cannot be cast to non-null type java.lang.Object");
                notifyAll();
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zU) {
            return;
        }
        this.b.b1(this.a);
    }

    public final synchronized void y(ErrorCode errorCode) {
        p31.f(errorCode, "errorCode");
        if (this.m == null) {
            this.m = errorCode;
            p31.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void z(long j) {
        this.d = j;
    }
}
