package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.text.i;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class gx0 implements ri0 {
    public static final d h = new d(null);
    private final zt1 a;
    private final RealConnection b;
    private final so c;
    private final ro d;
    private int e;
    private final jw0 f;
    private iw0 g;

    private abstract class a implements ks2 {
        private final op0 a;
        private boolean b;

        public a() {
            this.a = new op0(gx0.this.c.timeout());
        }

        protected final boolean n() {
            return this.b;
        }

        @Override // defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            p31.f(foVar, "sink");
            try {
                return gx0.this.c.read(foVar, j);
            } catch (IOException e) {
                gx0.this.g().A();
                u();
                throw e;
            }
        }

        @Override // defpackage.ks2
        public h33 timeout() {
            return this.a;
        }

        public final void u() {
            if (gx0.this.e == 6) {
                return;
            }
            if (gx0.this.e == 5) {
                gx0.this.r(this.a);
                gx0.this.e = 6;
            } else {
                throw new IllegalStateException("state: " + gx0.this.e);
            }
        }

        protected final void w(boolean z) {
            this.b = z;
        }
    }

    private final class b implements er2 {
        private final op0 a;
        private boolean b;

        public b() {
            this.a = new op0(gx0.this.d.timeout());
        }

        @Override // defpackage.er2
        public void b0(fo foVar, long j) {
            p31.f(foVar, SocialConstants.PARAM_SOURCE);
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            gx0.this.d.c0(j);
            gx0.this.d.S("\r\n");
            gx0.this.d.b0(foVar, j);
            gx0.this.d.S("\r\n");
        }

        @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            gx0.this.d.S("0\r\n\r\n");
            gx0.this.r(this.a);
            gx0.this.e = 3;
        }

        @Override // defpackage.er2, java.io.Flushable
        public synchronized void flush() {
            if (this.b) {
                return;
            }
            gx0.this.d.flush();
        }

        @Override // defpackage.er2
        public h33 timeout() {
            return this.a;
        }
    }

    private final class c extends a {
        private final tx0 d;
        private long e;
        private boolean f;
        final /* synthetic */ gx0 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(gx0 gx0Var, tx0 tx0Var) {
            super();
            p31.f(tx0Var, SocialConstants.PARAM_URL);
            this.g = gx0Var;
            this.d = tx0Var;
            this.e = -1L;
            this.f = true;
        }

        private final void y() throws ProtocolException {
            if (this.e != -1) {
                this.g.c.n0();
            }
            try {
                this.e = this.g.c.D0();
                String string = i.O0(this.g.c.n0()).toString();
                if (this.e < 0 || (string.length() > 0 && !i.G(string, ";", false, 2, null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + string + JsonFactory.DEFAULT_QUOTE_CHAR);
                }
                if (this.e == 0) {
                    this.f = false;
                    gx0 gx0Var = this.g;
                    gx0Var.g = gx0Var.f.a();
                    zt1 zt1Var = this.g.a;
                    p31.c(zt1Var);
                    i40 i40VarM = zt1Var.m();
                    tx0 tx0Var = this.d;
                    iw0 iw0Var = this.g.g;
                    p31.c(iw0Var);
                    mx0.f(i40VarM, tx0Var, iw0Var);
                    u();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (n()) {
                return;
            }
            if (this.f && !pa3.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.g.g().A();
                u();
            }
            w(true);
        }

        @Override // gx0.a, defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            p31.f(foVar, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (n()) {
                throw new IllegalStateException("closed");
            }
            if (!this.f) {
                return -1L;
            }
            long j2 = this.e;
            if (j2 == 0 || j2 == -1) {
                y();
                if (!this.f) {
                    return -1L;
                }
            }
            long j3 = super.read(foVar, Math.min(j, this.e));
            if (j3 != -1) {
                this.e -= j3;
                return j3;
            }
            this.g.g().A();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            u();
            throw protocolException;
        }
    }

    public static final class d {
        public /* synthetic */ d(y70 y70Var) {
            this();
        }

        private d() {
        }
    }

    private final class e extends a {
        private long d;

        public e(long j) {
            super();
            this.d = j;
            if (j == 0) {
                u();
            }
        }

        @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (n()) {
                return;
            }
            if (this.d != 0 && !pa3.s(this, 100, TimeUnit.MILLISECONDS)) {
                gx0.this.g().A();
                u();
            }
            w(true);
        }

        @Override // gx0.a, defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            p31.f(foVar, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (n()) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.d;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(foVar, Math.min(j2, j));
            if (j3 == -1) {
                gx0.this.g().A();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                u();
                throw protocolException;
            }
            long j4 = this.d - j3;
            this.d = j4;
            if (j4 == 0) {
                u();
            }
            return j3;
        }
    }

    private final class f implements er2 {
        private final op0 a;
        private boolean b;

        public f() {
            this.a = new op0(gx0.this.d.timeout());
        }

        @Override // defpackage.er2
        public void b0(fo foVar, long j) {
            p31.f(foVar, SocialConstants.PARAM_SOURCE);
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            pa3.l(foVar.size(), 0L, j);
            gx0.this.d.b0(foVar, j);
        }

        @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            gx0.this.r(this.a);
            gx0.this.e = 3;
        }

        @Override // defpackage.er2, java.io.Flushable
        public void flush() {
            if (this.b) {
                return;
            }
            gx0.this.d.flush();
        }

        @Override // defpackage.er2
        public h33 timeout() {
            return this.a;
        }
    }

    private final class g extends a {
        private boolean d;

        public g() {
            super();
        }

        @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (n()) {
                return;
            }
            if (!this.d) {
                u();
            }
            w(true);
        }

        @Override // gx0.a, defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            p31.f(foVar, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (n()) {
                throw new IllegalStateException("closed");
            }
            if (this.d) {
                return -1L;
            }
            long j2 = super.read(foVar, j);
            if (j2 != -1) {
                return j2;
            }
            this.d = true;
            u();
            return -1L;
        }
    }

    public gx0(zt1 zt1Var, RealConnection realConnection, so soVar, ro roVar) {
        p31.f(realConnection, "connection");
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        p31.f(roVar, "sink");
        this.a = zt1Var;
        this.b = realConnection;
        this.c = soVar;
        this.d = roVar;
        this.f = new jw0(soVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(op0 op0Var) {
        h33 h33VarI = op0Var.i();
        op0Var.j(h33.e);
        h33VarI.a();
        h33VarI.b();
    }

    private final boolean s(df2 df2Var) {
        return i.v("chunked", df2Var.d("Transfer-Encoding"), true);
    }

    private final boolean t(eh2 eh2Var) {
        return i.v("chunked", eh2.g0(eh2Var, "Transfer-Encoding", null, 2, null), true);
    }

    private final er2 u() {
        if (this.e == 1) {
            this.e = 2;
            return new b();
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    private final ks2 v(tx0 tx0Var) {
        if (this.e == 4) {
            this.e = 5;
            return new c(this, tx0Var);
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    private final ks2 w(long j) {
        if (this.e == 4) {
            this.e = 5;
            return new e(j);
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    private final er2 x() {
        if (this.e == 1) {
            this.e = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    private final ks2 y() {
        if (this.e == 4) {
            this.e = 5;
            g().A();
            return new g();
        }
        throw new IllegalStateException(("state: " + this.e).toString());
    }

    public final void A(iw0 iw0Var, String str) {
        p31.f(iw0Var, "headers");
        p31.f(str, "requestLine");
        if (this.e != 0) {
            throw new IllegalStateException(("state: " + this.e).toString());
        }
        this.d.S(str).S("\r\n");
        int size = iw0Var.size();
        for (int i = 0; i < size; i++) {
            this.d.S(iw0Var.b(i)).S(": ").S(iw0Var.g(i)).S("\r\n");
        }
        this.d.S("\r\n");
        this.e = 1;
    }

    @Override // defpackage.ri0
    public ks2 a(eh2 eh2Var) {
        p31.f(eh2Var, "response");
        if (!mx0.b(eh2Var)) {
            return w(0L);
        }
        if (t(eh2Var)) {
            return v(eh2Var.G0().i());
        }
        long jV = pa3.v(eh2Var);
        return jV != -1 ? w(jV) : y();
    }

    @Override // defpackage.ri0
    public void b(df2 df2Var) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        hf2 hf2Var = hf2.a;
        Proxy.Type type = g().B().b().type();
        p31.e(type, "connection.route().proxy.type()");
        A(df2Var.e(), hf2Var.a(df2Var, type));
    }

    @Override // defpackage.ri0
    public void c() {
        this.d.flush();
    }

    @Override // defpackage.ri0
    public void cancel() {
        g().e();
    }

    @Override // defpackage.ri0
    public long d(eh2 eh2Var) {
        p31.f(eh2Var, "response");
        if (!mx0.b(eh2Var)) {
            return 0L;
        }
        if (t(eh2Var)) {
            return -1L;
        }
        return pa3.v(eh2Var);
    }

    @Override // defpackage.ri0
    public er2 e(df2 df2Var, long j) throws ProtocolException {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        if (df2Var.a() != null && df2Var.a().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (s(df2Var)) {
            return u();
        }
        if (j != -1) {
            return x();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // defpackage.ri0
    public eh2.a f(boolean z) {
        int i = this.e;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.e).toString());
        }
        try {
            zt2 zt2VarA = zt2.d.a(this.f.b());
            eh2.a aVarK = new eh2.a().p(zt2VarA.a).g(zt2VarA.b).m(zt2VarA.c).k(this.f.a());
            if (z && zt2VarA.b == 100) {
                return null;
            }
            int i2 = zt2VarA.b;
            if (i2 == 100) {
                this.e = 3;
                return aVarK;
            }
            if (102 > i2 || i2 >= 200) {
                this.e = 4;
                return aVarK;
            }
            this.e = 3;
            return aVarK;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on " + g().B().a().l().p(), e2);
        }
    }

    @Override // defpackage.ri0
    public RealConnection g() {
        return this.b;
    }

    @Override // defpackage.ri0
    public void h() {
        this.d.flush();
    }

    public final void z(eh2 eh2Var) {
        p31.f(eh2Var, "response");
        long jV = pa3.v(eh2Var);
        if (jV == -1) {
            return;
        }
        ks2 ks2VarW = w(jV);
        pa3.L(ks2VarW, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        ks2VarW.close();
    }
}
