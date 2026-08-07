package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.constant.JL_Constant;
import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.ReConnectDevMsg;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.jl_bt_ota.util.ParseDataUtil;
import com.tencent.connect.common.Constants;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceReConnectManager {
    public static long RECONNECT_TIMEOUT = 65000;
    private static final String h = "DeviceReConnectManager";
    private static final int i = 3000;
    private static final int j = 20000;
    private static final int k = 2;
    private static final int l = 30000;
    private static final int m = 2000;
    private static final int n = 37973;
    private static final int o = 37974;
    private static final int p = 37975;
    private final Context a;
    private final BluetoothOTAManager b;
    private volatile ReConnectDevMsg c;
    private long d = 0;
    private final Map<String, BleScanMessage> e = new HashMap();
    private final Handler f = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_bt_ota.tool.DeviceReConnectManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case DeviceReConnectManager.n /* 37973 */:
                    DeviceReConnectManager.this.b();
                    break;
                case DeviceReConnectManager.o /* 37974 */:
                    JL_Log.w(DeviceReConnectManager.h, "MSG_RECONNECT_DEVICE_TIMEOUT", Constants.STR_EMPTY + DeviceReConnectManager.this.c);
                    if (DeviceReConnectManager.this.c != null) {
                        DeviceReConnectManager.this.c.setState(0);
                        DeviceReConnectManager deviceReConnectManager = DeviceReConnectManager.this;
                        deviceReConnectManager.a(OTAError.buildError(ErrorCode.SUB_ERR_RECONNECT_TIMEOUT, deviceReConnectManager.c.toString()));
                    }
                    break;
                case DeviceReConnectManager.p /* 37975 */:
                    JL_Log.w(DeviceReConnectManager.h, "MSG_CONNECT_DEVICE_TIMEOUT", Constants.STR_EMPTY + DeviceReConnectManager.this.c);
                    if (DeviceReConnectManager.this.c != null) {
                        DeviceReConnectManager.this.c.setState(0);
                        DeviceReConnectManager deviceReConnectManager2 = DeviceReConnectManager.this;
                        deviceReConnectManager2.a(deviceReConnectManager2.c.getAddress());
                    }
                    break;
            }
            return true;
        }
    });
    private final BtEventCallback g;

    public DeviceReConnectManager(Context context, BluetoothOTAManager bluetoothOTAManager) {
        BtEventCallback btEventCallback = new BtEventCallback() { // from class: com.jieli.jl_bt_ota.tool.DeviceReConnectManager.2
            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onAdapterStatus(boolean z, boolean z2) {
                if (z || !DeviceReConnectManager.this.isDeviceReconnecting()) {
                    return;
                }
                JL_Log.d(DeviceReConnectManager.h, "onAdapterStatus", "bluetooth is off.");
            }

            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onConnection(BluetoothDevice bluetoothDevice, int i2) {
                byte[] rawData;
                if (bluetoothDevice == null || !DeviceReConnectManager.this.isDeviceReconnecting() || i2 == 3) {
                    return;
                }
                boolean z = DeviceReConnectManager.this.f.hasMessages(DeviceReConnectManager.p) || DeviceReConnectManager.this.f();
                JL_Log.d(DeviceReConnectManager.h, "onConnection", "isConnecting: " + z + ", status = " + i2);
                if (z) {
                    BleScanMessage bleScanMessage = (BleScanMessage) DeviceReConnectManager.this.e.get(bluetoothDevice.getAddress());
                    if (bleScanMessage != null) {
                        JL_Log.d(DeviceReConnectManager.h, "onConnection", "bleScanMessage: " + bleScanMessage);
                        rawData = bleScanMessage.getRawData();
                    } else {
                        rawData = null;
                    }
                    boolean zA = DeviceReConnectManager.this.a(bluetoothDevice, rawData);
                    JL_Log.w(DeviceReConnectManager.h, "onConnection", CommonUtil.formatString("device : %s, status : %d, isReConnectDevice : %s", DeviceReConnectManager.this.b(bluetoothDevice), Integer.valueOf(i2), Boolean.valueOf(zA)));
                    if (zA) {
                        if (DeviceReConnectManager.this.c != null) {
                            DeviceReConnectManager.this.c.setState(0);
                        }
                        DeviceReConnectManager.this.f.removeMessages(DeviceReConnectManager.p);
                        if (i2 == 1 || i2 == 4) {
                            JL_Log.d(DeviceReConnectManager.h, "onConnection", "reconnect device success.");
                            DeviceReConnectManager.this.stopReconnectTask();
                        } else if (i2 == 2 || i2 == 0) {
                            JL_Log.i(DeviceReConnectManager.h, "onConnection", "connect device failed.");
                            DeviceReConnectManager.this.a(bluetoothDevice.getAddress());
                        }
                    }
                }
            }

            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
                byte[] rawData;
                if (bluetoothDevice == null || !DeviceReConnectManager.this.isDeviceReconnecting()) {
                    return;
                }
                if (bleScanMessage != null) {
                    DeviceReConnectManager.this.e.put(bluetoothDevice.getAddress(), bleScanMessage);
                    rawData = bleScanMessage.getRawData();
                } else {
                    rawData = null;
                }
                boolean zA = DeviceReConnectManager.this.a(bluetoothDevice, rawData);
                JL_Log.d(DeviceReConnectManager.h, "onDiscovery", CommonUtil.formatString("isReConnectDevice : %s, device : %s", Boolean.valueOf(zA), DeviceReConnectManager.this.b(bluetoothDevice)));
                if (zA) {
                    DeviceReConnectManager.this.a(bluetoothDevice);
                    DeviceReConnectManager.this.g();
                }
            }

            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onDiscoveryStatus(boolean z, boolean z2) {
                JL_Log.d(DeviceReConnectManager.h, "onDiscoveryStatus", "bStart : " + z2);
                if (!DeviceReConnectManager.this.isDeviceReconnecting() || DeviceReConnectManager.this.f()) {
                    return;
                }
                if (!z2) {
                    JL_Log.d(DeviceReConnectManager.h, "onDiscoveryStatus", "ready start scan");
                    DeviceReConnectManager.this.f.removeMessages(DeviceReConnectManager.n);
                    DeviceReConnectManager.this.f.sendEmptyMessageDelayed(DeviceReConnectManager.n, 1000L);
                } else {
                    if (DeviceReConnectManager.this.c == null || DeviceReConnectManager.this.c.getState() != 0) {
                        return;
                    }
                    DeviceReConnectManager.this.c.setState(1);
                }
            }
        };
        this.g = btEventCallback;
        this.a = context;
        this.b = bluetoothOTAManager;
        bluetoothOTAManager.registerBluetoothCallback(btEventCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        JL_Log.d(h, "stopScan", "---->");
        this.b.stopBLEScan();
        this.b.stopDeviceScan();
    }

    public String getReconnectAddress() {
        ReConnectDevMsg reConnectDevMsgE = e();
        if (reConnectDevMsgE == null) {
            return null;
        }
        return reConnectDevMsgE.getAddress();
    }

    public boolean isDeviceReconnecting() {
        return this.f.hasMessages(o);
    }

    public boolean isWaitingForUpdate() {
        return e() != null;
    }

    public void release() {
        setReConnectDevMsg(null);
        stopReconnectTask();
        this.b.unregisterBluetoothCallback(this.g);
        this.f.removeCallbacksAndMessages(null);
    }

    public void setReConnectDevMsg(ReConnectDevMsg reConnectDevMsg) {
        if (this.c != reConnectDevMsg) {
            this.c = reConnectDevMsg;
            this.e.clear();
            JL_Log.d(h, "setReConnectDevMsg", Constants.STR_EMPTY + reConnectDevMsg);
        }
    }

    public void setReconnectAddress(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            setReConnectDevMsg(null);
            return;
        }
        if (this.c == null) {
            setReConnectDevMsg(new ReConnectDevMsg(this.b.getBluetoothOption().getPriority(), str));
            return;
        }
        this.c.setAddress(str);
        JL_Log.d(h, "setReconnectAddress", Constants.STR_EMPTY + this.c);
    }

    public void setReconnectUseADV(boolean z) {
        if (this.c != null) {
            this.c.setUseADV(z);
        }
    }

    public void startReconnectTask() {
        if (isDeviceReconnecting()) {
            return;
        }
        String str = h;
        JL_Log.i(str, "startReconnectTask", "start....");
        a(c());
        JL_Log.i(str, "startReconnectTask", "timeout = " + RECONNECT_TIMEOUT);
        this.f.sendEmptyMessageDelayed(o, RECONNECT_TIMEOUT);
        this.f.sendEmptyMessage(n);
    }

    public void stopReconnectTask() {
        boolean zIsDeviceReconnecting = isDeviceReconnecting();
        boolean zIsWaitingForUpdate = isWaitingForUpdate();
        JL_Log.i(h, "stopReconnectTask", "isReconnecting : " + zIsDeviceReconnecting + ", isWaitingForUpdate : " + zIsWaitingForUpdate);
        a(0L);
        setReConnectDevMsg(null);
        g();
        this.f.removeCallbacksAndMessages(null);
    }

    private long c() {
        return Calendar.getInstance().getTimeInMillis();
    }

    private long d() {
        long jC = RECONNECT_TIMEOUT - (c() - this.d);
        if (jC < 0) {
            return 0L;
        }
        return jC;
    }

    private ReConnectDevMsg e() {
        if (this.c == null) {
            return null;
        }
        return this.c.cloneObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return e() != null && e().getState() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int iStartBLEScan;
        ReConnectDevMsg reConnectDevMsgE = e();
        if (reConnectDevMsgE == null) {
            JL_Log.w(h, "doReconnectTask", "reConnectDevMsg is null.");
            stopReconnectTask();
            return;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.w(h, "doReconnectTask", "Bluetooth is close.");
            this.f.removeMessages(n);
            this.f.sendEmptyMessageDelayed(n, 3000L);
            return;
        }
        if (reConnectDevMsgE.getState() == 2) {
            JL_Log.w(h, "doReconnectTask", "Task is connecting. " + reConnectDevMsgE);
            if (this.f.hasMessages(p)) {
                return;
            }
            this.f.sendEmptyMessageDelayed(p, 30000L);
            return;
        }
        boolean zIsConnectedDevice = this.b.isConnectedDevice();
        String str = h;
        JL_Log.i(str, "doReconnectTask", reConnectDevMsgE + ", isDevConnected : " + zIsConnectedDevice);
        if (zIsConnectedDevice) {
            JL_Log.i(str, "doReconnectTask", "device is connected. " + reConnectDevMsgE + ", device = " + this.b.getConnectedDevice());
            return;
        }
        BluetoothDevice bluetoothDeviceB = b(reConnectDevMsgE.getAddress());
        JL_Log.w(str, "doReconnectTask", "connectedDevice : " + b(bluetoothDeviceB));
        if (bluetoothDeviceB != null) {
            a(bluetoothDeviceB);
            return;
        }
        if (reConnectDevMsgE.isUseADV() && reConnectDevMsgE.getWay() != 0) {
            reConnectDevMsgE.setWay(0);
        }
        if (this.b.isScanning()) {
            int scanType = this.b.getScanType();
            boolean z = scanType == 2;
            if (!z) {
                z = (reConnectDevMsgE.getWay() == 1 && scanType == 1) || (reConnectDevMsgE.getWay() == 0 && scanType == 0);
            }
            JL_Log.i(str, "doReconnectTask", "isScanOk : " + z + ", scanType = " + scanType);
            if (z) {
                return;
            }
            g();
            SystemClock.sleep(100L);
        }
        long jD = d();
        JL_Log.d(str, "doReconnectTask", "leftTime ： " + jD + ", beginTaskTime : " + this.d);
        if (jD < RECONNECT_TIMEOUT - 40000 && !reConnectDevMsgE.isUseADV()) {
            int i2 = reConnectDevMsgE.getWay() == 1 ? 0 : 2;
            long j2 = jD - 3000;
            if (j2 > 0) {
                jD = j2;
            }
            iStartBLEScan = this.b.startDeviceScan(jD, i2);
            JL_Log.i(str, "doReconnectTask", "startDeviceScan : " + iStartBLEScan + ", way = " + i2 + ", timeout = " + jD);
        } else {
            long jMin = Math.min(jD, 20000L);
            if (reConnectDevMsgE.getWay() == 1) {
                iStartBLEScan = this.b.startDeviceScan(jMin, 1);
                JL_Log.i(str, "doReconnectTask", "startDeviceScan : " + iStartBLEScan + ", scanTime = " + jMin);
            } else {
                iStartBLEScan = this.b.startBLEScan(jMin);
                JL_Log.i(str, "doReconnectTask", "startBLEScan : " + iStartBLEScan + ", scanTime = " + jMin);
            }
        }
        if (iStartBLEScan != 0) {
            this.f.removeMessages(n);
            this.f.sendEmptyMessageDelayed(n, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        ReConnectDevMsg reConnectDevMsgE;
        if (bluetoothDevice == null || (reConnectDevMsgE = e()) == null) {
            return false;
        }
        String address = reConnectDevMsgE.getAddress();
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        String str = h;
        JL_Log.d(str, "checkIsReconnectDevice", "device : " + b(bluetoothDevice));
        if (!reConnectDevMsgE.isUseADV()) {
            return address.equals(bluetoothDevice.getAddress());
        }
        JL_Log.d(str, "checkIsReconnectDevice", "advertiseRawData : " + CHexConver.byte2HexStr(bArr));
        BleScanMessage oTAFlagFilterWithBroad = ParseDataUtil.parseOTAFlagFilterWithBroad(bArr, JL_Constant.OTA_IDENTIFY);
        if (oTAFlagFilterWithBroad == null) {
            return false;
        }
        JL_Log.d(str, "checkIsReconnectDevice", Constants.STR_EMPTY + oTAFlagFilterWithBroad);
        return address.equalsIgnoreCase(oTAFlagFilterWithBroad.getOldBleAddress());
    }

    private void a(long j2) {
        this.d = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluetoothDevice bluetoothDevice) {
        String str = h;
        JL_Log.d(str, "connectBtDevice", this.c + ", device : " + bluetoothDevice);
        if (this.c == null || this.c.getState() == 2) {
            return;
        }
        this.c.setState(2);
        long jD = d();
        JL_Log.i(str, "connectBtDevice", "left time = " + jD);
        if (jD <= 2000) {
            this.f.removeMessages(o);
            this.f.sendEmptyMessageDelayed(o, 31000L);
            JL_Log.i(str, "connectBtDevice", "reset time >>> ");
        }
        this.f.removeMessages(p);
        this.f.sendEmptyMessageDelayed(p, 30000L);
        this.b.connectBluetoothDevice(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseError baseError) {
        if (baseError == null) {
            return;
        }
        if (this.b.isOTA()) {
            this.b.errorEventCallback(baseError);
        }
        stopReconnectTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        long jD = d();
        String str2 = h;
        JL_Log.d(str2, "dealWithConnectFailed", "address : " + str + ", Left Time = " + jD);
        if (jD <= 2000) {
            JL_Log.i(str2, "dealWithConnectFailed", "time not enough.");
            a(OTAError.buildError(ErrorCode.SUB_ERR_RECONNECT_FAILED, str));
        } else {
            JL_Log.i(str2, "dealWithConnectFailed", "resume reconnect task.");
            this.f.removeMessages(n);
            this.f.sendEmptyMessage(n);
        }
    }

    private BluetoothDevice b(String str) {
        List<BluetoothDevice> systemConnectedBtDeviceList;
        if (BluetoothAdapter.checkBluetoothAddress(str) && (systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.a)) != null && !systemConnectedBtDeviceList.isEmpty()) {
            for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
                if (str.equals(bluetoothDevice.getAddress())) {
                    return bluetoothDevice;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.printBtDeviceInfo(this.a, bluetoothDevice);
    }
}
