package com.jieli.jl_bt_ota.impl;

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
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.text.TextUtils;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BluetoothBreProfiles extends BluetoothDiscovery {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BluetoothHeadset f281q;
    private BluetoothA2dp r;
    private BluetoothHandFreeReceiver s;
    private final BluetoothProfile.ServiceListener t;

    private class BluetoothHandFreeReceiver extends BroadcastReceiver {
        private BluetoothHandFreeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (TextUtils.isEmpty(action) || bluetoothDevice == null) {
                    return;
                }
                Objects.requireNonNull(action);
                switch (action) {
                    case "android.bluetooth.device.action.UUID":
                        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
                        if (parcelableArrayExtra == null) {
                            JL_Log.i(BluetoothBreProfiles.this.TAG, "ACTION_UUID", "No uuids.");
                            break;
                        } else {
                            ParcelUuid[] parcelUuidArr = new ParcelUuid[parcelableArrayExtra.length];
                            for (int i = 0; i < parcelableArrayExtra.length; i++) {
                                parcelUuidArr[i] = ParcelUuid.fromString(parcelableArrayExtra[i].toString());
                                JL_Log.d(BluetoothBreProfiles.this.TAG, "ACTION_UUID", "uuid : " + parcelUuidArr[i].toString());
                            }
                            break;
                        }
                        break;
                    case "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED":
                        try {
                            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                            JL_Log.i(BluetoothBreProfiles.this.TAG, "HFP#ACTION_CONNECTION_STATE_CHANGED", "device : " + BluetoothBreProfiles.this.printBtDeviceInfo(bluetoothDevice) + ", state : " + intExtra);
                            BluetoothBreProfiles.this.onHfpStatus(bluetoothDevice, intExtra);
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                        break;
                    case "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED":
                        try {
                            int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                            JL_Log.i(BluetoothBreProfiles.this.TAG, "A2DP#ACTION_CONNECTION_STATE_CHANGED", "device : " + BluetoothBreProfiles.this.printBtDeviceInfo(bluetoothDevice) + ", state : " + intExtra2);
                            BluetoothBreProfiles.this.onA2dpStatus(bluetoothDevice, intExtra2);
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                        break;
                }
            }
        }
    }

    public BluetoothBreProfiles(Context context) {
        super(context);
        this.t = new BluetoothProfile.ServiceListener() { // from class: com.jieli.jl_bt_ota.impl.BluetoothBreProfiles.1
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                JL_Log.i(BluetoothBreProfiles.this.TAG, "onServiceConnected", "profile : " + i);
                if (2 == i) {
                    BluetoothBreProfiles.this.r = (BluetoothA2dp) bluetoothProfile;
                } else if (1 == i) {
                    BluetoothBreProfiles.this.f281q = (BluetoothHeadset) bluetoothProfile;
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                JL_Log.i(BluetoothBreProfiles.this.TAG, "onServiceDisconnected", "profile : " + i);
                if (2 == i) {
                    BluetoothBreProfiles.this.r = null;
                } else if (1 == i) {
                    BluetoothBreProfiles.this.f281q = null;
                }
            }
        };
        a(context);
        a();
    }

    private boolean b(String str, BluetoothDevice bluetoothDevice) {
        if (c(str, bluetoothDevice)) {
            return true;
        }
        if (this.f281q != null) {
            return false;
        }
        JL_Log.w(this.TAG, str, "No hfp manager.");
        return true;
    }

    private boolean c(String str, BluetoothDevice bluetoothDevice) {
        if (!CommonUtil.checkHasConnectPermission(this.context)) {
            JL_Log.w(this.TAG, str, "Missing connect permissions.");
            return true;
        }
        if (bluetoothDevice == null) {
            JL_Log.w(this.TAG, str, "Device is null.");
            return true;
        }
        if (BluetoothUtil.isBluetoothEnable()) {
            return false;
        }
        JL_Log.w(this.TAG, str, "Bluetooth is off.");
        return true;
    }

    public boolean deviceHasA2dp(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.deviceHasProfile(this.context, bluetoothDevice, BluetoothConstant.UUID_A2DP);
    }

    public boolean deviceHasHfp(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.deviceHasProfile(this.context, bluetoothDevice, BluetoothConstant.UUID_HFP);
    }

    @SuppressLint({"MissingPermission"})
    public boolean disconnectByProfiles(BluetoothDevice bluetoothDevice) {
        boolean zDisconnectFromHfp = false;
        if (c("disconnectByProfiles", bluetoothDevice)) {
            return false;
        }
        JL_Log.d(this.TAG, "disconnectByProfiles", "device : " + printBtDeviceInfo(bluetoothDevice));
        if (bluetoothDevice.getType() != 2) {
            int iIsConnectedByA2dp = isConnectedByA2dp(bluetoothDevice);
            if (iIsConnectedByA2dp == 2) {
                zDisconnectFromHfp = disconnectFromA2dp(bluetoothDevice);
                JL_Log.i(this.TAG, "disconnectByProfiles", "disconnectFromA2dp : " + zDisconnectFromHfp);
            }
            int iIsConnectedByHfp = isConnectedByHfp(bluetoothDevice);
            if (iIsConnectedByHfp == 2) {
                zDisconnectFromHfp = disconnectFromHfp(bluetoothDevice);
                JL_Log.i(this.TAG, "disconnectByProfiles", "disconnectFromHfp : " + zDisconnectFromHfp);
            }
            if (iIsConnectedByA2dp == 0 && iIsConnectedByHfp == 0) {
                JL_Log.d(this.TAG, "disconnectByProfiles", "Classic Bluetooth is disconnected.");
                return true;
            }
        }
        return zDisconnectFromHfp;
    }

    public boolean disconnectFromA2dp(BluetoothDevice bluetoothDevice) {
        if (a("disconnectFromA2dp", bluetoothDevice)) {
            return false;
        }
        int iIsConnectedByA2dp = isConnectedByA2dp(bluetoothDevice);
        JL_Log.d(this.TAG, "disconnectFromA2dp", "deviceA2dpStatus : " + iIsConnectedByA2dp);
        if (iIsConnectedByA2dp == 0) {
            JL_Log.d(this.TAG, "disconnectFromA2dp", "A2dp is disconnected.");
            return true;
        }
        boolean zDisconnectDeviceA2dp = iIsConnectedByA2dp == 2 ? BluetoothUtil.disconnectDeviceA2dp(this.context, this.r, bluetoothDevice) : false;
        JL_Log.d(this.TAG, "disconnectFromA2dp", " -------------> " + zDisconnectDeviceA2dp);
        return zDisconnectDeviceA2dp;
    }

    public boolean disconnectFromHfp(BluetoothDevice bluetoothDevice) {
        if (b("disconnectFromHfp", bluetoothDevice)) {
            return false;
        }
        int iIsConnectedByHfp = isConnectedByHfp(bluetoothDevice);
        JL_Log.d(this.TAG, "disconnectFromHfp", "deviceHfpStatus : " + iIsConnectedByHfp);
        if (iIsConnectedByHfp == 0) {
            JL_Log.i(this.TAG, "disconnectFromHfp", "Hfp is disconnected");
            return true;
        }
        boolean zDisconnectDeviceHfp = iIsConnectedByHfp == 2 ? BluetoothUtil.disconnectDeviceHfp(this.context, this.f281q, bluetoothDevice) : false;
        JL_Log.i(this.TAG, "disconnectFromHfp", " ----> " + zDisconnectDeviceHfp);
        return zDisconnectDeviceHfp;
    }

    protected BluetoothHeadset getBluetoothHfp() {
        return this.f281q;
    }

    @SuppressLint({"MissingPermission"})
    public List<BluetoothDevice> getDevicesConnectedByProfile() {
        if (!CommonUtil.checkHasConnectPermission(this.context)) {
            return null;
        }
        BluetoothHeadset bluetoothHeadset = this.f281q;
        List<BluetoothDevice> connectedDevices = bluetoothHeadset != null ? bluetoothHeadset.getConnectedDevices() : null;
        ArrayList arrayList = connectedDevices != null ? new ArrayList(connectedDevices) : null;
        BluetoothA2dp bluetoothA2dp = this.r;
        if (bluetoothA2dp != null) {
            connectedDevices = bluetoothA2dp.getConnectedDevices();
        }
        if (connectedDevices != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.addAll(connectedDevices);
        }
        return arrayList;
    }

    protected BluetoothA2dp getmBluetoothA2dp() {
        return this.r;
    }

    @SuppressLint({"MissingPermission"})
    public int isConnectedByA2dp(BluetoothDevice bluetoothDevice) {
        if (a("isConnectedByA2dp", bluetoothDevice)) {
            return 0;
        }
        List<BluetoothDevice> connectedDevices = this.r.getConnectedDevices();
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    JL_Log.d(this.TAG, "isConnectedByA2dp", " ----> Connected");
                    return 2;
                }
            }
        }
        int connectionState = this.r.getConnectionState(bluetoothDevice);
        JL_Log.d(this.TAG, "isConnectedByA2dp", "state : " + connectionState);
        return connectionState;
    }

    @SuppressLint({"MissingPermission"})
    public int isConnectedByHfp(BluetoothDevice bluetoothDevice) {
        if (b("isConnectedByHfp", bluetoothDevice)) {
            return 0;
        }
        List<BluetoothDevice> connectedDevices = this.f281q.getConnectedDevices();
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    JL_Log.d(this.TAG, "isConnectedByHfp", "Hfp service is connected.");
                    return 2;
                }
            }
        }
        int connectionState = this.f281q.getConnectionState(bluetoothDevice);
        JL_Log.d(this.TAG, "isConnectedByHfp", "state : " + connectionState);
        return connectionState;
    }

    @SuppressLint({"MissingPermission"})
    public int isConnectedByProfile(BluetoothDevice bluetoothDevice) {
        if (c("isConnectedByProfile", bluetoothDevice)) {
            return 0;
        }
        BluetoothHeadset bluetoothHeadset = this.f281q;
        if (bluetoothHeadset == null || this.r == null) {
            JL_Log.w(this.TAG, "isConnectedByProfile", "No hfp manager or a2dp manager.");
            return 0;
        }
        List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    JL_Log.d(this.TAG, "isConnectedByProfile", "Hfp service is connected.");
                    return 2;
                }
            }
        }
        List<BluetoothDevice> connectedDevices2 = this.r.getConnectedDevices();
        if (connectedDevices2 != null) {
            Iterator<BluetoothDevice> it2 = connectedDevices2.iterator();
            while (it2.hasNext()) {
                if (it2.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    JL_Log.d(this.TAG, "isConnectedByProfile", "A2dp service is connected.");
                    return 2;
                }
            }
        }
        return 0;
    }

    @Override // com.jieli.jl_bt_ota.impl.BluetoothDiscovery, com.jieli.jl_bt_ota.impl.BluetoothBase, com.jieli.jl_bt_ota.interfaces.IUpgradeManager
    public void release() {
        BluetoothAdapter bluetoothAdapter;
        BluetoothAdapter bluetoothAdapter2;
        super.release();
        b();
        BluetoothA2dp bluetoothA2dp = this.r;
        if (bluetoothA2dp != null && (bluetoothAdapter2 = this.mBluetoothAdapter) != null) {
            bluetoothAdapter2.closeProfileProxy(2, bluetoothA2dp);
            this.r = null;
        }
        BluetoothHeadset bluetoothHeadset = this.f281q;
        if (bluetoothHeadset == null || (bluetoothAdapter = this.mBluetoothAdapter) == null) {
            return;
        }
        bluetoothAdapter.closeProfileProxy(1, bluetoothHeadset);
        this.f281q = null;
    }

    private void a(Context context) {
        if (context == null) {
            return;
        }
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            JL_Log.e(this.TAG, "init", "The device does not support Bluetooth function.");
            return;
        }
        if (this.r == null) {
            try {
                if (!bluetoothAdapter.getProfileProxy(context, this.t, 2)) {
                    JL_Log.e(this.TAG, "init", "Failed to obtain a2dp manager.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f281q == null) {
            try {
                if (this.mBluetoothAdapter.getProfileProxy(context, this.t, 1)) {
                    return;
                }
                JL_Log.e(this.TAG, "init", "Failed to obtain hfp manager.");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void b() {
        Context context;
        BluetoothHandFreeReceiver bluetoothHandFreeReceiver = this.s;
        if (bluetoothHandFreeReceiver == null || (context = this.context) == null) {
            return;
        }
        context.unregisterReceiver(bluetoothHandFreeReceiver);
        this.s = null;
    }

    protected boolean disconnectFromA2dp(String str) {
        return disconnectFromA2dp(BluetoothUtil.getRemoteDevice(str));
    }

    public boolean disconnectFromHfp(String str) {
        return disconnectFromHfp(BluetoothUtil.getRemoteDevice(str));
    }

    private boolean a(String str, BluetoothDevice bluetoothDevice) {
        if (c(str, bluetoothDevice)) {
            return true;
        }
        if (this.r != null) {
            return false;
        }
        JL_Log.w(this.TAG, str, "No a2dp manager.");
        return true;
    }

    private void a() {
        if (this.s != null || this.context == null) {
            return;
        }
        this.s = new BluetoothHandFreeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.UUID");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        this.context.registerReceiver(this.s, intentFilter);
    }
}
