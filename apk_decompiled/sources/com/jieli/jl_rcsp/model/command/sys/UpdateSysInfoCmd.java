package com.jieli.jl_rcsp.model.command.sys;

import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.model.parameter.UpdateSysInfoParam;

/* JADX INFO: loaded from: classes3.dex */
public class UpdateSysInfoCmd extends CommandWithParam<UpdateSysInfoParam> {
    public UpdateSysInfoCmd(UpdateSysInfoParam updateSysInfoParam) {
        super(9, UpdateSysInfoCmd.class.getSimpleName(), updateSysInfoParam);
    }
}
