package com.jieli.jl_rcsp.tool.datahandles;

import com.jieli.jl_rcsp.model.DataInfo;
import com.jieli.jl_rcsp.model.base.BasePacket;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DataInfoCache extends ArrayList<DataInfo> {
    public DataInfo getDataInfo(BasePacket basePacket) {
        for (DataInfo dataInfo : this) {
            if (dataInfo.getBasePacket().getOpCode() == basePacket.getOpCode() && dataInfo.getBasePacket().getOpCodeSn() == basePacket.getOpCodeSn()) {
                return dataInfo;
            }
        }
        return null;
    }
}
