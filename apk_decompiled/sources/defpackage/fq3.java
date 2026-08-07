package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.f;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class fq3 {
    public static int A = 0;
    public static int B = 0;
    public static int C = 1000;
    public static int D = Integer.MAX_VALUE;
    public static float E = 6.0f;
    public static float F = 10.0f;
    public static int G = 60;
    public static int H = 70;
    public static int I = 6;
    public static String J = null;
    public static boolean K = false;
    public static int L = 16;
    public static float M = 0.75f;
    public static double N = -0.10000000149011612d;
    public static int O = 0;
    public static int P = 0;
    public static int Q = 1;
    public static int R = -1;
    public static int S = 10;
    public static int T = 3;
    public static int U = 40;
    public static double[] V = null;
    public static int W = 1;
    public static int X = 1;
    public static int Y = 1;
    public static boolean a = false;
    public static boolean b = false;
    public static int c = 0;
    public static String d = "no";
    public static int e = 4;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static String l = "";
    public static int m = 3;
    public static int n = 0;
    public static int o = 0;
    public static float p = 2.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static float f334q = 10.0f;
    public static float r = 50.0f;
    public static float s = 200.0f;
    public static int t = 16;
    public static int u = 10000;
    public static float v = 0.5f;
    public static float w = 0.0f;
    public static float x = 0.1f;
    public static int y = 30;
    public static int z;
    private static String Z = Build.MANUFACTURER;
    public static boolean a0 = false;

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    public static String A() {
        String path;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    path = Environment.getExternalStorageDirectory().getPath();
                } else {
                    path = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            path = null;
        }
        if (path == null && Build.VERSION.SDK_INT > 28 && f.b() != null) {
            try {
                path = f.b().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
            } catch (Exception unused) {
                path = null;
            }
        }
        if (path != null) {
            try {
                File file = new File(path + "/baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return path;
    }

    public static String B(Context context) {
        int type = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    type = activeNetworkInfo.getType();
                }
            } catch (Throwable unused) {
            }
        }
        return "&netc=" + type;
    }

    public static String C() {
        String strA = A();
        if (strA == null) {
            return null;
        }
        return strA + "/baidu/tempdata";
    }

    public static String D() {
        try {
            File file = new File(f.b().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String E() {
        try {
            File file = new File(f.b().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return f.b().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String F() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(f.b().getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append("/baidu/tempdata");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return f.b().getFilesDir().getPath() + str + "/baidu/tempdata";
        } catch (Exception unused) {
            return null;
        }
    }

    public static String G() {
        return w("ro.mediatek.platform");
    }

    public static double a(double d2, double d3, double d4, double d5) {
        float[] fArr = new float[1];
        Location.distanceBetween(d2, d3, d4, d5, fArr);
        return fArr[0];
    }

    public static int b(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception unused) {
            return 2;
        }
    }

    public static int c(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static int d(Object obj, String str) throws NoSuchMethodException {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    public static int e(String str, String str2, String str3) {
        int iIndexOf;
        int length;
        int iIndexOf2;
        String strSubstring;
        if (str != null && !str.equals(Constants.STR_EMPTY) && (iIndexOf = str.indexOf(str2)) != -1 && (iIndexOf2 = str.indexOf(str3, (length = iIndexOf + str2.length()))) != -1 && (strSubstring = str.substring(length, iIndexOf2)) != null && !strSubstring.equals(Constants.STR_EMPTY)) {
            try {
                return Integer.parseInt(strSubstring);
            } catch (NumberFormatException unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public static String f() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i2), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String g(bn3 bn3Var, eq3 eq3Var, Location location, String str, int i2) {
        return h(bn3Var, eq3Var, location, str, i2, false);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00c8 A[Catch: Exception -> 0x00cb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cb, blocks: (B:40:0x008b, B:44:0x00a7, B:47:0x00ad, B:48:0x00b0, B:53:0x00bc, B:55:0x00c0, B:57:0x00c4, B:58:0x00c8), top: B:62:0x008b }] */
    public static String h(bn3 bn3Var, eq3 eq3Var, Location location, String str, int i2, boolean z2) {
        String strM;
        String strM2;
        StringBuffer stringBuffer = new StringBuffer(2048);
        if (bn3Var != null && (strM2 = so3.h().m(bn3Var)) != null) {
            stringBuffer.append(strM2);
        }
        if (eq3Var != null) {
            if (i2 == 0) {
                strM = z2 ? eq3Var.g() : eq3Var.k();
            } else {
                strM = eq3Var.m();
            }
            if (strM != null) {
                stringBuffer.append(strM);
            }
        }
        if (location != null) {
            String strZ = (c == 0 || i2 == 0) ? mp3.z(location) : mp3.L(location);
            if (strZ != null) {
                stringBuffer.append(strZ);
            }
        }
        String strB = to3.a().b(i2 == 0);
        if (strB != null) {
            stringBuffer.append(strB);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(mp3.f().s0());
        String strI = so3.h().i(bn3Var);
        if (strI != null && strI.length() + stringBuffer.length() < 2000) {
            stringBuffer.append(strI);
        }
        String string = stringBuffer.toString();
        if (location == null || eq3Var == null) {
            m = 3;
        } else {
            try {
                float speed = location.getSpeed();
                int i3 = c;
                int iQ = eq3Var.q();
                int iA = eq3Var.a();
                boolean zR = eq3Var.r();
                if (speed < E && ((i3 == 1 || i3 == 0) && (iQ < G || zR))) {
                    m = 1;
                } else if (speed >= F || (!(i3 == 1 || i3 == 0 || i3 == 3) || (iQ >= H && iA <= I))) {
                    m = 3;
                } else {
                    m = 2;
                }
            } catch (Exception unused) {
                m = 3;
            }
        }
        return string;
    }

    public static String i(String str) {
        return Jni.d(l + ";" + str);
    }

    public static String j(byte[] bArr, String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z2) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String k(byte[] bArr, boolean z2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return j(messageDigest.digest(), Constants.STR_EMPTY, z2);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean l(double d2, double d3) {
        return Math.abs(d2 - d3) <= 1.192092896E-7d;
    }

    public static boolean m(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.1920929E-7f;
    }

    public static boolean n(Location location) {
        String str;
        if (location == null || (str = Z) == null || !"huawei".equalsIgnoreCase(str)) {
            return false;
        }
        try {
            Bundle extras = location.getExtras();
            return extras != null && (extras.getInt("SourceType") & 128) == 128;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean o(BDLocation bDLocation) {
        int iG = bDLocation.g();
        return (iG > 100 && iG < 200) || iG == 62;
    }

    public static byte[] p(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int q(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean r() {
        return false;
    }

    public static boolean s(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean t(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte[] u(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[2048];
            while (true) {
                int i2 = gZIPInputStream.read(bArr2);
                if (i2 < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, i2);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String v() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet6Address) && inetAddressNextElement.getHostAddress() != null && !inetAddressNextElement.getHostAddress().startsWith("fe80:")) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return Constants.STR_EMPTY;
        } catch (Throwable unused) {
            return Constants.STR_EMPTY;
        }
    }

    public static String w(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                if (TextUtils.isEmpty(line)) {
                    return null;
                }
                return line;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean x(Context context) {
        int iCheckCallingOrSelfPermission;
        if (context == null) {
            return true;
        }
        try {
            iCheckCallingOrSelfPermission = context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        } catch (Exception e2) {
            e2.printStackTrace();
            iCheckCallingOrSelfPermission = 0;
        }
        boolean z2 = iCheckCallingOrSelfPermission == 0;
        if (z2) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) == 0) {
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return z2;
    }

    public static String y() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    public static String z(Context context) {
        return "&per=" + c(context, "android.permission.ACCESS_COARSE_LOCATION") + "|" + c(context, "android.permission.ACCESS_FINE_LOCATION") + "|" + c(context, "android.permission.READ_PHONE_STATE");
    }
}
