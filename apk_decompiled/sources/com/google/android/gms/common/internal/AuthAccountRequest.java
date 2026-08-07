package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new g();
    private final int a;
    private final IBinder b;
    private final Scope[] c;
    private Integer d;
    private Integer e;
    private Account f;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2, Account account) {
        this.a = i;
        this.b = iBinder;
        this.c = scopeArr;
        this.d = num;
        this.e = num2;
        this.f = account;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.g(parcel, 2, this.b, false);
        nj2.r(parcel, 3, this.c, i, false);
        nj2.j(parcel, 4, this.d, false);
        nj2.j(parcel, 5, this.e, false);
        nj2.n(parcel, 6, this.f, i, false);
        nj2.b(parcel, iA);
    }
}
