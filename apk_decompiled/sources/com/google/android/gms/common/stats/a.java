package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        int iA4 = 0;
        boolean zV = false;
        long jC = 0;
        long jC2 = 0;
        long jC3 = 0;
        String strO = null;
        ArrayList arrayListQ = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        float fX = 0.0f;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    jC = SafeParcelReader.C(parcel, iY);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
                case 4:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 6:
                    arrayListQ = SafeParcelReader.q(parcel, iY);
                    break;
                case 8:
                    jC2 = SafeParcelReader.C(parcel, iY);
                    break;
                case 10:
                    strO3 = SafeParcelReader.o(parcel, iY);
                    break;
                case 11:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 12:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 13:
                    strO4 = SafeParcelReader.o(parcel, iY);
                    break;
                case 14:
                    iA4 = SafeParcelReader.A(parcel, iY);
                    break;
                case 15:
                    fX = SafeParcelReader.x(parcel, iY);
                    break;
                case 16:
                    jC3 = SafeParcelReader.C(parcel, iY);
                    break;
                case 17:
                    strO5 = SafeParcelReader.o(parcel, iY);
                    break;
                case 18:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new WakeLockEvent(iA, jC, iA2, strO, iA3, arrayListQ, strO2, jC2, iA4, strO3, strO4, fX, jC3, strO5, zV);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
