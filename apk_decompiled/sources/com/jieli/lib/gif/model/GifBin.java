package com.jieli.lib.gif.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class GifBin implements Parcelable {
    public static final Parcelable.Creator<GifBin> CREATOR = new Parcelable.Creator<GifBin>() { // from class: com.jieli.lib.gif.model.GifBin.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GifBin createFromParcel(Parcel parcel) {
            return new GifBin(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GifBin[] newArray(int i) {
            return new GifBin[i];
        }
    };
    private byte[] data;
    private int height;
    private boolean isPacket;
    private String name;
    private String path;
    private int width;

    public GifBin() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getHeight() {
        return this.height;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isPacket() {
        return this.isPacket;
    }

    public GifBin setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public GifBin setHeight(int i) {
        this.height = i;
        return this;
    }

    public GifBin setName(String str) {
        this.name = str;
        return this;
    }

    public GifBin setPacket(boolean z) {
        this.isPacket = z;
        return this;
    }

    public GifBin setPath(String str) {
        this.path = str;
        return this;
    }

    public GifBin setWidth(int i) {
        this.width = i;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GifBin{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", data=");
        byte[] bArr = this.data;
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(", path='");
        sb.append(this.path);
        sb.append('\'');
        sb.append(", isPacket=");
        sb.append(this.isPacket);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeString(this.path);
        parcel.writeInt(this.isPacket ? 1 : 0);
    }

    public GifBin(Parcel parcel) {
        this.name = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.data = parcel.createByteArray();
        this.path = parcel.readString();
        this.isPacket = parcel.readInt() == 1;
    }
}
