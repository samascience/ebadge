package com.baji.protocol.event;

import com.baji.protocol.model.BatchPreviewInfo;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class BatchPreviewInfoEvent extends BajiBaseEvent {
    private final BatchPreviewInfo batchInfo;
    private final String eventType;

    public BatchPreviewInfoEvent(BatchPreviewInfo batchPreviewInfo) {
        p31.f(batchPreviewInfo, "batchInfo");
        this.batchInfo = batchPreviewInfo;
        this.eventType = "BATCH_PREVIEW_INFO";
    }

    public final BatchPreviewInfo getBatchInfo() {
        return this.batchInfo;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "批量预览信息: " + this.batchInfo.getMediaIds().size() + "个媒体文件";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }
}
