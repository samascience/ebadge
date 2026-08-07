package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Creator();
    private final String deviceName;
    private final String deviceVersion;
    private final List<String> features;
    private final long freeStorage;
    private final long maxFileSize;
    private final String protocolVersion;
    private final long storageCapacity;
    private final List<FileType> supportedFileTypes;

    public static final class Creator implements Parcelable.Creator<DeviceInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DeviceInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(FileType.valueOf(parcel.readString()));
            }
            return new DeviceInfo(string, string2, string3, j, j2, arrayList, parcel.readLong(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DeviceInfo[] newArray(int i) {
            return new DeviceInfo[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceInfo(String str, String str2, String str3, long j, long j2, List<? extends FileType> list, long j3, List<String> list2) {
        p31.f(str, "deviceName");
        p31.f(str2, "deviceVersion");
        p31.f(str3, "protocolVersion");
        p31.f(list, "supportedFileTypes");
        p31.f(list2, "features");
        this.deviceName = str;
        this.deviceVersion = str2;
        this.protocolVersion = str3;
        this.storageCapacity = j;
        this.freeStorage = j2;
        this.supportedFileTypes = list;
        this.maxFileSize = j3;
        this.features = list2;
    }

    public final String component1() {
        return this.deviceName;
    }

    public final String component2() {
        return this.deviceVersion;
    }

    public final String component3() {
        return this.protocolVersion;
    }

    public final long component4() {
        return this.storageCapacity;
    }

    public final long component5() {
        return this.freeStorage;
    }

    public final List<FileType> component6() {
        return this.supportedFileTypes;
    }

    public final long component7() {
        return this.maxFileSize;
    }

    public final List<String> component8() {
        return this.features;
    }

    public final DeviceInfo copy(String str, String str2, String str3, long j, long j2, List<? extends FileType> list, long j3, List<String> list2) {
        p31.f(str, "deviceName");
        p31.f(str2, "deviceVersion");
        p31.f(str3, "protocolVersion");
        p31.f(list, "supportedFileTypes");
        p31.f(list2, "features");
        return new DeviceInfo(str, str2, str3, j, j2, list, j3, list2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return p31.a(this.deviceName, deviceInfo.deviceName) && p31.a(this.deviceVersion, deviceInfo.deviceVersion) && p31.a(this.protocolVersion, deviceInfo.protocolVersion) && this.storageCapacity == deviceInfo.storageCapacity && this.freeStorage == deviceInfo.freeStorage && p31.a(this.supportedFileTypes, deviceInfo.supportedFileTypes) && this.maxFileSize == deviceInfo.maxFileSize && p31.a(this.features, deviceInfo.features);
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDeviceVersion() {
        return this.deviceVersion;
    }

    public final List<String> getFeatures() {
        return this.features;
    }

    public final long getFreeStorage() {
        return this.freeStorage;
    }

    public final long getMaxFileSize() {
        return this.maxFileSize;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final long getStorageCapacity() {
        return this.storageCapacity;
    }

    public final List<FileType> getSupportedFileTypes() {
        return this.supportedFileTypes;
    }

    public int hashCode() {
        return (((((((((((((this.deviceName.hashCode() * 31) + this.deviceVersion.hashCode()) * 31) + this.protocolVersion.hashCode()) * 31) + Long.hashCode(this.storageCapacity)) * 31) + Long.hashCode(this.freeStorage)) * 31) + this.supportedFileTypes.hashCode()) * 31) + Long.hashCode(this.maxFileSize)) * 31) + this.features.hashCode();
    }

    public String toString() {
        return "DeviceInfo(deviceName=" + this.deviceName + ", deviceVersion=" + this.deviceVersion + ", protocolVersion=" + this.protocolVersion + ", storageCapacity=" + this.storageCapacity + ", freeStorage=" + this.freeStorage + ", supportedFileTypes=" + this.supportedFileTypes + ", maxFileSize=" + this.maxFileSize + ", features=" + this.features + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeString(this.deviceName);
        parcel.writeString(this.deviceVersion);
        parcel.writeString(this.protocolVersion);
        parcel.writeLong(this.storageCapacity);
        parcel.writeLong(this.freeStorage);
        List<FileType> list = this.supportedFileTypes;
        parcel.writeInt(list.size());
        Iterator<FileType> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeLong(this.maxFileSize);
        parcel.writeStringList(this.features);
    }

    public /* synthetic */ DeviceInfo(String str, String str2, String str3, long j, long j2, List list, long j3, List list2, int i, y70 y70Var) {
        this(str, str2, str3, j, j2, list, j3, (i & 128) != 0 ? j.j() : list2);
    }
}
