package com.baji.network.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import com.baji.network.model.ErrorType;
import com.baji.network.model.NetworkError;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import defpackage.gx;
import defpackage.lv2;
import defpackage.p31;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.collections.b0;
import kotlin.text.i;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkUtils {
    public static final NetworkUtils INSTANCE = new NetworkUtils();

    private NetworkUtils() {
    }

    public static /* synthetic */ NetworkError createNetworkError$default(NetworkUtils networkUtils, int i, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        return networkUtils.createNetworkError(i, str, th);
    }

    public final String calculateFileMD5(File file) {
        int i;
        p31.f(file, "file");
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            fileInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                lv2 lv2Var = lv2.a;
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                p31.e(str, "format(...)");
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final String calculateStringMD5(String str) {
        p31.f(str, "input");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(gx.b);
            p31.e(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                lv2 lv2Var = lv2.a;
                String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                p31.e(str2, "format(...)");
                sb.append(str2);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final NetworkError createNetworkError(int i, String str, Throwable th) {
        ErrorType errorType;
        p31.f(str, "errorMessage");
        if (th instanceof IOException) {
            errorType = ErrorType.NETWORK_ERROR;
        } else if (i.K(str, "timeout", true)) {
            errorType = ErrorType.TIMEOUT_ERROR;
        } else if (i.K(str, "parse", true)) {
            errorType = ErrorType.PARSE_ERROR;
        } else if (i == 401) {
            errorType = ErrorType.AUTH_ERROR;
        } else {
            errorType = i >= 500 ? ErrorType.SERVER_ERROR : ErrorType.UNKNOWN_ERROR;
        }
        return new NetworkError(i, str, errorType, 0L, 8, null);
    }

    public final String formatFileSize(long j) {
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        double d = j;
        int i = 0;
        while (d >= 1024.0d && i < 4) {
            d /= (double) 1024;
            i++;
        }
        lv2 lv2Var = lv2.a;
        String str = String.format("%.2f %s", Arrays.copyOf(new Object[]{Double.valueOf(d), strArr[i]}, 2));
        p31.e(str, "format(...)");
        return str;
    }

    public final String formatSpeed(long j) {
        return formatFileSize(j) + "/s";
    }

    public final String formatTimeRemaining(long j) {
        long j2 = j / ((long) 1000);
        long j3 = 60;
        long j4 = j2 / j3;
        long j5 = j4 / j3;
        if (j5 > 0) {
            lv2 lv2Var = lv2.a;
            String str = String.format("%d小时%d分钟", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j4 % j3)}, 2));
            p31.e(str, "format(...)");
            return str;
        }
        if (j4 > 0) {
            lv2 lv2Var2 = lv2.a;
            String str2 = String.format("%d分钟%d秒", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(j2 % j3)}, 2));
            p31.e(str2, "format(...)");
            return str2;
        }
        lv2 lv2Var3 = lv2.a;
        String str3 = String.format("%d秒", Arrays.copyOf(new Object[]{Long.valueOf(j2)}, 1));
        p31.e(str3, "format(...)");
        return str3;
    }

    public final String getFileExtension(File file) {
        p31.f(file, "file");
        String name = file.getName();
        p31.c(name);
        int iB0 = i.b0(name, '.', 0, false, 6, null);
        if (iB0 <= 0 || iB0 >= name.length() - 1) {
            return Constants.STR_EMPTY;
        }
        String strSubstring = name.substring(iB0 + 1);
        p31.e(strSubstring, "substring(...)");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        p31.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final String getNetworkType(Context context) {
        p31.f(context, "context");
        Object systemService = context.getSystemService("connectivity");
        p31.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
            return "WIFI";
        }
        if (networkCapabilities == null || !networkCapabilities.hasTransport(0)) {
            return (networkCapabilities == null || !networkCapabilities.hasTransport(3)) ? "UNKNOWN" : "ETHERNET";
        }
        return "MOBILE";
    }

    public final boolean isImageFile(File file) {
        p31.f(file, "file");
        return b0.f("jpg", "jpeg", "png", "gif", "bmp", "webp").contains(getFileExtension(file));
    }

    public final boolean isNetworkAvailable(Context context) {
        p31.f(context, "context");
        Object systemService = context.getSystemService("connectivity");
        p31.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    public final boolean isValidFile(File file) {
        p31.f(file, "file");
        return file.exists() && file.isFile() && file.canRead();
    }

    public final boolean isValidUrl(String str) {
        p31.f(str, SocialConstants.PARAM_URL);
        try {
            new URL(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isVideoFile(File file) {
        p31.f(file, "file");
        return b0.f("mp4", "avi", "mov", "wmv", "flv", "mkv").contains(getFileExtension(file));
    }
}
