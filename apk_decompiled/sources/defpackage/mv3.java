package defpackage;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.d;

/* JADX INFO: loaded from: classes.dex */
public final class mv3 extends bv3 {
    private final Context c;

    public mv3(Context context) {
        this.c = context;
    }

    private final void b() {
        if (d.g(this.c, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }

    @Override // defpackage.xu3
    public final void B() {
        b();
        su2 su2VarB = su2.b(this.c);
        GoogleSignInAccount googleSignInAccountC = su2VarB.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.p;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = su2VarB.d();
        }
        c cVarE = new c.a(this.c).b(bc.g, googleSignInOptionsD).e();
        try {
            if (cVarE.d().J0()) {
                if (googleSignInAccountC != null) {
                    bc.j.a(cVarE);
                } else {
                    cVarE.e();
                }
            }
        } finally {
            cVarE.h();
        }
    }

    @Override // defpackage.xu3
    public final void E() {
        b();
        vu3.c(this.c).a();
    }
}
