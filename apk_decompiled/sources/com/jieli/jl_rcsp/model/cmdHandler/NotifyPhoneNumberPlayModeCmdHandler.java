package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.phone.NotifyPhoneNumberPlayModeCmd;
import com.jieli.jl_rcsp.model.parameter.NotifyPhoneNumberPlayModeParam;
import com.jieli.jl_rcsp.model.response.NotifyPhoneNumberPlayModeResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class NotifyPhoneNumberPlayModeCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 241) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int iByteToInt = 0;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length > 0) {
                iByteToInt = CHexConver.byteToInt(paramData[0]);
            }
            return new NotifyPhoneNumberPlayModeCmd(new NotifyPhoneNumberPlayModeParam(iByteToInt)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        NotifyPhoneNumberPlayModeResponse notifyPhoneNumberPlayModeResponse = new NotifyPhoneNumberPlayModeResponse((paramData == null || paramData.length <= 0) ? -1 : CHexConver.byteToInt(paramData[0]));
        notifyPhoneNumberPlayModeResponse.setRawData(paramData);
        if (command != null) {
            NotifyPhoneNumberPlayModeCmd notifyPhoneNumberPlayModeCmd = (NotifyPhoneNumberPlayModeCmd) command;
            notifyPhoneNumberPlayModeCmd.setStatus(basePacket.getStatus());
            notifyPhoneNumberPlayModeCmd.setResponse(notifyPhoneNumberPlayModeResponse);
            return notifyPhoneNumberPlayModeCmd;
        }
        NotifyPhoneNumberPlayModeCmd notifyPhoneNumberPlayModeCmd2 = new NotifyPhoneNumberPlayModeCmd(new NotifyPhoneNumberPlayModeParam(0));
        notifyPhoneNumberPlayModeCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        notifyPhoneNumberPlayModeCmd2.setStatus(basePacket.getStatus());
        notifyPhoneNumberPlayModeCmd2.setResponse(notifyPhoneNumberPlayModeResponse);
        return notifyPhoneNumberPlayModeCmd2;
    }
}
