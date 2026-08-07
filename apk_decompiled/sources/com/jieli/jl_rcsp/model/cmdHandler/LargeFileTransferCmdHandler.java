package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.NotifyPrepareEnvCmd;
import com.jieli.jl_rcsp.model.command.file_op.CancelLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferGetNameCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferOpCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.parameter.LargeFileTransferOpParam;
import com.jieli.jl_rcsp.model.parameter.StartLargeFileTransferParam;
import com.jieli.jl_rcsp.model.response.StartLargeFileTransferResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.tencent.connect.common.Constants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class LargeFileTransferCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        short sBytesToShort;
        int iBytesToInt;
        short sBytesToShort2;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        byte[] paramData = basePacket.getParamData();
        int iBytesToInt2 = 0;
        b = 0;
        byte b = 0;
        byte b2 = 0;
        b = 0;
        byte b3 = 0;
        if (basePacket.getType() == 1) {
            switch (opCode) {
                case 27:
                    byte[] bArrCopyOfRange = new byte[0];
                    if (paramData == null || paramData.length <= 5) {
                        sBytesToShort = 0;
                    } else {
                        iBytesToInt2 = CHexConver.bytesToInt(paramData, 0, 4);
                        sBytesToShort = CHexConver.bytesToShort(paramData[4], paramData[5]);
                        int length = paramData.length;
                        if (length - 6 > 0) {
                            bArrCopyOfRange = Arrays.copyOfRange(paramData, 6, length);
                        }
                    }
                    return new StartLargeFileTransferCmd(new StartLargeFileTransferParam(bArrCopyOfRange, iBytesToInt2, sBytesToShort)).setOpCodeSn(basePacket.getOpCodeSn());
                case 28:
                    if (paramData != null && paramData.length > 0) {
                        b3 = paramData[0];
                    }
                    StopLargeFileTransferCmd.Param param = new StopLargeFileTransferCmd.Param(b3);
                    param.setParamData(paramData);
                    return new StopLargeFileTransferCmd(param).setOpCodeSn(basePacket.getOpCodeSn());
                case 29:
                    if (paramData == null || paramData.length <= 0) {
                        iBytesToInt = 0;
                        sBytesToShort2 = 0;
                    } else {
                        byte b4 = paramData[0];
                        sBytesToShort2 = paramData.length > 2 ? CHexConver.bytesToShort(paramData[1], paramData[2]) : (short) 0;
                        iBytesToInt = paramData.length > 6 ? CHexConver.bytesToInt(paramData, 3, 4) : 0;
                        b2 = b4;
                    }
                    return new LargeFileTransferOpCmd(new LargeFileTransferOpParam(b2, sBytesToShort2, iBytesToInt)).setOpCodeSn(basePacket.getOpCodeSn());
                case 30:
                    return new CancelLargeFileTransferCmd().setOpCodeSn(basePacket.getOpCodeSn());
                case 32:
                    return new LargeFileTransferGetNameCmd(new LargeFileTransferGetNameCmd.Param(Constants.STR_EMPTY, 0)).setOpCodeSn(basePacket.getOpCodeSn());
                case 33:
                    if (paramData != null && paramData.length > 0) {
                        b = paramData[0];
                    }
                    return new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.Param(b)).setOpCodeSn(basePacket.getOpCodeSn());
            }
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
        switch (opCode) {
            case 27:
                StartLargeFileTransferResponse startLargeFileTransferResponse = new StartLargeFileTransferResponse();
                startLargeFileTransferResponse.setRawData(paramData);
                if (paramData.length > 1) {
                    startLargeFileTransferResponse.setTransferMtu(CHexConver.bytesToShort(paramData[0], paramData[1]));
                }
                StartLargeFileTransferCmd startLargeFileTransferCmd = command instanceof StartLargeFileTransferCmd ? (StartLargeFileTransferCmd) command : new StartLargeFileTransferCmd(new StartLargeFileTransferParam(new byte[0], 0, (short) 0));
                startLargeFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
                startLargeFileTransferCmd.setStatus(basePacket.getStatus());
                startLargeFileTransferCmd.setResponse(startLargeFileTransferResponse);
                return startLargeFileTransferCmd;
            case 28:
                StopLargeFileTransferCmd stopLargeFileTransferCmd = command instanceof StopLargeFileTransferCmd ? (StopLargeFileTransferCmd) command : new StopLargeFileTransferCmd(new StopLargeFileTransferCmd.Param(0));
                CommonResponse commonResponse = new CommonResponse();
                commonResponse.setRawData(paramData);
                stopLargeFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
                stopLargeFileTransferCmd.setStatus(basePacket.getStatus());
                stopLargeFileTransferCmd.setResponse(commonResponse);
                return stopLargeFileTransferCmd;
            case 29:
                LargeFileTransferOpCmd largeFileTransferOpCmd = command instanceof LargeFileTransferOpCmd ? (LargeFileTransferOpCmd) command : new LargeFileTransferOpCmd(new LargeFileTransferOpParam((byte) 0, (short) 0, 0));
                largeFileTransferOpCmd.setOpCodeSn(basePacket.getOpCodeSn());
                largeFileTransferOpCmd.setStatus(basePacket.getStatus());
                return largeFileTransferOpCmd;
            case 30:
                CancelLargeFileTransferCmd cancelLargeFileTransferCmd = command instanceof CancelLargeFileTransferCmd ? (CancelLargeFileTransferCmd) command : new CancelLargeFileTransferCmd();
                CommonResponse commonResponse2 = new CommonResponse();
                commonResponse2.setRawData(paramData);
                cancelLargeFileTransferCmd.setStatus(basePacket.getStatus());
                cancelLargeFileTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
                cancelLargeFileTransferCmd.setResponse(commonResponse2);
                return cancelLargeFileTransferCmd;
            case 32:
                LargeFileTransferGetNameCmd largeFileTransferGetNameCmd = command instanceof LargeFileTransferGetNameCmd ? (LargeFileTransferGetNameCmd) command : new LargeFileTransferGetNameCmd(new LargeFileTransferGetNameCmd.Param(Constants.STR_EMPTY, 0));
                CommonResponse commonResponse3 = new CommonResponse();
                commonResponse3.setRawData(paramData);
                largeFileTransferGetNameCmd.setStatus(basePacket.getStatus());
                largeFileTransferGetNameCmd.setOpCodeSn(basePacket.getOpCodeSn());
                largeFileTransferGetNameCmd.setResponse(commonResponse3);
                return largeFileTransferGetNameCmd;
            case 33:
                NotifyPrepareEnvCmd notifyPrepareEnvCmd = command instanceof NotifyPrepareEnvCmd ? (NotifyPrepareEnvCmd) command : new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.Param((byte) 0));
                CommonResponse commonResponse4 = new CommonResponse();
                commonResponse4.setRawData(paramData);
                notifyPrepareEnvCmd.setOpCodeSn(basePacket.getOpCodeSn());
                notifyPrepareEnvCmd.setStatus(basePacket.getStatus());
                notifyPrepareEnvCmd.setResponse(commonResponse4);
                return notifyPrepareEnvCmd;
        }
        return null;
    }
}
