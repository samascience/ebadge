package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;
import defpackage.st1;
import defpackage.tt3;

/* JADX INFO: loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new tt3();
    private final String a;
    private final int b;
    private final long c;

    public Feature(String str, int i, long j) {
        this.a = str;
        this.b = i;
        this.c = j;
    }

    public String F0() {
        return this.a;
    }

    public long G0() {
        long j = this.c;
        return j == -1 ? this.b : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((F0() != null && F0().equals(feature.F0())) || (F0() == null && feature.F0() == null)) && G0() == feature.G0()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return st1.b(F0(), Long.valueOf(G0()));
    }

    public final String toString() {
        st1.a aVarC = st1.c(this);
        aVarC.a("name", F0());
        aVarC.a("version", Long.valueOf(G0()));
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.o(parcel, 1, F0(), false);
        nj2.h(parcel, 2, this.b);
        nj2.k(parcel, 3, G0());
        nj2.b(parcel, iA);
    }
}
