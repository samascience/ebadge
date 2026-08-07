package com.baji.protocol.event;

import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class FileTransferCancelEvent extends BajiBaseEvent {
    private final String eventType;
    private final long fileId;
    private final String reason;

    public FileTransferCancelEvent(long j, String str) {
        p31.f(str, "reason");
        this.fileId = j;
        this.reason = str;
        this.eventType = "FILE_TRANSFER_CANCEL";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "文件传输取消: 文件ID=" + this.fileId + ", 原因=" + this.reason;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public final String getReason() {
        return this.reason;
    }
}
