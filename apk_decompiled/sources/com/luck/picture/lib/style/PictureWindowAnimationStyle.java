package com.luck.picture.lib.style;

import android.os.Parcel;
import android.os.Parcelable;
import com.luck.picture.lib.R$anim;

/* JADX INFO: loaded from: classes3.dex */
public class PictureWindowAnimationStyle implements Parcelable {
    public static final Parcelable.Creator<PictureWindowAnimationStyle> CREATOR = new a();
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureWindowAnimationStyle createFromParcel(Parcel parcel) {
            return new PictureWindowAnimationStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PictureWindowAnimationStyle[] newArray(int i) {
            return new PictureWindowAnimationStyle[i];
        }
    }

    public PictureWindowAnimationStyle(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = i;
        this.d = i2;
        this.e = i;
        this.f = i2;
    }

    public static PictureWindowAnimationStyle a() {
        return new PictureWindowAnimationStyle(R$anim.picture_anim_enter, R$anim.picture_anim_exit);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }

    protected PictureWindowAnimationStyle(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
    }
}
