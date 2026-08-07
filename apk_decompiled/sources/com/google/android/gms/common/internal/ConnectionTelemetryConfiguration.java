package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.mu3;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new mu3();
    private final RootTelemetryConfiguration a;
    private final boolean b;
    private final boolean c;
    private final int[] d;
    private final int e;
    private final int[] f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.a = rootTelemetryConfiguration;
        this.b = z;
        this.c = z2;
        this.d = iArr;
        this.e = i;
        this.f = iArr2;
    }

    public int F0() {
        return this.e;
    }

    public int[] G0() {
        return this.d;
    }

    public int[] H0() {
        return this.f;
    }

    public boolean I0() {
        return this.b;
    }

    public boolean J0() {
        return this.c;
    }

    public final RootTelemetryConfiguration K0() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.n(parcel, 1, this.a, i, false);
        nj2.c(parcel, 2, I0());
        nj2.c(parcel, 3, J0());
        nj2.i(parcel, 4, G0(), false);
        nj2.h(parcel, 5, F0());
        nj2.i(parcel, 6, H0(), false);
        nj2.b(parcel, iA);
    }
}
