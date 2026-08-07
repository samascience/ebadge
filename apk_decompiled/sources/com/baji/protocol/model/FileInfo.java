package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.connect.common.Constants;
import defpackage.p31;
import defpackage.y70;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class FileInfo implements Parcelable {
    public static final Parcelable.Creator<FileInfo> CREATOR = new Creator();
    private final int checksum;
    private final long fileId;
    private final String fileName;
    private final String filePath;
    private final long fileSize;
    private final FileType fileType;
    private final Map<String, String> metadata;
    private final long timestamp;

    public static final class Creator implements Parcelable.Creator<FileInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            long j2 = parcel.readLong();
            FileType fileTypeValueOf = FileType.valueOf(parcel.readString());
            int i = parcel.readInt();
            long j3 = parcel.readLong();
            int i2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i2);
            int i3 = 0;
            while (true) {
                String string2 = parcel.readString();
                if (i3 == i2) {
                    return new FileInfo(j, string, j2, fileTypeValueOf, i, j3, linkedHashMap, string2);
                }
                linkedHashMap.put(string2, parcel.readString());
                i3++;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileInfo[] newArray(int i) {
            return new FileInfo[i];
        }
    }

    public FileInfo(long j, String str, long j2, FileType fileType, int i, long j3, Map<String, String> map, String str2) {
        p31.f(str, "fileName");
        p31.f(fileType, "fileType");
        p31.f(map, "metadata");
        p31.f(str2, "filePath");
        this.fileId = j;
        this.fileName = str;
        this.fileSize = j2;
        this.fileType = fileType;
        this.checksum = i;
        this.timestamp = j3;
        this.metadata = map;
        this.filePath = str2;
    }

    public final long component1() {
        return this.fileId;
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

    public final Map<String, String> component7() {
        return this.metadata;
    }

    public final String component8() {
        return this.filePath;
    }

    public final FileInfo copy(long j, String str, long j2, FileType fileType, int i, long j3, Map<String, String> map, String str2) {
        p31.f(str, "fileName");
        p31.f(fileType, "fileType");
        p31.f(map, "metadata");
        p31.f(str2, "filePath");
        return new FileInfo(j, str, j2, fileType, i, j3, map, str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) obj;
        return this.fileId == fileInfo.fileId && p31.a(this.fileName, fileInfo.fileName) && this.fileSize == fileInfo.fileSize && this.fileType == fileInfo.fileType && this.checksum == fileInfo.checksum && this.timestamp == fileInfo.timestamp && p31.a(this.metadata, fileInfo.metadata) && p31.a(this.filePath, fileInfo.filePath);
    }

    public final int getChecksum() {
        return this.checksum;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final FileType getFileType() {
        return this.fileType;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.fileId) * 31) + this.fileName.hashCode()) * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileType.hashCode()) * 31) + Integer.hashCode(this.checksum)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.metadata.hashCode()) * 31) + this.filePath.hashCode();
    }

    public String toString() {
        return "FileInfo(fileId=" + this.fileId + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", fileType=" + this.fileType + ", checksum=" + this.checksum + ", timestamp=" + this.timestamp + ", metadata=" + this.metadata + ", filePath=" + this.filePath + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.fileId);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.fileType.name());
        parcel.writeInt(this.checksum);
        parcel.writeLong(this.timestamp);
        Map<String, String> map = this.metadata;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
        parcel.writeString(this.filePath);
    }

    public /* synthetic */ FileInfo(long j, String str, long j2, FileType fileType, int i, long j3, Map map, String str2, int i2, y70 y70Var) {
        this(j, str, j2, fileType, i, j3, (i2 & 64) != 0 ? u.f() : map, (i2 & 128) != 0 ? Constants.STR_EMPTY : str2);
    }
}
