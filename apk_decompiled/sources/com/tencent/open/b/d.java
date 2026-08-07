package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.connect.common.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static String a;
    private static String b;

    public static String a() {
        return Constants.STR_EMPTY;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String c(Context context) {
        return Constants.STR_EMPTY;
    }

    public static String d(Context context) {
        return Constants.STR_EMPTY;
    }

    public static String e(Context context) {
        try {
            if (b == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=");
                sb.append(b(context));
                sb.append('&');
                sb.append("model=");
                sb.append(com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()));
                sb.append('&');
                sb.append("os=");
                sb.append(Build.VERSION.RELEASE);
                sb.append('&');
                sb.append("apilevel=");
                sb.append(Build.VERSION.SDK_INT);
                sb.append('&');
                String strB = a.b(context);
                if (strB == null) {
                    strB = Constants.STR_EMPTY;
                }
                sb.append("network=");
                sb.append(strB);
                sb.append('&');
                sb.append("sdcard=");
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append('&');
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append('&');
                sb.append("manu=");
                sb.append(Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(a.e(context));
                b = sb.toString();
            }
            return b;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (context == null) {
            return Constants.STR_EMPTY;
        }
        a = Constants.STR_EMPTY;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return a;
    }

    public static String b(Context context) {
        return Constants.STR_EMPTY;
    }
}
