package com.iwellfitness.urllib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public class ManualUrlConfig {
    private static boolean initialized = false;
    private static OnOpenUrlListener openUrlListener;
    private static Provider provider;

    public interface OnOpenUrlListener {
        void onOpenUrl(Context context, OpenUrlRequest openUrlRequest);
    }

    public interface Provider {
        String getDeviceVersion();

        String getPackageName();

        boolean shouldShowAdv();
    }

    public static String getDeviceVersion() {
        Provider provider2 = provider;
        if (provider2 != null) {
            return provider2.getDeviceVersion();
        }
        return null;
    }

    public static String getPackageName() {
        Provider provider2 = provider;
        if (provider2 != null) {
            return provider2.getPackageName();
        }
        return null;
    }

    public static void init(Provider provider2) {
        if (provider2 == null) {
            throw new IllegalArgumentException("Provider cannot be null");
        }
        provider = provider2;
        initialized = true;
    }

    public static boolean isInitialized() {
        return initialized && provider != null;
    }

    public static void openUrl(Context context, String str) {
        openUrl(context, new OpenUrlRequest(str));
    }

    public static void reset() {
        provider = null;
        initialized = false;
        openUrlListener = null;
    }

    public static void setOpenUrlListener(OnOpenUrlListener onOpenUrlListener) {
        openUrlListener = onOpenUrlListener;
    }

    public static boolean shouldShowAdv() {
        Provider provider2 = provider;
        if (provider2 != null) {
            return provider2.shouldShowAdv();
        }
        return false;
    }

    public static void openUrl(Context context, String str, String str2) {
        openUrl(context, new OpenUrlRequest(str, str2));
    }

    public static void openUrl(Context context, OpenUrlRequest openUrlRequest) {
        if (context == null || openUrlRequest == null || openUrlRequest.getUrl() == null || openUrlRequest.getUrl().isEmpty()) {
            return;
        }
        OnOpenUrlListener onOpenUrlListener = openUrlListener;
        if (onOpenUrlListener != null) {
            onOpenUrlListener.onOpenUrl(context, openUrlRequest);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(openUrlRequest.getUrl()));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
