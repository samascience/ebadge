package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        String strO = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU != 3) {
                SafeParcelReader.F(parcel, iY);
            } else {
                pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, iY, PendingIntent.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zzah(iA, strO, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzah[i];
    }
}
