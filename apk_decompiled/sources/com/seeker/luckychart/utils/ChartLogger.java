package com.seeker.luckychart.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class ChartLogger {
    private static final String TAG = "ChartLogger";
    private static final boolean debug = true;

    public static void d(String str) {
        Log.d(TAG, str);
    }

    public static void dTag(String str, String str2) {
        Log.d("ChartLogger—" + str, str2);
    }

    public static void v(String str) {
        Log.v(TAG, str);
    }

    public static void vTag(String str, String str2) {
        Log.v("ChartLogger—" + str, str2);
    }

    public static void w(String str) {
        Log.w(TAG, str);
    }

    public static void wTag(String str, String str2) {
        Log.w("ChartLogger—" + str, str2);
    }
}
