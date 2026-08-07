package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        HashSet hashSet = new HashSet();
        zzt zztVar = null;
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        int iA = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
                hashSet.add(1);
            } else if (iU == 2) {
                zztVar = (zzt) SafeParcelReader.n(parcel, iY, zzt.CREATOR);
                hashSet.add(2);
            } else if (iU == 3) {
                strO = SafeParcelReader.o(parcel, iY);
                hashSet.add(3);
            } else if (iU == 4) {
                strO2 = SafeParcelReader.o(parcel, iY);
                hashSet.add(4);
            } else if (iU != 5) {
                SafeParcelReader.F(parcel, iY);
            } else {
                strO3 = SafeParcelReader.o(parcel, iY);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == iG) {
            return new zzr(hashSet, iA, zztVar, strO, strO2, strO3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(iG);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
