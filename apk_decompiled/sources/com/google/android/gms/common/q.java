package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        String strO = null;
        IBinder iBinderZ = null;
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 2) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU == 3) {
                zV2 = SafeParcelReader.v(parcel, iY);
            } else if (iU == 4) {
                iBinderZ = SafeParcelReader.z(parcel, iY);
            } else if (iU != 5) {
                SafeParcelReader.F(parcel, iY);
            } else {
                zV3 = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zzo(strO, zV, zV2, iBinderZ, zV3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
