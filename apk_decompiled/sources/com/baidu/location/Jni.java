package com.baidu.location;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class Jni {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 11;
    private static int e = 12;
    private static int f = 13;
    private static int g = 15;
    private static int h = 1024;
    private static boolean i = false;

    static {
        try {
            System.loadLibrary("locSDK8b");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            i = true;
        }
    }

    private static native String a(byte[] bArr, int i2);

    private static native String b(double d2, double d3, int i2, int i3);

    public static double[] c(double d2, double d3, String str) {
        int i2;
        double[] dArr = {0.0d, 0.0d};
        if (i) {
            return dArr;
        }
        if (str.equals("bd09")) {
            i2 = a;
        } else if (str.equals("bd09ll")) {
            i2 = b;
        } else if (str.equals("gcj02")) {
            i2 = c;
        } else if (str.equals("gps2gcj")) {
            i2 = d;
        } else if (str.equals("bd092gcj")) {
            i2 = e;
        } else if (str.equals("bd09ll2gcj")) {
            i2 = f;
        } else {
            i2 = str.equals("wgs842mc") ? g : -1;
        }
        if (str.equals("gcj2wgs")) {
            i2 = 16;
        }
        try {
            String[] strArrSplit = b(d2, d3, i2, 132456).split(":");
            dArr[0] = Double.parseDouble(strArrSplit[0]);
            dArr[1] = Double.parseDouble(strArrSplit[1]);
        } catch (Throwable unused) {
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        return dArr;
    }

    public static String d(String str) {
        if (i) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[h];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte b2 = bytes[i3];
            if (b2 != 0) {
                bArr[i2] = b2;
                i2++;
            }
        }
        try {
            return a(bArr, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "err!";
        }
    }

    public static String e(String str) {
        if (i) {
            return "err!";
        }
        return d(str) + "|tp=3";
    }

    private static native String ee(String str, int i2);

    public static Long f(String str) {
        String str2;
        if (i) {
            return null;
        }
        try {
            str2 = new String(str.getBytes(), Constants.ENC_UTF_8);
        } catch (Exception unused) {
            str2 = Constants.STR_EMPTY;
        }
        try {
            return Long.valueOf(murmur(str2));
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String g(String str) {
        String str2;
        String strEe = "err!";
        if (i) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), Constants.ENC_UTF_8);
        } catch (Exception unused) {
            str2 = Constants.STR_EMPTY;
        }
        try {
            strEe = ee(str2, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        return strEe + "|tp=4";
    }

    public static String h() {
        if (i) {
            return null;
        }
        try {
            return ldkaiv();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static native String ldkaiv();

    private static native long murmur(String str);
}
