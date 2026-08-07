package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public class zy0 {
    private final WorkDatabase a;

    public zy0(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void a(Context context, ow2 ow2Var) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i2 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            ow2Var.d();
            try {
                ow2Var.k("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                ow2Var.k("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                sharedPreferences.edit().clear().apply();
                ow2Var.j();
            } finally {
                ow2Var.l();
            }
        }
    }

    private int c(String str) {
        this.a.beginTransaction();
        try {
            Long lA = this.a.g().a(str);
            int i = 0;
            int iIntValue = lA != null ? lA.intValue() : 0;
            if (iIntValue != Integer.MAX_VALUE) {
                i = iIntValue + 1;
            }
            e(str, i);
            this.a.setTransactionSuccessful();
            return iIntValue;
        } finally {
            this.a.endTransaction();
        }
    }

    private void e(String str, int i) {
        this.a.g().b(new c52(str, i));
    }

    public int b() {
        int iC;
        synchronized (zy0.class) {
            iC = c("next_alarm_manager_id");
        }
        return iC;
    }

    public int d(int i, int i2) {
        synchronized (zy0.class) {
            int iC = c("next_job_scheduler_id");
            if (iC < i || iC > i2) {
                e("next_job_scheduler_id", i + 1);
            } else {
                i = iC;
            }
        }
        return i;
    }
}
