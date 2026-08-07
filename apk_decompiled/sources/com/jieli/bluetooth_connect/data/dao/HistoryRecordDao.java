package com.jieli.bluetooth_connect.data.dao;

import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface HistoryRecordDao {
    void addHistoryRecord(HistoryRecord historyRecord);

    HistoryRecord getHistoryRecord(String str);

    List<HistoryRecord> getHistoryRecordList();

    void removeHistoryRecord(HistoryRecord historyRecord);

    void removeHistoryRecords(List<HistoryRecord> list);

    void updateHistoryRecord(HistoryRecord historyRecord);

    void updateHistoryRecords(List<HistoryRecord> list);
}
