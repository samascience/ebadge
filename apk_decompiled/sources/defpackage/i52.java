package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public class i52 {
    private final WorkDatabase a;

    public i52(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void b(Context context, ow2 ow2Var) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j2 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            ow2Var.d();
            try {
                ow2Var.k("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j)});
                ow2Var.k("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                sharedPreferences.edit().clear().apply();
                ow2Var.j();
            } finally {
                ow2Var.l();
            }
        }
    }

    public boolean a() {
        Long lA = this.a.g().a("reschedule_needed");
        return lA != null && lA.longValue() == 1;
    }

    public void c(boolean z) {
        this.a.g().b(new c52("reschedule_needed", z));
    }
}
