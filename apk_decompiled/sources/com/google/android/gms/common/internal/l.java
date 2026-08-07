package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        int iA2 = 0;
        Scope[] scopeArr = null;
        int iA3 = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                iA3 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 3) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.F(parcel, iY);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.r(parcel, iY, Scope.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new SignInButtonConfig(iA, iA3, iA2, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
