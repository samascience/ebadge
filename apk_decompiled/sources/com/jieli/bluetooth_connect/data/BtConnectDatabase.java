package com.jieli.bluetooth_connect.data;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.g;
import com.jieli.bluetooth_connect.data.dao.HistoryRecordDao;
import defpackage.ek1;
import defpackage.ow2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BtConnectDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "bt_data.db";
    static final ek1 MIGRATION_1_2;
    static final ek1 MIGRATION_2_3;

    static {
        int i = 2;
        MIGRATION_1_2 = new ek1(1, i) { // from class: com.jieli.bluetooth_connect.data.BtConnectDatabase.1
            @Override // defpackage.ek1
            public void migrate(ow2 ow2Var) {
                ow2Var.e("ALTER TABLE HistoryRecord RENAME TO __HistoryRecord_old");
                ow2Var.e("CREATE TABLE IF NOT EXISTS `HistoryRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `address` TEXT NOT NULL, `mapped_address` TEXT, `dev_type` INTEGER NOT NULL, `connect_type` INTEGER NOT NULL, `sdk_flag` INTEGER NOT NULL, `vid` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `pid` INTEGER NOT NULL, `left_dev_lat` REAL NOT NULL, `left_dev_lon` REAL NOT NULL, `left_dev_update_time` INTEGER NOT NULL, `right_dev_lat` REAL NOT NULL, `right_dev_lon` REAL NOT NULL, `right_dev_update_time` INTEGER NOT NULL, `online_time` INTEGER NOT NULL)");
                ow2Var.e("INSERT INTO `HistoryRecord`(`name`, `address`, `mapped_address`, `dev_type`, `connect_type`, `sdk_flag`, `vid`, `uid`, `pid`, `left_dev_lat`, `left_dev_lon`, `left_dev_update_time`, `right_dev_lat`, `right_dev_lon`, `right_dev_update_time`, `online_time`) SELECT `name`, `address`, `mapped_address`, `dev_type`, `connect_type`, `sdk_flag`, `vid`, `uid`, `pid`, `left_dev_lat`, `left_dev_lon`, `left_dev_update_time`, `right_dev_lat`, `right_dev_lon`, `right_dev_update_time`, `online_time` FROM __HistoryRecord_old");
                ow2Var.e("DROP TABLE __HistoryRecord_old;");
            }
        };
        MIGRATION_2_3 = new ek1(i, 3) { // from class: com.jieli.bluetooth_connect.data.BtConnectDatabase.2
            @Override // defpackage.ek1
            public void migrate(ow2 ow2Var) {
                ow2Var.e("ALTER TABLE HistoryRecord ADD COLUMN `update_address` TEXT DEFAULT \"\"");
            }
        };
    }

    public static BtConnectDatabase buildDatabase(Context context) {
        return (BtConnectDatabase) g.a(context, BtConnectDatabase.class, DATABASE_NAME).c().b(MIGRATION_1_2, MIGRATION_2_3).d();
    }

    public abstract HistoryRecordDao historyRecordDao();
}
