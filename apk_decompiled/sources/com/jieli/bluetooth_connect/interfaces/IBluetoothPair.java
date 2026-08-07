package com.jieli.bluetooth_connect.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IBluetoothPair extends IBluetoothBase<OnBtDevicePairListener> {
    List<BluetoothDevice> getPairedDevices();

    boolean isPaired(BluetoothDevice bluetoothDevice);

    boolean isPairing(BluetoothDevice bluetoothDevice);

    boolean pair(BluetoothDevice bluetoothDevice);

    boolean pair(BluetoothDevice bluetoothDevice, int i);

    boolean tryToPair(BluetoothDevice bluetoothDevice);

    boolean tryToPair(BluetoothDevice bluetoothDevice, int i);

    boolean tryToUnPair(BluetoothDevice bluetoothDevice);

    boolean unPair(BluetoothDevice bluetoothDevice);
}
