package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        Intent intent = null;
        int iA2 = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU != 3) {
                SafeParcelReader.F(parcel, iY);
            } else {
                intent = (Intent) SafeParcelReader.n(parcel, iY, Intent.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zaa(iA, iA2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zaa[i];
    }
}
