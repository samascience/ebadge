package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationNoResponseCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* JADX INFO: loaded from: classes3.dex */
public class NFCOperationCmdHandler implements ICmdHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        NFCOperationCmd nFCOperationCmd;
        int iBytesToInt;
        int i;
        int iByteToInt;
        short sBytesToShort;
        int iBytesToInt2;
        int iByteToInt2;
        byte[] paramData = basePacket.getParamData();
        NFCOperationCmd.Response response = null;
        str = null;
        String str = null;
        str = null;
        String str2 = null;
        byte[] bArr = null;
        response = null;
        if (paramData == null || paramData.length == 0) {
            return null;
        }
        int iBytesToInt3 = 0;
        if (basePacket.getType() != 1) {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            if (command != null) {
                nFCOperationCmd = (NFCOperationCmd) command;
                if (((NFCOperationCmd.Param) nFCOperationCmd.getParam()).getOp() == 5) {
                    response = new NFCOperationCmd.GetDefaultNfcResponse(CHexConver.byteToInt(paramData[0]), paramData.length >= 3 ? CHexConver.bytesToShort(paramData[1], paramData[2]) : (short) 0);
                }
            } else {
                nFCOperationCmd = new NFCOperationCmd(new NFCOperationCmd.Param(0, 0));
            }
            if (response == null) {
                response = new NFCOperationCmd.Response(CHexConver.byteToInt(paramData[0]));
                response.setRawData(paramData);
            }
            nFCOperationCmd.setOpCodeSn(basePacket.getOpCodeSn());
            nFCOperationCmd.setStatus(basePacket.getStatus());
            nFCOperationCmd.setResponse(response);
            return nFCOperationCmd;
        }
        int opCodeSn = basePacket.getOpCodeSn();
        if (paramData.length >= 4) {
            iBytesToInt = CHexConver.bytesToInt(paramData, 0, 4);
            i = 4;
        } else {
            iBytesToInt = 0;
            i = 0;
        }
        if (paramData.length > i) {
            iByteToInt = CHexConver.byteToInt(paramData[i]);
            i++;
        } else {
            iByteToInt = 0;
        }
        switch (iByteToInt) {
            case 0:
                return new NFCOperationCmd(new NFCOperationCmd.StartSyncParam(iBytesToInt)).setOpCodeSn(opCodeSn);
            case 1:
                return new NFCOperationNoResponseCmd(new NFCOperationNoResponseCmd.StopSyncParam(iBytesToInt, paramData.length > i ? CHexConver.byteToInt(paramData[i]) : 0)).setOpCodeSn(opCodeSn);
            case 2:
                int i2 = i + 2;
                if (paramData.length >= i2) {
                    sBytesToShort = CHexConver.bytesToShort(paramData[i], paramData[i + 1]);
                    i = i2;
                } else {
                    sBytesToShort = 0;
                }
                int i3 = i + 4;
                if (paramData.length >= i3) {
                    iBytesToInt2 = CHexConver.bytesToInt(paramData, i, 4);
                    i = i3;
                } else {
                    iBytesToInt2 = 0;
                }
                if (paramData.length > i) {
                    int length = paramData.length - i;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(paramData, i, bArr2, 0, length);
                    bArr = bArr2;
                }
                return new NFCOperationCmd(new NFCOperationCmd.ModifyMsgParam(iBytesToInt, sBytesToShort, iBytesToInt2, bArr)).setOpCodeSn(opCodeSn);
            case 3:
                return new NFCOperationCmd(new NFCOperationCmd.DeleteMsgParam(iBytesToInt, paramData.length >= i + 2 ? CHexConver.bytesToShort(paramData[i], paramData[i + 1]) : (short) 0)).setOpCodeSn(opCodeSn);
            case 4:
                return new NFCOperationCmd(new NFCOperationCmd.NotifyNfcParam(iBytesToInt)).setOpCodeSn(opCodeSn);
            case 5:
                if (paramData.length > i) {
                    iByteToInt2 = CHexConver.byteToInt(paramData[i]);
                    i++;
                } else {
                    iByteToInt2 = 0;
                }
                if (iByteToInt2 == 1) {
                    return new NFCOperationCmd(new NFCOperationCmd.SetDefaultNfcParam(iBytesToInt, paramData.length >= i + 2 ? CHexConver.bytesToShort(paramData[i], paramData[i + 1]) : (short) 0)).setOpCodeSn(opCodeSn);
                }
                if (iByteToInt2 != 2) {
                    return new NFCOperationCmd(new NFCOperationCmd.GetDefaultNfcParam(iBytesToInt)).setOpCodeSn(opCodeSn);
                }
                return new NFCOperationNoResponseCmd(new NFCOperationNoResponseCmd.NotifyDefaultNfcParam(iBytesToInt, paramData.length >= i + 2 ? CHexConver.bytesToShort(paramData[i], paramData[i + 1]) : (short) 0)).setOpCodeSn(opCodeSn);
            case 6:
                int i4 = i + 4;
                if (paramData.length >= i4) {
                    iBytesToInt3 = CHexConver.bytesToInt(paramData, i, 4);
                    i = i4;
                }
                if (paramData.length > i) {
                    try {
                        str2 = new String(paramData, i, paramData.length - i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return new NFCOperationCmd(new NFCOperationCmd.InsertFileParam(iBytesToInt, iBytesToInt3, str2)).setOpCodeSn(opCodeSn);
            case 7:
                if (paramData.length > i) {
                    try {
                        str = new String(paramData, i, paramData.length - i);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return new NFCOperationCmd(new NFCOperationCmd.InsertFileEndParam(iBytesToInt, str)).setOpCodeSn(opCodeSn);
            default:
                JL_Log.e("NFCOperationCmdHandler", "parseDataToCmd", "未定义命令: " + iByteToInt);
                return null;
        }
    }
}
