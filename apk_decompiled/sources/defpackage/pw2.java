package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface pw2 extends Closeable {

    public static abstract class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e) {
                Log.w("SupportSQLite", "delete failed: ", e);
            }
        }

        public void b(ow2 ow2Var) {
        }

        public void c(ow2 ow2Var) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + ow2Var.c());
            if (!ow2Var.isOpen()) {
                a(ow2Var.c());
                return;
            }
            List listV = null;
            try {
                try {
                    listV = ow2Var.v();
                } catch (SQLiteException unused) {
                }
                try {
                    ow2Var.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (listV != null) {
                    Iterator it = listV.iterator();
                    while (it.hasNext()) {
                        a((String) ((Pair) it.next()).second);
                    }
                } else {
                    a(ow2Var.c());
                }
            }
        }

        public abstract void d(ow2 ow2Var);

        public abstract void e(ow2 ow2Var, int i, int i2);

        public void f(ow2 ow2Var) {
        }

        public abstract void g(ow2 ow2Var, int i, int i2);
    }

    public static class b {
        public final Context a;
        public final String b;
        public final a c;
        public final boolean d;

        public static class a {
            Context a;
            String b;
            a c;
            boolean d;

            a(Context context) {
                this.a = context;
            }

            public b a() {
                if (this.c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.d && TextUtils.isEmpty(this.b)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.a, this.b, this.c, this.d);
            }

            public a b(a aVar) {
                this.c = aVar;
                return this;
            }

            public a c(String str) {
                this.b = str;
                return this;
            }

            public a d(boolean z) {
                this.d = z;
                return this;
            }
        }

        b(Context context, String str, a aVar, boolean z) {
            this.a = context;
            this.b = str;
            this.c = aVar;
            this.d = z;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    public interface c {
        pw2 a(b bVar);
    }

    ow2 U();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z);
}
