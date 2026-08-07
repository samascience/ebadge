package com.baji.protocol.event;

import com.baji.protocol.model.FileInfo;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class FileTransferStartEvent extends BajiBaseEvent {
    private final String eventType;
    private final FileInfo fileInfo;

    public FileTransferStartEvent(FileInfo fileInfo) {
        p31.f(fileInfo, "fileInfo");
        this.fileInfo = fileInfo;
        this.eventType = "FILE_TRANSFER_START";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "开始传输文件: " + this.fileInfo.getFileName() + " (" + this.fileInfo.getFileSize() + " bytes)";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final FileInfo getFileInfo() {
        return this.fileInfo;
    }
}
