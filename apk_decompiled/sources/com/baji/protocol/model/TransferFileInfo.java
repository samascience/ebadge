package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.connect.common.Constants;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class TransferFileInfo implements Parcelable {
    public static final Parcelable.Creator<TransferFileInfo> CREATOR = new Creator();
    private final String filePath;
    private final long fileSize;
    private final FileType fileType;
    private final FunctionType functionType;
    private final int mediaId;

    public static final class Creator implements Parcelable.Creator<TransferFileInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferFileInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new TransferFileInfo(parcel.readInt(), parcel.readLong(), FileType.valueOf(parcel.readString()), FunctionType.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferFileInfo[] newArray(int i) {
            return new TransferFileInfo[i];
        }
    }

    public TransferFileInfo(int i, long j, FileType fileType, FunctionType functionType, String str) {
        p31.f(fileType, "fileType");
        p31.f(functionType, "functionType");
        p31.f(str, "filePath");
        this.mediaId = i;
        this.fileSize = j;
        this.fileType = fileType;
        this.functionType = functionType;
        this.filePath = str;
    }

    public static /* synthetic */ TransferFileInfo copy$default(TransferFileInfo transferFileInfo, int i, long j, FileType fileType, FunctionType functionType, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = transferFileInfo.mediaId;
        }
        if ((i2 & 2) != 0) {
            j = transferFileInfo.fileSize;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            fileType = transferFileInfo.fileType;
        }
        FileType fileType2 = fileType;
        if ((i2 & 8) != 0) {
            functionType = transferFileInfo.functionType;
        }
        FunctionType functionType2 = functionType;
        if ((i2 & 16) != 0) {
            str = transferFileInfo.filePath;
        }
        return transferFileInfo.copy(i, j2, fileType2, functionType2, str);
    }

    public final int component1() {
        return this.mediaId;
    }

    public final long component2() {
        return this.fileSize;
    }

    public final FileType component3() {
        return this.fileType;
    }

    public final FunctionType component4() {
        return this.functionType;
    }

    public final String component5() {
        return this.filePath;
    }

    public final TransferFileInfo copy(int i, long j, FileType fileType, FunctionType functionType, String str) {
        p31.f(fileType, "fileType");
        p31.f(functionType, "functionType");
        p31.f(str, "filePath");
        return new TransferFileInfo(i, j, fileType, functionType, str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferFileInfo)) {
            return false;
        }
        TransferFileInfo transferFileInfo = (TransferFileInfo) obj;
        return this.mediaId == transferFileInfo.mediaId && this.fileSize == transferFileInfo.fileSize && this.fileType == transferFileInfo.fileType && this.functionType == transferFileInfo.functionType && p31.a(this.filePath, transferFileInfo.filePath);
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

    public final FunctionType getFunctionType() {
        return this.functionType;
    }

    public final int getMediaId() {
        return this.mediaId;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.mediaId) * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileType.hashCode()) * 31) + this.functionType.hashCode()) * 31) + this.filePath.hashCode();
    }

    public String toString() {
        return "TransferFileInfo(mediaId=" + this.mediaId + ", fileSize=" + this.fileSize + ", fileType=" + this.fileType + ", functionType=" + this.functionType + ", filePath=" + this.filePath + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeInt(this.mediaId);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.fileType.name());
        parcel.writeString(this.functionType.name());
        parcel.writeString(this.filePath);
    }

    public /* synthetic */ TransferFileInfo(int i, long j, FileType fileType, FunctionType functionType, String str, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? -1 : i, j, fileType, functionType, (i2 & 16) != 0 ? Constants.STR_EMPTY : str);
    }
}
