package xfkj.fitpro.application;

import android.content.Context;
import android.content.Intent;
import com.blankj.utilcode.util.c;
import com.iwellfitness.urllib.ManualUrlConfig;
import com.iwellfitness.urllib.OpenUrlRequest;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.Tencent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import defpackage.hg;
import defpackage.k00;
import defpackage.xx0;
import xfkj.fitpro.application.MyApplication;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.AppInstructionsActivity;

/* JADX INFO: loaded from: classes4.dex */
public class MyApplication extends hg implements xx0 {
    private void G() {
        UMConfigure.preInit(this, getString(R.string.umeng_key_value), c.d());
        UMConfigure.submitPolicyGrantResult(getApplicationContext(), true);
        UMConfigure.init(hg.l(), getString(R.string.umeng_key_value), c.d(), 1, Constants.STR_EMPTY);
        UMConfigure.setLogEnabled(true);
        PlatformConfig.setWeixin(getString(R.string.wx_appid), getString(R.string.wx_secreid));
        PlatformConfig.setQQZone(getString(R.string.qq_appid), getString(R.string.qq_app_key));
        String str = c.f() + ".fileprovider";
        PlatformConfig.setQQFileProvider(str);
        PlatformConfig.setSinaFileProvider(str);
        PlatformConfig.setWXFileProvider(str);
        Tencent.setIsPermissionGranted(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(Context context, OpenUrlRequest openUrlRequest) {
        String url = openUrlRequest.getUrl();
        if (url == null || url.isEmpty()) {
            return;
        }
        String title = openUrlRequest.getTitle();
        Intent intent = new Intent(context, (Class<?>) AppInstructionsActivity.class);
        intent.putExtra(SocialConstants.PARAM_URL, url);
        if (title != null && !title.isEmpty()) {
            intent.putExtra("title", title);
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // defpackage.hg
    protected void y() {
        if (!k00.e()) {
            CrashReport.initCrashReport(getApplicationContext(), "4c7bf383ee", false);
            G();
        }
        super.u();
        ManualUrlConfig.setOpenUrlListener(new ManualUrlConfig.OnOpenUrlListener() { // from class: qm1
            @Override // com.iwellfitness.urllib.ManualUrlConfig.OnOpenUrlListener
            public final void onOpenUrl(Context context, OpenUrlRequest openUrlRequest) {
                MyApplication.H(context, openUrlRequest);
            }
        });
    }
}
