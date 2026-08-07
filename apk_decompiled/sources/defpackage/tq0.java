package defpackage;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
class tq0 extends sq0 implements sw2 {
    private final SQLiteStatement b;

    tq0(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.b = sQLiteStatement;
    }

    @Override // defpackage.sw2
    public int E() {
        return this.b.executeUpdateDelete();
    }

    @Override // defpackage.sw2
    public long p() {
        return this.b.executeInsert();
    }
}
