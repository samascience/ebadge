package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkInfo$State;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import defpackage.ap0;
import defpackage.fd1;
import defpackage.jk3;
import defpackage.nk3;
import defpackage.nz2;
import defpackage.sk2;
import defpackage.tk3;
import defpackage.to;
import defpackage.xk3;
import defpackage.yk3;
import defpackage.z62;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {
    private static final String d = fd1.f("ForceStopRunnable");
    private static final long e = TimeUnit.DAYS.toMillis(3650);
    private final Context a;
    private final nk3 b;
    private int c = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String a = fd1.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            fd1.c().g(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, nk3 nk3Var) {
        this.a = context.getApplicationContext();
        this.b = nk3Var;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, c(context), i);
    }

    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent pendingIntentD = d(context, to.b() ? 167772160 : 134217728);
        long jCurrentTimeMillis = System.currentTimeMillis() + e;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, pendingIntentD);
        }
    }

    public boolean a() {
        boolean zI = nz2.i(this.a, this.b);
        WorkDatabase workDatabaseN = this.b.n();
        yk3 yk3VarK = workDatabaseN.k();
        tk3 tk3VarJ = workDatabaseN.j();
        workDatabaseN.beginTransaction();
        try {
            List<xk3> listI = yk3VarK.i();
            boolean z = (listI == null || listI.isEmpty()) ? false : true;
            if (z) {
                for (xk3 xk3Var : listI) {
                    yk3VarK.b(WorkInfo$State.ENQUEUED, xk3Var.a);
                    yk3VarK.c(xk3Var.a, -1L);
                }
            }
            tk3VarJ.b();
            workDatabaseN.setTransactionSuccessful();
            workDatabaseN.endTransaction();
            return z || zI;
        } catch (Throwable th) {
            workDatabaseN.endTransaction();
            throw th;
        }
    }

    public void b() {
        boolean zA = a();
        if (h()) {
            fd1.c().a(d, "Rescheduling Workers.", new Throwable[0]);
            this.b.r();
            this.b.k().c(false);
        } else if (e()) {
            fd1.c().a(d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.b.r();
        } else if (zA) {
            fd1.c().a(d, "Found unfinished work, scheduling it.", new Throwable[0]);
            sk2.b(this.b.h(), this.b.n(), this.b.m());
        }
    }

    public boolean e() {
        try {
            PendingIntent pendingIntentD = d(this.a, to.b() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (pendingIntentD != null) {
                    pendingIntentD.cancel();
                }
                List historicalProcessExitReasons = ((ActivityManager) this.a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i = 0; i < historicalProcessExitReasons.size(); i++) {
                        if (ap0.a(historicalProcessExitReasons.get(i)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntentD == null) {
                g(this.a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e = e2;
            fd1.c().h(d, "Ignoring exception", e);
            return true;
        } catch (SecurityException e3) {
            e = e3;
            fd1.c().h(d, "Ignoring exception", e);
            return true;
        }
    }

    public boolean f() {
        a aVarH = this.b.h();
        if (TextUtils.isEmpty(aVarH.c())) {
            fd1.c().a(d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean zB = z62.b(this.a, aVarH);
        fd1.c().a(d, String.format("Is default app process = %s", Boolean.valueOf(zB)), new Throwable[0]);
        return zB;
    }

    boolean h() {
        return this.b.k().a();
    }

    public void i(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        try {
            if (!f()) {
                this.b.q();
                return;
            }
            while (true) {
                jk3.e(this.a);
                fd1.c().a(d, "Performing cleanup operations.", new Throwable[0]);
                try {
                    b();
                    this.b.q();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    i = this.c + 1;
                    this.c = i;
                    if (i >= 3) {
                        fd1.c().b(d, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        this.b.h().d();
                        throw illegalStateException;
                    }
                    fd1.c().a(d, String.format("Retrying after %s", Long.valueOf(((long) i) * 300)), e2);
                    i(((long) this.c) * 300);
                }
                fd1.c().a(d, String.format("Retrying after %s", Long.valueOf(((long) i) * 300)), e2);
                i(((long) this.c) * 300);
            }
        } catch (Throwable th) {
            this.b.q();
            throw th;
        }
    }
}
