package com.example.bluetoothlibrary.model;

import android.bluetooth.BluetoothDevice;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SearchDevice implements Serializable {
    public BluetoothDevice bluetoothDevice;
    public int rssi;
    public byte[] scanRecord;

    public SearchDevice(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.bluetoothDevice = bluetoothDevice;
        this.rssi = i;
        this.scanRecord = bArr;
    }
}
