package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.ai.AIOperateCmd;
import com.jieli.jl_rcsp.model.command.ai.AIOperateNoResponseCmd;
import com.jieli.jl_rcsp.model.parameter.AIOperateParam;
import com.jieli.jl_rcsp.model.response.AIOperateResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class AiOperateCmdHandler implements ICmdHandler {
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c1  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int opCode;
        AIOperateCmd aIOperateCmd;
        int iByteToInt;
        Integer numValueOf;
        Integer numValueOf2;
        String str;
        Integer num;
        Integer numValueOf3;
        AIOperateParam aIOperateParam = null;
        str = null;
        str = null;
        String str2 = null;
        if (basePacket != null && (opCode = basePacket.getOpCode()) == 50) {
            byte[] paramData = basePacket.getParamData();
            int iByteToInt2 = 0;
            if (basePacket.getType() != 1) {
                CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
                if (opCode == 50) {
                    byte[] bArr = new byte[0];
                    if (command != null) {
                        aIOperateCmd = (AIOperateCmd) command;
                        aIOperateParam = (AIOperateParam) aIOperateCmd.getParam();
                    } else {
                        aIOperateCmd = new AIOperateCmd(new AIOperateParam());
                    }
                    if (paramData != null && paramData.length > 0) {
                        int iByteToInt3 = CHexConver.byteToInt(paramData[0]);
                        if (aIOperateParam != null) {
                            aIOperateParam.getOp();
                        } else if (paramData.length > 1) {
                            int length = paramData.length - 1;
                            bArr = new byte[length];
                            System.arraycopy(paramData, 1, bArr, 0, length);
                        }
                        iByteToInt2 = iByteToInt3;
                    }
                    AIOperateResponse data = new AIOperateResponse(iByteToInt2).setData(bArr);
                    data.setRawData(paramData);
                    aIOperateCmd.setResponse(data);
                    aIOperateCmd.setStatus(basePacket.getStatus()).setOpCodeSn(basePacket.getOpCodeSn());
                    return aIOperateCmd;
                }
            } else if (opCode == 50) {
                if (paramData != null && paramData.length > 0) {
                    iByteToInt = CHexConver.byteToInt(paramData[0]);
                    if (paramData.length > 1) {
                        iByteToInt2 = CHexConver.byteToInt(paramData[1]);
                        if (iByteToInt == 0 && paramData.length > 2) {
                            if (iByteToInt2 == 0) {
                                String str3 = new String(paramData, 2, paramData.length - 2);
                                numValueOf = null;
                                numValueOf2 = null;
                                str = null;
                                str2 = str3;
                                num = str;
                            } else if (iByteToInt2 == 1) {
                                if ((paramData[2] & 128) == 128) {
                                    numValueOf = Integer.valueOf(CHexConver.bytesToInt(paramData[3], paramData[4]));
                                    numValueOf3 = Integer.valueOf(CHexConver.bytesToInt(paramData[5], paramData[6]));
                                } else {
                                    numValueOf = null;
                                    numValueOf3 = null;
                                }
                                numValueOf2 = Integer.valueOf(paramData[2] & 127);
                                str = null;
                                num = numValueOf3;
                            } else if (iByteToInt2 == 4) {
                                numValueOf = null;
                                numValueOf2 = null;
                                str = new String(paramData, 2, paramData.length - 2);
                                num = 0;
                            }
                        }
                    }
                    AIOperateParam thumbPath = new AIOperateParam().setOp(iByteToInt).setFlag(iByteToInt2).setAiDialStyle(str2).setAiDialFunUIState(numValueOf2).setScaleZoomHeight(num).setScaleZoomWidth(numValueOf).setThumbPath(str);
                    return basePacket.getHasResponse() == 1 ? new AIOperateCmd(thumbPath).setOpCodeSn(basePacket.getOpCodeSn()) : new AIOperateNoResponseCmd(thumbPath).setOpCodeSn(basePacket.getOpCodeSn());
                }
                iByteToInt = -1;
                numValueOf = null;
                numValueOf2 = null;
                str = null;
                num = str;
                AIOperateParam thumbPath2 = new AIOperateParam().setOp(iByteToInt).setFlag(iByteToInt2).setAiDialStyle(str2).setAiDialFunUIState(numValueOf2).setScaleZoomHeight(num).setScaleZoomWidth(numValueOf).setThumbPath(str);
                if (basePacket.getHasResponse() == 1) {
                }
            }
        }
        return null;
    }
}
