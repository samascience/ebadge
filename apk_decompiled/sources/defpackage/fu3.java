package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class fu3 {
    private static gd1 a = new gd1("GoogleSignInCommon", new String[0]);

    public static yu0 a(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount")) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.g;
        }
        return new yu0(googleSignInAccount, status);
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    private static void c(Context context) {
        vu3.c(context).a();
        Iterator it = c.k().iterator();
        while (it.hasNext()) {
            ((c) it.next()).p();
        }
        com.google.android.gms.common.api.internal.c.b();
    }

    public static tz1 d(c cVar, Context context, boolean z) {
        a.a("Revoking access", new Object[0]);
        String strE = su2.b(context).e();
        c(context);
        return z ? xt3.a(strE) : cVar.j(new nu3(cVar));
    }

    public static Intent e(Context context, GoogleSignInOptions googleSignInOptions) {
        a.a("getFallbackSignInIntent()", new Object[0]);
        Intent intentB = b(context, googleSignInOptions);
        intentB.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return intentB;
    }

    public static Intent f(Context context, GoogleSignInOptions googleSignInOptions) {
        a.a("getNoImplementationSignInIntent()", new Object[0]);
        Intent intentB = b(context, googleSignInOptions);
        intentB.setAction("com.google.android.gms.auth.NO_IMPL");
        return intentB;
    }
}
