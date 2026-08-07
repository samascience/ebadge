package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public class mt2 implements r60 {
    private final SQLiteDatabase a;

    public mt2(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    @Override // defpackage.r60
    public void d() {
        this.a.beginTransaction();
    }

    @Override // defpackage.r60
    public void e(String str) {
        this.a.execSQL(str);
    }

    @Override // defpackage.r60
    public s60 g(String str) {
        return new nt2(this.a.compileStatement(str));
    }

    @Override // defpackage.r60
    public void j() {
        this.a.setTransactionSuccessful();
    }

    @Override // defpackage.r60
    public void k(String str, Object[] objArr) {
        this.a.execSQL(str, objArr);
    }

    @Override // defpackage.r60
    public void l() {
        this.a.endTransaction();
    }

    @Override // defpackage.r60
    public Object m() {
        return this.a;
    }

    @Override // defpackage.r60
    public Cursor n(String str, String[] strArr) {
        return this.a.rawQuery(str, strArr);
    }

    @Override // defpackage.r60
    public boolean o() {
        return this.a.isDbLockedByCurrentThread();
    }
}
