package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ChunkInfo implements Parcelable {
    public static final Parcelable.Creator<ChunkInfo> CREATOR = new Creator();
    private final byte[] chunkData;
    private final int chunkIndex;
    private final int chunkSize;
    private final long fileId;
    private final boolean isLastChunk;

    public static final class Creator implements Parcelable.Creator<ChunkInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChunkInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new ChunkInfo(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChunkInfo[] newArray(int i) {
            return new ChunkInfo[i];
        }
    }

    public ChunkInfo(long j, int i, int i2, byte[] bArr, boolean z) {
        p31.f(bArr, "chunkData");
        this.fileId = j;
        this.chunkIndex = i;
        this.chunkSize = i2;
        this.chunkData = bArr;
        this.isLastChunk = z;
    }

    public static /* synthetic */ ChunkInfo copy$default(ChunkInfo chunkInfo, long j, int i, int i2, byte[] bArr, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = chunkInfo.fileId;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            i = chunkInfo.chunkIndex;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = chunkInfo.chunkSize;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            bArr = chunkInfo.chunkData;
        }
        byte[] bArr2 = bArr;
        if ((i3 & 16) != 0) {
            z = chunkInfo.isLastChunk;
        }
        return chunkInfo.copy(j2, i4, i5, bArr2, z);
    }

    public final long component1() {
        return this.fileId;
    }

    public final int component2() {
        return this.chunkIndex;
    }

    public final int component3() {
        return this.chunkSize;
    }

    public final byte[] component4() {
        return this.chunkData;
    }

    public final boolean component5() {
        return this.isLastChunk;
    }

    public final ChunkInfo copy(long j, int i, int i2, byte[] bArr, boolean z) {
        p31.f(bArr, "chunkData");
        return new ChunkInfo(j, i, i2, bArr, z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!p31.a(ChunkInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        p31.d(obj, "null cannot be cast to non-null type com.baji.protocol.model.ChunkInfo");
        ChunkInfo chunkInfo = (ChunkInfo) obj;
        return this.fileId == chunkInfo.fileId && this.chunkIndex == chunkInfo.chunkIndex && this.chunkSize == chunkInfo.chunkSize && this.isLastChunk == chunkInfo.isLastChunk && Arrays.equals(this.chunkData, chunkInfo.chunkData);
    }

    public final byte[] getChunkData() {
        return this.chunkData;
    }

    public final int getChunkIndex() {
        return this.chunkIndex;
    }

    public final int getChunkSize() {
        return this.chunkSize;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.fileId) * 31) + this.chunkIndex) * 31) + this.chunkSize) * 31) + Arrays.hashCode(this.chunkData)) * 31) + Boolean.hashCode(this.isLastChunk);
    }

    public final boolean isLastChunk() {
        return this.isLastChunk;
    }

    public String toString() {
        return "ChunkInfo(fileId=" + this.fileId + ", chunkIndex=" + this.chunkIndex + ", chunkSize=" + this.chunkSize + ", chunkData=" + Arrays.toString(this.chunkData) + ", isLastChunk=" + this.isLastChunk + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.fileId);
        parcel.writeInt(this.chunkIndex);
        parcel.writeInt(this.chunkSize);
        parcel.writeByteArray(this.chunkData);
        parcel.writeInt(this.isLastChunk ? 1 : 0);
    }

    public /* synthetic */ ChunkInfo(long j, int i, int i2, byte[] bArr, boolean z, int i3, y70 y70Var) {
        this(j, i, i2, bArr, (i3 & 16) != 0 ? false : z);
    }
}
