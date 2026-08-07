package com.jieli.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.jieli.JliCore;
import com.jieli.ble.BleManager;
import com.jieli.ble.interfaces.BleEventCallback;
import com.jieli.ble.interfaces.OnWriteDataCallback;
import com.jieli.ble.model.BleDevice;
import com.jieli.ble.model.BleScanInfo;
import com.jieli.config.ConfigHelper;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.multidevice.ReConnectHelper;
import com.jieli.util.AppUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"MissingPermission"})
public class BleManager {
    private static final int CALLBACK_TIMEOUT = 6000;
    private static final int CONNECT_BLE_TIMEOUT = 40000;
    private static final int MAX_RETRY_CONNECT_COUNT = 1;
    private static final int MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT = 4117;
    private static final int MSG_CHANGE_BLE_MTU_TIMEOUT = 4116;
    private static final int MSG_CONNECT_BLE_TIMEOUT = 4113;
    private static final int MSG_NOTIFY_BLE_TIMEOUT = 4115;
    private static final int MSG_SCAN_BLE_TIMEOUT = 4112;
    private static final int MSG_SCAN_HID_DEVICE = 4114;
    private static final int RECONNECT_BLE_DELAY = 2000;
    private static final int SCAN_BLE_TIMEOUT = 12000;
    public static final int SEND_DATA_MAX_TIMEOUT = 8000;
    private static final String TAG = "BleManager";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile BleManager instance;
    private volatile boolean isBleScanning;
    private BaseBtAdapterReceiver mAdapterReceiver;
    private final BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    private volatile BluetoothDevice mConnectingBtDevice;
    private final Context mContext;
    private NotifyCharacteristicRunnable mNotifyCharacteristicRunnable;
    private final ReConnectHelper mReConnectHelper;
    private volatile BluetoothDevice mUsingDevice;
    public static final UUID BLE_UUID_SERVICE = BluetoothConstant.UUID_SERVICE;
    public static final UUID BLE_UUID_WRITE = BluetoothConstant.UUID_WRITE;
    public static final UUID BLE_UUID_NOTIFICATION = BluetoothConstant.UUID_NOTIFICATION;
    public static final UUID BLE_UUID_NOTIFICATION_DESCRIPTOR = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");
    private final ConfigHelper configHelper = ConfigHelper.Companion.getInstance();
    private final Map<String, BleDevice> mConnectedGattMap = new HashMap();
    private final List<BluetoothDevice> mDiscoveredBleDevices = new ArrayList();
    private final BleEventCallbackManager mCallbackManager = new BleEventCallbackManager();
    private int mRetryConnectCount = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.ble.BleManager.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            List<BluetoothGattService> services;
            switch (message.what) {
                case 4112:
                    if (BleManager.this.isBleScanning) {
                        BleManager.this.stopLeScan();
                    }
                    return false;
                case 4113:
                    Object obj = message.obj;
                    if (obj instanceof BluetoothDevice) {
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
                        if (BleManager.this.getConnectedBle(bluetoothDevice) == null) {
                            BleManager.this.handleBleConnection(bluetoothDevice, 0);
                        }
                        BleManager.this.setConnectingBtDevice(null);
                    }
                    return false;
                case 4114:
                    List<BluetoothDevice> systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(BleManager.this.mContext);
                    if (systemConnectedBtDeviceList != null && AppUtil.checkHasConnectPermission(BleManager.this.mContext)) {
                        for (BluetoothDevice bluetoothDevice2 : systemConnectedBtDeviceList) {
                            if (bluetoothDevice2.getType() != 1 && bluetoothDevice2.getBondState() == 12) {
                                BleManager.this.handleDiscoveryBle(bluetoothDevice2, null);
                            }
                        }
                    }
                    BleManager.this.mHandler.sendEmptyMessageDelayed(4114, 1000L);
                    return false;
                case 4115:
                    Object obj2 = message.obj;
                    if (obj2 instanceof BluetoothDevice) {
                        BleManager.this.disconnectBleDevice((BluetoothDevice) obj2);
                    }
                    return false;
                case BleManager.MSG_CHANGE_BLE_MTU_TIMEOUT /* 4116 */:
                    BluetoothDevice bluetoothDevice3 = (BluetoothDevice) message.obj;
                    BleDevice connectedBle = BleManager.this.getConnectedBle(bluetoothDevice3);
                    JL_Log.i(BleManager.TAG, "-MSG_CHANGE_BLE_MTU_TIMEOUT- request mtu timeout, device : " + BleManager.this.printDeviceInfo(bluetoothDevice3) + ", " + connectedBle);
                    if (connectedBle != null) {
                        BleManager.this.handleBleConnectedEvent(bluetoothDevice3);
                    } else {
                        BleManager.this.handleBleConnection(bluetoothDevice3, 0);
                    }
                    return false;
                case BleManager.MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT /* 4117 */:
                    Object obj3 = message.obj;
                    if (obj3 instanceof BluetoothDevice) {
                        BluetoothDevice bluetoothDevice4 = (BluetoothDevice) obj3;
                        if (BluetoothUtil.deviceEquals(bluetoothDevice4, BleManager.this.mUsingDevice)) {
                            BleDevice connectedBle2 = BleManager.this.getConnectedBle(bluetoothDevice4);
                            if (connectedBle2 == null || (services = connectedBle2.getGatt().getServices()) == null || services.size() <= 0) {
                                JL_Log.d(BleManager.TAG, "discover services timeout.");
                                BleManager.this.disconnectBleDevice(bluetoothDevice4);
                                BleManager.this.reconnectDevice(bluetoothDevice4.getAddress(), false);
                            } else {
                                BleManager.this.mBluetoothGattCallback.onServicesDiscovered(connectedBle2.getGatt(), 0);
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }
    });
    private final BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: uj
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.a.lambda$new$1(bluetoothDevice, i, bArr);
        }
    };
    private final ScanCallback mScanCallback = new ScanCallback() { // from class: com.jieli.ble.BleManager.2
        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            JL_Log.d(BleManager.TAG, "onScanFailed : " + i);
            BleManager.this.stopLeScan();
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            if (scanResult == null || scanResult.getScanRecord() == null) {
                return;
            }
            BleManager.this.filterDevice(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes(), scanResult.isConnectable());
        }
    };
    private final BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: com.jieli.ble.BleManager.3
        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"MissingPermission"})
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BluetoothDevice device;
            if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(BleManager.this.mContext) || (device = bluetoothGatt.getDevice()) == null || bluetoothGattCharacteristic == null) {
                return;
            }
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            byte[] value = bluetoothGattCharacteristic.getValue();
            BluetoothGattService service = bluetoothGattCharacteristic.getService();
            UUID uuid2 = service != null ? service.getUuid() : null;
            JL_Log.d(BleManager.TAG, String.format(Locale.getDefault(), "onCharacteristicChanged : deice : %s, serviceUuid = %s, characteristicUuid = %s, \ndata : [%s]", BleManager.this.printDeviceInfo(device), uuid2, uuid, CHexConver.byte2HexStr(value)));
            BleManager.this.mCallbackManager.onBleDataNotification(device, uuid2, uuid, value);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"MissingPermission"})
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (bluetoothGatt == null || bluetoothGatt.getDevice() == null || bluetoothGattCharacteristic == null || !AppUtil.checkHasConnectPermission(BleManager.this.mContext)) {
                return;
            }
            BluetoothDevice device = bluetoothGatt.getDevice();
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            BluetoothGattService service = bluetoothGattCharacteristic.getService();
            UUID uuid2 = service != null ? service.getUuid() : null;
            byte[] value = bluetoothGattCharacteristic.getValue();
            JL_Log.d(BleManager.TAG, String.format(Locale.getDefault(), "onCharacteristicWrite : device : %s, serviceUuid = %s, characteristicUuid = %s, status = %d, \ndata : [%s]", BleManager.this.printDeviceInfo(device), uuid2, uuid, Integer.valueOf(i), CHexConver.byte2HexStr(value)));
            BleManager.this.wakeupSendThread(bluetoothGatt, uuid2, uuid, i, value);
            BleManager.this.mCallbackManager.onBleWriteStatus(device, uuid2, uuid, value, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"MissingPermission"})
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            BluetoothDevice device;
            if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(BleManager.this.mContext) || (device = bluetoothGatt.getDevice()) == null) {
                return;
            }
            JL_Log.i(BleManager.TAG, String.format(Locale.getDefault(), "onConnectionStateChange : device : %s, status = %d, newState = %d.", BleManager.this.printDeviceInfo(device), Integer.valueOf(i), Integer.valueOf(i2)));
            if (i2 == 0 || i2 == 3 || i2 == 2) {
                BleManager.this.stopConnectTimeout();
                BleManager.this.setConnectingBtDevice(null);
                if (i2 == 2) {
                    BleManager.this.mRetryConnectCount = 0;
                    boolean zDiscoverServices = bluetoothGatt.discoverServices();
                    JL_Log.d(BleManager.TAG, "onConnectionStateChange >> discoverServices : " + zDiscoverServices);
                    BleManager.this.putConnectedGattInMap(device.getAddress(), bluetoothGatt);
                    if (!zDiscoverServices) {
                        BleManager.this.disconnectBleDevice(device);
                        return;
                    } else {
                        BleManager.this.mHandler.removeMessages(BleManager.MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT);
                        BleManager.this.mHandler.sendMessageDelayed(BleManager.this.mHandler.obtainMessage(BleManager.MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT, device), 6000L);
                        return;
                    }
                }
                BleManager.this.removeConnectedBle(device);
                AppUtil.refreshBleDeviceCache(BleManager.this.mContext, bluetoothGatt);
                bluetoothGatt.close();
                if (i == 133) {
                    if (BleManager.this.mRetryConnectCount < 1) {
                        BleManager.access$1608(BleManager.this);
                        BleManager.this.connectBleDevice(device);
                        return;
                    }
                    BleManager.this.mRetryConnectCount = 0;
                }
            }
            BleManager.this.handleBleConnection(device, i2);
        }

        public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
            BluetoothDevice device;
            if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(BleManager.this.mContext) || (device = bluetoothGatt.getDevice()) == null) {
                return;
            }
            JL_Log.e(BleManager.TAG, "onConnectionUpdated >> device : " + BleManager.this.printDeviceInfo(device) + ", interval : " + i + ", latency : " + i2 + ", timeout : " + i3 + ", status : " + i4);
            BleManager.this.mCallbackManager.onConnectionUpdated(device, i, i2, i3, i4);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"MissingPermission"})
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            BluetoothDevice device;
            UUID uuid;
            UUID uuid2;
            if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(BleManager.this.mContext) || (device = bluetoothGatt.getDevice()) == null || bluetoothGattDescriptor == null) {
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
            if (characteristic != null) {
                uuid2 = characteristic.getUuid();
                BluetoothGattService service = characteristic.getService();
                uuid = service != null ? service.getUuid() : null;
            } else {
                uuid = null;
                uuid2 = null;
            }
            JL_Log.i(BleManager.TAG, String.format(Locale.getDefault(), "onDescriptorWrite : device : %s, serviceUuid = %s, characteristicUuid = %s, descriptor = %s, status = %d", BleManager.this.printDeviceInfo(device), uuid, uuid2, bluetoothGattDescriptor.getUuid(), Integer.valueOf(i)));
            BleManager.this.mCallbackManager.onBleNotificationStatus(device, uuid, uuid2, i);
            if (BleManager.this.mNotifyCharacteristicRunnable == null || !BluetoothUtil.deviceEquals(device, BleManager.this.mNotifyCharacteristicRunnable.getBleDevice()) || uuid == null || !uuid.equals(BleManager.this.mNotifyCharacteristicRunnable.getServiceUUID()) || uuid2 == null || !uuid2.equals(BleManager.this.mNotifyCharacteristicRunnable.getCharacteristicUUID()) || bluetoothGattDescriptor.getUuid() == null || !bluetoothGattDescriptor.getUuid().equals(BleManager.this.mNotifyCharacteristicRunnable.mDescriptorUUID)) {
                return;
            }
            if (i == 0) {
                BleManager.this.mNotifyCharacteristicRunnable = null;
                int bleRequestMtu = BleManager.this.configHelper.getBleRequestMtu();
                if (bleRequestMtu > 509) {
                    bleRequestMtu = 509;
                }
                BleManager.this.startChangeMtu(bluetoothGatt, bleRequestMtu);
                return;
            }
            int retryNum = BleManager.this.mNotifyCharacteristicRunnable.getRetryNum();
            if (retryNum >= 3) {
                BleManager.this.disconnectBleDevice(device);
            } else {
                BleManager.this.mNotifyCharacteristicRunnable.setRetryNum(retryNum + 1);
                BleManager.this.mHandler.postDelayed(BleManager.this.mNotifyCharacteristicRunnable, 100L);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"MissingPermission"})
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            BluetoothDevice device;
            if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(BleManager.this.mContext) || (device = bluetoothGatt.getDevice()) == null) {
                return;
            }
            JL_Log.d(BleManager.TAG, String.format(Locale.getDefault(), "onMtuChanged : device : %s, mtu = %d, status = %d", BleManager.this.printDeviceInfo(device), Integer.valueOf(i), Integer.valueOf(i2)));
            BleManager.this.mCallbackManager.onBleDataBlockChanged(device, i, i2);
            BleDevice connectedBle = BleManager.this.getConnectedBle(device);
            if (i2 == 0) {
                int i3 = i - 3;
                if (connectedBle == null || !BleManager.this.mHandler.hasMessages(BleManager.MSG_CHANGE_BLE_MTU_TIMEOUT)) {
                    return;
                }
                BleManager.this.stopChangeMtu();
                connectedBle.setMtu(i3);
                JL_Log.i(BleManager.TAG, "-onMtuChanged- handleBleConnectedEvent");
                BleManager.this.handleBleConnectedEvent(device);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"MissingPermission"})
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            BluetoothDevice device;
            boolean z;
            if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(BleManager.this.mContext) || (device = bluetoothGatt.getDevice()) == null) {
                return;
            }
            BleManager.this.mHandler.removeMessages(BleManager.MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT);
            BleManager.this.mCallbackManager.onBleServiceDiscovery(device, i, bluetoothGatt.getServices());
            if (i != 0) {
                z = false;
                break;
            }
            AppUtil.printBleGattServices(BleManager.this.mContext, device, bluetoothGatt, i);
            Iterator<BluetoothGattService> it = bluetoothGatt.getServices().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                BluetoothGattService next = it.next();
                UUID uuid = BleManager.BLE_UUID_SERVICE;
                if (uuid.equals(next.getUuid()) && next.getCharacteristic(BleManager.BLE_UUID_WRITE) != null) {
                    UUID uuid2 = BleManager.BLE_UUID_NOTIFICATION;
                    if (next.getCharacteristic(uuid2) != null) {
                        JL_Log.i(BleManager.TAG, "start NotifyCharacteristicRunnable...");
                        BleManager bleManager = BleManager.this;
                        bleManager.mNotifyCharacteristicRunnable = new NotifyCharacteristicRunnable(bluetoothGatt, uuid, uuid2);
                        BleManager.this.mHandler.post(BleManager.this.mNotifyCharacteristicRunnable);
                        z = true;
                        break;
                    }
                }
            }
            JL_Log.i(BleManager.TAG, "onServicesDiscovered : " + z);
            if (z) {
                return;
            }
            BleManager.this.disconnectBleDevice(device);
        }
    };

    private class BaseBtAdapterReceiver extends BroadcastReceiver {
        private BaseBtAdapterReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent == null || (action = intent.getAction()) == null) {
            }
            switch (action) {
                case "android.bluetooth.adapter.action.STATE_CHANGED":
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                    if (BleManager.this.mBluetoothAdapter != null && intExtra == -1) {
                        intExtra = BleManager.this.mBluetoothAdapter.getState();
                    }
                    if (intExtra == 10) {
                        BleManager.this.isBleScanning(false);
                        BleManager.this.mDiscoveredBleDevices.clear();
                        BleManager.this.mCallbackManager.onDiscoveryBleChange(false);
                        BleManager bleManager = BleManager.this;
                        bleManager.disconnectBleDevice(bleManager.getConnectedBtDevice());
                        BleManager.this.mCallbackManager.onAdapterChange(false);
                        break;
                    } else {
                        if (intExtra == 12) {
                            BleManager.this.mCallbackManager.onAdapterChange(true);
                        }
                        break;
                    }
                    break;
                case "android.bluetooth.device.action.ACL_CONNECTED":
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    JL_Log.i(BleManager.TAG, "BaseBtAdapterReceiver: ACTION_ACL_CONNECTED, device : " + BleManager.this.printDeviceInfo(bluetoothDevice));
                    break;
                case "android.bluetooth.device.action.ACL_DISCONNECTED":
                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    JL_Log.i(BleManager.TAG, "BaseBtAdapterReceiver: ACTION_ACL_DISCONNECTED, device : " + BleManager.this.printDeviceInfo(bluetoothDevice2));
                    break;
            }
        }
    }

    private class NotifyCharacteristicRunnable implements Runnable {
        private final UUID mCharacteristicUUID;
        public final UUID mDescriptorUUID;
        private final BluetoothGatt mGatt;
        private final UUID mServiceUUID;
        private int retryNum;

        /* JADX INFO: Access modifiers changed from: private */
        public BluetoothDevice getBleDevice() {
            BluetoothGatt bluetoothGatt = this.mGatt;
            if (bluetoothGatt == null) {
                return null;
            }
            return bluetoothGatt.getDevice();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UUID getCharacteristicUUID() {
            return this.mCharacteristicUUID;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getRetryNum() {
            return this.retryNum;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UUID getServiceUUID() {
            return this.mServiceUUID;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryNum(int i) {
            this.retryNum = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zEnableBLEDeviceNotification = BleManager.this.enableBLEDeviceNotification(this.mGatt, this.mServiceUUID, this.mCharacteristicUUID);
            JL_Log.w(BleManager.TAG, String.format(Locale.getDefault(), "enableBLEDeviceNotification ===> %s, service uuid = %s, characteristic uuid = %s", Boolean.valueOf(zEnableBLEDeviceNotification), this.mServiceUUID, this.mCharacteristicUUID));
            if (zEnableBLEDeviceNotification) {
                BleManager.this.mHandler.removeMessages(4115);
                BleManager.this.mHandler.sendMessageDelayed(BleManager.this.mHandler.obtainMessage(4115, this.mGatt.getDevice()), 6000L);
            } else {
                BluetoothGatt bluetoothGatt = this.mGatt;
                if (bluetoothGatt != null) {
                    BleManager.this.disconnectBleDevice(bluetoothGatt.getDevice());
                }
            }
        }

        private NotifyCharacteristicRunnable(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2) {
            this.mDescriptorUUID = BleManager.BLE_UUID_NOTIFICATION_DESCRIPTOR;
            this.retryNum = 0;
            this.mGatt = bluetoothGatt;
            this.mServiceUUID = uuid;
            this.mCharacteristicUUID = uuid2;
        }
    }

    private BleManager(Context context) {
        this.mContext = (Context) CommonUtil.checkNotNull(context);
        if (CommonUtil.getMainContext() == null) {
            CommonUtil.setMainContext(context);
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = defaultAdapter;
        if (defaultAdapter != null) {
            this.mBluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        }
        this.mReConnectHelper = new ReConnectHelper(context, this);
        registerReceiver();
    }

    static /* synthetic */ int access$1608(BleManager bleManager) {
        int i = bleManager.mRetryConnectCount;
        bleManager.mRetryConnectCount = i + 1;
        return i;
    }

    private void addSendTask(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr, OnWriteDataCallback onWriteDataCallback) {
        BleDevice connectedBle = getConnectedBle(bluetoothDevice);
        if ((connectedBle != null ? connectedBle.addSendTask(uuid, uuid2, bArr, onWriteDataCallback) : false) || onWriteDataCallback == null) {
            return;
        }
        onWriteDataCallback.onBleResult(bluetoothDevice, uuid, uuid2, false, bArr);
    }

    private void clearConnectedBleDevices() {
        if (AppUtil.checkHasConnectPermission(this.mContext) && !this.mConnectedGattMap.isEmpty()) {
            HashMap map = new HashMap(this.mConnectedGattMap);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                BleDevice bleDevice = (BleDevice) map.get((String) it.next());
                if (bleDevice != null) {
                    bleDevice.getGatt().disconnect();
                    bleDevice.getGatt().close();
                }
            }
            this.mConnectedGattMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public boolean enableBLEDeviceNotification(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2) {
        if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, "Bluetooth gatt is null.");
            return false;
        }
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            JL_Log.w(TAG, "BluetoothGattService is null. uuid = " + uuid);
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        if (characteristic == null) {
            JL_Log.w(TAG, "BluetoothGattCharacteristic is null. uuid = " + uuid2);
            return false;
        }
        boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(characteristic, true);
        if (characteristicNotification) {
            characteristicNotification = false;
            for (BluetoothGattDescriptor bluetoothGattDescriptor : characteristic.getDescriptors()) {
                if (BLE_UUID_NOTIFICATION_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                    characteristicNotification = tryToWriteDescriptor(bluetoothGatt, bluetoothGattDescriptor, 0, false);
                    if (characteristicNotification) {
                        break;
                    }
                    JL_Log.w(TAG, "tryToWriteDescriptor failed....");
                }
            }
        } else {
            JL_Log.w(TAG, "setCharacteristicNotification is failed....");
        }
        JL_Log.w(TAG, "enableBLEDeviceNotification ret : " + characteristicNotification + ", serviceUUID : " + uuid + ", characteristicUUID : " + uuid2);
        return characteristicNotification;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void filterDevice(BluetoothDevice bluetoothDevice, int i, byte[] bArr, boolean z) {
        if (!AppUtil.checkHasConnectPermission(this.mContext) || !isBluetoothEnable() || TextUtils.isEmpty(bluetoothDevice.getName()) || this.mDiscoveredBleDevices.contains(bluetoothDevice)) {
            return;
        }
        JL_Log.d(TAG, "notify device : " + printDeviceInfo(bluetoothDevice));
        this.mDiscoveredBleDevices.add(bluetoothDevice);
        handleDiscoveryBle(bluetoothDevice, new BleScanInfo().setRawData(bArr).setRssi(i).setEnableConnect(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BleDevice getConnectedBle(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return this.mConnectedGattMap.get(bluetoothDevice.getAddress());
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getConnectedBleDeviceList(Context context) {
        BluetoothManager bluetoothManager;
        if (context == null || !AppUtil.checkHasConnectPermission(context) || (bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth")) == null) {
            return null;
        }
        return bluetoothManager.getConnectedDevices(7);
    }

    public static BleManager getInstance() {
        if (instance == null) {
            synchronized (BleManager.class) {
                try {
                    if (instance == null) {
                        instance = new BleManager(JliCore.getInstance().getApplication());
                        JL_Log.w(TAG, "init BleManager.. " + instance);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private List<BleDevice> getSortList() {
        if (this.mConnectedGattMap.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(this.mConnectedGattMap.values());
        Collections.sort(arrayList, new Comparator() { // from class: vj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BleManager.lambda$getSortList$0((BleDevice) obj, (BleDevice) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBleConnectedEvent(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            JL_Log.e(TAG, "-handleBleConnectedEvent- device is null.");
            return;
        }
        stopChangeMtu();
        getConnectedBle(bluetoothDevice).startSendDataThread();
        handleBleConnection(bluetoothDevice, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBleConnection(BluetoothDevice bluetoothDevice, int i) {
        if (i == 0 || i == 2) {
            this.mHandler.removeMessages(4115);
        }
        JL_Log.i(TAG, "handleBleConnection >> device : " + printDeviceInfo(bluetoothDevice) + ", status : " + i);
        this.mCallbackManager.onBleConnection(bluetoothDevice, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDiscoveryBle(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo) {
        this.mCallbackManager.onDiscoveryBle(bluetoothDevice, bleScanInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getSortList$0(BleDevice bleDevice, BleDevice bleDevice2) {
        if (bleDevice == null && bleDevice2 == null) {
            return 0;
        }
        if (bleDevice == null) {
            return 1;
        }
        if (bleDevice2 == null) {
            return -1;
        }
        return Long.compare(bleDevice2.getConnectedTime(), bleDevice.getConnectedTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        filterDevice(bluetoothDevice, i, bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printDeviceInfo(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putConnectedGattInMap(String str, BluetoothGatt bluetoothGatt) {
        if (!BluetoothAdapter.checkBluetoothAddress(str) || bluetoothGatt == null) {
            return;
        }
        BleDevice bleDevice = new BleDevice(this.mContext, bluetoothGatt);
        bleDevice.setConnectedTime(System.currentTimeMillis());
        this.mConnectedGattMap.put(str, bleDevice);
        if (this.mUsingDevice == null) {
            this.mUsingDevice = bluetoothGatt.getDevice();
        }
        JL_Log.i(TAG, "putConnectedGattInMap >>>>>>>>>>>>> start");
        for (String str2 : this.mConnectedGattMap.keySet()) {
            JL_Log.d(TAG, "putConnectedGattInMap >>>>>>>>>>>>> " + str2);
        }
        JL_Log.i(TAG, "putConnectedGattInMap >>>>>>>>>>>>> end");
    }

    private void registerReceiver() {
        if (this.mAdapterReceiver == null) {
            this.mAdapterReceiver = new BaseBtAdapterReceiver();
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            this.mContext.registerReceiver(this.mAdapterReceiver, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BleDevice removeConnectedBle(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return removeConnectedBle(bluetoothDevice.getAddress());
    }

    private void setConnectedBtDevice(BluetoothDevice bluetoothDevice) {
        this.mUsingDevice = bluetoothDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectingBtDevice(BluetoothDevice bluetoothDevice) {
        this.mConnectingBtDevice = bluetoothDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void startChangeMtu(BluetoothGatt bluetoothGatt, int i) {
        if (bluetoothGatt == null || !AppUtil.checkHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, "-startChangeMtu- param is error.");
            return;
        }
        BluetoothDevice device = bluetoothGatt.getDevice();
        if (device == null) {
            JL_Log.w(TAG, "-startChangeMtu- device is null.");
            return;
        }
        if (this.mHandler.hasMessages(MSG_CHANGE_BLE_MTU_TIMEOUT)) {
            JL_Log.w(TAG, "-startChangeMtu- Adjusting the MTU for BLE");
            return;
        }
        boolean zRequestMtu = i > 20 ? bluetoothGatt.requestMtu(i + 3) : false;
        JL_Log.d(TAG, "-startChangeMtu- ret = " + zRequestMtu);
        if (!zRequestMtu) {
            handleBleConnectedEvent(device);
        } else {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(MSG_CHANGE_BLE_MTU_TIMEOUT, device), 6000L);
        }
    }

    private void startConnectTimeout(BluetoothDevice bluetoothDevice) {
        if (this.mHandler.hasMessages(4113)) {
            return;
        }
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(4113, bluetoothDevice), 40000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopChangeMtu() {
        this.mHandler.removeMessages(MSG_CHANGE_BLE_MTU_TIMEOUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopConnectTimeout() {
        if (this.mHandler.hasMessages(4113)) {
            this.mHandler.removeMessages(4113);
        }
    }

    private void syncSystemBleDevice() {
        List<BluetoothDevice> connectedBleDeviceList = getConnectedBleDeviceList(this.mContext);
        if (connectedBleDeviceList == null || connectedBleDeviceList.isEmpty()) {
            return;
        }
        for (BluetoothDevice bluetoothDevice : connectedBleDeviceList) {
            if (!BluetoothUtil.deviceEquals(bluetoothDevice, this.mUsingDevice) && !this.mDiscoveredBleDevices.contains(bluetoothDevice)) {
                this.mDiscoveredBleDevices.add(bluetoothDevice);
                handleDiscoveryBle(bluetoothDevice, new BleScanInfo().setEnableConnect(true));
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private boolean tryToWriteDescriptor(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i, boolean z) {
        if (!AppUtil.checkHasConnectPermission(this.mContext)) {
            return false;
        }
        if (!z) {
            z = bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            String str = TAG;
            JL_Log.i(str, "..descriptor : .setValue  ret : " + z);
            if (z) {
                i = 0;
            } else {
                i++;
                if (i >= 3) {
                    return false;
                }
                JL_Log.i(str, "-tryToWriteDescriptor- : retryCount : " + i + ", isSkipSetValue :  false");
                SystemClock.sleep(50L);
                tryToWriteDescriptor(bluetoothGatt, bluetoothGattDescriptor, i, false);
            }
        }
        if (z) {
            z = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
            String str2 = TAG;
            JL_Log.i(str2, "..bluetoothGatt : .writeDescriptor  ret : " + z);
            if (!z) {
                int i2 = i + 1;
                if (i2 >= 3) {
                    return false;
                }
                JL_Log.i(str2, "-tryToWriteDescriptor- 2222 : retryCount : " + i2 + ", isSkipSetValue :  true");
                SystemClock.sleep(50L);
                tryToWriteDescriptor(bluetoothGatt, bluetoothGattDescriptor, i2, true);
            }
        }
        return z;
    }

    private void unregisterReceiver() {
        BaseBtAdapterReceiver baseBtAdapterReceiver = this.mAdapterReceiver;
        if (baseBtAdapterReceiver != null) {
            this.mContext.unregisterReceiver(baseBtAdapterReceiver);
            this.mAdapterReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeupSendThread(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, int i, byte[] bArr) {
        BleDevice connectedBle = getConnectedBle(bluetoothGatt.getDevice());
        if (connectedBle != null) {
            SendBleDataThread.BleSendTask bleSendTask = new SendBleDataThread.BleSendTask(bluetoothGatt, uuid, uuid2, bArr, null);
            bleSendTask.setStatus(i);
            connectedBle.wakeupSendThread(bleSendTask);
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean connectBleDevice(BluetoothDevice bluetoothDevice) {
        BluetoothGatt bluetoothGattConnectGatt;
        boolean z = false;
        if (bluetoothDevice != null && AppUtil.checkHasConnectPermission(this.mContext)) {
            if (this.mConnectingBtDevice != null) {
                JL_Log.e(TAG, "BleDevice is connecting, please wait.");
                return isConnectingDevice(bluetoothDevice);
            }
            if (isBleScanning()) {
                stopLeScan();
            }
            try {
                bluetoothGattConnectGatt = bluetoothDevice.connectGatt(this.mContext, false, this.mBluetoothGattCallback, 2);
            } catch (Exception e) {
                e.printStackTrace();
                bluetoothGattConnectGatt = null;
            }
            z = bluetoothGattConnectGatt != null;
            if (z) {
                setConnectingBtDevice(bluetoothDevice);
                handleBleConnection(bluetoothDevice, 1);
                startConnectTimeout(bluetoothDevice);
                JL_Log.d(TAG, "connect start...." + printDeviceInfo(bluetoothDevice));
            }
        }
        return z;
    }

    public void destroy() {
        JL_Log.w(TAG, ">>>>>>>>>>>>>>destroy >>>>>>>>>>>>>>> ");
        unregisterReceiver();
        stopConnectTimeout();
        clearConnectedBleDevices();
        if (isBleScanning()) {
            stopLeScan();
        }
        isBleScanning(false);
        this.mDiscoveredBleDevices.clear();
        this.mReConnectHelper.release();
        this.mCallbackManager.release();
        this.mHandler.removeCallbacksAndMessages(null);
        instance = null;
    }

    @SuppressLint({"MissingPermission"})
    public void disconnectBleDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !AppUtil.checkHasConnectPermission(this.mContext)) {
            return;
        }
        BleDevice bleDeviceRemoveConnectedBle = removeConnectedBle(bluetoothDevice);
        String str = TAG;
        JL_Log.i(str, "disconnectBleDevice : " + printDeviceInfo(bluetoothDevice) + ", " + bleDeviceRemoveConnectedBle);
        if (bleDeviceRemoveConnectedBle == null) {
            JL_Log.i(str, "disconnectBleDevice : It is not a connected device.");
        } else if (BluetoothUtil.isBluetoothEnable()) {
            bleDeviceRemoveConnectedBle.getGatt().disconnect();
        }
    }

    public int getBleMtu(BluetoothDevice bluetoothDevice) {
        BleDevice connectedBle = getConnectedBle(bluetoothDevice);
        if (connectedBle == null) {
            return 0;
        }
        return connectedBle.getMtu();
    }

    public BluetoothDevice getConnectedBLEDevice(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return null;
        }
        List<BluetoothDevice> connectedDeviceList = getConnectedDeviceList();
        if (connectedDeviceList.isEmpty()) {
            return null;
        }
        for (BluetoothDevice bluetoothDevice : connectedDeviceList) {
            if (bluetoothDevice.getAddress().equals(str)) {
                return bluetoothDevice;
            }
        }
        return null;
    }

    public BluetoothDevice getConnectedBtDevice() {
        return this.mUsingDevice;
    }

    public BluetoothGatt getConnectedBtGatt(BluetoothDevice bluetoothDevice) {
        BleDevice connectedBle = getConnectedBle(bluetoothDevice);
        if (connectedBle == null) {
            return null;
        }
        return connectedBle.getGatt();
    }

    public List<BluetoothDevice> getConnectedDeviceList() {
        if (this.mConnectedGattMap.isEmpty()) {
            return new ArrayList();
        }
        List<BleDevice> sortList = getSortList();
        ArrayList arrayList = new ArrayList();
        for (BleDevice bleDevice : sortList) {
            if (bleDevice != null && bleDevice.getGatt().getDevice() != null) {
                arrayList.add(bleDevice.getGatt().getDevice());
            }
        }
        return arrayList;
    }

    public boolean isBleScanning() {
        return this.isBleScanning;
    }

    public boolean isBluetoothEnable() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public boolean isConnectedDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        return isConnectedDevice(bluetoothDevice.getAddress());
    }

    public boolean isConnecting() {
        return this.mConnectingBtDevice != null;
    }

    public boolean isConnectingDevice(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.deviceEquals(this.mConnectingBtDevice, bluetoothDevice);
    }

    public boolean isMatchReConnectDevice(String str, String str2) {
        return this.mReConnectHelper.isMatchAddress(str, str2);
    }

    public void reconnectDevice(String str, boolean z) {
        String str2 = TAG;
        JL_Log.d(str2, "reconnectDevice : address = " + str + ", isUseAdv = " + z);
        boolean zPutParam = this.mReConnectHelper.putParam(new ReConnectHelper.ReconnectParam(str, z));
        StringBuilder sb = new StringBuilder();
        sb.append("reconnectDevice : ret = ");
        sb.append(zPutParam);
        JL_Log.d(str2, sb.toString());
    }

    public void registerBleEventCallback(BleEventCallback bleEventCallback) {
        this.mCallbackManager.registerBleEventCallback(bleEventCallback);
    }

    @SuppressLint({"MissingPermission"})
    public boolean startLeScan(long j) {
        boolean zStartLeScan = false;
        if (this.mBluetoothAdapter != null && AppUtil.checkHasScanPermission(this.mContext) && isBluetoothEnable() && AppUtil.isHasLocationPermission(this.mContext)) {
            if (j <= 0) {
                j = 12000;
            }
            zStartLeScan = true;
            if (this.isBleScanning) {
                JL_Log.i(TAG, "scanning ble .....");
                BluetoothLeScanner bluetoothLeScanner = this.mBluetoothLeScanner;
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.flushPendingScanResults(this.mScanCallback);
                }
                this.mDiscoveredBleDevices.clear();
                this.mHandler.removeMessages(4112);
                this.mHandler.sendEmptyMessageDelayed(4112, j);
                syncSystemBleDevice();
                return true;
            }
            if (this.mBluetoothLeScanner != null) {
                this.mBluetoothLeScanner.startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(1).setMatchMode(1).build(), this.mScanCallback);
            } else {
                zStartLeScan = this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            }
            JL_Log.i(TAG, "startLeScan : " + zStartLeScan + ", timeout = " + j);
            isBleScanning(zStartLeScan);
            if (zStartLeScan) {
                this.mDiscoveredBleDevices.clear();
                this.mHandler.removeMessages(4112);
                this.mHandler.sendEmptyMessageDelayed(4112, j);
                syncSystemBleDevice();
            }
        }
        return zStartLeScan;
    }

    @SuppressLint({"MissingPermission"})
    public void stopLeScan() {
        if (this.mBluetoothAdapter != null && isBluetoothEnable() && AppUtil.checkHasScanPermission(this.mContext) && isBleScanning()) {
            try {
                BluetoothLeScanner bluetoothLeScanner = this.mBluetoothLeScanner;
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.stopScan(this.mScanCallback);
                } else {
                    this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mHandler.removeMessages(4112);
            this.mHandler.removeMessages(4114);
            isBleScanning(false);
        }
    }

    public void unregisterBleEventCallback(BleEventCallback bleEventCallback) {
        this.mCallbackManager.unregisterBleEventCallback(bleEventCallback);
    }

    public void writeDataByBleAsync(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr, OnWriteDataCallback onWriteDataCallback) {
        addSendTask(bluetoothDevice, uuid, uuid2, bArr, onWriteDataCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isBleScanning(boolean z) {
        this.isBleScanning = z;
        this.mCallbackManager.onDiscoveryBleChange(z);
        if (this.isBleScanning && this.configHelper.isHidDevice()) {
            this.mHandler.sendEmptyMessage(4114);
        }
    }

    private BleDevice removeConnectedBle(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return null;
        }
        BleDevice bleDeviceRemove = this.mConnectedGattMap.remove(str);
        if (bleDeviceRemove != null) {
            bleDeviceRemove.stopSendDataThread();
            if (this.mConnectedGattMap.isEmpty()) {
                setConnectedBtDevice(null);
            } else if (bleDeviceRemove.getGatt().getDevice() != null && BluetoothUtil.deviceEquals(bleDeviceRemove.getGatt().getDevice(), getConnectedBtDevice())) {
                setConnectedBtDevice(getSortList().get(0).getGatt().getDevice());
            }
        }
        return bleDeviceRemove;
    }

    public boolean isConnectedDevice(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return false;
        }
        List<BluetoothDevice> connectedDeviceList = getConnectedDeviceList();
        if (connectedDeviceList.isEmpty()) {
            return false;
        }
        Iterator<BluetoothDevice> it = connectedDeviceList.iterator();
        while (it.hasNext()) {
            if (it.next().getAddress().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
