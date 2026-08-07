package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum BluetoothStatusEnum {
    CONNECT_FAILED(-4),
    MAIN_SERVICE_NOT_MATCH(-3),
    NOT_SUPPORT_BLUETOOTH(-2),
    BLUETOOTH_NOT_OPENED(-1),
    DISCONNECT(0),
    CONNECTED(1),
    CONNECTING(2);

    private int value;

    BluetoothStatusEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
