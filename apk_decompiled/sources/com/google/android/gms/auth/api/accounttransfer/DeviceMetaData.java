package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new e();
    private final int a;
    private boolean b;
    private long c;
    private final boolean d;

    DeviceMetaData(int i, boolean z, long j, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = j;
        this.d = z2;
    }

    public long F0() {
        return this.c;
    }

    public boolean G0() {
        return this.d;
    }

    public boolean H0() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.c(parcel, 2, H0());
        nj2.k(parcel, 3, F0());
        nj2.c(parcel, 4, G0());
        nj2.b(parcel, iA);
    }
}
