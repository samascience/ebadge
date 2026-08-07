package xfkj.fitpro.db;

import android.app.Application;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import defpackage.g82;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DBContextWrapper extends ContextWrapper {
    private String path;

    public DBContextWrapper(Application application) {
        super(application);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TextUtils.isEmpty(this.path) ? g82.d : this.path);
        stringBuffer.append(str);
        return new File(stringBuffer.toString());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    public DBContextWrapper(Application application, String str) {
        super(application);
        this.path = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }
}
