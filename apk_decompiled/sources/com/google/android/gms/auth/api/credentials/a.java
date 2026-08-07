package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        String strO = null;
        String strO2 = null;
        Uri uri = null;
        ArrayList arrayListS = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        String strO6 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 2:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 3:
                    uri = (Uri) SafeParcelReader.n(parcel, iY, Uri.CREATOR);
                    break;
                case 4:
                    arrayListS = SafeParcelReader.s(parcel, iY, IdToken.CREATOR);
                    break;
                case 5:
                    strO3 = SafeParcelReader.o(parcel, iY);
                    break;
                case 6:
                    strO4 = SafeParcelReader.o(parcel, iY);
                    break;
                case 7:
                case 8:
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
                case 9:
                    strO5 = SafeParcelReader.o(parcel, iY);
                    break;
                case 10:
                    strO6 = SafeParcelReader.o(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new Credential(strO, strO2, uri, arrayListS, strO3, strO4, strO5, strO6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Credential[i];
    }
}
