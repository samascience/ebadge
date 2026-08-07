package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ug3 {
    private static String a;

    public static void a() {
        a = Constants.STR_EMPTY;
        sj2.b();
    }

    public static boolean b() {
        return sj2.c("isBind", false);
    }

    public static String c() {
        return sj2.d("bluetooth_address", Constants.STR_EMPTY);
    }

    public static String d() {
        String strE = e();
        if (strE == null || strE.isEmpty()) {
            return Constants.STR_EMPTY;
        }
        return sj2.d(strE + "_bluetooth_device_name", Constants.STR_EMPTY);
    }

    public static String e() {
        String str = a;
        if (str == null || str.trim().isEmpty()) {
            a = c();
        }
        return a;
    }

    public static void f(boolean z) {
        sj2.f("isBind", z);
    }

    public static void g(String str) {
        sj2.h("bluetooth_address", str);
        a = str;
    }

    public static void h(String str) {
        String strE = e();
        if (strE == null || strE.isEmpty()) {
            return;
        }
        sj2.h(strE + "_bluetooth_device_name", str);
    }

    public static void i(int i) {
        sj2.g(e() + "_PlarmType", i);
    }
}
