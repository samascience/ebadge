package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.connect.common.Constants;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class TransferStatusInfo implements Parcelable {
    public static final Parcelable.Creator<TransferStatusInfo> CREATOR = new Creator();
    private final ErrorCode errorCode;
    private final long fileId;
    private final String message;
    private final TransferStatus status;
    private final long timestamp;

    public static final class Creator implements Parcelable.Creator<TransferStatusInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferStatusInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new TransferStatusInfo(parcel.readLong(), TransferStatus.valueOf(parcel.readString()), ErrorCode.valueOf(parcel.readString()), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferStatusInfo[] newArray(int i) {
            return new TransferStatusInfo[i];
        }
    }

    public TransferStatusInfo(long j, TransferStatus transferStatus, ErrorCode errorCode, String str, long j2) {
        p31.f(transferStatus, "status");
        p31.f(errorCode, "errorCode");
        p31.f(str, "message");
        this.fileId = j;
        this.status = transferStatus;
        this.errorCode = errorCode;
        this.message = str;
        this.timestamp = j2;
    }

    public final long component1() {
        return this.fileId;
    }

    public final TransferStatus component2() {
        return this.status;
    }

    public final ErrorCode component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.message;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final TransferStatusInfo copy(long j, TransferStatus transferStatus, ErrorCode errorCode, String str, long j2) {
        p31.f(transferStatus, "status");
        p31.f(errorCode, "errorCode");
        p31.f(str, "message");
        return new TransferStatusInfo(j, transferStatus, errorCode, str, j2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferStatusInfo)) {
            return false;
        }
        TransferStatusInfo transferStatusInfo = (TransferStatusInfo) obj;
        return this.fileId == transferStatusInfo.fileId && this.status == transferStatusInfo.status && this.errorCode == transferStatusInfo.errorCode && p31.a(this.message, transferStatusInfo.message) && this.timestamp == transferStatusInfo.timestamp;
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final TransferStatus getStatus() {
        return this.status;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.fileId) * 31) + this.status.hashCode()) * 31) + this.errorCode.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "TransferStatusInfo(fileId=" + this.fileId + ", status=" + this.status + ", errorCode=" + this.errorCode + ", message=" + this.message + ", timestamp=" + this.timestamp + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.fileId);
        parcel.writeString(this.status.name());
        parcel.writeString(this.errorCode.name());
        parcel.writeString(this.message);
        parcel.writeLong(this.timestamp);
    }

    public /* synthetic */ TransferStatusInfo(long j, TransferStatus transferStatus, ErrorCode errorCode, String str, long j2, int i, y70 y70Var) {
        this(j, transferStatus, (i & 4) != 0 ? ErrorCode.SUCCESS : errorCode, (i & 8) != 0 ? Constants.STR_EMPTY : str, (i & 16) != 0 ? System.currentTimeMillis() : j2);
    }
}
