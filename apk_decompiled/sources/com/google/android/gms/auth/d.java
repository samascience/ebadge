package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        String strO = null;
        Long lD = null;
        ArrayList arrayListQ = null;
        String strO2 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 3:
                    lD = SafeParcelReader.D(parcel, iY);
                    break;
                case 4:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 5:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 6:
                    arrayListQ = SafeParcelReader.q(parcel, iY);
                    break;
                case 7:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new TokenData(iA, strO, lD, zV, zV2, arrayListQ, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new TokenData[i];
    }
}
