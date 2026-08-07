package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.BaseResponse;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class ReadFileFromDeviceCmdHandler implements ICmdHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        byte[] paramData;
        BaseResponse startResponse;
        ReadFileFromDeviceCmd.Param param;
        if (basePacket == null || (paramData = basePacket.getParamData()) == null || paramData.length == 0) {
            return null;
        }
        if (basePacket.getType() == 1) {
            byte b = paramData[0];
            if (b == -128) {
                param = new ReadFileFromDeviceCmd.StopParam(basePacket.getStatus() == 0 ? paramData[1] : (byte) 0);
            } else if (b == -127) {
                param = new ReadFileFromDeviceCmd.CancelParam(basePacket.getStatus() == 0 ? paramData[1] : (byte) 0);
            } else {
                param = new ReadFileFromDeviceCmd.Param((byte) -1);
            }
            ReadFileFromDeviceCmd readFileFromDeviceCmd = new ReadFileFromDeviceCmd(param);
            readFileFromDeviceCmd.setOpCodeSn(basePacket.getOpCodeSn());
            return readFileFromDeviceCmd;
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (command == null) {
            ReadFileFromDeviceCmd readFileFromDeviceCmd2 = new ReadFileFromDeviceCmd(null);
            readFileFromDeviceCmd2.setOpCodeSn(basePacket.getOpCodeSn());
            return readFileFromDeviceCmd2;
        }
        ReadFileFromDeviceCmd readFileFromDeviceCmd3 = (ReadFileFromDeviceCmd) command;
        byte b2 = ((ReadFileFromDeviceCmd.Param) readFileFromDeviceCmd3.getParam()).op;
        if (b2 == 0 || b2 == 1 || b2 == 2) {
            startResponse = new ReadFileFromDeviceCmd.StartResponse(basePacket.getStatus() == 0 ? CHexConver.bytesToInt(paramData, 1, 4) : 0);
        } else {
            startResponse = new ReadFileFromDeviceCmd.Response();
        }
        startResponse.setRawData(basePacket.getParamData());
        readFileFromDeviceCmd3.setStatus(basePacket.getStatus());
        readFileFromDeviceCmd3.setOpCodeSn(basePacket.getOpCodeSn());
        readFileFromDeviceCmd3.setResponse(startResponse);
        return readFileFromDeviceCmd3;
    }
}
