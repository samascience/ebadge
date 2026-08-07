package com.baji.protocol.event;

import com.baji.protocol.model.ErrorCode;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class FileTransferErrorEvent extends BajiBaseEvent {
    private final ErrorCode errorCode;
    private final String errorMessage;
    private final String eventType;
    private final long fileId;

    public FileTransferErrorEvent(long j, ErrorCode errorCode, String str) {
        p31.f(errorCode, "errorCode");
        p31.f(str, "errorMessage");
        this.fileId = j;
        this.errorCode = errorCode;
        this.errorMessage = str;
        this.eventType = "FILE_TRANSFER_ERROR";
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "文件传输错误: 文件ID=" + this.fileId + ", 错误代码=" + this.errorCode + ", 错误信息=" + this.errorMessage;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final long getFileId() {
        return this.fileId;
    }
}
