package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    private static class a {
        private static f a = new f();
    }

    public static f a() {
        return a.a;
    }

    public String b(Context context) {
        if (context == null) {
            return Build.MODEL;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 0);
        String string = sharedPreferences.getString("build_model", Constants.STR_EMPTY);
        if (string != null && !Constants.STR_EMPTY.equals(string)) {
            return string;
        }
        String str = Build.MODEL;
        sharedPreferences.edit().putString("build_model", str).apply();
        return str;
    }

    private f() {
    }

    public String a(Context context) {
        if (context == null) {
            return Build.DEVICE;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 0);
        String string = sharedPreferences.getString("build_device", Constants.STR_EMPTY);
        if (string != null && !Constants.STR_EMPTY.equals(string)) {
            return string;
        }
        String str = Build.DEVICE;
        sharedPreferences.edit().putString("build_device", str).apply();
        return str;
    }
}
