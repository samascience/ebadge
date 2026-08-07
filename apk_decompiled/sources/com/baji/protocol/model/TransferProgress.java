package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class TransferProgress implements Parcelable {
    public static final Parcelable.Creator<TransferProgress> CREATOR = new Creator();
    private final long estimatedTimeRemaining;
    private final long fileId;
    private final int progressPercent;
    private final long totalBytes;
    private final long transferSpeed;
    private final long transferredBytes;

    public static final class Creator implements Parcelable.Creator<TransferProgress> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferProgress createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new TransferProgress(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferProgress[] newArray(int i) {
            return new TransferProgress[i];
        }
    }

    public TransferProgress(long j, long j2, long j3, int i, long j4, long j5) {
        this.fileId = j;
        this.transferredBytes = j2;
        this.totalBytes = j3;
        this.progressPercent = i;
        this.transferSpeed = j4;
        this.estimatedTimeRemaining = j5;
    }

    public final long component1() {
        return this.fileId;
    }

    public final long component2() {
        return this.transferredBytes;
    }

    public final long component3() {
        return this.totalBytes;
    }

    public final int component4() {
        return this.progressPercent;
    }

    public final long component5() {
        return this.transferSpeed;
    }

    public final long component6() {
        return this.estimatedTimeRemaining;
    }

    public final TransferProgress copy(long j, long j2, long j3, int i, long j4, long j5) {
        return new TransferProgress(j, j2, j3, i, j4, j5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferProgress)) {
            return false;
        }
        TransferProgress transferProgress = (TransferProgress) obj;
        return this.fileId == transferProgress.fileId && this.transferredBytes == transferProgress.transferredBytes && this.totalBytes == transferProgress.totalBytes && this.progressPercent == transferProgress.progressPercent && this.transferSpeed == transferProgress.transferSpeed && this.estimatedTimeRemaining == transferProgress.estimatedTimeRemaining;
    }

    public final long getEstimatedTimeRemaining() {
        return this.estimatedTimeRemaining;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public final int getProgressPercent() {
        return this.progressPercent;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final long getTransferSpeed() {
        return this.transferSpeed;
    }

    public final long getTransferredBytes() {
        return this.transferredBytes;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.fileId) * 31) + Long.hashCode(this.transferredBytes)) * 31) + Long.hashCode(this.totalBytes)) * 31) + Integer.hashCode(this.progressPercent)) * 31) + Long.hashCode(this.transferSpeed)) * 31) + Long.hashCode(this.estimatedTimeRemaining);
    }

    public String toString() {
        return "TransferProgress(fileId=" + this.fileId + ", transferredBytes=" + this.transferredBytes + ", totalBytes=" + this.totalBytes + ", progressPercent=" + this.progressPercent + ", transferSpeed=" + this.transferSpeed + ", estimatedTimeRemaining=" + this.estimatedTimeRemaining + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.fileId);
        parcel.writeLong(this.transferredBytes);
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(this.progressPercent);
        parcel.writeLong(this.transferSpeed);
        parcel.writeLong(this.estimatedTimeRemaining);
    }
}
