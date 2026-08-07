package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.NotifyAppInfoParam;

/* JADX INFO: loaded from: classes3.dex */
public class NotifyAppInfoCmd extends CommandWithParamAndResponse<NotifyAppInfoParam, CommonResponse> {
    public NotifyAppInfoCmd(NotifyAppInfoParam notifyAppInfoParam) {
        super(Command.CMD_NOTIFY_DEVICE_APP_INFO, NotifyAppInfoCmd.class.getSimpleName(), notifyAppInfoParam);
    }
}
