package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU != 2) {
                SafeParcelReader.F(parcel, iY);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) SafeParcelReader.n(parcel, iY, ResolveAccountRequest.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zah(iA, resolveAccountRequest);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zah[i];
    }
}
