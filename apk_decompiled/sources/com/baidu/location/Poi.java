package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Poi implements Parcelable {
    public static final Parcelable.Creator<Poi> CREATOR = new i();
    private final double a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public Poi(String str, String str2, double d, String str3, String str4) {
        this.b = str;
        this.c = str2;
        this.a = d;
        this.d = str3;
        this.e = str4;
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public double d() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeDouble(this.a);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
