package xfkj.fitpro.activity.ota.jieli;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import com.blankj.utilcode.util.d;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import xfkj.fitpro.activity.ota.manager.OTASDKManager;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"MissingPermission"})
public class BleManager {
    private boolean isSending;
    private BluetoothGatt mBluetoothGatt;
    private OnBleEventListener mOnBleEventListener;
    private BluetoothGattCharacteristic writeCharForJIELI;
    public static final UUID serviceUUID = UUID.fromString("0000ae00-0000-1000-8000-00805f9b34fb");
    public static final UUID writeUUID = UUID.fromString("0000ae01-0000-1000-8000-00805f9b34fb");
    public static final UUID notifyUUID = UUID.fromString("0000ae02-0000-1000-8000-00805f9b34fb");
    private final String TAG = "BleManager2";
    private int bleMtu = 220;
    private final LinkedBlockingQueue<byte[]> sendQueue = new LinkedBlockingQueue<>();
    private final BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: xfkj.fitpro.activity.ota.jieli.BleManager.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            if (!BleManager.notifyUUID.equals(bluetoothGattCharacteristic.getUuid()) || BleManager.this.mOnBleEventListener == null) {
                return;
            }
            BleManager.this.mOnBleEventListener.onReceiveData(bluetoothGatt.getDevice(), bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (BleManager.writeUUID.equals(bluetoothGattCharacteristic.getUuid())) {
                Log.i("BleManager2", "onCharacteristicWrite:" + d.a(bluetoothGattCharacteristic.getValue()));
                BleManager.this.isSending = false;
                if (i != 0) {
                    BleManager.this.sendQueue.clear();
                } else {
                    if (BleManager.this.sendQueue.isEmpty()) {
                        return;
                    }
                    BleManager.this.writeDataToBle();
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            if ((i == 0 && i2 == 0) || i2 == 2) {
                BleManager.this.mBluetoothGatt = bluetoothGatt;
            }
            if (BleManager.this.mOnBleEventListener != null) {
                BleManager.this.mOnBleEventListener.onConnect(bluetoothGatt.getDevice(), i2);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            int i3;
            super.onMtuChanged(bluetoothGatt, i, i2);
            Log.i("BleManager2", "onMtuChanged mtu:" + i + ";status:" + i2);
            if (i2 != 0 || (i3 = i - 3) == BleManager.this.bleMtu) {
                return;
            }
            BleManager.this.bleMtu = i3;
        }
    };
    private final BluetoothGattCallback mBluetoothGattCallback2 = new BluetoothGattCallback() { // from class: xfkj.fitpro.activity.ota.jieli.BleManager.2
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeDataToBle() {
        byte[] bArrPoll;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        try {
            Thread.sleep(100L);
        } catch (Exception unused) {
        }
        boolean z = this.isSending;
        if (!z) {
            if (this.mBluetoothGatt == null || this.sendQueue.isEmpty() || (bArrPoll = this.sendQueue.poll()) == null || (bluetoothGattCharacteristic = this.writeCharForJIELI) == null) {
                return false;
            }
            bluetoothGattCharacteristic.setValue(bArrPoll);
            boolean zWriteCharacteristic = this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            this.isSending = zWriteCharacteristic;
            Log.i("BleManager2", "writeDataToBle data:" + d.a(bArrPoll));
            z = zWriteCharacteristic;
        }
        Log.i("BleManager2", "writeDataToBle ret:" + z);
        if (!z) {
            this.sendQueue.clear();
        }
        return z;
    }

    public void disconnect() {
        this.mBluetoothGatt.disconnect();
    }

    public int getBleMtu() {
        return this.bleMtu;
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.mBluetoothGatt;
    }

    public BluetoothGattCallback getBluetoothGattCallback() {
        return this.mBluetoothGattCallback;
    }

    public BluetoothGattCallback getBluetoothGattCallback2() {
        return this.mBluetoothGattCallback2;
    }

    public boolean sendBleData(byte[] bArr) {
        Log.i("BleManager2", "sendBleData:" + d.a(bArr) + ";mtu:" + this.bleMtu + ";cur threadId:" + Thread.currentThread().getId());
        OTASDKManager.getInstance().sendDataToJieLiDevice(bArr);
        return true;
    }

    public void setOnBleEventListener(OnBleEventListener onBleEventListener) {
        this.mOnBleEventListener = onBleEventListener;
    }

    public void setWriteCharForJIELI(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.writeCharForJIELI = bluetoothGattCharacteristic;
    }
}
