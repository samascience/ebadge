package com.arthenica.ffmpegkit;

import android.os.Build;
import android.util.Log;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.mi0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    static final String[] a = {"avutil", "swscale", "swresample", "avcodec", "avformat", "avfilter", "avdevice"};
    static final String[] b = {"chromaprint", "openh264", "rubberband", "snappy", "srt", "tesseract", "x265", "zimg", "libilbc"};

    static String a() {
        return "brand: " + Build.BRAND + ", model: " + Build.MODEL + ", device: " + Build.DEVICE + ", api level: " + Build.VERSION.SDK_INT + ", abis: " + FFmpegKitConfig.c(Build.SUPPORTED_ABIS) + ", 32bit abis: " + FFmpegKitConfig.c(Build.SUPPORTED_32_BIT_ABIS) + ", 64bit abis: " + FFmpegKitConfig.c(Build.SUPPORTED_64_BIT_ABIS);
    }

    static boolean b() {
        return System.getProperty("enable.ffmpeg.kit.test.mode") == null;
    }

    static String c() {
        return b() ? AbiDetect.a() : Abi.ABI_X86_64.getName();
    }

    static String d() {
        return b() ? FFmpegKitConfig.g() : new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.getDefault()).format(new Date());
    }

    static boolean e() {
        return false;
    }

    static void f(boolean z) {
        boolean z2 = false;
        if (!z && "arm-v7a".equals(k())) {
            try {
                i("ffmpegkit_armv7a_neon");
                z2 = true;
                AbiDetect.b();
            } catch (Error e) {
                Log.i("ffmpeg-kit", String.format("NEON supported armeabi-v7a ffmpegkit library not found. Loading default armeabi-v7a library.%s", mi0.a(e)));
            }
        }
        if (z2) {
            return;
        }
        i("ffmpegkit");
    }

    static void g() {
        i("ffmpegkit_abidetect");
    }

    static boolean h() {
        if (b()) {
            return AbiDetect.isNativeLTSBuild();
        }
        return true;
    }

    private static void i(String str) {
        if (b()) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e) {
                throw new Error(String.format("FFmpegKit failed to start on %s.", a()), e);
            }
        }
    }

    static int j() {
        return b() ? FFmpegKitConfig.getNativeLogLevel() : Level.AV_LOG_DEBUG.getValue();
    }

    private static String k() {
        return b() ? AbiDetect.getNativeAbi() : Abi.ABI_X86_64.getName();
    }

    static String l() {
        return b() ? d.b() : "test";
    }

    static String m() {
        if (b()) {
            return FFmpegKitConfig.k();
        }
        return h() ? String.format("%s-lts", "6.0") : "6.0";
    }
}
