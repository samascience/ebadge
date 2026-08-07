package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.speech.CancelSpeechCmd;
import com.jieli.jl_rcsp.model.command.speech.StartSpeechCmd;
import com.jieli.jl_rcsp.model.command.speech.StopSpeechCmd;
import com.jieli.jl_rcsp.model.parameter.StartSpeechParam;
import com.jieli.jl_rcsp.model.parameter.StopSpeechParam;
import com.jieli.jl_rcsp.model.response.StartSpeechResponse;
import com.jieli.jl_rcsp.model.response.StopSpeechResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* JADX INFO: loaded from: classes3.dex */
public class SpeechCmdHandler implements ICmdHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        boolean z;
        boolean z2;
        byte b;
        boolean z3;
        boolean z4;
        boolean z5;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 210 || opCode == 4 || opCode == 5) {
            byte[] paramData = basePacket.getParamData();
            int type = basePacket.getType();
            byte b2 = AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
            byte b3 = 0;
            boolean z6 = true;
            byte b4 = 1;
            if (type != 1) {
                CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
                if (opCode == 4) {
                    StartSpeechResponse startSpeechResponse = new StartSpeechResponse();
                    startSpeechResponse.setRawData(paramData);
                    if (command != null) {
                        StartSpeechCmd startSpeechCmd = (StartSpeechCmd) command;
                        startSpeechCmd.setStatus(basePacket.getStatus());
                        startSpeechCmd.setResponse(startSpeechResponse);
                        return startSpeechCmd;
                    }
                    StartSpeechCmd startSpeechCmd2 = new StartSpeechCmd(new StartSpeechParam((byte) 1, AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN, (byte) 1));
                    startSpeechCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    startSpeechCmd2.setStatus(basePacket.getStatus());
                    startSpeechCmd2.setResponse(startSpeechResponse);
                    return startSpeechCmd2;
                }
                if (opCode == 5) {
                    StopSpeechResponse stopSpeechResponse = new StopSpeechResponse();
                    if (paramData == null || paramData.length < 1) {
                        z = false;
                        z2 = false;
                        z6 = false;
                    } else {
                        byte b5 = paramData[0];
                        z = (b5 & 1) == 1;
                        z2 = (b5 & 2) == 2;
                        if ((b5 & 4) != 4) {
                            z6 = false;
                        }
                    }
                    stopSpeechResponse.setRawData(paramData);
                    stopSpeechResponse.setSyncIatText(z);
                    stopSpeechResponse.setSyncNlpText(z2);
                    stopSpeechResponse.setPlayTTS(z6);
                    if (command != null) {
                        StopSpeechCmd stopSpeechCmd = (StopSpeechCmd) command;
                        stopSpeechCmd.setStatus(basePacket.getStatus());
                        stopSpeechCmd.setResponse(stopSpeechResponse);
                        return stopSpeechCmd;
                    }
                    StopSpeechCmd stopSpeechCmd2 = new StopSpeechCmd(new StopSpeechParam().setReason((byte) 0));
                    stopSpeechCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    stopSpeechCmd2.setStatus(basePacket.getStatus());
                    stopSpeechCmd2.setResponse(stopSpeechResponse);
                    return stopSpeechCmd2;
                }
                if (opCode == 210) {
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setRawData(paramData);
                    if (command != null) {
                        CancelSpeechCmd cancelSpeechCmd = (CancelSpeechCmd) command;
                        cancelSpeechCmd.setStatus(basePacket.getStatus());
                        cancelSpeechCmd.setResponse(commonResponse);
                        return cancelSpeechCmd;
                    }
                    CancelSpeechCmd cancelSpeechCmd2 = new CancelSpeechCmd();
                    cancelSpeechCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    cancelSpeechCmd2.setStatus(basePacket.getStatus());
                    cancelSpeechCmd2.setResponse(commonResponse);
                    return cancelSpeechCmd2;
                }
            } else {
                if (opCode == 4) {
                    if (paramData == null || paramData.length < 2) {
                        b = 1;
                    } else {
                        byte b6 = paramData[0];
                        b2 = paramData[1];
                        b4 = b6;
                        b = paramData.length >= 3 ? paramData[2] : (byte) 1;
                    }
                    return new StartSpeechCmd(new StartSpeechParam(b4, b2, b)).setOpCodeSn(basePacket.getOpCodeSn());
                }
                if (opCode == 5) {
                    if (paramData == null || paramData.length <= 0) {
                        z3 = false;
                        z4 = false;
                        z5 = false;
                    } else {
                        byte b7 = paramData[0];
                        if (paramData.length > 1) {
                            byte b8 = paramData[1];
                            z4 = (b8 & 1) == 1;
                            z5 = (b8 & 2) == 2;
                            b3 = b7;
                            z3 = (b8 & 4) == 4;
                        } else {
                            z4 = false;
                            z5 = false;
                            b3 = b7;
                            z3 = false;
                        }
                    }
                    return new StopSpeechCmd(new StopSpeechParam().setReason(b3).setSyncIatText(z4).setSyncNlpText(z5).setPlayTTS(z3)).setOpCodeSn(basePacket.getOpCodeSn());
                }
                if (opCode == 210) {
                    return new CancelSpeechCmd().setOpCodeSn(basePacket.getOpCodeSn());
                }
            }
        }
        return null;
    }
}
