package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();
    private final int a;
    final String b;
    final FastJsonResponse.Field c;

    zam(int i, String str, FastJsonResponse.Field field) {
        this.a = i;
        this.b = str;
        this.c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.o(parcel, 2, this.b, false);
        nj2.n(parcel, 3, this.c, i, false);
        nj2.b(parcel, iA);
    }

    zam(String str, FastJsonResponse.Field field) {
        this.a = 1;
        this.b = str;
        this.c = field;
    }
}
