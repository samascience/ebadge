package com.jieli.jl_rcsp.model.command.upgrade;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.FirmwareUpdateBlockParam;
import com.jieli.jl_rcsp.model.response.FirmwareUpdateBlockResponse;

/* JADX INFO: loaded from: classes3.dex */
public class FirmwareUpdateBlockCmd extends CommandWithParamAndResponse<FirmwareUpdateBlockParam, FirmwareUpdateBlockResponse> {
    public FirmwareUpdateBlockCmd(FirmwareUpdateBlockParam firmwareUpdateBlockParam) {
        super(229, FirmwareUpdateBlockCmd.class.getSimpleName(), firmwareUpdateBlockParam);
    }
}
