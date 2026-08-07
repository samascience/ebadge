package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import defpackage.bl3;
import defpackage.fd1;
import defpackage.gz2;
import defpackage.hz2;
import defpackage.nk3;
import defpackage.qk3;
import defpackage.xk3;
import defpackage.yk3;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {
    private static final String g = fd1.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String r(xk3 xk3Var, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", xk3Var.a, xk3Var.c, num, xk3Var.b.name(), str, str2);
    }

    private static String s(qk3 qk3Var, bl3 bl3Var, hz2 hz2Var, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", "Job Id"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            xk3 xk3Var = (xk3) it.next();
            gz2 gz2VarC = hz2Var.c(xk3Var.a);
            sb.append(r(xk3Var, TextUtils.join(",", qk3Var.b(xk3Var.a)), gz2VarC != null ? Integer.valueOf(gz2VarC.b) : null, TextUtils.join(",", bl3Var.b(xk3Var.a))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a q() {
        WorkDatabase workDatabaseN = nk3.j(a()).n();
        yk3 yk3VarK = workDatabaseN.k();
        qk3 qk3VarI = workDatabaseN.i();
        bl3 bl3VarL = workDatabaseN.l();
        hz2 hz2VarH = workDatabaseN.h();
        List listE = yk3VarK.e(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List listI = yk3VarK.i();
        List listS = yk3VarK.s(200);
        if (listE != null && !listE.isEmpty()) {
            fd1 fd1VarC = fd1.c();
            String str = g;
            fd1VarC.d(str, "Recently completed work:\n\n", new Throwable[0]);
            fd1.c().d(str, s(qk3VarI, bl3VarL, hz2VarH, listE), new Throwable[0]);
        }
        if (listI != null && !listI.isEmpty()) {
            fd1 fd1VarC2 = fd1.c();
            String str2 = g;
            fd1VarC2.d(str2, "Running work:\n\n", new Throwable[0]);
            fd1.c().d(str2, s(qk3VarI, bl3VarL, hz2VarH, listI), new Throwable[0]);
        }
        if (listS != null && !listS.isEmpty()) {
            fd1 fd1VarC3 = fd1.c();
            String str3 = g;
            fd1VarC3.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            fd1.c().d(str3, s(qk3VarI, bl3VarL, hz2VarH, listS), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
