package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes.dex */
public interface ru1 {
    void a(String str);

    void b(String str, int i);

    void c(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, int i);

    void d(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, int i);

    void e(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, String str, int i);

    void f(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, byte[] bArr, String str);

    void g(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, int i);

    void h(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, byte[] bArr);

    void i(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    void j(BluetoothGatt bluetoothGatt, int i, int i2);

    void k(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice);

    void l(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice);
}
