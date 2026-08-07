package defpackage;

import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.collections.j;
import kotlin.text.i;
import lombok.javac.Javac;
import okhttp3.Protocol;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class md2 implements qh3, uh3.a {
    private final df2 a;
    private final sh3 b;
    private final Random c;
    private final long d;
    private rh3 e;
    private long f;
    private final String g;
    private eq h;
    private t03 i;
    private uh3 j;
    private wh3 k;
    private a13 l;
    private String m;
    private d n;
    private final ArrayDeque o;
    private final ArrayDeque p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f357q;
    private boolean r;
    private int s;
    private String t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    public static final b z = new b(null);
    private static final List A = j.e(Protocol.HTTP_1_1);

    public static final class a {
        private final int a;
        private final ByteString b;
        private final long c;

        public a(int i, ByteString byteString, long j) {
            this.a = i;
            this.b = byteString;
            this.c = j;
        }

        public final long a() {
            return this.c;
        }

        public final int b() {
            return this.a;
        }

        public final ByteString c() {
            return this.b;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private b() {
        }
    }

    public static final class c {
        private final int a;
        private final ByteString b;

        public c(int i, ByteString byteString) {
            p31.f(byteString, "data");
            this.a = i;
            this.b = byteString;
        }

        public final ByteString a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }
    }

    public static abstract class d implements Closeable {
        private final boolean a;
        private final so b;
        private final ro c;

        public d(boolean z, so soVar, ro roVar) {
            p31.f(soVar, SocialConstants.PARAM_SOURCE);
            p31.f(roVar, "sink");
            this.a = z;
            this.b = soVar;
            this.c = roVar;
        }

        public final boolean n() {
            return this.a;
        }

        public final ro u() {
            return this.c;
        }

        public final so w() {
            return this.b;
        }
    }

    private final class e extends t03 {
        public e() {
            super(md2.this.m + " writer", false, 2, null);
        }

        @Override // defpackage.t03
        public long f() {
            try {
                return md2.this.x() ? 0L : -1L;
            } catch (IOException e) {
                md2.this.q(e, null);
                return -1L;
            }
        }
    }

    public static final class f implements gq {
        final /* synthetic */ df2 b;

        f(df2 df2Var) {
            this.b = df2Var;
        }

        @Override // defpackage.gq
        public void onFailure(eq eqVar, IOException iOException) {
            p31.f(eqVar, "call");
            p31.f(iOException, "e");
            md2.this.q(iOException, null);
        }

        @Override // defpackage.gq
        public void onResponse(eq eqVar, eh2 eh2Var) {
            p31.f(eqVar, "call");
            p31.f(eh2Var, "response");
            qi0 qi0VarD = eh2Var.D();
            try {
                md2.this.n(eh2Var, qi0VarD);
                p31.c(qi0VarD);
                d dVarN = qi0VarD.n();
                rh3 rh3VarA = rh3.g.a(eh2Var.j0());
                md2.this.e = rh3VarA;
                if (!md2.this.t(rh3VarA)) {
                    md2 md2Var = md2.this;
                    synchronized (md2Var) {
                        md2Var.p.clear();
                        md2Var.f(1010, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
                try {
                    md2.this.s(pa3.i + " WebSocket " + this.b.i().p(), dVarN);
                    md2.this.r().h(md2.this, eh2Var);
                    md2.this.u();
                } catch (Exception e) {
                    md2.this.q(e, null);
                }
            } catch (IOException e2) {
                md2.this.q(e2, eh2Var);
                pa3.m(eh2Var);
                if (qi0VarD != null) {
                    qi0VarD.v();
                }
            }
        }
    }

    public static final class g extends t03 {
        final /* synthetic */ md2 e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, md2 md2Var, long j) {
            super(str, false, 2, null);
            this.e = md2Var;
            this.f = j;
        }

        @Override // defpackage.t03
        public long f() {
            this.e.y();
            return this.f;
        }
    }

    public static final class h extends t03 {
        final /* synthetic */ md2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, md2 md2Var) {
            super(str, z);
            this.e = md2Var;
        }

        @Override // defpackage.t03
        public long f() {
            this.e.m();
            return -1L;
        }
    }

    public md2(b13 b13Var, df2 df2Var, sh3 sh3Var, Random random, long j, rh3 rh3Var, long j2) {
        p31.f(b13Var, "taskRunner");
        p31.f(df2Var, "originalRequest");
        p31.f(sh3Var, "listener");
        p31.f(random, "random");
        this.a = df2Var;
        this.b = sh3Var;
        this.c = random;
        this.d = j;
        this.e = rh3Var;
        this.f = j2;
        this.l = b13Var.i();
        this.o = new ArrayDeque();
        this.p = new ArrayDeque();
        this.s = -1;
        if (!p31.a(Constants.HTTP_GET, df2Var.g())) {
            throw new IllegalArgumentException(("Request must be GET: " + df2Var.g()).toString());
        }
        ByteString.a aVar = ByteString.Companion;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        k83 k83Var = k83.a;
        this.g = ByteString.a.h(aVar, bArr, 0, 0, 3, null).base64();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t(rh3 rh3Var) {
        if (!rh3Var.f && rh3Var.b == null) {
            return rh3Var.d == null || new e31(8, 15).f(rh3Var.d.intValue());
        }
        return false;
    }

    private final void v() {
        if (!pa3.h || Thread.holdsLock(this)) {
            t03 t03Var = this.i;
            if (t03Var != null) {
                a13.j(this.l, t03Var, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final synchronized boolean w(ByteString byteString, int i) {
        if (!this.u && !this.r) {
            if (this.f357q + ((long) byteString.size()) > Javac.GENERATED_MEMBER) {
                f(1001, null);
                return false;
            }
            this.f357q += (long) byteString.size();
            this.p.add(new c(i, byteString));
            v();
            return true;
        }
        return false;
    }

    @Override // defpackage.qh3
    public boolean a(ByteString byteString) {
        p31.f(byteString, "bytes");
        return w(byteString, 2);
    }

    @Override // defpackage.qh3
    public boolean b(String str) {
        p31.f(str, "text");
        return w(ByteString.Companion.d(str), 1);
    }

    @Override // uh3.a
    public void c(ByteString byteString) {
        p31.f(byteString, "bytes");
        this.b.g(this, byteString);
    }

    @Override // uh3.a
    public void d(String str) {
        p31.f(str, "text");
        this.b.f(this, str);
    }

    @Override // uh3.a
    public synchronized void e(ByteString byteString) {
        try {
            p31.f(byteString, "payload");
            if (!this.u && (!this.r || !this.p.isEmpty())) {
                this.o.add(byteString);
                v();
                this.w++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.qh3
    public boolean f(int i, String str) {
        return o(i, str, 60000L);
    }

    @Override // uh3.a
    public synchronized void g(ByteString byteString) {
        p31.f(byteString, "payload");
        this.x++;
        this.y = false;
    }

    @Override // uh3.a
    public void h(int i, String str) {
        d dVar;
        uh3 uh3Var;
        wh3 wh3Var;
        p31.f(str, "reason");
        if (i == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            try {
                if (this.s != -1) {
                    throw new IllegalStateException("already closed");
                }
                this.s = i;
                this.t = str;
                dVar = null;
                if (this.r && this.p.isEmpty()) {
                    d dVar2 = this.n;
                    this.n = null;
                    uh3Var = this.j;
                    this.j = null;
                    wh3Var = this.k;
                    this.k = null;
                    this.l.n();
                    dVar = dVar2;
                } else {
                    uh3Var = null;
                    wh3Var = null;
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            this.b.d(this, i, str);
            if (dVar != null) {
                this.b.c(this, i, str);
            }
        } finally {
            if (dVar != null) {
                pa3.m(dVar);
            }
            if (uh3Var != null) {
                pa3.m(uh3Var);
            }
            if (wh3Var != null) {
                pa3.m(wh3Var);
            }
        }
    }

    public void m() {
        eq eqVar = this.h;
        p31.c(eqVar);
        eqVar.cancel();
    }

    public final void n(eh2 eh2Var, qi0 qi0Var) throws ProtocolException {
        p31.f(eh2Var, "response");
        if (eh2Var.C() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + eh2Var.C() + ' ' + eh2Var.m0() + '\'');
        }
        String strG0 = eh2.g0(eh2Var, "Connection", null, 2, null);
        if (!i.v("Upgrade", strG0, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strG0 + '\'');
        }
        String strG1 = eh2.g0(eh2Var, "Upgrade", null, 2, null);
        if (!i.v("websocket", strG1, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strG1 + '\'');
        }
        String strG2 = eh2.g0(eh2Var, "Sec-WebSocket-Accept", null, 2, null);
        String strBase64 = ByteString.Companion.d(this.g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (p31.a(strBase64, strG2)) {
            if (qi0Var == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strG2 + '\'');
    }

    public final synchronized boolean o(int i, String str, long j) {
        ByteString byteStringD;
        try {
            th3.a.c(i);
            if (str != null) {
                byteStringD = ByteString.Companion.d(str);
                if (byteStringD.size() > 123) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            } else {
                byteStringD = null;
            }
            if (!this.u && !this.r) {
                this.r = true;
                this.p.add(new a(i, byteStringD, j));
                v();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void p(zt1 zt1Var) {
        p31.f(zt1Var, "client");
        if (this.a.d("Sec-WebSocket-Extensions") != null) {
            q(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        zt1 zt1VarB = zt1Var.y().i(fi0.b).N(A).b();
        df2 df2VarB = this.a.h().g("Upgrade", "websocket").g("Connection", "Upgrade").g("Sec-WebSocket-Key", this.g).g("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP).g("Sec-WebSocket-Extensions", "permessage-deflate").b();
        gd2 gd2Var = new gd2(zt1VarB, df2VarB, true);
        this.h = gd2Var;
        p31.c(gd2Var);
        gd2Var.n(new f(df2VarB));
    }

    public final void q(Exception exc, eh2 eh2Var) {
        p31.f(exc, "e");
        synchronized (this) {
            if (this.u) {
                return;
            }
            this.u = true;
            d dVar = this.n;
            this.n = null;
            uh3 uh3Var = this.j;
            this.j = null;
            wh3 wh3Var = this.k;
            this.k = null;
            this.l.n();
            k83 k83Var = k83.a;
            try {
                this.b.e(this, exc, eh2Var);
            } finally {
                if (dVar != null) {
                    pa3.m(dVar);
                }
                if (uh3Var != null) {
                    pa3.m(uh3Var);
                }
                if (wh3Var != null) {
                    pa3.m(wh3Var);
                }
            }
        }
    }

    public final sh3 r() {
        return this.b;
    }

    public final void s(String str, d dVar) {
        p31.f(str, "name");
        p31.f(dVar, "streams");
        rh3 rh3Var = this.e;
        p31.c(rh3Var);
        synchronized (this) {
            try {
                this.m = str;
                this.n = dVar;
                this.k = new wh3(dVar.n(), dVar.u(), this.c, rh3Var.a, rh3Var.a(dVar.n()), this.f);
                this.i = new e();
                long j = this.d;
                if (j != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                    this.l.i(new g(str + " ping", this, nanos), nanos);
                }
                if (!this.p.isEmpty()) {
                    v();
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.j = new uh3(dVar.n(), dVar.w(), this, rh3Var.a, rh3Var.a(!dVar.n()));
    }

    public final void u() {
        while (this.s == -1) {
            uh3 uh3Var = this.j;
            p31.c(uh3Var);
            uh3Var.n();
        }
    }

    public final boolean x() {
        String str;
        uh3 uh3Var;
        wh3 wh3Var;
        int i;
        d dVar;
        synchronized (this) {
            try {
                if (this.u) {
                    return false;
                }
                wh3 wh3Var2 = this.k;
                Object objPoll = this.o.poll();
                Object obj = null;
                if (objPoll == null) {
                    Object objPoll2 = this.p.poll();
                    if (objPoll2 instanceof a) {
                        i = this.s;
                        str = this.t;
                        if (i != -1) {
                            dVar = this.n;
                            this.n = null;
                            uh3Var = this.j;
                            this.j = null;
                            wh3Var = this.k;
                            this.k = null;
                            this.l.n();
                        } else {
                            long jA = ((a) objPoll2).a();
                            this.l.i(new h(this.m + " cancel", true, this), TimeUnit.MILLISECONDS.toNanos(jA));
                            dVar = null;
                            uh3Var = null;
                            wh3Var = null;
                        }
                    } else {
                        if (objPoll2 == null) {
                            return false;
                        }
                        str = null;
                        uh3Var = null;
                        wh3Var = null;
                        i = -1;
                        dVar = null;
                    }
                    obj = objPoll2;
                } else {
                    str = null;
                    uh3Var = null;
                    wh3Var = null;
                    i = -1;
                    dVar = null;
                }
                k83 k83Var = k83.a;
                try {
                    if (objPoll != null) {
                        p31.c(wh3Var2);
                        wh3Var2.C((ByteString) objPoll);
                    } else if (obj instanceof c) {
                        c cVar = (c) obj;
                        p31.c(wh3Var2);
                        wh3Var2.w(cVar.b(), cVar.a());
                        synchronized (this) {
                            this.f357q -= (long) cVar.a().size();
                        }
                    } else {
                        if (!(obj instanceof a)) {
                            throw new AssertionError();
                        }
                        a aVar = (a) obj;
                        p31.c(wh3Var2);
                        wh3Var2.n(aVar.b(), aVar.c());
                        if (dVar != null) {
                            sh3 sh3Var = this.b;
                            p31.c(str);
                            sh3Var.c(this, i, str);
                        }
                    }
                    if (dVar != null) {
                        pa3.m(dVar);
                    }
                    if (uh3Var != null) {
                        pa3.m(uh3Var);
                    }
                    if (wh3Var != null) {
                        pa3.m(wh3Var);
                    }
                    return true;
                } catch (Throwable th) {
                    if (dVar != null) {
                        pa3.m(dVar);
                    }
                    if (uh3Var != null) {
                        pa3.m(uh3Var);
                    }
                    if (wh3Var != null) {
                        pa3.m(wh3Var);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void y() {
        synchronized (this) {
            try {
                if (this.u) {
                    return;
                }
                wh3 wh3Var = this.k;
                if (wh3Var == null) {
                    return;
                }
                int i = this.y ? this.v : -1;
                this.v++;
                this.y = true;
                k83 k83Var = k83.a;
                if (i == -1) {
                    try {
                        wh3Var.y(ByteString.EMPTY);
                        return;
                    } catch (IOException e2) {
                        q(e2, null);
                        return;
                    }
                }
                q(new SocketTimeoutException("sent ping but didn't receive pong within " + this.d + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
