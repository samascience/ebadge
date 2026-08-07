package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class tt3 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        String strO = null;
        int iA = 0;
        long jC = -1;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 2) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU != 3) {
                SafeParcelReader.F(parcel, iY);
            } else {
                jC = SafeParcelReader.C(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new Feature(strO, iA, jC);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Feature[i];
    }
}
