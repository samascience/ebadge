package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        String strO = Constants.STR_EMPTY;
        GoogleSignInAccount googleSignInAccount = null;
        String strO2 = Constants.STR_EMPTY;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 4) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 7) {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.n(parcel, iY, GoogleSignInAccount.CREATOR);
            } else if (iU != 8) {
                SafeParcelReader.F(parcel, iY);
            } else {
                strO2 = SafeParcelReader.o(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new SignInAccount(strO, googleSignInAccount, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
