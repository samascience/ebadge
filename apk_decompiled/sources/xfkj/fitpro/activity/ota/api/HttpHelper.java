package xfkj.fitpro.activity.ota.api;

import android.net.Uri;
import android.util.Log;
import defpackage.df2;
import defpackage.gq;
import defpackage.pv2;
import defpackage.zt1;
import java.io.IOException;
import xfkj.fitpro.activity.ota.manager.OTASDKManager;
import xfkj.fitpro.activity.ota.model.OTAInfo;

/* JADX INFO: loaded from: classes4.dex */
public class HttpHelper {
    private static final String TOKEN = "Bearer 6fcb7f58475b4e5aad8f0f1cadce235e";
    private static HttpHelper instance;
    private final String TAG = HttpHelper.class.getSimpleName();

    public static HttpHelper getInstance() {
        if (instance == null) {
            instance = new HttpHelper();
        }
        return instance;
    }

    public void getOTAUpgradeInfo(gq gqVar) {
        OTAInfo oTAInfo = OTASDKManager.getInstance().getOTAInfo();
        if (oTAInfo == null) {
            Log.e(this.TAG, "OTAInfo为空，无法获取升级信息");
            gqVar.onFailure(null, new IOException("OTAInfo为空"));
            return;
        }
        String bluetoothName = oTAInfo.getBluetoothName();
        String softVersion = oTAInfo.getSoftVersion();
        zt1 okHttpClient = NetWorkManager.getInstance().getOkHttpClient();
        df2.a aVar = new df2.a();
        aVar.a("authorization", Uri.decode(TOKEN));
        if (pv2.h(oTAInfo.getBluetoothName())) {
            Log.e(this.TAG, "name is empty");
            gqVar.onFailure(null, new IOException("蓝牙名称为空"));
            return;
        }
        String str = oTAInfo.getPlarmType() == 1 ? String.format("https://tomato.gulaike.com/api/v1/config/app?name=%1$s&type=1&version=%2$s", bluetoothName, softVersion) : String.format("https://tomato.gulaike.com/api/v1/config/app?name=%1$s&type=1&version=%2$s", bluetoothName, softVersion);
        Log.e(this.TAG, "softVersionUrl:" + str);
        if (pv2.h(str)) {
            Log.e(this.TAG, "softVersionUrl is empty");
            gqVar.onFailure(null, new IOException("升级URL为空"));
        } else {
            aVar.m(str);
            okHttpClient.a(aVar.b()).n(gqVar);
        }
    }
}
