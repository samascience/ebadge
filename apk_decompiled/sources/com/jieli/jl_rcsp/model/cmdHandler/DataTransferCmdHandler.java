package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.data.DataTransferCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;

/* JADX INFO: loaded from: classes3.dex */
public class DataTransferCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 48) {
            return null;
        }
        int i = basePacket.getHasResponse() == 0 ? 1 : 2;
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getType() == 1) {
            DataTransferCmd.Param param = new DataTransferCmd.Param(paramData);
            int op = param.getOp();
            if (op == 0) {
                param = new DataTransferCmd.TransferParam(paramData).getWay() == 1 ? new DataTransferCmd.SendDataParam(paramData) : new DataTransferCmd.ReadDataParam(paramData);
            } else if (op == 1) {
                param = new DataTransferCmd.DataTransferParam(paramData);
            } else if (op == 2) {
                param = new DataTransferCmd.CancelTransferParam(paramData);
            }
            return new DataTransferCmd(i, param).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        DataTransferCmd dataTransferCmd = command == null ? new DataTransferCmd(new DataTransferCmd.Param(new byte[0])) : (DataTransferCmd) command;
        DataTransferCmd.Response response = new DataTransferCmd.Response(paramData);
        int op2 = response.getOp();
        if (op2 == 0) {
            response = new DataTransferCmd.TransferParamResponse(paramData).getWay() == 1 ? new DataTransferCmd.SendDataResponse(paramData) : new DataTransferCmd.ReadDataResponse(paramData);
        } else if (op2 == 1) {
            response = new DataTransferCmd.DataTransferResponse(paramData);
        }
        dataTransferCmd.setResponse(response);
        dataTransferCmd.setStatus(basePacket.getStatus());
        dataTransferCmd.setOpCodeSn(basePacket.getOpCodeSn());
        return dataTransferCmd;
    }
}
