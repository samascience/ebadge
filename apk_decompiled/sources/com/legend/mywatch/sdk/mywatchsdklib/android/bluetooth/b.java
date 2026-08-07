package com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth;

/* JADX INFO: loaded from: classes3.dex */
abstract class b {
    private static long a = 0;
    private static int b = 100;

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - a <= ((long) b);
        a = jCurrentTimeMillis;
        return z;
    }
}
