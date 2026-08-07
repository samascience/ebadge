package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    private static final String[] a = {"huawei"};
    private static final String[] b = {"vivo"};
    private static final String[] c = {"xiaomi"};
    private static final String[] d = {"oppo"};
    private static final String[] e = {"leeco", "letv"};
    private static final String[] f = {"360", "qiku"};
    private static final String[] g = {"zte"};
    private static final String[] h = {"oneplus"};
    private static final String[] i = {"nubia"};
    private static final String[] j = {"coolpad", "yulong"};
    private static final String[] k = {"lg", "lge"};
    private static final String[] l = {"google"};
    private static final String[] m = {"samsung"};
    private static final String[] n = {"meizu"};
    private static final String[] o = {"lenovo"};
    private static final String[] p = {"smartisan", "deltainno"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f222q = {"htc"};
    private static final String[] r = {"sony"};
    private static final String[] s = {"gionee", "amigo"};
    private static final String[] t = {"motorola"};
    private static a u = null;

    public static class a {
        private String a;
        private String b;

        public String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + "}";
        }
    }

    private static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static a c() {
        a aVar = u;
        if (aVar != null) {
            return aVar;
        }
        u = new a();
        String strA = a();
        String strB = b();
        String[] strArr = a;
        if (i(strA, strB, strArr)) {
            u.a = strArr[0];
            String strD = d("ro.build.version.emui");
            String[] strArrSplit = strD.split("_");
            if (strArrSplit.length > 1) {
                u.b = strArrSplit[1];
            } else {
                u.b = strD;
            }
            return u;
        }
        String[] strArr2 = b;
        if (i(strA, strB, strArr2)) {
            u.a = strArr2[0];
            u.b = d("ro.vivo.os.build.display.id");
            return u;
        }
        String[] strArr3 = c;
        if (i(strA, strB, strArr3)) {
            u.a = strArr3[0];
            u.b = d("ro.build.version.incremental");
            return u;
        }
        String[] strArr4 = d;
        if (i(strA, strB, strArr4)) {
            u.a = strArr4[0];
            u.b = d("ro.build.version.opporom");
            return u;
        }
        String[] strArr5 = e;
        if (i(strA, strB, strArr5)) {
            u.a = strArr5[0];
            u.b = d("ro.letv.release.version");
            return u;
        }
        String[] strArr6 = f;
        if (i(strA, strB, strArr6)) {
            u.a = strArr6[0];
            u.b = d("ro.build.uiversion");
            return u;
        }
        String[] strArr7 = g;
        if (i(strA, strB, strArr7)) {
            u.a = strArr7[0];
            u.b = d("ro.build.MiFavor_version");
            return u;
        }
        String[] strArr8 = h;
        if (i(strA, strB, strArr8)) {
            u.a = strArr8[0];
            u.b = d("ro.rom.version");
            return u;
        }
        String[] strArr9 = i;
        if (i(strA, strB, strArr9)) {
            u.a = strArr9[0];
            u.b = d("ro.build.rom.id");
            return u;
        }
        String[] strArr10 = j;
        if (i(strA, strB, strArr10)) {
            u.a = strArr10[0];
        } else {
            String[] strArr11 = k;
            if (i(strA, strB, strArr11)) {
                u.a = strArr11[0];
            } else {
                String[] strArr12 = l;
                if (i(strA, strB, strArr12)) {
                    u.a = strArr12[0];
                } else {
                    String[] strArr13 = m;
                    if (i(strA, strB, strArr13)) {
                        u.a = strArr13[0];
                    } else {
                        String[] strArr14 = n;
                        if (i(strA, strB, strArr14)) {
                            u.a = strArr14[0];
                        } else {
                            String[] strArr15 = o;
                            if (i(strA, strB, strArr15)) {
                                u.a = strArr15[0];
                            } else {
                                String[] strArr16 = p;
                                if (i(strA, strB, strArr16)) {
                                    u.a = strArr16[0];
                                } else {
                                    String[] strArr17 = f222q;
                                    if (i(strA, strB, strArr17)) {
                                        u.a = strArr17[0];
                                    } else {
                                        String[] strArr18 = r;
                                        if (i(strA, strB, strArr18)) {
                                            u.a = strArr18[0];
                                        } else {
                                            String[] strArr19 = s;
                                            if (i(strA, strB, strArr19)) {
                                                u.a = strArr19[0];
                                            } else {
                                                String[] strArr20 = t;
                                                if (i(strA, strB, strArr20)) {
                                                    u.a = strArr20[0];
                                                } else {
                                                    u.a = strB;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        u.b = d(Constants.STR_EMPTY);
        return u;
    }

    private static String d(String str) {
        String strE = !TextUtils.isEmpty(str) ? e(str) : Constants.STR_EMPTY;
        if (TextUtils.isEmpty(strE) || strE.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    strE = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strE) ? "unknown" : strE;
    }

    private static String e(String str) throws Throwable {
        String strG = g(str);
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        String strH = h(str);
        return (TextUtils.isEmpty(strH) && Build.VERSION.SDK_INT < 28) ? f(str) : strH;
    }

    private static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, Constants.STR_EMPTY);
        } catch (Exception unused) {
            return Constants.STR_EMPTY;
        }
    }

    private static String g(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused) {
                        }
                        return line;
                    }
                    bufferedReader2.close();
                    return Constants.STR_EMPTY;
                } catch (IOException unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        return Constants.STR_EMPTY;
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                return Constants.STR_EMPTY;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, Constants.STR_EMPTY);
        } catch (Exception unused) {
            return Constants.STR_EMPTY;
        }
    }

    private static boolean i(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }
}
