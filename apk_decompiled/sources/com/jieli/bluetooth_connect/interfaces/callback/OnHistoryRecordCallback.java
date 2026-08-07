package com.jieli.bluetooth_connect.interfaces.callback;

import com.jieli.bluetooth_connect.bean.history.HistoryRecord;

/* JADX INFO: loaded from: classes3.dex */
public interface OnHistoryRecordCallback {
    void onFailed(int i, String str);

    void onSuccess(HistoryRecord historyRecord);
}
