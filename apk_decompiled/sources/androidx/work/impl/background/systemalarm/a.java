package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import defpackage.fd1;
import defpackage.gz2;
import defpackage.hz2;
import defpackage.nk3;
import defpackage.zy0;

/* JADX INFO: loaded from: classes.dex */
abstract class a {
    private static final String a = fd1.f("Alarms");

    public static void a(Context context, nk3 nk3Var, String str) {
        hz2 hz2VarH = nk3Var.n().h();
        gz2 gz2VarC = hz2VarH.c(str);
        if (gz2VarC != null) {
            b(context, str, gz2VarC.b);
            fd1.c().a(a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            hz2VarH.d(str);
        }
    }

    private static void b(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        fd1.c().a(a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void c(Context context, nk3 nk3Var, String str, long j) {
        WorkDatabase workDatabaseN = nk3Var.n();
        hz2 hz2VarH = workDatabaseN.h();
        gz2 gz2VarC = hz2VarH.c(str);
        if (gz2VarC != null) {
            b(context, str, gz2VarC.b);
            d(context, str, gz2VarC.b, j);
        } else {
            int iB = new zy0(workDatabaseN).b();
            hz2VarH.b(new gz2(str, iB));
            d(context, str, iB, j);
        }
    }

    private static void d(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 201326592);
        if (alarmManager != null) {
            alarmManager.setExact(0, j, service);
        }
    }
}
