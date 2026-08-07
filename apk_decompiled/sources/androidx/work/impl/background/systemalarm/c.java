package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import defpackage.fd1;
import defpackage.gk3;
import defpackage.xk3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class c {
    private static final String e = fd1.f("ConstraintsCmdHandler");
    private final Context a;
    private final int b;
    private final e c;
    private final gk3 d;

    c(Context context, int i, e eVar) {
        this.a = context;
        this.b = i;
        this.c = eVar;
        this.d = new gk3(context, eVar.f(), null);
    }

    void a() {
        List<xk3> listG = this.c.g().n().k().g();
        ConstraintProxy.a(this.a, listG);
        this.d.d(listG);
        ArrayList arrayList = new ArrayList(listG.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (xk3 xk3Var : listG) {
            String str = xk3Var.a;
            if (jCurrentTimeMillis >= xk3Var.a() && (!xk3Var.b() || this.d.c(str))) {
                arrayList.add(xk3Var);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = ((xk3) it.next()).a;
            Intent intentB = b.b(this.a, str2);
            fd1.c().a(e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            e eVar = this.c;
            eVar.k(new e.b(eVar, intentB, this.b));
        }
        this.d.e();
    }
}
