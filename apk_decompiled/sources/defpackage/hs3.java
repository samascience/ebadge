package defpackage;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zaj;

/* JADX INFO: loaded from: classes.dex */
public abstract class hs3 extends jr3 implements es3 {
    public hs3() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // defpackage.jr3
    protected boolean H(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 3) {
            z((ConnectionResult) vr3.b(parcel, ConnectionResult.CREATOR), (zaa) vr3.b(parcel, zaa.CREATOR));
        } else if (i == 4) {
            s((Status) vr3.b(parcel, Status.CREATOR));
        } else if (i == 6) {
            u((Status) vr3.b(parcel, Status.CREATOR));
        } else if (i == 7) {
            e((Status) vr3.b(parcel, Status.CREATOR), (GoogleSignInAccount) vr3.b(parcel, GoogleSignInAccount.CREATOR));
        } else {
            if (i != 8) {
                return false;
            }
            g((zaj) vr3.b(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
