package com.baji.protocol.event;

import com.baji.protocol.model.FileInfo;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class FileTransferCompleteEvent extends BajiBaseEvent {
    private final long averageSpeed;
    private final String eventType;
    private final FileInfo fileInfo;
    private final long transferTime;

    public FileTransferCompleteEvent(FileInfo fileInfo, long j, long j2) {
        p31.f(fileInfo, "fileInfo");
        this.fileInfo = fileInfo;
        this.transferTime = j;
        this.averageSpeed = j2;
        this.eventType = "FILE_TRANSFER_COMPLETE";
    }

    public final long getAverageSpeed() {
        return this.averageSpeed;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "文件传输完成: " + this.fileInfo.getFileName() + " (耗时: " + this.transferTime + "ms, 平均速度: " + this.averageSpeed + " bytes/s)";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final FileInfo getFileInfo() {
        return this.fileInfo;
    }

    public final long getTransferTime() {
        return this.transferTime;
    }
}
