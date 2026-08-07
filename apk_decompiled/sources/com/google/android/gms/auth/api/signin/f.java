package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        ArrayList arrayListS = null;
        Account account = null;
        String strO = null;
        String strO2 = null;
        ArrayList arrayListS2 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    arrayListS = SafeParcelReader.s(parcel, iY, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.n(parcel, iY, Account.CREATOR);
                    break;
                case 4:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 5:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 6:
                    zV3 = SafeParcelReader.v(parcel, iY);
                    break;
                case 7:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 8:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 9:
                    arrayListS2 = SafeParcelReader.s(parcel, iY, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new GoogleSignInOptions(iA, arrayListS, account, zV, zV2, zV3, strO, strO2, arrayListS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
