package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class PreviewInfo implements Parcelable {
    public static final Parcelable.Creator<PreviewInfo> CREATOR = new Creator();
    private final long mediaId;
    private final byte[] previewData;
    private final int previewSize;

    public static final class Creator implements Parcelable.Creator<PreviewInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PreviewInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new PreviewInfo(parcel.readLong(), parcel.readInt(), parcel.createByteArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PreviewInfo[] newArray(int i) {
            return new PreviewInfo[i];
        }
    }

    public PreviewInfo(long j, int i, byte[] bArr) {
        this.mediaId = j;
        this.previewSize = i;
        this.previewData = bArr;
    }

    public static /* synthetic */ PreviewInfo copy$default(PreviewInfo previewInfo, long j, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = previewInfo.mediaId;
        }
        if ((i2 & 2) != 0) {
            i = previewInfo.previewSize;
        }
        if ((i2 & 4) != 0) {
            bArr = previewInfo.previewData;
        }
        return previewInfo.copy(j, i, bArr);
    }

    public final long component1() {
        return this.mediaId;
    }

    public final int component2() {
        return this.previewSize;
    }

    public final byte[] component3() {
        return this.previewData;
    }

    public final PreviewInfo copy(long j, int i, byte[] bArr) {
        return new PreviewInfo(j, i, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!p31.a(PreviewInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        p31.d(obj, "null cannot be cast to non-null type com.baji.protocol.model.PreviewInfo");
        PreviewInfo previewInfo = (PreviewInfo) obj;
        if (this.mediaId != previewInfo.mediaId || this.previewSize != previewInfo.previewSize) {
            return false;
        }
        byte[] bArr = this.previewData;
        if (bArr != null) {
            byte[] bArr2 = previewInfo.previewData;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (previewInfo.previewData != null) {
            return false;
        }
        return true;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    public final byte[] getPreviewData() {
        return this.previewData;
    }

    public final int getPreviewSize() {
        return this.previewSize;
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.mediaId) * 31) + this.previewSize) * 31;
        byte[] bArr = this.previewData;
        return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "PreviewInfo(mediaId=" + this.mediaId + ", previewSize=" + this.previewSize + ", previewData=" + Arrays.toString(this.previewData) + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.mediaId);
        parcel.writeInt(this.previewSize);
        parcel.writeByteArray(this.previewData);
    }

    public /* synthetic */ PreviewInfo(long j, int i, byte[] bArr, int i2, y70 y70Var) {
        this(j, i, (i2 & 4) != 0 ? null : bArr);
    }
}
