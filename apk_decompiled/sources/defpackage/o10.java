package defpackage;

import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;

/* JADX INFO: loaded from: classes3.dex */
public class o10 extends ng {
    public static final int b = BluetoothStatusEnum.MAIN_SERVICE_NOT_MATCH.getValue();
    public static final int c = BluetoothStatusEnum.NOT_SUPPORT_BLUETOOTH.getValue();
    public static final int d = BluetoothStatusEnum.BLUETOOTH_NOT_OPENED.getValue();
    public static final int e = BluetoothStatusEnum.DISCONNECT.getValue();
    public static final int f = BluetoothStatusEnum.CONNECTED.getValue();
    public static final int g = BluetoothStatusEnum.CONNECTING.getValue();
    private int a;

    public o10(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public boolean isConnected() {
        return this.a == BluetoothStatusEnum.CONNECTED.getValue();
    }
}
