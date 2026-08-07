package com.jieli.jl_rcsp.model.command.tws;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.SetDeviceNotifyAdvInfoParam;
import com.jieli.jl_rcsp.model.response.SetDeviceNotifyAdvInfoResponse;

/* JADX INFO: loaded from: classes3.dex */
public class SetDeviceNotifyAdvInfoCmd extends CommandWithParamAndResponse<SetDeviceNotifyAdvInfoParam, SetDeviceNotifyAdvInfoResponse> {
    public SetDeviceNotifyAdvInfoCmd(SetDeviceNotifyAdvInfoParam setDeviceNotifyAdvInfoParam) {
        super(195, SetDeviceNotifyAdvInfoCmd.class.getSimpleName(), setDeviceNotifyAdvInfoParam);
    }
}
