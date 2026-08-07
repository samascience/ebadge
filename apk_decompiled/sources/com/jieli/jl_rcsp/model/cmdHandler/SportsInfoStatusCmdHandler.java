package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.JL_Log;

/* JADX INFO: loaded from: classes3.dex */
public class SportsInfoStatusCmdHandler implements ICmdHandler {
    private final String tag = getClass().getSimpleName();

    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 166) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        int i = basePacket.getHasResponse() == 1 ? 2 : 1;
        if (basePacket.getType() != 1) {
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
            if (command == null) {
                JL_Log.e(this.tag, "parseDataToCmd", "invalid sports info status sync cmd response");
                return null;
            }
            try {
                SportsInfoStatusSyncCmd.Response response = new SportsInfoStatusSyncCmd.Response(paramData);
                int op = response.getOp();
                if (op == 0) {
                    response = new SportsInfoStatusSyncCmd.ReadSportsInfoResponse(paramData);
                } else if (op == 2) {
                    response = new SportsInfoStatusSyncCmd.AppStopSportsResponse(paramData);
                } else if (op == 6) {
                    response = new SportsInfoStatusSyncCmd.ReadRealDataResponse(paramData);
                }
                SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd = (SportsInfoStatusSyncCmd) command;
                sportsInfoStatusSyncCmd.setOpCodeSn(basePacket.getOpCodeSn());
                sportsInfoStatusSyncCmd.setStatus(basePacket.getStatus());
                sportsInfoStatusSyncCmd.setResponse(response);
                return sportsInfoStatusSyncCmd;
            } catch (ParseDataException e) {
                JL_Log.w(this.tag, "parseDataToCmd", "response ParseDataException : " + e);
                return null;
            }
        }
        try {
            SportsInfoStatusSyncCmd.Param param = new SportsInfoStatusSyncCmd.Param(paramData);
            switch (param.getOp()) {
                case 0:
                    param = new SportsInfoStatusSyncCmd.ReadSportsInfoParam(paramData);
                    break;
                case 1:
                    param = new SportsInfoStatusSyncCmd.StartSportsParam(paramData);
                    break;
                case 2:
                    param = new SportsInfoStatusSyncCmd.AppStopSportsParam(paramData);
                    break;
                case 3:
                    param = new SportsInfoStatusSyncCmd.FirmwareStopSportsParam(paramData);
                    break;
                case 4:
                    param = new SportsInfoStatusSyncCmd.PauseSportsParam(paramData);
                    break;
                case 5:
                    param = new SportsInfoStatusSyncCmd.ResumeSportsParam(paramData);
                    break;
                case 6:
                    param = new SportsInfoStatusSyncCmd.ReadRealDataParam(paramData);
                    break;
                case 7:
                    param = new SportsInfoStatusSyncCmd.SetReadRealDataIntervalParam(paramData);
                    break;
            }
            SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd2 = new SportsInfoStatusSyncCmd(i, param);
            sportsInfoStatusSyncCmd2.setOpCodeSn(basePacket.getOpCodeSn());
            return sportsInfoStatusSyncCmd2;
        } catch (ParseDataException e2) {
            JL_Log.w(this.tag, "parseDataToCmd", "command ParseDataException : " + e2);
            return null;
        }
    }
}
