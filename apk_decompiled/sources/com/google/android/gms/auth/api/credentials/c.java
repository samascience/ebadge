package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        int iA2 = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU == 2) {
                zV2 = SafeParcelReader.v(parcel, iY);
            } else if (iU == 3) {
                zV3 = SafeParcelReader.v(parcel, iY);
            } else if (iU == 4) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU != 1000) {
                SafeParcelReader.F(parcel, iY);
            } else {
                iA = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new CredentialPickerConfig(iA, zV, zV2, zV3, iA2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
