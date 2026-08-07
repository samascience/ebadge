package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkError implements Parcelable {
    public static final Parcelable.Creator<NetworkError> CREATOR = new Creator();
    private final int errorCode;
    private final String errorMessage;
    private final ErrorType errorType;
    private final long timestamp;

    public static final class Creator implements Parcelable.Creator<NetworkError> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetworkError createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new NetworkError(parcel.readInt(), parcel.readString(), ErrorType.valueOf(parcel.readString()), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetworkError[] newArray(int i) {
            return new NetworkError[i];
        }
    }

    public NetworkError(int i, String str, ErrorType errorType, long j) {
        p31.f(str, "errorMessage");
        p31.f(errorType, "errorType");
        this.errorCode = i;
        this.errorMessage = str;
        this.errorType = errorType;
        this.timestamp = j;
    }

    public static /* synthetic */ NetworkError copy$default(NetworkError networkError, int i, String str, ErrorType errorType, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = networkError.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = networkError.errorMessage;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            errorType = networkError.errorType;
        }
        ErrorType errorType2 = errorType;
        if ((i2 & 8) != 0) {
            j = networkError.timestamp;
        }
        return networkError.copy(i, str2, errorType2, j);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ErrorType component3() {
        return this.errorType;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final NetworkError copy(int i, String str, ErrorType errorType, long j) {
        p31.f(str, "errorMessage");
        p31.f(errorType, "errorType");
        return new NetworkError(i, str, errorType, j);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkError)) {
            return false;
        }
        NetworkError networkError = (NetworkError) obj;
        return this.errorCode == networkError.errorCode && p31.a(this.errorMessage, networkError.errorMessage) && this.errorType == networkError.errorType && this.timestamp == networkError.timestamp;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.errorCode) * 31) + this.errorMessage.hashCode()) * 31) + this.errorType.hashCode()) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "NetworkError(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", errorType=" + this.errorType + ", timestamp=" + this.timestamp + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorType.name());
        parcel.writeLong(this.timestamp);
    }

    public /* synthetic */ NetworkError(int i, String str, ErrorType errorType, long j, int i2, y70 y70Var) {
        this(i, str, errorType, (i2 & 8) != 0 ? System.currentTimeMillis() : j);
    }
}
