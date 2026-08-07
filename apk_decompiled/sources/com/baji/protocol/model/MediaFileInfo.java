package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class MediaFileInfo implements Parcelable {
    public static final Parcelable.Creator<MediaFileInfo> CREATOR = new Creator();
    private final int backgroundSize;
    private final int checksum;
    private final String fileName;
    private final long fileSize;
    private final FileType fileType;
    private final long mediaId;
    private final Map<String, String> metadata;
    private final int previewSize;
    private final long timestamp;

    public static final class Creator implements Parcelable.Creator<MediaFileInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaFileInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            long j2 = parcel.readLong();
            FileType fileTypeValueOf = FileType.valueOf(parcel.readString());
            int i = parcel.readInt();
            long j3 = parcel.readLong();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i4);
            int i5 = 0;
            while (i5 != i4) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
                i5++;
                i4 = i4;
            }
            return new MediaFileInfo(j, string, j2, fileTypeValueOf, i, j3, i2, i3, linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaFileInfo[] newArray(int i) {
            return new MediaFileInfo[i];
        }
    }

    public MediaFileInfo(long j, String str, long j2, FileType fileType, int i, long j3, int i2, int i3, Map<String, String> map) {
        p31.f(str, "fileName");
        p31.f(fileType, "fileType");
        p31.f(map, "metadata");
        this.mediaId = j;
        this.fileName = str;
        this.fileSize = j2;
        this.fileType = fileType;
        this.checksum = i;
        this.timestamp = j3;
        this.previewSize = i2;
        this.backgroundSize = i3;
        this.metadata = map;
    }

    public final long component1() {
        return this.mediaId;
    }

    public final String component2() {
        return this.fileName;
    }

    public final long component3() {
        return this.fileSize;
    }

    public final FileType component4() {
        return this.fileType;
    }

    public final int component5() {
        return this.checksum;
    }

    public final long component6() {
        return this.timestamp;
    }

    public final int component7() {
        return this.previewSize;
    }

    public final int component8() {
        return this.backgroundSize;
    }

    public final Map<String, String> component9() {
        return this.metadata;
    }

    public final MediaFileInfo copy(long j, String str, long j2, FileType fileType, int i, long j3, int i2, int i3, Map<String, String> map) {
        p31.f(str, "fileName");
        p31.f(fileType, "fileType");
        p31.f(map, "metadata");
        return new MediaFileInfo(j, str, j2, fileType, i, j3, i2, i3, map);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaFileInfo)) {
            return false;
        }
        MediaFileInfo mediaFileInfo = (MediaFileInfo) obj;
        return this.mediaId == mediaFileInfo.mediaId && p31.a(this.fileName, mediaFileInfo.fileName) && this.fileSize == mediaFileInfo.fileSize && this.fileType == mediaFileInfo.fileType && this.checksum == mediaFileInfo.checksum && this.timestamp == mediaFileInfo.timestamp && this.previewSize == mediaFileInfo.previewSize && this.backgroundSize == mediaFileInfo.backgroundSize && p31.a(this.metadata, mediaFileInfo.metadata);
    }

    public final int getBackgroundSize() {
        return this.backgroundSize;
    }

    public final int getChecksum() {
        return this.checksum;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final FileType getFileType() {
        return this.fileType;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final int getPreviewSize() {
        return this.previewSize;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.mediaId) * 31) + this.fileName.hashCode()) * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileType.hashCode()) * 31) + Integer.hashCode(this.checksum)) * 31) + Long.hashCode(this.timestamp)) * 31) + Integer.hashCode(this.previewSize)) * 31) + Integer.hashCode(this.backgroundSize)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "MediaFileInfo(mediaId=" + this.mediaId + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", fileType=" + this.fileType + ", checksum=" + this.checksum + ", timestamp=" + this.timestamp + ", previewSize=" + this.previewSize + ", backgroundSize=" + this.backgroundSize + ", metadata=" + this.metadata + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.mediaId);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.fileType.name());
        parcel.writeInt(this.checksum);
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.previewSize);
        parcel.writeInt(this.backgroundSize);
        Map<String, String> map = this.metadata;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public /* synthetic */ MediaFileInfo(long j, String str, long j2, FileType fileType, int i, long j3, int i2, int i3, Map map, int i4, y70 y70Var) {
        this(j, str, j2, fileType, i, j3, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? 0 : i3, (i4 & 256) != 0 ? u.f() : map);
    }
}
