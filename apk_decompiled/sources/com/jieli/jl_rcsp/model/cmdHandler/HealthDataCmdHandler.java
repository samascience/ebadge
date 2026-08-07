package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd;
import com.jieli.jl_rcsp.model.command.watch.ReceiveHealthDataCmd;
import com.jieli.jl_rcsp.model.command.watch.RequestHealthDataCmd;
import com.jieli.jl_rcsp.model.command.watch.SensorLogCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.JL_Log;

/* JADX INFO: loaded from: classes3.dex */
public class HealthDataCmdHandler implements ICmdHandler {
    private final String tag = getClass().getSimpleName();

    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        RequestHealthDataCmd requestHealthDataCmd;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode != 160 && opCode != 161 && opCode != 162 && opCode != 163) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i = 2;
        if (basePacket.getType() == 1) {
            try {
                if (opCode == 160) {
                    if (basePacket.getHasResponse() != 1) {
                        i = 1;
                    }
                    return new RequestHealthDataCmd(i, new RequestHealthDataCmd.Param(paramData)).setOpCodeSn(basePacket.getOpCodeSn());
                }
                if (opCode == 162) {
                    return new ReceiveHealthDataCmd(new ReceiveHealthDataCmd.Param(paramData)).setOpCodeSn(basePacket.getOpCodeSn());
                }
                if (opCode == 163) {
                    return new SensorLogCmd(new SensorLogCmd.Param(paramData)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            } catch (ParseDataException e) {
                JL_Log.w(this.tag, "parseDataToCmd", "command. op code : " + basePacket.getOpCode() + ", " + e);
            }
        } else {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            try {
                if (opCode == 160) {
                    if (command != null) {
                        requestHealthDataCmd = (RequestHealthDataCmd) command;
                    } else {
                        if (basePacket.getHasResponse() != 1) {
                            i = 1;
                        }
                        requestHealthDataCmd = new RequestHealthDataCmd(i, new RequestHealthDataCmd.Param(null));
                    }
                    requestHealthDataCmd.setResponse(new RequestHealthDataCmd.Response(paramData));
                    requestHealthDataCmd.setStatus(basePacket.getStatus());
                    requestHealthDataCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    return requestHealthDataCmd;
                }
                if (opCode == 161) {
                    PushInfoDataToDeviceCmd pushInfoDataToDeviceCmd = command != null ? (PushInfoDataToDeviceCmd) command : new PushInfoDataToDeviceCmd(new PushInfoDataToDeviceCmd.Param(null));
                    pushInfoDataToDeviceCmd.setResponse(new PushInfoDataToDeviceCmd.Response(paramData));
                    pushInfoDataToDeviceCmd.setStatus(basePacket.getStatus());
                    pushInfoDataToDeviceCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    return pushInfoDataToDeviceCmd;
                }
            } catch (ParseDataException e2) {
                JL_Log.w(this.tag, "parseDataToCmd", "response. op code : " + basePacket.getOpCode() + ", " + e2);
            }
        }
        return null;
    }
}
