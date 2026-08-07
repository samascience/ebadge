package com.jieli.jl_rcsp.model.command.data;

import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.model.parameter.DataParam;

/* JADX INFO: loaded from: classes3.dex */
public class DataCmd extends CommandWithParam<DataParam> {
    public DataCmd(DataParam dataParam) {
        super(1, DataCmd.class.getSimpleName(), dataParam);
    }
}
