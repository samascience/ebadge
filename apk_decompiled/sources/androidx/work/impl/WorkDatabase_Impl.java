package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.room.e;
import androidx.room.h;
import defpackage.bl3;
import defpackage.cl3;
import defpackage.e52;
import defpackage.f52;
import defpackage.hz2;
import defpackage.iz2;
import defpackage.k90;
import defpackage.l90;
import defpackage.ow2;
import defpackage.pw2;
import defpackage.q50;
import defpackage.qk3;
import defpackage.rk3;
import defpackage.tk3;
import defpackage.tz2;
import defpackage.uk3;
import defpackage.yk3;
import defpackage.zk3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    private volatile yk3 b;
    private volatile k90 c;
    private volatile bl3 d;
    private volatile hz2 e;
    private volatile qk3 f;
    private volatile tk3 g;
    private volatile e52 h;

    class a extends h.a {
        a(int i) {
            super(i);
        }

        @Override // androidx.room.h.a
        public void createAllTables(ow2 ow2Var) {
            ow2Var.e("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ow2Var.e("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            ow2Var.e("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            ow2Var.e("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            ow2Var.e("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            ow2Var.e("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            ow2Var.e("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ow2Var.e("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            ow2Var.e("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ow2Var.e("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ow2Var.e("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            ow2Var.e("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ow2Var.e("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            ow2Var.e("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            ow2Var.e("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        @Override // androidx.room.h.a
        public void dropAllTables(ow2 ow2Var) {
            ow2Var.e("DROP TABLE IF EXISTS `Dependency`");
            ow2Var.e("DROP TABLE IF EXISTS `WorkSpec`");
            ow2Var.e("DROP TABLE IF EXISTS `WorkTag`");
            ow2Var.e("DROP TABLE IF EXISTS `SystemIdInfo`");
            ow2Var.e("DROP TABLE IF EXISTS `WorkName`");
            ow2Var.e("DROP TABLE IF EXISTS `WorkProgress`");
            ow2Var.e("DROP TABLE IF EXISTS `Preference`");
            if (((RoomDatabase) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.b) ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.get(i)).b(ow2Var);
                }
            }
        }

        @Override // androidx.room.h.a
        protected void onCreate(ow2 ow2Var) {
            if (((RoomDatabase) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.b) ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.get(i)).a(ow2Var);
                }
            }
        }

        @Override // androidx.room.h.a
        public void onOpen(ow2 ow2Var) {
            ((RoomDatabase) WorkDatabase_Impl.this).mDatabase = ow2Var;
            ow2Var.e("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.internalInitInvalidationTracker(ow2Var);
            if (((RoomDatabase) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.b) ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.get(i)).c(ow2Var);
                }
            }
        }

        @Override // androidx.room.h.a
        public void onPostMigrate(ow2 ow2Var) {
        }

        @Override // androidx.room.h.a
        public void onPreMigrate(ow2 ow2Var) {
            q50.a(ow2Var);
        }

        @Override // androidx.room.h.a
        protected h.b onValidateSchema(ow2 ow2Var) {
            HashMap map = new HashMap(2);
            map.put("work_spec_id", new tz2.a("work_spec_id", "TEXT", true, 1, null, 1));
            map.put("prerequisite_id", new tz2.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new tz2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new tz2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new tz2.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new tz2.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            tz2 tz2Var = new tz2("Dependency", map, hashSet, hashSet2);
            tz2 tz2VarA = tz2.a(ow2Var, "Dependency");
            if (!tz2Var.equals(tz2VarA)) {
                return new h.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tz2Var + "\n Found:\n" + tz2VarA);
            }
            HashMap map2 = new HashMap(25);
            map2.put("id", new tz2.a("id", "TEXT", true, 1, null, 1));
            map2.put("state", new tz2.a("state", "INTEGER", true, 0, null, 1));
            map2.put("worker_class_name", new tz2.a("worker_class_name", "TEXT", true, 0, null, 1));
            map2.put("input_merger_class_name", new tz2.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            map2.put("input", new tz2.a("input", "BLOB", true, 0, null, 1));
            map2.put("output", new tz2.a("output", "BLOB", true, 0, null, 1));
            map2.put("initial_delay", new tz2.a("initial_delay", "INTEGER", true, 0, null, 1));
            map2.put("interval_duration", new tz2.a("interval_duration", "INTEGER", true, 0, null, 1));
            map2.put("flex_duration", new tz2.a("flex_duration", "INTEGER", true, 0, null, 1));
            map2.put("run_attempt_count", new tz2.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            map2.put("backoff_policy", new tz2.a("backoff_policy", "INTEGER", true, 0, null, 1));
            map2.put("backoff_delay_duration", new tz2.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            map2.put("period_start_time", new tz2.a("period_start_time", "INTEGER", true, 0, null, 1));
            map2.put("minimum_retention_duration", new tz2.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            map2.put("schedule_requested_at", new tz2.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            map2.put("run_in_foreground", new tz2.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            map2.put("out_of_quota_policy", new tz2.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            map2.put("required_network_type", new tz2.a("required_network_type", "INTEGER", false, 0, null, 1));
            map2.put("requires_charging", new tz2.a("requires_charging", "INTEGER", true, 0, null, 1));
            map2.put("requires_device_idle", new tz2.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            map2.put("requires_battery_not_low", new tz2.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            map2.put("requires_storage_not_low", new tz2.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            map2.put("trigger_content_update_delay", new tz2.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            map2.put("trigger_max_content_delay", new tz2.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            map2.put("content_uri_triggers", new tz2.a("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new tz2.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new tz2.d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            tz2 tz2Var2 = new tz2("WorkSpec", map2, hashSet3, hashSet4);
            tz2 tz2VarA2 = tz2.a(ow2Var, "WorkSpec");
            if (!tz2Var2.equals(tz2VarA2)) {
                return new h.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tz2Var2 + "\n Found:\n" + tz2VarA2);
            }
            HashMap map3 = new HashMap(2);
            map3.put("tag", new tz2.a("tag", "TEXT", true, 1, null, 1));
            map3.put("work_spec_id", new tz2.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new tz2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new tz2.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            tz2 tz2Var3 = new tz2("WorkTag", map3, hashSet5, hashSet6);
            tz2 tz2VarA3 = tz2.a(ow2Var, "WorkTag");
            if (!tz2Var3.equals(tz2VarA3)) {
                return new h.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tz2Var3 + "\n Found:\n" + tz2VarA3);
            }
            HashMap map4 = new HashMap(2);
            map4.put("work_spec_id", new tz2.a("work_spec_id", "TEXT", true, 1, null, 1));
            map4.put("system_id", new tz2.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new tz2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            tz2 tz2Var4 = new tz2("SystemIdInfo", map4, hashSet7, new HashSet(0));
            tz2 tz2VarA4 = tz2.a(ow2Var, "SystemIdInfo");
            if (!tz2Var4.equals(tz2VarA4)) {
                return new h.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tz2Var4 + "\n Found:\n" + tz2VarA4);
            }
            HashMap map5 = new HashMap(2);
            map5.put("name", new tz2.a("name", "TEXT", true, 1, null, 1));
            map5.put("work_spec_id", new tz2.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new tz2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new tz2.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            tz2 tz2Var5 = new tz2("WorkName", map5, hashSet8, hashSet9);
            tz2 tz2VarA5 = tz2.a(ow2Var, "WorkName");
            if (!tz2Var5.equals(tz2VarA5)) {
                return new h.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tz2Var5 + "\n Found:\n" + tz2VarA5);
            }
            HashMap map6 = new HashMap(2);
            map6.put("work_spec_id", new tz2.a("work_spec_id", "TEXT", true, 1, null, 1));
            map6.put("progress", new tz2.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new tz2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            tz2 tz2Var6 = new tz2("WorkProgress", map6, hashSet10, new HashSet(0));
            tz2 tz2VarA6 = tz2.a(ow2Var, "WorkProgress");
            if (!tz2Var6.equals(tz2VarA6)) {
                return new h.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tz2Var6 + "\n Found:\n" + tz2VarA6);
            }
            HashMap map7 = new HashMap(2);
            map7.put("key", new tz2.a("key", "TEXT", true, 1, null, 1));
            map7.put("long_value", new tz2.a("long_value", "INTEGER", false, 0, null, 1));
            tz2 tz2Var7 = new tz2("Preference", map7, new HashSet(0), new HashSet(0));
            tz2 tz2VarA7 = tz2.a(ow2Var, "Preference");
            if (tz2Var7.equals(tz2VarA7)) {
                return new h.b(true, null);
            }
            return new h.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tz2Var7 + "\n Found:\n" + tz2VarA7);
        }
    }

    @Override // androidx.work.impl.WorkDatabase
    public k90 c() {
        k90 k90Var;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new l90(this);
                }
                k90Var = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return k90Var;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        ow2 ow2VarU = super.getOpenHelper().U();
        try {
            super.beginTransaction();
            ow2VarU.e("PRAGMA defer_foreign_keys = TRUE");
            ow2VarU.e("DELETE FROM `Dependency`");
            ow2VarU.e("DELETE FROM `WorkSpec`");
            ow2VarU.e("DELETE FROM `WorkTag`");
            ow2VarU.e("DELETE FROM `SystemIdInfo`");
            ow2VarU.e("DELETE FROM `WorkName`");
            ow2VarU.e("DELETE FROM `WorkProgress`");
            ow2VarU.e("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            ow2VarU.W("PRAGMA wal_checkpoint(FULL)").close();
            if (!ow2VarU.r0()) {
                ow2VarU.e("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected e createInvalidationTracker() {
        return new e(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    protected pw2 createOpenHelper(androidx.room.a aVar) {
        return aVar.a.a(pw2.b.a(aVar.b).c(aVar.c).b(new h(aVar, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }

    @Override // androidx.work.impl.WorkDatabase
    public e52 g() {
        e52 e52Var;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            try {
                if (this.h == null) {
                    this.h = new f52(this);
                }
                e52Var = this.h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return e52Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public hz2 h() {
        hz2 hz2Var;
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            try {
                if (this.e == null) {
                    this.e = new iz2(this);
                }
                hz2Var = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hz2Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public qk3 i() {
        qk3 qk3Var;
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            try {
                if (this.f == null) {
                    this.f = new rk3(this);
                }
                qk3Var = this.f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qk3Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public tk3 j() {
        tk3 tk3Var;
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            try {
                if (this.g == null) {
                    this.g = new uk3(this);
                }
                tk3Var = this.g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tk3Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public yk3 k() {
        yk3 yk3Var;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            try {
                if (this.b == null) {
                    this.b = new zk3(this);
                }
                yk3Var = this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yk3Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public bl3 l() {
        bl3 bl3Var;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            try {
                if (this.d == null) {
                    this.d = new cl3(this);
                }
                bl3Var = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bl3Var;
    }
}
