package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        HashSet hashSet = new HashSet();
        int iA = 0;
        String strO = null;
        byte[] bArrG = null;
        PendingIntent pendingIntent = null;
        DeviceMetaData deviceMetaData = null;
        int iA2 = 0;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    hashSet.add(1);
                    break;
                case 2:
                    strO = SafeParcelReader.o(parcel, iY);
                    hashSet.add(2);
                    break;
                case 3:
                    iA = SafeParcelReader.A(parcel, iY);
                    hashSet.add(3);
                    break;
                case 4:
                    bArrG = SafeParcelReader.g(parcel, iY);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, iY, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    deviceMetaData = (DeviceMetaData) SafeParcelReader.n(parcel, iY, DeviceMetaData.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
            }
        }
        if (parcel.dataPosition() == iG) {
            return new zzt(hashSet, iA2, strO, iA, bArrG, pendingIntent, deviceMetaData);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(iG);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzt[i];
    }
}
