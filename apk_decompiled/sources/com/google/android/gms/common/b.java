package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import defpackage.fv3;
import defpackage.il3;
import defpackage.ta0;
import defpackage.zt3;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final int a = d.a;
    private static final b b = new b();

    b() {
    }

    public void a(Context context) {
        d.a(context);
    }

    public Intent b(int i) {
        return c(null, i, null);
    }

    public Intent c(Context context, int i, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            return fv3.c("com.google.android.gms");
        }
        if (context != null && ta0.c(context)) {
            return fv3.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(il3.a(context).c(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return fv3.b("com.google.android.gms", sb.toString());
    }

    public PendingIntent d(Context context, int i, int i2) {
        return e(context, i, i2, null);
    }

    public PendingIntent e(Context context, int i, int i2, String str) {
        Intent intentC = c(context, i, str);
        if (intentC == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, intentC, zt3.a | 134217728);
    }

    public String f(int i) {
        return d.b(i);
    }

    public int g(Context context) {
        return h(context, a);
    }

    public int h(Context context, int i) {
        int iF = d.f(context, i);
        if (d.h(context, iF)) {
            return 18;
        }
        return iF;
    }

    public boolean i(Context context, int i) {
        return d.h(context, i);
    }

    public boolean j(Context context, String str) {
        return d.k(context, str);
    }

    public boolean k(int i) {
        return d.j(i);
    }
}
