package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface zx0 {
    List a();

    void b(Context context, boolean z);

    void c(Context context);

    void d();

    void e(yu1 yu1Var, long j);

    void f(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    boolean g(int i);

    boolean h(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    void i(boolean z, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void j(Context context, BluetoothDevice bluetoothDevice, long j, ru1 ru1Var);
}
