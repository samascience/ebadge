package defpackage;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class qi0 {
    private final gd2 a;
    private final fi0 b;
    private final si0 c;
    private final ri0 d;
    private boolean e;
    private boolean f;
    private final RealConnection g;

    private final class a extends mp0 {
        private final long b;
        private boolean c;
        private long d;
        private boolean e;
        final /* synthetic */ qi0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qi0 qi0Var, er2 er2Var, long j) {
            super(er2Var);
            p31.f(er2Var, "delegate");
            this.f = qi0Var;
            this.b = j;
        }

        private final IOException n(IOException iOException) {
            if (this.c) {
                return iOException;
            }
            this.c = true;
            return this.f.a(this.d, false, true, iOException);
        }

        @Override // defpackage.mp0, defpackage.er2
        public void b0(fo foVar, long j) throws IOException {
            p31.f(foVar, SocialConstants.PARAM_SOURCE);
            if (this.e) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.b;
            if (j2 == -1 || this.d + j <= j2) {
                try {
                    super.b0(foVar, j);
                    this.d += j;
                    return;
                } catch (IOException e) {
                    throw n(e);
                }
            }
            throw new ProtocolException("expected " + this.b + " bytes but received " + (this.d + j));
        }

        @Override // defpackage.mp0, defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.e) {
                return;
            }
            this.e = true;
            long j = this.b;
            if (j != -1 && this.d != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                n(null);
            } catch (IOException e) {
                throw n(e);
            }
        }

        @Override // defpackage.mp0, defpackage.er2, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw n(e);
            }
        }
    }

    public final class b extends np0 {
        private final long a;
        private long b;
        private boolean c;
        private boolean d;
        private boolean e;
        final /* synthetic */ qi0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qi0 qi0Var, ks2 ks2Var, long j) {
            super(ks2Var);
            p31.f(ks2Var, "delegate");
            this.f = qi0Var;
            this.a = j;
            this.c = true;
            if (j == 0) {
                n(null);
            }
        }

        @Override // defpackage.np0, defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.e) {
                return;
            }
            this.e = true;
            try {
                super.close();
                n(null);
            } catch (IOException e) {
                throw n(e);
            }
        }

        public final IOException n(IOException iOException) {
            if (this.d) {
                return iOException;
            }
            this.d = true;
            if (iOException == null && this.c) {
                this.c = false;
                this.f.i().v(this.f.g());
            }
            return this.f.a(this.b, true, false, iOException);
        }

        @Override // defpackage.np0, defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            p31.f(foVar, "sink");
            if (this.e) {
                throw new IllegalStateException("closed");
            }
            try {
                long j2 = delegate().read(foVar, j);
                if (this.c) {
                    this.c = false;
                    this.f.i().v(this.f.g());
                }
                if (j2 == -1) {
                    n(null);
                    return -1L;
                }
                long j3 = this.b + j2;
                long j4 = this.a;
                if (j4 != -1 && j3 > j4) {
                    throw new ProtocolException("expected " + this.a + " bytes but received " + j3);
                }
                this.b = j3;
                if (j3 == j4) {
                    n(null);
                }
                return j2;
            } catch (IOException e) {
                throw n(e);
            }
        }
    }

    public qi0(gd2 gd2Var, fi0 fi0Var, si0 si0Var, ri0 ri0Var) {
        p31.f(gd2Var, "call");
        p31.f(fi0Var, "eventListener");
        p31.f(si0Var, "finder");
        p31.f(ri0Var, "codec");
        this.a = gd2Var;
        this.b = fi0Var;
        this.c = si0Var;
        this.d = ri0Var;
        this.g = ri0Var.g();
    }

    private final void u(IOException iOException) {
        this.f = true;
        this.c.h(iOException);
        this.d.g().I(this.a, iOException);
    }

    public final IOException a(long j, boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            u(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.b.r(this.a, iOException);
            } else {
                this.b.p(this.a, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.b.w(this.a, iOException);
            } else {
                this.b.u(this.a, j);
            }
        }
        return this.a.s(this, z2, z, iOException);
    }

    public final void b() {
        this.d.cancel();
    }

    public final er2 c(df2 df2Var, boolean z) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        this.e = z;
        ff2 ff2VarA = df2Var.a();
        p31.c(ff2VarA);
        long jContentLength = ff2VarA.contentLength();
        this.b.q(this.a);
        return new a(this, this.d.e(df2Var, jContentLength), jContentLength);
    }

    public final void d() {
        this.d.cancel();
        this.a.s(this, true, true, null);
    }

    public final void e() {
        try {
            this.d.c();
        } catch (IOException e) {
            this.b.r(this.a, e);
            u(e);
            throw e;
        }
    }

    public final void f() {
        try {
            this.d.h();
        } catch (IOException e) {
            this.b.r(this.a, e);
            u(e);
            throw e;
        }
    }

    public final gd2 g() {
        return this.a;
    }

    public final RealConnection h() {
        return this.g;
    }

    public final fi0 i() {
        return this.b;
    }

    public final si0 j() {
        return this.c;
    }

    public final boolean k() {
        return this.f;
    }

    public final boolean l() {
        return !p31.a(this.c.d().l().h(), this.g.B().a().l().h());
    }

    public final boolean m() {
        return this.e;
    }

    public final md2.d n() {
        this.a.y();
        return this.d.g().y(this);
    }

    public final void o() {
        this.d.g().A();
    }

    public final void p() {
        this.a.s(this, true, false, null);
    }

    public final fh2 q(eh2 eh2Var) throws IOException {
        p31.f(eh2Var, "response");
        try {
            String strG0 = eh2.g0(eh2Var, "Content-Type", null, 2, null);
            long jD = this.d.d(eh2Var);
            return new kd2(strG0, jD, hu1.b(new b(this, this.d.a(eh2Var), jD)));
        } catch (IOException e) {
            this.b.w(this.a, e);
            u(e);
            throw e;
        }
    }

    public final eh2.a r(boolean z) {
        try {
            eh2.a aVarF = this.d.f(z);
            if (aVarF != null) {
                aVarF.l(this);
            }
            return aVarF;
        } catch (IOException e) {
            this.b.w(this.a, e);
            u(e);
            throw e;
        }
    }

    public final void s(eh2 eh2Var) {
        p31.f(eh2Var, "response");
        this.b.x(this.a, eh2Var);
    }

    public final void t() {
        this.b.y(this.a);
    }

    public final void v() {
        a(-1L, true, true, null);
    }

    public final void w(df2 df2Var) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        try {
            this.b.t(this.a);
            this.d.b(df2Var);
            this.b.s(this.a, df2Var);
        } catch (IOException e) {
            this.b.r(this.a, e);
            u(e);
            throw e;
        }
    }
}
