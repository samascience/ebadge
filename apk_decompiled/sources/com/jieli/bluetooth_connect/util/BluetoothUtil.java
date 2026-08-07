package com.jieli.bluetooth_connect.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.util.CHexConver;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothUtil {
    private static final String TAG = "BluetoothUtil";
    private static final char[] mChars = CHexConver.b.toCharArray();

    public static byte[] addressCovertToByteArray(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(":")) {
            return null;
        }
        String strReplace = str.replace(":", Constants.STR_EMPTY);
        int length = strReplace.length() / 2;
        byte[] bArr = new byte[length];
        if (length != 6) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (i3 <= strReplace.length()) {
                try {
                    bArr[i] = (byte) Integer.valueOf(strReplace.substring(i2, i3), 16).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return bArr;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean connectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp == null || bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Object objInvoke = bluetoothA2dp.getClass().getMethod("connect", BluetoothDevice.class).invoke(bluetoothA2dp, bluetoothDevice);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean connectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (bluetoothHeadset == null || bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothHeadset.getClass().getMethod("connect", BluetoothDevice.class);
            method.setAccessible(true);
            Object objInvoke = method.invoke(bluetoothHeadset, bluetoothDevice);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String connectionString(int i) {
        if (i != 1) {
            return i != 2 ? "STATE_DISCONNECTED(0)" : "STATE_CONNECTED(2)";
        }
        return "STATE_CONNECTING(1)";
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public static boolean createBond(Context context, BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method declaredMethod = bluetoothDevice.getClass().getDeclaredMethod("createBond", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(bluetoothDevice, Integer.valueOf(i));
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deviceEquals(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
        return (bluetoothDevice == null || bluetoothDevice2 == null || !bluetoothDevice.getAddress().equals(bluetoothDevice2.getAddress())) ? false : true;
    }

    public static boolean deviceHasA2dp(Context context, BluetoothDevice bluetoothDevice) {
        return deviceHasProfile(context, bluetoothDevice, BluetoothConstant.UUID_A2DP);
    }

    public static boolean deviceHasHfp(Context context, BluetoothDevice bluetoothDevice) {
        return deviceHasProfile(context, bluetoothDevice, BluetoothConstant.UUID_HFP);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean deviceHasProfile(Context context, BluetoothDevice bluetoothDevice, UUID uuid) {
        ParcelUuid[] uuids;
        if (!isBluetoothEnable() || bluetoothDevice == null || uuid == null || TextUtils.isEmpty(uuid.toString()) || !ConnectUtil.isHasConnectPermission(context) || (uuids = bluetoothDevice.getUuids()) == null) {
            return false;
        }
        for (ParcelUuid parcelUuid : uuids) {
            if (parcelUuid != null && uuid.toString().equalsIgnoreCase(parcelUuid.toString())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disableBluetooth(Context context) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        if (defaultAdapter.isEnabled()) {
            return defaultAdapter.disable();
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp == null || bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothA2dp.getClass().getMethod("disconnect", BluetoothDevice.class);
            method.setAccessible(true);
            Object objInvoke = method.invoke(bluetoothA2dp, bluetoothDevice);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            JL_Log.e(TAG, "disconnectDeviceA2dp", "have an exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (bluetoothHeadset == null || bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothHeadset.getClass().getMethod("disconnect", BluetoothDevice.class);
            method.setAccessible(true);
            Object objInvoke = method.invoke(bluetoothHeadset, bluetoothDevice);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            JL_Log.e(TAG, "disconnectDeviceHfp", "have an exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean enableBluetooth(Context context) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        if (defaultAdapter.isEnabled()) {
            return true;
        }
        return defaultAdapter.enable();
    }

    public static int formatBleMtu(int i) {
        if (i < 20) {
            i = 20;
        }
        if (i > 509) {
            return 509;
        }
        return i;
    }

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static BluetoothDevice getActivityDevice(Context context, BluetoothA2dp bluetoothA2dp) {
        if (bluetoothA2dp == null || !ConnectUtil.isHasConnectPermission(context)) {
            return null;
        }
        try {
            Method declaredMethod = bluetoothA2dp.getClass().getDeclaredMethod("getActiveDevice", null);
            declaredMethod.setAccessible(true);
            return (BluetoothDevice) declaredMethod.invoke(bluetoothA2dp, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static int getBtAdapterConnectionState(Context context, BluetoothAdapter bluetoothAdapter) {
        if (!ConnectUtil.isHasConnectPermission(context) || bluetoothAdapter == null) {
            return 0;
        }
        try {
            Method declaredMethod = bluetoothAdapter.getClass().getDeclaredMethod("getConnectionState", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(bluetoothAdapter, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getConnectedBleDeviceList(Context context) {
        BluetoothManager bluetoothManager;
        if (ConnectUtil.isHasConnectPermission(context) && (bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth")) != null) {
            try {
                return bluetoothManager.getConnectedDevices(7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Method getDeclaredMethod() throws Exception {
        return Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getPairedBLEDevices(Context context) {
        List<BluetoothDevice> pairedDevices;
        if (!ConnectUtil.isHasConnectPermission(context) || (pairedDevices = getPairedDevices(context)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : pairedDevices) {
            int type = bluetoothDevice.getType();
            if (type == 2 || type == 3) {
                arrayList.add(bluetoothDevice);
            }
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getPairedDevices(Context context) {
        BluetoothAdapter defaultAdapter;
        if (!ConnectUtil.isHasConnectPermission(context) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null || !defaultAdapter.isEnabled()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (defaultAdapter.getBondedDevices() != null) {
            arrayList.addAll(defaultAdapter.getBondedDevices());
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public static int getPriority(Context context, BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null && ConnectUtil.isHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(bluetoothProfile.getClass(), "getPriority", new Class[]{BluetoothDevice.class});
                if (method == null) {
                    return 0;
                }
                Object objInvoke = method.invoke(bluetoothProfile, bluetoothDevice);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Deprecated
    public static BluetoothDevice getRemoteDevice(String str) {
        return getRemoteDevice(ConnectUtil.getContext(), str);
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getSystemConnectedBtDeviceList(Context context) {
        if (!ConnectUtil.isHasConnectPermission(context)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            int btAdapterConnectionState = getBtAdapterConnectionState(context, defaultAdapter);
            if (btAdapterConnectionState == 2 || btAdapterConnectionState == 0) {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (isBTConnected(context, bluetoothDevice)) {
                        arrayList.add(bluetoothDevice);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static boolean hasBle(Context context) {
        return context != null && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i = 0; i < bArr.length; i++) {
                char[] cArr = mChars;
                sb.append(cArr[(bArr[i] & 255) >> 4]);
                sb.append(cArr[bArr[i] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                if (i != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static byte[] hexStringCovertToByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (i3 <= str.length()) {
                try {
                    bArr[i] = (byte) Integer.valueOf(str.substring(i2, i3), 16).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return bArr;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBTConnected(Context context, BluetoothDevice bluetoothDevice) {
        if (!ConnectUtil.isHasConnectPermission(context) || bluetoothDevice == null) {
            return false;
        }
        try {
            Object objInvoke = bluetoothDevice.getClass().getDeclaredMethod("isConnected", null).invoke(bluetoothDevice, null);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBleConnected(Context context, BluetoothDevice bluetoothDevice) {
        List<BluetoothDevice> connectedBleDeviceList;
        if (context == null || bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context) || (connectedBleDeviceList = getConnectedBleDeviceList(context)) == null) {
            return false;
        }
        for (BluetoothDevice bluetoothDevice2 : connectedBleDeviceList) {
            if (bluetoothDevice2 != null && bluetoothDevice.getAddress().equals(bluetoothDevice2.getAddress())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBluetoothEnable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    @SuppressLint({"MissingPermission"})
    public static void printBleGattServices(Context context, BluetoothDevice bluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
        if (bluetoothDevice == null || bluetoothGatt == null || !ConnectUtil.isHasConnectPermission(context) || !JL_Log.isLog()) {
            return;
        }
        String str = TAG;
        JL_Log.d(str, ConnectUtil.formatString("[[============================Bluetooth[%s], Discovery Services status[%d]=================================]]\n", printBtDeviceInfo(context, bluetoothDevice), Integer.valueOf(i)));
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        if (services != null) {
            JL_Log.d(str, "[[======Service Size:" + services.size() + "======================\n");
            for (BluetoothGattService bluetoothGattService : services) {
                if (bluetoothGattService != null) {
                    String str2 = TAG;
                    JL_Log.d(str2, "[[======Service:" + bluetoothGattService.getUuid() + "======================\n");
                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                    if (characteristics != null) {
                        JL_Log.d(str2, "[[[[=============characteristics Size:" + characteristics.size() + "======================\n");
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                            if (bluetoothGattCharacteristic != null) {
                                String str3 = TAG;
                                JL_Log.d(str3, "[[[[=============characteristic:" + bluetoothGattCharacteristic.getUuid() + ",write type : " + bluetoothGattCharacteristic.getWriteType() + "======================\n");
                                List<BluetoothGattDescriptor> descriptors = bluetoothGattCharacteristic.getDescriptors();
                                if (descriptors != null) {
                                    JL_Log.d(str3, "[[[[[[=============descriptors Size:" + descriptors.size() + "======================\n");
                                    for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                        if (bluetoothGattDescriptor != null) {
                                            JL_Log.d(TAG, "[[[[[[=============descriptor:" + bluetoothGattDescriptor.getUuid() + ",permission:" + bluetoothGattDescriptor.getPermissions() + "\nvalue : " + CHexConverter.byte2HexStr(bluetoothGattDescriptor.getValue()) + "======================\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        JL_Log.d(TAG, "[[============================Bluetooth[" + printBtDeviceInfo(context, bluetoothDevice) + "] Services show End=================================]]\n");
    }

    @Deprecated
    public static String printBtDeviceInfo(BluetoothDevice bluetoothDevice) {
        return printBtDeviceInfo(ConnectUtil.getContext(), bluetoothDevice, true);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean refreshBleDeviceCache(Context context, BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Object objInvoke = bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean removeBond(Context context, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Object objInvoke = bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JL_Log.e(TAG, "removeBond", "Invoke removeBond : " + e.getMessage());
            return false;
        }
    }

    public static String reverseAddressString(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return str;
        }
        if (str.contains(":")) {
            str = str.replaceAll(":", Constants.STR_EMPTY);
        }
        byte[] bArrHexStringCovertToByteArray = hexStringCovertToByteArray(str);
        if (bArrHexStringCovertToByteArray == null) {
            return str;
        }
        byte[] bArr = new byte[6];
        int length = bArrHexStringCovertToByteArray.length - 1;
        int i = 0;
        while (true) {
            if (!(i < bArrHexStringCovertToByteArray.length) || !(length >= 0)) {
                return hexDataCovetToAddress(bArr);
            }
            bArr[i] = bArrHexStringCovertToByteArray[length];
            i++;
            length--;
        }
    }

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static boolean setActivityDevice(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp == null || bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method declaredMethod = bluetoothA2dp.getClass().getDeclaredMethod("setActiveDevice", bluetoothDevice.getClass());
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(bluetoothA2dp, bluetoothDevice);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean setPriority(Context context, BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothProfile != null && bluetoothDevice != null && ConnectUtil.isHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(bluetoothProfile.getClass(), "setPriority", new Class[]{BluetoothDevice.class, Integer.TYPE});
                if (method == null) {
                    return false;
                }
                Object objInvoke = method.invoke(bluetoothProfile, bluetoothDevice, Integer.valueOf(i));
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static BluetoothDevice getRemoteDevice(Context context, String str) {
        BluetoothAdapter defaultAdapter;
        if (!BluetoothAdapter.checkBluetoothAddress(str) || !ConnectUtil.isHasConnectPermission(context) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return null;
        }
        try {
            return defaultAdapter.getRemoteDevice(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String printBtDeviceInfo(Context context, BluetoothDevice bluetoothDevice) {
        return printBtDeviceInfo(context, bluetoothDevice, true);
    }

    @SuppressLint({"MissingPermission"})
    public static String printBtDeviceInfo(Context context, BluetoothDevice bluetoothDevice, boolean z) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return "null";
        }
        if (z) {
            return "name : " + bluetoothDevice.getName() + ", type : " + bluetoothDevice.getType() + ", address : " + bluetoothDevice.getAddress();
        }
        return bluetoothDevice.getAddress();
    }

    @SuppressLint({"MissingPermission"})
    public static boolean createBond(Context context, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        return bluetoothDevice.createBond();
    }
}
