package defpackage;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes4.dex */
public class hj0 {
    private BluetoothDevice a;
    private int b;

    public hj0(BluetoothDevice bluetoothDevice, int i) {
        this.a = bluetoothDevice;
        this.b = i;
    }

    public BluetoothDevice a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "ExpandBluetoothDevice{bluetoothDevice=[ name = " + this.a.getName() + ", address = " + this.a.getAddress() + "], rSSI=" + this.b + '}';
    }
}
