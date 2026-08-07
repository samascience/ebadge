package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class ta0 {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    public static boolean a() {
        int i = d.a;
        return "user".equals(Build.TYPE);
    }

    public static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (a == null) {
            boolean z = false;
            if (x32.f() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }

    public static boolean c(Context context) {
        if (b(context) && !x32.h()) {
            return true;
        }
        if (d(context)) {
            return !x32.i() || x32.k();
        }
        return false;
    }

    public static boolean d(Context context) {
        if (b == null) {
            boolean z = false;
            if (x32.g() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            b = Boolean.valueOf(z);
        }
        return b.booleanValue();
    }

    public static boolean e(Context context) {
        if (c == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            c = Boolean.valueOf(z);
        }
        return c.booleanValue();
    }
}
