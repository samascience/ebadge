package com.baji.protocol.event;

import com.baji.protocol.model.ErrorCode;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class MediaManagementErrorEvent extends BajiBaseEvent {
    private final ErrorCode errorCode;
    private final String errorMessage;
    private final String eventType;
    private final Long mediaId;
    private final String operation;

    public MediaManagementErrorEvent(String str, Long l, ErrorCode errorCode, String str2) {
        p31.f(str, "operation");
        p31.f(errorCode, "errorCode");
        p31.f(str2, "errorMessage");
        this.operation = str;
        this.mediaId = l;
        this.errorCode = errorCode;
        this.errorMessage = str2;
        this.eventType = "MEDIA_MANAGEMENT_ERROR";
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("媒体管理错误: 操作=");
        sb.append(this.operation);
        sb.append(", 媒体ID=");
        Object obj = this.mediaId;
        if (obj == null) {
            obj = "N/A";
        }
        sb.append(obj);
        sb.append(", 错误=");
        sb.append(this.errorCode);
        sb.append(", 信息=");
        sb.append(this.errorMessage);
        return sb.toString();
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final Long getMediaId() {
        return this.mediaId;
    }

    public final String getOperation() {
        return this.operation;
    }
}
