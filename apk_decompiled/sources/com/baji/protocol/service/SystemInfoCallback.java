package com.baji.protocol.service;

import com.baji.protocol.model.DeviceInfo;
import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.FileType;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SystemInfoCallback {
    void onCapabilityReceived(List<? extends FileType> list, long j, List<String> list2);

    void onDeviceInfoReceived(DeviceInfo deviceInfo);

    void onError(ErrorCode errorCode, String str);

    void onStorageStatusReceived(long j, long j2);
}
