package com.baji.protocol.event;

import com.baji.protocol.model.PreviewInfo;

/* JADX INFO: loaded from: classes.dex */
public final class MediaPreviewEvent extends BajiBaseEvent {
    private final String eventType = "MEDIA_PREVIEW";
    private final long mediaId;
    private final PreviewInfo previewInfo;

    public MediaPreviewEvent(long j, PreviewInfo previewInfo) {
        this.mediaId = j;
        this.previewInfo = previewInfo;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        if (this.previewInfo == null) {
            return "媒体预览: ID=" + this.mediaId + ", 获取失败";
        }
        return "媒体预览: ID=" + this.mediaId + ", 大小=" + this.previewInfo.getPreviewSize() + " bytes";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    public final PreviewInfo getPreviewInfo() {
        return this.previewInfo;
    }
}
