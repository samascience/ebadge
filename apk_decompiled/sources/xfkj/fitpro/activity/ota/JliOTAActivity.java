package xfkj.fitpro.activity.ota;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.g;
import com.blankj.utilcode.util.r;
import com.jieli.OTAManager2;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;
import com.jieli.jl_rcsp.impl.NetworkOpImpl;
import com.jieli.jl_rcsp.interfaces.network.OnNetworkListener;
import com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkOTAState;
import com.jieli.jl_rcsp.model.network.OTAParam;
import defpackage.ks1;
import defpackage.pb0;
import defpackage.pv2;
import defpackage.qm2;
import defpackage.ug3;
import defpackage.zi2;
import java.util.Arrays;
import xfkj.fitpro.activity.ota.base.LeBaseActivity;
import xfkj.fitpro.activity.ota.base.NewBaseActivity;
import xfkj.fitpro.activity.ota.databinding.ActivityJliOtaactivityBinding;
import xfkj.fitpro.activity.ota.enu.OTAUpdateState;
import xfkj.fitpro.activity.ota.jieli.WatchManagerDemo;
import xfkj.fitpro.activity.ota.utils.BleUtils;
import xfkj.fitpro.activity.ota.utils.MySPUtils;

/* JADX INFO: loaded from: classes4.dex */
public class JliOTAActivity extends LeBaseActivity<ActivityJliOtaactivityBinding> {
    private String firmwarePath;
    private Runnable mDelayedErrorRunnable;
    private NetworkOpImpl mNetworkOp;
    private String[] mPathArray;
    private WatchManagerDemo mWatchManager;
    private String netWorkPath;
    private OTAManager2 otaManager;
    private boolean isInitFirmwareOTA = false;
    private boolean isInitNetWorkOTA = false;
    private Handler mHandler = new Handler();
    private final OnNetworkListener mOnNetworkListener = new OnNetworkListener() { // from class: xfkj.fitpro.activity.ota.JliOTAActivity.3
        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkListener
        public void onNetworkInfo(BluetoothDevice bluetoothDevice, NetworkInfo networkInfo) {
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkListener
        public void onNetworkOTAState(BluetoothDevice bluetoothDevice, NetworkOTAState networkOTAState) {
        }
    };

    /* JADX INFO: renamed from: xfkj.fitpro.activity.ota.JliOTAActivity$1, reason: invalid class name */
    class AnonymousClass1 extends BtEventCallback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnection$0(int i) {
            if (com.blankj.utilcode.util.a.j(((NewBaseActivity) JliOTAActivity.this).mContext)) {
                JliOTAActivity.this.OTAError(" connect ota failed status:" + i);
            }
        }

        @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
        public void onConnection(BluetoothDevice bluetoothDevice, final int i) {
            if (!JliOTAActivity.getDeviceAddress().equals(bluetoothDevice.getAddress())) {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "onConnection: not this device");
                return;
            }
            Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "onConnection:" + i);
            if (i == 1) {
                JliOTAActivity.this.stopDelayError();
                if (JliOTAActivity.this.otaManager.isOTA()) {
                    return;
                }
                JliOTAActivity.this.otaManager.queryMandatoryUpdate(new IActionCallback<TargetInfoResponse>() { // from class: xfkj.fitpro.activity.ota.JliOTAActivity.1.1
                    @Override // com.jieli.jl_bt_ota.interfaces.IActionCallback
                    public void onError(BaseError baseError) {
                        if (baseError.getCode() == 0 && baseError.getSubCode() == 0) {
                            TargetInfoResponse deviceInfo = JliOTAActivity.this.otaManager.getDeviceInfo();
                            deviceInfo.getVersionCode();
                            deviceInfo.getVersionName();
                            deviceInfo.getProjectCode();
                            deviceInfo.getUid();
                            deviceInfo.getPid();
                        }
                    }

                    @Override // com.jieli.jl_bt_ota.interfaces.IActionCallback
                    public void onSuccess(TargetInfoResponse targetInfoResponse) {
                        targetInfoResponse.getVersionCode();
                        targetInfoResponse.getVersionName();
                        targetInfoResponse.getProjectCode();
                        targetInfoResponse.getUid();
                        targetInfoResponse.getPid();
                    }
                });
                JliOTAActivity.this.otaManager.getBluetoothOption().setFirmwareFilePath(JliOTAActivity.this.firmwarePath);
                JliOTAActivity.this.startFirmwareOTA();
                return;
            }
            if (i == 0 || i == 2) {
                JliOTAActivity.this.stopDelayError();
                JliOTAActivity.this.mDelayedErrorRunnable = new Runnable() { // from class: xfkj.fitpro.activity.ota.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.lambda$onConnection$0(i);
                    }
                };
                JliOTAActivity.this.mHandler.postDelayed(JliOTAActivity.this.mDelayedErrorRunnable, ProtocolConstants.CONNECTION_TIMEOUT_MS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OTAError(String str) {
        setResult(1);
        ToastUtils.s(str);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OTAFinish() {
        MySPUtils.putOTAUpDateState(OTAUpdateState.OTA_UPDATE_NOT_BEING);
        setResult(-1);
        ToastUtils.t(R.string.upgrade_success);
        finish();
    }

    private void connectOTA() {
        BluetoothDevice bluetoothDeviceByMac = BleUtils.getBluetoothDeviceByMac(getDeviceAddress());
        Log.i(this.TAG, "startFirmwareOTA:" + bluetoothDeviceByMac.getAddress());
        this.otaManager.connectBluetoothDevice(bluetoothDeviceByMac);
    }

    private String findFirmwareOTAPath() {
        for (String str : this.mPathArray) {
            if (!isNetWorkOTA(str)) {
                return str;
            }
        }
        return null;
    }

    public static String findNetWorkOTAPath(String[] strArr) {
        for (String str : strArr) {
            if (isNetWorkOTA(str)) {
                return str;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBleMac() {
        return getDeviceAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDeviceAddress() {
        return ug3.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFirmwareOTA() {
        if (!this.isInitFirmwareOTA) {
            Log.i(this.TAG, "initFirmwareOTA");
            this.isInitFirmwareOTA = true;
            BleUtils.unPairLeDevice(getDeviceAddress());
            zi2.b();
            zi2.e().B();
            this.otaManager = new OTAManager2(getApplicationContext());
            BluetoothOTAConfigure bluetoothOTAConfigureCreateDefault = BluetoothOTAConfigure.createDefault();
            bluetoothOTAConfigureCreateDefault.setPriority(0).setUseAuthDevice(true).setBleIntervalMs(500).setTimeoutMs(3000).setMtu(500).setNeedChangeMtu(false).setUseReconnect(false);
            bluetoothOTAConfigureCreateDefault.setFirmwareFilePath(this.firmwarePath);
            this.otaManager.configure(bluetoothOTAConfigureCreateDefault);
            this.otaManager.registerBluetoothCallback(new AnonymousClass1());
        }
        r.d(new Runnable() { // from class: u41
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$initFirmwareOTA$1();
            }
        }, 1000L);
    }

    private void initNetWorkOTA() {
        if (!this.isInitNetWorkOTA) {
            Log.i(this.TAG, "initNetWorkOTA");
            this.isInitNetWorkOTA = true;
            WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
            this.mWatchManager = watchManagerDemo;
            NetworkOpImpl networkOpImplInstance = NetworkOpImpl.instance(watchManagerDemo);
            this.mNetworkOp = networkOpImplInstance;
            networkOpImplInstance.addOnNetworkListener(this.mOnNetworkListener);
        }
        startNetworkOta(this.netWorkPath);
    }

    public static boolean isFindNetWorkOTAPath(String str) {
        return (pv2.h(str) || findNetWorkOTAPath(str.split(",")) == null) ? false : true;
    }

    public static boolean isNetWorkOTA(String str) {
        return str.endsWith("diff");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0() {
        if (com.blankj.utilcode.util.a.j(this.mContext)) {
            initFirmwareOTA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFirmwareOTA$1() {
        if (com.blankj.utilcode.util.a.j(this.mContext)) {
            connectOTA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackPressed$2(DialogInterface dialogInterface, int i) {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOTAProgress(float f) {
        ((ActivityJliOtaactivityBinding) this.binding).tvUpgrade.setText(getString(R.string.upgradding) + ks1.n(f, 2) + "%");
        ((ActivityJliOtaactivityBinding) this.binding).progressBar.setProgress((int) f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFirmwareOTA() {
        this.otaManager.startOTA(new IUpgradeCallback() { // from class: xfkj.fitpro.activity.ota.JliOTAActivity.2
            @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
            public void onCancelOTA() {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "onCancelOTA");
            }

            @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
            public void onError(BaseError baseError) {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "BaseError:" + baseError);
                JliOTAActivity.this.OTAError(baseError.getMessage());
            }

            @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
            public void onNeedReconnect(String str, boolean z) {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "onNeedReconnect addr:" + str);
                JliOTAActivity.this.otaManager.getBluetoothOption().isUseReconnect();
            }

            @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
            public void onProgress(int i, float f) {
                JliOTAActivity.this.showOTAProgress(f);
            }

            @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
            public void onStartOTA() {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "onStartOTA");
                MySPUtils.putOTAUpDateState(OTAUpdateState.OTA_UPDATE_ING);
            }

            @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
            public void onStopOTA() {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "onStopOTA");
                g.f(JliOTAActivity.this.firmwarePath);
                JliOTAActivity.this.OTAFinish();
            }
        });
    }

    private void startNetworkOta(String str) {
        Log.i(this.TAG, "startNetworkOta:" + str);
        this.mNetworkOp.startNetworkOTA(this.mWatchManager.getConnectedDevice(), new OTAParam(str), new OnNetworkOTACallback() { // from class: xfkj.fitpro.activity.ota.JliOTAActivity.4
            @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
            public void onCancel() {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "startNetworkOta onCancel");
            }

            @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
            public void onError(int i, String str2) {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "startNetworkOta onError:" + str2);
                JliOTAActivity.this.OTAError(str2);
            }

            @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
            public void onProgress(int i) {
                if (i <= 0) {
                    return;
                }
                JliOTAActivity.this.showOTAProgress(i);
            }

            @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
            public void onStart() {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "startNetworkOta");
                MySPUtils.putOTAUpDateState(OTAUpdateState.OTA_UPDATE_ING);
            }

            @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
            public void onStop() {
                Log.i(((NewBaseActivity) JliOTAActivity.this).TAG, "startNetworkOta onStop");
                g.f(JliOTAActivity.this.netWorkPath);
                if (JliOTAActivity.this.mPathArray.length == 1) {
                    JliOTAActivity.this.OTAFinish();
                    return;
                }
                JliOTAActivity.this.initFirmwareOTA();
                JliOTAActivity.this.showOTAProgress(0.0f);
                MySPUtils.putOTAFilePath(JliOTAActivity.this.firmwarePath, JliOTAActivity.this.getBleMac());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDelayError() {
        Runnable runnable = this.mDelayedErrorRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mDelayedErrorRunnable = null;
        }
    }

    @Override // xfkj.fitpro.activity.ota.base.LeBaseActivity, xfkj.fitpro.activity.ota.base.NewBaseActivity
    protected void handleMsg(Message message) {
        super.handleMsg(message);
        if (message.what == 101) {
            pb0.a();
            if (pv2.h(this.netWorkPath)) {
                initFirmwareOTA();
            } else {
                initNetWorkOTA();
            }
        }
    }

    @Override // xfkj.fitpro.activity.ota.base.NewBaseActivity
    public void initData(Bundle bundle) {
        setTitle(R.string.ota_upgrade);
        registerAckCallback(101);
        this.mPathArray = getIntent().getStringExtra("path").split(",");
        Log.i(this.TAG, "init mPathArray:" + Arrays.toString(this.mPathArray));
        String[] strArr = this.mPathArray;
        if (strArr.length > 1) {
            this.netWorkPath = findNetWorkOTAPath(strArr);
            this.firmwarePath = findFirmwareOTAPath();
            if (writeDataToBleShowDialog(qm2.q((byte) this.mPathArray.length))) {
                return;
            }
            OTAError(getString(R.string.unconnected));
            return;
        }
        String str = strArr[0];
        if (isNetWorkOTA(str)) {
            this.netWorkPath = str;
            initNetWorkOTA();
            return;
        }
        this.firmwarePath = str;
        zi2.b();
        zi2.e().B();
        BleUtils.unPairLeDevice(getDeviceAddress());
        r.d(new Runnable() { // from class: v41
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$initData$0();
            }
        }, 2000L);
    }

    @Override // xfkj.fitpro.activity.ota.base.NewBaseActivity
    public void initListener() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.isInitNetWorkOTA && !this.isInitFirmwareOTA) {
            super.onBackPressed();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.warn));
        builder.setMessage(getString(R.string.upgradding_content));
        builder.setNeutralButton(getString(R.string.cancel_txt), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(getString(R.string.exit), new DialogInterface.OnClickListener() { // from class: w41
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.lambda$onBackPressed$2(dialogInterface, i);
            }
        });
        builder.show();
    }

    @Override // xfkj.fitpro.activity.ota.base.LeBaseActivity, xfkj.fitpro.activity.ota.base.NewBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        stopDelayError();
        if (this.isInitFirmwareOTA) {
            this.otaManager.release();
        }
        if (this.isInitNetWorkOTA) {
            this.mNetworkOp.removeOnNetworkListener(this.mOnNetworkListener);
            this.mNetworkOp.destroy();
        }
    }
}
