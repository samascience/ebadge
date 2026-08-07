package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new e();
    private final int a;
    private final CredentialPickerConfig b;
    private final boolean c;
    private final boolean d;
    private final String[] e;
    private final boolean f;
    private final String g;
    private final String h;

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.a = i;
        this.b = (CredentialPickerConfig) a52.g(credentialPickerConfig);
        this.c = z;
        this.d = z2;
        this.e = (String[]) a52.g(strArr);
        if (i < 2) {
            this.f = true;
            this.g = null;
            this.h = null;
        } else {
            this.f = z3;
            this.g = str;
            this.h = str2;
        }
    }

    public final String[] F0() {
        return this.e;
    }

    public final CredentialPickerConfig G0() {
        return this.b;
    }

    public final String H0() {
        return this.h;
    }

    public final String I0() {
        return this.g;
    }

    public final boolean J0() {
        return this.c;
    }

    public final boolean K0() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.n(parcel, 1, G0(), i, false);
        nj2.c(parcel, 2, J0());
        nj2.c(parcel, 3, this.d);
        nj2.p(parcel, 4, F0(), false);
        nj2.c(parcel, 5, K0());
        nj2.o(parcel, 6, I0(), false);
        nj2.o(parcel, 7, H0(), false);
        nj2.h(parcel, 1000, this.a);
        nj2.b(parcel, iA);
    }
}
