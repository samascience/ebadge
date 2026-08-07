package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkResponse<T> implements Parcelable {
    public static final Parcelable.Creator<NetworkResponse<?>> CREATOR = new Creator();
    private final int code;
    private final T data;
    private final String message;
    private final boolean success;
    private final long timestamp;

    public static final class Creator implements Parcelable.Creator<NetworkResponse<?>> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetworkResponse<?> createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new NetworkResponse<>(parcel.readInt() != 0, parcel.readValue(NetworkResponse.class.getClassLoader()), parcel.readString(), parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetworkResponse<?>[] newArray(int i) {
            return new NetworkResponse[i];
        }
    }

    public NetworkResponse(boolean z, T t, String str, int i, long j) {
        this.success = z;
        this.data = t;
        this.message = str;
        this.code = i;
        this.timestamp = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkResponse copy$default(NetworkResponse networkResponse, boolean z, Object obj, String str, int i, long j, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            z = networkResponse.success;
        }
        if ((i2 & 2) != 0) {
            obj = networkResponse.data;
        }
        Object obj3 = obj;
        if ((i2 & 4) != 0) {
            str = networkResponse.message;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            i = networkResponse.code;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            j = networkResponse.timestamp;
        }
        return networkResponse.copy(z, obj3, str2, i3, j);
    }

    public final boolean component1() {
        return this.success;
    }

    public final T component2() {
        return this.data;
    }

    public final String component3() {
        return this.message;
    }

    public final int component4() {
        return this.code;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final NetworkResponse<T> copy(boolean z, T t, String str, int i, long j) {
        return new NetworkResponse<>(z, t, str, i, j);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkResponse)) {
            return false;
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        return this.success == networkResponse.success && p31.a(this.data, networkResponse.data) && p31.a(this.message, networkResponse.message) && this.code == networkResponse.code && this.timestamp == networkResponse.timestamp;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        T t = this.data;
        int iHashCode2 = (iHashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.message;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.code)) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "NetworkResponse(success=" + this.success + ", data=" + this.data + ", message=" + this.message + ", code=" + this.code + ", timestamp=" + this.timestamp + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeInt(this.success ? 1 : 0);
        parcel.writeValue(this.data);
        parcel.writeString(this.message);
        parcel.writeInt(this.code);
        parcel.writeLong(this.timestamp);
    }

    public /* synthetic */ NetworkResponse(boolean z, Object obj, String str, int i, long j, int i2, y70 y70Var) {
        this(z, obj, str, i, (i2 & 16) != 0 ? System.currentTimeMillis() : j);
    }
}
