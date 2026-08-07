package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;
import defpackage.st1;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new d();
    private final int a;
    private final String b;
    private final Long c;
    private final boolean d;
    private final boolean e;
    private final List f;
    private final String g;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List list, String str2) {
        this.a = i;
        this.b = a52.e(str);
        this.c = l;
        this.d = z;
        this.e = z2;
        this.f = list;
        this.g = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.b, tokenData.b) && st1.a(this.c, tokenData.c) && this.d == tokenData.d && this.e == tokenData.e && st1.a(this.f, tokenData.f) && st1.a(this.g, tokenData.g);
    }

    public int hashCode() {
        return st1.b(this.b, this.c, Boolean.valueOf(this.d), Boolean.valueOf(this.e), this.f, this.g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.o(parcel, 2, this.b, false);
        nj2.l(parcel, 3, this.c, false);
        nj2.c(parcel, 4, this.d);
        nj2.c(parcel, 5, this.e);
        nj2.q(parcel, 6, this.f, false);
        nj2.o(parcel, 7, this.g, false);
        nj2.b(parcel, iA);
    }
}
