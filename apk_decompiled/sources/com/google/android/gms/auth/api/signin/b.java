package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.dynamite.DynamiteModule;
import defpackage.bc;
import defpackage.c8;
import defpackage.fu3;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.google.android.gms.common.api.b {
    private static final a j = new a(null);
    private static int k = C0073b.a;

    private static class a {
        private a() {
        }

        /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.auth.api.signin.b$b, reason: collision with other inner class name */
    static final enum C0073b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, bc.g, googleSignInOptions, new c8());
    }

    private final synchronized int m() {
        try {
            if (k == C0073b.a) {
                Context contextE = e();
                com.google.android.gms.common.a aVarN = com.google.android.gms.common.a.n();
                int iH = aVarN.h(contextE, 12451000);
                if (iH == 0) {
                    k = C0073b.d;
                } else if (aVarN.c(contextE, iH, null) != null || DynamiteModule.a(contextE, "com.google.android.gms.auth.api.fallback") == 0) {
                    k = C0073b.b;
                } else {
                    k = C0073b.c;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return k;
    }

    public Intent l() {
        Context contextE = e();
        int i = g.a[m() - 1];
        if (i != 1) {
            return i != 2 ? fu3.f(contextE, (GoogleSignInOptions) d()) : fu3.b(contextE, (GoogleSignInOptions) d());
        }
        return fu3.e(contextE, (GoogleSignInOptions) d());
    }
}
