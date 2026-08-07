package com.jieli.otasdk.util;

import defpackage.p31;
import defpackage.y70;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class OtaConstant {
    public static final boolean AUTO_FAULT_TOLERANT = false;
    public static final int AUTO_FAULT_TOLERANT_COUNT = 1;
    public static final int AUTO_TEST_COUNT = 30;
    public static final boolean AUTO_TEST_OTA = false;
    public static final int CURRENT_PROTOCOL = 0;
    public static final Companion Companion = new Companion(null);
    public static final String DIR_LOGCAT = "logcat";
    public static final String DIR_ROOT = "JieLiOTA";
    public static final String DIR_UPGRADE = "upgrade";
    public static final boolean HID_DEVICE_WAY = false;
    public static final boolean IS_NEED_DEVICE_AUTH = true;
    public static final boolean NEED_CUSTOM_RECONNECT_WAY = false;
    public static final int PROTOCOL_BLE = 0;
    public static final int PROTOCOL_SPP = 1;
    public static final long SCAN_TIMEOUT = 16000;
    public static final boolean USE_SPP_MULTIPLE_CHANNEL = false;
    private static final UUID UUID_A2DP;
    private static final UUID UUID_SPP;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public final UUID getUUID_A2DP() {
            return OtaConstant.UUID_A2DP;
        }

        public final UUID getUUID_SPP() {
            return OtaConstant.UUID_SPP;
        }

        private Companion() {
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("0000110b-0000-1000-8000-00805f9b34fb");
        p31.e(uuidFromString, "fromString(\"0000110b-0000-1000-8000-00805f9b34fb\")");
        UUID_A2DP = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        p31.e(uuidFromString2, "fromString(\"00001101-0000-1000-8000-00805f9b34fb\")");
        UUID_SPP = uuidFromString2;
    }
}
