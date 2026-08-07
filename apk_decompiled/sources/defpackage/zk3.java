package defpackage;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.work.WorkInfo$State;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zk3 implements yk3 {
    private final RoomDatabase a;
    private final uh0 b;
    private final no2 c;
    private final no2 d;
    private final no2 e;
    private final no2 f;
    private final no2 g;
    private final no2 h;
    private final no2 i;
    private final no2 j;

    class a extends uh0 {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.uh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void bind(sw2 sw2Var, xk3 xk3Var) throws Throwable {
            String str = xk3Var.a;
            if (str == null) {
                sw2Var.l0(1);
            } else {
                sw2Var.f(1, str);
            }
            sw2Var.i(2, el3.j(xk3Var.b));
            String str2 = xk3Var.c;
            if (str2 == null) {
                sw2Var.l0(3);
            } else {
                sw2Var.f(3, str2);
            }
            String str3 = xk3Var.d;
            if (str3 == null) {
                sw2Var.l0(4);
            } else {
                sw2Var.f(4, str3);
            }
            byte[] bArrK = androidx.work.b.k(xk3Var.e);
            if (bArrK == null) {
                sw2Var.l0(5);
            } else {
                sw2Var.R(5, bArrK);
            }
            byte[] bArrK2 = androidx.work.b.k(xk3Var.f);
            if (bArrK2 == null) {
                sw2Var.l0(6);
            } else {
                sw2Var.R(6, bArrK2);
            }
            sw2Var.i(7, xk3Var.g);
            sw2Var.i(8, xk3Var.h);
            sw2Var.i(9, xk3Var.i);
            sw2Var.i(10, xk3Var.k);
            sw2Var.i(11, el3.a(xk3Var.l));
            sw2Var.i(12, xk3Var.m);
            sw2Var.i(13, xk3Var.n);
            sw2Var.i(14, xk3Var.o);
            sw2Var.i(15, xk3Var.p);
            sw2Var.i(16, xk3Var.f444q ? 1L : 0L);
            sw2Var.i(17, el3.i(xk3Var.r));
            n20 n20Var = xk3Var.j;
            if (n20Var == null) {
                sw2Var.l0(18);
                sw2Var.l0(19);
                sw2Var.l0(20);
                sw2Var.l0(21);
                sw2Var.l0(22);
                sw2Var.l0(23);
                sw2Var.l0(24);
                sw2Var.l0(25);
                return;
            }
            sw2Var.i(18, el3.h(n20Var.b()));
            sw2Var.i(19, n20Var.g() ? 1L : 0L);
            sw2Var.i(20, n20Var.h() ? 1L : 0L);
            sw2Var.i(21, n20Var.f() ? 1L : 0L);
            sw2Var.i(22, n20Var.i() ? 1L : 0L);
            sw2Var.i(23, n20Var.c());
            sw2Var.i(24, n20Var.d());
            byte[] bArrC = el3.c(n20Var.a());
            if (bArrC == null) {
                sw2Var.l0(25);
            } else {
                sw2Var.R(25, bArrC);
            }
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends no2 {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    class c extends no2 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    class d extends no2 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    class e extends no2 {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    class f extends no2 {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    class g extends no2 {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    class h extends no2 {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    class i extends no2 {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public zk3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
        this.g = new f(roomDatabase);
        this.h = new g(roomDatabase);
        this.i = new h(roomDatabase);
        this.j = new i(roomDatabase);
    }

    @Override // defpackage.yk3
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.c.acquire();
        if (str == null) {
            sw2VarAcquire.l0(1);
        } else {
            sw2VarAcquire.f(1, str);
        }
        this.a.beginTransaction();
        try {
            sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(sw2VarAcquire);
        }
    }

    @Override // defpackage.yk3
    public int b(WorkInfo$State workInfo$State, String... strArr) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder sbB = ov2.b();
        sbB.append("UPDATE workspec SET state=");
        sbB.append("?");
        sbB.append(" WHERE id IN (");
        ov2.a(sbB, strArr.length);
        sbB.append(")");
        sw2 sw2VarCompileStatement = this.a.compileStatement(sbB.toString());
        sw2VarCompileStatement.i(1, el3.j(workInfo$State));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                sw2VarCompileStatement.l0(i2);
            } else {
                sw2VarCompileStatement.f(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            int iE = sw2VarCompileStatement.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // defpackage.yk3
    public int c(String str, long j) {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.h.acquire();
        sw2VarAcquire.i(1, j);
        if (str == null) {
            sw2VarAcquire.l0(2);
        } else {
            sw2VarAcquire.f(2, str);
        }
        this.a.beginTransaction();
        try {
            int iE = sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.h.release(sw2VarAcquire);
        }
    }

    @Override // defpackage.yk3
    public List d(String str) {
        ci2 ci2VarW = ci2.w("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            int iB = i50.b(cursorB, "id");
            int iB2 = i50.b(cursorB, "state");
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                xk3.b bVar = new xk3.b();
                bVar.a = cursorB.getString(iB);
                bVar.b = el3.g(cursorB.getInt(iB2));
                arrayList.add(bVar);
            }
            cursorB.close();
            ci2VarW.D();
            return arrayList;
        } catch (Throwable th) {
            cursorB.close();
            ci2VarW.D();
            throw th;
        }
    }

    @Override // defpackage.yk3
    public List e(long j) throws Throwable {
        ci2 ci2Var;
        ci2 ci2VarW = ci2.w("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        ci2VarW.i(1, j);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            int iB = i50.b(cursorB, "required_network_type");
            int iB2 = i50.b(cursorB, "requires_charging");
            int iB3 = i50.b(cursorB, "requires_device_idle");
            int iB4 = i50.b(cursorB, "requires_battery_not_low");
            int iB5 = i50.b(cursorB, "requires_storage_not_low");
            int iB6 = i50.b(cursorB, "trigger_content_update_delay");
            int iB7 = i50.b(cursorB, "trigger_max_content_delay");
            int iB8 = i50.b(cursorB, "content_uri_triggers");
            int iB9 = i50.b(cursorB, "id");
            int iB10 = i50.b(cursorB, "state");
            int iB11 = i50.b(cursorB, "worker_class_name");
            int iB12 = i50.b(cursorB, "input_merger_class_name");
            int iB13 = i50.b(cursorB, "input");
            int iB14 = i50.b(cursorB, "output");
            ci2Var = ci2VarW;
            try {
                int iB15 = i50.b(cursorB, "initial_delay");
                int iB16 = i50.b(cursorB, "interval_duration");
                int iB17 = i50.b(cursorB, "flex_duration");
                int iB18 = i50.b(cursorB, "run_attempt_count");
                int iB19 = i50.b(cursorB, "backoff_policy");
                int iB20 = i50.b(cursorB, "backoff_delay_duration");
                int iB21 = i50.b(cursorB, "period_start_time");
                int iB22 = i50.b(cursorB, "minimum_retention_duration");
                int iB23 = i50.b(cursorB, "schedule_requested_at");
                int iB24 = i50.b(cursorB, "run_in_foreground");
                int iB25 = i50.b(cursorB, "out_of_quota_policy");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i3 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i4 = iB11;
                    n20 n20Var = new n20();
                    int i5 = iB;
                    n20Var.k(el3.e(cursorB.getInt(iB)));
                    n20Var.m(cursorB.getInt(iB2) != 0);
                    n20Var.n(cursorB.getInt(iB3) != 0);
                    n20Var.l(cursorB.getInt(iB4) != 0);
                    n20Var.o(cursorB.getInt(iB5) != 0);
                    int i6 = iB2;
                    int i7 = iB3;
                    n20Var.p(cursorB.getLong(iB6));
                    n20Var.q(cursorB.getLong(iB7));
                    n20Var.j(el3.b(cursorB.getBlob(iB8)));
                    xk3 xk3Var = new xk3(string, string2);
                    xk3Var.b = el3.g(cursorB.getInt(iB10));
                    xk3Var.d = cursorB.getString(iB12);
                    xk3Var.e = androidx.work.b.g(cursorB.getBlob(iB13));
                    int i8 = i2;
                    xk3Var.f = androidx.work.b.g(cursorB.getBlob(i8));
                    int i9 = iB15;
                    i2 = i8;
                    xk3Var.g = cursorB.getLong(i9);
                    int i10 = iB12;
                    int i11 = iB16;
                    xk3Var.h = cursorB.getLong(i11);
                    int i12 = iB4;
                    int i13 = iB17;
                    xk3Var.i = cursorB.getLong(i13);
                    int i14 = iB18;
                    xk3Var.k = cursorB.getInt(i14);
                    int i15 = iB19;
                    xk3Var.l = el3.d(cursorB.getInt(i15));
                    iB17 = i13;
                    int i16 = iB20;
                    xk3Var.m = cursorB.getLong(i16);
                    int i17 = iB21;
                    xk3Var.n = cursorB.getLong(i17);
                    iB21 = i17;
                    int i18 = iB22;
                    xk3Var.o = cursorB.getLong(i18);
                    int i19 = iB23;
                    xk3Var.p = cursorB.getLong(i19);
                    int i20 = iB24;
                    xk3Var.f444q = cursorB.getInt(i20) != 0;
                    int i21 = iB25;
                    xk3Var.r = el3.f(cursorB.getInt(i21));
                    xk3Var.j = n20Var;
                    arrayList.add(xk3Var);
                    iB2 = i6;
                    iB25 = i21;
                    iB12 = i10;
                    iB15 = i9;
                    iB16 = i11;
                    iB18 = i14;
                    iB23 = i19;
                    iB9 = i3;
                    iB11 = i4;
                    iB = i5;
                    iB24 = i20;
                    iB22 = i18;
                    iB3 = i7;
                    iB20 = i16;
                    iB4 = i12;
                    iB19 = i15;
                }
                cursorB.close();
                ci2Var.D();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                ci2Var.D();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ci2Var = ci2VarW;
        }
    }

    @Override // defpackage.yk3
    public List f(int i2) throws Throwable {
        ci2 ci2Var;
        ci2 ci2VarW = ci2.w("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        ci2VarW.i(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            int iB = i50.b(cursorB, "required_network_type");
            int iB2 = i50.b(cursorB, "requires_charging");
            int iB3 = i50.b(cursorB, "requires_device_idle");
            int iB4 = i50.b(cursorB, "requires_battery_not_low");
            int iB5 = i50.b(cursorB, "requires_storage_not_low");
            int iB6 = i50.b(cursorB, "trigger_content_update_delay");
            int iB7 = i50.b(cursorB, "trigger_max_content_delay");
            int iB8 = i50.b(cursorB, "content_uri_triggers");
            int iB9 = i50.b(cursorB, "id");
            int iB10 = i50.b(cursorB, "state");
            int iB11 = i50.b(cursorB, "worker_class_name");
            int iB12 = i50.b(cursorB, "input_merger_class_name");
            int iB13 = i50.b(cursorB, "input");
            int iB14 = i50.b(cursorB, "output");
            ci2Var = ci2VarW;
            try {
                int iB15 = i50.b(cursorB, "initial_delay");
                int iB16 = i50.b(cursorB, "interval_duration");
                int iB17 = i50.b(cursorB, "flex_duration");
                int iB18 = i50.b(cursorB, "run_attempt_count");
                int iB19 = i50.b(cursorB, "backoff_policy");
                int iB20 = i50.b(cursorB, "backoff_delay_duration");
                int iB21 = i50.b(cursorB, "period_start_time");
                int iB22 = i50.b(cursorB, "minimum_retention_duration");
                int iB23 = i50.b(cursorB, "schedule_requested_at");
                int iB24 = i50.b(cursorB, "run_in_foreground");
                int iB25 = i50.b(cursorB, "out_of_quota_policy");
                int i3 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i4 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i5 = iB11;
                    n20 n20Var = new n20();
                    int i6 = iB;
                    n20Var.k(el3.e(cursorB.getInt(iB)));
                    n20Var.m(cursorB.getInt(iB2) != 0);
                    n20Var.n(cursorB.getInt(iB3) != 0);
                    n20Var.l(cursorB.getInt(iB4) != 0);
                    n20Var.o(cursorB.getInt(iB5) != 0);
                    int i7 = iB2;
                    int i8 = iB3;
                    n20Var.p(cursorB.getLong(iB6));
                    n20Var.q(cursorB.getLong(iB7));
                    n20Var.j(el3.b(cursorB.getBlob(iB8)));
                    xk3 xk3Var = new xk3(string, string2);
                    xk3Var.b = el3.g(cursorB.getInt(iB10));
                    xk3Var.d = cursorB.getString(iB12);
                    xk3Var.e = androidx.work.b.g(cursorB.getBlob(iB13));
                    int i9 = i3;
                    xk3Var.f = androidx.work.b.g(cursorB.getBlob(i9));
                    i3 = i9;
                    int i10 = iB15;
                    xk3Var.g = cursorB.getLong(i10);
                    int i11 = iB12;
                    int i12 = iB16;
                    xk3Var.h = cursorB.getLong(i12);
                    int i13 = iB4;
                    int i14 = iB17;
                    xk3Var.i = cursorB.getLong(i14);
                    int i15 = iB18;
                    xk3Var.k = cursorB.getInt(i15);
                    int i16 = iB19;
                    xk3Var.l = el3.d(cursorB.getInt(i16));
                    iB17 = i14;
                    int i17 = iB20;
                    xk3Var.m = cursorB.getLong(i17);
                    int i18 = iB21;
                    xk3Var.n = cursorB.getLong(i18);
                    iB21 = i18;
                    int i19 = iB22;
                    xk3Var.o = cursorB.getLong(i19);
                    int i20 = iB23;
                    xk3Var.p = cursorB.getLong(i20);
                    int i21 = iB24;
                    xk3Var.f444q = cursorB.getInt(i21) != 0;
                    int i22 = iB25;
                    xk3Var.r = el3.f(cursorB.getInt(i22));
                    xk3Var.j = n20Var;
                    arrayList.add(xk3Var);
                    iB25 = i22;
                    iB2 = i7;
                    iB12 = i11;
                    iB15 = i10;
                    iB16 = i12;
                    iB18 = i15;
                    iB23 = i20;
                    iB9 = i4;
                    iB11 = i5;
                    iB = i6;
                    iB24 = i21;
                    iB22 = i19;
                    iB3 = i8;
                    iB20 = i17;
                    iB4 = i13;
                    iB19 = i16;
                }
                cursorB.close();
                ci2Var.D();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                ci2Var.D();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ci2Var = ci2VarW;
        }
    }

    @Override // defpackage.yk3
    public List g() throws Throwable {
        ci2 ci2Var;
        ci2 ci2VarW = ci2.w("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            int iB = i50.b(cursorB, "required_network_type");
            int iB2 = i50.b(cursorB, "requires_charging");
            int iB3 = i50.b(cursorB, "requires_device_idle");
            int iB4 = i50.b(cursorB, "requires_battery_not_low");
            int iB5 = i50.b(cursorB, "requires_storage_not_low");
            int iB6 = i50.b(cursorB, "trigger_content_update_delay");
            int iB7 = i50.b(cursorB, "trigger_max_content_delay");
            int iB8 = i50.b(cursorB, "content_uri_triggers");
            int iB9 = i50.b(cursorB, "id");
            int iB10 = i50.b(cursorB, "state");
            int iB11 = i50.b(cursorB, "worker_class_name");
            int iB12 = i50.b(cursorB, "input_merger_class_name");
            int iB13 = i50.b(cursorB, "input");
            int iB14 = i50.b(cursorB, "output");
            ci2Var = ci2VarW;
            try {
                int iB15 = i50.b(cursorB, "initial_delay");
                int iB16 = i50.b(cursorB, "interval_duration");
                int iB17 = i50.b(cursorB, "flex_duration");
                int iB18 = i50.b(cursorB, "run_attempt_count");
                int iB19 = i50.b(cursorB, "backoff_policy");
                int iB20 = i50.b(cursorB, "backoff_delay_duration");
                int iB21 = i50.b(cursorB, "period_start_time");
                int iB22 = i50.b(cursorB, "minimum_retention_duration");
                int iB23 = i50.b(cursorB, "schedule_requested_at");
                int iB24 = i50.b(cursorB, "run_in_foreground");
                int iB25 = i50.b(cursorB, "out_of_quota_policy");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i3 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i4 = iB11;
                    n20 n20Var = new n20();
                    int i5 = iB;
                    n20Var.k(el3.e(cursorB.getInt(iB)));
                    n20Var.m(cursorB.getInt(iB2) != 0);
                    n20Var.n(cursorB.getInt(iB3) != 0);
                    n20Var.l(cursorB.getInt(iB4) != 0);
                    n20Var.o(cursorB.getInt(iB5) != 0);
                    int i6 = iB2;
                    int i7 = iB3;
                    n20Var.p(cursorB.getLong(iB6));
                    n20Var.q(cursorB.getLong(iB7));
                    n20Var.j(el3.b(cursorB.getBlob(iB8)));
                    xk3 xk3Var = new xk3(string, string2);
                    xk3Var.b = el3.g(cursorB.getInt(iB10));
                    xk3Var.d = cursorB.getString(iB12);
                    xk3Var.e = androidx.work.b.g(cursorB.getBlob(iB13));
                    int i8 = i2;
                    xk3Var.f = androidx.work.b.g(cursorB.getBlob(i8));
                    i2 = i8;
                    int i9 = iB15;
                    xk3Var.g = cursorB.getLong(i9);
                    int i10 = iB13;
                    int i11 = iB16;
                    xk3Var.h = cursorB.getLong(i11);
                    int i12 = iB4;
                    int i13 = iB17;
                    xk3Var.i = cursorB.getLong(i13);
                    int i14 = iB18;
                    xk3Var.k = cursorB.getInt(i14);
                    int i15 = iB19;
                    xk3Var.l = el3.d(cursorB.getInt(i15));
                    iB17 = i13;
                    int i16 = iB20;
                    xk3Var.m = cursorB.getLong(i16);
                    int i17 = iB21;
                    xk3Var.n = cursorB.getLong(i17);
                    iB21 = i17;
                    int i18 = iB22;
                    xk3Var.o = cursorB.getLong(i18);
                    int i19 = iB23;
                    xk3Var.p = cursorB.getLong(i19);
                    int i20 = iB24;
                    xk3Var.f444q = cursorB.getInt(i20) != 0;
                    int i21 = iB25;
                    xk3Var.r = el3.f(cursorB.getInt(i21));
                    xk3Var.j = n20Var;
                    arrayList.add(xk3Var);
                    iB25 = i21;
                    iB2 = i6;
                    iB13 = i10;
                    iB15 = i9;
                    iB16 = i11;
                    iB18 = i14;
                    iB23 = i19;
                    iB9 = i3;
                    iB11 = i4;
                    iB = i5;
                    iB24 = i20;
                    iB22 = i18;
                    iB3 = i7;
                    iB20 = i16;
                    iB4 = i12;
                    iB19 = i15;
                }
                cursorB.close();
                ci2Var.D();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                ci2Var.D();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ci2Var = ci2VarW;
        }
    }

    @Override // defpackage.yk3
    public void h(String str, androidx.work.b bVar) throws Throwable {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.d.acquire();
        byte[] bArrK = androidx.work.b.k(bVar);
        if (bArrK == null) {
            sw2VarAcquire.l0(1);
        } else {
            sw2VarAcquire.R(1, bArrK);
        }
        if (str == null) {
            sw2VarAcquire.l0(2);
        } else {
            sw2VarAcquire.f(2, str);
        }
        this.a.beginTransaction();
        try {
            sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.d.release(sw2VarAcquire);
        }
    }

    @Override // defpackage.yk3
    public List i() throws Throwable {
        ci2 ci2Var;
        ci2 ci2VarW = ci2.w("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            int iB = i50.b(cursorB, "required_network_type");
            int iB2 = i50.b(cursorB, "requires_charging");
            int iB3 = i50.b(cursorB, "requires_device_idle");
            int iB4 = i50.b(cursorB, "requires_battery_not_low");
            int iB5 = i50.b(cursorB, "requires_storage_not_low");
            int iB6 = i50.b(cursorB, "trigger_content_update_delay");
            int iB7 = i50.b(cursorB, "trigger_max_content_delay");
            int iB8 = i50.b(cursorB, "content_uri_triggers");
            int iB9 = i50.b(cursorB, "id");
            int iB10 = i50.b(cursorB, "state");
            int iB11 = i50.b(cursorB, "worker_class_name");
            int iB12 = i50.b(cursorB, "input_merger_class_name");
            int iB13 = i50.b(cursorB, "input");
            int iB14 = i50.b(cursorB, "output");
            ci2Var = ci2VarW;
            try {
                int iB15 = i50.b(cursorB, "initial_delay");
                int iB16 = i50.b(cursorB, "interval_duration");
                int iB17 = i50.b(cursorB, "flex_duration");
                int iB18 = i50.b(cursorB, "run_attempt_count");
                int iB19 = i50.b(cursorB, "backoff_policy");
                int iB20 = i50.b(cursorB, "backoff_delay_duration");
                int iB21 = i50.b(cursorB, "period_start_time");
                int iB22 = i50.b(cursorB, "minimum_retention_duration");
                int iB23 = i50.b(cursorB, "schedule_requested_at");
                int iB24 = i50.b(cursorB, "run_in_foreground");
                int iB25 = i50.b(cursorB, "out_of_quota_policy");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i3 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i4 = iB11;
                    n20 n20Var = new n20();
                    int i5 = iB;
                    n20Var.k(el3.e(cursorB.getInt(iB)));
                    n20Var.m(cursorB.getInt(iB2) != 0);
                    n20Var.n(cursorB.getInt(iB3) != 0);
                    n20Var.l(cursorB.getInt(iB4) != 0);
                    n20Var.o(cursorB.getInt(iB5) != 0);
                    int i6 = iB2;
                    int i7 = iB3;
                    n20Var.p(cursorB.getLong(iB6));
                    n20Var.q(cursorB.getLong(iB7));
                    n20Var.j(el3.b(cursorB.getBlob(iB8)));
                    xk3 xk3Var = new xk3(string, string2);
                    xk3Var.b = el3.g(cursorB.getInt(iB10));
                    xk3Var.d = cursorB.getString(iB12);
                    xk3Var.e = androidx.work.b.g(cursorB.getBlob(iB13));
                    int i8 = i2;
                    xk3Var.f = androidx.work.b.g(cursorB.getBlob(i8));
                    i2 = i8;
                    int i9 = iB15;
                    xk3Var.g = cursorB.getLong(i9);
                    int i10 = iB13;
                    int i11 = iB16;
                    xk3Var.h = cursorB.getLong(i11);
                    int i12 = iB4;
                    int i13 = iB17;
                    xk3Var.i = cursorB.getLong(i13);
                    int i14 = iB18;
                    xk3Var.k = cursorB.getInt(i14);
                    int i15 = iB19;
                    xk3Var.l = el3.d(cursorB.getInt(i15));
                    iB17 = i13;
                    int i16 = iB20;
                    xk3Var.m = cursorB.getLong(i16);
                    int i17 = iB21;
                    xk3Var.n = cursorB.getLong(i17);
                    iB21 = i17;
                    int i18 = iB22;
                    xk3Var.o = cursorB.getLong(i18);
                    int i19 = iB23;
                    xk3Var.p = cursorB.getLong(i19);
                    int i20 = iB24;
                    xk3Var.f444q = cursorB.getInt(i20) != 0;
                    int i21 = iB25;
                    xk3Var.r = el3.f(cursorB.getInt(i21));
                    xk3Var.j = n20Var;
                    arrayList.add(xk3Var);
                    iB25 = i21;
                    iB2 = i6;
                    iB13 = i10;
                    iB15 = i9;
                    iB16 = i11;
                    iB18 = i14;
                    iB23 = i19;
                    iB9 = i3;
                    iB11 = i4;
                    iB = i5;
                    iB24 = i20;
                    iB22 = i18;
                    iB3 = i7;
                    iB20 = i16;
                    iB4 = i12;
                    iB19 = i15;
                }
                cursorB.close();
                ci2Var.D();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                ci2Var.D();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ci2Var = ci2VarW;
        }
    }

    @Override // defpackage.yk3
    public boolean j() {
        boolean z = false;
        ci2 ci2VarW = ci2.w("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            if (cursorB.moveToFirst() && cursorB.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            cursorB.close();
            ci2VarW.D();
        }
    }

    @Override // defpackage.yk3
    public List k(String str) {
        ci2 ci2VarW = ci2.w("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                arrayList.add(cursorB.getString(0));
            }
            cursorB.close();
            ci2VarW.D();
            return arrayList;
        } catch (Throwable th) {
            cursorB.close();
            ci2VarW.D();
            throw th;
        }
    }

    @Override // defpackage.yk3
    public WorkInfo$State l(String str) {
        ci2 ci2VarW = ci2.w("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            return cursorB.moveToFirst() ? el3.g(cursorB.getInt(0)) : null;
        } finally {
            cursorB.close();
            ci2VarW.D();
        }
    }

    @Override // defpackage.yk3
    public xk3 m(String str) throws Throwable {
        ci2 ci2Var;
        xk3 xk3Var;
        ci2 ci2VarW = ci2.w("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            int iB = i50.b(cursorB, "required_network_type");
            int iB2 = i50.b(cursorB, "requires_charging");
            int iB3 = i50.b(cursorB, "requires_device_idle");
            int iB4 = i50.b(cursorB, "requires_battery_not_low");
            int iB5 = i50.b(cursorB, "requires_storage_not_low");
            int iB6 = i50.b(cursorB, "trigger_content_update_delay");
            int iB7 = i50.b(cursorB, "trigger_max_content_delay");
            int iB8 = i50.b(cursorB, "content_uri_triggers");
            int iB9 = i50.b(cursorB, "id");
            int iB10 = i50.b(cursorB, "state");
            int iB11 = i50.b(cursorB, "worker_class_name");
            int iB12 = i50.b(cursorB, "input_merger_class_name");
            int iB13 = i50.b(cursorB, "input");
            int iB14 = i50.b(cursorB, "output");
            ci2Var = ci2VarW;
            try {
                int iB15 = i50.b(cursorB, "initial_delay");
                int iB16 = i50.b(cursorB, "interval_duration");
                int iB17 = i50.b(cursorB, "flex_duration");
                int iB18 = i50.b(cursorB, "run_attempt_count");
                int iB19 = i50.b(cursorB, "backoff_policy");
                int iB20 = i50.b(cursorB, "backoff_delay_duration");
                int iB21 = i50.b(cursorB, "period_start_time");
                int iB22 = i50.b(cursorB, "minimum_retention_duration");
                int iB23 = i50.b(cursorB, "schedule_requested_at");
                int iB24 = i50.b(cursorB, "run_in_foreground");
                int iB25 = i50.b(cursorB, "out_of_quota_policy");
                if (cursorB.moveToFirst()) {
                    String string = cursorB.getString(iB9);
                    String string2 = cursorB.getString(iB11);
                    n20 n20Var = new n20();
                    n20Var.k(el3.e(cursorB.getInt(iB)));
                    n20Var.m(cursorB.getInt(iB2) != 0);
                    n20Var.n(cursorB.getInt(iB3) != 0);
                    n20Var.l(cursorB.getInt(iB4) != 0);
                    n20Var.o(cursorB.getInt(iB5) != 0);
                    n20Var.p(cursorB.getLong(iB6));
                    n20Var.q(cursorB.getLong(iB7));
                    n20Var.j(el3.b(cursorB.getBlob(iB8)));
                    xk3 xk3Var2 = new xk3(string, string2);
                    xk3Var2.b = el3.g(cursorB.getInt(iB10));
                    xk3Var2.d = cursorB.getString(iB12);
                    xk3Var2.e = androidx.work.b.g(cursorB.getBlob(iB13));
                    xk3Var2.f = androidx.work.b.g(cursorB.getBlob(iB14));
                    xk3Var2.g = cursorB.getLong(iB15);
                    xk3Var2.h = cursorB.getLong(iB16);
                    xk3Var2.i = cursorB.getLong(iB17);
                    xk3Var2.k = cursorB.getInt(iB18);
                    xk3Var2.l = el3.d(cursorB.getInt(iB19));
                    xk3Var2.m = cursorB.getLong(iB20);
                    xk3Var2.n = cursorB.getLong(iB21);
                    xk3Var2.o = cursorB.getLong(iB22);
                    xk3Var2.p = cursorB.getLong(iB23);
                    xk3Var2.f444q = cursorB.getInt(iB24) != 0;
                    xk3Var2.r = el3.f(cursorB.getInt(iB25));
                    xk3Var2.j = n20Var;
                    xk3Var = xk3Var2;
                } else {
                    xk3Var = null;
                }
                cursorB.close();
                ci2Var.D();
                return xk3Var;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                ci2Var.D();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ci2Var = ci2VarW;
        }
    }

    @Override // defpackage.yk3
    public int n(String str) {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.g.acquire();
        if (str == null) {
            sw2VarAcquire.l0(1);
        } else {
            sw2VarAcquire.f(1, str);
        }
        this.a.beginTransaction();
        try {
            int iE = sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.g.release(sw2VarAcquire);
        }
    }

    @Override // defpackage.yk3
    public void o(xk3 xk3Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(xk3Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // defpackage.yk3
    public List p(String str) {
        ci2 ci2VarW = ci2.w("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                arrayList.add(androidx.work.b.g(cursorB.getBlob(0)));
            }
            cursorB.close();
            ci2VarW.D();
            return arrayList;
        } catch (Throwable th) {
            cursorB.close();
            ci2VarW.D();
            throw th;
        }
    }

    @Override // defpackage.yk3
    public int q(String str) {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.f.acquire();
        if (str == null) {
            sw2VarAcquire.l0(1);
        } else {
            sw2VarAcquire.f(1, str);
        }
        this.a.beginTransaction();
        try {
            int iE = sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.f.release(sw2VarAcquire);
        }
    }

    @Override // defpackage.yk3
    public void r(String str, long j) {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.e.acquire();
        sw2VarAcquire.i(1, j);
        if (str == null) {
            sw2VarAcquire.l0(2);
        } else {
            sw2VarAcquire.f(2, str);
        }
        this.a.beginTransaction();
        try {
            sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.e.release(sw2VarAcquire);
        }
    }

    @Override // defpackage.yk3
    public List s(int i2) throws Throwable {
        ci2 ci2Var;
        ci2 ci2VarW = ci2.w("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        ci2VarW.i(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            int iB = i50.b(cursorB, "required_network_type");
            int iB2 = i50.b(cursorB, "requires_charging");
            int iB3 = i50.b(cursorB, "requires_device_idle");
            int iB4 = i50.b(cursorB, "requires_battery_not_low");
            int iB5 = i50.b(cursorB, "requires_storage_not_low");
            int iB6 = i50.b(cursorB, "trigger_content_update_delay");
            int iB7 = i50.b(cursorB, "trigger_max_content_delay");
            int iB8 = i50.b(cursorB, "content_uri_triggers");
            int iB9 = i50.b(cursorB, "id");
            int iB10 = i50.b(cursorB, "state");
            int iB11 = i50.b(cursorB, "worker_class_name");
            int iB12 = i50.b(cursorB, "input_merger_class_name");
            int iB13 = i50.b(cursorB, "input");
            int iB14 = i50.b(cursorB, "output");
            ci2Var = ci2VarW;
            try {
                int iB15 = i50.b(cursorB, "initial_delay");
                int iB16 = i50.b(cursorB, "interval_duration");
                int iB17 = i50.b(cursorB, "flex_duration");
                int iB18 = i50.b(cursorB, "run_attempt_count");
                int iB19 = i50.b(cursorB, "backoff_policy");
                int iB20 = i50.b(cursorB, "backoff_delay_duration");
                int iB21 = i50.b(cursorB, "period_start_time");
                int iB22 = i50.b(cursorB, "minimum_retention_duration");
                int iB23 = i50.b(cursorB, "schedule_requested_at");
                int iB24 = i50.b(cursorB, "run_in_foreground");
                int iB25 = i50.b(cursorB, "out_of_quota_policy");
                int i3 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i4 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i5 = iB11;
                    n20 n20Var = new n20();
                    int i6 = iB;
                    n20Var.k(el3.e(cursorB.getInt(iB)));
                    n20Var.m(cursorB.getInt(iB2) != 0);
                    n20Var.n(cursorB.getInt(iB3) != 0);
                    n20Var.l(cursorB.getInt(iB4) != 0);
                    n20Var.o(cursorB.getInt(iB5) != 0);
                    int i7 = iB2;
                    int i8 = iB3;
                    n20Var.p(cursorB.getLong(iB6));
                    n20Var.q(cursorB.getLong(iB7));
                    n20Var.j(el3.b(cursorB.getBlob(iB8)));
                    xk3 xk3Var = new xk3(string, string2);
                    xk3Var.b = el3.g(cursorB.getInt(iB10));
                    xk3Var.d = cursorB.getString(iB12);
                    xk3Var.e = androidx.work.b.g(cursorB.getBlob(iB13));
                    int i9 = i3;
                    xk3Var.f = androidx.work.b.g(cursorB.getBlob(i9));
                    i3 = i9;
                    int i10 = iB15;
                    xk3Var.g = cursorB.getLong(i10);
                    int i11 = iB12;
                    int i12 = iB16;
                    xk3Var.h = cursorB.getLong(i12);
                    int i13 = iB4;
                    int i14 = iB17;
                    xk3Var.i = cursorB.getLong(i14);
                    int i15 = iB18;
                    xk3Var.k = cursorB.getInt(i15);
                    int i16 = iB19;
                    xk3Var.l = el3.d(cursorB.getInt(i16));
                    iB17 = i14;
                    int i17 = iB20;
                    xk3Var.m = cursorB.getLong(i17);
                    int i18 = iB21;
                    xk3Var.n = cursorB.getLong(i18);
                    iB21 = i18;
                    int i19 = iB22;
                    xk3Var.o = cursorB.getLong(i19);
                    int i20 = iB23;
                    xk3Var.p = cursorB.getLong(i20);
                    int i21 = iB24;
                    xk3Var.f444q = cursorB.getInt(i21) != 0;
                    int i22 = iB25;
                    xk3Var.r = el3.f(cursorB.getInt(i22));
                    xk3Var.j = n20Var;
                    arrayList.add(xk3Var);
                    iB25 = i22;
                    iB2 = i7;
                    iB12 = i11;
                    iB15 = i10;
                    iB16 = i12;
                    iB18 = i15;
                    iB23 = i20;
                    iB9 = i4;
                    iB11 = i5;
                    iB = i6;
                    iB24 = i21;
                    iB22 = i19;
                    iB3 = i8;
                    iB20 = i17;
                    iB4 = i13;
                    iB19 = i16;
                }
                cursorB.close();
                ci2Var.D();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                ci2Var.D();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ci2Var = ci2VarW;
        }
    }

    @Override // defpackage.yk3
    public int t() {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.i.acquire();
        this.a.beginTransaction();
        try {
            int iE = sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.i.release(sw2VarAcquire);
        }
    }
}
