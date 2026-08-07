package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.nfc.OnNfcEventCallback;
import com.jieli.jl_rcsp.model.device.NfcMsg;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NfcEventCbHelper extends BaseCallbackManager<OnNfcEventCallback> implements OnNfcEventCallback {
    @Override // com.jieli.jl_rcsp.interfaces.nfc.OnNfcEventCallback
    public void onDefaultNfc(final BluetoothDevice bluetoothDevice, final short s) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ar1
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnNfcEventCallback) obj).onDefaultNfc(bluetoothDevice, s);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.OnNfcEventCallback
    public void onModifyNfcMsg(final BluetoothDevice bluetoothDevice, final NfcMsg nfcMsg) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: xq1
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnNfcEventCallback) obj).onModifyNfcMsg(bluetoothDevice, nfcMsg);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.OnNfcEventCallback
    public void onNfcMsgChange(final BluetoothDevice bluetoothDevice, final List<NfcMsg> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: zq1
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnNfcEventCallback) obj).onNfcMsgChange(bluetoothDevice, list);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.OnNfcEventCallback
    public void onRequestSynNfcMsg(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: yq1
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnNfcEventCallback) obj).onRequestSynNfcMsg(bluetoothDevice);
            }
        });
    }
}
