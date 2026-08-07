package xfkj.fitpro.activity.ota.manager;

import android.app.Application;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class OTAInitializer {
    private static final String TAG = "OTAInitializer";

    /* JADX INFO: renamed from: xfkj.fitpro.activity.ota.manager.OTAInitializer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$xfkj$fitpro$activity$ota$manager$OTAInitializer$OTAPlatform;

        static {
            int[] iArr = new int[OTAPlatform.values().length];
            $SwitchMap$xfkj$fitpro$activity$ota$manager$OTAInitializer$OTAPlatform = iArr;
            try {
                iArr[OTAPlatform.JLI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$xfkj$fitpro$activity$ota$manager$OTAInitializer$OTAPlatform[OTAPlatform.LP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$xfkj$fitpro$activity$ota$manager$OTAInitializer$OTAPlatform[OTAPlatform.LY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum OTAPlatform {
        JLI("杰理科技"),
        LP("络达科技"),
        LY("联芸科技");

        private final String displayName;

        OTAPlatform(String str) {
            this.displayName = str;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }

    public static String getInitializationStatus() {
        return OTASDKManager.getInstance().getInitializationStatus();
    }

    public static boolean initialize(Application application) {
        try {
            OTASDKManager.getInstance().initialize(application);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "OTA SDK初始化失败", e);
            return false;
        }
    }

    public static boolean isInitialized() {
        return OTASDKManager.getInstance().isInitialized();
    }

    public static boolean isPlatformInitialized(OTAPlatform oTAPlatform) {
        OTASDKManager oTASDKManager = OTASDKManager.getInstance();
        int i = AnonymousClass1.$SwitchMap$xfkj$fitpro$activity$ota$manager$OTAInitializer$OTAPlatform[oTAPlatform.ordinal()];
        if (i == 1) {
            return oTASDKManager.isJliInitialized();
        }
        if (i == 2) {
            return oTASDKManager.isLpInitialized();
        }
        if (i != 3) {
            return false;
        }
        return oTASDKManager.isLyInitialized();
    }

    public static void reset() {
        OTASDKManager.getInstance().reset();
    }
}
