package com.baji.protocol.event;

import com.tencent.connect.common.Constants;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class MediaIdAllocationEvent extends BajiBaseEvent {
    private final String eventType;
    private final long mediaId;
    private final String message;
    private final boolean success;

    public /* synthetic */ MediaIdAllocationEvent(long j, boolean z, String str, int i, y70 y70Var) {
        this(j, z, (i & 4) != 0 ? Constants.STR_EMPTY : str);
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("媒体ID分配: ID=");
        sb.append(this.mediaId);
        sb.append(", 结果=");
        sb.append(this.success ? "成功" : "失败");
        sb.append(", 信息=");
        sb.append(this.message);
        return sb.toString();
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public MediaIdAllocationEvent(long j, boolean z, String str) {
        p31.f(str, "message");
        this.mediaId = j;
        this.success = z;
        this.message = str;
        this.eventType = "MEDIA_ID_ALLOCATION";
    }
}
