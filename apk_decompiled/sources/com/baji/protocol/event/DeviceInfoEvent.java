package com.baji.protocol.event;

import com.baji.protocol.model.DeviceInfo;
import com.fasterxml.jackson.core.JsonPointer;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceInfoEvent extends BajiBaseEvent {
    private final DeviceInfo deviceInfo;
    private final String eventType = "DEVICE_INFO";

    public DeviceInfoEvent(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        if (this.deviceInfo == null) {
            return "设备信息: 获取失败";
        }
        return "设备信息: " + this.deviceInfo.getDeviceName() + " v" + this.deviceInfo.getDeviceVersion() + ", 存储: " + this.deviceInfo.getFreeStorage() + JsonPointer.SEPARATOR + this.deviceInfo.getStorageCapacity() + " bytes";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }
}
