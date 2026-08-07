package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class SimultaneousTranslationResponse implements Parcelable {
    public static final Parcelable.Creator<SimultaneousTranslationResponse> CREATOR = new Creator();
    private final int expires_at;
    private final String langConfig;
    private final String token;

    public static final class Creator implements Parcelable.Creator<SimultaneousTranslationResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SimultaneousTranslationResponse createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new SimultaneousTranslationResponse(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SimultaneousTranslationResponse[] newArray(int i) {
            return new SimultaneousTranslationResponse[i];
        }
    }

    public SimultaneousTranslationResponse(String str, String str2, int i) {
        p31.f(str, "token");
        p31.f(str2, "langConfig");
        this.token = str;
        this.langConfig = str2;
        this.expires_at = i;
    }

    public static /* synthetic */ SimultaneousTranslationResponse copy$default(SimultaneousTranslationResponse simultaneousTranslationResponse, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = simultaneousTranslationResponse.token;
        }
        if ((i2 & 2) != 0) {
            str2 = simultaneousTranslationResponse.langConfig;
        }
        if ((i2 & 4) != 0) {
            i = simultaneousTranslationResponse.expires_at;
        }
        return simultaneousTranslationResponse.copy(str, str2, i);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.langConfig;
    }

    public final int component3() {
        return this.expires_at;
    }

    public final SimultaneousTranslationResponse copy(String str, String str2, int i) {
        p31.f(str, "token");
        p31.f(str2, "langConfig");
        return new SimultaneousTranslationResponse(str, str2, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimultaneousTranslationResponse)) {
            return false;
        }
        SimultaneousTranslationResponse simultaneousTranslationResponse = (SimultaneousTranslationResponse) obj;
        return p31.a(this.token, simultaneousTranslationResponse.token) && p31.a(this.langConfig, simultaneousTranslationResponse.langConfig) && this.expires_at == simultaneousTranslationResponse.expires_at;
    }

    public final int getExpires_at() {
        return this.expires_at;
    }

    public final String getLangConfig() {
        return this.langConfig;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + this.langConfig.hashCode()) * 31) + Integer.hashCode(this.expires_at);
    }

    public String toString() {
        return "SimultaneousTranslationResponse(token=" + this.token + ", langConfig=" + this.langConfig + ", expires_at=" + this.expires_at + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeString(this.token);
        parcel.writeString(this.langConfig);
        parcel.writeInt(this.expires_at);
    }

    public /* synthetic */ SimultaneousTranslationResponse(String str, String str2, int i, int i2, y70 y70Var) {
        this(str, str2, (i2 & 4) != 0 ? 0 : i);
    }
}
