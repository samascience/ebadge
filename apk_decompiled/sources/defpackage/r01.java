package defpackage;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.k;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.utils.executor.c;
import androidx.camera.core.internal.utils.ImageUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
public class r01 {
    private static int f;
    static final gj0 g = new gj0();
    private final p a;
    private final k b;
    private final mw c;
    private final j72 d;
    private final mw.c e;

    public r01(p pVar, Size size, tt ttVar, boolean z, Size size2, int i) {
        t23.a();
        this.a = pVar;
        this.b = k.a.j(pVar).h();
        mw mwVar = new mw();
        this.c = mwVar;
        Executor executorD0 = pVar.d0(c.d());
        Objects.requireNonNull(executorD0);
        j72 j72Var = new j72(executorD0, null);
        this.d = j72Var;
        int iP = pVar.p();
        int i2 = i();
        pVar.c0();
        mw.c cVarM = mw.c.m(size, iP, i2, z, null, size2, i);
        this.e = cVarM;
        j72Var.x(mwVar.v(cVarM));
    }

    private su b(int i, pv pvVar, i03 i03Var, wz2 wz2Var) {
        ArrayList arrayList = new ArrayList();
        String strValueOf = String.valueOf(pvVar.hashCode());
        List<l> listA = pvVar.a();
        Objects.requireNonNull(listA);
        for (l lVar : listA) {
            k.a aVar = new k.a();
            aVar.v(this.b.k());
            aVar.e(this.b.g());
            aVar.a(i03Var.o());
            aVar.f(this.e.k());
            aVar.t(l());
            if (ImageUtil.i(this.e.d())) {
                if (g.a()) {
                    aVar.d(k.i, Integer.valueOf(i03Var.m()));
                }
                aVar.d(k.j, Integer.valueOf(g(i03Var)));
            }
            aVar.e(lVar.a().g());
            aVar.g(strValueOf, Integer.valueOf(lVar.getId()));
            aVar.r(i);
            aVar.c(this.e.a());
            arrayList.add(aVar.h());
        }
        return new su(arrayList, wz2Var);
    }

    private pv c() {
        pv pvVarY = this.a.Y(qv.b());
        Objects.requireNonNull(pvVarY);
        return pvVarY;
    }

    private k72 d(int i, pv pvVar, i03 i03Var, wz2 wz2Var, ub1 ub1Var) {
        return new k72(pvVar, i03Var.l(), i03Var.h(), i03Var.m(), i03Var.j(), i03Var.n(), wz2Var, ub1Var, i);
    }

    private int i() {
        Integer num = (Integer) this.a.f(p.M, null);
        if (num != null) {
            return num.intValue();
        }
        Integer num2 = (Integer) this.a.f(q.l, null);
        if (num2 == null || num2.intValue() != 4101) {
            return 256;
        }
        return DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
    }

    private boolean l() {
        return this.e.h() != null;
    }

    public void a() {
        t23.a();
        this.c.r();
        this.d.v();
    }

    az1 e(i03 i03Var, wz2 wz2Var, ub1 ub1Var) {
        t23.a();
        pv pvVarC = c();
        int i = f;
        f = i + 1;
        return new az1(b(i, pvVarC, i03Var, wz2Var), d(i, pvVarC, i03Var, wz2Var, ub1Var));
    }

    public SessionConfig.b f(Size size) {
        SessionConfig.b bVarR = SessionConfig.b.r(this.a, size);
        bVarR.i(this.e.k());
        if (this.e.h() != null) {
            bVarR.x(this.e.h());
        }
        return bVarR;
    }

    int g(i03 i03Var) {
        boolean z = i03Var.k() != null;
        boolean zH = y43.h(i03Var.h(), this.e.j());
        if (z && zH) {
            return i03Var.g() == 0 ? 100 : 95;
        }
        return i03Var.j();
    }

    public int h() {
        t23.a();
        return this.c.h();
    }

    void j(d03.b bVar) {
        t23.a();
        this.e.b().accept(bVar);
    }

    public void k(androidx.camera.core.l.a aVar) {
        t23.a();
        this.c.u(aVar);
    }

    void m(k72 k72Var) {
        t23.a();
        this.e.i().accept(k72Var);
    }
}
