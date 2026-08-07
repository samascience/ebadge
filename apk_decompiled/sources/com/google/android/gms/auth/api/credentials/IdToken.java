package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.lu3;
import defpackage.nj2;
import defpackage.st1;

/* JADX INFO: loaded from: classes.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new lu3();
    private final String a;
    private final String b;

    public IdToken(String str, String str2) {
        a52.b(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        a52.b(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.a = str;
        this.b = str2;
    }

    public final String F0() {
        return this.a;
    }

    public final String G0() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return st1.a(this.a, idToken.a) && st1.a(this.b, idToken.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.o(parcel, 1, F0(), false);
        nj2.o(parcel, 2, G0(), false);
        nj2.b(parcel, iA);
    }
}
