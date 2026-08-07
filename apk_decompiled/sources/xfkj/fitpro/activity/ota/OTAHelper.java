package xfkj.fitpro.activity.ota;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.g;
import com.blankj.utilcode.util.r;
import com.blankj.utilcode.util.s;
import com.tencent.connect.common.Constants;
import defpackage.eh2;
import defpackage.eq;
import defpackage.fh2;
import defpackage.gq;
import defpackage.pv2;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import xfkj.fitpro.activity.ota.OTAHelper;
import xfkj.fitpro.activity.ota.api.HttpHelper;
import xfkj.fitpro.activity.ota.enu.OTAUpdateState;
import xfkj.fitpro.activity.ota.event.OTAUpgradeEvent;
import xfkj.fitpro.activity.ota.manager.OTASDKManager;
import xfkj.fitpro.activity.ota.model.OTAInfo;
import xfkj.fitpro.activity.ota.model.OTAUpgradeInfo;
import xfkj.fitpro.activity.ota.service.TelinkOtaUpgradeService;
import xfkj.fitpro.activity.ota.utils.DownloadMannager;
import xfkj.fitpro.activity.ota.utils.EventBusUtils;
import xfkj.fitpro.activity.ota.utils.MySPUtils;
import xfkj.fitpro.activity.ota.utils.OTAPathUtils;

/* JADX INFO: loaded from: classes4.dex */
public class OTAHelper {
    private static final String TAG = "OTAHelper";
    private static boolean mScanOfOTAMode = false;

    /* JADX INFO: renamed from: xfkj.fitpro.activity.ota.OTAHelper$1, reason: invalid class name */
    class AnonymousClass1 implements gq {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ OTAInfo val$hardInfo;
        final /* synthetic */ boolean val$isJumpException;

        AnonymousClass1(boolean z, Activity activity, OTAInfo oTAInfo) {
            this.val$isJumpException = z;
            this.val$activity = activity;
            this.val$hardInfo = oTAInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onResponse$0(OTAUpgradeInfo oTAUpgradeInfo, boolean z, Activity activity, OTAInfo oTAInfo) {
            OTADialogHelper.hideDialog();
            if (oTAUpgradeInfo == null || !oTAUpgradeInfo.isSuccess()) {
                ToastUtils.t(R.string.loading_failed);
            } else if (z || !OTAProxyUtils.checkOTAUpgradeStatus((AppCompatActivity) activity, oTAInfo)) {
                OTAHelper.findOTANewVersion(activity, oTAUpgradeInfo);
            } else {
                Log.e(OTAHelper.TAG, "Check OTA exception");
            }
        }

        @Override // defpackage.gq
        public void onFailure(eq eqVar, IOException iOException) {
            OTADialogHelper.hideDialog();
            ToastUtils.u(iOException.getMessage());
        }

        @Override // defpackage.gq
        public void onResponse(eq eqVar, eh2 eh2Var) throws IOException {
            fh2 fh2VarN = eh2Var.n();
            final OTAUpgradeInfo oTAUpgradeInfoObjectFromData = OTAUpgradeInfo.objectFromData(fh2VarN.string());
            fh2VarN.close();
            final boolean z = this.val$isJumpException;
            final Activity activity = this.val$activity;
            final OTAInfo oTAInfo = this.val$hardInfo;
            r.c(new Runnable() { // from class: xfkj.fitpro.activity.ota.b
                @Override // java.lang.Runnable
                public final void run() {
                    OTAHelper.AnonymousClass1.lambda$onResponse$0(oTAUpgradeInfoObjectFromData, z, activity, oTAInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void OTADownloadFinish(OTAUpgradeInfo.DataBean dataBean) {
        OTADialogHelper.hideDialog();
        int type = dataBean.getType();
        String str = Constants.STR_EMPTY;
        if (type == 3 || type == 4) {
            EventBusUtils.post(new OTAUpgradeEvent(Constants.STR_EMPTY));
            return;
        }
        for (File file : g.s(OTAPathUtils.getOTADir())) {
            String name = file.getName();
            if (name != null && name.toLowerCase(Locale.ROOT).contains("app")) {
                String absolutePath = file.getAbsolutePath();
                if (!pv2.h(str)) {
                    absolutePath = str + "," + absolutePath;
                }
                str = absolutePath;
            }
        }
        if (pv2.h(str)) {
            return;
        }
        EventBusUtils.post(new OTAUpgradeEvent(str));
    }

    public static void checkAndGotoOTA(AppCompatActivity appCompatActivity) {
        OTAInfo oTAInfo = OTASDKManager.getInstance().getOTAInfo();
        if (oTAInfo == null) {
            Log.e(TAG, "OTAInfo为空，无法进入OTA模式");
            ToastUtils.u("设备信息未初始化");
            return;
        }
        String oTAFilePath = MySPUtils.getOTAFilePath(oTAInfo.getDeviceId());
        String[] strArrSplit = oTAFilePath.split(",");
        if (strArrSplit.length == 1 && g.p(strArrSplit[0])) {
            showLowBatteryTips(appCompatActivity, oTAFilePath, oTAInfo);
        } else if (strArrSplit.length == 2 && g.p(strArrSplit[0]) && g.p(strArrSplit[1])) {
            showLowBatteryTips(appCompatActivity, oTAFilePath, oTAInfo);
        } else {
            checkUpgrade(appCompatActivity, true);
        }
    }

    public static void checkUpgrade(Activity activity) {
        checkUpgrade(activity, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void findOTANewVersion(final Activity activity, OTAUpgradeInfo oTAUpgradeInfo) {
        final OTAUpgradeInfo.DataBean data = oTAUpgradeInfo.getData();
        if (data == null) {
            ToastUtils.t(R.string.last_version_not_upgrade);
            OTADialogHelper.hideDialog();
            return;
        }
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(activity);
        aVar.s(R.string.upgrade_txt);
        aVar.d(false);
        aVar.o(R.string.update, new DialogInterface.OnClickListener() { // from class: vs1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                OTAHelper.lambda$findOTANewVersion$0(data, activity, dialogInterface, i);
            }
        });
        aVar.k(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ws1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aVar.v();
    }

    private static String getCurrentDownloadUrl(OTAUpgradeInfo.DataBean dataBean) {
        return !pv2.h(dataBean.getApp_down_url()) ? dataBean.getApp_down_url() : dataBean.getAppDownUrl4g();
    }

    private static String getString(int i) {
        return pv2.d(i);
    }

    public static boolean isExceptionOTAUpgrade() {
        OTAInfo oTAInfo = OTASDKManager.getInstance().getOTAInfo();
        if (oTAInfo != null) {
            return MySPUtils.getOTAUpDateState(oTAInfo.getDeviceId()) == OTAUpdateState.OTA_UPDATE_ING.getOrdinal() && !pv2.h(oTAInfo.getDeviceId());
        }
        Log.e(TAG, "OTAInfo为空，无法检查异常升级状态");
        return false;
    }

    public static boolean isScanOfOTAMode() {
        return mScanOfOTAMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$findOTANewVersion$0(OTAUpgradeInfo.DataBean dataBean, Activity activity, DialogInterface dialogInterface, int i) {
        dataBean.setCurrentDownloadUrl(getCurrentDownloadUrl(dataBean));
        startDownloadOTAFile(activity, dataBean, (pv2.h(dataBean.getAppDownUrl4g()) || pv2.h(dataBean.getApp_down_url())) ? false : true);
    }

    public static void setScanOfOTAMode(boolean z) {
        mScanOfOTAMode = z;
    }

    public static void showLowBatteryTips(AppCompatActivity appCompatActivity, String str, OTAInfo oTAInfo) {
        if (oTAInfo == null && (oTAInfo = OTASDKManager.getInstance().getOTAInfo()) == null) {
            Log.e(TAG, "OTAInfo为空，无法显示低电量提示");
            ToastUtils.u("设备信息未初始化");
            return;
        }
        int plarmType = oTAInfo.getPlarmType();
        Log.i(TAG, "showLowBatteryTips: 低电量提示，设备类型：" + plarmType);
        if (plarmType != 1) {
            Log.i(TAG, "showLowBatteryTips: 低电量提示，非Telink设备");
            OTAProxyUtils.startOTAPage(appCompatActivity, str, oTAInfo);
            return;
        }
        Log.i(TAG, "showLowBatteryTips: 低电量提示，Telink设备");
        Intent intent = new Intent(appCompatActivity, (Class<?>) TelinkOtaUpgradeService.class);
        intent.putExtra("path", str);
        intent.putExtra("isforce", false);
        appCompatActivity.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startDownloadOTAFile(final Activity activity, final OTAUpgradeInfo.DataBean dataBean, final boolean z) {
        DownloadMannager downloadMannager = new DownloadMannager();
        downloadMannager.setDownLoadListener(new DownloadMannager.DownLoadListener() { // from class: xfkj.fitpro.activity.ota.OTAHelper.2
            @Override // xfkj.fitpro.activity.ota.utils.DownloadMannager.DownLoadListener
            public void onFailed(String str) {
                OTADialogHelper.hideDialog();
            }

            @Override // xfkj.fitpro.activity.ota.utils.DownloadMannager.DownLoadListener
            public void onStartDownload() {
                OTADialogHelper.showLoadDialog(activity);
            }

            @Override // xfkj.fitpro.activity.ota.utils.DownloadMannager.DownLoadListener
            public void onSuccess(String str, String str2) {
                try {
                    Log.i(OTAHelper.TAG, "startDownloadOTAFile:" + str);
                    s.b(str, OTAPathUtils.getOTADir());
                    g.f(str);
                    if (z) {
                        OTAUpgradeInfo.DataBean dataBean2 = dataBean;
                        dataBean2.setCurrentDownloadUrl(dataBean2.getAppDownUrl4g());
                        dataBean.setDisplay_name("4g");
                        OTAHelper.startDownloadOTAFile(activity, dataBean, false);
                    } else {
                        OTAHelper.OTADownloadFinish(dataBean);
                    }
                } catch (Exception e) {
                    Log.e(OTAHelper.TAG, "startDownloadOTAFile:" + e);
                }
            }
        });
        String currentDownloadUrl = dataBean.getCurrentDownloadUrl();
        Log.e(TAG, "startDownloadOTAFile url:" + currentDownloadUrl);
        downloadMannager.startDownLoad(currentDownloadUrl, OTAPathUtils.getOTADir() + File.separator + dataBean.getDisplay_name() + ".zip");
    }

    public static void checkUpgrade(Activity activity, boolean z) {
        OTAInfo oTAInfo = OTASDKManager.getInstance().getOTAInfo();
        if (oTAInfo == null) {
            Log.e(TAG, "OTAInfo为空，无法检查升级");
            ToastUtils.u("设备信息未初始化");
        } else {
            OTADialogHelper.showDialog(activity, activity.getString(R.string.check_upgrade));
            HttpHelper.getInstance().getOTAUpgradeInfo(new AnonymousClass1(z, activity, oTAInfo));
        }
    }
}
