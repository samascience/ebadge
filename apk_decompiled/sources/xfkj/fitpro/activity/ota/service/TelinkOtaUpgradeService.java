package xfkj.fitpro.activity.ota.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.telink.ota.ble.a;
import com.telink.ota.fundation.StatusCode;
import defpackage.ek2;
import defpackage.ft1;
import defpackage.pv2;
import defpackage.xx1;
import java.io.FileInputStream;
import java.io.IOException;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import xfkj.fitpro.activity.ota.OTAProxyUtils;
import xfkj.fitpro.activity.ota.event.TelinkOTAUpdateStatusEvent;
import xfkj.fitpro.activity.ota.utils.EventBusUtils;

/* JADX INFO: loaded from: classes4.dex */
public class TelinkOtaUpgradeService extends Service {
    private static final int MSG_CONNECTION = 13;
    private static final int MSG_INFO = 12;
    private static final int MSG_PROGRESS = 11;
    private byte[] firmwareData;
    private BluetoothDevice mBluetoothDevice;
    DelayConnectThread mDelayConnectThread;
    private a mDevice;
    UpdateTimeoutThread mUpdateTimeoutThread;
    private final String TAG = "TelinkOtaUpgradeService";
    boolean isConnected = false;
    public Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xfkj.fitpro.activity.ota.service.TelinkOtaUpgradeService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10001) {
                return;
            }
            Log.e("TelinkOtaUpgradeService", "update timeout");
            TelinkOtaUpgradeService.this.postEvent(3, 0);
            TelinkOtaUpgradeService.this.stopSelf();
        }
    };
    private Handler mInfoHandler = new Handler(Looper.getMainLooper()) { // from class: xfkj.fitpro.activity.ota.service.TelinkOtaUpgradeService.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 11) {
                Log.i("TelinkOtaUpgradeService", message.obj + "%");
                return;
            }
            if (i == 12) {
                StatusCode statusCode = (StatusCode) message.obj;
                if (statusCode.isComplete()) {
                    Log.i("TelinkOtaUpgradeService", "isComplete");
                }
                if (statusCode == StatusCode.SUCCESS) {
                    Log.i("TelinkOtaUpgradeService", "upgrade sucess");
                    EventBusUtils.post(new TelinkOTAUpdateStatusEvent(2, 0));
                    TelinkOtaUpgradeService.this.stopSelf();
                    return;
                }
                return;
            }
            if (i == 13) {
                if (message.arg1 == 1) {
                    Log.i("TelinkOtaUpgradeService", "connectting...");
                    return;
                }
                TelinkOtaUpgradeService telinkOtaUpgradeService = TelinkOtaUpgradeService.this;
                if (telinkOtaUpgradeService.isConnected) {
                    telinkOtaUpgradeService.startOTA();
                } else {
                    telinkOtaUpgradeService.mInfoHandler.removeCallbacks(TelinkOtaUpgradeService.this.mDelayConnectThread);
                    TelinkOtaUpgradeService.this.mInfoHandler.postDelayed(TelinkOtaUpgradeService.this.mDelayConnectThread, 8000L);
                }
            }
        }
    };
    private boolean isfalse = false;
    public a.b mDeviceStateCallback = new a.b() { // from class: xfkj.fitpro.activity.ota.service.TelinkOtaUpgradeService.5
        @Override // com.telink.ota.ble.a.b
        public void onConnectionStateChange(a aVar, int i) {
            TelinkOtaUpgradeService telinkOtaUpgradeService = TelinkOtaUpgradeService.this;
            telinkOtaUpgradeService.isConnected = i == 2;
            telinkOtaUpgradeService.mInfoHandler.obtainMessage(13, Integer.valueOf(i)).sendToTarget();
        }

        @Override // com.telink.ota.ble.a.b
        public void onOtaProgressUpdate(int i) {
            TelinkOtaUpgradeService.this.mInfoHandler.obtainMessage(11, Integer.valueOf(i)).sendToTarget();
            TelinkOtaUpgradeService.this.mHandler.removeMessages(10001);
            TelinkOtaUpgradeService.this.postEvent(1, i);
            TelinkOtaUpgradeService.this.startUpgradeTimout();
        }

        @Override // com.telink.ota.ble.a.b
        public void onOtaStateChanged(a aVar, StatusCode statusCode) {
            Message messageObtainMessage = TelinkOtaUpgradeService.this.mInfoHandler.obtainMessage(12);
            messageObtainMessage.obj = statusCode;
            messageObtainMessage.sendToTarget();
        }
    };

    private class DelayConnectThread implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (TelinkOtaUpgradeService.this.isConnected) {
                return;
            }
            Log.e("TelinkOtaUpgradeService", "reconnect...");
            TelinkOtaUpgradeService.this.connectDevice();
        }

        private DelayConnectThread() {
        }
    }

    private class UpdateTimeoutThread implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            TelinkOtaUpgradeService.this.postEvent(3, 0);
            TelinkOtaUpgradeService.this.stopSelf();
        }

        private UpdateTimeoutThread() {
        }
    }

    public TelinkOtaUpgradeService() {
        this.mDelayConnectThread = new DelayConnectThread();
        this.mUpdateTimeoutThread = new UpdateTimeoutThread();
    }

    private void checkSelectedFile(String str) {
        if (!readFirmware(str)) {
            stopSelf();
        } else {
            System.arraycopy(this.firmwareData, 2, new byte[4], 0, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectDevice() {
        this.mDevice.n(this.mBluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postEvent(int i, int i2) {
        EventBusUtils.post(new TelinkOTAUpdateStatusEvent(i, i2));
    }

    private boolean readFirmware(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            this.firmwareData = bArr;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startOTA() {
        Log.e("TelinkOtaUpgradeService", "start ota...");
        xx1 xx1Var = new xx1();
        xx1Var.f(this.firmwareData);
        xx1Var.g(8);
        this.mDevice.l0(xx1Var);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpgradeTimout() {
        this.mInfoHandler.removeCallbacks(this.mUpdateTimeoutThread);
        this.mInfoHandler.postDelayed(this.mUpdateTimeoutThread, ProtocolConstants.CONNECTION_TIMEOUT_MS);
    }

    public String getConnectionDesc(int i) {
        if (i == 0) {
            return "disconnected";
        }
        if (i == 1) {
            return "connecting...";
        }
        if (i != 2) {
            return i != 3 ? "unknown" : "disconnecting...";
        }
        return "connected";
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(OTAProxyUtils.getmOtaInfo().getDeviceId());
        this.mBluetoothDevice = remoteDevice;
        if (remoteDevice == null) {
            stopSelf();
            return;
        }
        a aVar = new a(this);
        this.mDevice = aVar;
        aVar.j0(this.mDeviceStateCallback);
        ft1.a.d(new ek2() { // from class: xfkj.fitpro.activity.ota.service.TelinkOtaUpgradeService.3
            @Override // defpackage.ek2
            public void onScanResult(int i, ScanResult scanResult) {
                super.onScanResult(i, scanResult);
                BluetoothDevice bluetoothDeviceA = scanResult.a();
                if (pv2.b(TelinkOtaUpgradeService.this.mBluetoothDevice.getAddress(), bluetoothDeviceA.getAddress())) {
                    Log.i("TelinkOtaUpgradeService", "scan result device:" + bluetoothDeviceA);
                    TelinkOtaUpgradeService.this.mBluetoothDevice = bluetoothDeviceA;
                    ft1.a.f();
                }
            }
        });
        PermissionUtils.y("LOCATION").m(new PermissionUtils.b() { // from class: xfkj.fitpro.activity.ota.service.TelinkOtaUpgradeService.4
            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onDenied() {
                if (TelinkOtaUpgradeService.this.isfalse) {
                    return;
                }
                TelinkOtaUpgradeService.this.postEvent(0, 0);
                TelinkOtaUpgradeService.this.mHandler.sendEmptyMessageDelayed(10001, 40000L);
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onGranted() {
                ft1.a.e();
                if (TelinkOtaUpgradeService.this.isfalse) {
                    return;
                }
                TelinkOtaUpgradeService.this.postEvent(0, 0);
                TelinkOtaUpgradeService.this.mHandler.sendEmptyMessageDelayed(10001, 40000L);
            }
        }).z();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.e("TelinkOtaUpgradeService", "call destroy");
        ft1.a.f();
        this.mInfoHandler.removeCallbacks(this.mDelayConnectThread);
        this.mInfoHandler.removeCallbacks(this.mUpdateTimeoutThread);
        a aVar = this.mDevice;
        if (aVar != null) {
            aVar.V(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra("path");
        this.isfalse = intent.getBooleanExtra("isforce", false);
        checkSelectedFile(stringExtra);
        connectDevice();
        return super.onStartCommand(intent, i, i2);
    }
}
