package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        String strO = null;
        boolean zV = false;
        boolean zV2 = false;
        IBinder iBinderZ = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 2) {
                iBinderZ = SafeParcelReader.z(parcel, iY);
            } else if (iU == 3) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.F(parcel, iY);
            } else {
                zV2 = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zzs(strO, iBinderZ, zV, zV2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzs[i];
    }
}
