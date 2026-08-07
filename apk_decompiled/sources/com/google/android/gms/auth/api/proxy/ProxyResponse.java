package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new b();
    private final int a;
    public final int b;
    public final PendingIntent c;
    public final int d;
    private final Bundle e;
    public final byte[] f;

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.e = bundle;
        this.f = bArr;
        this.c = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.b);
        nj2.n(parcel, 2, this.c, i, false);
        nj2.h(parcel, 3, this.d);
        nj2.d(parcel, 4, this.e, false);
        nj2.e(parcel, 5, this.f, false);
        nj2.h(parcel, 1000, this.a);
        nj2.b(parcel, iA);
    }
}
