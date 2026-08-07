package com.arthenica.ffmpegkit;

/* JADX INFO: loaded from: classes.dex */
public class AbiDetect {
    private static boolean a = false;

    static {
        c.g();
    }

    public static String a() {
        return a ? "arm-v7a-neon" : getNativeAbi();
    }

    static void b() {
        a = true;
    }

    static native String getNativeAbi();

    static native String getNativeBuildConf();

    static native String getNativeCpuAbi();

    static native boolean isNativeLTSBuild();
}
