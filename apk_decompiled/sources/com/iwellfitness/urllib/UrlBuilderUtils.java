package com.iwellfitness.urllib;

import android.util.Log;
import com.tencent.open.SocialConstants;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class UrlBuilderUtils {
    private static final String TAG = "UrlBuilderUtils";
    public static final String TYPE_APP = "app";
    public static final String TYPE_DEV = "dev";
    public static final String TYPE_FAQ = "faq";

    public static class Builder {
        private boolean hasParams = false;
        private final StringBuilder urlBuilder;

        public Builder(String str) {
            this.urlBuilder = new StringBuilder(str);
        }

        private void appendParam(String str, String str2) {
            try {
                String strEncode = URLEncoder.encode(str2, StandardCharsets.UTF_8.toString());
                if (this.hasParams) {
                    this.urlBuilder.append("&");
                } else {
                    this.urlBuilder.append("?");
                    this.hasParams = true;
                }
                StringBuilder sb = this.urlBuilder;
                sb.append(str);
                sb.append("=");
                sb.append(strEncode);
            } catch (Exception unused) {
                if (this.hasParams) {
                    this.urlBuilder.append("&");
                } else {
                    this.urlBuilder.append("?");
                    this.hasParams = true;
                }
                StringBuilder sb2 = this.urlBuilder;
                sb2.append(str);
                sb2.append("=");
                sb2.append(str2);
            }
        }

        private boolean isEmpty(String str) {
            return str == null || str.length() == 0;
        }

        public Builder addAdvParam(boolean z) {
            appendParam("a", z ? "1" : "0");
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (!isEmpty(str) && !isEmpty(str2)) {
                appendParam(str, str2);
            }
            return this;
        }

        public Builder addPkgNameParam(String str) {
            if (isEmpty(str)) {
                return this;
            }
            appendParam("pkgName", str);
            return this;
        }

        public Builder addTypeParam(String str) {
            if (isEmpty(str)) {
                return this;
            }
            appendParam(SocialConstants.PARAM_TYPE, str);
            return this;
        }

        public Builder addVersionParam(String str) {
            if (isEmpty(str)) {
                return this;
            }
            if (!str.startsWith("V") && !str.startsWith("v")) {
                str = "V" + str;
            }
            appendParam("version", str);
            return this;
        }

        public String build() {
            return this.urlBuilder.toString();
        }
    }

    public static String buildAppManualUrl(String str, boolean z) {
        return buildManualUrl(ManualUrlConstants.BASE_URL, "app", null, str, z);
    }

    public static String buildDeviceManualUrl(String str, String str2, boolean z) {
        return buildManualUrl(ManualUrlConstants.BASE_URL, TYPE_DEV, str, str2, z);
    }

    public static String buildFaqUrl(String str, boolean z) {
        return buildManualUrl(ManualUrlConstants.BASE_URL, TYPE_FAQ, null, str, z);
    }

    public static String buildManualUrl(String str, String str2, String str3, String str4, boolean z) {
        Builder builder = new Builder(str);
        builder.addAdvParam(z);
        if (!isEmpty(str2)) {
            builder.addTypeParam(str2);
        }
        if (!isEmpty(str3)) {
            builder.addVersionParam(str3);
        }
        if (!isEmpty(str4)) {
            builder.addPkgNameParam(str4);
        }
        String strBuild = builder.build();
        Log.d(TAG, "buildManualUrl - type: " + str2 + ", deviceVersion: " + str3 + ", pkgName: " + str4 + ", showAdv: " + z);
        StringBuilder sb = new StringBuilder();
        sb.append("buildManualUrl - final URL: ");
        sb.append(strBuild);
        Log.d(TAG, sb.toString());
        return strBuild;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String buildAppManualUrl(String str, String str2, boolean z) {
        return buildManualUrl(str, "app", null, str2, z);
    }

    public static String buildDeviceManualUrl(String str, String str2, String str3, boolean z) {
        return buildManualUrl(str, TYPE_DEV, str2, str3, z);
    }

    public static String buildFaqUrl(String str, String str2, boolean z) {
        return buildManualUrl(str, TYPE_FAQ, null, str2, z);
    }

    public static String buildAppManualUrl() {
        return buildManualUrl("app");
    }

    public static String buildDeviceManualUrl() {
        return buildManualUrl(TYPE_DEV);
    }

    public static String buildFaqUrl() {
        return buildManualUrl(TYPE_FAQ);
    }

    public static String buildManualUrl(String str) {
        if (ManualUrlConfig.isInitialized()) {
            String deviceVersion = ManualUrlConfig.getDeviceVersion();
            String packageName = ManualUrlConfig.getPackageName();
            boolean zShouldShowAdv = ManualUrlConfig.shouldShowAdv();
            Log.d(TAG, "buildManualUrl (simplified) - type: " + str + ", deviceVersion: " + deviceVersion + ", pkgName: " + packageName + ", showAdv: " + zShouldShowAdv);
            return buildManualUrl(ManualUrlConstants.BASE_URL, str, deviceVersion, packageName, zShouldShowAdv);
        }
        throw new IllegalStateException("ManualUrlConfig not initialized. Call ManualUrlConfig.init() first.");
    }
}
