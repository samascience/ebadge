package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceExtendParamCmdHandler implements ICmdHandler {
    private final String tag = getClass().getSimpleName();

    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        byte[] paramData = basePacket.getParamData();
        DeviceExtendParamCmd.Param fileTransferParam = null;
        if (paramData == null || paramData.length < 1) {
            JL_Log.e(this.tag, "parseDataToCmd", "异常：数据包内容为空，cmd id = " + RcspUtil.formatString("%02x", Integer.valueOf(basePacket.getOpCode())));
            return null;
        }
        if (basePacket.getType() == 1) {
            byte b = paramData[0];
            if (b == 0) {
                fileTransferParam = new DeviceExtendParamCmd.FileTransferParam(paramData);
            } else if (b == 1) {
                fileTransferParam = new DeviceExtendParamCmd.DeleteFileParam(paramData);
            } else if (b == 2) {
                fileTransferParam = new DeviceExtendParamCmd.ReadFileParam(paramData);
            }
            return new DeviceExtendParamCmd(fileTransferParam);
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        DeviceExtendParamCmd deviceExtendParamCmd = command != null ? (DeviceExtendParamCmd) command : new DeviceExtendParamCmd(new DeviceExtendParamCmd.Param(paramData[0]));
        byte b2 = paramData[0];
        DeviceExtendParamCmd.Response fileTransferResponse = b2 == 0 ? new DeviceExtendParamCmd.FileTransferResponse(paramData) : new DeviceExtendParamCmd.Response(b2);
        fileTransferResponse.setRawData(paramData);
        deviceExtendParamCmd.setStatus(basePacket.getStatus());
        deviceExtendParamCmd.setOpCodeSn(basePacket.getOpCodeSn());
        deviceExtendParamCmd.setResponse(fileTransferResponse);
        return deviceExtendParamCmd;
    }
}
