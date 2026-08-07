package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.connect.common.Constants;
import defpackage.p31;
import defpackage.y70;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class ProtocolResponse implements Parcelable {
    public static final Parcelable.Creator<ProtocolResponse> CREATOR = new Creator();
    private final Map<String, String> data;
    private final ErrorCode errorCode;
    private final String message;
    private final boolean success;

    public static final class Creator implements Parcelable.Creator<ProtocolResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProtocolResponse createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            ErrorCode errorCodeValueOf = ErrorCode.valueOf(parcel.readString());
            String string = parcel.readString();
            int i = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i);
            for (int i2 = 0; i2 != i; i2++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new ProtocolResponse(z, errorCodeValueOf, string, linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProtocolResponse[] newArray(int i) {
            return new ProtocolResponse[i];
        }
    }

    public ProtocolResponse(boolean z, ErrorCode errorCode, String str, Map<String, String> map) {
        p31.f(errorCode, "errorCode");
        p31.f(str, "message");
        p31.f(map, "data");
        this.success = z;
        this.errorCode = errorCode;
        this.message = str;
        this.data = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProtocolResponse copy$default(ProtocolResponse protocolResponse, boolean z, ErrorCode errorCode, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = protocolResponse.success;
        }
        if ((i & 2) != 0) {
            errorCode = protocolResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str = protocolResponse.message;
        }
        if ((i & 8) != 0) {
            map = protocolResponse.data;
        }
        return protocolResponse.copy(z, errorCode, str, map);
    }

    public final boolean component1() {
        return this.success;
    }

    public final ErrorCode component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.message;
    }

    public final Map<String, String> component4() {
        return this.data;
    }

    public final ProtocolResponse copy(boolean z, ErrorCode errorCode, String str, Map<String, String> map) {
        p31.f(errorCode, "errorCode");
        p31.f(str, "message");
        p31.f(map, "data");
        return new ProtocolResponse(z, errorCode, str, map);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtocolResponse)) {
            return false;
        }
        ProtocolResponse protocolResponse = (ProtocolResponse) obj;
        return this.success == protocolResponse.success && this.errorCode == protocolResponse.errorCode && p31.a(this.message, protocolResponse.message) && p31.a(this.data, protocolResponse.data);
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.success) * 31) + this.errorCode.hashCode()) * 31) + this.message.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "ProtocolResponse(success=" + this.success + ", errorCode=" + this.errorCode + ", message=" + this.message + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeInt(this.success ? 1 : 0);
        parcel.writeString(this.errorCode.name());
        parcel.writeString(this.message);
        Map<String, String> map = this.data;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public /* synthetic */ ProtocolResponse(boolean z, ErrorCode errorCode, String str, Map map, int i, y70 y70Var) {
        this(z, (i & 2) != 0 ? ErrorCode.SUCCESS : errorCode, (i & 4) != 0 ? Constants.STR_EMPTY : str, (i & 8) != 0 ? u.f() : map);
    }
}
