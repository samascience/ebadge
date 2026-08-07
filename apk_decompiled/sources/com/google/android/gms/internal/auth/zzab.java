package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new a();
    private final int a = 1;
    private final String b;
    private final int c;

    zzab(int i, String str, int i2) {
        this.b = (String) a52.g(str);
        this.c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.o(parcel, 2, this.b, false);
        nj2.h(parcel, 3, this.c);
        nj2.b(parcel, iA);
    }
}
