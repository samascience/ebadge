package com.jieli.multidevice;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.ble.BleManager;
import com.jieli.ble.interfaces.BleEventCallback;
import com.jieli.ble.model.BleScanInfo;
import com.jieli.jl_bt_ota.constant.JL_Constant;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.tool.DeviceReConnectManager;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.jl_bt_ota.util.ParseDataUtil;
import com.jieli.multidevice.ReConnectHelper;
import com.tencent.open.SocialConstants;
import defpackage.p31;
import defpackage.y70;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ReConnectHelper {
    private static final long FAILED_DELAY = 3000;
    private static final int MSG_PROCESS_TASK = 2;
    private static final int MSG_RECONNECT_TIMEOUT = 1;
    private static final long SCAN_TIMEOUT = 20000;
    private final BleEventCallback bleEventCallback;
    private final Map<String, BleScanMessage> mBleAdvCache;
    private final BleManager mBtManager;
    private final Context mContext;
    private final List<ReconnectParam> mParams;
    private final Handler mUIHandler;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = ReConnectHelper.class.getSimpleName();
    private static final long RECONNECT_TIMEOUT = DeviceReConnectManager.RECONNECT_TIMEOUT;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        private Companion() {
        }
    }

    public static final class ReconnectParam {
        private String connectAddress;
        private final String deviceAddress;
        private final boolean isUseNewADV;

        public ReconnectParam(String str, boolean z) {
            p31.f(str, "deviceAddress");
            this.deviceAddress = str;
            this.isUseNewADV = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !p31.a(ReconnectParam.class, obj.getClass())) {
                return false;
            }
            ReconnectParam reconnectParam = (ReconnectParam) obj;
            return this.isUseNewADV == reconnectParam.isUseNewADV && p31.a(this.deviceAddress, reconnectParam.deviceAddress);
        }

        public final String getConnectAddress() {
            return this.connectAddress;
        }

        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public int hashCode() {
            return Objects.hash(this.deviceAddress, Boolean.valueOf(this.isUseNewADV));
        }

        public final boolean isUseNewADV() {
            return this.isUseNewADV;
        }

        public final void setConnectAddress(String str) {
            this.connectAddress = str;
        }

        public String toString() {
            return "ReconnectParam{deviceAddress='" + this.deviceAddress + "', isUseNewADV=" + this.isUseNewADV + ", connectAddress='" + this.connectAddress + "'}";
        }
    }

    public ReConnectHelper(Context context, BleManager bleManager) {
        p31.f(context, "mContext");
        p31.f(bleManager, "mBtManager");
        this.mContext = context;
        this.mBtManager = bleManager;
        this.mParams = new ArrayList();
        this.mBleAdvCache = new HashMap();
        this.mUIHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: sc2
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return ReConnectHelper.mUIHandler$lambda$0(this.a, message);
            }
        });
        BleEventCallback bleEventCallback = new BleEventCallback() { // from class: com.jieli.multidevice.ReConnectHelper$bleEventCallback$1
            @Override // com.jieli.ble.interfaces.BleEventCallback, com.jieli.ble.interfaces.IBleEventCallback
            public void onAdapterChange(boolean z) {
                if (this.this$0.isReconnecting() && z) {
                    JL_Log.i(ReConnectHelper.TAG, "onAdapterChange : bluetooth is on, try to start le scan.");
                    this.this$0.mUIHandler.sendEmptyMessage(2);
                }
            }

            @Override // com.jieli.ble.interfaces.BleEventCallback, com.jieli.ble.interfaces.IBleEventCallback
            public void onBleConnection(BluetoothDevice bluetoothDevice, int i) {
                if (!this.this$0.isReconnecting() || bluetoothDevice == null) {
                    return;
                }
                BleScanMessage bleScanMessage = (BleScanMessage) this.this$0.mBleAdvCache.get(bluetoothDevice.getAddress());
                if (this.this$0.isReconnectDevice(bluetoothDevice, bleScanMessage)) {
                    JL_Log.i(ReConnectHelper.TAG, "onBleConnection : " + bluetoothDevice + ", status = " + i + ", " + bleScanMessage);
                    if (i == 0) {
                        JL_Log.i(ReConnectHelper.TAG, "-onConnection- resume reconnect task.");
                        this.this$0.mUIHandler.sendEmptyMessage(2);
                        return;
                    }
                    if (i != 2) {
                        return;
                    }
                    JL_Log.w(ReConnectHelper.TAG, "onBleConnection : removeParam >>> " + bluetoothDevice.getAddress());
                    ReConnectHelper reConnectHelper = this.this$0;
                    String address = bluetoothDevice.getAddress();
                    p31.e(address, "device.address");
                    reConnectHelper.removeParam(address);
                }
            }

            @Override // com.jieli.ble.interfaces.BleEventCallback, com.jieli.ble.interfaces.IBleEventCallback
            public void onDiscoveryBle(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo) {
                p31.f(bleScanInfo, "bleScanMessage");
                if (!this.this$0.isReconnecting() || bluetoothDevice == null) {
                    return;
                }
                BleScanMessage oTAFlagFilterWithBroad = ParseDataUtil.parseOTAFlagFilterWithBroad(bleScanInfo.getRawData(), JL_Constant.OTA_IDENTIFY);
                if (oTAFlagFilterWithBroad != null) {
                    Map map = this.this$0.mBleAdvCache;
                    String address = bluetoothDevice.getAddress();
                    p31.e(address, "device.address");
                    map.put(address, oTAFlagFilterWithBroad);
                    JL_Log.d(ReConnectHelper.TAG, "onDiscoveryBle : put data in map.");
                }
                boolean zIsReconnectDevice = this.this$0.isReconnectDevice(bluetoothDevice, oTAFlagFilterWithBroad);
                JL_Log.d(ReConnectHelper.TAG, "onDiscoveryBle : " + bluetoothDevice + ", isReconnectDevice = " + zIsReconnectDevice + ", " + oTAFlagFilterWithBroad);
                if (zIsReconnectDevice) {
                    this.this$0.stopBtScan();
                    ReConnectHelper reConnectHelper = this.this$0;
                    String address2 = bluetoothDevice.getAddress();
                    p31.e(address2, "device.address");
                    ReConnectHelper.ReconnectParam cacheParam = reConnectHelper.getCacheParam(address2);
                    if (cacheParam != null) {
                        cacheParam.setConnectAddress(bluetoothDevice.getAddress());
                    }
                    JL_Log.d(ReConnectHelper.TAG, "onDiscoveryBle : " + bluetoothDevice + ", param = " + cacheParam);
                    this.this$0.mBtManager.connectBleDevice(bluetoothDevice);
                }
            }

            @Override // com.jieli.ble.interfaces.BleEventCallback, com.jieli.ble.interfaces.IBleEventCallback
            public void onDiscoveryBleChange(boolean z) {
                if (this.this$0.isReconnecting()) {
                    boolean zIsConnecting = this.this$0.mBtManager.isConnecting();
                    JL_Log.i(ReConnectHelper.TAG, "onDiscoveryBleChange : " + z + ", isConnecting = " + zIsConnecting);
                    if (z || zIsConnecting) {
                        return;
                    }
                    this.this$0.mUIHandler.sendEmptyMessage(2);
                }
            }
        };
        this.bleEventCallback = bleEventCallback;
        bleManager.registerBleEventCallback(bleEventCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReconnectParam getCacheParam(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return null;
        }
        BleScanMessage bleScanMessage = this.mBleAdvCache.get(str);
        for (ReconnectParam reconnectParam : new ArrayList(this.mParams)) {
            if (p31.a(str, reconnectParam.getDeviceAddress()) || (bleScanMessage != null && p31.a(reconnectParam.getDeviceAddress(), bleScanMessage.getOldBleAddress()))) {
                return reconnectParam;
            }
        }
        return null;
    }

    private final BluetoothDevice getSystemConnectedDevice() {
        List<BluetoothDevice> systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.mContext);
        if (systemConnectedBtDeviceList != null && !systemConnectedBtDeviceList.isEmpty()) {
            for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
                if (isReconnectDevice(bluetoothDevice, null)) {
                    return bluetoothDevice;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isReconnectDevice(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
        boolean zA = false;
        if (bluetoothDevice != null && !this.mParams.isEmpty()) {
            for (ReconnectParam reconnectParam : new ArrayList(this.mParams)) {
                zA = (reconnectParam.isUseNewADV() && bleScanMessage != null && bleScanMessage.isOTA()) ? p31.a(reconnectParam.getDeviceAddress(), bleScanMessage.getOldBleAddress()) : p31.a(reconnectParam.getDeviceAddress(), bluetoothDevice.getAddress());
                if (zA) {
                    break;
                }
            }
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mUIHandler$lambda$0(ReConnectHelper reConnectHelper, Message message) {
        p31.f(reConnectHelper, "this$0");
        p31.f(message, SocialConstants.PARAM_SEND_MSG);
        int i = message.what;
        if (i == 1) {
            reConnectHelper.stopBtScan();
            reConnectHelper.mParams.clear();
        } else if (i != 2) {
            Object obj = message.obj;
            if (obj instanceof String) {
                p31.d(obj, "null cannot be cast to non-null type kotlin.String");
                reConnectHelper.removeParam((String) obj);
            }
        } else {
            reConnectHelper.processReconnectTask();
        }
        return true;
    }

    private final void processReconnectTask() {
        if (this.mBtManager.isBleScanning()) {
            this.mUIHandler.sendEmptyMessageDelayed(2, FAILED_DELAY);
            return;
        }
        BluetoothDevice systemConnectedDevice = getSystemConnectedDevice();
        if (systemConnectedDevice == null) {
            if (this.mBtManager.startLeScan(SCAN_TIMEOUT)) {
                return;
            }
            JL_Log.i(TAG, "processReconnectTask : start Le scan failed.");
            this.mUIHandler.sendEmptyMessageDelayed(2, FAILED_DELAY);
            return;
        }
        String address = systemConnectedDevice.getAddress();
        p31.e(address, "connectedDevice.address");
        ReconnectParam cacheParam = getCacheParam(address);
        if (cacheParam != null) {
            cacheParam.setConnectAddress(systemConnectedDevice.getAddress());
        }
        this.mBtManager.connectBleDevice(systemConnectedDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeParam(String str) {
        ReconnectParam cacheParam = getCacheParam(str);
        if (cacheParam == null) {
            return;
        }
        if (this.mParams.remove(cacheParam)) {
            this.mUIHandler.removeMessages(cacheParam.hashCode());
            if (this.mParams.isEmpty()) {
                this.mUIHandler.removeMessages(1);
                return;
            }
        }
        this.mUIHandler.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopBtScan() {
        this.mBtManager.stopLeScan();
    }

    public final boolean isMatchAddress(String str, String str2) {
        p31.f(str, "srcAddress");
        p31.f(str2, "checkAddress");
        ReconnectParam cacheParam = getCacheParam(str);
        if (cacheParam == null || !BluetoothAdapter.checkBluetoothAddress(str2)) {
            return false;
        }
        return p31.a(str2, cacheParam.getDeviceAddress()) || p31.a(str2, cacheParam.getConnectAddress());
    }

    public final boolean isReconnecting() {
        return this.mUIHandler.hasMessages(1);
    }

    public final boolean putParam(ReconnectParam reconnectParam) {
        if (reconnectParam == null) {
            return false;
        }
        if (this.mParams.contains(reconnectParam)) {
            return true;
        }
        if (!this.mParams.add(reconnectParam)) {
            return false;
        }
        Handler handler = this.mUIHandler;
        int iHashCode = this.mParams.hashCode();
        long j = RECONNECT_TIMEOUT;
        handler.sendEmptyMessageDelayed(iHashCode, j);
        if (!isReconnecting()) {
            Handler handler2 = this.mUIHandler;
            handler2.sendMessageDelayed(handler2.obtainMessage(1, reconnectParam.getDeviceAddress()), j + ((long) 10000));
            this.mUIHandler.sendEmptyMessage(2);
        }
        return true;
    }

    public final void release() {
        this.mParams.clear();
        this.mBleAdvCache.clear();
        this.mUIHandler.removeCallbacksAndMessages(null);
        this.mBtManager.unregisterBleEventCallback(this.bleEventCallback);
    }
}
