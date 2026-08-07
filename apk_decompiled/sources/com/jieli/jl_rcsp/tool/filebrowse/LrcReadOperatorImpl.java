package com.jieli.jl_rcsp.tool.filebrowse;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_filebrowse.interfaces.OperatCallback;
import com.jieli.jl_filebrowse.interfaces.lrc.LrcReadOperator;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.StartLrcGetCmd;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* JADX INFO: loaded from: classes3.dex */
public class LrcReadOperatorImpl implements LrcReadOperator {
    public static final String b = "LrcReadOperatorImpl";
    public final RcspOpImpl a;

    public static class CustomRcspCallback<C extends CommandBase> implements RcspCommandCallback<C> {
        public final String a;
        public final OperatCallback b;

        public CustomRcspCallback(String str, OperatCallback operatCallback) {
            this.a = str;
            this.b = operatCallback;
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onCommandResponse(BluetoothDevice bluetoothDevice, C c) {
            if (c.getStatus() != 0) {
                onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12292, c.getStatus(), null));
                return;
            }
            OperatCallback operatCallback = this.b;
            if (operatCallback != null) {
                operatCallback.onSuccess();
            }
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
            JL_Log.e(LrcReadOperatorImpl.b, this.a, RcspUtil.formatString("device: %s, %s", bluetoothDevice, baseError));
            OperatCallback operatCallback = this.b;
            if (operatCallback != null) {
                operatCallback.onError(baseError.getSubCode());
            }
        }
    }

    public LrcReadOperatorImpl(RcspOpImpl rcspOpImpl) {
        this.a = rcspOpImpl;
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadOperator
    public void startLrcRead(OperatCallback operatCallback) {
        RcspOpImpl rcspOpImpl = this.a;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), new StartLrcGetCmd(), new CustomRcspCallback("startLrcRead", operatCallback));
    }
}
