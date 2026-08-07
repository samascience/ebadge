package com.jieli;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import com.jieli.OTAManager2;
import com.jieli.ble.BleManager;
import com.jieli.ble.interfaces.BleEventCallback;
import com.jieli.ble.interfaces.OnWriteDataCallback;
import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.model.base.BaseError;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class OTAManager2 extends BluetoothOTAManager {
    private final BleManager bleManager;
    private MyBleEventCallback btEventCallback;

    private class MyBleEventCallback extends BleEventCallback {
        private MyBleEventCallback() {
        }

        @Override // com.jieli.ble.interfaces.BleEventCallback, com.jieli.ble.interfaces.IBleEventCallback
        public void onBleConnection(BluetoothDevice bluetoothDevice, int i) {
            super.onBleConnection(bluetoothDevice, i);
            OTAManager2.this.onBtDeviceConnection(bluetoothDevice, OTAManager2.this.changeConnectStatus(i));
        }

        @Override // com.jieli.ble.interfaces.BleEventCallback, com.jieli.ble.interfaces.IBleEventCallback
        public void onBleDataBlockChanged(BluetoothDevice bluetoothDevice, int i, int i2) {
            super.onBleDataBlockChanged(bluetoothDevice, i, i2);
            OTAManager2 oTAManager2 = OTAManager2.this;
            oTAManager2.onMtuChanged(oTAManager2.getConnectedBluetoothGatt(), i, i2);
        }

        @Override // com.jieli.ble.interfaces.BleEventCallback, com.jieli.ble.interfaces.IBleEventCallback
        public void onBleDataNotification(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
            super.onBleDataNotification(bluetoothDevice, uuid, uuid2, bArr);
            OTAManager2.this.onReceiveDeviceData(bluetoothDevice, bArr);
        }
    }

    public OTAManager2(Context context) {
        super(context);
        BleManager bleManager = BleManager.getInstance();
        this.bleManager = bleManager;
        MyBleEventCallback myBleEventCallback = new MyBleEventCallback();
        this.btEventCallback = myBleEventCallback;
        bleManager.registerBleEventCallback(myBleEventCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int changeConnectStatus(int i) {
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return i != 2 ? 0 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendDataToDevice$0(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, boolean z, byte[] bArr) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public void connectBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.bleManager.connectBleDevice(bluetoothDevice);
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public void disconnectBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.bleManager.disconnectBleDevice(bluetoothDevice);
    }

    @Override // com.jieli.jl_bt_ota.impl.BluetoothOTAManager, com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public void errorEventCallback(BaseError baseError) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public BluetoothGatt getConnectedBluetoothGatt() {
        return this.bleManager.getConnectedBtGatt(getConnectedDevice());
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public BluetoothDevice getConnectedDevice() {
        return this.bleManager.getConnectedBtDevice();
    }

    @Override // com.jieli.jl_bt_ota.impl.BluetoothOTAManager, com.jieli.jl_bt_ota.impl.BluetoothBreProfiles, com.jieli.jl_bt_ota.impl.BluetoothDiscovery, com.jieli.jl_bt_ota.impl.BluetoothBase, com.jieli.jl_bt_ota.interfaces.IUpgradeManager
    public void release() {
        if (isOTA()) {
            cancelOTA();
        }
        this.bleManager.unregisterBleEventCallback(this.btEventCallback);
        super.release();
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public boolean sendDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        this.bleManager.writeDataByBleAsync(bluetoothDevice, BleManager.BLE_UUID_SERVICE, BleManager.BLE_UUID_WRITE, bArr, new OnWriteDataCallback() { // from class: xs1
            @Override // com.jieli.ble.interfaces.OnWriteDataCallback
            public final void onBleResult(BluetoothDevice bluetoothDevice2, UUID uuid, UUID uuid2, boolean z, byte[] bArr2) {
                OTAManager2.lambda$sendDataToDevice$0(bluetoothDevice2, uuid, uuid2, z, bArr2);
            }
        });
        return true;
    }
}
