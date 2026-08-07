package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Log;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a() {
        q.f();
        System.exit(0);
    }

    public static int b() {
        return c(o.a().getPackageName());
    }

    public static int c(String str) {
        if (q.H(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = o.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String d() {
        return e(o.a().getPackageName());
    }

    public static String e(String str) {
        if (q.H(str)) {
            return Constants.STR_EMPTY;
        }
        try {
            PackageManager packageManager = o.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? Constants.STR_EMPTY : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    public static String f() {
        return o.a().getPackageName();
    }

    public static int g() {
        return h(o.a().getPackageName());
    }

    public static int h(String str) {
        if (q.H(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = o.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String i() {
        return j(o.a().getPackageName());
    }

    public static String j(String str) {
        if (q.H(str)) {
            return Constants.STR_EMPTY;
        }
        try {
            PackageInfo packageInfo = o.a().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? Constants.STR_EMPTY : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    public static boolean k() {
        return q.B();
    }

    public static boolean l(String str) {
        if (q.H(str)) {
            return false;
        }
        try {
            return o.a().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void m(o.c cVar) {
        q.b(cVar);
    }

    public static void n() {
        o(false);
    }

    public static void o(boolean z) {
        Intent intentR = q.r(o.a().getPackageName());
        if (intentR == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        intentR.addFlags(335577088);
        o.a().startActivity(intentR);
        if (z) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
