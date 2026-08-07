package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.n(parcel, iY, ConnectionResult.CREATOR);
            } else if (iU != 3) {
                SafeParcelReader.F(parcel, iY);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.n(parcel, iY, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zaj(iA, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zaj[i];
    }
}
