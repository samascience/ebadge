package defpackage;

import com.tencent.open.SocialConstants;
import java.io.Closeable;
import java.util.List;
import kotlin.collections.j;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes4.dex */
public final class eh2 implements Closeable {
    private final df2 a;
    private final Protocol b;
    private final String c;
    private final int d;
    private final Handshake e;
    private final iw0 f;
    private final fh2 g;
    private final eh2 h;
    private final eh2 i;
    private final eh2 j;
    private final long k;
    private final long l;
    private final qi0 m;
    private tp n;

    public eh2(df2 df2Var, Protocol protocol, String str, int i, Handshake handshake, iw0 iw0Var, fh2 fh2Var, eh2 eh2Var, eh2 eh2Var2, eh2 eh2Var3, long j, long j2, qi0 qi0Var) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        p31.f(protocol, "protocol");
        p31.f(str, "message");
        p31.f(iw0Var, "headers");
        this.a = df2Var;
        this.b = protocol;
        this.c = str;
        this.d = i;
        this.e = handshake;
        this.f = iw0Var;
        this.g = fh2Var;
        this.h = eh2Var;
        this.i = eh2Var2;
        this.j = eh2Var3;
        this.k = j;
        this.l = j2;
        this.m = qi0Var;
    }

    public static /* synthetic */ String g0(eh2 eh2Var, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return eh2Var.e0(str, str2);
    }

    public final Protocol A0() {
        return this.b;
    }

    public final int C() {
        return this.d;
    }

    public final qi0 D() {
        return this.m;
    }

    public final long F0() {
        return this.l;
    }

    public final df2 G0() {
        return this.a;
    }

    public final long H0() {
        return this.k;
    }

    public final Handshake V() {
        return this.e;
    }

    public final String a0(String str) {
        p31.f(str, "name");
        return g0(this, str, null, 2, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        fh2 fh2Var = this.g;
        if (fh2Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        fh2Var.close();
    }

    public final String e0(String str, String str2) {
        p31.f(str, "name");
        String strA = this.f.a(str);
        return strA == null ? str2 : strA;
    }

    public final iw0 j0() {
        return this.f;
    }

    public final boolean k0() {
        int i = this.d;
        return 200 <= i && i < 300;
    }

    public final String m0() {
        return this.c;
    }

    public final fh2 n() {
        return this.g;
    }

    public final eh2 t0() {
        return this.h;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.d + ", message=" + this.c + ", url=" + this.a.i() + '}';
    }

    public final tp u() {
        tp tpVar = this.n;
        if (tpVar != null) {
            return tpVar;
        }
        tp tpVarB = tp.n.b(this.f);
        this.n = tpVarB;
        return tpVarB;
    }

    public final eh2 w() {
        return this.i;
    }

    public final a w0() {
        return new a(this);
    }

    public final List y() {
        String str;
        iw0 iw0Var = this.f;
        int i = this.d;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return j.j();
            }
            str = "Proxy-Authenticate";
        }
        return mx0.a(iw0Var, str);
    }

    public final eh2 y0() {
        return this.j;
    }

    public static class a {
        private df2 a;
        private Protocol b;
        private int c;
        private String d;
        private Handshake e;
        private iw0.a f;
        private fh2 g;
        private eh2 h;
        private eh2 i;
        private eh2 j;
        private long k;
        private long l;
        private qi0 m;

        public a() {
            this.c = -1;
            this.f = new iw0.a();
        }

        private final void e(eh2 eh2Var) {
            if (eh2Var != null && eh2Var.n() != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private final void f(String str, eh2 eh2Var) {
            if (eh2Var != null) {
                if (eh2Var.n() != null) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (eh2Var.t0() != null) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (eh2Var.w() != null) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (eh2Var.y0() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        public a a(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            this.f.a(str, str2);
            return this;
        }

        public a b(fh2 fh2Var) {
            this.g = fh2Var;
            return this;
        }

        public eh2 c() {
            int i = this.c;
            if (i < 0) {
                throw new IllegalStateException(("code < 0: " + this.c).toString());
            }
            df2 df2Var = this.a;
            if (df2Var == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.b;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.d;
            if (str != null) {
                return new eh2(df2Var, protocol, str, i, this.e, this.f.e(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }
            throw new IllegalStateException("message == null");
        }

        public a d(eh2 eh2Var) {
            f("cacheResponse", eh2Var);
            this.i = eh2Var;
            return this;
        }

        public a g(int i) {
            this.c = i;
            return this;
        }

        public final int h() {
            return this.c;
        }

        public a i(Handshake handshake) {
            this.e = handshake;
            return this;
        }

        public a j(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            this.f.h(str, str2);
            return this;
        }

        public a k(iw0 iw0Var) {
            p31.f(iw0Var, "headers");
            this.f = iw0Var.c();
            return this;
        }

        public final void l(qi0 qi0Var) {
            p31.f(qi0Var, "deferredTrailers");
            this.m = qi0Var;
        }

        public a m(String str) {
            p31.f(str, "message");
            this.d = str;
            return this;
        }

        public a n(eh2 eh2Var) {
            f("networkResponse", eh2Var);
            this.h = eh2Var;
            return this;
        }

        public a o(eh2 eh2Var) {
            e(eh2Var);
            this.j = eh2Var;
            return this;
        }

        public a p(Protocol protocol) {
            p31.f(protocol, "protocol");
            this.b = protocol;
            return this;
        }

        public a q(long j) {
            this.l = j;
            return this;
        }

        public a r(df2 df2Var) {
            p31.f(df2Var, SocialConstants.TYPE_REQUEST);
            this.a = df2Var;
            return this;
        }

        public a s(long j) {
            this.k = j;
            return this;
        }

        public a(eh2 eh2Var) {
            p31.f(eh2Var, "response");
            this.c = -1;
            this.a = eh2Var.G0();
            this.b = eh2Var.A0();
            this.c = eh2Var.C();
            this.d = eh2Var.m0();
            this.e = eh2Var.V();
            this.f = eh2Var.j0().c();
            this.g = eh2Var.n();
            this.h = eh2Var.t0();
            this.i = eh2Var.w();
            this.j = eh2Var.y0();
            this.k = eh2Var.H0();
            this.l = eh2Var.F0();
            this.m = eh2Var.D();
        }
    }
}
