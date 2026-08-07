package defpackage;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class iz2 implements hz2 {
    private final RoomDatabase a;
    private final uh0 b;
    private final no2 c;

    class a extends uh0 {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.uh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void bind(sw2 sw2Var, gz2 gz2Var) {
            String str = gz2Var.a;
            if (str == null) {
                sw2Var.l0(1);
            } else {
                sw2Var.f(1, str);
            }
            sw2Var.i(2, gz2Var.b);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }
    }

    class b extends no2 {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public iz2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    @Override // defpackage.hz2
    public List a() {
        ci2 ci2VarW = ci2.w("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
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

    @Override // defpackage.hz2
    public void b(gz2 gz2Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(gz2Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // defpackage.hz2
    public gz2 c(String str) {
        ci2 ci2VarW = ci2.w("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            return cursorB.moveToFirst() ? new gz2(cursorB.getString(i50.b(cursorB, "work_spec_id")), cursorB.getInt(i50.b(cursorB, "system_id"))) : null;
        } finally {
            cursorB.close();
            ci2VarW.D();
        }
    }

    @Override // defpackage.hz2
    public void d(String str) {
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
}
