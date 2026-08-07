package com.jieli.config;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.jieli.JliCore;
import com.jieli.otasdk.util.OtaConstant;
import com.tencent.connect.common.Constants;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigHelper {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_AUTO_TEST_COUNT = "auto_test_count";
    private static final String KEY_AUTO_TEST_OTA = "auto_test_ota";
    private static final String KEY_BLE_MTU_VALUE = "ble_mtu_value";
    private static final String KEY_BROADCAST_BOX = "broadcast_box_switch";
    private static final String KEY_COMMUNICATION_WAY = "communication_way";
    private static final String KEY_DEVELOP_MODE = "develop_mode";
    private static final String KEY_DOWNLOAD_URI = "download_uri";
    private static final String KEY_FAULT_TOLERANT = "fault_tolerant";
    private static final String KEY_FAULT_TOLERANT_COUNT = "fault_tolerant_count";
    private static final String KEY_IS_HID_DEVICE = "is_hid_device";
    private static final String KEY_IS_USE_DEVICE_AUTH = "is_use_device_auth";
    private static final String KEY_SCAN_FILTER_STRING = "scan_filter_string";
    private static final String KEY_SPP_CUSTOM_UUID = "spp_custom_uuid";
    private static final String KEY_SPP_MULTIPLE_CHANNEL = "spp_multiple_channel";
    private static final String KEY_USE_CUSTOM_RECONNECT_WAY = "use_custom_reconnect_way";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile ConfigHelper instance;
    private final SharedPreferences preferences;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public final ConfigHelper getInstance() {
            ConfigHelper configHelper = ConfigHelper.instance;
            if (configHelper == null) {
                synchronized (this) {
                    configHelper = ConfigHelper.instance;
                    if (configHelper == null) {
                        Application application = JliCore.getInstance().getApplication();
                        p31.e(application, "getInstance().application");
                        configHelper = new ConfigHelper(application, null);
                        ConfigHelper.instance = configHelper;
                    }
                }
            }
            return configHelper;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ConfigHelper(Context context, y70 y70Var) {
        this(context);
    }

    public final void enableBroadcastBox(boolean z) {
        this.preferences.edit().putBoolean(KEY_BROADCAST_BOX, z).apply();
    }

    public final int getAutoTestCount() {
        return this.preferences.getInt(KEY_AUTO_TEST_COUNT, 30);
    }

    public final int getBleRequestMtu() {
        return this.preferences.getInt(KEY_BLE_MTU_VALUE, 509);
    }

    public final String getCustomSppChannel() {
        return this.preferences.getString(KEY_SPP_CUSTOM_UUID, OtaConstant.Companion.getUUID_SPP().toString());
    }

    public final int getFaultTolerantCount() {
        return this.preferences.getInt(KEY_FAULT_TOLERANT_COUNT, 1);
    }

    public final String getScanFilter() {
        return this.preferences.getString(KEY_SCAN_FILTER_STRING, Constants.STR_EMPTY);
    }

    public final boolean isAutoTest() {
        return this.preferences.getBoolean(KEY_AUTO_TEST_OTA, false);
    }

    public final boolean isBleWay() {
        return this.preferences.getInt(KEY_COMMUNICATION_WAY, 0) == 0;
    }

    public final boolean isDevelopMode() {
        return this.preferences.getBoolean(KEY_DEVELOP_MODE, false);
    }

    public final boolean isEnableBroadcastBox() {
        return this.preferences.getBoolean(KEY_BROADCAST_BOX, false);
    }

    public final boolean isFaultTolerant() {
        return this.preferences.getBoolean(KEY_FAULT_TOLERANT, false);
    }

    public final boolean isHidDevice() {
        return this.preferences.getBoolean(KEY_IS_HID_DEVICE, false);
    }

    public final boolean isUseCustomReConnectWay() {
        return this.preferences.getBoolean(KEY_USE_CUSTOM_RECONNECT_WAY, false);
    }

    public final boolean isUseDeviceAuth() {
        return this.preferences.getBoolean(KEY_IS_USE_DEVICE_AUTH, true);
    }

    public final boolean isUseMultiSppChannel() {
        return this.preferences.getBoolean(KEY_SPP_MULTIPLE_CHANNEL, false);
    }

    public final void setAutoTest(boolean z) {
        this.preferences.edit().putBoolean(KEY_AUTO_TEST_OTA, z).apply();
    }

    public final void setAutoTestCount(int i) {
        if (isAutoTest()) {
            this.preferences.edit().putInt(KEY_AUTO_TEST_COUNT, i).apply();
        }
    }

    public final void setBleRequestMtu(int i) {
        this.preferences.edit().putInt(KEY_BLE_MTU_VALUE, i).apply();
    }

    public final void setBleWay(boolean z) {
        this.preferences.edit().putInt(KEY_COMMUNICATION_WAY, !z ? 1 : 0).apply();
    }

    public final void setCustomSppChannel(String str) {
        this.preferences.edit().putString(KEY_SPP_CUSTOM_UUID, str).apply();
    }

    public final void setDevelopMode(boolean z) {
        this.preferences.edit().putBoolean(KEY_DEVELOP_MODE, z).apply();
    }

    public final void setFaultTolerant(boolean z) {
        this.preferences.edit().putBoolean(KEY_FAULT_TOLERANT, z).apply();
    }

    public final void setFaultTolerantCount(int i) {
        if (isFaultTolerant()) {
            this.preferences.edit().putInt(KEY_FAULT_TOLERANT_COUNT, i).apply();
        }
    }

    public final void setHidDevice(boolean z) {
        this.preferences.edit().putBoolean(KEY_IS_HID_DEVICE, z).apply();
    }

    public final void setScanFilter(String str) {
        this.preferences.edit().putString(KEY_SCAN_FILTER_STRING, str).apply();
    }

    public final void setUseCustomReConnectWay(boolean z) {
        this.preferences.edit().putBoolean(KEY_USE_CUSTOM_RECONNECT_WAY, z).apply();
    }

    public final void setUseDeviceAuth(boolean z) {
        this.preferences.edit().putBoolean(KEY_IS_USE_DEVICE_AUTH, z).apply();
    }

    public final void setUseMultiSppChannel(boolean z) {
        this.preferences.edit().putBoolean(KEY_SPP_MULTIPLE_CHANNEL, z).apply();
    }

    private ConfigHelper(Context context) {
        this.preferences = context.getSharedPreferences("ota_config_data", 0);
    }
}
