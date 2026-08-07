package com.baji.protocol.event;

import com.baji.protocol.model.ErrorCode;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class SystemErrorEvent extends BajiBaseEvent {
    private final String component;
    private final ErrorCode errorCode;
    private final String errorMessage;
    private final String eventType;

    public /* synthetic */ SystemErrorEvent(ErrorCode errorCode, String str, String str2, int i, y70 y70Var) {
        this(errorCode, str, (i & 4) != 0 ? "SYSTEM" : str2);
    }

    public final String getComponent() {
        return this.component;
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "系统错误: 组件=" + this.component + ", 错误=" + this.errorCode + ", 信息=" + this.errorMessage;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public SystemErrorEvent(ErrorCode errorCode, String str, String str2) {
        p31.f(errorCode, "errorCode");
        p31.f(str, "errorMessage");
        p31.f(str2, "component");
        this.errorCode = errorCode;
        this.errorMessage = str;
        this.component = str2;
        this.eventType = "SYSTEM_ERROR";
    }
}
