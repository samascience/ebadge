package defpackage;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class rh0 implements Runnable {
    private static final String c = fd1.f("EnqueueRunnable");
    private final ik3 a;
    private final vw1 b = new vw1();

    public rh0(ik3 ik3Var) {
        this.a = ik3Var;
    }

    private static boolean b(ik3 ik3Var) {
        boolean zC = c(ik3Var.g(), ik3Var.f(), (String[]) ik3.l(ik3Var).toArray(new String[0]), ik3Var.d(), ik3Var.b());
        ik3Var.k();
        return zC;
    }

    /* JADX WARN: Code duplicated, block: B:82:0x0137 A[PHI: r0 r8 r11 r12 r13
      0x0137: PHI (r0v1 java.lang.String[]) = 
      (r0v0 java.lang.String[])
      (r0v0 java.lang.String[])
      (r0v0 java.lang.String[])
      (r0v13 java.lang.String[])
      (r0v13 java.lang.String[])
     binds: [B:28:0x0061, B:29:0x0063, B:31:0x0071, B:81:0x0136, B:80:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r8v2 boolean) = (r8v1 boolean), (r8v1 boolean), (r8v1 boolean), (r8v5 boolean), (r8v6 boolean) binds: [B:28:0x0061, B:29:0x0063, B:31:0x0071, B:81:0x0136, B:80:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r11v2 boolean) = (r11v1 boolean), (r11v1 boolean), (r11v1 boolean), (r11v4 boolean), (r11v4 boolean) binds: [B:28:0x0061, B:29:0x0063, B:31:0x0071, B:81:0x0136, B:80:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r12v2 boolean) = (r12v1 boolean), (r12v1 boolean), (r12v1 boolean), (r12v5 boolean), (r12v5 boolean) binds: [B:28:0x0061, B:29:0x0063, B:31:0x0071, B:81:0x0136, B:80:0x0134] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r13v2 boolean) = (r13v1 boolean), (r13v1 boolean), (r13v1 boolean), (r13v5 boolean), (r13v5 boolean) binds: [B:28:0x0061, B:29:0x0063, B:31:0x0071, B:81:0x0136, B:80:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    private static boolean c(nk3 nk3Var, List list, String[] strArr, String str, ExistingWorkPolicy existingWorkPolicy) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String[] strArr2 = strArr;
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabaseN = nk3Var.n();
        boolean z5 = strArr2 != null && strArr2.length > 0;
        if (z5) {
            z = false;
            z2 = false;
            z3 = true;
            for (String str2 : strArr2) {
                xk3 xk3VarM = workDatabaseN.k().m(str2);
                if (xk3VarM == null) {
                    fd1.c().b(c, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                WorkInfo$State workInfo$State = xk3VarM.b;
                z3 &= workInfo$State == WorkInfo$State.SUCCEEDED;
                if (workInfo$State == WorkInfo$State.FAILED) {
                    z2 = true;
                } else if (workInfo$State == WorkInfo$State.CANCELLED) {
                    z = true;
                }
            }
        } else {
            z = false;
            z2 = false;
            z3 = true;
        }
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (zIsEmpty || z5) {
            z4 = false;
        } else {
            List<xk3.b> listD = workDatabaseN.k().d(str);
            if (listD.isEmpty()) {
                z4 = false;
            } else if (existingWorkPolicy == ExistingWorkPolicy.APPEND || existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE) {
                k90 k90VarC = workDatabaseN.c();
                List arrayList = new ArrayList();
                for (xk3.b bVar : listD) {
                    if (!k90VarC.d(bVar.a)) {
                        WorkInfo$State workInfo$State2 = bVar.b;
                        boolean z6 = (workInfo$State2 == WorkInfo$State.SUCCEEDED) & z3;
                        if (workInfo$State2 == WorkInfo$State.FAILED) {
                            z2 = true;
                        } else if (workInfo$State2 == WorkInfo$State.CANCELLED) {
                            z = true;
                        }
                        arrayList.add(bVar.a);
                        z3 = z6;
                    }
                }
                if (existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE && (z || z2)) {
                    yk3 yk3VarK = workDatabaseN.k();
                    Iterator it = yk3VarK.d(str).iterator();
                    while (it.hasNext()) {
                        yk3VarK.a(((xk3.b) it.next()).a);
                    }
                    arrayList = Collections.emptyList();
                    z = false;
                    z2 = false;
                }
                strArr2 = (String[]) arrayList.toArray(strArr2);
                z5 = strArr2.length > 0;
                z4 = false;
            } else {
                if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                    Iterator it2 = listD.iterator();
                    while (it2.hasNext()) {
                        WorkInfo$State workInfo$State3 = ((xk3.b) it2.next()).b;
                        if (workInfo$State3 == WorkInfo$State.ENQUEUED || workInfo$State3 == WorkInfo$State.RUNNING) {
                            return false;
                        }
                    }
                }
                gv.c(str, nk3Var, false).run();
                yk3 yk3VarK2 = workDatabaseN.k();
                Iterator it3 = listD.iterator();
                while (it3.hasNext()) {
                    yk3VarK2.a(((xk3.b) it3.next()).a);
                }
                z4 = true;
            }
        }
        Iterator it4 = list.iterator();
        while (it4.hasNext()) {
            wk3 wk3Var = (wk3) it4.next();
            xk3 xk3VarC = wk3Var.c();
            if (!z5 || z3) {
                if (xk3VarC.d()) {
                    xk3VarC.n = 0L;
                } else {
                    xk3VarC.n = jCurrentTimeMillis;
                }
            } else if (z2) {
                xk3VarC.b = WorkInfo$State.FAILED;
            } else if (z) {
                xk3VarC.b = WorkInfo$State.CANCELLED;
            } else {
                xk3VarC.b = WorkInfo$State.BLOCKED;
            }
            if (xk3VarC.b == WorkInfo$State.ENQUEUED) {
                z4 = true;
            }
            workDatabaseN.k().o(xk3VarC);
            if (z5) {
                int length = strArr2.length;
                int i = 0;
                while (i < length) {
                    workDatabaseN.c().c(new i90(wk3Var.a(), strArr2[i]));
                    i++;
                    strArr2 = strArr2;
                    it4 = it4;
                }
            }
            String[] strArr3 = strArr2;
            Iterator it5 = it4;
            Iterator it6 = wk3Var.b().iterator();
            while (it6.hasNext()) {
                workDatabaseN.l().a(new al3((String) it6.next(), wk3Var.a()));
            }
            if (!zIsEmpty) {
                workDatabaseN.i().a(new pk3(str, wk3Var.a()));
            }
            strArr2 = strArr3;
            it4 = it5;
        }
        return z4;
    }

    private static boolean e(ik3 ik3Var) {
        List<ik3> listE = ik3Var.e();
        boolean z = false;
        if (listE != null) {
            boolean zE = false;
            for (ik3 ik3Var2 : listE) {
                if (ik3Var2.j()) {
                    fd1.c().h(c, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", ik3Var2.c())), new Throwable[0]);
                } else {
                    zE |= e(ik3Var2);
                }
            }
            z = zE;
        }
        return b(ik3Var) | z;
    }

    public boolean a() {
        WorkDatabase workDatabaseN = this.a.g().n();
        workDatabaseN.beginTransaction();
        try {
            boolean zE = e(this.a);
            workDatabaseN.setTransactionSuccessful();
            return zE;
        } finally {
            workDatabaseN.endTransaction();
        }
    }

    public tw1 d() {
        return this.b;
    }

    public void f() {
        nk3 nk3VarG = this.a.g();
        sk2.b(nk3VarG.h(), nk3VarG.n(), nk3VarG.m());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.h()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.a));
            }
            if (a()) {
                sy1.a(this.a.g().g(), RescheduleReceiver.class, true);
                f();
            }
            this.b.a(tw1.a);
        } catch (Throwable th) {
            this.b.a(new tw1.b.a(th));
        }
    }
}
