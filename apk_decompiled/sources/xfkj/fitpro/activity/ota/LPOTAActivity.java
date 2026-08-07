package xfkj.fitpro.activity.ota;

import com.phy.ota_demo.ui.LPScanActivity;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LPOTAActivity extends LPScanActivity {
    @Override // com.phy.ota_demo.ui.LPScanActivity
    protected String getMacAddress() {
        return OTAProxyUtils.getmOtaInfo().getDeviceId();
    }

    @Override // com.phy.ota_demo.ui.LPScanActivity
    protected String getPath() {
        return getIntent().getStringExtra("path");
    }

    @Override // defpackage.t02
    public /* bridge */ /* synthetic */ void onBatchScanResults(List list) {
        super.onBatchScanResults(list);
    }

    @Override // defpackage.t02
    public /* bridge */ /* synthetic */ void onScanFailed(String str) {
        super.onScanFailed(str);
    }
}
