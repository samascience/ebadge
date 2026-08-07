package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.tws.GetLowLatencySettingsCmd;
import com.jieli.jl_rcsp.model.response.GetLowLatencySettingsResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class GetLowLatencySettingsCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int iBytesToInt;
        if (basePacket == null || basePacket.getOpCode() != 213) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            return new GetLowLatencySettingsCmd().setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        int iBytesToInt2 = 50;
        if (paramData == null || paramData.length <= 1) {
            iBytesToInt = 20;
        } else {
            iBytesToInt = CHexConver.bytesToInt(paramData, 0, 2);
            if (paramData.length > 5) {
                iBytesToInt2 = CHexConver.bytesToInt(paramData, 2, 4);
            }
        }
        GetLowLatencySettingsResponse getLowLatencySettingsResponse = new GetLowLatencySettingsResponse(iBytesToInt, iBytesToInt2);
        getLowLatencySettingsResponse.setRawData(paramData);
        if (command != null) {
            GetLowLatencySettingsCmd getLowLatencySettingsCmd = (GetLowLatencySettingsCmd) command;
            getLowLatencySettingsCmd.setResponse(getLowLatencySettingsResponse);
            getLowLatencySettingsCmd.setStatus(basePacket.getStatus());
            return getLowLatencySettingsCmd;
        }
        GetLowLatencySettingsCmd getLowLatencySettingsCmd2 = new GetLowLatencySettingsCmd();
        getLowLatencySettingsCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        getLowLatencySettingsCmd2.setResponse(getLowLatencySettingsResponse);
        getLowLatencySettingsCmd2.setStatus(basePacket.getStatus());
        return getLowLatencySettingsCmd2;
    }
}
