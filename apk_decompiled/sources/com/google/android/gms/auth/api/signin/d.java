package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        Uri uri = null;
        String strO5 = null;
        String strO6 = null;
        ArrayList arrayListS = null;
        String strO7 = null;
        String strO8 = null;
        long jC = 0;
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
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    strO3 = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    strO4 = SafeParcelReader.o(parcel, iY);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.n(parcel, iY, Uri.CREATOR);
                    break;
                case 7:
                    strO5 = SafeParcelReader.o(parcel, iY);
                    break;
                case 8:
                    jC = SafeParcelReader.C(parcel, iY);
                    break;
                case 9:
                    strO6 = SafeParcelReader.o(parcel, iY);
                    break;
                case 10:
                    arrayListS = SafeParcelReader.s(parcel, iY, Scope.CREATOR);
                    break;
                case 11:
                    strO7 = SafeParcelReader.o(parcel, iY);
                    break;
                case 12:
                    strO8 = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new GoogleSignInAccount(iA, strO, strO2, strO3, strO4, uri, strO5, jC, strO6, arrayListS, strO7, strO8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
