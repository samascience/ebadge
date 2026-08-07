package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import defpackage.a52;
import defpackage.d13;
import defpackage.d8;
import defpackage.fu3;
import defpackage.u03;
import defpackage.yu0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static b a(Context context, GoogleSignInOptions googleSignInOptions) {
        return new b(context, (GoogleSignInOptions) a52.g(googleSignInOptions));
    }

    public static u03 b(Intent intent) {
        yu0 yu0VarA = fu3.a(intent);
        if (yu0VarA == null) {
            return d13.a(d8.a(Status.i));
        }
        return (!yu0VarA.n().K0() || yu0VarA.a() == null) ? d13.a(d8.a(yu0VarA.n())) : d13.b(yu0VarA.a());
    }
}
