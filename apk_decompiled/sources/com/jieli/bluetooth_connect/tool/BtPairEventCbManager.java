package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;

/* JADX INFO: loaded from: classes3.dex */
public class BtPairEventCbManager extends BaseCbManager<OnBtDevicePairListener> implements OnBtDevicePairListener {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBtDevicePairListener onBtDevicePairListener) {
        return super.addListener(onBtDevicePairListener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBtDevicePairListener> callbackImpl) {
        super.callbackEvent(callbackImpl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
    public void onAdapterStatus(final boolean z, final boolean z2) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: yn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDevicePairListener) obj).onAdapterStatus(z, z2);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
    public void onBtDeviceBond(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: zn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDevicePairListener) obj).onBtDeviceBond(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
    public void onPairError(final BluetoothDevice bluetoothDevice, final ErrorInfo errorInfo) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: ao
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDevicePairListener) obj).onPairError(bluetoothDevice, errorInfo);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBtDevicePairListener onBtDevicePairListener) {
        return super.removeListener(onBtDevicePairListener);
    }
}
