package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new r();
    private final boolean a;
    private final String b;
    private final int c;
    private final int d;

    zzq(boolean z, String str, int i, int i2) {
        this.a = z;
        this.b = str;
        this.c = t.a(i) - 1;
        this.d = g.a(i2) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.c(parcel, 1, this.a);
        nj2.o(parcel, 2, this.b, false);
        nj2.h(parcel, 3, this.c);
        nj2.h(parcel, 4, this.d);
        nj2.b(parcel, iA);
    }
}
