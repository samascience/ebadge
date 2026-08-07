package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import android.os.ParcelUuid;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothEventCbManager extends BaseCbManager<IBluetoothEventCallback> implements IBluetoothEventCallback {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(IBluetoothEventCallback iBluetoothEventCallback) {
        return super.addListener(iBluetoothEventCallback);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<IBluetoothEventCallback> callbackImpl) {
        super.callbackEvent(callbackImpl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onA2dpStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: cl
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onA2dpStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onAdapterStatus(final boolean z, final boolean z2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: hl
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onAdapterStatus(z, z2);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleConnection(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: fl
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleConnection(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleDataBlockChanged(final BluetoothDevice bluetoothDevice, final int i, final int i2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: el
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleDataBlockChanged(bluetoothDevice, i, i2);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleDataNotification(final BluetoothDevice bluetoothDevice, final UUID uuid, final UUID uuid2, final byte[] bArr) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: rk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleDataNotification(bluetoothDevice, uuid, uuid2, bArr);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleNotificationStatus(final BluetoothDevice bluetoothDevice, final UUID uuid, final UUID uuid2, final boolean z) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: jl
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleNotificationStatus(bluetoothDevice, uuid, uuid2, z);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleServiceDiscovery(final BluetoothDevice bluetoothDevice, final int i, final List<BluetoothGattService> list) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: gl
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleServiceDiscovery(bluetoothDevice, i, list);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleWriteStatus(final BluetoothDevice bluetoothDevice, final UUID uuid, final UUID uuid2, final byte[] bArr, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: zk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleWriteStatus(bluetoothDevice, uuid, uuid2, bArr, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBondStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: yk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBondStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBtDeviceConnectStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: al
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBtDeviceConnectStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onConnection(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: qk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onConnection(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onConnectionUpdated(final BluetoothGatt bluetoothGatt, final int i, final int i2, final int i3, final int i4) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: pk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onConnectionUpdated(bluetoothGatt, i, i2, i3, i4);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onDeviceUuidsDiscovery(final BluetoothDevice bluetoothDevice, final ParcelUuid[] parcelUuidArr) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: bl
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onDeviceUuidsDiscovery(bluetoothDevice, parcelUuidArr);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onDiscovery(final BluetoothDevice bluetoothDevice, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: tk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onDiscovery(bluetoothDevice, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onDiscoveryStatus(final boolean z, final boolean z2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: sk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onDiscoveryStatus(z, z2);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onError(final ErrorInfo errorInfo) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: dl
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onError(errorInfo);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onHfpStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: wk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onHfpStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onHistoryRecordChange(final int i, final HistoryRecord historyRecord) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: vk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onHistoryRecordChange(i, historyRecord);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onShowDialog(final BluetoothDevice bluetoothDevice, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: xk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onShowDialog(bluetoothDevice, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onSppDataNotification(final BluetoothDevice bluetoothDevice, final UUID uuid, final byte[] bArr) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: ok
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onSppDataNotification(bluetoothDevice, uuid, bArr);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onSppStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: il
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onSppStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onSwitchConnectedDevice(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: uk
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onSwitchConnectedDevice(bluetoothDevice);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(IBluetoothEventCallback iBluetoothEventCallback) {
        return super.removeListener(iBluetoothEventCallback);
    }
}
