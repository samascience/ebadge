package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class pv3 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        String strO = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 2) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU != 5) {
                SafeParcelReader.F(parcel, iY);
            } else {
                googleSignInOptions = (GoogleSignInOptions) SafeParcelReader.n(parcel, iY, GoogleSignInOptions.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new SignInConfiguration(strO, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
