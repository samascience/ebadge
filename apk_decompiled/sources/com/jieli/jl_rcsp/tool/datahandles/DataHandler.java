package com.jieli.jl_rcsp.tool.datahandles;

import com.jieli.jl_rcsp.model.DataInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface DataHandler {
    void addRecvData(DataInfo dataInfo);

    void addSendData(DataInfo dataInfo);

    void release();
}
