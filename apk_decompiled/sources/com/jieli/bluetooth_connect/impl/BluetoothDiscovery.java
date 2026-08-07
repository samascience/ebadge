package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener;
import com.jieli.bluetooth_connect.tool.BtDiscoveryCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.jieli.bluetooth_connect.util.ParseDataUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothDiscovery implements IBluetoothDiscovery {
    private static final int MSG_DISCOVERY_BLE_TIMEOUT = 1011;
    private static final int MSG_DISCOVERY_EDR_TIMEOUT = 1022;
    public static int SCAN_MIN_TIMEOUT = 2000;
    private static final String TAG = "BluetoothDiscovery";
    private boolean isBleScanning;
    private boolean isEdrScanning;
    private final BluetoothAdapter mBluetoothAdapter;
    private BluetoothDiscoveryReceiver mBluetoothDiscoveryReceiver;
    private BluetoothLeScanner mBluetoothLeScanner;
    private BluetoothOption mBluetoothOption;
    private BluetoothReceiver mBluetoothReceiver;
    private final BtDiscoveryCbManager mBtDiscoveryCbManager;
    private final Context mContext;
    private int mScanType;
    private long scanTotalTime;
    private long startBleScanTime;
    private long startEdrScanTime;
    private final List<BluetoothDevice> mDiscoveredDevices = new ArrayList();
    private final List<BluetoothDevice> mDiscoveredEdrDevices = new ArrayList();
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: lk
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.lambda$new$0(message);
        }
    });
    private final BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: nk
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.a.lambda$new$1(bluetoothDevice, i, bArr);
        }
    };
    private final ScanCallback mScanCallback = new ScanCallback() { // from class: com.jieli.bluetooth_connect.impl.BluetoothDiscovery.1
        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            super.onScanFailed(i);
            JL_Log.e(BluetoothDiscovery.TAG, "onScanFailed", "errorCode : " + i);
            BluetoothDiscovery.this.mBtDiscoveryCbManager.onDiscoveryError(ErrorInfo.buildError(8, i, null));
            BluetoothDiscovery.this.notifyDiscoveryStatus(true, false);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            if (scanResult == null || scanResult.getScanRecord() == null) {
                return;
            }
            BluetoothDiscovery.this.filterDevice(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes(), scanResult.isConnectable());
        }
    };

    private class BluetoothDiscoveryReceiver extends BroadcastReceiver {
        private BluetoothDiscoveryReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
            }
            Objects.requireNonNull(action);
            switch (action) {
                case "android.bluetooth.adapter.action.DISCOVERY_FINISHED":
                    JL_Log.i(BluetoothDiscovery.TAG, "ACTION_DISCOVERY_FINISHED", "isDeviceScanning : " + BluetoothDiscovery.this.isDeviceScanning());
                    BluetoothDiscovery.this.notifyDiscoveryStatus(false, false);
                    break;
                case "android.bluetooth.adapter.action.DISCOVERY_STARTED":
                    JL_Log.i(BluetoothDiscovery.TAG, "ACTION_DISCOVERY_STARTED", "isDeviceScanning : " + BluetoothDiscovery.this.isDeviceScanning());
                    BluetoothDiscovery.this.notifyDiscoveryStatus(false, true);
                    break;
                case "android.bluetooth.device.action.FOUND":
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) -1);
                    if (bluetoothDevice != null && BluetoothUtil.isBluetoothEnable() && ConnectUtil.isHasConnectPermission(context) && BluetoothDiscovery.this.isDeviceScanning()) {
                        int type = bluetoothDevice.getType();
                        int i = BluetoothDiscovery.this.mScanType;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                }
                            } else if (1 != type) {
                            }
                        } else if (2 != type && 3 != type) {
                        }
                        if (!BluetoothDiscovery.this.mDiscoveredEdrDevices.contains(bluetoothDevice)) {
                            BluetoothDiscovery.this.mDiscoveredEdrDevices.add(bluetoothDevice);
                            BluetoothDiscovery.this.mBtDiscoveryCbManager.onDiscoveryDevice(bluetoothDevice, new BleScanMessage().setEnableConnect(true).setRssi(shortExtra));
                        }
                        break;
                    }
                    break;
            }
        }
    }

    private class BluetoothReceiver extends BroadcastReceiver {
        private BluetoothReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()) && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0) == 10) {
                BluetoothDiscovery.this.mDiscoveredDevices.clear();
                BluetoothDiscovery.this.mDiscoveredEdrDevices.clear();
                if (BluetoothDiscovery.this.isScanning()) {
                    BluetoothDiscovery bluetoothDiscovery = BluetoothDiscovery.this;
                    bluetoothDiscovery.notifyDiscoveryStatus(bluetoothDiscovery.mScanType == 0, false);
                }
            }
        }
    }

    public BluetoothDiscovery(Context context, BluetoothOption bluetoothOption, OnBtDiscoveryListener onBtDiscoveryListener) {
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        setBluetoothOption(bluetoothOption);
        this.mBtDiscoveryCbManager = new BtDiscoveryCbManager();
        addListener(onBtDiscoveryListener);
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        getBluetoothLeScanner();
        registerBtReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void filterDevice(BluetoothDevice bluetoothDevice, int i, byte[] bArr, boolean z) {
        if (bluetoothDevice != null && ConnectUtil.isHasConnectPermission(this.mContext) && BluetoothUtil.isBluetoothEnable()) {
            boolean z2 = (this.mBluetoothOption.isSkipNoneNameDevice() && TextUtils.isEmpty(bluetoothDevice.getName())) ? false : true;
            if (this.mBluetoothOption.getBleScanStrategy() == 0) {
                if (!z2 || this.mDiscoveredDevices.contains(bluetoothDevice)) {
                    return;
                }
                BleScanMessage oTAFlagFilterWithBroad = ParseDataUtil.parseOTAFlagFilterWithBroad(bArr, this.mBluetoothOption.getOtaScanFilterData());
                if (oTAFlagFilterWithBroad == null) {
                    oTAFlagFilterWithBroad = new BleScanMessage();
                }
                this.mDiscoveredDevices.add(bluetoothDevice);
                this.mBtDiscoveryCbManager.onDiscoveryDevice(bluetoothDevice, oTAFlagFilterWithBroad.setRawData(bArr).setRssi(i).setEnableConnect(z));
                return;
            }
            BleScanMessage bleScanMessageIsFilterBleDevice = ParseDataUtil.isFilterBleDevice(this.mBluetoothOption, bArr);
            if (bleScanMessageIsFilterBleDevice == null || !z2) {
                return;
            }
            if (bleScanMessageIsFilterBleDevice.isEnableConnect() && !z) {
                bleScanMessageIsFilterBleDevice.setEnableConnect(false);
            }
            bleScanMessageIsFilterBleDevice.setRawData(bArr).setRssi(i);
            if (bleScanMessageIsFilterBleDevice.isShowDialog()) {
                this.mBtDiscoveryCbManager.onShowProductDialog(bluetoothDevice, bleScanMessageIsFilterBleDevice);
            }
            if (this.mDiscoveredDevices.contains(bluetoothDevice)) {
                return;
            }
            this.mDiscoveredDevices.add(bluetoothDevice);
            this.mBtDiscoveryCbManager.onDiscoveryDevice(bluetoothDevice, bleScanMessageIsFilterBleDevice);
        }
    }

    private BluetoothLeScanner getBluetoothLeScanner() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && this.mBluetoothLeScanner == null) {
            this.mBluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
        }
        return this.mBluetoothLeScanner;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        int i = message.what;
        if (i == MSG_DISCOVERY_BLE_TIMEOUT) {
            boolean zIsBleScanning = isBleScanning();
            JL_Log.w(TAG, "MSG_DISCOVERY_BLE_TIMEOUT", "bleScanning = " + zIsBleScanning);
            if (zIsBleScanning) {
                stopBleScan(true);
            }
        } else if (i == MSG_DISCOVERY_EDR_TIMEOUT) {
            boolean zIsDeviceScanning = isDeviceScanning();
            JL_Log.w(TAG, "MSG_DISCOVERY_EDR_TIMEOUT", "deviceScanning = " + zIsDeviceScanning);
            if (zIsDeviceScanning) {
                stopDeviceScan(true);
                notifyDiscoveryStatus(false, false);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        filterDevice(bluetoothDevice, i, bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDiscoveryStatus(boolean z, boolean z2) {
        JL_Log.i(TAG, "notifyDiscoveryStatus", "bBle : " + z + ", bStart : " + z2 + ", mScanType : " + this.mScanType);
        int i = this.mScanType;
        if (!z2) {
            if (z) {
                this.startBleScanTime = 0L;
                setBleScanning(false);
                this.mHandler.removeMessages(MSG_DISCOVERY_BLE_TIMEOUT);
            } else {
                this.startEdrScanTime = 0L;
                setDeviceScanning(false);
                unregisterReceiver();
                this.mHandler.removeMessages(MSG_DISCOVERY_EDR_TIMEOUT);
            }
            this.mScanType = 0;
        }
        if (i == 0 && z) {
            this.mBtDiscoveryCbManager.onDiscoveryStatusChange(true, z2);
        } else {
            if (i != 1 || z) {
                return;
            }
            this.mBtDiscoveryCbManager.onDiscoveryStatusChange(false, z2);
        }
    }

    private void registerBtReceiver() {
        if (this.mBluetoothReceiver == null) {
            this.mBluetoothReceiver = new BluetoothReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            this.mContext.registerReceiver(this.mBluetoothReceiver, intentFilter);
        }
    }

    private void registerReceiver() {
        if (this.mBluetoothDiscoveryReceiver == null) {
            this.mBluetoothDiscoveryReceiver = new BluetoothDiscoveryReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            this.mContext.registerReceiver(this.mBluetoothDiscoveryReceiver, intentFilter);
        }
    }

    private void setBleScanning(boolean z) {
        this.isBleScanning = z;
    }

    private void setDeviceScanning(boolean z) {
        this.isEdrScanning = z;
    }

    @SuppressLint({"MissingPermission"})
    private boolean stopBleScan(boolean z) {
        if (this.mBluetoothAdapter == null || !ConnectUtil.isHasScanPermission(this.mContext)) {
            JL_Log.e(TAG, "stopBleScan", "this device is not supported bluetooth.");
            return false;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            return false;
        }
        if (!isBleScanning()) {
            return true;
        }
        long currentTime = getCurrentTime() - this.startBleScanTime;
        if (!z && currentTime < SCAN_MIN_TIMEOUT) {
            JL_Log.i(TAG, "stopBleScan", "Turn on time is too short. usedTime = " + currentTime + ", SCAN_MIN_TIMEOUT = " + SCAN_MIN_TIMEOUT);
            this.mHandler.removeMessages(MSG_DISCOVERY_BLE_TIMEOUT);
            this.mHandler.sendEmptyMessageDelayed(MSG_DISCOVERY_BLE_TIMEOUT, ((long) SCAN_MIN_TIMEOUT) - currentTime);
            return true;
        }
        if (getBluetoothLeScanner() != null) {
            try {
                JL_Log.d(TAG, "stopBleScan", "stopScan");
                this.mBluetoothLeScanner.stopScan(this.mScanCallback);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                JL_Log.d(TAG, "stopBleScan", "stopLeScan");
                this.mBluetoothAdapter.stopLeScan(this.leScanCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        notifyDiscoveryStatus(true, false);
        return true;
    }

    private void unregisterBtReceiver() {
        BluetoothReceiver bluetoothReceiver = this.mBluetoothReceiver;
        if (bluetoothReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothReceiver);
            this.mBluetoothReceiver = null;
        }
    }

    private void unregisterReceiver() {
        BluetoothDiscoveryReceiver bluetoothDiscoveryReceiver = this.mBluetoothDiscoveryReceiver;
        if (bluetoothDiscoveryReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothDiscoveryReceiver);
            this.mBluetoothDiscoveryReceiver = null;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        this.mBtDiscoveryCbManager.destroy();
        stopDeviceScan(true);
        stopBleScan(true);
        unregisterReceiver();
        unregisterBtReceiver();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public ArrayList<BluetoothDevice> getDiscoveredBluetoothDevices() {
        return this.mScanType == 0 ? new ArrayList<>(this.mDiscoveredDevices) : new ArrayList<>(this.mDiscoveredEdrDevices);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public int getScanType() {
        return this.mScanType;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean isBleScanning() {
        return this.isBleScanning;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean isDeviceScanning() {
        return this.isEdrScanning;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean isScanning() {
        return isDeviceScanning() || isBleScanning();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption bluetoothOption) {
        if (bluetoothOption == null) {
            bluetoothOption = BluetoothOption.createDefaultOption();
        }
        this.mBluetoothOption = bluetoothOption;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    @SuppressLint({"MissingPermission"})
    public boolean startBLEScan(long j) {
        boolean zStartLeScan;
        if (!ConnectUtil.isHasScanPermission(this.mContext)) {
            JL_Log.e(TAG, "startBLEScan", "No Bluetooth scanning permission.");
            return false;
        }
        if (!ConnectUtil.isHasLocationPermission(this.mContext)) {
            JL_Log.e(TAG, "startBLEScan", "No location permission.");
            return false;
        }
        if (this.mBluetoothAdapter == null) {
            JL_Log.e(TAG, "startBLEScan", "this device is not supported bluetooth.");
            return false;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.w(TAG, "startBLEScan", "Bluetooth adapter is close.");
            return false;
        }
        if (isDeviceScanning()) {
            stopDeviceScan(true);
        }
        if (isBleScanning()) {
            long currentTime = this.scanTotalTime - (getCurrentTime() - this.startBleScanTime);
            JL_Log.i(TAG, "startBLEScan", "scanning ble ..... left timeout : " + currentTime);
            return true;
        }
        if (getBluetoothLeScanner() != null) {
            this.mBluetoothLeScanner.startScan(new ArrayList(), new ScanSettings.Builder().setScanMode(this.mBluetoothOption.getBleScanMode()).setMatchMode(1).build(), this.mScanCallback);
            JL_Log.d(TAG, "startBLEScan", "startScan : true ");
            zStartLeScan = true;
        } else {
            zStartLeScan = this.mBluetoothAdapter.startLeScan(this.leScanCallback);
            JL_Log.d(TAG, "startBLEScan", "startLeScan : " + zStartLeScan);
        }
        if (zStartLeScan) {
            this.mScanType = 0;
            this.mDiscoveredDevices.clear();
            setBleScanning(true);
            if (j < SCAN_MIN_TIMEOUT) {
                j = 8000;
            }
            this.startBleScanTime = getCurrentTime();
            this.scanTotalTime = j;
            JL_Log.d(TAG, "startBLEScan", "scanTotalTime : " + this.scanTotalTime);
            this.mHandler.removeMessages(MSG_DISCOVERY_BLE_TIMEOUT);
            this.mHandler.sendEmptyMessageDelayed(MSG_DISCOVERY_BLE_TIMEOUT, j);
            notifyDiscoveryStatus(true, true);
        }
        return zStartLeScan;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean startDeviceScan(long j) {
        return startDeviceScan(1, j);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean stopBLEScan() {
        return stopBleScan(false);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean stopDeviceScan() {
        return stopDeviceScan(false);
    }

    @SuppressLint({"MissingPermission"})
    private boolean stopDeviceScan(boolean z) {
        if (this.mBluetoothAdapter == null || !ConnectUtil.isHasScanPermission(this.mContext)) {
            JL_Log.e(TAG, "stopDeviceScan", " this device is not supported bluetooth.");
            return false;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            return false;
        }
        if (!isDeviceScanning()) {
            return true;
        }
        long currentTime = getCurrentTime() - this.startEdrScanTime;
        if (z || currentTime >= SCAN_MIN_TIMEOUT) {
            boolean zCancelDiscovery = this.mBluetoothAdapter.cancelDiscovery();
            JL_Log.d(TAG, "stopDeviceScan", "cancelDiscovery : " + zCancelDiscovery);
            return zCancelDiscovery;
        }
        JL_Log.i(TAG, "stopDeviceScan", "Turn on time is too short. usedTime = " + currentTime + ", SCAN_MIN_TIMEOUT = " + SCAN_MIN_TIMEOUT);
        this.mHandler.removeMessages(MSG_DISCOVERY_EDR_TIMEOUT);
        this.mHandler.sendEmptyMessageDelayed(MSG_DISCOVERY_EDR_TIMEOUT, ((long) SCAN_MIN_TIMEOUT) - currentTime);
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtDiscoveryListener onBtDiscoveryListener) {
        this.mBtDiscoveryCbManager.addListener(onBtDiscoveryListener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtDiscoveryListener onBtDiscoveryListener) {
        this.mBtDiscoveryCbManager.removeListener(onBtDiscoveryListener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    @SuppressLint({"MissingPermission"})
    public boolean startDeviceScan(int i, long j) {
        if (!ConnectUtil.isHasScanPermission(this.mContext)) {
            JL_Log.e(TAG, "startDeviceScan", "No Bluetooth scanning permission.");
            return false;
        }
        if (!ConnectUtil.isHasLocationPermission(this.mContext)) {
            JL_Log.e(TAG, "startDeviceScan", "No location permission.");
            return false;
        }
        if (this.mBluetoothAdapter == null) {
            JL_Log.e(TAG, "startDeviceScan", "this device is not supported bluetooth.");
            return false;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.e(TAG, "startDeviceScan", "Bluetooth is not turned on.");
            return false;
        }
        if (i == 0) {
            return startBLEScan(j);
        }
        if (isBleScanning()) {
            JL_Log.w(TAG, "startDeviceScan", "stopBLEScan");
            stopBleScan(true);
        }
        if (isDeviceScanning()) {
            long currentTime = this.scanTotalTime - (getCurrentTime() - this.startEdrScanTime);
            JL_Log.i(TAG, "startDeviceScan", "scanning edr ..... ScanType : " + this.mScanType + ", leftTime : " + currentTime);
            return true;
        }
        registerReceiver();
        boolean zStartDiscovery = this.mBluetoothAdapter.startDiscovery();
        JL_Log.i(TAG, "startDeviceScan", "startDiscovery : " + zStartDiscovery);
        if (zStartDiscovery) {
            this.mScanType = i;
            this.mDiscoveredEdrDevices.clear();
            setDeviceScanning(true);
            if (j < SCAN_MIN_TIMEOUT) {
                j = 8000;
            }
            this.startEdrScanTime = getCurrentTime();
            this.scanTotalTime = j;
            this.mHandler.removeMessages(MSG_DISCOVERY_EDR_TIMEOUT);
            this.mHandler.sendEmptyMessageDelayed(MSG_DISCOVERY_EDR_TIMEOUT, j);
        } else {
            unregisterReceiver();
        }
        return zStartDiscovery;
    }
}
