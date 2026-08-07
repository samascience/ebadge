package no.nordicsemi.android.dfu;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
class DfuProgressInfo {
    private int bytesReceived;
    private int bytesSent;
    private int currentPart;
    private int imageSizeInBytes;
    private int initialBytesSent;
    private int lastBytesSent;
    private long lastProgressTime;
    private final ProgressListener mListener;
    private int maxObjectSizeInBytes;
    private int progress;
    private long timeStart;
    private int totalParts;

    interface ProgressListener {
        void updateProgressNotification();
    }

    DfuProgressInfo(ProgressListener progressListener) {
        this.mListener = progressListener;
    }

    void addBytesSent(int i) {
        setBytesSent(this.bytesSent + i);
    }

    int getAvailableObjectSizeIsBytes() {
        int i = this.imageSizeInBytes;
        int i2 = this.bytesSent;
        int i3 = this.maxObjectSizeInBytes;
        return Math.min(i - i2, i3 - (i2 % i3));
    }

    float getAverageSpeed() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.timeStart;
        if (jElapsedRealtime - j != 0) {
            return (this.bytesSent - this.initialBytesSent) / (jElapsedRealtime - j);
        }
        return 0.0f;
    }

    int getBytesReceived() {
        return this.bytesReceived;
    }

    int getBytesSent() {
        return this.bytesSent;
    }

    int getCurrentPart() {
        return this.currentPart;
    }

    int getImageSizeInBytes() {
        return this.imageSizeInBytes;
    }

    int getProgress() {
        return this.progress;
    }

    float getSpeed() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        float f = jElapsedRealtime - this.timeStart != 0 ? (this.bytesSent - this.lastBytesSent) / (jElapsedRealtime - this.lastProgressTime) : 0.0f;
        this.lastProgressTime = jElapsedRealtime;
        this.lastBytesSent = this.bytesSent;
        return f;
    }

    int getTotalParts() {
        return this.totalParts;
    }

    void init(int i, int i2, int i3) {
        this.imageSizeInBytes = i;
        this.maxObjectSizeInBytes = Integer.MAX_VALUE;
        this.currentPart = i2;
        this.totalParts = i3;
    }

    boolean isComplete() {
        return this.bytesSent == this.imageSizeInBytes;
    }

    boolean isLastPart() {
        return this.currentPart == this.totalParts;
    }

    boolean isObjectComplete() {
        return this.bytesSent % this.maxObjectSizeInBytes == 0;
    }

    void setBytesReceived(int i) {
        this.bytesReceived = i;
    }

    void setBytesSent(int i) {
        if (this.timeStart == 0) {
            this.timeStart = SystemClock.elapsedRealtime();
            this.initialBytesSent = i;
        }
        this.bytesSent = i;
        this.progress = (int) ((i * 100.0f) / this.imageSizeInBytes);
        this.mListener.updateProgressNotification();
    }

    void setMaxObjectSizeInBytes(int i) {
        this.maxObjectSizeInBytes = i;
    }

    void setProgress(int i) {
        this.progress = i;
        this.mListener.updateProgressNotification();
    }

    DfuProgressInfo setTotalPart(int i) {
        this.totalParts = i;
        return this;
    }
}
