package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        int iA2 = 0;
        String[] strArrP = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleF = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strArrP = SafeParcelReader.p(parcel, iY);
            } else if (iU == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.r(parcel, iY, CursorWindow.CREATOR);
            } else if (iU == 3) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 4) {
                bundleF = SafeParcelReader.f(parcel, iY);
            } else if (iU != 1000) {
                SafeParcelReader.F(parcel, iY);
            } else {
                iA = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        DataHolder dataHolder = new DataHolder(iA, strArrP, cursorWindowArr, iA2, bundleF);
        dataHolder.H0();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
