package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        ArrayList arrayListQ = null;
        ArrayList arrayListQ2 = null;
        ArrayList arrayListQ3 = null;
        ArrayList arrayListQ4 = null;
        ArrayList arrayListQ5 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    arrayListQ = SafeParcelReader.q(parcel, iY);
                    break;
                case 3:
                    arrayListQ2 = SafeParcelReader.q(parcel, iY);
                    break;
                case 4:
                    arrayListQ3 = SafeParcelReader.q(parcel, iY);
                    break;
                case 5:
                    arrayListQ4 = SafeParcelReader.q(parcel, iY);
                    break;
                case 6:
                    arrayListQ5 = SafeParcelReader.q(parcel, iY);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zzo(iA, arrayListQ, arrayListQ2, arrayListQ3, arrayListQ4, arrayListQ5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
