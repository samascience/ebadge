package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new c();
    private final int a;
    private final List b;

    AccountChangeEventsResponse(int i, List list) {
        this.a = i;
        this.b = (List) a52.g(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.s(parcel, 2, this.b, false);
        nj2.b(parcel, iA);
    }
}
