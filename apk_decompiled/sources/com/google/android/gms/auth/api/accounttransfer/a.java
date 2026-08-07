package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        HashSet hashSet = new HashSet();
        int iA = 0;
        ArrayList arrayListS = null;
        zzo zzoVar = null;
        int iA2 = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA2 = SafeParcelReader.A(parcel, iY);
                hashSet.add(1);
            } else if (iU == 2) {
                arrayListS = SafeParcelReader.s(parcel, iY, zzr.CREATOR);
                hashSet.add(2);
            } else if (iU == 3) {
                iA = SafeParcelReader.A(parcel, iY);
                hashSet.add(3);
            } else if (iU != 4) {
                SafeParcelReader.F(parcel, iY);
            } else {
                zzoVar = (zzo) SafeParcelReader.n(parcel, iY, zzo.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == iG) {
            return new zzl(hashSet, iA2, arrayListS, iA, zzoVar);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(iG);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }
}
