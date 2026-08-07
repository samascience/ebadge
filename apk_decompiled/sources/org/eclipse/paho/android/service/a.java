package org.eclipse.paho.android.service;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import defpackage.fl1;

/* JADX INFO: loaded from: classes4.dex */
class a implements b {
    private SQLiteDatabase a = null;
    private C0162a b;
    private fl1 c;

    /* JADX INFO: renamed from: org.eclipse.paho.android.service.a$a, reason: collision with other inner class name */
    private static class C0162a extends SQLiteOpenHelper {
        private fl1 a;

        public C0162a(fl1 fl1Var, Context context) {
            super(context, "mqttAndroidService.db", (SQLiteDatabase.CursorFactory) null, 1);
            this.a = fl1Var;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.a.b("MQTTDatabaseHelper", "onCreate {CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);}");
            try {
                sQLiteDatabase.execSQL("CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);");
                this.a.b("MQTTDatabaseHelper", "created the table");
            } catch (SQLException e) {
                this.a.c("MQTTDatabaseHelper", "onCreate", e);
                throw e;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.a.b("MQTTDatabaseHelper", "onUpgrade");
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MqttArrivedMessageTable");
                onCreate(sQLiteDatabase);
                this.a.b("MQTTDatabaseHelper", "onUpgrade complete");
            } catch (SQLException e) {
                this.a.c("MQTTDatabaseHelper", "onUpgrade", e);
                throw e;
            }
        }
    }

    public a(MqttService mqttService, Context context) {
        this.b = null;
        this.c = mqttService;
        this.b = new C0162a(this.c, context);
        this.c.b("DatabaseMessageStore", "DatabaseMessageStore<init> complete");
    }

    private int b(String str) {
        Cursor cursorQuery = this.a.query("MqttArrivedMessageTable", new String[]{"messageId"}, "clientHandle=?", new String[]{str}, null, null, null);
        int i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        cursorQuery.close();
        return i;
    }

    @Override // org.eclipse.paho.android.service.b
    public boolean a(String str, String str2) {
        this.a = this.b.getWritableDatabase();
        this.c.b("DatabaseMessageStore", "discardArrived{" + str + "}, {" + str2 + "}");
        try {
            int iDelete = this.a.delete("MqttArrivedMessageTable", "messageId=? AND clientHandle=?", new String[]{str2, str});
            if (iDelete == 1) {
                int iB = b(str);
                this.c.b("DatabaseMessageStore", "discardArrived - Message deleted successfully. - messages in db for this clientHandle " + iB);
                return true;
            }
            this.c.a("DatabaseMessageStore", "discardArrived - Error deleting message {" + str2 + "} from database: Rows affected = " + iDelete);
            return false;
        } catch (SQLException e) {
            this.c.c("DatabaseMessageStore", "discardArrived", e);
            throw e;
        }
    }

    @Override // org.eclipse.paho.android.service.b
    public void close() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }
}
