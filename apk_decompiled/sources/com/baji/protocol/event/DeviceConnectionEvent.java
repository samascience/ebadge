package com.baji.protocol.event;

import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceConnectionEvent extends BajiBaseEvent {
    private final long connectionTime;
    private final String deviceName;
    private final String eventType;
    private final boolean isConnected;

    public /* synthetic */ DeviceConnectionEvent(boolean z, String str, long j, int i, y70 y70Var) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? System.currentTimeMillis() : j);
    }

    public final long getConnectionTime() {
        return this.connectionTime;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        if (!this.isConnected) {
            return "设备连接: 已断开";
        }
        return "设备连接: " + this.deviceName + " 已连接";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public DeviceConnectionEvent(boolean z, String str, long j) {
        this.isConnected = z;
        this.deviceName = str;
        this.connectionTime = j;
        this.eventType = "DEVICE_CONNECTION";
    }
}
