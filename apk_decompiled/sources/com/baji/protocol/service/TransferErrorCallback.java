package com.baji.protocol.service;

import com.baji.protocol.model.ErrorCode;

/* JADX INFO: loaded from: classes.dex */
public interface TransferErrorCallback {
    void onError(long j, ErrorCode errorCode, String str);
}
