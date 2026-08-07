package com.jieli.bmp_convert;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class ConvertResult implements Parcelable {
    public static final Parcelable.Creator<ConvertResult> CREATOR = new Parcelable.Creator<ConvertResult>() { // from class: com.jieli.bmp_convert.ConvertResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConvertResult createFromParcel(Parcel parcel) {
            return new ConvertResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConvertResult[] newArray(int i) {
            return new ConvertResult[i];
        }
    };
    private int algorithm;
    private int bufSize;
    private int compressMode;
    private int pixelFormat;
    private int result;

    public ConvertResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public int getBufSize() {
        return this.bufSize;
    }

    public int getCompressMode() {
        return this.compressMode;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public int getResult() {
        return this.result;
    }

    public boolean isConvertSuccess() {
        return this.result > 0;
    }

    public ConvertResult setAlgorithm(int i) {
        this.algorithm = i;
        return this;
    }

    public ConvertResult setBufSize(int i) {
        this.bufSize = i;
        return this;
    }

    public ConvertResult setCompressMode(int i) {
        this.compressMode = i;
        return this;
    }

    public ConvertResult setPixelFormat(int i) {
        this.pixelFormat = i;
        return this;
    }

    public ConvertResult setResult(int i) {
        this.result = i;
        return this;
    }

    public String toString() {
        return "ConvertResult{result=" + this.result + ", algorithm=" + this.algorithm + ", bufSize=" + this.bufSize + ", pixelFormat=" + this.pixelFormat + ", compressMode=" + this.compressMode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.result);
        parcel.writeInt(this.algorithm);
        parcel.writeInt(this.bufSize);
        parcel.writeInt(this.pixelFormat);
        parcel.writeInt(this.compressMode);
    }

    public ConvertResult(Parcel parcel) {
        this.result = parcel.readInt();
        this.algorithm = parcel.readInt();
        this.bufSize = parcel.readInt();
        this.pixelFormat = parcel.readInt();
        this.compressMode = parcel.readInt();
    }
}
