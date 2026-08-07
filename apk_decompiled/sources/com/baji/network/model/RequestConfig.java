package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class RequestConfig implements Parcelable {
    public static final Parcelable.Creator<RequestConfig> CREATOR = new Creator();
    private final long cacheMaxAge;
    private final boolean enableCache;
    private final Map<String, String> headers;
    private final int retryCount;
    private final long retryDelay;
    private final long timeout;

    public static final class Creator implements Parcelable.Creator<RequestConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RequestConfig createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            long j = parcel.readLong();
            int i = parcel.readInt();
            long j2 = parcel.readLong();
            boolean z = parcel.readInt() != 0;
            long j3 = parcel.readLong();
            int i2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new RequestConfig(j, i, j2, z, j3, linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RequestConfig[] newArray(int i) {
            return new RequestConfig[i];
        }
    }

    public RequestConfig() {
        this(0L, 0, 0L, false, 0L, null, 63, null);
    }

    public final long component1() {
        return this.timeout;
    }

    public final int component2() {
        return this.retryCount;
    }

    public final long component3() {
        return this.retryDelay;
    }

    public final boolean component4() {
        return this.enableCache;
    }

    public final long component5() {
        return this.cacheMaxAge;
    }

    public final Map<String, String> component6() {
        return this.headers;
    }

    public final RequestConfig copy(long j, int i, long j2, boolean z, long j3, Map<String, String> map) {
        p31.f(map, "headers");
        return new RequestConfig(j, i, j2, z, j3, map);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestConfig)) {
            return false;
        }
        RequestConfig requestConfig = (RequestConfig) obj;
        return this.timeout == requestConfig.timeout && this.retryCount == requestConfig.retryCount && this.retryDelay == requestConfig.retryDelay && this.enableCache == requestConfig.enableCache && this.cacheMaxAge == requestConfig.cacheMaxAge && p31.a(this.headers, requestConfig.headers);
    }

    public final long getCacheMaxAge() {
        return this.cacheMaxAge;
    }

    public final boolean getEnableCache() {
        return this.enableCache;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final long getRetryDelay() {
        return this.retryDelay;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.timeout) * 31) + Integer.hashCode(this.retryCount)) * 31) + Long.hashCode(this.retryDelay)) * 31) + Boolean.hashCode(this.enableCache)) * 31) + Long.hashCode(this.cacheMaxAge)) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "RequestConfig(timeout=" + this.timeout + ", retryCount=" + this.retryCount + ", retryDelay=" + this.retryDelay + ", enableCache=" + this.enableCache + ", cacheMaxAge=" + this.cacheMaxAge + ", headers=" + this.headers + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeLong(this.timeout);
        parcel.writeInt(this.retryCount);
        parcel.writeLong(this.retryDelay);
        parcel.writeInt(this.enableCache ? 1 : 0);
        parcel.writeLong(this.cacheMaxAge);
        Map<String, String> map = this.headers;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public RequestConfig(long j, int i, long j2, boolean z, long j3, Map<String, String> map) {
        p31.f(map, "headers");
        this.timeout = j;
        this.retryCount = i;
        this.retryDelay = j2;
        this.enableCache = z;
        this.cacheMaxAge = j3;
        this.headers = map;
    }

    public /* synthetic */ RequestConfig(long j, int i, long j2, boolean z, long j3, Map map, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? 30000L : j, (i2 & 2) != 0 ? 3 : i, (i2 & 4) != 0 ? 1000L : j2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? 604800000L : j3, (i2 & 32) != 0 ? u.f() : map);
    }
}
