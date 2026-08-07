package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArrP = null;
        String strO = null;
        String strO2 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU != 1000) {
                switch (iU) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) SafeParcelReader.n(parcel, iY, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        zV = SafeParcelReader.v(parcel, iY);
                        break;
                    case 3:
                        zV2 = SafeParcelReader.v(parcel, iY);
                        break;
                    case 4:
                        strArrP = SafeParcelReader.p(parcel, iY);
                        break;
                    case 5:
                        zV3 = SafeParcelReader.v(parcel, iY);
                        break;
                    case 6:
                        strO = SafeParcelReader.o(parcel, iY);
                        break;
                    case 7:
                        strO2 = SafeParcelReader.o(parcel, iY);
                        break;
                    default:
                        SafeParcelReader.F(parcel, iY);
                        break;
                }
            } else {
                iA = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new HintRequest(iA, credentialPickerConfig, zV, zV2, strArrP, zV3, strO, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new HintRequest[i];
    }
}
