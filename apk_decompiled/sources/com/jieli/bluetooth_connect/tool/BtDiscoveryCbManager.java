package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener;

/* JADX INFO: loaded from: classes3.dex */
public class BtDiscoveryCbManager extends BaseCbManager<OnBtDiscoveryListener> implements OnBtDiscoveryListener {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBtDiscoveryListener onBtDiscoveryListener) {
        return super.addListener(onBtDiscoveryListener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBtDiscoveryListener> callbackImpl) {
        super.callbackEvent(callbackImpl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onDiscoveryDevice(final BluetoothDevice bluetoothDevice, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: wn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onDiscoveryDevice(bluetoothDevice, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onDiscoveryError(final ErrorInfo errorInfo) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: vn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onDiscoveryError(errorInfo);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onDiscoveryStatusChange(final boolean z, final boolean z2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: un
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onDiscoveryStatusChange(z, z2);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onShowProductDialog(final BluetoothDevice bluetoothDevice, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: xn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onShowProductDialog(bluetoothDevice, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBtDiscoveryListener onBtDiscoveryListener) {
        return super.removeListener(onBtDiscoveryListener);
    }
}
