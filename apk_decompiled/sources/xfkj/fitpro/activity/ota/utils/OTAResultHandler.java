package xfkj.fitpro.activity.ota.utils;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.ToastUtils;
import defpackage.a4;
import defpackage.ar0;
import defpackage.e4;
import defpackage.f4;
import defpackage.p31;
import defpackage.yq0;
import xfkj.fitpro.activity.ota.constant.Constant;
import xfkj.fitpro.activity.ota.enu.OTAUpdateState;
import xfkj.fitpro.activity.ota.manager.OTASDKManager;
import xfkj.fitpro.activity.ota.model.OTAInfo;
import xfkj.fitpro.activity.ota.utils.OTAResultHandler;

/* JADX INFO: loaded from: classes4.dex */
public final class OTAResultHandler {
    private static final String TAG = "OTAResultHandler";
    private static f4 otaResultLauncher;
    public static final OTAResultHandler INSTANCE = new OTAResultHandler();
    private static boolean autoResetState = true;

    private OTAResultHandler() {
    }

    public static final void forceResetAllOTAState() {
        try {
            OTASDKManager.getInstance().resetOtaState();
            OTASDKManager.getInstance().reset();
            Log.i(TAG, "已强制重置所有 OTA 相关状态");
        } catch (Exception e) {
            Log.e(TAG, "强制重置 OTA 状态时发生异常", e);
        }
    }

    private final void handleOTACancel(Activity activity) {
        try {
            Log.i(TAG, "OTA 升级取消处理完成");
        } catch (Exception e) {
            Log.e(TAG, "处理 OTA 升级取消时发生异常", e);
        }
    }

    private final void handleOTAFailed(Activity activity) {
        try {
            ToastUtils.v("OTA 升级失败", new Object[0]);
            Log.i(TAG, "OTA 升级失败处理完成");
        } catch (Exception e) {
            Log.e(TAG, "处理 OTA 升级失败时发生异常", e);
        }
    }

    public static final void handleOTAResult(int i, int i2, Intent intent, Activity activity, yq0 yq0Var, ar0 ar0Var, yq0 yq0Var2) {
        p31.f(activity, "activity");
        if (i != 2001) {
            return;
        }
        Log.i(TAG, "处理 OTA 返回结果: requestCode=" + i + ", resultCode=" + i2);
        if (i2 == -1) {
            Log.i(TAG, "OTA 升级成功");
            INSTANCE.handleOTASuccess(activity);
            if (yq0Var != null) {
                yq0Var.invoke();
            }
            if (autoResetState) {
                resetOTAState();
                return;
            }
            return;
        }
        if (i2 == 0) {
            Log.i(TAG, "OTA 升级被取消");
            INSTANCE.handleOTACancel(activity);
            if (yq0Var2 != null) {
                yq0Var2.invoke();
            }
            if (autoResetState) {
                resetOTAState();
                return;
            }
            return;
        }
        if (i2 == 1) {
            Log.w(TAG, "OTA 升级失败");
            INSTANCE.handleOTAFailed(activity);
            if (ar0Var != null) {
                ar0Var.invoke("OTA 升级失败");
            }
            if (autoResetState) {
                resetOTAState();
                return;
            }
            return;
        }
        Log.w(TAG, "未知的 OTA 返回码: " + i2);
        INSTANCE.handleOTAUnknown(activity, i2);
        if (autoResetState) {
            resetOTAState();
        }
    }

    private final void handleOTASuccess(Activity activity) {
        try {
            ToastUtils.v("OTA 升级成功", new Object[0]);
            Log.i(TAG, "OTA 升级成功处理完成");
        } catch (Exception e) {
            Log.e(TAG, "处理 OTA 升级成功时发生异常", e);
        }
    }

    private final void handleOTAUnknown(Activity activity, int i) {
        try {
            Log.w(TAG, "处理未知的 OTA 返回码: " + i);
        } catch (Exception e) {
            Log.e(TAG, "处理未知 OTA 返回码时发生异常", e);
        }
    }

    public static final boolean isAutoResetState() {
        return autoResetState;
    }

    public static final boolean isOTAUpgrading() {
        try {
            OTAInfo oTAInfo = OTASDKManager.getInstance().getOTAInfo();
            if (oTAInfo == null) {
                return false;
            }
            String deviceId = oTAInfo.getDeviceId();
            return deviceId.length() > 0 && MySPUtils.getOTAUpDateState(deviceId) == OTAUpdateState.OTA_UPDATE_ING.getOrdinal();
        } catch (Exception e) {
            Log.e(TAG, "检查 OTA 升级状态时发生异常", e);
            return false;
        }
    }

    public static final boolean launchOTAActivity(Intent intent) {
        p31.f(intent, "intent");
        boolean z = false;
        try {
            f4 f4Var = otaResultLauncher;
            if (f4Var != null) {
                p31.c(f4Var);
                f4Var.a(intent);
                z = true;
            } else {
                Log.e(TAG, "OTA 结果监听器未注册，无法启动 OTA Activity");
            }
        } catch (Exception e) {
            Log.e(TAG, "启动 OTA Activity 时发生异常", e);
        }
        return z;
    }

    public static final void registerOTAResultLauncher(final AppCompatActivity appCompatActivity, final yq0 yq0Var, final ar0 ar0Var, final yq0 yq0Var2) {
        p31.f(appCompatActivity, "activity");
        if (otaResultLauncher != null) {
            Log.w(TAG, "OTA 结果监听器已经注册，先注销旧的");
            unregisterOTAResultLauncher();
        }
        otaResultLauncher = appCompatActivity.registerForActivityResult(new e4(), new a4() { // from class: bt1
            @Override // defpackage.a4
            public final void a(Object obj) {
                OTAResultHandler.registerOTAResultLauncher$lambda$0(appCompatActivity, yq0Var, ar0Var, yq0Var2, (ActivityResult) obj);
            }
        });
        Log.i(TAG, "已注册 OTA Activity 结果监听器");
    }

    public static /* synthetic */ void registerOTAResultLauncher$default(AppCompatActivity appCompatActivity, yq0 yq0Var, ar0 ar0Var, yq0 yq0Var2, int i, Object obj) {
        if ((i & 2) != 0) {
            yq0Var = null;
        }
        if ((i & 4) != 0) {
            ar0Var = null;
        }
        if ((i & 8) != 0) {
            yq0Var2 = null;
        }
        registerOTAResultLauncher(appCompatActivity, yq0Var, ar0Var, yq0Var2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerOTAResultLauncher$lambda$0(AppCompatActivity appCompatActivity, yq0 yq0Var, ar0 ar0Var, yq0 yq0Var2, ActivityResult activityResult) {
        p31.f(activityResult, "result");
        Log.i(TAG, "收到 OTA Activity 返回结果: resultCode=" + activityResult.b());
        handleOTAResult(Constant.REQUEST_CODE_OTA, activityResult.b(), activityResult.a(), appCompatActivity, yq0Var, ar0Var, yq0Var2);
    }

    public static final void resetOTAState() {
        try {
            OTAInfo oTAInfo = OTASDKManager.getInstance().getOTAInfo();
            if (oTAInfo != null) {
                String deviceId = oTAInfo.getDeviceId();
                if (deviceId.length() > 0) {
                    MySPUtils.putOTAUpDateState(OTAUpdateState.OTA_UPDATE_NOT_BEING);
                    Log.i(TAG, "已重置设备 " + deviceId + " 的 OTA 升级状态");
                }
            }
            OTASDKManager.getInstance().resetOtaState();
            Log.i(TAG, "已重置 OTA SDK 状态");
        } catch (Exception e) {
            Log.e(TAG, "重置 OTA 状态时发生异常", e);
        }
    }

    public static final void setAutoResetState(boolean z) {
        autoResetState = z;
        Log.i(TAG, "设置自动重置 OTA 状态: " + z);
    }

    public static final void unregisterOTAResultLauncher() {
        otaResultLauncher = null;
        Log.i(TAG, "已注销 OTA Activity 结果监听器");
    }
}
