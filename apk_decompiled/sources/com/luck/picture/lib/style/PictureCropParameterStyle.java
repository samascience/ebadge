package com.luck.picture.lib.style;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class PictureCropParameterStyle implements Parcelable {
    public static final Parcelable.Creator<PictureCropParameterStyle> CREATOR = new a();
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureCropParameterStyle createFromParcel(Parcel parcel) {
            return new PictureCropParameterStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PictureCropParameterStyle[] newArray(int i) {
            return new PictureCropParameterStyle[i];
        }
    }

    protected PictureCropParameterStyle(Parcel parcel) {
        this.a = parcel.readByte() != 0;
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
