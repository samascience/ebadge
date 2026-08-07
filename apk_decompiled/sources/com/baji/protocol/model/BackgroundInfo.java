package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class BackgroundInfo implements Parcelable {
    public static final Parcelable.Creator<BackgroundInfo> CREATOR = new Creator();
    private final byte[] backgroundData;
    private final int backgroundSize;
    private final long mediaId;

    public static final class Creator implements Parcelable.Creator<BackgroundInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BackgroundInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new BackgroundInfo(parcel.readLong(), parcel.readInt(), parcel.createByteArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BackgroundInfo[] newArray(int i) {
            return new BackgroundInfo[i];
        }
    }

    public BackgroundInfo(long j, int i, byte[] bArr) {
        this.mediaId = j;
        this.backgroundSize = i;
        this.backgroundData = bArr;
    }

    public static /* synthetic */ BackgroundInfo copy$default(BackgroundInfo backgroundInfo, long j, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = backgroundInfo.mediaId;
        }
        if ((i2 & 2) != 0) {
            i = backgroundInfo.backgroundSize;
        }
        if ((i2 & 4) != 0) {
            bArr = backgroundInfo.backgroundData;
        }
        return backgroundInfo.copy(j, i, bArr);
    }

    public final long component1() {
        return this.mediaId;
    }

    public final int component2() {
        return this.backgroundSize;
    }

    public final byte[] component3() {
        return this.backgroundData;
    }

    public final BackgroundInfo copy(long j, int i, byte[] bArr) {
        return new BackgroundInfo(j, i, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!p31.a(BackgroundInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        p31.d(obj, "null cannot be cast to non-null type com.baji.protocol.model.BackgroundInfo");
        BackgroundInfo backgroundInfo = (BackgroundInfo) obj;
        if (this.mediaId != backgroundInfo.mediaId || this.backgroundSize != backgroundInfo.backgroundSize) {
            return false;
        }
        byte[] bArr = this.backgroundData;
        if (bArr != null) {
            byte[] bArr2 = backgroundInfo.backgroundData;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (backgroundInfo.backgroundData != null) {
            return false;
        }
        return true;
    }

    public final byte[] getBackgroundData() {
        return this.backgroundData;
    }

    public final int getBackgroundSize() {
        return this.backgroundSize;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.mediaId) * 31) + this.backgroundSize) * 31;
        byte[] bArr = this.backgroundData;
        return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "BackgroundInfo(mediaId=" + this.mediaId + ", backgroundSize=" + this.backgroundSize + ", backgroundData=" + Arrays.toString(this.backgroundData) + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.mediaId);
        parcel.writeInt(this.backgroundSize);
        parcel.writeByteArray(this.backgroundData);
    }

    public /* synthetic */ BackgroundInfo(long j, int i, byte[] bArr, int i2, y70 y70Var) {
        this(j, i, (i2 & 4) != 0 ? null : bArr);
    }
}
