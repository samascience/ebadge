package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new d();
    private final int a;
    private final boolean b;
    private final String[] c;
    private final CredentialPickerConfig d;
    private final CredentialPickerConfig e;
    private final boolean f;
    private final String g;
    private final String h;
    private final boolean i;

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.a = i;
        this.b = z;
        this.c = (String[]) a52.g(strArr);
        this.d = credentialPickerConfig == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig;
        this.e = credentialPickerConfig2 == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig2;
        if (i < 3) {
            this.f = true;
            this.g = null;
            this.h = null;
        } else {
            this.f = z2;
            this.g = str;
            this.h = str2;
        }
        this.i = z3;
    }

    public final String[] F0() {
        return this.c;
    }

    public final CredentialPickerConfig G0() {
        return this.e;
    }

    public final CredentialPickerConfig H0() {
        return this.d;
    }

    public final String I0() {
        return this.h;
    }

    public final String J0() {
        return this.g;
    }

    public final boolean K0() {
        return this.f;
    }

    public final boolean L0() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.c(parcel, 1, L0());
        nj2.p(parcel, 2, F0(), false);
        nj2.n(parcel, 3, H0(), i, false);
        nj2.n(parcel, 4, G0(), i, false);
        nj2.c(parcel, 5, K0());
        nj2.o(parcel, 6, J0(), false);
        nj2.o(parcel, 7, I0(), false);
        nj2.h(parcel, 1000, this.a);
        nj2.c(parcel, 8, this.i);
        nj2.b(parcel, iA);
    }
}
