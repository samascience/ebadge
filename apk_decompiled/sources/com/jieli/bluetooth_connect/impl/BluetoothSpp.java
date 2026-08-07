package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.bluetooth_connect.interfaces.IBluetoothSpp;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener;
import com.jieli.bluetooth_connect.tool.ReceiveSppDataThread;
import com.jieli.bluetooth_connect.tool.SppEventCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.CHexConverter;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothSpp implements IBluetoothSpp {
    private static final int DELAY_TIME = 1000;
    private static final int MSG_CONNECT_SPP = 41014;
    private static final int MSG_CONNECT_SPP_TIMEOUT = 41013;
    private static final int MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT = 41015;
    private static final String TAG = "BluetoothSpp";
    private static final int WAIT_TIMEOUT = 3000;
    private final BluetoothBrEdr mBluetoothBrEdr;
    private BluetoothOption mBluetoothOption;
    private final BluetoothPair mBluetoothPair;
    private volatile BluetoothDevice mConnectedSppDevice;
    private volatile BluetoothDevice mConnectingSppDevice;
    private ConnectionSppThread mConnectionSppThread;
    private final Context mContext;
    private final OnBrEdrListener mOnBrEdrListener;
    private final OnBtDevicePairListener mOnBtDevicePairListener;
    private final ReceiveSppDataThread.OnRecvSppDataListener mOnRecvSppDataListener;
    private final SppEventCbManager mSppEventCbManager;
    private BluetoothSppReceiver mSppReceiver;
    private final List<BluetoothDevice> mConnectedSppDevices = Collections.synchronizedList(new ArrayList());
    private final Map<String, BluetoothSocket> mSppSocketMap = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReceiveSppDataThread> mSppRecvThreadMap = Collections.synchronizedMap(new HashMap());
    private final ExecutorService mThreadPool = Executors.newFixedThreadPool(8);
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case BluetoothSpp.MSG_CONNECT_SPP_TIMEOUT /* 41013 */:
                    BluetoothDevice bluetoothDevice = BluetoothSpp.this.mConnectingSppDevice;
                    JL_Log.d(BluetoothSpp.TAG, "MSG_CONNECT_SPP_TIMEOUT", "device : " + BluetoothSpp.this.printfDeviceInfo(bluetoothDevice));
                    if (bluetoothDevice != null && !BluetoothSpp.this.isConnectedSppDevice(bluetoothDevice)) {
                        BluetoothSpp.this.notifySppState(bluetoothDevice, 0);
                        break;
                    }
                    break;
                case BluetoothSpp.MSG_CONNECT_SPP /* 41014 */:
                    BluetoothDevice bluetoothDevice2 = BluetoothSpp.this.mConnectingSppDevice;
                    JL_Log.d(BluetoothSpp.TAG, "MSG_CONNECT_SPP", "device : " + BluetoothSpp.this.printfDeviceInfo(bluetoothDevice2));
                    if (bluetoothDevice2 != null) {
                        BluetoothSpp.this.startConnectSpp(bluetoothDevice2);
                    }
                    break;
                case BluetoothSpp.MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT /* 41015 */:
                    BluetoothDevice bluetoothDevice3 = BluetoothSpp.this.mConnectingSppDevice;
                    JL_Log.d(BluetoothSpp.TAG, "MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT", "device : " + BluetoothSpp.this.printfDeviceInfo(bluetoothDevice3));
                    if (bluetoothDevice3 != null) {
                        BluetoothSpp.this.mHandler.sendEmptyMessage(BluetoothSpp.MSG_CONNECT_SPP);
                    }
                    break;
            }
            return true;
        }
    });

    private class BluetoothSppReceiver extends BroadcastReceiver {
        private BluetoothSppReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !"android.bluetooth.device.action.UUID".equals(action) || (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) == null || !ConnectUtil.isHasConnectPermission(context)) {
                return;
            }
            Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
            if (parcelableArrayExtra == null) {
                BluetoothSpp.this.handleDeviceUuids(bluetoothDevice, null);
                JL_Log.i(BluetoothSpp.TAG, "ACTION_UUID", "no uuids");
                return;
            }
            ParcelUuid[] parcelUuidArr = new ParcelUuid[parcelableArrayExtra.length];
            for (int i = 0; i < parcelableArrayExtra.length; i++) {
                parcelUuidArr[i] = ParcelUuid.fromString(parcelableArrayExtra[i].toString());
                JL_Log.i(BluetoothSpp.TAG, "ACTION_UUID", "uuid : " + parcelUuidArr[i].toString());
            }
            BluetoothSpp.this.handleDeviceUuids(bluetoothDevice, parcelUuidArr);
        }
    }

    private class ConnectionSppThread extends Thread {
        private static final String tag = "ConnectionThread";
        private final BluetoothDevice mDevice;

        @Override // java.lang.Thread, java.lang.Runnable
        @SuppressLint({"MissingPermission"})
        public synchronized void run() {
            BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
            int i;
            JL_Log.i(BluetoothSpp.TAG, tag, "spp connect start. Device : " + BluetoothSpp.this.printfDeviceInfo(this.mDevice) + ", uuid : " + BluetoothSpp.this.mBluetoothOption.getSppUUID());
            if (this.mDevice != null && ConnectUtil.isHasConnectPermission(BluetoothSpp.this.mContext)) {
                if (!BluetoothUtil.deviceHasProfile(BluetoothSpp.this.mContext, this.mDevice, BluetoothSpp.this.mBluetoothOption.getSppUUID())) {
                    JL_Log.e(BluetoothSpp.TAG, tag, "device no spp uuid. " + BluetoothSpp.this.mBluetoothOption.getSppUUID());
                }
                try {
                    bluetoothSocketCreateRfcommSocketToServiceRecord = this.mDevice.createRfcommSocketToServiceRecord(BluetoothSpp.this.mBluetoothOption.getSppUUID());
                    try {
                        bluetoothSocketCreateRfcommSocketToServiceRecord.connect();
                        i = 2;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        JL_Log.e(BluetoothSpp.TAG, tag, "spp connect occurred exception : " + e.getMessage());
                        i = 0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bluetoothSocketCreateRfcommSocketToServiceRecord = null;
                }
                if (2 != i) {
                    JL_Log.e(BluetoothSpp.TAG, tag, "spp connect failed. " + BluetoothSpp.this.printfDeviceInfo(this.mDevice));
                    BluetoothSpp.this.notifySppState(this.mDevice, i);
                    BluetoothSpp.this.mConnectionSppThread = null;
                    return;
                }
                JL_Log.i(BluetoothSpp.TAG, tag, "spp connect ok. " + BluetoothSpp.this.printfDeviceInfo(this.mDevice));
                if (BluetoothSpp.this.mConnectedSppDevice == null) {
                    BluetoothSpp.this.setConnectedSppDevice(this.mDevice);
                }
                if (!BluetoothSpp.this.mConnectedSppDevices.contains(this.mDevice)) {
                    BluetoothSpp.this.mConnectedSppDevices.add(this.mDevice);
                    BluetoothSpp.this.mSppSocketMap.put(this.mDevice.getAddress(), bluetoothSocketCreateRfcommSocketToServiceRecord);
                    BluetoothSpp.this.startReceiveDataThread(this.mDevice, bluetoothSocketCreateRfcommSocketToServiceRecord);
                }
                BluetoothSpp.this.notifySppState(this.mDevice, 2);
            }
            BluetoothSpp.this.mConnectionSppThread = null;
            JL_Log.i(BluetoothSpp.TAG, tag, "exit");
        }

        private ConnectionSppThread(BluetoothDevice bluetoothDevice) {
            super(tag);
            this.mDevice = bluetoothDevice;
        }
    }

    public BluetoothSpp(Context context, BluetoothBrEdr bluetoothBrEdr, BluetoothOption bluetoothOption, OnBtSppListener onBtSppListener) {
        OnBtDevicePairListener onBtDevicePairListener = new OnBtDevicePairListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.2
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onAdapterStatus(boolean z, boolean z2) {
                if (z) {
                    return;
                }
                BluetoothSpp.this.clearDevices();
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onBtDeviceBond(BluetoothDevice bluetoothDevice, int i) {
                if (BluetoothUtil.deviceEquals(bluetoothDevice, BluetoothSpp.this.mConnectingSppDevice)) {
                    JL_Log.w(BluetoothSpp.TAG, "onBtDeviceBond", "device : " + BluetoothSpp.this.printfDeviceInfo(bluetoothDevice) + ", status : " + i);
                    if (i != 12) {
                        if (i == 10) {
                            BluetoothSpp.this.notifySppState(bluetoothDevice, 0);
                            return;
                        }
                        return;
                    }
                    BluetoothSpp.this.mHandler.removeMessages(BluetoothSpp.MSG_CONNECT_SPP_TIMEOUT);
                    BluetoothSpp.this.mHandler.sendEmptyMessageDelayed(BluetoothSpp.MSG_CONNECT_SPP_TIMEOUT, 30000L);
                    if (!BluetoothUtil.deviceHasA2dp(BluetoothSpp.this.mContext, bluetoothDevice) && !BluetoothUtil.deviceHasHfp(BluetoothSpp.this.mContext, bluetoothDevice)) {
                        JL_Log.i(BluetoothSpp.TAG, "onBtDeviceBond", "device has not a2dp and hfp.");
                        BluetoothSpp.this.mHandler.sendEmptyMessage(BluetoothSpp.MSG_CONNECT_SPP);
                    } else {
                        JL_Log.d(BluetoothSpp.TAG, "onBtDeviceBond", "Waiting for a2dp or hfp connect.");
                        BluetoothSpp.this.mHandler.removeMessages(BluetoothSpp.MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT);
                        BluetoothSpp.this.mHandler.sendEmptyMessageDelayed(BluetoothSpp.MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT, 3000L);
                    }
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onPairError(BluetoothDevice bluetoothDevice, ErrorInfo errorInfo) {
                if (BluetoothUtil.deviceEquals(bluetoothDevice, BluetoothSpp.this.mConnectingSppDevice)) {
                    BluetoothSpp.this.notifySppState(bluetoothDevice, 0);
                }
            }
        };
        this.mOnBtDevicePairListener = onBtDevicePairListener;
        OnBrEdrListener onBrEdrListener = new OnBrEdrListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.3
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onA2dpStatus(BluetoothDevice bluetoothDevice, int i) {
                BluetoothSpp.this.checkNeedConnect(bluetoothDevice, i);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onBrEdrConnection(BluetoothDevice bluetoothDevice, int i) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onDeviceUuids(BluetoothDevice bluetoothDevice, ParcelUuid[] parcelUuidArr) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onEdrService(boolean z, int i, BluetoothProfile bluetoothProfile) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onHfpStatus(BluetoothDevice bluetoothDevice, int i) {
                BluetoothSpp.this.checkNeedConnect(bluetoothDevice, i);
            }
        };
        this.mOnBrEdrListener = onBrEdrListener;
        this.mOnRecvSppDataListener = new ReceiveSppDataThread.OnRecvSppDataListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.4
            @Override // com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.OnRecvSppDataListener
            public void onRecvSppData(long j, BluetoothDevice bluetoothDevice, byte[] bArr) {
                JL_Log.d(BluetoothSpp.TAG, ConnectUtil.formatString("[onRecvSppData] <<< device : %s, data [ %s ].", bluetoothDevice, CHexConverter.byte2HexStr(bArr)));
                BluetoothSpp.this.mSppEventCbManager.onSppDataNotify(bluetoothDevice, BluetoothSpp.this.mBluetoothOption.getSppUUID(), bArr);
            }

            @Override // com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.OnRecvSppDataListener
            public void onThreadStart(long j) {
            }

            @Override // com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.OnRecvSppDataListener
            public void onThreadStop(long j, int i, BluetoothDevice bluetoothDevice) {
                JL_Log.w(BluetoothSpp.TAG, "onThreadStop", "reason : " + i);
                BluetoothSpp.this.disconnectSPPDevice(bluetoothDevice);
            }
        };
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        BluetoothBrEdr bluetoothBrEdr2 = (BluetoothBrEdr) ConnectUtil.checkNotNull(bluetoothBrEdr);
        this.mBluetoothBrEdr = bluetoothBrEdr2;
        BluetoothPair bluetoothPair = bluetoothBrEdr.getBluetoothPair();
        this.mBluetoothPair = bluetoothPair;
        bluetoothBrEdr2.addListener(onBrEdrListener);
        bluetoothPair.addListener(onBtDevicePairListener);
        this.mSppEventCbManager = new SppEventCbManager();
        this.mBluetoothOption = bluetoothOption == null ? BluetoothOption.createDefaultOption() : bluetoothOption;
        addListener(onBtSppListener);
        registerSppReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNeedConnect(BluetoothDevice bluetoothDevice, int i) {
        if (BluetoothUtil.deviceEquals(bluetoothDevice, this.mConnectingSppDevice)) {
            if (i == 1) {
                this.mHandler.removeMessages(MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT);
                return;
            }
            JL_Log.d(TAG, "checkNeedConnect", "a2dp or hfp connect finish.");
            this.mHandler.removeMessages(MSG_CONNECT_SPP);
            this.mHandler.sendEmptyMessageDelayed(MSG_CONNECT_SPP, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDevices() {
        JL_Log.d(TAG, "clearDevices", Constants.STR_EMPTY);
        Iterator it = new ArrayList(this.mConnectedSppDevices).iterator();
        while (it.hasNext()) {
            disconnectSpp((BluetoothDevice) it.next());
        }
        if (!this.mSppSocketMap.isEmpty()) {
            Iterator<String> it2 = this.mSppSocketMap.keySet().iterator();
            while (it2.hasNext()) {
                BluetoothSocket bluetoothSocket = this.mSppSocketMap.get(it2.next());
                if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
                    try {
                        bluetoothSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        this.mSppSocketMap.clear();
        this.mSppRecvThreadMap.clear();
        this.mConnectedSppDevices.clear();
        setConnectingSppDevice(null);
        setConnectedSppDevice(null);
    }

    private boolean disconnectSpp(BluetoothDevice bluetoothDevice) {
        String str = TAG;
        JL_Log.i(str, "disconnectSpp", "device : " + printfDeviceInfo(bluetoothDevice));
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(str, "disconnectSpp", "param is error.");
            return false;
        }
        if (!this.mConnectedSppDevices.contains(bluetoothDevice)) {
            JL_Log.i(str, "disconnectSpp", "device is not connected device.");
            return true;
        }
        BluetoothSocket bluetoothSocketRemove = this.mSppSocketMap.remove(bluetoothDevice.getAddress());
        if (bluetoothSocketRemove != null && bluetoothSocketRemove.isConnected()) {
            try {
                bluetoothSocketRemove.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ReceiveSppDataThread receiveSppDataThreadRemove = this.mSppRecvThreadMap.remove(bluetoothDevice.getAddress());
        if (receiveSppDataThreadRemove != null) {
            receiveSppDataThreadRemove.stopThread();
        }
        this.mConnectedSppDevices.remove(bluetoothDevice);
        JL_Log.i(TAG, "disconnectSpp", "remove connected device ok.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeviceUuids(BluetoothDevice bluetoothDevice, ParcelUuid[] parcelUuidArr) {
        if (BluetoothUtil.deviceEquals(bluetoothDevice, this.mConnectingSppDevice)) {
            JL_Log.d(TAG, "handleDeviceUuids", "get uuid success.");
            this.mHandler.sendEmptyMessage(MSG_CONNECT_SPP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySppState(BluetoothDevice bluetoothDevice, int i) {
        notifySppState(bluetoothDevice, this.mBluetoothOption.getSppUUID(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printfDeviceInfo(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice);
    }

    private void registerSppReceiver() {
        if (this.mSppReceiver == null) {
            this.mSppReceiver = new BluetoothSppReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.UUID");
            this.mContext.registerReceiver(this.mSppReceiver, intentFilter);
        }
    }

    private void removeDevice(BluetoothDevice bluetoothDevice) {
        if (this.mConnectedSppDevices.isEmpty()) {
            setConnectedSppDevice(null);
        } else if (BluetoothUtil.deviceEquals(bluetoothDevice, this.mConnectedSppDevice)) {
            List<BluetoothDevice> list = this.mConnectedSppDevices;
            setConnectedSppDevice(list.get(list.size() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConnectSpp(BluetoothDevice bluetoothDevice) {
        JL_Log.i(TAG, "startConnectSpp", "device : " + printfDeviceInfo(bluetoothDevice) + ", Connect thread : " + this.mConnectionSppThread);
        if (bluetoothDevice == null || this.mConnectionSppThread != null) {
            return;
        }
        ConnectionSppThread connectionSppThread = new ConnectionSppThread(bluetoothDevice);
        this.mConnectionSppThread = connectionSppThread;
        connectionSppThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReceiveDataThread(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket) {
        JL_Log.e(TAG, "startReceiveDataThread", "socket : " + bluetoothSocket);
        ReceiveSppDataThread receiveSppDataThread = new ReceiveSppDataThread(bluetoothDevice, bluetoothSocket, this.mOnRecvSppDataListener);
        if (this.mThreadPool.isShutdown()) {
            return;
        }
        this.mThreadPool.submit(receiveSppDataThread);
        this.mSppRecvThreadMap.put(bluetoothDevice.getAddress(), receiveSppDataThread);
    }

    private void stopConnectSpp() {
        ConnectionSppThread connectionSppThread = this.mConnectionSppThread;
        if (connectionSppThread != null) {
            try {
                if (connectionSppThread.isAlive()) {
                    this.mConnectionSppThread.interrupt();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mConnectionSppThread = null;
        }
    }

    private void unregisterSppReceiver() {
        BluetoothSppReceiver bluetoothSppReceiver = this.mSppReceiver;
        if (bluetoothSppReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothSppReceiver);
            this.mSppReceiver = null;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    @SuppressLint({"MissingPermission"})
    public boolean connectSPPDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.i(TAG, "connectSPPDevice", "device is bad object. ");
            return false;
        }
        String str = TAG;
        JL_Log.i(str, "connectSPPDevice", "device : " + printfDeviceInfo(bluetoothDevice));
        if (this.mConnectingSppDevice != null) {
            JL_Log.i(str, "connectSPPDevice", "ConnectingSppDevice is connecting. ConnectingSppDevice : " + printfDeviceInfo(this.mConnectedSppDevice));
            return false;
        }
        if (isConnectedSppDevice(bluetoothDevice)) {
            notifySppState(bluetoothDevice, 2);
            return true;
        }
        if (!this.mBluetoothOption.isUseMultiDevice() && this.mConnectedSppDevice != null && !BluetoothUtil.deviceEquals(this.mConnectedSppDevice, bluetoothDevice)) {
            disconnectSPPDevice(this.mConnectedSppDevice);
            SystemClock.sleep(300L);
        }
        setConnectingSppDevice(bluetoothDevice);
        boolean zIsPaired = this.mBluetoothPair.isPaired(bluetoothDevice);
        JL_Log.i(str, "connectSPPDevice", "isPaired : " + zIsPaired);
        if (!zIsPaired) {
            boolean zTryToPair = this.mBluetoothPair.tryToPair(bluetoothDevice);
            JL_Log.i(str, "connectSPPDevice", "tryToPair : " + zTryToPair);
            if (!zTryToPair) {
                notifySppState(bluetoothDevice, 0);
                JL_Log.w(str, "connectSPPDevice", "tryToPair is failed.");
                return false;
            }
        } else if (bluetoothDevice.getUuids() != null && BluetoothUtil.deviceHasProfile(this.mContext, bluetoothDevice, this.mBluetoothOption.getSppUUID())) {
            JL_Log.i(str, "connectSPPDevice", "start connect spp.");
            this.mHandler.sendEmptyMessage(MSG_CONNECT_SPP);
        } else if (!bluetoothDevice.fetchUuidsWithSdp()) {
            notifySppState(bluetoothDevice, 0);
            JL_Log.w(str, "connectSPPDevice", "fetchUuidsWithSdp is failed.");
            return false;
        }
        notifySppState(bluetoothDevice, 1);
        this.mHandler.removeMessages(MSG_CONNECT_SPP_TIMEOUT);
        this.mHandler.sendEmptyMessageDelayed(MSG_CONNECT_SPP_TIMEOUT, 40000L);
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        JL_Log.d(TAG, "destroy", Constants.STR_EMPTY);
        this.mSppEventCbManager.destroy();
        this.mBluetoothPair.removeListener(this.mOnBtDevicePairListener);
        this.mBluetoothBrEdr.removeListener(this.mOnBrEdrListener);
        stopConnectSpp();
        clearDevices();
        if (!this.mThreadPool.isShutdown()) {
            this.mThreadPool.shutdownNow();
        }
        unregisterSppReceiver();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public boolean disconnectSPPDevice(BluetoothDevice bluetoothDevice) {
        JL_Log.i(TAG, "disconnectSPPDevice", "device : " + printfDeviceInfo(bluetoothDevice));
        boolean zDisconnectSpp = disconnectSpp(bluetoothDevice);
        if (zDisconnectSpp) {
            notifySppState(bluetoothDevice, 0);
        }
        return zDisconnectSpp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public BluetoothDevice getConnectedSPPDevice() {
        return this.mConnectedSppDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public List<BluetoothDevice> getConnectedSppDevices() {
        return new ArrayList(this.mConnectedSppDevices);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public BluetoothDevice getSppConnectingDevice() {
        return this.mConnectingSppDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public boolean isConnectedSppDevice(BluetoothDevice bluetoothDevice) {
        BluetoothSocket bluetoothSocket;
        if (bluetoothDevice == null || (bluetoothSocket = this.mSppSocketMap.get(bluetoothDevice.getAddress())) == null) {
            return false;
        }
        return bluetoothSocket.isConnected();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public boolean isSppConnecting() {
        return this.mConnectingSppDevice != null;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption bluetoothOption) {
        if (bluetoothOption != null) {
            this.mBluetoothOption = bluetoothOption;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public void setConnectedSppDevice(BluetoothDevice bluetoothDevice) {
        if (BluetoothUtil.deviceEquals(this.mConnectedSppDevice, bluetoothDevice)) {
            return;
        }
        this.mConnectedSppDevice = bluetoothDevice;
        if (bluetoothDevice != null) {
            this.mSppEventCbManager.onSwitchSppDevice(bluetoothDevice);
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public void setConnectingSppDevice(BluetoothDevice bluetoothDevice) {
        this.mConnectingSppDevice = bluetoothDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public synchronized boolean writeDataToSppDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        if (bArr == null || bluetoothDevice == null) {
            JL_Log.w(TAG, "writeDataToSppDevice", "param is error.");
            return false;
        }
        if (!isConnectedSppDevice(bluetoothDevice)) {
            JL_Log.w(TAG, "writeDataToSppDevice", "device is disconnected.");
            return false;
        }
        BluetoothSocket bluetoothSocket = this.mSppSocketMap.get(bluetoothDevice.getAddress());
        if (bluetoothSocket == null || !bluetoothSocket.isConnected()) {
            JL_Log.w(TAG, "writeDataToSppDevice", "spp socket is close.");
            return false;
        }
        try {
            bluetoothSocket.getOutputStream().write(bArr);
            JL_Log.i(TAG, ConnectUtil.formatString("[writeDataToSppDevice] >>> send data successful. device : %s, data [ %s ].", bluetoothDevice, CHexConverter.byte2HexStr(bArr)));
            return true;
        } catch (Exception e) {
            JL_Log.w(TAG, "writeDataToSppDevice", "have an exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    private void notifySppState(BluetoothDevice bluetoothDevice, UUID uuid, int i) {
        JL_Log.i(TAG, "notifySppState", "device : " + printfDeviceInfo(bluetoothDevice) + ", status : " + BluetoothConstant.printBtConnection(i));
        if (i != 1) {
            if (BluetoothUtil.deviceEquals(this.mConnectingSppDevice, bluetoothDevice)) {
                setConnectingSppDevice(null);
                this.mHandler.removeMessages(MSG_CONNECT_SPP_TIMEOUT);
            }
            if (i == 0) {
                removeDevice(bluetoothDevice);
            }
        }
        this.mSppEventCbManager.onSppConnection(bluetoothDevice, uuid, i);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtSppListener onBtSppListener) {
        this.mSppEventCbManager.addListener(onBtSppListener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtSppListener onBtSppListener) {
        this.mSppEventCbManager.removeListener(onBtSppListener);
    }
}
