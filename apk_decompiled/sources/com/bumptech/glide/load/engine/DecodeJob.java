package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.tencent.connect.common.Constants;
import defpackage.ac0;
import defpackage.ak0;
import defpackage.cd1;
import defpackage.e21;
import defpackage.h42;
import defpackage.pu0;
import defpackage.px1;
import defpackage.qg2;
import defpackage.rx1;
import defpackage.tt2;
import defpackage.w81;
import defpackage.xg2;
import defpackage.y50;
import defpackage.yb0;
import defpackage.z43;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DecodeJob implements com.bumptech.glide.load.engine.e.a, Runnable, Comparable, ak0.f {
    private DataSource F;
    private y50 G;
    private volatile com.bumptech.glide.load.engine.e H;
    private volatile boolean I;
    private volatile boolean J;
    private boolean K;
    private final e d;
    private final h42 e;
    private com.bumptech.glide.c h;
    private w81 i;
    private Priority j;
    private k k;
    private int l;
    private int m;
    private ac0 n;
    private rx1 o;
    private b p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f224q;
    private Stage r;
    private RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private w81 x;
    private w81 y;
    private Object z;
    private final com.bumptech.glide.load.engine.f a = new com.bumptech.glide.load.engine.f();
    private final List b = new ArrayList();
    private final tt2 c = tt2.a();
    private final d f = new d();
    private final f g = new f();

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    interface b {
        void a(GlideException glideException);

        void b(DecodeJob decodeJob);

        void c(qg2 qg2Var, DataSource dataSource, boolean z);
    }

    private final class c implements g.a {
        private final DataSource a;

        c(DataSource dataSource) {
            this.a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.g.a
        public qg2 a(qg2 qg2Var) {
            return DecodeJob.this.v(this.a, qg2Var);
        }
    }

    private static class d {
        private w81 a;
        private xg2 b;
        private p c;

        d() {
        }

        void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        void b(e eVar, rx1 rx1Var) {
            pu0.a("DecodeJob.encode");
            try {
                eVar.a().b(this.a, new com.bumptech.glide.load.engine.d(this.b, this.c, rx1Var));
            } finally {
                this.c.f();
                pu0.d();
            }
        }

        boolean c() {
            return this.c != null;
        }

        void d(w81 w81Var, xg2 xg2Var, p pVar) {
            this.a = w81Var;
            this.b = xg2Var;
            this.c = pVar;
        }
    }

    interface e {
        yb0 a();
    }

    private static class f {
        private boolean a;
        private boolean b;
        private boolean c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.c || z || this.b) && this.a;
        }

        synchronized boolean b() {
            this.b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.c = true;
            return a(false);
        }

        synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        synchronized void e() {
            this.b = false;
            this.a = false;
            this.c = false;
        }
    }

    DecodeJob(e eVar, h42 h42Var) {
        this.d = eVar;
        this.e = h42Var;
    }

    private void A() {
        int i = a.a[this.s.ordinal()];
        if (i == 1) {
            this.r = k(Stage.INITIALIZE);
            this.H = j();
            y();
        } else if (i == 2) {
            y();
        } else {
            if (i == 3) {
                i();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private void B() {
        Throwable th;
        this.c.c();
        if (!this.I) {
            this.I = true;
            return;
        }
        if (this.b.isEmpty()) {
            th = null;
        } else {
            List list = this.b;
            th = (Throwable) list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private qg2 g(y50 y50Var, Object obj, DataSource dataSource) {
        if (obj == null) {
            y50Var.b();
            return null;
        }
        try {
            long jB = cd1.b();
            qg2 qg2VarH = h(obj, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + qg2VarH, jB);
            }
            return qg2VarH;
        } finally {
            y50Var.b();
        }
    }

    private qg2 h(Object obj, DataSource dataSource) {
        return z(obj, dataSource, this.a.h(obj.getClass()));
    }

    private void i() {
        qg2 qg2VarG;
        if (Log.isLoggable("DecodeJob", 2)) {
            p("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.G);
        }
        try {
            qg2VarG = g(this.G, this.z, this.F);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.y, this.F);
            this.b.add(e2);
            qg2VarG = null;
        }
        if (qg2VarG != null) {
            r(qg2VarG, this.F, this.K);
        } else {
            y();
        }
    }

    private com.bumptech.glide.load.engine.e j() {
        int i = a.b[this.r.ordinal()];
        if (i == 1) {
            return new q(this.a, this);
        }
        if (i == 2) {
            return new com.bumptech.glide.load.engine.b(this.a, this);
        }
        if (i == 3) {
            return new t(this.a, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    private Stage k(Stage stage) {
        int i = a.b[stage.ordinal()];
        if (i == 1) {
            return this.n.a() ? Stage.DATA_CACHE : k(Stage.DATA_CACHE);
        }
        if (i == 2) {
            return this.u ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i == 3 || i == 4) {
            return Stage.FINISHED;
        }
        if (i == 5) {
            return this.n.b() ? Stage.RESOURCE_CACHE : k(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    private rx1 l(DataSource dataSource) {
        rx1 rx1Var = this.o;
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.a.w();
        px1 px1Var = com.bumptech.glide.load.resource.bitmap.a.j;
        Boolean bool = (Boolean) rx1Var.a(px1Var);
        if (bool != null && (!bool.booleanValue() || z)) {
            return rx1Var;
        }
        rx1 rx1Var2 = new rx1();
        rx1Var2.b(this.o);
        rx1Var2.c(px1Var, Boolean.valueOf(z));
        return rx1Var2;
    }

    private int m() {
        return this.j.ordinal();
    }

    private void o(String str, long j) {
        p(str, j, null);
    }

    private void p(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(cd1.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = Constants.STR_EMPTY;
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void q(qg2 qg2Var, DataSource dataSource, boolean z) {
        B();
        this.p.c(qg2Var, dataSource, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(qg2 qg2Var, DataSource dataSource, boolean z) {
        p pVar;
        if (qg2Var instanceof e21) {
            ((e21) qg2Var).b();
        }
        if (this.f.c()) {
            qg2Var = p.c(qg2Var);
            pVar = qg2Var;
        } else {
            pVar = 0;
        }
        q(qg2Var, dataSource, z);
        this.r = Stage.ENCODE;
        try {
            if (this.f.c()) {
                this.f.b(this.d, this.o);
            }
            if (pVar != 0) {
                pVar.f();
            }
            t();
        } catch (Throwable th) {
            if (pVar != 0) {
                pVar.f();
            }
            throw th;
        }
    }

    private void s() {
        B();
        this.p.a(new GlideException("Failed to load resource", new ArrayList(this.b)));
        u();
    }

    private void t() {
        if (this.g.b()) {
            x();
        }
    }

    private void u() {
        if (this.g.c()) {
            x();
        }
    }

    private void x() {
        this.g.e();
        this.f.a();
        this.a.a();
        this.I = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.H = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.F = null;
        this.G = null;
        this.t = 0L;
        this.J = false;
        this.v = null;
        this.b.clear();
        this.e.a(this);
    }

    private void y() {
        this.w = Thread.currentThread();
        this.t = cd1.b();
        boolean zA = false;
        while (!this.J && this.H != null && !(zA = this.H.a())) {
            this.r = k(this.r);
            this.H = j();
            if (this.r == Stage.SOURCE) {
                d();
                return;
            }
        }
        if ((this.r == Stage.FINISHED || this.J) && !zA) {
            s();
        }
    }

    private qg2 z(Object obj, DataSource dataSource, o oVar) {
        rx1 rx1VarL = l(dataSource);
        com.bumptech.glide.load.data.a aVarL = this.h.i().l(obj);
        try {
            return oVar.a(aVarL, rx1VarL, this.l, this.m, new c(dataSource));
        } finally {
            aVarL.b();
        }
    }

    boolean C() {
        Stage stageK = k(Stage.INITIALIZE);
        return stageK == Stage.RESOURCE_CACHE || stageK == Stage.DATA_CACHE;
    }

    public void a() {
        this.J = true;
        com.bumptech.glide.load.engine.e eVar = this.H;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void b(w81 w81Var, Object obj, y50 y50Var, DataSource dataSource, w81 w81Var2) {
        this.x = w81Var;
        this.z = obj;
        this.G = y50Var;
        this.F = dataSource;
        this.y = w81Var2;
        this.K = w81Var != this.a.c().get(0);
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.DECODE_DATA;
            this.p.b(this);
        } else {
            pu0.a("DecodeJob.decodeFromRetrievedData");
            try {
                i();
            } finally {
                pu0.d();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c(w81 w81Var, Exception exc, y50 y50Var, DataSource dataSource) {
        y50Var.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(w81Var, dataSource, y50Var.a());
        this.b.add(glideException);
        if (Thread.currentThread() == this.w) {
            y();
        } else {
            this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.p.b(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void d() {
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.b(this);
    }

    @Override // ak0.f
    public tt2 e() {
        return this.c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(DecodeJob decodeJob) {
        int iM = m() - decodeJob.m();
        return iM == 0 ? this.f224q - decodeJob.f224q : iM;
    }

    DecodeJob n(com.bumptech.glide.c cVar, Object obj, k kVar, w81 w81Var, int i, int i2, Class cls, Class cls2, Priority priority, ac0 ac0Var, Map map, boolean z, boolean z2, boolean z3, rx1 rx1Var, b bVar, int i3) {
        this.a.u(cVar, obj, w81Var, i, i2, ac0Var, cls, cls2, priority, rx1Var, map, z, z2, this.d);
        this.h = cVar;
        this.i = w81Var;
        this.j = priority;
        this.k = kVar;
        this.l = i;
        this.m = i2;
        this.n = ac0Var;
        this.u = z3;
        this.o = rx1Var;
        this.p = bVar;
        this.f224q = i3;
        this.s = RunReason.INITIALIZE;
        this.v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        pu0.b("DecodeJob#run(model=%s)", this.v);
        y50 y50Var = this.G;
        try {
            try {
                try {
                    if (this.J) {
                        s();
                        if (y50Var != null) {
                            y50Var.b();
                        }
                        pu0.d();
                        return;
                    }
                    A();
                    if (y50Var != null) {
                        y50Var.b();
                    }
                    pu0.d();
                } catch (Throwable th) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.J + ", stage: " + this.r, th);
                    }
                    if (this.r != Stage.ENCODE) {
                        this.b.add(th);
                        s();
                    }
                    if (!this.J) {
                        throw th;
                    }
                    throw th;
                }
            } catch (CallbackException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            if (y50Var != null) {
                y50Var.b();
            }
            pu0.d();
            throw th2;
        }
    }

    qg2 v(DataSource dataSource, qg2 qg2Var) {
        qg2 qg2VarTransform;
        z43 z43Var;
        EncodeStrategy encodeStrategyB;
        w81 cVar;
        Class<?> cls = qg2Var.get().getClass();
        xg2 xg2VarN = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            z43 z43VarR = this.a.r(cls);
            z43Var = z43VarR;
            qg2VarTransform = z43VarR.transform(this.h, qg2Var, this.l, this.m);
        } else {
            qg2VarTransform = qg2Var;
            z43Var = null;
        }
        if (!qg2Var.equals(qg2VarTransform)) {
            qg2Var.a();
        }
        if (this.a.v(qg2VarTransform)) {
            xg2VarN = this.a.n(qg2VarTransform);
            encodeStrategyB = xg2VarN.b(this.o);
        } else {
            encodeStrategyB = EncodeStrategy.NONE;
        }
        xg2 xg2Var = xg2VarN;
        if (!this.n.d(!this.a.x(this.x), dataSource, encodeStrategyB)) {
            return qg2VarTransform;
        }
        if (xg2Var == null) {
            throw new Registry.NoResultEncoderAvailableException(qg2VarTransform.get().getClass());
        }
        int i = a.c[encodeStrategyB.ordinal()];
        if (i == 1) {
            cVar = new com.bumptech.glide.load.engine.c(this.x, this.i);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyB);
            }
            cVar = new r(this.a.b(), this.x, this.i, this.l, this.m, z43Var, cls, this.o);
        }
        p pVarC = p.c(qg2VarTransform);
        this.f.d(cVar, xg2Var, pVarC);
        return pVarC;
    }

    void w(boolean z) {
        if (this.g.d(z)) {
            x();
        }
    }
}
