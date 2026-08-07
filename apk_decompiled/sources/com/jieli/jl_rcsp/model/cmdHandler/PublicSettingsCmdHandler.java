package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.setting.PublicSettingsCmd;
import com.jieli.jl_rcsp.model.device.settings.SettingData;
import com.jieli.jl_rcsp.model.device.settings.v0.BoundDeviceState;
import com.jieli.jl_rcsp.model.device.settings.v0.BrightnessSetting;
import com.jieli.jl_rcsp.model.device.settings.v0.DialExpandInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.FlashlightSetting;
import com.jieli.jl_rcsp.model.device.settings.v0.FunctionResource;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkFunction;
import com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* JADX INFO: loaded from: classes3.dex */
public class PublicSettingsCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 51) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i = basePacket.getHasResponse() == 1 ? 2 : 1;
        if (basePacket.getType() != 1) {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            PublicSettingsCmd publicSettingsCmd = command != null ? (PublicSettingsCmd) command : new PublicSettingsCmd(i, new PublicSettingsCmd.Param());
            publicSettingsCmd.setResponse(new PublicSettingsCmd.Response(paramData));
            publicSettingsCmd.setStatus(basePacket.getStatus());
            publicSettingsCmd.setOpCodeSn(basePacket.getOpCodeSn());
            return publicSettingsCmd;
        }
        SettingData settingData = new SettingData(paramData);
        PublicSettingsCmd.Param param = new PublicSettingsCmd.Param(settingData);
        if (settingData.getVersion() == 0) {
            int function = new SettingFunction(paramData).getFunction();
            if (function == 1) {
                param = new PublicSettingsCmd.Param(new BrightnessSetting(paramData));
            } else if (function == 2) {
                param = new PublicSettingsCmd.Param(new FlashlightSetting(paramData));
            } else if (function == 3) {
                param = new PublicSettingsCmd.Param(new BoundDeviceState(paramData));
            } else if (function == 4) {
                param = new PublicSettingsCmd.Param(new FunctionResource(paramData));
            } else if (function == 5) {
                param = new PublicSettingsCmd.Param(new NetworkFunction(paramData));
            } else if (function == 7) {
                param = new PublicSettingsCmd.Param(new DialExpandInfo(paramData));
            }
        }
        return new PublicSettingsCmd(i, param).setOpCodeSn(basePacket.getOpCodeSn());
    }
}
