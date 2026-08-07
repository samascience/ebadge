package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int iA2 = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.n(parcel, iY, ParcelFileDescriptor.CREATOR);
            } else if (iU != 3) {
                SafeParcelReader.F(parcel, iY);
            } else {
                iA2 = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new BitmapTeleporter(iA, parcelFileDescriptor, iA2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
