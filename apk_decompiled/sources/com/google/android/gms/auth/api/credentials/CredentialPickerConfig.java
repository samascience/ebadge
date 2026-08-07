package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new c();
    private final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final int e;

    public static class a {
        private boolean a = false;
        private boolean b = true;
        private int c = 1;

        public CredentialPickerConfig a() {
            return new CredentialPickerConfig(this);
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        this.a = i;
        this.b = z;
        this.c = z2;
        if (i < 2) {
            this.d = z3;
            this.e = z3 ? 3 : 1;
        } else {
            this.d = i2 == 3;
            this.e = i2;
        }
    }

    public final boolean F0() {
        return this.e == 3;
    }

    public final boolean G0() {
        return this.b;
    }

    public final boolean H0() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.c(parcel, 1, G0());
        nj2.c(parcel, 2, H0());
        nj2.c(parcel, 3, F0());
        nj2.h(parcel, 4, this.e);
        nj2.h(parcel, 1000, this.a);
        nj2.b(parcel, iA);
    }

    private CredentialPickerConfig(a aVar) {
        this(2, aVar.a, aVar.b, false, aVar.c);
    }
}
