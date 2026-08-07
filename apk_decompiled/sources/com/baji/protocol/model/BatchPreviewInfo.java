package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BatchPreviewInfo implements Parcelable {
    public static final Parcelable.Creator<BatchPreviewInfo> CREATOR = new Creator();
    private final List<Long> mediaIds;
    private final List<PreviewInfo> previewInfos;

    public static final class Creator implements Parcelable.Creator<BatchPreviewInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BatchPreviewInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            int i3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList2.add(PreviewInfo.CREATOR.createFromParcel(parcel));
            }
            return new BatchPreviewInfo(arrayList, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BatchPreviewInfo[] newArray(int i) {
            return new BatchPreviewInfo[i];
        }
    }

    public BatchPreviewInfo(List<Long> list, List<PreviewInfo> list2) {
        p31.f(list, "mediaIds");
        p31.f(list2, "previewInfos");
        this.mediaIds = list;
        this.previewInfos = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchPreviewInfo copy$default(BatchPreviewInfo batchPreviewInfo, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = batchPreviewInfo.mediaIds;
        }
        if ((i & 2) != 0) {
            list2 = batchPreviewInfo.previewInfos;
        }
        return batchPreviewInfo.copy(list, list2);
    }

    public final List<Long> component1() {
        return this.mediaIds;
    }

    public final List<PreviewInfo> component2() {
        return this.previewInfos;
    }

    public final BatchPreviewInfo copy(List<Long> list, List<PreviewInfo> list2) {
        p31.f(list, "mediaIds");
        p31.f(list2, "previewInfos");
        return new BatchPreviewInfo(list, list2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BatchPreviewInfo)) {
            return false;
        }
        BatchPreviewInfo batchPreviewInfo = (BatchPreviewInfo) obj;
        return p31.a(this.mediaIds, batchPreviewInfo.mediaIds) && p31.a(this.previewInfos, batchPreviewInfo.previewInfos);
    }

    public final List<Long> getMediaIds() {
        return this.mediaIds;
    }

    public final List<PreviewInfo> getPreviewInfos() {
        return this.previewInfos;
    }

    public int hashCode() {
        return (this.mediaIds.hashCode() * 31) + this.previewInfos.hashCode();
    }

    public String toString() {
        return "BatchPreviewInfo(mediaIds=" + this.mediaIds + ", previewInfos=" + this.previewInfos + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        List<Long> list = this.mediaIds;
        parcel.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeLong(it.next().longValue());
        }
        List<PreviewInfo> list2 = this.previewInfos;
        parcel.writeInt(list2.size());
        Iterator<PreviewInfo> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, i);
        }
    }
}
