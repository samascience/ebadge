package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.ac0;
import defpackage.ak0;
import defpackage.cd1;
import defpackage.h42;
import defpackage.ji1;
import defpackage.nu0;
import defpackage.qg2;
import defpackage.rx1;
import defpackage.sg2;
import defpackage.w81;
import defpackage.yb0;
import defpackage.z42;
import defpackage.zb0;
import java.util.Map;
import java.util.concurrent.Executor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class h implements j, ji1.a, m.a {
    private static final boolean i = Log.isLoggable("Engine", 2);
    private final n a;
    private final l b;
    private final ji1 c;
    private final b d;
    private final s e;
    private final c f;
    private final a g;
    private final com.bumptech.glide.load.engine.a h;

    static class a {
        final DecodeJob.e a;
        final h42 b = ak0.d(Opcodes.FCMPG, new C0064a());
        private int c;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.h$a$a, reason: collision with other inner class name */
        class C0064a implements ak0.d {
            C0064a() {
            }

            @Override // ak0.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DecodeJob create() {
                a aVar = a.this;
                return new DecodeJob(aVar.a, aVar.b);
            }
        }

        a(DecodeJob.e eVar) {
            this.a = eVar;
        }

        DecodeJob a(com.bumptech.glide.c cVar, Object obj, k kVar, w81 w81Var, int i, int i2, Class cls, Class cls2, Priority priority, ac0 ac0Var, Map map, boolean z, boolean z2, boolean z3, rx1 rx1Var, DecodeJob.b bVar) {
            DecodeJob decodeJob = (DecodeJob) z42.d((DecodeJob) this.b.b());
            int i3 = this.c;
            this.c = i3 + 1;
            return decodeJob.n(cVar, obj, kVar, w81Var, i, i2, cls, cls2, priority, ac0Var, map, z, z2, z3, rx1Var, bVar, i3);
        }
    }

    static class b {
        final nu0 a;
        final nu0 b;
        final nu0 c;
        final nu0 d;
        final j e;
        final m.a f;
        final h42 g = ak0.d(Opcodes.FCMPG, new a());

        class a implements ak0.d {
            a() {
            }

            @Override // ak0.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i create() {
                b bVar = b.this;
                return new i(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        b(nu0 nu0Var, nu0 nu0Var2, nu0 nu0Var3, nu0 nu0Var4, j jVar, m.a aVar) {
            this.a = nu0Var;
            this.b = nu0Var2;
            this.c = nu0Var3;
            this.d = nu0Var4;
            this.e = jVar;
            this.f = aVar;
        }

        i a(w81 w81Var, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((i) z42.d((i) this.g.b())).l(w81Var, z, z2, z3, z4);
        }
    }

    private static class c implements DecodeJob.e {
        private final yb0.a a;
        private volatile yb0 b;

        c(yb0.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.e
        public yb0 a() {
            if (this.b == null) {
                synchronized (this) {
                    try {
                        if (this.b == null) {
                            this.b = this.a.a();
                        }
                        if (this.b == null) {
                            this.b = new zb0();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.b;
        }
    }

    public class d {
        private final i a;
        private final sg2 b;

        d(sg2 sg2Var, i iVar) {
            this.b = sg2Var;
            this.a = iVar;
        }

        public void a() {
            synchronized (h.this) {
                this.a.r(this.b);
            }
        }
    }

    public h(ji1 ji1Var, yb0.a aVar, nu0 nu0Var, nu0 nu0Var2, nu0 nu0Var3, nu0 nu0Var4, boolean z) {
        this(ji1Var, aVar, nu0Var, nu0Var2, nu0Var3, nu0Var4, null, null, null, null, null, null, z);
    }

    private m e(w81 w81Var) {
        qg2 qg2VarE = this.c.e(w81Var);
        if (qg2VarE == null) {
            return null;
        }
        return qg2VarE instanceof m ? (m) qg2VarE : new m(qg2VarE, true, true, w81Var, this);
    }

    private m g(w81 w81Var) {
        m mVarE = this.h.e(w81Var);
        if (mVarE != null) {
            mVarE.b();
        }
        return mVarE;
    }

    private m h(w81 w81Var) {
        m mVarE = e(w81Var);
        if (mVarE != null) {
            mVarE.b();
            this.h.a(w81Var, mVarE);
        }
        return mVarE;
    }

    private m i(k kVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        m mVarG = g(kVar);
        if (mVarG != null) {
            if (i) {
                j("Loaded resource from active resources", j, kVar);
            }
            return mVarG;
        }
        m mVarH = h(kVar);
        if (mVarH == null) {
            return null;
        }
        if (i) {
            j("Loaded resource from cache", j, kVar);
        }
        return mVarH;
    }

    private static void j(String str, long j, w81 w81Var) {
        Log.v("Engine", str + " in " + cd1.a(j) + "ms, key: " + w81Var);
    }

    private d l(com.bumptech.glide.c cVar, Object obj, w81 w81Var, int i2, int i3, Class cls, Class cls2, Priority priority, ac0 ac0Var, Map map, boolean z, boolean z2, rx1 rx1Var, boolean z3, boolean z4, boolean z5, boolean z6, sg2 sg2Var, Executor executor, k kVar, long j) {
        i iVarA = this.a.a(kVar, z6);
        if (iVarA != null) {
            iVarA.d(sg2Var, executor);
            if (i) {
                j("Added to existing load", j, kVar);
            }
            return new d(sg2Var, iVarA);
        }
        i iVarA2 = this.d.a(kVar, z3, z4, z5, z6);
        DecodeJob decodeJobA = this.g.a(cVar, obj, kVar, w81Var, i2, i3, cls, cls2, priority, ac0Var, map, z, z2, z6, rx1Var, iVarA2);
        this.a.c(kVar, iVarA2);
        iVarA2.d(sg2Var, executor);
        iVarA2.s(decodeJobA);
        if (i) {
            j("Started new load", j, kVar);
        }
        return new d(sg2Var, iVarA2);
    }

    @Override // com.bumptech.glide.load.engine.j
    public synchronized void a(i iVar, w81 w81Var) {
        this.a.d(w81Var, iVar);
    }

    @Override // com.bumptech.glide.load.engine.m.a
    public void b(w81 w81Var, m mVar) {
        this.h.d(w81Var);
        if (mVar.d()) {
            this.c.c(w81Var, mVar);
        } else {
            this.e.a(mVar, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.j
    public synchronized void c(i iVar, w81 w81Var, m mVar) {
        if (mVar != null) {
            try {
                if (mVar.d()) {
                    this.h.a(w81Var, mVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.d(w81Var, iVar);
    }

    @Override // ji1.a
    public void d(qg2 qg2Var) {
        this.e.a(qg2Var, true);
    }

    public d f(com.bumptech.glide.c cVar, Object obj, w81 w81Var, int i2, int i3, Class cls, Class cls2, Priority priority, ac0 ac0Var, Map map, boolean z, boolean z2, rx1 rx1Var, boolean z3, boolean z4, boolean z5, boolean z6, sg2 sg2Var, Executor executor) {
        long jB = i ? cd1.b() : 0L;
        k kVarA = this.b.a(obj, w81Var, i2, i3, map, cls, cls2, rx1Var);
        synchronized (this) {
            try {
                m mVarI = i(kVarA, z3, jB);
                if (mVarI == null) {
                    return l(cVar, obj, w81Var, i2, i3, cls, cls2, priority, ac0Var, map, z, z2, rx1Var, z3, z4, z5, z6, sg2Var, executor, kVarA, jB);
                }
                sg2Var.c(mVarI, DataSource.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(qg2 qg2Var) {
        if (!(qg2Var instanceof m)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((m) qg2Var).e();
    }

    h(ji1 ji1Var, yb0.a aVar, nu0 nu0Var, nu0 nu0Var2, nu0 nu0Var3, nu0 nu0Var4, n nVar, l lVar, com.bumptech.glide.load.engine.a aVar2, b bVar, a aVar3, s sVar, boolean z) {
        this.c = ji1Var;
        c cVar = new c(aVar);
        this.f = cVar;
        com.bumptech.glide.load.engine.a aVar4 = aVar2 == null ? new com.bumptech.glide.load.engine.a(z) : aVar2;
        this.h = aVar4;
        aVar4.f(this);
        this.b = lVar == null ? new l() : lVar;
        this.a = nVar == null ? new n() : nVar;
        this.d = bVar == null ? new b(nu0Var, nu0Var2, nu0Var3, nu0Var4, this, this) : bVar;
        this.g = aVar3 == null ? new a(cVar) : aVar3;
        this.e = sVar == null ? new s() : sVar;
        ji1Var.d(this);
    }
}
