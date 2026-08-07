package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* JADX INFO: loaded from: classes3.dex */
public class CustomRcspActionCallback<T, C extends CommandBase> implements RcspCommandCallback<C> {
    protected final String funcName;
    protected final OnOperationCallback<T> mCallback;
    protected final IHandleResult<T, C> mParser;

    public CustomRcspActionCallback(String str, OnOperationCallback<T> onOperationCallback, IHandleResult<T, C> iHandleResult) {
        this.funcName = str;
        this.mCallback = onOperationCallback;
        this.mParser = iHandleResult;
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
    public void onCommandResponse(BluetoothDevice bluetoothDevice, C c) {
        T tHandleResult;
        if (c == null) {
            IHandleResult<T, C> iHandleResult = this.mParser;
            tHandleResult = iHandleResult != null ? iHandleResult.handleResult(bluetoothDevice, null) : null;
            OnOperationCallback<T> onOperationCallback = this.mCallback;
            if (onOperationCallback != null) {
                onOperationCallback.onSuccess(tHandleResult);
                return;
            }
            return;
        }
        IHandleResult<T, C> iHandleResult2 = this.mParser;
        int iHasResult = iHandleResult2 == null ? 0 : iHandleResult2.hasResult(bluetoothDevice, c);
        if (c.getStatus() != 0 || iHasResult != 0) {
            if (c.getStatus() != 0) {
                onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12292, c.getStatus(), null));
                return;
            } else {
                onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12293, iHasResult, null));
                return;
            }
        }
        IHandleResult<T, C> iHandleResult3 = this.mParser;
        tHandleResult = iHandleResult3 != null ? iHandleResult3.handleResult(bluetoothDevice, c) : null;
        if (this.mParser != null && tHandleResult == null) {
            BaseError baseError = new BaseError(12289, WatchError.getErrorDesc(12289));
            baseError.setOpCode(c.getId());
            onErrCode(bluetoothDevice, baseError);
        } else {
            OnOperationCallback<T> onOperationCallback2 = this.mCallback;
            if (onOperationCallback2 != null) {
                onOperationCallback2.onSuccess(tHandleResult);
            }
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
    public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
        JL_Log.e("RcspCommandCallback", this.funcName, RcspUtil.formatString("Device[%s] has an error: %s", bluetoothDevice, baseError));
        OnOperationCallback<T> onOperationCallback = this.mCallback;
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(baseError);
        }
    }
}
