package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class nz2 implements rk2 {
    private static final String e = fd1.f("SystemJobScheduler");
    private final Context a;
    private final JobScheduler b;
    private final nk3 c;
    private final mz2 d;

    public nz2(Context context, nk3 nk3Var) {
        this(context, nk3Var, (JobScheduler) context.getSystemService("jobscheduler"), new mz2(context));
    }

    public static void b(Context context) {
        List listG;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (listG = g(context, jobScheduler)) == null || listG.isEmpty()) {
            return;
        }
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            c(jobScheduler, ((JobInfo) it.next()).getId());
        }
    }

    private static void c(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            fd1.c().b(e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    private static List f(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> listG = g(context, jobScheduler);
        if (listG == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : listG) {
            if (str.equals(h(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            fd1.c().b(e, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static String h(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(Context context, nk3 nk3Var) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> listG = g(context, jobScheduler);
        List listA = nk3Var.n().h().a();
        boolean z = false;
        HashSet hashSet = new HashSet(listG != null ? listG.size() : 0);
        if (listG != null && !listG.isEmpty()) {
            for (JobInfo jobInfo : listG) {
                String strH = h(jobInfo);
                if (TextUtils.isEmpty(strH)) {
                    c(jobScheduler, jobInfo.getId());
                } else {
                    hashSet.add(strH);
                }
            }
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains((String) it.next())) {
                fd1.c().a(e, "Reconciling jobs", new Throwable[0]);
                z = true;
                break;
            }
        }
        if (z) {
            WorkDatabase workDatabaseN = nk3Var.n();
            workDatabaseN.beginTransaction();
            try {
                yk3 yk3VarK = workDatabaseN.k();
                Iterator it2 = listA.iterator();
                while (it2.hasNext()) {
                    yk3VarK.c((String) it2.next(), -1L);
                }
                workDatabaseN.setTransactionSuccessful();
            } finally {
                workDatabaseN.endTransaction();
            }
        }
        return z;
    }

    @Override // defpackage.rk2
    public boolean a() {
        return true;
    }

    @Override // defpackage.rk2
    public void d(String str) {
        List listF = f(this.a, this.b, str);
        if (listF == null || listF.isEmpty()) {
            return;
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            c(this.b, ((Integer) it.next()).intValue());
        }
        this.c.n().h().d(str);
    }

    @Override // defpackage.rk2
    public void e(xk3... xk3VarArr) {
        WorkDatabase workDatabaseN = this.c.n();
        zy0 zy0Var = new zy0(workDatabaseN);
        for (xk3 xk3Var : xk3VarArr) {
            workDatabaseN.beginTransaction();
            try {
                xk3 xk3VarM = workDatabaseN.k().m(xk3Var.a);
                if (xk3VarM == null) {
                    fd1.c().h(e, "Skipping scheduling " + xk3Var.a + " because it's no longer in the DB", new Throwable[0]);
                    workDatabaseN.setTransactionSuccessful();
                } else if (xk3VarM.b != WorkInfo$State.ENQUEUED) {
                    fd1.c().h(e, "Skipping scheduling " + xk3Var.a + " because it is no longer enqueued", new Throwable[0]);
                    workDatabaseN.setTransactionSuccessful();
                } else {
                    gz2 gz2VarC = workDatabaseN.h().c(xk3Var.a);
                    int iD = gz2VarC != null ? gz2VarC.b : zy0Var.d(this.c.h().i(), this.c.h().g());
                    if (gz2VarC == null) {
                        this.c.n().h().b(new gz2(xk3Var.a, iD));
                    }
                    j(xk3Var, iD);
                    workDatabaseN.setTransactionSuccessful();
                }
                workDatabaseN.endTransaction();
            } catch (Throwable th) {
                workDatabaseN.endTransaction();
                throw th;
            }
        }
    }

    public void j(xk3 xk3Var, int i) {
        JobInfo jobInfoA = this.d.a(xk3Var, i);
        fd1 fd1VarC = fd1.c();
        String str = e;
        fd1VarC.a(str, String.format("Scheduling work ID %s Job ID %s", xk3Var.a, Integer.valueOf(i)), new Throwable[0]);
        try {
            if (this.b.schedule(jobInfoA) == 0) {
                fd1.c().h(str, String.format("Unable to schedule work ID %s", xk3Var.a), new Throwable[0]);
                if (xk3Var.f444q && xk3Var.r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    xk3Var.f444q = false;
                    fd1.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", xk3Var.a), new Throwable[0]);
                    j(xk3Var, i);
                }
            }
        } catch (IllegalStateException e2) {
            List listG = g(this.a, this.b);
            String str2 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(listG != null ? listG.size() : 0), Integer.valueOf(this.c.n().k().g().size()), Integer.valueOf(this.c.h().h()));
            fd1.c().b(e, str2, new Throwable[0]);
            throw new IllegalStateException(str2, e2);
        } catch (Throwable th) {
            fd1.c().b(e, String.format("Unable to schedule %s", xk3Var), th);
        }
    }

    public nz2(Context context, nk3 nk3Var, JobScheduler jobScheduler, mz2 mz2Var) {
        this.a = context;
        this.c = nk3Var;
        this.b = jobScheduler;
        this.d = mz2Var;
    }
}
