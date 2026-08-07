package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class PoiRegion implements Parcelable {
    public static final Parcelable.Creator<PoiRegion> CREATOR = new j();
    private final String a;
    private final String b;
    private final String c;

    public PoiRegion(String str, String str2, String str3) {
        this.b = str2;
        this.a = str;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
        parcel.writeString(this.c);
    }
}
