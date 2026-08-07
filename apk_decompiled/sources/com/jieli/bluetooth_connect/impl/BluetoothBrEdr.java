package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.tool.BrEdrEventCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothBrEdr implements IBluetoothBrEdr {
    private static final int MSG_CONNECT_EDR_TIMEOUT = 26145;
    private static final String TAG = "BluetoothBrEdr";
    private volatile boolean isInitA2dp;
    private volatile boolean isInitHfp;
    private BluetoothA2dp mBluetoothA2dp;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothHandFreeReceiver mBluetoothHandFreeReceiver;
    private BluetoothHeadset mBluetoothHfp;
    private BluetoothOption mBluetoothOption;
    private final BluetoothPair mBluetoothPair;
    private final BrEdrEventCbManager mBrEdrEventCbManager;
    private volatile BluetoothDevice mConnectingEdr;
    private final Context mContext;
    private final OnBtDevicePairListener mOnBtDevicePairListener;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: hk
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.lambda$new$0(message);
        }
    });
    private final BluetoothProfile.ServiceListener mBTServiceListener = new BluetoothProfile.ServiceListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBrEdr.1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            JL_Log.i(BluetoothBrEdr.TAG, "onServiceConnected", "profile = " + i);
            if (2 == i) {
                BluetoothBrEdr.this.mBluetoothA2dp = (BluetoothA2dp) bluetoothProfile;
                BluetoothBrEdr.this.isInitA2dp = false;
            } else if (1 == i) {
                BluetoothBrEdr.this.mBluetoothHfp = (BluetoothHeadset) bluetoothProfile;
                BluetoothBrEdr.this.isInitHfp = false;
            }
            BluetoothBrEdr.this.mBrEdrEventCbManager.onEdrService(true, i, bluetoothProfile);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            JL_Log.i(BluetoothBrEdr.TAG, "onServiceDisconnected", "profile = " + i);
            if (2 == i) {
                BluetoothBrEdr.this.mBluetoothA2dp = null;
                BluetoothBrEdr.this.isInitA2dp = false;
            } else if (1 == i) {
                BluetoothBrEdr.this.mBluetoothHfp = null;
                BluetoothBrEdr.this.isInitHfp = false;
            }
            BluetoothBrEdr.this.mBrEdrEventCbManager.onEdrService(false, i, null);
        }
    };

    private class BluetoothHandFreeReceiver extends BroadcastReceiver {
        private BluetoothHandFreeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            BluetoothDevice bluetoothDevice;
            if (intent == null || (action = intent.getAction()) == null || action.isEmpty() || (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) == null) {
                return;
            }
            switch (action) {
                case "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED":
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 11);
                    JL_Log.i(BluetoothBrEdr.TAG, "A2DP#ACTION_PLAYING_STATE_CHANGED", "state : " + intExtra);
                    break;
                case "android.bluetooth.device.action.UUID":
                    Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
                    if (parcelableArrayExtra == null) {
                        BluetoothBrEdr.this.onDeviceUuids(bluetoothDevice, null);
                        JL_Log.i(BluetoothBrEdr.TAG, "ACTION_UUID", "no uuids");
                        break;
                    } else {
                        ParcelUuid[] parcelUuidArr = new ParcelUuid[parcelableArrayExtra.length];
                        for (int i = 0; i < parcelableArrayExtra.length; i++) {
                            ParcelUuid parcelUuidFromString = ParcelUuid.fromString(parcelableArrayExtra[i].toString());
                            parcelUuidArr[i] = parcelUuidFromString;
                            JL_Log.i(BluetoothBrEdr.TAG, "ACTION_UUID", parcelUuidFromString.toString());
                        }
                        BluetoothBrEdr.this.onDeviceUuids(bluetoothDevice, parcelUuidArr);
                        break;
                    }
                    break;
                case "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED":
                    try {
                        int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        JL_Log.i(BluetoothBrEdr.TAG, "HFP#ACTION_CONNECTION_STATE_CHANGED", "device : " + BluetoothBrEdr.this.printDeviceInfo(bluetoothDevice) + ", state : " + intExtra2);
                        if (intExtra2 != -1) {
                            BluetoothBrEdr.this.onHfpStatus(bluetoothDevice, intExtra2);
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                    break;
                case "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED":
                    try {
                        int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        JL_Log.i(BluetoothBrEdr.TAG, "A2DP#ACTION_CONNECTION_STATE_CHANGED", "device : " + BluetoothBrEdr.this.printDeviceInfo(bluetoothDevice) + ", state : " + intExtra3);
                        if (intExtra3 != -1) {
                            BluetoothBrEdr.this.onA2dpStatus(bluetoothDevice, intExtra3);
                            break;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                    break;
            }
        }
    }

    public BluetoothBrEdr(Context context, BluetoothPair bluetoothPair, OnBrEdrListener onBrEdrListener) {
        OnBtDevicePairListener onBtDevicePairListener = new OnBtDevicePairListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBrEdr.2
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onAdapterStatus(boolean z, boolean z2) {
                BluetoothDevice connectingBrEdrDevice;
                if (z || (connectingBrEdrDevice = BluetoothBrEdr.this.getConnectingBrEdrDevice()) == null) {
                    return;
                }
                BluetoothBrEdr.this.startConnectionTimeout(connectingBrEdrDevice, 0L);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            @SuppressLint({"MissingPermission"})
            public void onBtDeviceBond(BluetoothDevice bluetoothDevice, int i) {
                if (BluetoothUtil.deviceEquals(bluetoothDevice, BluetoothBrEdr.this.getConnectingBrEdrDevice())) {
                    JL_Log.i(BluetoothBrEdr.TAG, "onBtDeviceBond", ConnectUtil.formatString("device : [%s], status : %d", BluetoothBrEdr.this.printDeviceInfo(bluetoothDevice), Integer.valueOf(i)));
                    if (i == 10) {
                        BluetoothBrEdr.this.onBrEdrConnection(bluetoothDevice, 0);
                    } else if (i == 12) {
                        if (ConnectUtil.isHasConnectPermission(BluetoothBrEdr.this.mContext) && bluetoothDevice.getType() != 1) {
                            BluetoothBrEdr.this.tryToConnectBrEdr(bluetoothDevice);
                        }
                        BluetoothBrEdr.this.startConnectionTimeout(bluetoothDevice, 30000L);
                    }
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onPairError(BluetoothDevice bluetoothDevice, ErrorInfo errorInfo) {
                if (BluetoothUtil.deviceEquals(bluetoothDevice, BluetoothBrEdr.this.getConnectingBrEdrDevice())) {
                    JL_Log.w(BluetoothBrEdr.TAG, "onPairError", ConnectUtil.formatString("device : [%s], error : %s", BluetoothBrEdr.this.printDeviceInfo(bluetoothDevice), errorInfo));
                    BluetoothBrEdr.this.onBrEdrConnection(bluetoothDevice, 0);
                }
            }
        };
        this.mOnBtDevicePairListener = onBtDevicePairListener;
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        BluetoothPair bluetoothPair2 = (BluetoothPair) ConnectUtil.checkNotNull(bluetoothPair);
        this.mBluetoothPair = bluetoothPair2;
        bluetoothPair2.addListener(onBtDevicePairListener);
        this.mBrEdrEventCbManager = new BrEdrEventCbManager();
        addListener(onBrEdrListener);
        initBrEdrService(context);
        registerReceiver();
    }

    private boolean checkA2dpBadEnv(String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, str, "device is null");
            return true;
        }
        if (this.mBluetoothA2dp != null) {
            return false;
        }
        JL_Log.w(TAG, str, "BluetoothA2dp is null");
        return true;
    }

    private boolean checkHfpBadEnv(String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, str, "device is null");
            return true;
        }
        if (this.mBluetoothHfp != null) {
            return false;
        }
        JL_Log.w(TAG, str, "BluetoothHfp is null");
        return true;
    }

    private void initBrEdrService(Context context) {
        if (context == null) {
            return;
        }
        android.bluetooth.BluetoothManager bluetoothManager = (android.bluetooth.BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.mBluetoothAdapter = bluetoothManager.getAdapter();
        }
        if (this.mBluetoothAdapter == null) {
            this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.mBluetoothAdapter == null) {
            JL_Log.w(TAG, "initBrEdrService", "The device does not support Bluetooth.");
            return;
        }
        if (this.mBluetoothA2dp == null && !this.isInitA2dp) {
            try {
                this.isInitA2dp = this.mBluetoothAdapter.getProfileProxy(context, this.mBTServiceListener, 2);
                if (!this.isInitA2dp) {
                    JL_Log.w(TAG, "initBrEdrService", "getProfileProxy: a2dp error.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mBluetoothHfp != null || this.isInitHfp) {
            return;
        }
        try {
            this.isInitHfp = this.mBluetoothAdapter.getProfileProxy(context, this.mBTServiceListener, 1);
            if (this.isInitHfp) {
                return;
            }
            JL_Log.w(TAG, "initBrEdrService", "getProfileProxy: hfp error");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        if (message.what != MSG_CONNECT_EDR_TIMEOUT) {
            return true;
        }
        Object obj = message.obj;
        if (!(obj instanceof BluetoothDevice)) {
            return false;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
        JL_Log.i(TAG, "MSG_CONNECT_EDR_TIMEOUT", "connectingDev : " + printDeviceInfo(bluetoothDevice));
        if (isConnectedByProfile(bluetoothDevice) == 2) {
            return true;
        }
        onBrEdrConnection(bluetoothDevice, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onA2dpStatus(BluetoothDevice bluetoothDevice, int i) {
        String str = TAG;
        JL_Log.d(str, "onA2dpStatus", ConnectUtil.formatString("device : [%s], status : %s", printDeviceInfo(bluetoothDevice), BluetoothUtil.connectionString(i)));
        this.mBrEdrEventCbManager.onA2dpStatus(bluetoothDevice, i);
        if (i == 0) {
            onBrEdrConnection(bluetoothDevice, 0);
            return;
        }
        if (i == 2) {
            onBrEdrConnection(bluetoothDevice, 2);
            int iIsConnectedByHfp = isConnectedByHfp(bluetoothDevice);
            JL_Log.i(str, "onA2dpStatus", "a2dp is connected, hfp status = " + BluetoothUtil.connectionString(iIsConnectedByHfp));
            if (iIsConnectedByHfp != 2) {
                connectByProfiles(bluetoothDevice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBrEdrConnection(BluetoothDevice bluetoothDevice, int i) {
        JL_Log.d(TAG, "onBrEdrConnection", ConnectUtil.formatString("device : [%s], status : %s", printDeviceInfo(bluetoothDevice), BluetoothUtil.connectionString(i)));
        if (i != 1 && BluetoothUtil.deviceEquals(bluetoothDevice, getConnectingBrEdrDevice())) {
            setConnectingEdr(null);
            this.mHandler.removeMessages(MSG_CONNECT_EDR_TIMEOUT);
        }
        this.mBrEdrEventCbManager.onBrEdrConnection(bluetoothDevice, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceUuids(BluetoothDevice bluetoothDevice, ParcelUuid[] parcelUuidArr) {
        this.mBrEdrEventCbManager.onDeviceUuids(bluetoothDevice, parcelUuidArr);
        if (!BluetoothUtil.deviceEquals(bluetoothDevice, getConnectingBrEdrDevice()) || connectByProfiles(bluetoothDevice)) {
            return;
        }
        onBrEdrConnection(bluetoothDevice, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHfpStatus(BluetoothDevice bluetoothDevice, int i) {
        String str = TAG;
        JL_Log.d(str, "onHfpStatus", ConnectUtil.formatString("device : [%s], status : %s", printDeviceInfo(bluetoothDevice), BluetoothUtil.connectionString(i)));
        this.mBrEdrEventCbManager.onHfpStatus(bluetoothDevice, i);
        if (i == 0) {
            onBrEdrConnection(bluetoothDevice, 0);
            return;
        }
        if (i == 2) {
            int iIsConnectedByA2dp = isConnectedByA2dp(bluetoothDevice);
            JL_Log.i(str, "onHfpStatus", "hfp is connected, a2dp status = " + BluetoothUtil.connectionString(iIsConnectedByA2dp));
            if (iIsConnectedByA2dp != 2) {
                connectByProfiles(bluetoothDevice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printDeviceInfo(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice);
    }

    private void registerReceiver() {
        if (this.mBluetoothHandFreeReceiver == null) {
            this.mBluetoothHandFreeReceiver = new BluetoothHandFreeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.UUID");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            this.mContext.registerReceiver(this.mBluetoothHandFreeReceiver, intentFilter);
        }
    }

    private void setConnectingEdr(BluetoothDevice bluetoothDevice) {
        this.mConnectingEdr = bluetoothDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConnectionTimeout(BluetoothDevice bluetoothDevice, long j) {
        this.mHandler.removeMessages(MSG_CONNECT_EDR_TIMEOUT);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(MSG_CONNECT_EDR_TIMEOUT, bluetoothDevice), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public boolean tryToConnectBrEdr(BluetoothDevice bluetoothDevice) {
        boolean zFetchUuidsWithSdp;
        String str;
        if (bluetoothDevice == null) {
            return false;
        }
        if (bluetoothDevice.getUuids() == null || bluetoothDevice.getUuids().length == 0 || !(BluetoothUtil.deviceHasA2dp(this.mContext, bluetoothDevice) || BluetoothUtil.deviceHasHfp(this.mContext, bluetoothDevice))) {
            zFetchUuidsWithSdp = bluetoothDevice.fetchUuidsWithSdp();
            str = "fetchUuidsWithSdp";
        } else {
            zFetchUuidsWithSdp = connectByProfiles(bluetoothDevice);
            str = "connectByProfiles";
        }
        if (zFetchUuidsWithSdp) {
            JL_Log.i(TAG, "tryToConnectBrEdr", str + " success.");
        } else {
            onBrEdrConnection(bluetoothDevice, 0);
            JL_Log.w(TAG, "tryToConnectBrEdr", str + " failed.");
        }
        return zFetchUuidsWithSdp;
    }

    private void unregisterReceiver() {
        BluetoothHandFreeReceiver bluetoothHandFreeReceiver = this.mBluetoothHandFreeReceiver;
        if (bluetoothHandFreeReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothHandFreeReceiver);
            this.mBluetoothHandFreeReceiver = null;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public boolean connectBrEdrDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, "connectBrEdrDevice", "device is null.");
            return false;
        }
        BluetoothDevice connectingBrEdrDevice = getConnectingBrEdrDevice();
        if (connectingBrEdrDevice != null) {
            JL_Log.w(TAG, "connectBrEdrDevice", "Classic device is connecting. connecting device : " + printDeviceInfo(connectingBrEdrDevice));
            return false;
        }
        setConnectingEdr(bluetoothDevice);
        boolean zIsPaired = this.mBluetoothPair.isPaired(bluetoothDevice);
        String str = TAG;
        JL_Log.d(str, "connectBrEdrDevice", "isPaired : " + zIsPaired);
        if (!zIsPaired) {
            boolean zTryToPair = this.mBluetoothPair.tryToPair(bluetoothDevice);
            JL_Log.d(str, "connectBrEdrDevice", "tryToPair : " + zTryToPair);
            if (!zTryToPair) {
                onBrEdrConnection(bluetoothDevice, 0);
                return false;
            }
        } else if (!tryToConnectBrEdr(bluetoothDevice)) {
            return false;
        }
        onBrEdrConnection(bluetoothDevice, 1);
        startConnectionTimeout(bluetoothDevice, 40000L);
        JL_Log.d(str, "connectBrEdrDevice", "Start connecting classic Bluetooth.");
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean connectByA2dp(BluetoothDevice bluetoothDevice) {
        if (checkA2dpBadEnv("connectByA2dp", bluetoothDevice)) {
            return false;
        }
        int iIsConnectedByA2dp = isConnectedByA2dp(bluetoothDevice);
        String str = TAG;
        JL_Log.i(str, "connectByA2dp", "deviceA2dpStatus : " + BluetoothUtil.connectionString(iIsConnectedByA2dp));
        if (iIsConnectedByA2dp == 1) {
            JL_Log.d(str, "connectByA2dp", "A2DP is connecting.");
            return true;
        }
        if (iIsConnectedByA2dp == 2) {
            onA2dpStatus(bluetoothDevice, iIsConnectedByA2dp);
            return true;
        }
        boolean zConnectDeviceA2dp = BluetoothUtil.connectDeviceA2dp(this.mContext, this.mBluetoothA2dp, bluetoothDevice);
        JL_Log.i(str, "connectByA2dp", "ret : " + zConnectDeviceA2dp);
        return zConnectDeviceA2dp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean connectByHfp(BluetoothDevice bluetoothDevice) {
        if (checkHfpBadEnv("connectByHfp", bluetoothDevice)) {
            return false;
        }
        if (!BluetoothUtil.deviceHasHfp(this.mContext, bluetoothDevice)) {
            JL_Log.w(TAG, "connectByHfp", "no found hfp service");
            return false;
        }
        int iIsConnectedByHfp = isConnectedByHfp(bluetoothDevice);
        String str = TAG;
        JL_Log.d(str, "connectByHfp", "deviceHfpStatus : " + BluetoothUtil.connectionString(iIsConnectedByHfp));
        if (iIsConnectedByHfp != 1) {
            if (iIsConnectedByHfp != 2) {
                boolean zConnectDeviceHfp = BluetoothUtil.connectDeviceHfp(this.mContext, this.mBluetoothHfp, bluetoothDevice);
                JL_Log.d(str, "connectByHfp", "ret : " + zConnectDeviceHfp);
                return zConnectDeviceHfp;
            }
            onHfpStatus(bluetoothDevice, iIsConnectedByHfp);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a2 A[RETURN] */
    /* JADX WARN: Instruction removed from duplicated block: B:28:0x0088, please report this as an issue */
    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public boolean connectByProfiles(BluetoothDevice bluetoothDevice) {
        int iIsConnectedByA2dp;
        boolean zConnectByA2dp;
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, "connectByProfiles", "device is null.");
            return false;
        }
        String str = TAG;
        JL_Log.d(str, "connectByProfiles", "device : " + printDeviceInfo(bluetoothDevice));
        BluetoothOption bluetoothOption = this.mBluetoothOption;
        boolean z = bluetoothOption == null || bluetoothOption.isSupportA2DP();
        boolean z2 = z && BluetoothUtil.deviceHasA2dp(this.mContext, bluetoothDevice);
        JL_Log.d(str, "connectByProfiles", "supportA2dp : " + z + ", devHasA2dp : " + z2);
        if (z2) {
            iIsConnectedByA2dp = isConnectedByA2dp(bluetoothDevice);
            JL_Log.d(str, "connectByProfiles", "deviceA2dpStatus : " + BluetoothUtil.connectionString(iIsConnectedByA2dp));
            if (iIsConnectedByA2dp == 0) {
                zConnectByA2dp = connectByA2dp(bluetoothDevice);
                JL_Log.d(str, "connectByProfiles", "connectByA2dp : " + zConnectByA2dp);
                if (zConnectByA2dp) {
                    return true;
                }
            } else {
                if (iIsConnectedByA2dp == 1) {
                    return true;
                }
                if (iIsConnectedByA2dp == 3) {
                    zConnectByA2dp = connectByA2dp(bluetoothDevice);
                    JL_Log.d(str, "connectByProfiles", "connectByA2dp : " + zConnectByA2dp);
                    if (zConnectByA2dp) {
                        return true;
                    }
                }
            }
        } else {
            JL_Log.i(str, "connectByProfiles", "no a2dp.");
            iIsConnectedByA2dp = 0;
        }
        boolean zDeviceHasHfp = BluetoothUtil.deviceHasHfp(this.mContext, bluetoothDevice);
        JL_Log.d(str, "connectByProfiles", "devHasHfp : " + zDeviceHasHfp);
        if (zDeviceHasHfp) {
            int iIsConnectedByHfp = isConnectedByHfp(bluetoothDevice);
            JL_Log.d(str, "connectByProfiles", "deviceHfpStatus : " + BluetoothUtil.connectionString(iIsConnectedByHfp));
            if (iIsConnectedByHfp != 1) {
                if (iIsConnectedByHfp != 2) {
                    boolean zConnectByHfp = connectByHfp(bluetoothDevice);
                    JL_Log.d(str, "connectByProfiles", "connectByHfp : " + zConnectByHfp);
                    if (zConnectByHfp) {
                        return true;
                    }
                } else {
                    onBrEdrConnection(bluetoothDevice, 2);
                }
            }
            return true;
        }
        JL_Log.i(str, "connectByProfiles", "no hfp.");
        if (iIsConnectedByA2dp == 2) {
            onBrEdrConnection(bluetoothDevice, 2);
            return true;
        }
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        setConnectingEdr(null);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mBluetoothPair.removeListener(this.mOnBtDevicePairListener);
        this.mBrEdrEventCbManager.destroy();
        unregisterReceiver();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public boolean disconnectByProfiles(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, "disconnectByProfiles", "device is null");
            return false;
        }
        String str = TAG;
        JL_Log.d(str, "disconnectByProfiles", "device : " + printDeviceInfo(bluetoothDevice));
        int iIsConnectedByA2dp = isConnectedByA2dp(bluetoothDevice);
        boolean zDisconnectFromA2dp = iIsConnectedByA2dp == 2 ? disconnectFromA2dp(bluetoothDevice) : false;
        int iIsConnectedByHfp = isConnectedByHfp(bluetoothDevice);
        if (iIsConnectedByHfp == 2) {
            zDisconnectFromA2dp = disconnectFromHfp(bluetoothDevice);
        }
        if (iIsConnectedByA2dp == 0 && iIsConnectedByHfp == 0) {
            onBrEdrConnection(bluetoothDevice, 0);
            zDisconnectFromA2dp = true;
        }
        JL_Log.d(str, "disconnectByProfiles", "ret :  " + zDisconnectFromA2dp);
        return zDisconnectFromA2dp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean disconnectFromA2dp(BluetoothDevice bluetoothDevice) {
        if (checkA2dpBadEnv("disconnectFromA2dp", bluetoothDevice)) {
            return false;
        }
        int iIsConnectedByA2dp = isConnectedByA2dp(bluetoothDevice);
        String str = TAG;
        JL_Log.d(str, "disconnectFromA2dp", "deviceA2dpStatus : " + BluetoothUtil.connectionString(iIsConnectedByA2dp));
        if (iIsConnectedByA2dp == 1) {
            JL_Log.d(str, "disconnectFromA2dp", "A2DP is connecting.");
            return false;
        }
        if (iIsConnectedByA2dp != 2) {
            onA2dpStatus(bluetoothDevice, 0);
            return true;
        }
        boolean zDisconnectDeviceA2dp = BluetoothUtil.disconnectDeviceA2dp(this.mContext, this.mBluetoothA2dp, bluetoothDevice);
        JL_Log.d(str, "disconnectFromA2dp", "ret : " + zDisconnectDeviceA2dp);
        return zDisconnectDeviceA2dp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean disconnectFromHfp(BluetoothDevice bluetoothDevice) {
        if (checkHfpBadEnv("disconnectFromHfp", bluetoothDevice)) {
            return false;
        }
        int iIsConnectedByHfp = isConnectedByHfp(bluetoothDevice);
        String str = TAG;
        JL_Log.d(str, "disconnectFromHfp", "deviceHfpStatus : " + BluetoothUtil.connectionString(iIsConnectedByHfp));
        if (iIsConnectedByHfp == 1) {
            JL_Log.d(str, "disconnectFromHfp", "HFP is connecting.");
            return false;
        }
        if (iIsConnectedByHfp != 2) {
            onHfpStatus(bluetoothDevice, 0);
            return true;
        }
        boolean zDisconnectDeviceHfp = BluetoothUtil.disconnectDeviceHfp(this.mContext, this.mBluetoothHfp, bluetoothDevice);
        JL_Log.d(str, "disconnectFromHfp", "ret : " + zDisconnectDeviceHfp);
        return zDisconnectDeviceHfp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public BluetoothDevice getActivityBluetoothDevice() {
        return BluetoothUtil.getActivityDevice(this.mContext, this.mBluetoothA2dp);
    }

    public BluetoothA2dp getBluetoothA2dp() {
        return this.mBluetoothA2dp;
    }

    public BluetoothHeadset getBluetoothHfp() {
        return this.mBluetoothHfp;
    }

    public BluetoothPair getBluetoothPair() {
        return this.mBluetoothPair;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public BluetoothDevice getConnectingBrEdrDevice() {
        return this.mConnectingEdr;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean isBrEdrConnecting() {
        return getConnectingBrEdrDevice() != null;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public int isConnectedByA2dp(BluetoothDevice bluetoothDevice) {
        if (checkA2dpBadEnv("isConnectedByA2dp", bluetoothDevice)) {
            return 0;
        }
        List<BluetoothDevice> connectedDevices = this.mBluetoothA2dp.getConnectedDevices();
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    return 2;
                }
            }
        }
        return this.mBluetoothA2dp.getConnectionState(bluetoothDevice);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public int isConnectedByHfp(BluetoothDevice bluetoothDevice) {
        if (checkHfpBadEnv("isConnectedByHfp", bluetoothDevice)) {
            return 0;
        }
        List<BluetoothDevice> connectedDevices = this.mBluetoothHfp.getConnectedDevices();
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    return 2;
                }
            }
        }
        return this.mBluetoothHfp.getConnectionState(bluetoothDevice);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public int isConnectedByProfile(BluetoothDevice bluetoothDevice) {
        BluetoothOption bluetoothOption = this.mBluetoothOption;
        int iIsConnectedByA2dp = ((bluetoothOption == null || bluetoothOption.isSupportA2DP()) && BluetoothUtil.deviceHasA2dp(this.mContext, bluetoothDevice)) ? isConnectedByA2dp(bluetoothDevice) : 0;
        if (iIsConnectedByA2dp == 2) {
            return iIsConnectedByA2dp;
        }
        int iIsConnectedByHfp = BluetoothUtil.deviceHasHfp(this.mContext, bluetoothDevice) ? isConnectedByHfp(bluetoothDevice) : 0;
        if (iIsConnectedByHfp == 2) {
            return iIsConnectedByHfp;
        }
        return 0;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public boolean setActivityBluetoothDevice(BluetoothDevice bluetoothDevice) {
        List<BluetoothDevice> connectedDevices;
        if (((bluetoothDevice == null || this.mBluetoothA2dp == null) && ConnectUtil.isHasConnectPermission(this.mContext)) || (connectedDevices = this.mBluetoothA2dp.getConnectedDevices()) == null || !connectedDevices.contains(bluetoothDevice)) {
            return false;
        }
        return BluetoothUtil.setActivityDevice(this.mContext, this.mBluetoothA2dp, bluetoothDevice);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption bluetoothOption) {
        this.mBluetoothOption = bluetoothOption;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBrEdrListener onBrEdrListener) {
        this.mBrEdrEventCbManager.addListener(onBrEdrListener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBrEdrListener onBrEdrListener) {
        this.mBrEdrEventCbManager.removeListener(onBrEdrListener);
    }

    public boolean connectByA2dp(String str) {
        return connectByA2dp(BluetoothUtil.getRemoteDevice(this.mContext, str));
    }

    public boolean disconnectFromA2dp(String str) {
        return disconnectFromA2dp(BluetoothUtil.getRemoteDevice(this.mContext, str));
    }

    public boolean disconnectFromHfp(String str) {
        return disconnectFromHfp(BluetoothUtil.getRemoteDevice(this.mContext, str));
    }

    public boolean connectByHfp(String str) {
        return connectByHfp(BluetoothUtil.getRemoteDevice(this.mContext, str));
    }
}
