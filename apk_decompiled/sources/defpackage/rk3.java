package defpackage;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class rk3 implements qk3 {
    private final RoomDatabase a;
    private final uh0 b;

    class a extends uh0 {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.uh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void bind(sw2 sw2Var, pk3 pk3Var) {
            String str = pk3Var.a;
            if (str == null) {
                sw2Var.l0(1);
            } else {
                sw2Var.f(1, str);
            }
            String str2 = pk3Var.b;
            if (str2 == null) {
                sw2Var.l0(2);
            } else {
                sw2Var.f(2, str2);
            }
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public rk3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // defpackage.qk3
    public void a(pk3 pk3Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(pk3Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // defpackage.qk3
    public List b(String str) {
        ci2 ci2VarW = ci2.w("SELECT name FROM workname WHERE work_spec_id=?", 1);
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
}
