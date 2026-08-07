package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        long jC = 0;
        String strO = null;
        String strO2 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    jC = SafeParcelReader.C(parcel, iY);
                    break;
                case 3:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 5:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 6:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new AccountChangeEvent(iA, jC, strO, iA2, iA3, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEvent[i];
    }
}
