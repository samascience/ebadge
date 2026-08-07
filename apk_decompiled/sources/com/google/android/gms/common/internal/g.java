package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        IBinder iBinderZ = null;
        Scope[] scopeArr = null;
        Integer numB = null;
        Integer numB2 = null;
        Account account = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    iBinderZ = SafeParcelReader.z(parcel, iY);
                    break;
                case 3:
                    scopeArr = (Scope[]) SafeParcelReader.r(parcel, iY, Scope.CREATOR);
                    break;
                case 4:
                    numB = SafeParcelReader.B(parcel, iY);
                    break;
                case 5:
                    numB2 = SafeParcelReader.B(parcel, iY);
                    break;
                case 6:
                    account = (Account) SafeParcelReader.n(parcel, iY, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new AuthAccountRequest(iA, iBinderZ, scopeArr, numB, numB2, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
