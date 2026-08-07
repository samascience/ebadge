package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class pq0 implements ow2 {
    private static final String[] b = {Constants.STR_EMPTY, " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] c = new String[0];
    private final SQLiteDatabase a;

    class a implements SQLiteDatabase.CursorFactory {
        final /* synthetic */ rw2 a;

        a(rw2 rw2Var) {
            this.a = rw2Var;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.u(new sq0(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    class b implements SQLiteDatabase.CursorFactory {
        final /* synthetic */ rw2 a;

        b(rw2 rw2Var) {
            this.a = rw2Var;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.u(new sq0(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    pq0(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    @Override // defpackage.ow2
    public Cursor P(rw2 rw2Var, CancellationSignal cancellationSignal) {
        return this.a.rawQueryWithFactory(new b(rw2Var), rw2Var.n(), c, null, cancellationSignal);
    }

    @Override // defpackage.ow2
    public Cursor W(String str) {
        return t(new hp2(str));
    }

    @Override // defpackage.ow2
    public String c() {
        return this.a.getPath();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // defpackage.ow2
    public void d() {
        this.a.beginTransaction();
    }

    @Override // defpackage.ow2
    public void e(String str) {
        this.a.execSQL(str);
    }

    @Override // defpackage.ow2
    public sw2 g(String str) {
        return new tq0(this.a.compileStatement(str));
    }

    @Override // defpackage.ow2
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // defpackage.ow2
    public void j() {
        this.a.setTransactionSuccessful();
    }

    @Override // defpackage.ow2
    public void k(String str, Object[] objArr) {
        this.a.execSQL(str, objArr);
    }

    @Override // defpackage.ow2
    public void l() {
        this.a.endTransaction();
    }

    boolean n(SQLiteDatabase sQLiteDatabase) {
        return this.a == sQLiteDatabase;
    }

    @Override // defpackage.ow2
    public boolean r0() {
        return this.a.inTransaction();
    }

    @Override // defpackage.ow2
    public Cursor t(rw2 rw2Var) {
        return this.a.rawQueryWithFactory(new a(rw2Var), rw2Var.n(), c, null);
    }

    @Override // defpackage.ow2
    public List v() {
        return this.a.getAttachedDbs();
    }
}
