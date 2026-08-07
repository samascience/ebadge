package defpackage;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class mz2 {
    private static final String b = fd1.f("SystemJobInfoConverter");
    private final ComponentName a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            a = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    mz2(Context context) {
        this.a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(m30.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    static int c(NetworkType networkType) {
        int i = a.a[networkType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        fd1.c().a(b, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
        return 1;
    }

    static void d(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    JobInfo a(xk3 xk3Var, int i) {
        n20 n20Var = xk3Var.j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", xk3Var.a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", xk3Var.d());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.a).setRequiresCharging(n20Var.g()).setRequiresDeviceIdle(n20Var.h()).setExtras(persistableBundle);
        d(extras, n20Var.b());
        if (!n20Var.h()) {
            extras.setBackoffCriteria(xk3Var.m, xk3Var.l == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long jMax = Math.max(xk3Var.a() - System.currentTimeMillis(), 0L);
        if (Build.VERSION.SDK_INT <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!xk3Var.f444q) {
            extras.setImportantWhileForeground(true);
        }
        if (n20Var.e()) {
            Iterator it = n20Var.a().b().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b((m30.a) it.next()));
            }
            extras.setTriggerContentUpdateDelay(n20Var.c());
            extras.setTriggerContentMaxDelay(n20Var.d());
        }
        extras.setPersisted(false);
        extras.setRequiresBatteryNotLow(n20Var.f());
        extras.setRequiresStorageNotLow(n20Var.i());
        boolean z = xk3Var.k > 0;
        boolean z2 = jMax > 0;
        if (to.b() && xk3Var.f444q && !z && !z2) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
