package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;
import defpackage.st1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new a();
    private final String a;
    private final String b;
    private final Uri c;
    private final List d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;

    Credential(String str, String str2, Uri uri, List list, String str3, String str4, String str5, String str6) {
        String strTrim = ((String) a52.h(str, "credential identifier cannot be null")).trim();
        a52.f(strTrim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri uri2 = Uri.parse(str4);
                if (uri2.isAbsolute() && uri2.isHierarchical() && !TextUtils.isEmpty(uri2.getScheme()) && !TextUtils.isEmpty(uri2.getAuthority()) && ("http".equalsIgnoreCase(uri2.getScheme()) || "https".equalsIgnoreCase(uri2.getScheme()))) {
                    z = true;
                }
            }
            if (!z) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.b = str2;
        this.c = uri;
        this.d = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.a = strTrim;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
    }

    public String F0() {
        return this.f;
    }

    public String G0() {
        return this.h;
    }

    public String H0() {
        return this.g;
    }

    public String I0() {
        return this.a;
    }

    public List J0() {
        return this.d;
    }

    public String K0() {
        return this.b;
    }

    public String L0() {
        return this.e;
    }

    public Uri M0() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.a, credential.a) && TextUtils.equals(this.b, credential.b) && st1.a(this.c, credential.c) && TextUtils.equals(this.e, credential.e) && TextUtils.equals(this.f, credential.f);
    }

    public int hashCode() {
        return st1.b(this.a, this.b, this.c, this.e, this.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.o(parcel, 1, I0(), false);
        nj2.o(parcel, 2, K0(), false);
        nj2.n(parcel, 3, M0(), i, false);
        nj2.s(parcel, 4, J0(), false);
        nj2.o(parcel, 5, L0(), false);
        nj2.o(parcel, 6, F0(), false);
        nj2.o(parcel, 9, H0(), false);
        nj2.o(parcel, 10, G0(), false);
        nj2.b(parcel, iA);
    }
}
