package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public abstract class sj2 {
    public static SharedPreferences a;
    private static SharedPreferences.Editor b;

    public static void a(Context context) {
        yc1.a("getSharedPreferences--储存的文件名--", "mywatch_sdk_sp");
        SharedPreferences sharedPreferences = context.getSharedPreferences("mywatch_sdk_sp", 0);
        a = sharedPreferences;
        b = sharedPreferences.edit();
    }

    public static boolean b() {
        if (e()) {
            return false;
        }
        b.clear();
        return b.commit();
    }

    public static boolean c(String str, boolean z) {
        if (e()) {
            return false;
        }
        return a.getBoolean(str, z);
    }

    public static String d(String str, String str2) {
        if (e()) {
            return null;
        }
        return a.getString(str, str2);
    }

    public static boolean e() {
        boolean z = a == null;
        if (z) {
            yc1.a("提醒", "sharedPreferences未被创建！");
        }
        return z;
    }

    public static boolean f(String str, boolean z) {
        if (e()) {
            return false;
        }
        i(str);
        b.putBoolean(str, z);
        return b.commit();
    }

    public static boolean g(String str, int i) {
        if (e()) {
            return false;
        }
        i(str);
        b.putInt(str, i);
        return b.commit();
    }

    public static boolean h(String str, String str2) {
        if (e()) {
            return false;
        }
        i(str);
        b.putString(str, str2);
        return b.commit();
    }

    public static boolean i(String str) {
        if (e()) {
            return false;
        }
        b.remove(str);
        return b.commit();
    }
}
