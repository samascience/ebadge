package xfkj.fitpro.activity.ota;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.baji.protocol.model.ProtocolConstants;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.r;
import com.legend.mywatch.commonlib.CommonPromptDialog;
import defpackage.ar0;
import defpackage.p31;
import defpackage.pv2;
import defpackage.yq0;
import defpackage.zi2;
import java.util.Locale;
import kotlin.text.i;
import xfkj.fitpro.activity.ota.OTAProxyUtils;
import xfkj.fitpro.activity.ota.manager.OTASDKManager;
import xfkj.fitpro.activity.ota.model.OTAInfo;
import xfkj.fitpro.activity.ota.utils.BleUtils;
import xfkj.fitpro.activity.ota.utils.MySPUtils;
import xfkj.fitpro.activity.ota.utils.OTAResultHandler;

/* JADX INFO: loaded from: classes4.dex */
public final class OTAProxyUtils {
    public static final OTAProxyUtils INSTANCE = new OTAProxyUtils();
    private static final String TAG = "OTAProxyUtils";
    private static OTAInfo mOtaInfo;

    private OTAProxyUtils() {
    }

    public static final boolean checkOTAUpgradeStatus(final AppCompatActivity appCompatActivity, final OTAInfo oTAInfo) {
        p31.f(appCompatActivity, "activity");
        p31.f(oTAInfo, "hardInfo");
        if (!OTAHelper.isExceptionOTAUpgrade()) {
            return false;
        }
        Log.i(TAG, "checkOTAUpgradeStatus find new OTAUpdate");
        final CommonPromptDialog commonPromptDialog = new CommonPromptDialog(appCompatActivity.getString(R.string.ota_upgrade_is_interrupted));
        commonPromptDialog.U(new CommonPromptDialog.a() { // from class: zs1
            @Override // com.legend.mywatch.commonlib.CommonPromptDialog.a
            public final void a() {
                OTAProxyUtils.checkOTAUpgradeStatus$lambda$1(commonPromptDialog, appCompatActivity, oTAInfo);
            }
        });
        commonPromptDialog.M(appCompatActivity.getSupportFragmentManager(), "OTA dialog");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkOTAUpgradeStatus$lambda$1(CommonPromptDialog commonPromptDialog, AppCompatActivity appCompatActivity, OTAInfo oTAInfo) {
        commonPromptDialog.y();
        INSTANCE.handleOTAUpgradeException(appCompatActivity, oTAInfo);
    }

    public static final void forceResetAllOTAState() {
        Log.i(TAG, "强制重置所有 OTA 相关状态");
        OTAResultHandler.forceResetAllOTAState();
    }

    public static final OTAInfo getmOtaInfo() {
        return mOtaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleOTAUpgradeException$lambda$2(AppCompatActivity appCompatActivity) {
        OTADialogHelper.hideDialog();
        if (!zi2.i()) {
            INSTANCE.startOTAScanPage();
            return;
        }
        zi2.b();
        zi2.e().B();
        OTAHelper.checkAndGotoOTA(appCompatActivity);
    }

    public static final boolean isAutoResetState() {
        return OTAResultHandler.isAutoResetState();
    }

    public static final boolean isOTAUpgrading() {
        return OTAResultHandler.isOTAUpgrading();
    }

    public static final void registerOTAResultHandler(AppCompatActivity appCompatActivity, yq0 yq0Var, ar0 ar0Var, yq0 yq0Var2, boolean z) {
        p31.f(appCompatActivity, "activity");
        Log.i(TAG, "注册 OTA 结果监听器，自动重置状态: " + z);
        OTAResultHandler.setAutoResetState(z);
        OTAResultHandler.registerOTAResultLauncher(appCompatActivity, yq0Var, ar0Var, yq0Var2);
    }

    public static /* synthetic */ void registerOTAResultHandler$default(AppCompatActivity appCompatActivity, yq0 yq0Var, ar0 ar0Var, yq0 yq0Var2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            yq0Var = null;
        }
        if ((i & 4) != 0) {
            ar0Var = null;
        }
        if ((i & 8) != 0) {
            yq0Var2 = null;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        registerOTAResultHandler(appCompatActivity, yq0Var, ar0Var, yq0Var2, z);
    }

    public static final void resetOTAState(Activity activity) {
        p31.f(activity, "activity");
        Log.i(TAG, "重置 OTA 升级状态");
        OTAResultHandler.resetOTAState();
    }

    public static final void setAutoResetState(boolean z) {
        Log.i(TAG, "设置自动重置 OTA 状态: " + z);
        OTAResultHandler.setAutoResetState(z);
    }

    public static final void startOTAPage(final AppCompatActivity appCompatActivity, final String str, OTAInfo oTAInfo) {
        p31.f(appCompatActivity, "activity");
        p31.f(oTAInfo, "otaInfo");
        mOtaInfo = oTAInfo;
        OTASDKManager.getInstance().setOtaState();
        Log.i(TAG, "startOTAPage");
        int plarmType = oTAInfo.getPlarmType();
        if (plarmType != 7) {
            zi2.b();
            zi2.e().B();
            BleUtils.unPairLeDevice(oTAInfo.getDeviceId());
        }
        if (plarmType == 5) {
            BleUtils.unPairBRDevice(oTAInfo.getClassicBluetoothMac());
            BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(oTAInfo.getDeviceId());
            Intent intent = new Intent(appCompatActivity, (Class<?>) LyOTActivity.class);
            intent.putExtra("path", str);
            intent.putExtra("device", remoteDevice);
            OTAResultHandler.launchOTAActivity(intent);
            return;
        }
        if (plarmType == 6) {
            Intent intent2 = new Intent(appCompatActivity, (Class<?>) LPOTAActivity.class);
            intent2.putExtra("path", str);
            OTAResultHandler.launchOTAActivity(intent2);
        } else {
            if (plarmType != 7) {
                ToastUtils.v("No platform information was identified", new Object[0]);
                return;
            }
            if (INSTANCE.isFindGuiXinPath(oTAInfo) || !JliOTAActivity.isFindNetWorkOTAPath(str)) {
                Intent intent3 = new Intent(appCompatActivity, (Class<?>) JliOTAActivity.class);
                intent3.putExtra("path", str);
                OTAResultHandler.launchOTAActivity(intent3);
            } else {
                zi2.b();
                OTADialogHelper.showDialog(appCompatActivity, appCompatActivity.getString(R.string.connecting));
                zi2.a(oTAInfo.getDeviceId());
                r.d(new Runnable() { // from class: at1
                    @Override // java.lang.Runnable
                    public final void run() {
                        OTAProxyUtils.startOTAPage$lambda$0(appCompatActivity, str);
                    }
                }, ProtocolConstants.CONNECTION_TIMEOUT_MS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startOTAPage$lambda$0(AppCompatActivity appCompatActivity, String str) {
        OTADialogHelper.hideDialog();
        if (!zi2.i()) {
            ToastUtils.t(R.string.unconnected);
            return;
        }
        Intent intent = new Intent(appCompatActivity, (Class<?>) JliOTAActivity.class);
        intent.putExtra("path", str);
        OTAResultHandler.launchOTAActivity(intent);
    }

    public static final void unregisterOTAResultHandler() {
        Log.i(TAG, "注销 OTA 结果监听器");
        OTAResultHandler.unregisterOTAResultLauncher();
    }

    public final void handleOTAUpgradeException(final AppCompatActivity appCompatActivity, OTAInfo oTAInfo) {
        p31.f(appCompatActivity, "activity");
        p31.f(oTAInfo, "info");
        String deviceId = oTAInfo.getDeviceId();
        if (pv2.h(deviceId)) {
            startOTAScanPage();
        } else {
            if (zi2.i()) {
                OTAHelper.checkAndGotoOTA(appCompatActivity);
                return;
            }
            OTADialogHelper.showDialog((Context) appCompatActivity, appCompatActivity.getString(R.string.do_connecting_txt), false);
            zi2.a(deviceId);
            r.d(new Runnable() { // from class: ys1
                @Override // java.lang.Runnable
                public final void run() {
                    OTAProxyUtils.handleOTAUpgradeException$lambda$2(appCompatActivity);
                }
            }, 5000L);
        }
    }

    public final boolean isFindGuiXinPath(OTAInfo oTAInfo) {
        p31.f(oTAInfo, "info");
        String softVersion = oTAInfo.getSoftVersion();
        if (softVersion == null) {
            return false;
        }
        Locale locale = Locale.getDefault();
        p31.e(locale, "getDefault(...)");
        String lowerCase = softVersion.toLowerCase(locale);
        p31.e(lowerCase, "toLowerCase(...)");
        return i.M(lowerCase, "gx", false, 2, null) || JliOTAActivity.isFindNetWorkOTAPath(MySPUtils.getOTAFilePath(oTAInfo.getClassicBluetoothMac()));
    }

    public final void startOTAScanPage() {
        OTAHelper.setScanOfOTAMode(true);
    }
}
