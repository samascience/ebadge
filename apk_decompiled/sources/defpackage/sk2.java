package defpackage;

import android.content.Context;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class sk2 {
    private static final String a = fd1.f("Schedulers");

    static rk2 a(Context context, nk3 nk3Var) {
        nz2 nz2Var = new nz2(context, nk3Var);
        sy1.a(context, SystemJobService.class, true);
        fd1.c().a(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        return nz2Var;
    }

    public static void b(a aVar, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        yk3 yk3VarK = workDatabase.k();
        workDatabase.beginTransaction();
        try {
            List listF = yk3VarK.f(aVar.h());
            List listS = yk3VarK.s(200);
            if (listF != null && listF.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator it = listF.iterator();
                while (it.hasNext()) {
                    yk3VarK.c(((xk3) it.next()).a, jCurrentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (listF != null && listF.size() > 0) {
                xk3[] xk3VarArr = (xk3[]) listF.toArray(new xk3[listF.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    rk2 rk2Var = (rk2) it2.next();
                    if (rk2Var.a()) {
                        rk2Var.e(xk3VarArr);
                    }
                }
            }
            if (listS == null || listS.size() <= 0) {
                return;
            }
            xk3[] xk3VarArr2 = (xk3[]) listS.toArray(new xk3[listS.size()]);
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                rk2 rk2Var2 = (rk2) it3.next();
                if (!rk2Var2.a()) {
                    rk2Var2.e(xk3VarArr2);
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
