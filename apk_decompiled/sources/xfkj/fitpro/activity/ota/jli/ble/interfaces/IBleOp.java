package xfkj.fitpro.activity.ota.jli.ble.interfaces;

import android.bluetooth.BluetoothGatt;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public interface IBleOp {
    int getBleMtu();

    boolean writeDataByBle(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, byte[] bArr);
}
