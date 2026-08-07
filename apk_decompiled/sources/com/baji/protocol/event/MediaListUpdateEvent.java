package com.baji.protocol.event;

import com.baji.protocol.model.MediaFileInfo;
import defpackage.p31;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaListUpdateEvent extends BajiBaseEvent {
    private final String eventType;
    private final List<MediaFileInfo> mediaList;

    public MediaListUpdateEvent(List<MediaFileInfo> list) {
        p31.f(list, "mediaList");
        this.mediaList = list;
        this.eventType = "MEDIA_LIST_UPDATE";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "媒体列表更新: 共" + this.mediaList.size() + "个文件";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final List<MediaFileInfo> getMediaList() {
        return this.mediaList;
    }
}
