package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        String[] strArrP = null;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        String strO = null;
        String strO2 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU != 1000) {
                switch (iU) {
                    case 1:
                        zV = SafeParcelReader.v(parcel, iY);
                        break;
                    case 2:
                        strArrP = SafeParcelReader.p(parcel, iY);
                        break;
                    case 3:
                        credentialPickerConfig = (CredentialPickerConfig) SafeParcelReader.n(parcel, iY, CredentialPickerConfig.CREATOR);
                        break;
                    case 4:
                        credentialPickerConfig2 = (CredentialPickerConfig) SafeParcelReader.n(parcel, iY, CredentialPickerConfig.CREATOR);
                        break;
                    case 5:
                        zV2 = SafeParcelReader.v(parcel, iY);
                        break;
                    case 6:
                        strO = SafeParcelReader.o(parcel, iY);
                        break;
                    case 7:
                        strO2 = SafeParcelReader.o(parcel, iY);
                        break;
                    case 8:
                        zV3 = SafeParcelReader.v(parcel, iY);
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
        return new CredentialRequest(iA, zV, strArrP, credentialPickerConfig, credentialPickerConfig2, zV2, strO, strO2, zV3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
