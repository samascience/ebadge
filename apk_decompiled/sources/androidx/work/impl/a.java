package androidx.work.impl;

import android.content.Context;
import defpackage.ek1;
import defpackage.i52;
import defpackage.ow2;
import defpackage.zy0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static ek1 a = new C0043a(1, 2);
    public static ek1 b = new b(3, 4);
    public static ek1 c = new c(4, 5);
    public static ek1 d = new d(6, 7);
    public static ek1 e = new e(7, 8);
    public static ek1 f = new f(8, 9);
    public static ek1 g = new g(11, 12);

    /* JADX INFO: renamed from: androidx.work.impl.a$a, reason: collision with other inner class name */
    class C0043a extends ek1 {
        C0043a(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ow2Var.e("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            ow2Var.e("DROP TABLE IF EXISTS alarmInfo");
            ow2Var.e("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    class b extends ek1 {
        b(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
        }
    }

    class c extends ek1 {
        c(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            ow2Var.e("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    class d extends ek1 {
        d(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    class e extends ek1 {
        e(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    class f extends ek1 {
        f(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class g extends ek1 {
        g(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class h extends ek1 {
        final Context a;

        public h(Context context, int i, int i2) {
            super(i, i2);
            this.a = context;
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            if (this.endVersion >= 10) {
                ow2Var.k("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.a.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    public static class i extends ek1 {
        final Context a;

        public i(Context context) {
            super(9, 10);
            this.a = context;
        }

        @Override // defpackage.ek1
        public void migrate(ow2 ow2Var) {
            ow2Var.e("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            i52.b(this.a, ow2Var);
            zy0.a(this.a, ow2Var);
        }
    }
}
