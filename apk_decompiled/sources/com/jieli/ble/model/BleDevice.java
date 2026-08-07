package com.jieli.ble.model;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import com.jieli.ble.SendBleDataThread;
import com.jieli.ble.interfaces.OnThreadStateListener;
import com.jieli.ble.interfaces.OnWriteDataCallback;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.util.AppUtil;
import java.util.UUID;
import xfkj.fitpro.activity.ota.jli.ble.interfaces.IBleOp;

/* JADX INFO: loaded from: classes3.dex */
public class BleDevice {
    private long connectedTime;
    private final Context context;
    private final BluetoothGatt gatt;
    private SendBleDataThread sendDataThread;
    private final String tag = "BleManager";
    private int mtu = 20;

    public BleDevice(Context context, BluetoothGatt bluetoothGatt) {
        this.context = context;
        this.gatt = bluetoothGatt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public boolean writeDataToDeviceByBle(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, byte[] bArr) {
        boolean zWriteCharacteristic = false;
        if (bluetoothGatt == null || uuid == null || uuid2 == null || bArr == null || bArr.length == 0 || !AppUtil.checkHasConnectPermission(this.context)) {
            JL_Log.d("BleManager", "writeDataByBle : param is invalid.");
            return false;
        }
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            JL_Log.d("BleManager", "writeDataByBle : service is null.");
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        if (characteristic == null) {
            JL_Log.d("BleManager", "writeDataByBle : characteristic is null");
            return false;
        }
        try {
            characteristic.setValue(bArr);
            zWriteCharacteristic = bluetoothGatt.writeCharacteristic(characteristic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JL_Log.d("BleManager", "writeDataByBle : send ret : " + zWriteCharacteristic + ", data = " + CHexConver.byte2HexStr(bArr));
        return zWriteCharacteristic;
    }

    public boolean addSendTask(UUID uuid, UUID uuid2, byte[] bArr, OnWriteDataCallback onWriteDataCallback) {
        SendBleDataThread sendBleDataThread = this.sendDataThread;
        if (sendBleDataThread == null || !sendBleDataThread.isRunning()) {
            return false;
        }
        return this.sendDataThread.addSendTask(this.gatt, uuid, uuid2, bArr, onWriteDataCallback);
    }

    public long getConnectedTime() {
        return this.connectedTime;
    }

    public BluetoothGatt getGatt() {
        return this.gatt;
    }

    public int getMtu() {
        int i = this.mtu;
        if (i > 128) {
            this.mtu = i - 6;
        }
        return this.mtu;
    }

    public void setConnectedTime(long j) {
        this.connectedTime = j;
    }

    public void setMtu(int i) {
        this.mtu = i;
    }

    public void startSendDataThread() {
        SendBleDataThread sendBleDataThread = this.sendDataThread;
        if (sendBleDataThread == null || !sendBleDataThread.isRunning()) {
            SendBleDataThread sendBleDataThread2 = new SendBleDataThread(new IBleOp() { // from class: com.jieli.ble.model.BleDevice.1
                @Override // xfkj.fitpro.activity.ota.jli.ble.interfaces.IBleOp
                public int getBleMtu() {
                    return BleDevice.this.getMtu();
                }

                @Override // xfkj.fitpro.activity.ota.jli.ble.interfaces.IBleOp
                public boolean writeDataByBle(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, byte[] bArr) {
                    return BleDevice.this.writeDataToDeviceByBle(bluetoothGatt, uuid, uuid2, bArr);
                }
            }, new OnThreadStateListener() { // from class: com.jieli.ble.model.BleDevice.2
                @Override // com.jieli.ble.interfaces.OnThreadStateListener
                public void onEnd(long j, String str) {
                    if (BleDevice.this.sendDataThread == null || BleDevice.this.sendDataThread.getId() != j) {
                        return;
                    }
                    BleDevice.this.sendDataThread = null;
                }

                @Override // com.jieli.ble.interfaces.OnThreadStateListener
                public void onStart(long j, String str) {
                }
            });
            this.sendDataThread = sendBleDataThread2;
            sendBleDataThread2.start();
        }
    }

    public void stopSendDataThread() {
        SendBleDataThread sendBleDataThread = this.sendDataThread;
        if (sendBleDataThread != null) {
            sendBleDataThread.stopThread();
        }
    }

    public String toString() {
        return "BleDevice{context=" + this.context + ", gatt=" + this.gatt + ", mtu=" + this.mtu + ", connectedTime=" + this.connectedTime + ", sendDataThread=" + this.sendDataThread + '}';
    }

    public void wakeupSendThread(SendBleDataThread.BleSendTask bleSendTask) {
        if (this.sendDataThread == null || bleSendTask == null || !this.gatt.equals(bleSendTask.getBleGatt())) {
            return;
        }
        this.sendDataThread.wakeupSendThread(bleSendTask);
    }
}
