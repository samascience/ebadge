package com.jieli.lib.gif.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class GifConvertResult implements Parcelable {
    public static final Parcelable.Creator<GifConvertResult> CREATOR = new Parcelable.Creator<GifConvertResult>() { // from class: com.jieli.lib.gif.model.GifConvertResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GifConvertResult createFromParcel(Parcel parcel) {
            return new GifConvertResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GifConvertResult[] newArray(int i) {
            return new GifConvertResult[i];
        }
    };
    private int code;
    private GifBin gifBin;
    private String message;

    public GifConvertResult() {
        this.code = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public GifBin getGifBin() {
        return this.gifBin;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public GifConvertResult setCode(int i) {
        this.code = i;
        return this;
    }

    public GifConvertResult setGifBin(GifBin gifBin) {
        this.gifBin = gifBin;
        return this;
    }

    public GifConvertResult setMessage(String str) {
        this.message = str;
        return this;
    }

    public String toString() {
        return "GifConvertResult{code=" + this.code + ", message='" + this.message + "', gifBin=" + this.gifBin + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.gifBin, i);
    }

    public GifConvertResult(Parcel parcel) {
        this.code = -1;
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.gifBin = (GifBin) parcel.readParcelable(GifBin.class.getClassLoader());
    }
}
