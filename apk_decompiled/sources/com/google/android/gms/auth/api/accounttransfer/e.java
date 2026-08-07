package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        long jC = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU == 3) {
                jC = SafeParcelReader.C(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.F(parcel, iY);
            } else {
                zV2 = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new DeviceMetaData(iA, zV, jC, zV2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DeviceMetaData[i];
    }
}
