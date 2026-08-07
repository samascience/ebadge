package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        PendingIntent pendingIntent = null;
        Bundle bundleF = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, iY, PendingIntent.CREATOR);
            } else if (iU == 3) {
                iA3 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 4) {
                bundleF = SafeParcelReader.f(parcel, iY);
            } else if (iU == 5) {
                bArrG = SafeParcelReader.g(parcel, iY);
            } else if (iU != 1000) {
                SafeParcelReader.F(parcel, iY);
            } else {
                iA = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new ProxyResponse(iA, iA2, pendingIntent, iA3, bundleF, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
