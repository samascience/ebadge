package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.BaseResponse;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* JADX INFO: loaded from: classes3.dex */
public class SmallFileTransferCmdHandler implements ICmdHandler {
    private final String TAG = SmallFileTransferCmdHandler.class.getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        BaseResponse queryResponse;
        SmallFileTransferCmd.Param queryParam;
        if (basePacket == null || basePacket.getOpCode() != 40) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() != 1) {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            if (command == null) {
                JL_Log.e(this.TAG, "parseDataToCmd", "invalid small file transfer cmd response");
                return null;
            }
            SmallFileTransferCmd smallFileTransferCmd = (SmallFileTransferCmd) command;
            smallFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
            smallFileTransferCmd.setStatus(basePacket.getStatus());
            if (basePacket.getStatus() != 0) {
                JL_Log.w(this.TAG, "parseDataToCmd", "small file transfer cmd  send fail, status = " + basePacket.getStatus());
                smallFileTransferCmd.setResponse(new SmallFileTransferCmd.Response());
                return smallFileTransferCmd;
            }
            byte b = paramData[0];
            int length = paramData.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(paramData, 1, bArr, 0, length);
            if (b == 0) {
                queryResponse = new SmallFileTransferCmd.QueryResponse(((SmallFileTransferCmd.QueryParam) smallFileTransferCmd.getParam()).data[0], bArr);
            } else if (b == 1) {
                queryResponse = new SmallFileTransferCmd.ReadFileResponse(bArr);
            } else if (b != 2) {
                queryResponse = (b == 3 || b == 4) ? new SmallFileTransferCmd.ResultResponse(bArr[0]) : new SmallFileTransferCmd.Response();
            } else {
                queryResponse = new SmallFileTransferCmd.AddFileResponse(bArr);
            }
            queryResponse.setRawData(bArr);
            smallFileTransferCmd.setResponse(queryResponse);
            return smallFileTransferCmd;
        }
        byte b2 = paramData[0];
        int length2 = paramData.length;
        int i = length2 - 1;
        byte[] bArr2 = new byte[i];
        System.arraycopy(paramData, 1, bArr2, 0, i);
        if (b2 == 0) {
            queryParam = new SmallFileTransferCmd.QueryParam(bArr2[0]);
        } else if (b2 == 1) {
            queryParam = new SmallFileTransferCmd.ReadFileParam(bArr2[0], CHexConver.bytesToShort(bArr2[1], bArr2[2]), CHexConver.bytesToShort(bArr2[3], bArr2[4]), CHexConver.bytesToShort(bArr2[5], bArr2[6]), bArr2[7]);
        } else if (b2 == 2) {
            byte b3 = bArr2[0];
            short sBytesToShort = CHexConver.bytesToShort(bArr2[1], bArr2[2]);
            short sBytesToShort2 = CHexConver.bytesToShort(bArr2[3], bArr2[4]);
            short sBytesToShort3 = CHexConver.bytesToShort(bArr2[5], bArr2[6]);
            int i2 = length2 - 8;
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, 7, bArr3, 0, i2);
            queryParam = new SmallFileTransferCmd.AddFileParam(b3, sBytesToShort, sBytesToShort2, bArr3, sBytesToShort3);
        } else if (b2 == 3) {
            byte b4 = bArr2[0];
            short sBytesToShort4 = CHexConver.bytesToShort(bArr2[1], bArr2[2]);
            short sBytesToShort5 = CHexConver.bytesToShort(bArr2[3], bArr2[4]);
            short sBytesToShort6 = CHexConver.bytesToShort(bArr2[5], bArr2[6]);
            short sBytesToShort7 = CHexConver.bytesToShort(bArr2[7], bArr2[8]);
            int i3 = length2 - 10;
            byte[] bArr4 = new byte[i3];
            System.arraycopy(bArr2, 9, bArr4, 0, i3);
            queryParam = new SmallFileTransferCmd.UpdateFileParam(b4, sBytesToShort4, sBytesToShort5, sBytesToShort6, bArr4, sBytesToShort7);
        } else {
            if (b2 != 4) {
                throw new RuntimeException("invalid Small file transfer cmd op");
            }
            queryParam = new SmallFileTransferCmd.DeleteFileParam(bArr2[0], CHexConver.bytesToShort(bArr2[1], bArr2[2]));
        }
        SmallFileTransferCmd smallFileTransferCmd2 = new SmallFileTransferCmd(queryParam);
        smallFileTransferCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        return smallFileTransferCmd2;
    }
}
