package defpackage;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zaj;

/* JADX INFO: loaded from: classes.dex */
public interface es3 extends IInterface {
    void e(Status status, GoogleSignInAccount googleSignInAccount);

    void g(zaj zajVar);

    void s(Status status);

    void u(Status status);

    void z(ConnectionResult connectionResult, zaa zaaVar);
}
