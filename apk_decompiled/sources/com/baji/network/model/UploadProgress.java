package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class UploadProgress implements Parcelable {
    public static final Parcelable.Creator<UploadProgress> CREATOR = new Creator();
    private final long estimatedTimeRemaining;
    private final float progress;
    private final long speed;
    private final long totalBytes;
    private final long uploadedBytes;

    public static final class Creator implements Parcelable.Creator<UploadProgress> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UploadProgress createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new UploadProgress(parcel.readLong(), parcel.readLong(), parcel.readFloat(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UploadProgress[] newArray(int i) {
            return new UploadProgress[i];
        }
    }

    public UploadProgress(long j, long j2, float f, long j3, long j4) {
        this.totalBytes = j;
        this.uploadedBytes = j2;
        this.progress = f;
        this.speed = j3;
        this.estimatedTimeRemaining = j4;
    }

    public final long component1() {
        return this.totalBytes;
    }

    public final long component2() {
        return this.uploadedBytes;
    }

    public final float component3() {
        return this.progress;
    }

    public final long component4() {
        return this.speed;
    }

    public final long component5() {
        return this.estimatedTimeRemaining;
    }

    public final UploadProgress copy(long j, long j2, float f, long j3, long j4) {
        return new UploadProgress(j, j2, f, j3, j4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadProgress)) {
            return false;
        }
        UploadProgress uploadProgress = (UploadProgress) obj;
        return this.totalBytes == uploadProgress.totalBytes && this.uploadedBytes == uploadProgress.uploadedBytes && Float.compare(this.progress, uploadProgress.progress) == 0 && this.speed == uploadProgress.speed && this.estimatedTimeRemaining == uploadProgress.estimatedTimeRemaining;
    }

    public final long getEstimatedTimeRemaining() {
        return this.estimatedTimeRemaining;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final long getSpeed() {
        return this.speed;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final long getUploadedBytes() {
        return this.uploadedBytes;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.totalBytes) * 31) + Long.hashCode(this.uploadedBytes)) * 31) + Float.hashCode(this.progress)) * 31) + Long.hashCode(this.speed)) * 31) + Long.hashCode(this.estimatedTimeRemaining);
    }

    public String toString() {
        return "UploadProgress(totalBytes=" + this.totalBytes + ", uploadedBytes=" + this.uploadedBytes + ", progress=" + this.progress + ", speed=" + this.speed + ", estimatedTimeRemaining=" + this.estimatedTimeRemaining + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.totalBytes);
        parcel.writeLong(this.uploadedBytes);
        parcel.writeFloat(this.progress);
        parcel.writeLong(this.speed);
        parcel.writeLong(this.estimatedTimeRemaining);
    }
}
