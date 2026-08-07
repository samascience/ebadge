package com.jieli.bluetooth_connect.interfaces.listener;

import android.bluetooth.BluetoothDevice;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public interface OnWriteDataCallback {
    void onBleResult(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, boolean z, byte[] bArr);
}
