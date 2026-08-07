package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ai2 {
    private static Integer a;

    public static int a() {
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme")) {
            return 0;
        }
        return sv2.e(str.replaceAll("Flyme", Constants.STR_EMPTY).replaceAll("OS", Constants.STR_EMPTY).replaceAll(" ", Constants.STR_EMPTY).substring(0, 1));
    }

    public static int b() {
        Integer num = a;
        if (num != null) {
            return num.intValue();
        }
        if (g()) {
            Integer num2 = 1;
            a = num2;
            return num2.intValue();
        }
        if (f()) {
            Integer num3 = 2;
            a = num3;
            return num3.intValue();
        }
        if (e()) {
            Integer num4 = 3;
            a = num4;
            return num4.intValue();
        }
        Integer num5 = 4;
        a = num5;
        return num5.intValue();
    }

    public static int c() throws Throwable {
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            return 0;
        }
        try {
            return db3.a(strD);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String d() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.code").getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return line;
            } catch (IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    private static boolean e() {
        return true;
    }

    private static boolean f() {
        return a() >= 4;
    }

    private static boolean g() throws Throwable {
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        try {
            return db3.a(strD) >= 4;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
