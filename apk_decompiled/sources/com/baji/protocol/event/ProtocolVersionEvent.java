package com.baji.protocol.event;

import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class ProtocolVersionEvent extends BajiBaseEvent {
    private final String appProtocolVersion;
    private final String deviceProtocolVersion;
    private final String eventType;
    private final boolean isCompatible;

    public ProtocolVersionEvent(String str, String str2, boolean z) {
        p31.f(str, "deviceProtocolVersion");
        p31.f(str2, "appProtocolVersion");
        this.deviceProtocolVersion = str;
        this.appProtocolVersion = str2;
        this.isCompatible = z;
        this.eventType = "PROTOCOL_VERSION";
    }

    public final String getAppProtocolVersion() {
        return this.appProtocolVersion;
    }

    public final String getDeviceProtocolVersion() {
        return this.deviceProtocolVersion;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("协议版本: 设备=");
        sb.append(this.deviceProtocolVersion);
        sb.append(", 应用=");
        sb.append(this.appProtocolVersion);
        sb.append(", 兼容=");
        sb.append(this.isCompatible ? "是" : "否");
        return sb.toString();
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final boolean isCompatible() {
        return this.isCompatible;
    }
}
