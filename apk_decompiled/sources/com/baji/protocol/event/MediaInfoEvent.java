package com.baji.protocol.event;

import com.baji.protocol.model.MediaFileInfo;

/* JADX INFO: loaded from: classes.dex */
public final class MediaInfoEvent extends BajiBaseEvent {
    private final String eventType = "MEDIA_INFO";
    private final MediaFileInfo mediaInfo;

    public MediaInfoEvent(MediaFileInfo mediaFileInfo) {
        this.mediaInfo = mediaFileInfo;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        if (this.mediaInfo == null) {
            return "媒体信息: 未找到";
        }
        return "媒体信息: " + this.mediaInfo.getFileName() + " (" + this.mediaInfo.getFileSize() + " bytes, " + this.mediaInfo.getFileType() + ')';
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final MediaFileInfo getMediaInfo() {
        return this.mediaInfo;
    }
}
