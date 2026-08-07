package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class DownloadProgress implements Parcelable {
    public static final Parcelable.Creator<DownloadProgress> CREATOR = new Creator();
    private final long downloadedBytes;
    private final long estimatedTimeRemaining;
    private final float progress;
    private final long speed;
    private final long totalBytes;

    public static final class Creator implements Parcelable.Creator<DownloadProgress> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DownloadProgress createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new DownloadProgress(parcel.readLong(), parcel.readLong(), parcel.readFloat(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DownloadProgress[] newArray(int i) {
            return new DownloadProgress[i];
        }
    }

    public DownloadProgress(long j, long j2, float f, long j3, long j4) {
        this.totalBytes = j;
        this.downloadedBytes = j2;
        this.progress = f;
        this.speed = j3;
        this.estimatedTimeRemaining = j4;
    }

    public final long component1() {
        return this.totalBytes;
    }

    public final long component2() {
        return this.downloadedBytes;
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

    public final DownloadProgress copy(long j, long j2, float f, long j3, long j4) {
        return new DownloadProgress(j, j2, f, j3, j4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadProgress)) {
            return false;
        }
        DownloadProgress downloadProgress = (DownloadProgress) obj;
        return this.totalBytes == downloadProgress.totalBytes && this.downloadedBytes == downloadProgress.downloadedBytes && Float.compare(this.progress, downloadProgress.progress) == 0 && this.speed == downloadProgress.speed && this.estimatedTimeRemaining == downloadProgress.estimatedTimeRemaining;
    }

    public final long getDownloadedBytes() {
        return this.downloadedBytes;
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

    public int hashCode() {
        return (((((((Long.hashCode(this.totalBytes) * 31) + Long.hashCode(this.downloadedBytes)) * 31) + Float.hashCode(this.progress)) * 31) + Long.hashCode(this.speed)) * 31) + Long.hashCode(this.estimatedTimeRemaining);
    }

    public String toString() {
        return "DownloadProgress(totalBytes=" + this.totalBytes + ", downloadedBytes=" + this.downloadedBytes + ", progress=" + this.progress + ", speed=" + this.speed + ", estimatedTimeRemaining=" + this.estimatedTimeRemaining + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.totalBytes);
        parcel.writeLong(this.downloadedBytes);
        parcel.writeFloat(this.progress);
        parcel.writeLong(this.speed);
        parcel.writeLong(this.estimatedTimeRemaining);
    }
}
