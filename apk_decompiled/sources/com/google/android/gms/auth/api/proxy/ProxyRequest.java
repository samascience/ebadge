package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new a();
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static final int o = 7;
    private final int a;
    public final String b;
    public final int c;
    public final long d;
    public final byte[] e;
    private Bundle f;

    ProxyRequest(int i2, String str, int i3, long j2, byte[] bArr, Bundle bundle) {
        this.a = i2;
        this.b = str;
        this.c = i3;
        this.d = j2;
        this.e = bArr;
        this.f = bundle;
    }

    public String toString() {
        String str = this.b;
        int i2 = this.c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i2);
        sb.append(" ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = nj2.a(parcel);
        nj2.o(parcel, 1, this.b, false);
        nj2.h(parcel, 2, this.c);
        nj2.k(parcel, 3, this.d);
        nj2.e(parcel, 4, this.e, false);
        nj2.d(parcel, 5, this.f, false);
        nj2.h(parcel, 1000, this.a);
        nj2.b(parcel, iA);
    }
}
