package androidx.room;

import android.database.Cursor;
import defpackage.bi2;
import defpackage.ek1;
import defpackage.hp2;
import defpackage.ow2;
import defpackage.pw2;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends pw2.a {
    private androidx.room.a b;
    private final a c;
    private final String d;
    private final String e;

    public static abstract class a {
        public final int version;

        public a(int i) {
            this.version = i;
        }

        protected abstract void createAllTables(ow2 ow2Var);

        protected abstract void dropAllTables(ow2 ow2Var);

        protected abstract void onCreate(ow2 ow2Var);

        protected abstract void onOpen(ow2 ow2Var);

        protected abstract void onPostMigrate(ow2 ow2Var);

        protected abstract void onPreMigrate(ow2 ow2Var);

        protected abstract b onValidateSchema(ow2 ow2Var);

        @Deprecated
        protected void validateMigration(ow2 ow2Var) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    public static class b {
        public final boolean a;
        public final String b;

        public b(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    public h(androidx.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.version);
        this.b = aVar;
        this.c = aVar2;
        this.d = str;
        this.e = str2;
    }

    private void h(ow2 ow2Var) {
        if (!k(ow2Var)) {
            b bVarOnValidateSchema = this.c.onValidateSchema(ow2Var);
            if (bVarOnValidateSchema.a) {
                this.c.onPostMigrate(ow2Var);
                l(ow2Var);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarOnValidateSchema.b);
            }
        }
        Cursor cursorT = ow2Var.t(new hp2("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = cursorT.moveToFirst() ? cursorT.getString(0) : null;
            cursorT.close();
            if (!this.d.equals(string) && !this.e.equals(string)) {
                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
        } catch (Throwable th) {
            cursorT.close();
            throw th;
        }
    }

    private void i(ow2 ow2Var) {
        ow2Var.e("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(ow2 ow2Var) {
        Cursor cursorW = ow2Var.W("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (cursorW.moveToFirst() && cursorW.getInt(0) == 0) {
                z = true;
            }
            return z;
        } finally {
            cursorW.close();
        }
    }

    private static boolean k(ow2 ow2Var) {
        Cursor cursorW = ow2Var.W("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (cursorW.moveToFirst() && cursorW.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            cursorW.close();
        }
    }

    private void l(ow2 ow2Var) {
        i(ow2Var);
        ow2Var.e(bi2.a(this.d));
    }

    @Override // pw2.a
    public void b(ow2 ow2Var) {
        super.b(ow2Var);
    }

    @Override // pw2.a
    public void d(ow2 ow2Var) {
        boolean zJ = j(ow2Var);
        this.c.createAllTables(ow2Var);
        if (!zJ) {
            b bVarOnValidateSchema = this.c.onValidateSchema(ow2Var);
            if (!bVarOnValidateSchema.a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarOnValidateSchema.b);
            }
        }
        l(ow2Var);
        this.c.onCreate(ow2Var);
    }

    @Override // pw2.a
    public void e(ow2 ow2Var, int i, int i2) {
        g(ow2Var, i, i2);
    }

    @Override // pw2.a
    public void f(ow2 ow2Var) {
        super.f(ow2Var);
        h(ow2Var);
        this.c.onOpen(ow2Var);
        this.b = null;
    }

    @Override // pw2.a
    public void g(ow2 ow2Var, int i, int i2) {
        List listC;
        androidx.room.a aVar = this.b;
        if (aVar == null || (listC = aVar.d.c(i, i2)) == null) {
            androidx.room.a aVar2 = this.b;
            if (aVar2 != null && !aVar2.a(i, i2)) {
                this.c.dropAllTables(ow2Var);
                this.c.createAllTables(ow2Var);
                return;
            }
            throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        this.c.onPreMigrate(ow2Var);
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            ((ek1) it.next()).migrate(ow2Var);
        }
        b bVarOnValidateSchema = this.c.onValidateSchema(ow2Var);
        if (bVarOnValidateSchema.a) {
            this.c.onPostMigrate(ow2Var);
            l(ow2Var);
        } else {
            throw new IllegalStateException("Migration didn't properly handle: " + bVarOnValidateSchema.b);
        }
    }
}
