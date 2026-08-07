package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.jt3;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new jt3();
    private final int a;
    private final boolean b;
    private final boolean c;
    private final int d;
    private final int e;

    public RootTelemetryConfiguration(int i, boolean z, boolean z2, int i2, int i3) {
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = i2;
        this.e = i3;
    }

    public int F0() {
        return this.d;
    }

    public int G0() {
        return this.e;
    }

    public boolean H0() {
        return this.b;
    }

    public boolean I0() {
        return this.c;
    }

    public int J0() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, J0());
        nj2.c(parcel, 2, H0());
        nj2.c(parcel, 3, I0());
        nj2.h(parcel, 4, F0());
        nj2.h(parcel, 5, G0());
        nj2.b(parcel, iA);
    }
}
