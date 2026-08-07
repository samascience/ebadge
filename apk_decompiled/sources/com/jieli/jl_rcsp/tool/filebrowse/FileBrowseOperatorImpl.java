package com.jieli.jl_rcsp.tool.filebrowse;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_filebrowse.bean.PathData;
import com.jieli.jl_filebrowse.interfaces.FileBrowseOperator;
import com.jieli.jl_filebrowse.interfaces.OperatCallback;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.DelDevFileCmd;
import com.jieli.jl_rcsp.model.command.file_op.DeviceFormatCmd;
import com.jieli.jl_rcsp.model.parameter.DelDevFileParam;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* JADX INFO: loaded from: classes3.dex */
public class FileBrowseOperatorImpl implements FileBrowseOperator {
    public static final String b = "FileBrowseOperatorImpl";
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
            JL_Log.e(FileBrowseOperatorImpl.b, this.a, RcspUtil.formatString("device: %s, %s", bluetoothDevice, baseError));
            OperatCallback operatCallback = this.b;
            if (operatCallback != null) {
                operatCallback.onError(baseError.getSubCode());
            }
        }
    }

    public FileBrowseOperatorImpl(RcspOpImpl rcspOpImpl) {
        this.a = rcspOpImpl;
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileBrowseOperator
    public boolean dataHasPacket() {
        return false;
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileBrowseOperator
    public void deleteFile(final int i, final byte b2, final int i2, final boolean z, boolean z2, final OperatCallback operatCallback) {
        if (z2) {
            a((byte) 1, new OperatCallback() { // from class: com.jieli.jl_rcsp.tool.filebrowse.FileBrowseOperatorImpl.1
                @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
                public void onError(int i3) {
                    operatCallback.onError(i3);
                }

                @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
                public void onSuccess() {
                    FileBrowseOperatorImpl.this.a(i, b2, i2, z, operatCallback);
                }
            });
        } else {
            a(i, b2, i2, z, operatCallback);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileBrowseOperator
    public void formatDevice(final int i, final OperatCallback operatCallback) {
        a((byte) 2, new OperatCallback() { // from class: com.jieli.jl_rcsp.tool.filebrowse.FileBrowseOperatorImpl.2
            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onError(int i2) {
                OperatCallback operatCallback2 = operatCallback;
                if (operatCallback2 != null) {
                    operatCallback2.onError(i2);
                }
            }

            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onSuccess() {
                JL_Log.i(FileBrowseOperatorImpl.b, "formatDevice", "Start formatting");
                FileBrowseOperatorImpl.this.a.sendRcspCommand(FileBrowseOperatorImpl.this.a.getTargetDevice(), new DeviceFormatCmd(new DeviceFormatCmd.Param(i)), 30000, new CustomRcspCallback("formatDevice", operatCallback));
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileBrowseOperator
    public void sendPathDataCmd(PathData pathData, byte[] bArr, OperatCallback operatCallback) {
        RcspOpImpl rcspOpImpl = this.a;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildSendPathDataCmd(pathData), new CustomRcspCallback("sendPathDataCmd", operatCallback));
    }

    public final void a(byte b2, OperatCallback operatCallback) {
        RcspOpImpl rcspOpImpl = this.a;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildNotifyPrepareEnvCmd(b2), new CustomRcspCallback("prepareDelEnv", operatCallback));
    }

    public final void a(int i, byte b2, int i2, boolean z, OperatCallback operatCallback) {
        DelDevFileCmd delDevFileCmd = new DelDevFileCmd(new DelDevFileParam(i, b2, i2, z));
        RcspOpImpl rcspOpImpl = this.a;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), delDevFileCmd, 6000, new CustomRcspCallback("deleteFileActual", operatCallback));
    }
}
