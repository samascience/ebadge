package com.legend.mywatch.sdk.mywatchsdklib.android.excepion;

/* JADX INFO: loaded from: classes3.dex */
public class NotSupportBluetoothException extends RuntimeException {
    public NotSupportBluetoothException() {
        super("not supported on Bluetooth");
    }

    public NotSupportBluetoothException(String str) {
        super(str);
    }
}
