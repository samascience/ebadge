package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.os.ParcelUuid;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;

/* JADX INFO: loaded from: classes3.dex */
public class BrEdrEventCbManager extends BaseCbManager<OnBrEdrListener> implements OnBrEdrListener {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBrEdrListener onBrEdrListener) {
        return super.addListener(onBrEdrListener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBrEdrListener> callbackImpl) {
        super.callbackEvent(callbackImpl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onA2dpStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: nn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onA2dpStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onBrEdrConnection(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: mn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onBrEdrConnection(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onDeviceUuids(final BluetoothDevice bluetoothDevice, final ParcelUuid[] parcelUuidArr) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: on
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onDeviceUuids(bluetoothDevice, parcelUuidArr);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onEdrService(final boolean z, final int i, final BluetoothProfile bluetoothProfile) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: kn
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onEdrService(z, i, bluetoothProfile);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onHfpStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: ln
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onHfpStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBrEdrListener onBrEdrListener) {
        return super.removeListener(onBrEdrListener);
    }
}
