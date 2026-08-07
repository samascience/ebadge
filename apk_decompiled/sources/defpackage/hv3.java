package defpackage;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class hv3 extends yt3 implements ev3 {
    public hv3() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // defpackage.yt3
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 101:
                o((GoogleSignInAccount) bu3.a(parcel, GoogleSignInAccount.CREATOR), (Status) bu3.a(parcel, Status.CREATOR));
                break;
            case 102:
                f((Status) bu3.a(parcel, Status.CREATOR));
                break;
            case 103:
                k((Status) bu3.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
