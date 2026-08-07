package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public abstract class rj2 {
    public static SharedPreferences a;
    private static SharedPreferences.Editor b;

    public static void a(Context context) {
        String packageName = context.getPackageName();
        hg.b("getSharedPreferences--储存的文件名--", packageName);
        SharedPreferences sharedPreferences = context.getSharedPreferences(packageName, 0);
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

    public static int c(String str, int i) {
        if (e()) {
            return 0;
        }
        return a.getInt(str, i);
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
            hg.b("提醒", "sharedPreferences未被创建！");
        }
        return z;
    }

    public static boolean f(String str, int i) {
        if (e()) {
            return false;
        }
        h(str);
        b.putInt(str, i);
        return b.commit();
    }

    public static boolean g(String str, String str2) {
        if (e()) {
            return false;
        }
        h(str);
        b.putString(str, str2);
        return b.commit();
    }

    public static boolean h(String str) {
        if (e()) {
            return false;
        }
        b.remove(str);
        return b.commit();
    }
}
