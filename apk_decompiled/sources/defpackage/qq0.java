package defpackage;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class qq0 implements pw2 {
    private final Context a;
    private final String b;
    private final pw2.a c;
    private final boolean d;
    private final Object e = new Object();
    private a f;
    private boolean g;

    static class a extends SQLiteOpenHelper {
        final pq0[] a;
        final pw2.a b;
        private boolean c;

        /* JADX INFO: renamed from: qq0$a$a, reason: collision with other inner class name */
        class C0166a implements DatabaseErrorHandler {
            final /* synthetic */ pw2.a a;
            final /* synthetic */ pq0[] b;

            C0166a(pw2.a aVar, pq0[] pq0VarArr) {
                this.a = aVar;
                this.b = pq0VarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.a.c(a.u(this.b, sQLiteDatabase));
            }
        }

        a(Context context, String str, pq0[] pq0VarArr, pw2.a aVar) {
            super(context, str, null, aVar.a, new C0166a(aVar, pq0VarArr));
            this.b = aVar;
            this.a = pq0VarArr;
        }

        static pq0 u(pq0[] pq0VarArr, SQLiteDatabase sQLiteDatabase) {
            pq0 pq0Var = pq0VarArr[0];
            if (pq0Var == null || !pq0Var.n(sQLiteDatabase)) {
                pq0VarArr[0] = new pq0(sQLiteDatabase);
            }
            return pq0VarArr[0];
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.a[0] = null;
        }

        pq0 n(SQLiteDatabase sQLiteDatabase) {
            return u(this.a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.b.b(n(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.b.d(n(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.e(n(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.c) {
                return;
            }
            this.b.f(n(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.g(n(sQLiteDatabase), i, i2);
        }

        synchronized ow2 w() {
            this.c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.c) {
                return n(writableDatabase);
            }
            close();
            return w();
        }
    }

    qq0(Context context, String str, pw2.a aVar, boolean z) {
        this.a = context;
        this.b = str;
        this.c = aVar;
        this.d = z;
    }

    private a n() {
        a aVar;
        synchronized (this.e) {
            try {
                if (this.f == null) {
                    pq0[] pq0VarArr = new pq0[1];
                    if (this.b == null || !this.d) {
                        this.f = new a(this.a, this.b, pq0VarArr, this.c);
                    } else {
                        this.f = new a(this.a, new File(this.a.getNoBackupFilesDir(), this.b).getAbsolutePath(), pq0VarArr, this.c);
                    }
                    this.f.setWriteAheadLoggingEnabled(this.g);
                }
                aVar = this.f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // defpackage.pw2
    public ow2 U() {
        return n().w();
    }

    @Override // defpackage.pw2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n().close();
    }

    @Override // defpackage.pw2
    public String getDatabaseName() {
        return this.b;
    }

    @Override // defpackage.pw2
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.e) {
            try {
                a aVar = this.f;
                if (aVar != null) {
                    aVar.setWriteAheadLoggingEnabled(z);
                }
                this.g = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
