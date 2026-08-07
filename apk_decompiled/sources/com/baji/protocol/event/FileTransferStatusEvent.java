package com.baji.protocol.event;

import com.baji.protocol.model.TransferStatusInfo;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class FileTransferStatusEvent extends BajiBaseEvent {
    private final String eventType;
    private final TransferStatusInfo statusInfo;

    public FileTransferStatusEvent(TransferStatusInfo transferStatusInfo) {
        p31.f(transferStatusInfo, "statusInfo");
        this.statusInfo = transferStatusInfo;
        this.eventType = "FILE_TRANSFER_STATUS";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "文件传输状态: " + this.statusInfo.getStatus() + " - " + this.statusInfo.getMessage();
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final TransferStatusInfo getStatusInfo() {
        return this.statusInfo;
    }
}
