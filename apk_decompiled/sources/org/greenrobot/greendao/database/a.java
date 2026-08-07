package org.greenrobot.greendao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import defpackage.mt2;
import defpackage.r60;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends SQLiteOpenHelper {
    private final Context context;
    private InterfaceC0163a encryptedHelper;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    /* JADX INFO: renamed from: org.greenrobot.greendao.database.a$a, reason: collision with other inner class name */
    interface InterfaceC0163a {
        r60 getEncryptedReadableDb(String str);

        r60 getEncryptedReadableDb(char[] cArr);

        r60 getEncryptedWritableDb(String str);

        r60 getEncryptedWritableDb(char[] cArr);
    }

    public a(Context context, String str, int i) {
        this(context, str, null, i);
    }

    private InterfaceC0163a n() {
        if (this.encryptedHelper == null) {
            try {
                Class.forName("net.sqlcipher.database.SQLiteOpenHelper");
                try {
                    this.encryptedHelper = (InterfaceC0163a) Class.forName("org.greenrobot.greendao.database.SqlCipherEncryptedHelper").getConstructor(a.class, Context.class, String.class, Integer.TYPE, Boolean.TYPE).newInstance(this, this.context, this.name, Integer.valueOf(this.version), Boolean.valueOf(this.loadSQLCipherNativeLibs));
                } catch (Exception e) {
                    throw new DaoException(e);
                }
            } catch (ClassNotFoundException unused) {
                throw new DaoException("Using an encrypted database requires SQLCipher, make sure to add it to dependencies: https://greenrobot.org/greendao/documentation/database-encryption/");
            }
        }
        return this.encryptedHelper;
    }

    public r60 getEncryptedReadableDb(String str) {
        return n().getEncryptedReadableDb(str);
    }

    public r60 getEncryptedWritableDb(String str) {
        return n().getEncryptedWritableDb(str);
    }

    public r60 getReadableDb() {
        return wrap(getReadableDatabase());
    }

    public r60 getWritableDb() {
        return wrap(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    public abstract void onCreate(r60 r60Var);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(wrap(sQLiteDatabase), i, i2);
    }

    public void setLoadSQLCipherNativeLibs(boolean z) {
        this.loadSQLCipherNativeLibs = z;
    }

    protected r60 wrap(SQLiteDatabase sQLiteDatabase) {
        return new mt2(sQLiteDatabase);
    }

    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.loadSQLCipherNativeLibs = true;
        this.context = context;
        this.name = str;
        this.version = i;
    }

    public void onOpen(r60 r60Var) {
    }

    public void onUpgrade(r60 r60Var, int i, int i2) {
    }

    public r60 getEncryptedReadableDb(char[] cArr) {
        return n().getEncryptedReadableDb(cArr);
    }

    public r60 getEncryptedWritableDb(char[] cArr) {
        return n().getEncryptedWritableDb(cArr);
    }
}
