package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.IdToken;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class lu3 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        String strO = null;
        String strO2 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU != 2) {
                SafeParcelReader.F(parcel, iY);
            } else {
                strO2 = SafeParcelReader.o(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new IdToken(strO, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new IdToken[i];
    }
}
