package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class CommonErrorResponse implements Parcelable {
    public static final Parcelable.Creator<CommonErrorResponse> CREATOR = new Creator();
    private final int code;
    private final String message;

    public static final class Creator implements Parcelable.Creator<CommonErrorResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonErrorResponse createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new CommonErrorResponse(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonErrorResponse[] newArray(int i) {
            return new CommonErrorResponse[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonErrorResponse() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CommonErrorResponse copy$default(CommonErrorResponse commonErrorResponse, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = commonErrorResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = commonErrorResponse.message;
        }
        return commonErrorResponse.copy(i, str);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final CommonErrorResponse copy(int i, String str) {
        p31.f(str, "message");
        return new CommonErrorResponse(i, str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonErrorResponse)) {
            return false;
        }
        CommonErrorResponse commonErrorResponse = (CommonErrorResponse) obj;
        return this.code == commonErrorResponse.code && p31.a(this.message, commonErrorResponse.message);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "CommonErrorResponse(code=" + this.code + ", message=" + this.message + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
    }

    public CommonErrorResponse(int i, String str) {
        p31.f(str, "message");
        this.code = i;
        this.message = str;
    }

    public /* synthetic */ CommonErrorResponse(int i, String str, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "未知错误" : str);
    }
}
