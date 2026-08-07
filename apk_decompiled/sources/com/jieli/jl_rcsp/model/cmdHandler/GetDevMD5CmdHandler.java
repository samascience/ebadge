package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.status.GetDevMD5Cmd;
import com.jieli.jl_rcsp.model.response.GetDevMD5Response;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class GetDevMD5CmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        String str;
        if (basePacket == null || basePacket.getOpCode() != 212) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            return new GetDevMD5Cmd().setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (paramData == null || paramData.length < 32) {
            str = Constants.STR_EMPTY;
        } else {
            try {
                str = new String(paramData, 0, 32);
            } catch (Exception e) {
                e.printStackTrace();
                str = Constants.STR_EMPTY;
            }
        }
        GetDevMD5Response getDevMD5Response = new GetDevMD5Response(str);
        getDevMD5Response.setRawData(paramData);
        if (command != null) {
            GetDevMD5Cmd getDevMD5Cmd = (GetDevMD5Cmd) command;
            getDevMD5Cmd.setResponse(getDevMD5Response);
            getDevMD5Cmd.setStatus(basePacket.getStatus());
            return getDevMD5Cmd;
        }
        GetDevMD5Cmd getDevMD5Cmd2 = new GetDevMD5Cmd();
        getDevMD5Cmd2.setOpCodeSn(basePacket.getOpCodeSn());
        getDevMD5Cmd2.setResponse(getDevMD5Response);
        getDevMD5Cmd2.setStatus(basePacket.getStatus());
        return getDevMD5Cmd2;
    }
}
