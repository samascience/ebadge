package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.SearchDevCmd;
import com.jieli.jl_rcsp.model.parameter.SearchDevParam;
import com.jieli.jl_rcsp.model.response.SearchDevResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class SearchDevCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int iByteToInt;
        int iByteToInt2;
        int iByteToInt3;
        int iBytesToInt;
        if (basePacket == null || basePacket.getOpCode() != 25) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i = 0;
        if (basePacket.getType() != 1) {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            SearchDevResponse searchDevResponse = (paramData == null || paramData.length <= 0) ? new SearchDevResponse(0) : new SearchDevResponse(CHexConver.byteToInt(paramData[0]));
            searchDevResponse.setRawData(paramData);
            if (command != null) {
                SearchDevCmd searchDevCmd = (SearchDevCmd) command;
                searchDevCmd.setStatus(basePacket.getStatus());
                searchDevCmd.setResponse(searchDevResponse);
                return searchDevCmd;
            }
            SearchDevCmd searchDevCmd2 = new SearchDevCmd(new SearchDevParam());
            searchDevCmd2.setOpCodeSn(basePacket.getOpCodeSn());
            searchDevCmd2.setStatus(basePacket.getStatus());
            searchDevCmd2.setResponse(searchDevResponse);
            return searchDevCmd2;
        }
        if (paramData != null && paramData.length > 0) {
            iByteToInt = CHexConver.byteToInt(paramData[0]);
            if (paramData.length > 1) {
                iByteToInt3 = CHexConver.byteToInt(paramData[1]);
                if (paramData.length > 3) {
                    iBytesToInt = CHexConver.bytesToInt(paramData[2], paramData[3]);
                    if (paramData.length > 4) {
                        int iByteToInt4 = CHexConver.byteToInt(paramData[4]);
                        iByteToInt2 = paramData.length > 5 ? CHexConver.byteToInt(paramData[5]) : 0;
                        i = iByteToInt4;
                    } else {
                        iByteToInt2 = 0;
                    }
                } else {
                    iByteToInt2 = 0;
                    iBytesToInt = 0;
                }
            } else {
                iByteToInt2 = 0;
            }
            return new SearchDevCmd(new SearchDevParam(iByteToInt, iByteToInt3, iBytesToInt).setWay(i).setPlayer(iByteToInt2)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        iByteToInt = 0;
        iByteToInt2 = 0;
        iByteToInt3 = iByteToInt2;
        iBytesToInt = iByteToInt3;
        return new SearchDevCmd(new SearchDevParam(iByteToInt, iByteToInt3, iBytesToInt).setWay(i).setPlayer(iByteToInt2)).setOpCodeSn(basePacket.getOpCodeSn());
    }
}
