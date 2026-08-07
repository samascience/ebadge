package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.BaseResponse;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.AlarmExpandCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmExpandCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int opCode;
        BaseResponse readRtcBellArgsResponse = null;
        if (basePacket == null || (opCode = basePacket.getOpCode()) != 37) {
            return null;
        }
        if (basePacket.getType() == 1) {
            return new AlarmExpandCmd(new AlarmExpandCmd.Param((byte) 0, new byte[0]));
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
        AlarmExpandCmd alarmExpandCmd = command != null ? (AlarmExpandCmd) command : new AlarmExpandCmd(new AlarmExpandCmd.ReadRtcBellArgsParams((byte) 0));
        byte b = basePacket.getParamData()[0];
        if (b == 0) {
            int length = basePacket.getParamData().length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(basePacket.getParamData(), 1, bArr, 0, length);
            readRtcBellArgsResponse = new AlarmExpandCmd.ReadRtcBellArgsResponse(b, bArr);
        } else if (b == 1) {
            readRtcBellArgsResponse = new AlarmExpandCmd.Response(b);
        }
        if (readRtcBellArgsResponse != null) {
            readRtcBellArgsResponse.setRawData(basePacket.getParamData());
        }
        alarmExpandCmd.setStatus(basePacket.getStatus());
        alarmExpandCmd.setResponse(readRtcBellArgsResponse);
        alarmExpandCmd.setOpCodeSn(basePacket.getOpCodeSn());
        return alarmExpandCmd;
    }
}
