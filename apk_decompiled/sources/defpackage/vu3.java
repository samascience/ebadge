package defpackage;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public final class vu3 {
    private static vu3 d;
    private su2 a;
    private GoogleSignInAccount b;
    private GoogleSignInOptions c;

    private vu3(Context context) {
        su2 su2VarB = su2.b(context);
        this.a = su2VarB;
        this.b = su2VarB.c();
        this.c = this.a.d();
    }

    public static synchronized vu3 c(Context context) {
        return d(context.getApplicationContext());
    }

    private static synchronized vu3 d(Context context) {
        try {
            if (d == null) {
                d = new vu3(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return d;
    }

    public final synchronized void a() {
        this.a.a();
        this.b = null;
        this.c = null;
    }

    public final synchronized void b(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.a.f(googleSignInAccount, googleSignInOptions);
        this.b = googleSignInAccount;
        this.c = googleSignInOptions;
    }
}
