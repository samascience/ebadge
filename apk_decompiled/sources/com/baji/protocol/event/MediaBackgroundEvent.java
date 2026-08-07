package com.baji.protocol.event;

import com.baji.protocol.model.BackgroundInfo;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBackgroundEvent extends BajiBaseEvent {
    private final BackgroundInfo backgroundInfo;
    private final String eventType = "MEDIA_BACKGROUND";
    private final long mediaId;

    public MediaBackgroundEvent(long j, BackgroundInfo backgroundInfo) {
        this.mediaId = j;
        this.backgroundInfo = backgroundInfo;
    }

    public final BackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        if (this.backgroundInfo == null) {
            return "媒体背景: ID=" + this.mediaId + ", 获取失败";
        }
        return "媒体背景: ID=" + this.mediaId + ", 大小=" + this.backgroundInfo.getBackgroundSize() + " bytes";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final long getMediaId() {
        return this.mediaId;
    }
}
