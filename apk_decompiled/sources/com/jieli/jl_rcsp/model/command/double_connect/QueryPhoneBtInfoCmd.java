package com.jieli.jl_rcsp.model.command.double_connect;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.device.double_connect.ConnectedBtInfo;
import com.jieli.jl_rcsp.model.device.double_connect.DeviceBtInfo;

/* JADX INFO: loaded from: classes3.dex */
public class QueryPhoneBtInfoCmd extends CommandBase<Param, Response> {

    public static class NotifyParam extends Param {
        private final ConnectedBtInfo connectedBtInfo = new ConnectedBtInfo();

        public ConnectedBtInfo getConnectedBtInfo() {
            return this.connectedBtInfo;
        }

        @Override // com.jieli.jl_rcsp.model.command.double_connect.QueryPhoneBtInfoCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return this.connectedBtInfo.toData();
        }

        @Override // com.jieli.jl_rcsp.model.command.double_connect.QueryPhoneBtInfoCmd.Param
        public int parseData(byte[] bArr) {
            return this.connectedBtInfo.parseConnectedDeviceBtData(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "NotifyParam{connectedBtInfo=" + this.connectedBtInfo + "} ";
        }
    }

    public static class Param extends BaseParameter {
        private DeviceBtInfo deviceBtInfo;

        public DeviceBtInfo getDeviceBtInfo() {
            return this.deviceBtInfo;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            DeviceBtInfo deviceBtInfo = this.deviceBtInfo;
            return deviceBtInfo != null ? deviceBtInfo.toData() : new byte[0];
        }

        public int parseData(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            DeviceBtInfo deviceBtInfo = new DeviceBtInfo();
            int data = deviceBtInfo.parseData(bArr);
            if (data > 0) {
                setDeviceBtInfo(deviceBtInfo);
            }
            return data;
        }

        public Param setDeviceBtInfo(DeviceBtInfo deviceBtInfo) {
            this.deviceBtInfo = deviceBtInfo;
            return this;
        }
    }

    public static class Response extends CommonResponse {
        private final ConnectedBtInfo connectedBtInfo = new ConnectedBtInfo();

        public ConnectedBtInfo getConnectedBtInfo() {
            return this.connectedBtInfo;
        }

        public int parseData(byte[] bArr) {
            return this.connectedBtInfo.parseConnectedDeviceBtData(bArr);
        }
    }

    public QueryPhoneBtInfoCmd(Param param) {
        this(2, param);
    }

    public QueryPhoneBtInfoCmd(int i, Param param) {
        super(49, "QueryPhoneBtInfoCmd", i);
        setParam(param);
    }
}
