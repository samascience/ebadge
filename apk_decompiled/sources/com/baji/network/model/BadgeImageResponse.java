package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeImageResponse implements Parcelable {
    public static final Parcelable.Creator<BadgeImageResponse> CREATOR = new Creator();
    private final List<BadgeImage> data;
    private final boolean success;

    public static final class Creator implements Parcelable.Creator<BadgeImageResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadgeImageResponse createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(BadgeImage.CREATOR.createFromParcel(parcel));
            }
            return new BadgeImageResponse(z, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadgeImageResponse[] newArray(int i) {
            return new BadgeImageResponse[i];
        }
    }

    public BadgeImageResponse(boolean z, List<BadgeImage> list) {
        p31.f(list, "data");
        this.success = z;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BadgeImageResponse copy$default(BadgeImageResponse badgeImageResponse, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = badgeImageResponse.success;
        }
        if ((i & 2) != 0) {
            list = badgeImageResponse.data;
        }
        return badgeImageResponse.copy(z, list);
    }

    public final boolean component1() {
        return this.success;
    }

    public final List<BadgeImage> component2() {
        return this.data;
    }

    public final BadgeImageResponse copy(boolean z, List<BadgeImage> list) {
        p31.f(list, "data");
        return new BadgeImageResponse(z, list);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgeImageResponse)) {
            return false;
        }
        BadgeImageResponse badgeImageResponse = (BadgeImageResponse) obj;
        return this.success == badgeImageResponse.success && p31.a(this.data, badgeImageResponse.data);
    }

    public final List<BadgeImage> getData() {
        return this.data;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.success) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "BadgeImageResponse(success=" + this.success + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeInt(this.success ? 1 : 0);
        List<BadgeImage> list = this.data;
        parcel.writeInt(list.size());
        Iterator<BadgeImage> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, i);
        }
    }
}
