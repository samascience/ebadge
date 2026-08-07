package com.baji.protocol.event;

import com.baji.protocol.model.ChunkInfo;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class ChunkTransferEvent extends BajiBaseEvent {
    private final ChunkInfo chunkInfo;
    private final String eventType;

    public ChunkTransferEvent(ChunkInfo chunkInfo) {
        p31.f(chunkInfo, "chunkInfo");
        this.chunkInfo = chunkInfo;
        this.eventType = "CHUNK_TRANSFER";
    }

    public final ChunkInfo getChunkInfo() {
        return this.chunkInfo;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "数据块传输: 文件ID=" + this.chunkInfo.getFileId() + ", 块索引=" + this.chunkInfo.getChunkIndex() + ", 大小=" + this.chunkInfo.getChunkSize() + " bytes";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }
}
