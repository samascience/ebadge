package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.record.OnRecordStateCallback;
import com.jieli.jl_rcsp.model.RecordState;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;

/* JADX INFO: loaded from: classes3.dex */
public class RecordStateCallbackHelper extends BaseCallbackManager<OnRecordStateCallback> implements OnRecordStateCallback {
    public void addOnRecordStateCallback(OnRecordStateCallback onRecordStateCallback) {
        registerCallback(onRecordStateCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.OnRecordStateCallback
    public void onStateChange(final BluetoothDevice bluetoothDevice, final RecordState recordState) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: rd2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRecordStateCallback) obj).onStateChange(bluetoothDevice, recordState);
            }
        });
    }

    public void removeOnRecordStateCallback(OnRecordStateCallback onRecordStateCallback) {
        unregisterCallback(onRecordStateCallback);
    }
}
