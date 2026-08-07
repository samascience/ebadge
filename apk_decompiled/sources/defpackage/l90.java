package defpackage;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l90 implements k90 {
    private final RoomDatabase a;
    private final uh0 b;

    class a extends uh0 {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.uh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void bind(sw2 sw2Var, i90 i90Var) {
            String str = i90Var.a;
            if (str == null) {
                sw2Var.l0(1);
            } else {
                sw2Var.f(1, str);
            }
            String str2 = i90Var.b;
            if (str2 == null) {
                sw2Var.l0(2);
            } else {
                sw2Var.f(2, str2);
            }
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public l90(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // defpackage.k90
    public List a(String str) {
        ci2 ci2VarW = ci2.w("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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

    @Override // defpackage.k90
    public boolean b(String str) {
        ci2 ci2VarW = ci2.w("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            if (cursorB.moveToFirst()) {
                z = cursorB.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorB.close();
            ci2VarW.D();
        }
    }

    @Override // defpackage.k90
    public void c(i90 i90Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(i90Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // defpackage.k90
    public boolean d(String str) {
        ci2 ci2VarW = ci2.w("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            if (cursorB.moveToFirst()) {
                z = cursorB.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorB.close();
            ci2VarW.D();
        }
    }
}
