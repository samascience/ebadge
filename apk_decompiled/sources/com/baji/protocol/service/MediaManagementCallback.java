package com.baji.protocol.service;

import com.baji.protocol.model.BackgroundInfo;
import com.baji.protocol.model.BatchPreviewInfo;
import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.MediaFileInfo;
import com.baji.protocol.model.PreviewInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MediaManagementCallback {
    void onBackgroundReceived(long j, BackgroundInfo backgroundInfo);

    void onBatchPreviewReceived(BatchPreviewInfo batchPreviewInfo);

    void onError(String str, Long l, ErrorCode errorCode, String str2);

    void onMediaDeleted(long j, boolean z, String str);

    void onMediaIdAllocated(long j, boolean z, String str);

    void onMediaInfoReceived(MediaFileInfo mediaFileInfo);

    void onMediaListReceived(List<MediaFileInfo> list);

    void onPreviewReceived(long j, PreviewInfo previewInfo);
}
