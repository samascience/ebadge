package com.baji.protocol.event;

import com.baji.protocol.model.TransferProgress;
import com.fasterxml.jackson.core.JsonPointer;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class FileTransferProgressEvent extends BajiBaseEvent {
    private final String eventType;
    private final TransferProgress progress;

    public FileTransferProgressEvent(TransferProgress transferProgress) {
        p31.f(transferProgress, "progress");
        this.progress = transferProgress;
        this.eventType = "FILE_TRANSFER_PROGRESS";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "文件传输进度: " + this.progress.getProgressPercent() + "% (" + this.progress.getTransferredBytes() + JsonPointer.SEPARATOR + this.progress.getTotalBytes() + " bytes)";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final TransferProgress getProgress() {
        return this.progress;
    }
}
