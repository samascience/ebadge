package com.jieli.bluetooth_connect.data.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import defpackage.ci2;
import defpackage.i50;
import defpackage.q50;
import defpackage.sw2;
import defpackage.th0;
import defpackage.uh0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class HistoryRecordDao_Impl implements HistoryRecordDao {
    private final RoomDatabase __db;
    private final th0 __deletionAdapterOfHistoryRecord;
    private final uh0 __insertionAdapterOfHistoryRecord;
    private final th0 __updateAdapterOfHistoryRecord;

    public HistoryRecordDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfHistoryRecord = new uh0(roomDatabase) { // from class: com.jieli.bluetooth_connect.data.dao.HistoryRecordDao_Impl.1
            @Override // defpackage.no2
            public String createQuery() {
                return "INSERT OR ABORT INTO `HistoryRecord` (`id`,`name`,`address`,`mapped_address`,`dev_type`,`connect_type`,`sdk_flag`,`vid`,`uid`,`pid`,`left_dev_lat`,`left_dev_lon`,`left_dev_update_time`,`right_dev_lat`,`right_dev_lon`,`right_dev_update_time`,`online_time`,`update_address`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // defpackage.uh0
            public void bind(sw2 sw2Var, HistoryRecord historyRecord) {
                sw2Var.i(1, historyRecord.getId());
                if (historyRecord.getName() == null) {
                    sw2Var.l0(2);
                } else {
                    sw2Var.f(2, historyRecord.getName());
                }
                if (historyRecord.getAddress() == null) {
                    sw2Var.l0(3);
                } else {
                    sw2Var.f(3, historyRecord.getAddress());
                }
                if (historyRecord.getMappedAddress() == null) {
                    sw2Var.l0(4);
                } else {
                    sw2Var.f(4, historyRecord.getMappedAddress());
                }
                sw2Var.i(5, historyRecord.getDevType());
                sw2Var.i(6, historyRecord.getConnectType());
                sw2Var.i(7, historyRecord.getSdkFlag());
                sw2Var.i(8, historyRecord.getVid());
                sw2Var.i(9, historyRecord.getUid());
                sw2Var.i(10, historyRecord.getPid());
                sw2Var.h(11, historyRecord.getLeftDevLatitude());
                sw2Var.h(12, historyRecord.getLeftDevLongitude());
                sw2Var.i(13, historyRecord.getLeftDevUpdateTime());
                sw2Var.h(14, historyRecord.getRightDevLatitude());
                sw2Var.h(15, historyRecord.getRightDevLongitude());
                sw2Var.i(16, historyRecord.getRightDevUpdateTime());
                sw2Var.i(17, historyRecord.getOnlineTime());
                if (historyRecord.getUpdateAddress() == null) {
                    sw2Var.l0(18);
                } else {
                    sw2Var.f(18, historyRecord.getUpdateAddress());
                }
            }
        };
        this.__deletionAdapterOfHistoryRecord = new th0(roomDatabase) { // from class: com.jieli.bluetooth_connect.data.dao.HistoryRecordDao_Impl.2
            @Override // defpackage.no2
            public String createQuery() {
                return "DELETE FROM `HistoryRecord` WHERE `id` = ?";
            }

            @Override // defpackage.th0
            public void bind(sw2 sw2Var, HistoryRecord historyRecord) {
                sw2Var.i(1, historyRecord.getId());
            }
        };
        this.__updateAdapterOfHistoryRecord = new th0(roomDatabase) { // from class: com.jieli.bluetooth_connect.data.dao.HistoryRecordDao_Impl.3
            @Override // defpackage.no2
            public String createQuery() {
                return "UPDATE OR ABORT `HistoryRecord` SET `id` = ?,`name` = ?,`address` = ?,`mapped_address` = ?,`dev_type` = ?,`connect_type` = ?,`sdk_flag` = ?,`vid` = ?,`uid` = ?,`pid` = ?,`left_dev_lat` = ?,`left_dev_lon` = ?,`left_dev_update_time` = ?,`right_dev_lat` = ?,`right_dev_lon` = ?,`right_dev_update_time` = ?,`online_time` = ?,`update_address` = ? WHERE `id` = ?";
            }

            @Override // defpackage.th0
            public void bind(sw2 sw2Var, HistoryRecord historyRecord) {
                sw2Var.i(1, historyRecord.getId());
                if (historyRecord.getName() == null) {
                    sw2Var.l0(2);
                } else {
                    sw2Var.f(2, historyRecord.getName());
                }
                if (historyRecord.getAddress() == null) {
                    sw2Var.l0(3);
                } else {
                    sw2Var.f(3, historyRecord.getAddress());
                }
                if (historyRecord.getMappedAddress() == null) {
                    sw2Var.l0(4);
                } else {
                    sw2Var.f(4, historyRecord.getMappedAddress());
                }
                sw2Var.i(5, historyRecord.getDevType());
                sw2Var.i(6, historyRecord.getConnectType());
                sw2Var.i(7, historyRecord.getSdkFlag());
                sw2Var.i(8, historyRecord.getVid());
                sw2Var.i(9, historyRecord.getUid());
                sw2Var.i(10, historyRecord.getPid());
                sw2Var.h(11, historyRecord.getLeftDevLatitude());
                sw2Var.h(12, historyRecord.getLeftDevLongitude());
                sw2Var.i(13, historyRecord.getLeftDevUpdateTime());
                sw2Var.h(14, historyRecord.getRightDevLatitude());
                sw2Var.h(15, historyRecord.getRightDevLongitude());
                sw2Var.i(16, historyRecord.getRightDevUpdateTime());
                sw2Var.i(17, historyRecord.getOnlineTime());
                if (historyRecord.getUpdateAddress() == null) {
                    sw2Var.l0(18);
                } else {
                    sw2Var.f(18, historyRecord.getUpdateAddress());
                }
                sw2Var.i(19, historyRecord.getId());
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void addHistoryRecord(HistoryRecord historyRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfHistoryRecord.insert(historyRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public HistoryRecord getHistoryRecord(String str) {
        ci2 ci2Var;
        HistoryRecord historyRecord;
        ci2 ci2VarW = ci2.w("SELECT * FROM HistoryRecord WHERE address LIKE ? OR mapped_address LIKE ? OR update_address LIKE ? ORDER BY online_time DESC LIMIT 1", 3);
        if (str == null) {
            ci2VarW.l0(1);
        } else {
            ci2VarW.f(1, str);
        }
        if (str == null) {
            ci2VarW.l0(2);
        } else {
            ci2VarW.f(2, str);
        }
        if (str == null) {
            ci2VarW.l0(3);
        } else {
            ci2VarW.f(3, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor cursorB = q50.b(this.__db, ci2VarW, false, null);
            try {
                int iB = i50.b(cursorB, "id");
                int iB2 = i50.b(cursorB, "name");
                int iB3 = i50.b(cursorB, "address");
                int iB4 = i50.b(cursorB, "mapped_address");
                int iB5 = i50.b(cursorB, "dev_type");
                int iB6 = i50.b(cursorB, "connect_type");
                int iB7 = i50.b(cursorB, "sdk_flag");
                int iB8 = i50.b(cursorB, "vid");
                int iB9 = i50.b(cursorB, "uid");
                int iB10 = i50.b(cursorB, "pid");
                int iB11 = i50.b(cursorB, "left_dev_lat");
                int iB12 = i50.b(cursorB, "left_dev_lon");
                int iB13 = i50.b(cursorB, "left_dev_update_time");
                ci2Var = ci2VarW;
                try {
                    int iB14 = i50.b(cursorB, "right_dev_lat");
                    try {
                        int iB15 = i50.b(cursorB, "right_dev_lon");
                        int iB16 = i50.b(cursorB, "right_dev_update_time");
                        int iB17 = i50.b(cursorB, "online_time");
                        int iB18 = i50.b(cursorB, "update_address");
                        if (cursorB.moveToFirst()) {
                            HistoryRecord historyRecord2 = new HistoryRecord();
                            historyRecord2.setId(cursorB.getInt(iB));
                            historyRecord2.setName(cursorB.isNull(iB2) ? null : cursorB.getString(iB2));
                            historyRecord2.setAddress(cursorB.isNull(iB3) ? null : cursorB.getString(iB3));
                            historyRecord2.setMappedAddress(cursorB.isNull(iB4) ? null : cursorB.getString(iB4));
                            historyRecord2.setDevType(cursorB.getInt(iB5));
                            historyRecord2.setConnectType(cursorB.getInt(iB6));
                            historyRecord2.setSdkFlag(cursorB.getInt(iB7));
                            historyRecord2.setVid(cursorB.getInt(iB8));
                            historyRecord2.setUid(cursorB.getInt(iB9));
                            historyRecord2.setPid(cursorB.getInt(iB10));
                            historyRecord2.setLeftDevLatitude(cursorB.getDouble(iB11));
                            historyRecord2.setLeftDevLongitude(cursorB.getDouble(iB12));
                            historyRecord2.setLeftDevUpdateTime(cursorB.getLong(iB13));
                            historyRecord2.setRightDevLatitude(cursorB.getDouble(iB14));
                            historyRecord2.setRightDevLongitude(cursorB.getDouble(iB15));
                            historyRecord2.setRightDevUpdateTime(cursorB.getLong(iB16));
                            historyRecord2.setOnlineTime(cursorB.getLong(iB17));
                            historyRecord2.setUpdateAddress(cursorB.isNull(iB18) ? null : cursorB.getString(iB18));
                            historyRecord = historyRecord2;
                        } else {
                            historyRecord = null;
                        }
                        this.__db.setTransactionSuccessful();
                        cursorB.close();
                        ci2Var.D();
                        this.__db.endTransaction();
                        return historyRecord;
                    } catch (Throwable th) {
                        th = th;
                        cursorB.close();
                        ci2Var.D();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                ci2Var = ci2VarW;
            }
        } catch (Throwable th4) {
            this.__db.endTransaction();
            throw th4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [ci2, rw2] */
    /* JADX WARN: Type inference failed for: r3v2 */
    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public List<HistoryRecord> getHistoryRecordList() throws Throwable {
        ci2 ci2Var;
        HistoryRecordDao_Impl historyRecordDao_ImplW = ci2.w("SELECT * FROM HistoryRecord ORDER BY online_time DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            try {
                Cursor cursorB = q50.b(this.__db, historyRecordDao_ImplW, false, null);
                try {
                    int iB = i50.b(cursorB, "id");
                    int iB2 = i50.b(cursorB, "name");
                    int iB3 = i50.b(cursorB, "address");
                    int iB4 = i50.b(cursorB, "mapped_address");
                    int iB5 = i50.b(cursorB, "dev_type");
                    int iB6 = i50.b(cursorB, "connect_type");
                    int iB7 = i50.b(cursorB, "sdk_flag");
                    int iB8 = i50.b(cursorB, "vid");
                    int iB9 = i50.b(cursorB, "uid");
                    int iB10 = i50.b(cursorB, "pid");
                    int iB11 = i50.b(cursorB, "left_dev_lat");
                    int iB12 = i50.b(cursorB, "left_dev_lon");
                    int iB13 = i50.b(cursorB, "left_dev_update_time");
                    ci2Var = historyRecordDao_ImplW;
                    try {
                        int iB14 = i50.b(cursorB, "right_dev_lat");
                        try {
                            int iB15 = i50.b(cursorB, "right_dev_lon");
                            int iB16 = i50.b(cursorB, "right_dev_update_time");
                            int iB17 = i50.b(cursorB, "online_time");
                            int iB18 = i50.b(cursorB, "update_address");
                            int i = iB14;
                            ArrayList arrayList = new ArrayList(cursorB.getCount());
                            while (cursorB.moveToNext()) {
                                HistoryRecord historyRecord = new HistoryRecord();
                                ArrayList arrayList2 = arrayList;
                                historyRecord.setId(cursorB.getInt(iB));
                                historyRecord.setName(cursorB.isNull(iB2) ? null : cursorB.getString(iB2));
                                historyRecord.setAddress(cursorB.isNull(iB3) ? null : cursorB.getString(iB3));
                                historyRecord.setMappedAddress(cursorB.isNull(iB4) ? null : cursorB.getString(iB4));
                                historyRecord.setDevType(cursorB.getInt(iB5));
                                historyRecord.setConnectType(cursorB.getInt(iB6));
                                historyRecord.setSdkFlag(cursorB.getInt(iB7));
                                historyRecord.setVid(cursorB.getInt(iB8));
                                historyRecord.setUid(cursorB.getInt(iB9));
                                historyRecord.setPid(cursorB.getInt(iB10));
                                int i2 = iB;
                                historyRecord.setLeftDevLatitude(cursorB.getDouble(iB11));
                                historyRecord.setLeftDevLongitude(cursorB.getDouble(iB12));
                                historyRecord.setLeftDevUpdateTime(cursorB.getLong(iB13));
                                int i3 = iB2;
                                int i4 = i;
                                int i5 = iB13;
                                historyRecord.setRightDevLatitude(cursorB.getDouble(i4));
                                int i6 = iB15;
                                historyRecord.setRightDevLongitude(cursorB.getDouble(i6));
                                int i7 = iB16;
                                historyRecord.setRightDevUpdateTime(cursorB.getLong(i7));
                                int i8 = iB17;
                                historyRecord.setOnlineTime(cursorB.getLong(i8));
                                int i9 = iB18;
                                historyRecord.setUpdateAddress(cursorB.isNull(i9) ? null : cursorB.getString(i9));
                                arrayList = arrayList2;
                                arrayList.add(historyRecord);
                                iB18 = i9;
                                iB = i2;
                                iB17 = i8;
                                iB13 = i5;
                                i = i4;
                                iB16 = i7;
                                iB2 = i3;
                                iB15 = i6;
                            }
                            try {
                                this.__db.setTransactionSuccessful();
                                cursorB.close();
                                ci2Var.D();
                                this.__db.endTransaction();
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                cursorB.close();
                                ci2Var.D();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursorB.close();
                        ci2Var.D();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    ci2Var = historyRecordDao_ImplW;
                }
            } catch (Throwable th5) {
                th = th5;
                historyRecordDao_ImplW = this;
                historyRecordDao_ImplW.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            historyRecordDao_ImplW.__db.endTransaction();
            throw th;
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void removeHistoryRecord(HistoryRecord historyRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfHistoryRecord.handle(historyRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void removeHistoryRecords(List<HistoryRecord> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfHistoryRecord.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void updateHistoryRecord(HistoryRecord historyRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfHistoryRecord.handle(historyRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jieli.bluetooth_connect.data.dao.HistoryRecordDao
    public void updateHistoryRecords(List<HistoryRecord> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfHistoryRecord.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
