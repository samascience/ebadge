package defpackage;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cu {
    private static String a(String str) {
        return TextUtils.isEmpty(str) ? Constants.STR_EMPTY : str.replaceAll(":", Constants.STR_EMPTY);
    }

    private static String b(String str) {
        return a(str) + "_preview_pause_on_remote_shutter";
    }

    private static String c(String str) {
        return a(str) + "_realtime_preview_supported";
    }

    public static boolean d() {
        return qj2.b(b(ug3.c()), false);
    }

    public static boolean e() {
        return qj2.b(c(ug3.c()), false);
    }

    public static void f(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qj2.d(b(str), z);
    }

    public static void g(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qj2.d(c(str), z);
    }
}
