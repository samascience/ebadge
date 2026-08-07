package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class AiAccessConfigApiResponse implements Parcelable {
    public static final Parcelable.Creator<AiAccessConfigApiResponse> CREATOR = new Creator();
    private final String data;
    private final CommonErrorResponse error;
    private final String key;
    private final String langConfig;
    private final boolean success;

    public static final class Creator implements Parcelable.Creator<AiAccessConfigApiResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AiAccessConfigApiResponse createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new AiAccessConfigApiResponse(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : CommonErrorResponse.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AiAccessConfigApiResponse[] newArray(int i) {
            return new AiAccessConfigApiResponse[i];
        }
    }

    public AiAccessConfigApiResponse() {
        this(null, false, null, null, null, 31, null);
    }

    public static /* synthetic */ AiAccessConfigApiResponse copy$default(AiAccessConfigApiResponse aiAccessConfigApiResponse, String str, boolean z, String str2, String str3, CommonErrorResponse commonErrorResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiAccessConfigApiResponse.data;
        }
        if ((i & 2) != 0) {
            z = aiAccessConfigApiResponse.success;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = aiAccessConfigApiResponse.langConfig;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = aiAccessConfigApiResponse.key;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            commonErrorResponse = aiAccessConfigApiResponse.error;
        }
        return aiAccessConfigApiResponse.copy(str, z2, str4, str5, commonErrorResponse);
    }

    public final String component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.success;
    }

    public final String component3() {
        return this.langConfig;
    }

    public final String component4() {
        return this.key;
    }

    public final CommonErrorResponse component5() {
        return this.error;
    }

    public final AiAccessConfigApiResponse copy(String str, boolean z, String str2, String str3, CommonErrorResponse commonErrorResponse) {
        return new AiAccessConfigApiResponse(str, z, str2, str3, commonErrorResponse);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiAccessConfigApiResponse)) {
            return false;
        }
        AiAccessConfigApiResponse aiAccessConfigApiResponse = (AiAccessConfigApiResponse) obj;
        return p31.a(this.data, aiAccessConfigApiResponse.data) && this.success == aiAccessConfigApiResponse.success && p31.a(this.langConfig, aiAccessConfigApiResponse.langConfig) && p31.a(this.key, aiAccessConfigApiResponse.key) && p31.a(this.error, aiAccessConfigApiResponse.error);
    }

    public final String getData() {
        return this.data;
    }

    public final CommonErrorResponse getError() {
        return this.error;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLangConfig() {
        return this.langConfig;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        String str = this.data;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.success)) * 31;
        String str2 = this.langConfig;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        CommonErrorResponse commonErrorResponse = this.error;
        return iHashCode3 + (commonErrorResponse != null ? commonErrorResponse.hashCode() : 0);
    }

    public String toString() {
        return "AiAccessConfigApiResponse(data=" + this.data + ", success=" + this.success + ", langConfig=" + this.langConfig + ", key=" + this.key + ", error=" + this.error + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeString(this.data);
        parcel.writeInt(this.success ? 1 : 0);
        parcel.writeString(this.langConfig);
        parcel.writeString(this.key);
        CommonErrorResponse commonErrorResponse = this.error;
        if (commonErrorResponse == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            commonErrorResponse.writeToParcel(parcel, i);
        }
    }

    public AiAccessConfigApiResponse(String str, boolean z, String str2, String str3, CommonErrorResponse commonErrorResponse) {
        this.data = str;
        this.success = z;
        this.langConfig = str2;
        this.key = str3;
        this.error = commonErrorResponse;
    }

    public /* synthetic */ AiAccessConfigApiResponse(String str, boolean z, String str2, String str3, CommonErrorResponse commonErrorResponse, int i, y70 y70Var) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : commonErrorResponse);
    }
}
