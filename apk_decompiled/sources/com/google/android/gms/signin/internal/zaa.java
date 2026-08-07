package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.jh2;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable implements jh2 {
    public static final Parcelable.Creator<zaa> CREATOR = new a();
    private final int a;
    private int b;
    private Intent c;

    zaa(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    @Override // defpackage.jh2
    public final Status n() {
        return this.b == 0 ? Status.g : Status.k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.h(parcel, 2, this.b);
        nj2.n(parcel, 3, this.c, i, false);
        nj2.b(parcel, iA);
    }
}
