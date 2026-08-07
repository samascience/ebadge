package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes4.dex */
public interface DfuDeviceSelector {
    boolean matches(BluetoothDevice bluetoothDevice, int i, byte[] bArr, String str, String str2);
}
