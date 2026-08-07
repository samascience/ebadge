package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class SppEventCbManager extends BaseCbManager<OnBtSppListener> implements OnBtSppListener {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBtSppListener onBtSppListener) {
        return super.addListener(onBtSppListener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBtSppListener> callbackImpl) {
        super.callbackEvent(callbackImpl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener
    public void onSppConnection(final BluetoothDevice bluetoothDevice, final UUID uuid, final int i) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: ys2
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtSppListener) obj).onSppConnection(bluetoothDevice, uuid, i);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener
    public void onSppDataNotify(final BluetoothDevice bluetoothDevice, final UUID uuid, final byte[] bArr) {
        if (bArr == null) {
            return;
        }
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: xs2
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtSppListener) obj).onSppDataNotify(bluetoothDevice, uuid, bArr);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener
    public void onSwitchSppDevice(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: zs2
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtSppListener) obj).onSwitchSppDevice(bluetoothDevice);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBtSppListener onBtSppListener) {
        return super.removeListener(onBtSppListener);
    }
}
