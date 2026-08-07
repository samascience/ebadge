package defpackage;

import android.util.Log;
import com.tencent.connect.common.Constants;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.db.build.DeviceFunctionConfigModelDao;
import xfkj.fitpro.model.DeviceFunctionConfigModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z90 {
    public static DeviceFunctionConfigModel a(String str) {
        if (pv2.f(str)) {
            Log.w("DeviceFunctionConfigManager", "MAC 地址为空，无法获取配置");
            return null;
        }
        try {
            return (DeviceFunctionConfigModel) DBHelper.getDaoSession().getDeviceFunctionConfigModelDao().queryBuilder().r(DeviceFunctionConfigModelDao.Properties.DeviceMac.b(str.replaceAll(":", Constants.STR_EMPTY)), new gi3[0]).q();
        } catch (Exception e) {
            Log.e("DeviceFunctionConfigManager", "获取设备功能配置失败: " + e.getMessage(), e);
            return null;
        }
    }

    public static boolean b(String str) {
        DeviceFunctionConfigModel deviceFunctionConfigModelA = a(str);
        Log.i("DeviceFunctionConfigManager", "isSupportCommonContacts: " + deviceFunctionConfigModelA);
        return deviceFunctionConfigModelA != null && Boolean.TRUE.equals(deviceFunctionConfigModelA.getIsShowSyncontract());
    }

    public static boolean c(String str) {
        DeviceFunctionConfigModel deviceFunctionConfigModelA = a(str);
        return (deviceFunctionConfigModelA == null || Boolean.TRUE.equals(deviceFunctionConfigModelA.getIsCloseEmergencyContact())) ? false : true;
    }

    public static boolean d(String str) {
        DeviceFunctionConfigModel deviceFunctionConfigModelA = a(str);
        return deviceFunctionConfigModelA != null && Boolean.TRUE.equals(deviceFunctionConfigModelA.getIsShowRemoteCamera());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v27, types: [boolean, java.lang.Object] */
    public static void e(aa0 aa0Var, String str) {
        if (aa0Var == 0) {
            Log.w("DeviceFunctionConfigManager", "DeviceFunctionEvent 为空，无法保存配置");
            return;
        }
        if (pv2.f(str)) {
            Log.w("DeviceFunctionConfigManager", "MAC 地址为空，无法保存配置");
            return;
        }
        if (!zm1.J()) {
            Log.d("DeviceFunctionConfigManager", "BadgeOK 未识别，设备配置信息不可用，跳过保存，MAC: " + str);
            return;
        }
        try {
            String strReplaceAll = str.replaceAll(":", Constants.STR_EMPTY);
            DeviceFunctionConfigModel deviceFunctionConfigModel = (DeviceFunctionConfigModel) DBHelper.getDaoSession().getDeviceFunctionConfigModelDao().queryBuilder().r(DeviceFunctionConfigModelDao.Properties.DeviceMac.b(strReplaceAll), new gi3[0]).q();
            if (deviceFunctionConfigModel == null) {
                deviceFunctionConfigModel = new DeviceFunctionConfigModel();
                deviceFunctionConfigModel.setDeviceMac(strReplaceAll);
            }
            deviceFunctionConfigModel.setUpdateTime(Long.valueOf(System.currentTimeMillis()));
            deviceFunctionConfigModel.setIsShowOta(Boolean.valueOf(aa0Var.w()));
            deviceFunctionConfigModel.setIsShowBattery(Boolean.valueOf(aa0Var.l()));
            deviceFunctionConfigModel.setIsShowHeart(Boolean.valueOf(aa0Var.s()));
            deviceFunctionConfigModel.setIsShowBlood(Boolean.valueOf(aa0Var.n()));
            deviceFunctionConfigModel.setIsShowSpo(Boolean.valueOf(aa0Var.A()));
            deviceFunctionConfigModel.setIsShowSleep(Boolean.valueOf(aa0Var.z()));
            deviceFunctionConfigModel.setIsShowDistance(Boolean.valueOf(aa0Var.p()));
            deviceFunctionConfigModel.setIsShowWxsport(Boolean.valueOf(aa0Var.F()));
            deviceFunctionConfigModel.setIsShowVoice(Boolean.valueOf(aa0Var.D()));
            deviceFunctionConfigModel.setIsShowSyncontract(Boolean.valueOf(aa0Var.B()));
            deviceFunctionConfigModel.setIsShowTemp(Boolean.valueOf(aa0Var.C()));
            deviceFunctionConfigModel.setIsShowWeather(Boolean.valueOf((boolean) aa0Var.invokeMethod("DeviceFunctionConfigManager", "DeviceFunctionConfigManager")));
            deviceFunctionConfigModel.setIsShowClockDial(Boolean.valueOf(aa0Var.o()));
            deviceFunctionConfigModel.setIsShowMoreNotifi(Boolean.valueOf(aa0Var.v()));
            deviceFunctionConfigModel.setIsShowAdv(Boolean.valueOf(aa0Var.k()));
            deviceFunctionConfigModel.setIsShowRemoteCamera(Boolean.valueOf(aa0Var.x()));
            deviceFunctionConfigModel.setIsShowFindDevice(Boolean.valueOf(aa0Var.r()));
            deviceFunctionConfigModel.setIsShowHrEl(Boolean.valueOf(aa0Var.t()));
            deviceFunctionConfigModel.setIsShowLongDurationTime(Boolean.valueOf(aa0Var.u()));
            deviceFunctionConfigModel.setIsShowDisturbMode(Boolean.valueOf(aa0Var.q()));
            deviceFunctionConfigModel.setIsShowShakeMode(Boolean.valueOf(aa0Var.y()));
            deviceFunctionConfigModel.setIsShowBatteryPercentage(Boolean.valueOf(aa0Var.m()));
            deviceFunctionConfigModel.setIsSupportOfBodyGame(Boolean.valueOf(aa0Var.H()));
            deviceFunctionConfigModel.setIsSupportOfGestureControl(Boolean.valueOf(aa0Var.J()));
            deviceFunctionConfigModel.setIsSupportOfIMEI(Boolean.valueOf(aa0Var.K()));
            deviceFunctionConfigModel.setIsSupportOfExercise(Boolean.valueOf(aa0Var.I()));
            deviceFunctionConfigModel.setIsSupportOfArmRemoval(Boolean.valueOf(aa0Var.G()));
            deviceFunctionConfigModel.setIsSupportSleepEyeMovement(Boolean.valueOf(aa0Var.N()));
            deviceFunctionConfigModel.setIsSupportPaymentQRCode(Boolean.valueOf(aa0Var.L()));
            deviceFunctionConfigModel.setIsSupportRealTimeAlbumPreview(Boolean.valueOf(aa0Var.M()));
            deviceFunctionConfigModel.setIsCloseTempUnite(Boolean.valueOf(aa0Var.i()));
            deviceFunctionConfigModel.setIsCloseDrinkWarn(Boolean.valueOf(aa0Var.a()));
            deviceFunctionConfigModel.setIsTurnOff(Boolean.valueOf(aa0Var.O()));
            deviceFunctionConfigModel.setIsCloseNotification(Boolean.valueOf(aa0Var.c()));
            deviceFunctionConfigModel.setIsCloseEmergencyContact(Boolean.valueOf(aa0Var.b()));
            deviceFunctionConfigModel.setIsCloseRestingHeartRate(Boolean.valueOf(aa0Var.e()));
            deviceFunctionConfigModel.setIsClosePinchToAnswer(Boolean.valueOf(aa0Var.d()));
            deviceFunctionConfigModel.setIsCloseShakeToReject(Boolean.valueOf(aa0Var.g()));
            deviceFunctionConfigModel.setIsCloseShakeToSwitchVideo(Boolean.valueOf(aa0Var.h()));
            deviceFunctionConfigModel.setIsCloseShakeMusicToggle(Boolean.valueOf(aa0Var.f()));
            deviceFunctionConfigModel.setIsDefaultOpenCall(Boolean.valueOf(aa0Var.j()));
            DBHelper.getDaoSession().getDeviceFunctionConfigModelDao().insertOrReplace(deviceFunctionConfigModel);
            Log.i("DeviceFunctionConfigManager", "设备功能配置已保存，MAC: " + strReplaceAll);
        } catch (Exception e) {
            Log.e("DeviceFunctionConfigManager", "保存设备功能配置失败: " + e.getMessage(), e);
        }
    }
}
