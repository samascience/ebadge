package com.baji.protocol.event;

import com.fasterxml.jackson.core.JsonPointer;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceStorageEvent extends BajiBaseEvent {
    private final String eventType = "DEVICE_STORAGE";
    private final long freeSpace;
    private final long totalCapacity;
    private final long usedSpace;

    public DeviceStorageEvent(long j, long j2, long j3) {
        this.totalCapacity = j;
        this.freeSpace = j2;
        this.usedSpace = j3;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        long j = this.totalCapacity;
        return "设备存储: 已使用 " + (j > 0 ? (int) ((this.usedSpace * ((long) 100)) / j) : 0) + "% (" + this.usedSpace + JsonPointer.SEPARATOR + this.totalCapacity + " bytes)";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final long getFreeSpace() {
        return this.freeSpace;
    }

    public final long getTotalCapacity() {
        return this.totalCapacity;
    }

    public final long getUsedSpace() {
        return this.usedSpace;
    }
}
