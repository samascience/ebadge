package com.jieli.jl_rcsp.tool.callback;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* JADX INFO: loaded from: classes3.dex */
public class RcspCallbackManager extends BaseCallbackManager<OnRcspCallback> {
    public void onConnectStateChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: za2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onConnectStateChange(bluetoothDevice, i);
            }
        });
    }

    public void onMandatoryUpgrade(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ua2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onMandatoryUpgrade(bluetoothDevice);
            }
        });
    }

    public void onPutDataToDataHandler(final BluetoothDevice bluetoothDevice, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ya2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onPutDataToDataHandler(bluetoothDevice, bArr);
            }
        });
    }

    public void onRcspCommand(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: va2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspCommand(bluetoothDevice, commandBase);
            }
        });
    }

    public void onRcspDataCmd(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: wa2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspDataCmd(bluetoothDevice, commandBase);
            }
        });
    }

    public void onRcspError(final BluetoothDevice bluetoothDevice, final BaseError baseError) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ta2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspError(bluetoothDevice, baseError);
            }
        });
    }

    public void onRcspInit(final BluetoothDevice bluetoothDevice, final boolean z) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: xa2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspInit(bluetoothDevice, z);
            }
        });
    }

    public void onSwitchConnectedDevice(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ab2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onSwitchConnectedDevice(bluetoothDevice);
            }
        });
    }
}
