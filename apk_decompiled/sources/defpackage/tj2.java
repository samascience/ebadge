package defpackage;

import android.os.Build;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.f;
import com.blankj.utilcode.util.g;
import com.blankj.utilcode.util.l;
import com.blankj.utilcode.util.m;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class tj2 {
    public static final String a;
    private static final String b;
    public static final String c;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(l.b());
        String str = File.separator;
        sb.append(str);
        String string = sb.toString();
        a = string;
        b = string + "log";
        c = string + "gui_xin_log" + str;
    }

    public static String a() {
        return "************* Head ****************\nRom Info           : " + m.c() + "\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\nApp VersionName    : " + c.i() + "\nApp VersionCode    : " + c.g() + "\n************* Head ****************\n\n";
    }

    public static void b(String str) {
        d("connect", str);
    }

    public static void c(String str) {
        d("log", str);
    }

    public static void d(String str, String str2) {
        e(str, str2, ".txt");
    }

    public static void e(String str, String str2, String str3) {
        f(str, str2, true, str3);
    }

    public static void f(String str, String str2, boolean z, String str3) {
        if (d20.b) {
            if (z) {
                str = str + e33.g(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH));
            }
            g(str2, a + str, str3);
        }
    }

    public static void g(String str, String str2, String str3) {
        String str4 = str2 + str3;
        if (!g.p(str4)) {
            str = a() + str;
        }
        f.d(str4, e33.g(new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS, Locale.ENGLISH)) + " " + str + "\n", true);
    }
}
