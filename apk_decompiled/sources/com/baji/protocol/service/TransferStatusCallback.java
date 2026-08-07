package com.baji.protocol.service;

import com.baji.protocol.model.TransferStatusInfo;

/* JADX INFO: loaded from: classes.dex */
public interface TransferStatusCallback {
    void onStatusChanged(TransferStatusInfo transferStatusInfo);
}
