package defpackage;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes3.dex */
public class pj0 {
    public final BluetoothDevice a;
    public int b;

    public pj0(BluetoothDevice bluetoothDevice, int i) {
        this.a = bluetoothDevice;
        this.b = i;
    }

    public boolean a(BluetoothDevice bluetoothDevice) {
        return this.a.getAddress().equals(bluetoothDevice.getAddress());
    }
}
