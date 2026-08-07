package defpackage;

import android.util.Rational;
import androidx.camera.core.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ie implements dh0 {
    private final dh0 c;
    private final wr0 d;
    private final Map e = new HashMap();

    public ie(dh0 dh0Var, wr0 wr0Var) {
        this.c = dh0Var;
        this.d = wr0Var;
    }

    private eh0 c(eh0 eh0Var, int i, int i2) {
        eh0.c cVar;
        if (eh0Var == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(eh0Var.d());
        Iterator it = eh0Var.d().iterator();
        do {
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            cVar = (eh0.c) it.next();
        } while (cVar.g() != 0);
        eh0.c cVarK = k(g(cVar, i, i2), this.d);
        if (cVarK != null) {
            arrayList.add(cVarK);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return eh0.b.h(eh0Var.a(), eh0Var.b(), eh0Var.c(), arrayList);
    }

    private static int d(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            return 5;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i);
    }

    private static String e(int i) {
        return eh0.g(i);
    }

    private static int f(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 4096;
        }
        if (i == 3) {
            return 8192;
        }
        if (i == 4) {
            return -1;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i);
    }

    private static eh0.c g(eh0.c cVar, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        int iE = cVar.e();
        String strI = cVar.i();
        int iJ = cVar.j();
        if (i != cVar.g()) {
            iE = d(i);
            strI = e(iE);
            iJ = f(i);
        }
        return eh0.c.a(iE, strI, j(cVar.c(), i2, cVar.b()), cVar.f(), cVar.k(), cVar.h(), iJ, i2, cVar.d(), i);
    }

    private eh0 h(int i) {
        if (this.e.containsKey(Integer.valueOf(i))) {
            return (eh0) this.e.get(Integer.valueOf(i));
        }
        if (!this.c.a(i)) {
            return null;
        }
        eh0 eh0VarC = c(this.c.b(i), 1, 10);
        this.e.put(Integer.valueOf(i), eh0VarC);
        return eh0VarC;
    }

    private static eh0.c i(eh0.c cVar, int i) {
        return eh0.c.a(cVar.e(), cVar.i(), i, cVar.f(), cVar.k(), cVar.h(), cVar.j(), cVar.b(), cVar.d(), cVar.g());
    }

    private static int j(int i, int i2, int i3) {
        if (i2 == i3) {
            return i;
        }
        int iDoubleValue = (int) (((double) i) * new Rational(i2, i3).doubleValue());
        if (x.f("BackupHdrProfileEncoderProfilesProvider")) {
            x.a("BackupHdrProfileEncoderProfilesProvider", String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iDoubleValue)));
        }
        return iDoubleValue;
    }

    static eh0.c k(eh0.c cVar, wr0 wr0Var) {
        if (cVar == null) {
            return null;
        }
        kc3 kc3VarF = yb3.f(cVar);
        pc3 pc3Var = (pc3) wr0Var.apply(kc3VarF);
        if (pc3Var == null || !pc3Var.a(cVar.k(), cVar.h())) {
            return null;
        }
        int iE = kc3VarF.e();
        int iIntValue = ((Integer) pc3Var.c().clamp(Integer.valueOf(iE))).intValue();
        return iIntValue == iE ? cVar : i(cVar, iIntValue);
    }

    @Override // defpackage.dh0
    public boolean a(int i) {
        return this.c.a(i) && h(i) != null;
    }

    @Override // defpackage.dh0
    public eh0 b(int i) {
        return h(i);
    }
}
