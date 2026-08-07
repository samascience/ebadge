package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.p000authapi.zzy;

/* JADX INFO: loaded from: classes.dex */
public final class sv3 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            if (SafeParcelReader.u(iY) != 1) {
                SafeParcelReader.F(parcel, iY);
            } else {
                credential = (Credential) SafeParcelReader.n(parcel, iY, Credential.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zzy(credential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzy[i];
    }
}
