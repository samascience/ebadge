package com.jieli.bluetooth_connect.data;

import androidx.room.RoomDatabase;
import androidx.room.a;
import androidx.room.e;
import androidx.room.h;
import com.jieli.bluetooth_connect.data.dao.HistoryRecordDao;
import com.jieli.bluetooth_connect.data.dao.HistoryRecordDao_Impl;
import defpackage.ow2;
import defpackage.pw2;
import defpackage.q50;
import defpackage.tz2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class BtConnectDatabase_Impl extends BtConnectDatabase {
    private volatile HistoryRecordDao _historyRecordDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        ow2 ow2VarU = super.getOpenHelper().U();
        try {
            super.beginTransaction();
            ow2VarU.e("DELETE FROM `HistoryRecord`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            ow2VarU.W("PRAGMA wal_checkpoint(FULL)").close();
            if (!ow2VarU.r0()) {
                ow2VarU.e("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected e createInvalidationTracker() {
        return new e(this, new HashMap(0), new HashMap(0), "HistoryRecord");
    }

    @Override // androidx.room.RoomDatabase
    protected pw2 createOpenHelper(a aVar) {
        return aVar.a.a(pw2.b.a(aVar.b).c(aVar.c).b(new h(aVar, new h.a(3) { // from class: com.jieli.bluetooth_connect.data.BtConnectDatabase_Impl.1
            @Override // androidx.room.h.a
            public void createAllTables(ow2 ow2Var) {
                ow2Var.e("CREATE TABLE IF NOT EXISTS `HistoryRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `address` TEXT NOT NULL, `mapped_address` TEXT, `dev_type` INTEGER NOT NULL, `connect_type` INTEGER NOT NULL, `sdk_flag` INTEGER NOT NULL, `vid` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `pid` INTEGER NOT NULL, `left_dev_lat` REAL NOT NULL, `left_dev_lon` REAL NOT NULL, `left_dev_update_time` INTEGER NOT NULL, `right_dev_lat` REAL NOT NULL, `right_dev_lon` REAL NOT NULL, `right_dev_update_time` INTEGER NOT NULL, `online_time` INTEGER NOT NULL, `update_address` TEXT)");
                ow2Var.e("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                ow2Var.e("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '37c904c212639270e9bf47ab0db1554c')");
            }

            @Override // androidx.room.h.a
            public void dropAllTables(ow2 ow2Var) {
                ow2Var.e("DROP TABLE IF EXISTS `HistoryRecord`");
                if (((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.b) ((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks.get(i)).b(ow2Var);
                    }
                }
            }

            @Override // androidx.room.h.a
            protected void onCreate(ow2 ow2Var) {
                if (((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.b) ((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks.get(i)).a(ow2Var);
                    }
                }
            }

            @Override // androidx.room.h.a
            public void onOpen(ow2 ow2Var) {
                ((RoomDatabase) BtConnectDatabase_Impl.this).mDatabase = ow2Var;
                BtConnectDatabase_Impl.this.internalInitInvalidationTracker(ow2Var);
                if (((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.b) ((RoomDatabase) BtConnectDatabase_Impl.this).mCallbacks.get(i)).c(ow2Var);
                    }
                }
            }

            @Override // androidx.room.h.a
            public void onPostMigrate(ow2 ow2Var) {
            }

            @Override // androidx.room.h.a
            public void onPreMigrate(ow2 ow2Var) {
                q50.a(ow2Var);
            }

            @Override // androidx.room.h.a
            protected h.b onValidateSchema(ow2 ow2Var) {
                HashMap map = new HashMap(18);
                map.put("id", new tz2.a("id", "INTEGER", true, 1, null, 1));
                map.put("name", new tz2.a("name", "TEXT", false, 0, null, 1));
                map.put("address", new tz2.a("address", "TEXT", true, 0, null, 1));
                map.put("mapped_address", new tz2.a("mapped_address", "TEXT", false, 0, null, 1));
                map.put("dev_type", new tz2.a("dev_type", "INTEGER", true, 0, null, 1));
                map.put("connect_type", new tz2.a("connect_type", "INTEGER", true, 0, null, 1));
                map.put("sdk_flag", new tz2.a("sdk_flag", "INTEGER", true, 0, null, 1));
                map.put("vid", new tz2.a("vid", "INTEGER", true, 0, null, 1));
                map.put("uid", new tz2.a("uid", "INTEGER", true, 0, null, 1));
                map.put("pid", new tz2.a("pid", "INTEGER", true, 0, null, 1));
                map.put("left_dev_lat", new tz2.a("left_dev_lat", "REAL", true, 0, null, 1));
                map.put("left_dev_lon", new tz2.a("left_dev_lon", "REAL", true, 0, null, 1));
                map.put("left_dev_update_time", new tz2.a("left_dev_update_time", "INTEGER", true, 0, null, 1));
                map.put("right_dev_lat", new tz2.a("right_dev_lat", "REAL", true, 0, null, 1));
                map.put("right_dev_lon", new tz2.a("right_dev_lon", "REAL", true, 0, null, 1));
                map.put("right_dev_update_time", new tz2.a("right_dev_update_time", "INTEGER", true, 0, null, 1));
                map.put("online_time", new tz2.a("online_time", "INTEGER", true, 0, null, 1));
                map.put("update_address", new tz2.a("update_address", "TEXT", false, 0, null, 1));
                tz2 tz2Var = new tz2("HistoryRecord", map, new HashSet(0), new HashSet(0));
                tz2 tz2VarA = tz2.a(ow2Var, "HistoryRecord");
                if (tz2Var.equals(tz2VarA)) {
                    return new h.b(true, null);
                }
                return new h.b(false, "HistoryRecord(com.jieli.bluetooth_connect.bean.history.HistoryRecord).\n Expected:\n" + tz2Var + "\n Found:\n" + tz2VarA);
            }
        }, "37c904c212639270e9bf47ab0db1554c", "9eb7cb727e7ddaae57f54c68f427f12d")).a());
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(HistoryRecordDao.class, HistoryRecordDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // com.jieli.bluetooth_connect.data.BtConnectDatabase
    public HistoryRecordDao historyRecordDao() {
        HistoryRecordDao historyRecordDao;
        if (this._historyRecordDao != null) {
            return this._historyRecordDao;
        }
        synchronized (this) {
            try {
                if (this._historyRecordDao == null) {
                    this._historyRecordDao = new HistoryRecordDao_Impl(this);
                }
                historyRecordDao = this._historyRecordDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return historyRecordDao;
    }
}
