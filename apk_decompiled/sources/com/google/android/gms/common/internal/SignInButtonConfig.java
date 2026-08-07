package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new l();
    private final int a;
    private final int b;
    private final int c;
    private final Scope[] d;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = scopeArr;
    }

    public int F0() {
        return this.b;
    }

    public int G0() {
        return this.c;
    }

    public Scope[] H0() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.h(parcel, 2, F0());
        nj2.h(parcel, 3, G0());
        nj2.r(parcel, 4, H0(), i, false);
        nj2.b(parcel, iA);
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }
}
