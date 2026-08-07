package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class BleEventCbManager extends BaseCbManager<OnBtBleListener> {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBtBleListener onBtBleListener) {
        return super.addListener(onBtBleListener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBtBleListener> callbackImpl) {
        super.callbackEvent(callbackImpl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    public void onBleBond(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: oj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleBond(bluetoothDevice, i);
            }
        });
    }

    public void onBleConnection(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: bj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleConnection(bluetoothDevice, i);
            }
        });
    }

    public void onBleDataNotify(final BluetoothDevice bluetoothDevice, final UUID uuid, final UUID uuid2, final byte[] bArr) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: aj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleDataNotify(bluetoothDevice, uuid, uuid2, bArr);
            }
        });
    }

    public void onBleMtuChanged(final BluetoothDevice bluetoothDevice, final int i, final int i2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: hj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleMtuChanged(bluetoothDevice, i, i2);
            }
        });
    }

    public void onBleNotificationStatus(final BluetoothDevice bluetoothDevice, final UUID uuid, final UUID uuid2, final boolean z) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: qj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleNotificationStatus(bluetoothDevice, uuid, uuid2, z);
            }
        });
    }

    public void onBleWriteStatus(final BluetoothDevice bluetoothDevice, final UUID uuid, final UUID uuid2, final byte[] bArr, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: zi
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleWriteStatus(bluetoothDevice, uuid, uuid2, bArr, i);
            }
        });
    }

    public void onCharacteristicChanged(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: dj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
        });
    }

    public void onCharacteristicRead(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: pj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        });
    }

    public void onCharacteristicWrite(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: kj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        });
    }

    public void onConnectionStateChange(final BluetoothGatt bluetoothGatt, final int i, final int i2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: jj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onConnectionStateChange(bluetoothGatt, i, i2);
            }
        });
    }

    public void onConnectionUpdatedCallback(final BluetoothGatt bluetoothGatt, final int i, final int i2, final int i3, final int i4) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: rj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onConnectionUpdatedCallback(bluetoothGatt, i, i2, i3, i4);
            }
        });
    }

    public void onDescriptorRead(final BluetoothGatt bluetoothGatt, final BluetoothGattDescriptor bluetoothGattDescriptor, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: fj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        });
    }

    public void onDescriptorWrite(final BluetoothGatt bluetoothGatt, final BluetoothGattDescriptor bluetoothGattDescriptor, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: yi
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        });
    }

    public void onMtuChanged(final BluetoothGatt bluetoothGatt, final int i, final int i2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: sj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onMtuChanged(bluetoothGatt, i, i2);
            }
        });
    }

    public void onPhyRead(final BluetoothGatt bluetoothGatt, final int i, final int i2, final int i3) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: nj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onPhyRead(bluetoothGatt, i, i2, i3);
            }
        });
    }

    public void onPhyUpdate(final BluetoothGatt bluetoothGatt, final int i, final int i2, final int i3) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: gj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onPhyUpdate(bluetoothGatt, i, i2, i3);
            }
        });
    }

    public void onReadRemoteRssi(final BluetoothGatt bluetoothGatt, final int i, final int i2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: mj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onReadRemoteRssi(bluetoothGatt, i, i2);
            }
        });
    }

    public void onReliableWriteCompleted(final BluetoothGatt bluetoothGatt, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: cj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onReliableWriteCompleted(bluetoothGatt, i);
            }
        });
    }

    public void onServiceChanged(final BluetoothGatt bluetoothGatt) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: ej
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onServiceChanged(bluetoothGatt);
            }
        });
    }

    public void onServicesDiscovered(final BluetoothGatt bluetoothGatt, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: lj
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onServicesDiscovered(bluetoothGatt, i);
            }
        });
    }

    public void onSwitchBleDevice(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: ij
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onSwitchBleDevice(bluetoothDevice);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBtBleListener onBtBleListener) {
        return super.removeListener(onBtBleListener);
    }
}
