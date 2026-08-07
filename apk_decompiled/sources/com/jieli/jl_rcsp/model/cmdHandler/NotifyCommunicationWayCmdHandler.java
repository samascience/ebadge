package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.NotifyCommunicationWayCmd;
import com.jieli.jl_rcsp.model.parameter.NotifyCommunicationWayParam;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class NotifyCommunicationWayCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int iByteToInt;
        if (basePacket == null || basePacket.getOpCode() != 11) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int iByteToInt2 = 0;
        if (basePacket.getType() == 1) {
            if (paramData == null || paramData.length <= 1) {
                iByteToInt = 0;
            } else {
                iByteToInt2 = CHexConver.byteToInt(paramData[0]);
                iByteToInt = CHexConver.byteToInt(paramData[1]);
            }
            return new NotifyCommunicationWayCmd(new NotifyCommunicationWayParam(iByteToInt2, iByteToInt)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(paramData);
        if (command != null) {
            NotifyCommunicationWayCmd notifyCommunicationWayCmd = (NotifyCommunicationWayCmd) command;
            notifyCommunicationWayCmd.setStatus(basePacket.getStatus());
            notifyCommunicationWayCmd.setResponse(commonResponse);
            return notifyCommunicationWayCmd;
        }
        NotifyCommunicationWayCmd notifyCommunicationWayCmd2 = new NotifyCommunicationWayCmd(new NotifyCommunicationWayParam(0, 0));
        notifyCommunicationWayCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        notifyCommunicationWayCmd2.setStatus(basePacket.getStatus());
        notifyCommunicationWayCmd2.setResponse(commonResponse);
        return notifyCommunicationWayCmd2;
    }
}
