package defpackage;

import android.database.Cursor;
import androidx.room.RoomDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class f52 implements e52 {
    private final RoomDatabase a;
    private final uh0 b;

    class a extends uh0 {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.uh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void bind(sw2 sw2Var, c52 c52Var) {
            String str = c52Var.a;
            if (str == null) {
                sw2Var.l0(1);
            } else {
                sw2Var.f(1, str);
            }
            Long l = c52Var.b;
            if (l == null) {
                sw2Var.l0(2);
            } else {
                sw2Var.i(2, l.longValue());
            }
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }
    }

    public f52(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // defpackage.e52
    public Long a(String str) {
        ci2 ci2VarW = ci2.w("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Long lValueOf = null;
        Cursor cursorB = q50.b(this.a, ci2VarW, false, null);
        try {
            if (cursorB.moveToFirst() && !cursorB.isNull(0)) {
                lValueOf = Long.valueOf(cursorB.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorB.close();
            ci2VarW.D();
        }
    }

    @Override // defpackage.e52
    public void b(c52 c52Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(c52Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
