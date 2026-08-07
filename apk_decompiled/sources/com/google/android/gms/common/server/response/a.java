package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        int iA2 = 0;
        boolean zV = false;
        int iA3 = 0;
        boolean zV2 = false;
        int iA4 = 0;
        String strO = null;
        String strO2 = null;
        zaa zaaVar = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 3:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 4:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 5:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 6:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 7:
                    iA4 = SafeParcelReader.A(parcel, iY);
                    break;
                case 8:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.n(parcel, iY, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new FastJsonResponse.Field(iA, iA2, zV, iA3, zV2, strO, iA4, strO2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}
