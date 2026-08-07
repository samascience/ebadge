package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qj2 {
    public static SharedPreferences a;
    private static SharedPreferences.Editor b;

    public static void a(Context context) {
        Log.d("SaveKeyValues", "getSharedPreferences--储存的文件名--camera_library_sp");
        SharedPreferences sharedPreferences = context.getSharedPreferences("camera_library_sp", 0);
        a = sharedPreferences;
        b = sharedPreferences.edit();
    }

    public static boolean b(String str, boolean z) {
        if (c()) {
            return false;
        }
        return a.getBoolean(str, z);
    }

    public static boolean c() {
        boolean z = a == null;
        if (z) {
            Log.d("SaveKeyValues", "提醒：sharedPreferences未被创建！");
        }
        return z;
    }

    public static boolean d(String str, boolean z) {
        if (c()) {
            return false;
        }
        e(str);
        b.putBoolean(str, z);
        return b.commit();
    }

    public static boolean e(String str) {
        if (c()) {
            return false;
        }
        b.remove(str);
        return b.commit();
    }
}
