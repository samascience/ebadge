package xfkj.fitpro.activity.ota.jieli;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes4.dex */
public interface OnBleEventListener {
    void onConnect(BluetoothDevice bluetoothDevice, int i);

    void onReceiveData(BluetoothDevice bluetoothDevice, byte[] bArr);
}
