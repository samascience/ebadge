package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;
import defpackage.py0;
import defpackage.rt1;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new q();
    private final String a;
    private final boolean b;
    private final boolean c;
    private final Context d;
    private final boolean e;

    zzo(String str, boolean z, boolean z2, IBinder iBinder, boolean z3) {
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = (Context) rt1.c(py0.a.b(iBinder));
        this.e = z3;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.IBinder, py0] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.o(parcel, 1, this.a, false);
        nj2.c(parcel, 2, this.b);
        nj2.c(parcel, 3, this.c);
        nj2.g(parcel, 4, rt1.d(this.d), false);
        nj2.c(parcel, 5, this.e);
        nj2.b(parcel, iA);
    }
}
