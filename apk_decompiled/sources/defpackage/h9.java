package defpackage;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h9 {
    public static String a(Context context) {
        return b(context, context.getPackageName());
    }

    public static String b(Context context, String str) {
        if (tv2.a(str)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        return d(context, context.getPackageName());
    }

    public static String d(Context context, String str) {
        if (tv2.a(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void e(Context context, File file) {
        if (an0.a(file)) {
            Intent intentA = j31.a(context, file);
            if (context.getPackageManager().resolveActivity(intentA, 65536) != null) {
                try {
                    context.startActivity(intentA);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean f(Context context, String str) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
