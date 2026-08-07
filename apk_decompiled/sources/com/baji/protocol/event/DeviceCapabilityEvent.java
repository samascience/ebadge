package com.baji.protocol.event;

import com.baji.protocol.model.FileType;
import defpackage.p31;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceCapabilityEvent extends BajiBaseEvent {
    private final String eventType;
    private final List<String> features;
    private final long maxFileSize;
    private final List<FileType> supportedFileTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceCapabilityEvent(List<? extends FileType> list, long j, List<String> list2) {
        p31.f(list, "supportedFileTypes");
        p31.f(list2, "features");
        this.supportedFileTypes = list;
        this.maxFileSize = j;
        this.features = list2;
        this.eventType = "DEVICE_CAPABILITY";
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        return "设备能力: 支持" + this.supportedFileTypes.size() + "种文件类型, 最大文件" + this.maxFileSize + " bytes, 功能: " + j.N(this.features, ", ", null, null, 0, null, null, 62, null);
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final List<String> getFeatures() {
        return this.features;
    }

    public final long getMaxFileSize() {
        return this.maxFileSize;
    }

    public final List<FileType> getSupportedFileTypes() {
        return this.supportedFileTypes;
    }
}
