package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        int iA2 = 0;
        String strO = null;
        byte[] bArrG = null;
        Bundle bundleF = null;
        long jC = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 2) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 3) {
                jC = SafeParcelReader.C(parcel, iY);
            } else if (iU == 4) {
                bArrG = SafeParcelReader.g(parcel, iY);
            } else if (iU == 5) {
                bundleF = SafeParcelReader.f(parcel, iY);
            } else if (iU != 1000) {
                SafeParcelReader.F(parcel, iY);
            } else {
                iA = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new ProxyRequest(iA, strO, iA2, jC, bArrG, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
