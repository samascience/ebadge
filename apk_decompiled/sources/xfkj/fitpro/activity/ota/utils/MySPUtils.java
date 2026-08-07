package xfkj.fitpro.activity.ota.utils;

import com.tencent.connect.common.Constants;
import defpackage.ij2;
import xfkj.fitpro.activity.ota.OTAProxyUtils;
import xfkj.fitpro.activity.ota.enu.OTAUpdateState;

/* JADX INFO: loaded from: classes4.dex */
public class MySPUtils {
    public static final String KEY_FUNCTION_OTA_FILE_PATH = "KEY_FUNCTION_OTA_FILE_PATH";
    public static final String KEY_FUNCTION_OTA_STATE = "KEY_FUNCTION_OTA_STATE";

    private static String getFormatBluetoothAddress() {
        return OTAProxyUtils.getmOtaInfo().getDeviceId();
    }

    public static String getOTAFilePath(String str) {
        return ij2.b().h(KEY_FUNCTION_OTA_FILE_PATH + str, Constants.STR_EMPTY);
    }

    public static int getOTAUpDateState(String str) {
        return ij2.b().e(KEY_FUNCTION_OTA_STATE + str, OTAUpdateState.OTA_UPDATE_NOT_BEING.getOrdinal());
    }

    public static void putOTAFilePath(String str, String str2) {
        ij2.b().n(KEY_FUNCTION_OTA_FILE_PATH + str2, str);
    }

    public static void putOTAUpDateState(OTAUpdateState oTAUpdateState) {
        ij2.b().j(KEY_FUNCTION_OTA_STATE + getFormatBluetoothAddress(), oTAUpdateState.getOrdinal());
    }

    public static int getOTAUpDateState() {
        return ij2.b().e(KEY_FUNCTION_OTA_STATE + getFormatBluetoothAddress(), OTAUpdateState.OTA_UPDATE_NOT_BEING.getOrdinal());
    }
}
