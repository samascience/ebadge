package okhttp3.internal.http2;

import com.tencent.open.SocialConstants;
import defpackage.a13;
import defpackage.b13;
import defpackage.fo;
import defpackage.j92;
import defpackage.jx0;
import defpackage.k83;
import defpackage.nn2;
import defpackage.p31;
import defpackage.pa3;
import defpackage.r32;
import defpackage.ro;
import defpackage.so;
import defpackage.t03;
import defpackage.y70;
import defpackage.yq0;
import defpackage.z03;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Closeable {
    public static final C0155b H = new C0155b(null);
    private static final nn2 I;
    private final d F;
    private final Set G;
    private final boolean a;
    private final c b;
    private final Map c;
    private final String d;
    private int e;
    private int f;
    private boolean g;
    private final b13 h;
    private final a13 i;
    private final a13 j;
    private final a13 k;
    private final j92 l;
    private long m;
    private long n;
    private long o;
    private long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f368q;
    private long r;
    private final nn2 s;
    private nn2 t;
    private long u;
    private long v;
    private long w;
    private long x;
    private final Socket y;
    private final okhttp3.internal.http2.d z;

    public static final class a {
        private boolean a;
        private final b13 b;
        public Socket c;
        public String d;
        public so e;
        public ro f;
        private c g;
        private j92 h;
        private int i;

        public a(boolean z, b13 b13Var) {
            p31.f(b13Var, "taskRunner");
            this.a = z;
            this.b = b13Var;
            this.g = c.b;
            this.h = j92.b;
        }

        public final b a() {
            return new b(this);
        }

        public final boolean b() {
            return this.a;
        }

        public final String c() {
            String str = this.d;
            if (str != null) {
                return str;
            }
            p31.t("connectionName");
            return null;
        }

        public final c d() {
            return this.g;
        }

        public final int e() {
            return this.i;
        }

        public final j92 f() {
            return this.h;
        }

        public final ro g() {
            ro roVar = this.f;
            if (roVar != null) {
                return roVar;
            }
            p31.t("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.c;
            if (socket != null) {
                return socket;
            }
            p31.t("socket");
            return null;
        }

        public final so i() {
            so soVar = this.e;
            if (soVar != null) {
                return soVar;
            }
            p31.t(SocialConstants.PARAM_SOURCE);
            return null;
        }

        public final b13 j() {
            return this.b;
        }

        public final a k(c cVar) {
            p31.f(cVar, "listener");
            this.g = cVar;
            return this;
        }

        public final a l(int i) {
            this.i = i;
            return this;
        }

        public final void m(String str) {
            p31.f(str, "<set-?>");
            this.d = str;
        }

        public final void n(ro roVar) {
            p31.f(roVar, "<set-?>");
            this.f = roVar;
        }

        public final void o(Socket socket) {
            p31.f(socket, "<set-?>");
            this.c = socket;
        }

        public final void p(so soVar) {
            p31.f(soVar, "<set-?>");
            this.e = soVar;
        }

        public final a q(Socket socket, String str, so soVar, ro roVar) {
            String str2;
            p31.f(socket, "socket");
            p31.f(str, "peerName");
            p31.f(soVar, SocialConstants.PARAM_SOURCE);
            p31.f(roVar, "sink");
            o(socket);
            if (this.a) {
                str2 = pa3.i + ' ' + str;
            } else {
                str2 = "MockWebServer " + str;
            }
            m(str2);
            p(soVar);
            n(roVar);
            return this;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    public static final class C0155b {
        public /* synthetic */ C0155b(y70 y70Var) {
            this();
        }

        public final nn2 a() {
            return b.I;
        }

        private C0155b() {
        }
    }

    public static abstract class c {
        public static final C0156b a = new C0156b(null);
        public static final c b = new a();

        public static final class a extends c {
            a() {
            }

            @Override // okhttp3.internal.http2.b.c
            public void c(jx0 jx0Var) {
                p31.f(jx0Var, "stream");
                jx0Var.d(ErrorCode.REFUSED_STREAM, null);
            }
        }

        /* JADX INFO: renamed from: okhttp3.internal.http2.b$c$b, reason: collision with other inner class name */
        public static final class C0156b {
            public /* synthetic */ C0156b(y70 y70Var) {
                this();
            }

            private C0156b() {
            }
        }

        public void b(b bVar, nn2 nn2Var) {
            p31.f(bVar, "connection");
            p31.f(nn2Var, "settings");
        }

        public abstract void c(jx0 jx0Var);
    }

    public final class d implements okhttp3.internal.http2.c.InterfaceC0159c, yq0 {
        private final okhttp3.internal.http2.c a;
        final /* synthetic */ b b;

        public static final class a extends t03 {
            final /* synthetic */ b e;
            final /* synthetic */ Ref$ObjectRef f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z, b bVar, Ref$ObjectRef ref$ObjectRef) {
                super(str, z);
                this.e = bVar;
                this.f = ref$ObjectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.t03
            public long f() {
                this.e.L0().b(this.e, (nn2) this.f.element);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: okhttp3.internal.http2.b$d$b, reason: collision with other inner class name */
        public static final class C0157b extends t03 {
            final /* synthetic */ b e;
            final /* synthetic */ jx0 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0157b(String str, boolean z, b bVar, jx0 jx0Var) {
                super(str, z);
                this.e = bVar;
                this.f = jx0Var;
            }

            @Override // defpackage.t03
            public long f() {
                try {
                    this.e.L0().c(this.f);
                    return -1L;
                } catch (IOException e) {
                    r32.a.g().j("Http2Connection.Listener failure for " + this.e.J0(), 4, e);
                    try {
                        this.f.d(ErrorCode.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        public static final class c extends t03 {
            final /* synthetic */ b e;
            final /* synthetic */ int f;
            final /* synthetic */ int g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z, b bVar, int i, int i2) {
                super(str, z);
                this.e = bVar;
                this.f = i;
                this.g = i2;
            }

            @Override // defpackage.t03
            public long f() {
                this.e.l1(true, this.f, this.g);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: okhttp3.internal.http2.b$d$d, reason: collision with other inner class name */
        public static final class C0158d extends t03 {
            final /* synthetic */ d e;
            final /* synthetic */ boolean f;
            final /* synthetic */ nn2 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0158d(String str, boolean z, d dVar, boolean z2, nn2 nn2Var) {
                super(str, z);
                this.e = dVar;
                this.f = z2;
                this.g = nn2Var;
            }

            @Override // defpackage.t03
            public long f() {
                this.e.k(this.f, this.g);
                return -1L;
            }
        }

        public d(b bVar, okhttp3.internal.http2.c cVar) {
            p31.f(cVar, "reader");
            this.b = bVar;
            this.a = cVar;
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void a() {
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void b(boolean z, int i, int i2, List list) {
            p31.f(list, "headerBlock");
            if (this.b.a1(i)) {
                this.b.X0(i, list, z);
                return;
            }
            b bVar = this.b;
            synchronized (bVar) {
                jx0 jx0VarP0 = bVar.P0(i);
                if (jx0VarP0 != null) {
                    k83 k83Var = k83.a;
                    jx0VarP0.x(pa3.P(list), z);
                    return;
                }
                if (bVar.g) {
                    return;
                }
                if (i <= bVar.K0()) {
                    return;
                }
                if (i % 2 == bVar.M0() % 2) {
                    return;
                }
                jx0 jx0Var = new jx0(i, bVar, false, z, pa3.P(list));
                bVar.d1(i);
                bVar.Q0().put(Integer.valueOf(i), jx0Var);
                bVar.h.i().i(new C0157b(bVar.J0() + '[' + i + "] onStream", true, bVar, jx0Var), 0L);
            }
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void c(boolean z, int i, so soVar, int i2) {
            p31.f(soVar, SocialConstants.PARAM_SOURCE);
            if (this.b.a1(i)) {
                this.b.W0(i, soVar, i2, z);
                return;
            }
            jx0 jx0VarP0 = this.b.P0(i);
            if (jx0VarP0 == null) {
                this.b.n1(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                this.b.i1(j);
                soVar.a(j);
                return;
            }
            jx0VarP0.w(soVar, i2);
            if (z) {
                jx0VarP0.x(pa3.b, true);
            }
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void d(int i, long j) {
            if (i == 0) {
                b bVar = this.b;
                synchronized (bVar) {
                    bVar.x = bVar.R0() + j;
                    p31.d(bVar, "null cannot be cast to non-null type java.lang.Object");
                    bVar.notifyAll();
                    k83 k83Var = k83.a;
                }
                return;
            }
            jx0 jx0VarP0 = this.b.P0(i);
            if (jx0VarP0 != null) {
                synchronized (jx0VarP0) {
                    jx0VarP0.a(j);
                    k83 k83Var2 = k83.a;
                }
            }
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void e(boolean z, int i, int i2) {
            if (!z) {
                this.b.i.i(new c(this.b.J0() + " ping", true, this.b, i, i2), 0L);
                return;
            }
            b bVar = this.b;
            synchronized (bVar) {
                try {
                    if (i == 1) {
                        bVar.n++;
                    } else if (i != 2) {
                        if (i == 3) {
                            bVar.f368q++;
                            p31.d(bVar, "null cannot be cast to non-null type java.lang.Object");
                            bVar.notifyAll();
                        }
                        k83 k83Var = k83.a;
                    } else {
                        bVar.p++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void f(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void g(int i, ErrorCode errorCode) {
            p31.f(errorCode, "errorCode");
            if (this.b.a1(i)) {
                this.b.Z0(i, errorCode);
                return;
            }
            jx0 jx0VarB1 = this.b.b1(i);
            if (jx0VarB1 != null) {
                jx0VarB1.y(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void h(boolean z, nn2 nn2Var) {
            p31.f(nn2Var, "settings");
            this.b.i.i(new C0158d(this.b.J0() + " applyAndAckSettings", true, this, z, nn2Var), 0L);
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void i(int i, int i2, List list) {
            p31.f(list, "requestHeaders");
            this.b.Y0(i2, list);
        }

        @Override // defpackage.yq0
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            l();
            return k83.a;
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0159c
        public void j(int i, ErrorCode errorCode, ByteString byteString) {
            int i2;
            Object[] array;
            p31.f(errorCode, "errorCode");
            p31.f(byteString, "debugData");
            byteString.size();
            b bVar = this.b;
            synchronized (bVar) {
                array = bVar.Q0().values().toArray(new jx0[0]);
                bVar.g = true;
                k83 k83Var = k83.a;
            }
            for (jx0 jx0Var : (jx0[]) array) {
                if (jx0Var.j() > i && jx0Var.t()) {
                    jx0Var.y(ErrorCode.REFUSED_STREAM);
                    this.b.b1(jx0Var.j());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, nn2] */
        /* JADX WARN: Type inference failed for: r13v3 */
        public final void k(boolean z, nn2 nn2Var) {
            ?? r13;
            long jC;
            int i;
            jx0[] jx0VarArr;
            p31.f(nn2Var, "settings");
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            okhttp3.internal.http2.d dVarS0 = this.b.S0();
            b bVar = this.b;
            synchronized (dVarS0) {
                synchronized (bVar) {
                    try {
                        nn2 nn2VarO0 = bVar.O0();
                        if (z) {
                            r13 = nn2Var;
                        } else {
                            nn2 nn2Var2 = new nn2();
                            nn2Var2.g(nn2VarO0);
                            nn2Var2.g(nn2Var);
                            r13 = nn2Var2;
                        }
                        ref$ObjectRef.element = r13;
                        jC = ((long) r13.c()) - ((long) nn2VarO0.c());
                        jx0VarArr = (jC == 0 || bVar.Q0().isEmpty()) ? null : (jx0[]) bVar.Q0().values().toArray(new jx0[0]);
                        bVar.e1((nn2) ref$ObjectRef.element);
                        bVar.k.i(new a(bVar.J0() + " onSettings", true, bVar, ref$ObjectRef), 0L);
                        k83 k83Var = k83.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    bVar.S0().n((nn2) ref$ObjectRef.element);
                } catch (IOException e) {
                    bVar.H0(e);
                }
                k83 k83Var2 = k83.a;
            }
            if (jx0VarArr != null) {
                for (jx0 jx0Var : jx0VarArr) {
                    synchronized (jx0Var) {
                        jx0Var.a(jC);
                        k83 k83Var3 = k83.a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.c] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void l() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.a.w(this);
                    while (this.a.u(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        this.b.G0(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e2) {
                        e = e2;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        b bVar = this.b;
                        bVar.G0(errorCode4, errorCode4, e);
                        errorCode = bVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    this.b.G0(errorCode, errorCode2, e);
                    pa3.m(this.a);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                this.b.G0(errorCode, errorCode2, e);
                pa3.m(this.a);
                throw th;
            }
            errorCode2 = this.a;
            pa3.m(errorCode2);
        }
    }

    public static final class e extends t03 {
        final /* synthetic */ b e;
        final /* synthetic */ int f;
        final /* synthetic */ fo g;
        final /* synthetic */ int h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z, b bVar, int i, fo foVar, int i2, boolean z2) {
            super(str, z);
            this.e = bVar;
            this.f = i;
            this.g = foVar;
            this.h = i2;
            this.i = z2;
        }

        @Override // defpackage.t03
        public long f() {
            try {
                boolean zC = this.e.l.c(this.f, this.g, this.h, this.i);
                if (zC) {
                    this.e.S0().j0(this.f, ErrorCode.CANCEL);
                }
                if (!zC && !this.i) {
                    return -1L;
                }
                synchronized (this.e) {
                    this.e.G.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class f extends t03 {
        final /* synthetic */ b e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z, b bVar, int i, List list, boolean z2) {
            super(str, z);
            this.e = bVar;
            this.f = i;
            this.g = list;
            this.h = z2;
        }

        @Override // defpackage.t03
        public long f() {
            boolean zB = this.e.l.b(this.f, this.g, this.h);
            if (zB) {
                try {
                    this.e.S0().j0(this.f, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zB && !this.h) {
                return -1L;
            }
            synchronized (this.e) {
                this.e.G.remove(Integer.valueOf(this.f));
            }
            return -1L;
        }
    }

    public static final class g extends t03 {
        final /* synthetic */ b e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z, b bVar, int i, List list) {
            super(str, z);
            this.e = bVar;
            this.f = i;
            this.g = list;
        }

        @Override // defpackage.t03
        public long f() {
            if (!this.e.l.a(this.f, this.g)) {
                return -1L;
            }
            try {
                this.e.S0().j0(this.f, ErrorCode.CANCEL);
                synchronized (this.e) {
                    this.e.G.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class h extends t03 {
        final /* synthetic */ b e;
        final /* synthetic */ int f;
        final /* synthetic */ ErrorCode g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, b bVar, int i, ErrorCode errorCode) {
            super(str, z);
            this.e = bVar;
            this.f = i;
            this.g = errorCode;
        }

        @Override // defpackage.t03
        public long f() {
            this.e.l.d(this.f, this.g);
            synchronized (this.e) {
                this.e.G.remove(Integer.valueOf(this.f));
                k83 k83Var = k83.a;
            }
            return -1L;
        }
    }

    public static final class i extends t03 {
        final /* synthetic */ b e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z, b bVar) {
            super(str, z);
            this.e = bVar;
        }

        @Override // defpackage.t03
        public long f() {
            this.e.l1(false, 2, 0);
            return -1L;
        }
    }

    public static final class j extends t03 {
        final /* synthetic */ b e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, b bVar, long j) {
            super(str, false, 2, null);
            this.e = bVar;
            this.f = j;
        }

        @Override // defpackage.t03
        public long f() {
            boolean z;
            synchronized (this.e) {
                if (this.e.n < this.e.m) {
                    z = true;
                } else {
                    this.e.m++;
                    z = false;
                }
            }
            if (z) {
                this.e.H0(null);
                return -1L;
            }
            this.e.l1(false, 1, 0);
            return this.f;
        }
    }

    public static final class k extends t03 {
        final /* synthetic */ b e;
        final /* synthetic */ int f;
        final /* synthetic */ ErrorCode g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z, b bVar, int i, ErrorCode errorCode) {
            super(str, z);
            this.e = bVar;
            this.f = i;
            this.g = errorCode;
        }

        @Override // defpackage.t03
        public long f() {
            try {
                this.e.m1(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.H0(e);
                return -1L;
            }
        }
    }

    public static final class l extends t03 {
        final /* synthetic */ b e;
        final /* synthetic */ int f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z, b bVar, int i, long j) {
            super(str, z);
            this.e = bVar;
            this.f = i;
            this.g = j;
        }

        @Override // defpackage.t03
        public long f() {
            try {
                this.e.S0().m0(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.H0(e);
                return -1L;
            }
        }
    }

    static {
        nn2 nn2Var = new nn2();
        nn2Var.h(7, 65535);
        nn2Var.h(5, 16384);
        I = nn2Var;
    }

    public b(a aVar) {
        p31.f(aVar, "builder");
        boolean zB = aVar.b();
        this.a = zB;
        this.b = aVar.d();
        this.c = new LinkedHashMap();
        String strC = aVar.c();
        this.d = strC;
        this.f = aVar.b() ? 3 : 2;
        b13 b13VarJ = aVar.j();
        this.h = b13VarJ;
        a13 a13VarI = b13VarJ.i();
        this.i = a13VarI;
        this.j = b13VarJ.i();
        this.k = b13VarJ.i();
        this.l = aVar.f();
        nn2 nn2Var = new nn2();
        if (aVar.b()) {
            nn2Var.h(7, 16777216);
        }
        this.s = nn2Var;
        nn2 nn2Var2 = I;
        this.t = nn2Var2;
        this.x = nn2Var2.c();
        this.y = aVar.h();
        this.z = new okhttp3.internal.http2.d(aVar.g(), zB);
        this.F = new d(this, new okhttp3.internal.http2.c(aVar.i(), zB));
        this.G = new LinkedHashSet();
        if (aVar.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(aVar.e());
            a13VarI.i(new j(strC + " ping", this, nanos), nanos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        G0(errorCode, errorCode, iOException);
    }

    private final jx0 U0(int i2, List list, boolean z) {
        int i3;
        jx0 jx0Var;
        boolean z2 = true;
        boolean z3 = !z;
        synchronized (this.z) {
            try {
                synchronized (this) {
                    try {
                        if (this.f > 1073741823) {
                            f1(ErrorCode.REFUSED_STREAM);
                        }
                        if (this.g) {
                            throw new ConnectionShutdownException();
                        }
                        i3 = this.f;
                        this.f = i3 + 2;
                        jx0Var = new jx0(i3, this, z3, false, null);
                        if (z && this.w < this.x && jx0Var.r() < jx0Var.q()) {
                            z2 = false;
                        }
                        if (jx0Var.u()) {
                            this.c.put(Integer.valueOf(i3), jx0Var);
                        }
                        k83 k83Var = k83.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i2 == 0) {
                    this.z.V(z3, i3, list);
                } else {
                    if (this.a) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.z.g0(i2, i3, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z2) {
            this.z.flush();
        }
        return jx0Var;
    }

    public static /* synthetic */ void h1(b bVar, boolean z, b13 b13Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            b13Var = b13.i;
        }
        bVar.g1(z, b13Var);
    }

    public final void G0(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) {
        int i2;
        Object[] array;
        p31.f(errorCode, "connectionCode");
        p31.f(errorCode2, "streamCode");
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            f1(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.c.isEmpty()) {
                    array = null;
                } else {
                    array = this.c.values().toArray(new jx0[0]);
                    this.c.clear();
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        jx0[] jx0VarArr = (jx0[]) array;
        if (jx0VarArr != null) {
            for (jx0 jx0Var : jx0VarArr) {
                try {
                    jx0Var.d(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.z.close();
        } catch (IOException unused3) {
        }
        try {
            this.y.close();
        } catch (IOException unused4) {
        }
        this.i.n();
        this.j.n();
        this.k.n();
    }

    public final boolean I0() {
        return this.a;
    }

    public final String J0() {
        return this.d;
    }

    public final int K0() {
        return this.e;
    }

    public final c L0() {
        return this.b;
    }

    public final int M0() {
        return this.f;
    }

    public final nn2 N0() {
        return this.s;
    }

    public final nn2 O0() {
        return this.t;
    }

    public final synchronized jx0 P0(int i2) {
        return (jx0) this.c.get(Integer.valueOf(i2));
    }

    public final Map Q0() {
        return this.c;
    }

    public final long R0() {
        return this.x;
    }

    public final okhttp3.internal.http2.d S0() {
        return this.z;
    }

    public final synchronized boolean T0(long j2) {
        if (this.g) {
            return false;
        }
        return this.p >= this.o || j2 < this.r;
    }

    public final jx0 V0(List list, boolean z) {
        p31.f(list, "requestHeaders");
        return U0(0, list, z);
    }

    public final void W0(int i2, so soVar, int i3, boolean z) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        fo foVar = new fo();
        long j2 = i3;
        soVar.B0(j2);
        soVar.read(foVar, j2);
        this.j.i(new e(this.d + '[' + i2 + "] onData", true, this, i2, foVar, i3, z), 0L);
    }

    public final void X0(int i2, List list, boolean z) {
        p31.f(list, "requestHeaders");
        this.j.i(new f(this.d + '[' + i2 + "] onHeaders", true, this, i2, list, z), 0L);
    }

    public final void Y0(int i2, List list) {
        p31.f(list, "requestHeaders");
        synchronized (this) {
            if (this.G.contains(Integer.valueOf(i2))) {
                n1(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.G.add(Integer.valueOf(i2));
            this.j.i(new g(this.d + '[' + i2 + "] onRequest", true, this, i2, list), 0L);
        }
    }

    public final void Z0(int i2, ErrorCode errorCode) {
        p31.f(errorCode, "errorCode");
        this.j.i(new h(this.d + '[' + i2 + "] onReset", true, this, i2, errorCode), 0L);
    }

    public final boolean a1(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public final synchronized jx0 b1(int i2) {
        jx0 jx0Var;
        jx0Var = (jx0) this.c.remove(Integer.valueOf(i2));
        p31.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return jx0Var;
    }

    public final void c1() {
        synchronized (this) {
            long j2 = this.p;
            long j3 = this.o;
            if (j2 < j3) {
                return;
            }
            this.o = j3 + 1;
            this.r = System.nanoTime() + ((long) 1000000000);
            k83 k83Var = k83.a;
            this.i.i(new i(this.d + " ping", true, this), 0L);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        G0(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void d1(int i2) {
        this.e = i2;
    }

    public final void e1(nn2 nn2Var) {
        p31.f(nn2Var, "<set-?>");
        this.t = nn2Var;
    }

    public final void f1(ErrorCode errorCode) {
        p31.f(errorCode, "statusCode");
        synchronized (this.z) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                int i2 = this.e;
                ref$IntRef.element = i2;
                k83 k83Var = k83.a;
                this.z.D(i2, errorCode, pa3.a);
            }
        }
    }

    public final void flush() {
        this.z.flush();
    }

    public final void g1(boolean z, b13 b13Var) {
        p31.f(b13Var, "taskRunner");
        if (z) {
            this.z.u();
            this.z.k0(this.s);
            int iC = this.s.c();
            if (iC != 65535) {
                this.z.m0(0, iC - 65535);
            }
        }
        b13Var.i().i(new z03(this.d, true, this.F), 0L);
    }

    public final synchronized void i1(long j2) {
        long j3 = this.u + j2;
        this.u = j3;
        long j4 = j3 - this.v;
        if (j4 >= this.s.c() / 2) {
            o1(0, j4);
            this.v += j4;
        }
    }

    public final void j1(int i2, boolean z, fo foVar, long j2) {
        long j3;
        long j4;
        int iMin;
        long j5;
        if (j2 == 0) {
            this.z.w(z, i2, foVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j3 = this.w;
                            j4 = this.x;
                            if (j3 >= j4) {
                                if (!this.c.containsKey(Integer.valueOf(i2))) {
                                    throw new IOException("stream closed");
                                }
                                p31.d(this, "null cannot be cast to non-null type java.lang.Object");
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    throw th;
                }
                iMin = Math.min((int) Math.min(j2, j4 - j3), this.z.a0());
                j5 = iMin;
                this.w += j5;
                k83 k83Var = k83.a;
            }
            j2 -= j5;
            this.z.w(z && j2 == 0, i2, foVar, iMin);
        }
    }

    public final void k1(int i2, boolean z, List list) {
        p31.f(list, "alternating");
        this.z.V(z, i2, list);
    }

    public final void l1(boolean z, int i2, int i3) {
        try {
            this.z.e0(z, i2, i3);
        } catch (IOException e2) {
            H0(e2);
        }
    }

    public final void m1(int i2, ErrorCode errorCode) {
        p31.f(errorCode, "statusCode");
        this.z.j0(i2, errorCode);
    }

    public final void n1(int i2, ErrorCode errorCode) {
        p31.f(errorCode, "errorCode");
        this.i.i(new k(this.d + '[' + i2 + "] writeSynReset", true, this, i2, errorCode), 0L);
    }

    public final void o1(int i2, long j2) {
        this.i.i(new l(this.d + '[' + i2 + "] windowUpdate", true, this, i2, j2), 0L);
    }
}
