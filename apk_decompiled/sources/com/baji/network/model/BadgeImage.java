package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.SocialConstants;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeImage implements Parcelable {
    public static final Parcelable.Creator<BadgeImage> CREATOR = new Creator();
    private final String id;
    private final int type;
    private final String url;

    public static final class Creator implements Parcelable.Creator<BadgeImage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadgeImage createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new BadgeImage(parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadgeImage[] newArray(int i) {
            return new BadgeImage[i];
        }
    }

    public BadgeImage(String str, int i, String str2) {
        p31.f(str, "id");
        p31.f(str2, SocialConstants.PARAM_URL);
        this.id = str;
        this.type = i;
        this.url = str2;
    }

    public static /* synthetic */ BadgeImage copy$default(BadgeImage badgeImage, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = badgeImage.id;
        }
        if ((i2 & 2) != 0) {
            i = badgeImage.type;
        }
        if ((i2 & 4) != 0) {
            str2 = badgeImage.url;
        }
        return badgeImage.copy(str, i, str2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.url;
    }

    public final BadgeImage copy(String str, int i, String str2) {
        p31.f(str, "id");
        p31.f(str2, SocialConstants.PARAM_URL);
        return new BadgeImage(str, i, str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgeImage)) {
            return false;
        }
        BadgeImage badgeImage = (BadgeImage) obj;
        return p31.a(this.id, badgeImage.id) && this.type == badgeImage.type && p31.a(this.url, badgeImage.url);
    }

    public final String getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final String getTypeDescription() {
        int i = this.type;
        if (i == 1) {
            return "边框";
        }
        if (i != 2) {
            return i != 3 ? "未知" : "时间样式";
        }
        return "贴纸";
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Integer.hashCode(this.type)) * 31) + this.url.hashCode();
    }

    public final boolean isBorder() {
        return this.type == 1;
    }

    public final boolean isSticker() {
        return this.type == 2;
    }

    public final boolean isTimeStyle() {
        return this.type == 3;
    }

    public String toString() {
        return "BadgeImage(id=" + this.id + ", type=" + this.type + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
    }
}
