package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.fw0;
import defpackage.nj2;
import defpackage.pv3;

/* JADX INFO: loaded from: classes.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new pv3();
    private final String a;
    private GoogleSignInOptions b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.a = a52.e(str);
        this.b = googleSignInOptions;
    }

    public final GoogleSignInOptions F0() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.a.equals(signInConfiguration.a)) {
            GoogleSignInOptions googleSignInOptions = this.b;
            if (googleSignInOptions == null) {
                if (signInConfiguration.b == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new fw0().a(this.a).a(this.b).b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.o(parcel, 2, this.a, false);
        nj2.n(parcel, 5, this.b, i, false);
        nj2.b(parcel, iA);
    }
}
