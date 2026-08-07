package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.dt3;
import defpackage.vt3;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends dt3 implements f {
    c0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.f
    public final Account C() {
        Parcel parcelA = a(2, b());
        Account account = (Account) vt3.a(parcelA, Account.CREATOR);
        parcelA.recycle();
        return account;
    }
}
