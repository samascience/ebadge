package defpackage;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: loaded from: classes4.dex */
public class nt2 implements s60 {
    private final SQLiteStatement a;

    public nt2(SQLiteStatement sQLiteStatement) {
        this.a = sQLiteStatement;
    }

    @Override // defpackage.s60
    public void close() {
        this.a.close();
    }

    @Override // defpackage.s60
    public void execute() {
        this.a.execute();
    }

    @Override // defpackage.s60
    public void f(int i, String str) {
        this.a.bindString(i, str);
    }

    @Override // defpackage.s60
    public void h(int i, double d) {
        this.a.bindDouble(i, d);
    }

    @Override // defpackage.s60
    public void i(int i, long j) {
        this.a.bindLong(i, j);
    }

    @Override // defpackage.s60
    public long p() {
        return this.a.executeInsert();
    }

    @Override // defpackage.s60
    public long q() {
        return this.a.simpleQueryForLong();
    }

    @Override // defpackage.s60
    public void r() {
        this.a.clearBindings();
    }

    @Override // defpackage.s60
    public Object s() {
        return this.a;
    }
}
