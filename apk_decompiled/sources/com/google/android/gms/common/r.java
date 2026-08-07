package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        boolean zV = false;
        int iA = 0;
        String strO = null;
        int iA2 = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU == 2) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 3) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.F(parcel, iY);
            } else {
                iA = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zzq(zV, strO, iA2, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzq[i];
    }
}
