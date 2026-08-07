package defpackage;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
class sq0 implements qw2 {
    private final SQLiteProgram a;

    sq0(SQLiteProgram sQLiteProgram) {
        this.a = sQLiteProgram;
    }

    @Override // defpackage.qw2
    public void R(int i, byte[] bArr) {
        this.a.bindBlob(i, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // defpackage.qw2
    public void f(int i, String str) {
        this.a.bindString(i, str);
    }

    @Override // defpackage.qw2
    public void h(int i, double d) {
        this.a.bindDouble(i, d);
    }

    @Override // defpackage.qw2
    public void i(int i, long j) {
        this.a.bindLong(i, j);
    }

    @Override // defpackage.qw2
    public void l0(int i) {
        this.a.bindNull(i);
    }
}
