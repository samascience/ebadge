package xfkj.fitpro.activity.ota.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.o;
import com.tencent.connect.common.Constants;
import defpackage.pv2;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import xfkj.fitpro.activity.ota.jieli.BluetoothJieLiTools;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"MissingPermission"})
public class BleUtils {
    public static final int CONNECTION_STATE_CONNECTED = 1;
    public static final int CONNECTION_STATE_DISCONNECTED = 0;
    public static final int CONNECTION_STATE_UN_SUPPORT = -1;
    private static final String TAG = "BleUtils";
    private static long lastPairTime = 0;
    private static int spaceTime = 3000;

    public static void cancelDiscovery() {
        BluetoothAdapter defaultAdapter;
        if (!PermissionUtils.t("android.permission.BLUETOOTH_SCAN") || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return;
        }
        defaultAdapter.cancelDiscovery();
    }

    public static boolean checkAndBondDevice(BluetoothDevice bluetoothDevice) {
        return pair(bluetoothDevice);
    }

    public static void closeBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            return;
        }
        defaultAdapter.disable();
    }

    public static boolean createBond(BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothDevice == null) {
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

    public static String getBleName(String str) {
        BluetoothDevice remoteDevice;
        return (PermissionUtil.hasBluetoothConnect() && (remoteDevice = getRemoteDevice(str)) != null) ? remoteDevice.getName() : Constants.STR_EMPTY;
    }

    public static BluetoothDevice getBluetoothDeviceByMac(String str) {
        try {
            if (pv2.f(str) || !BluetoothAdapter.checkBluetoothAddress(str)) {
                return null;
            }
            return BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getConnectionState(String str) {
        if (!isSupportBle()) {
            return -1;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) o.a().getSystemService("bluetooth");
        BluetoothDevice remoteDevice = bluetoothManager.getAdapter().getRemoteDevice(str);
        if (remoteDevice != null && PermissionUtil.hasBluetoothConnect()) {
            return bluetoothManager.getConnectionState(remoteDevice, 7);
        }
        return 0;
    }

    public static Field getDeclaredField(Class<?> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    public static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @SuppressLint({"PrivateApi"})
    public static Object getIBluetoothGatt(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return getDeclaredMethod(obj, "getBluetoothGatt", (Class<?>[]) new Class[0]).invoke(obj, null);
    }

    @SuppressLint({"PrivateApi"})
    public static Object getIBluetoothManager(BluetoothAdapter bluetoothAdapter) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return getDeclaredMethod((Class<?>) BluetoothAdapter.class, "getBluetoothManager", (Class<?>[]) new Class[0]).invoke(bluetoothAdapter, null);
    }

    public static int getInternalConnectionState(String str) {
        if (!isSupportBle()) {
            return -1;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) o.a().getSystemService("bluetooth");
        BluetoothDevice remoteDevice = bluetoothManager.getAdapter().getRemoteDevice(str);
        if (remoteDevice == null || !PermissionUtil.hasBluetoothConnect()) {
            return 0;
        }
        int connectionState = bluetoothManager.getConnectionState(remoteDevice, 7);
        if (connectionState == 2) {
            return 1;
        }
        return connectionState;
    }

    private static BluetoothDevice getRemoteDevice(String str) {
        if (BluetoothAdapter.getDefaultAdapter() == null || !BluetoothAdapter.checkBluetoothAddress(str)) {
            return null;
        }
        return BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str);
    }

    public static boolean hasLocationEnablePermission(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
        } catch (Exception unused) {
            i = 0;
        }
        return i != 0;
    }

    public static boolean isBR(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            return bluetoothDevice.getType() == 1 || bluetoothDevice.getType() == 3;
        }
        return false;
    }

    public static boolean isEnable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.isEnabled();
        }
        return false;
    }

    public static boolean isEnableGps() {
        LocationManager locationManager = (LocationManager) o.a().getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    public static boolean isFastOfPair() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - lastPairTime <= ((long) spaceTime);
        lastPairTime = jCurrentTimeMillis;
        return z;
    }

    public static boolean isOnbond(BluetoothDevice bluetoothDevice) {
        try {
            if (Build.VERSION.SDK_INT < 31 || PermissionUtils.t("android.permission.BLUETOOTH_CONNECT")) {
                return bluetoothDevice != null && bluetoothDevice.getBondState() == 12;
            }
            PermissionUtils.y("android.permission.BLUETOOTH_CONNECT").z();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isScanBluetooth() {
        return isEnable() && isEnableGps();
    }

    @TargetApi(21)
    public static boolean isScanClientInitialize(BluetoothAdapter.LeScanCallback leScanCallback) {
        try {
            HashMap map = (HashMap) getDeclaredField((Class<?>) BluetoothLeScanner.class, "mLeScanClients").get(BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner());
            if ((map == null ? 0 : map.size()) > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null && key != null && key == leScanCallback) {
                        int i = getDeclaredField(value, "mScannerId").getInt(value);
                        System.out.println("mClientIf=" + i);
                        return true;
                    }
                }
            } else if (leScanCallback != null) {
                return false;
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static boolean isSupportBle() {
        return o.a().getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static void openBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.isEnabled()) {
            return;
        }
        defaultAdapter.enable();
    }

    public static boolean pair(BluetoothDevice bluetoothDevice) {
        try {
            if (bluetoothDevice == null) {
                Log.d(TAG, "device is null");
                return false;
            }
            if (bluetoothDevice.getBondState() != 10) {
                Log.d(TAG, "device is bond");
                return false;
            }
            if (isFastOfPair()) {
                Log.d(TAG, "pair is fast");
                return false;
            }
            Log.d(TAG, "pair:" + bluetoothDevice.getAddress());
            boolean zCreateBond = bluetoothDevice.getType() == 3 ? createBond(bluetoothDevice, 1) : false;
            return !zCreateBond ? bluetoothDevice.createBond() : zCreateBond;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void refreshBleAppFromSystem(Context context, String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            try {
                Object iBluetoothManager = getIBluetoothManager(defaultAdapter);
                Method declaredMethod = iBluetoothManager.getClass().getDeclaredMethod("isBleAppPresent", null);
                declaredMethod.setAccessible(true);
                if (((Boolean) declaredMethod.invoke(iBluetoothManager, null)).booleanValue()) {
                    return;
                }
                Field declaredField = BluetoothAdapter.class.getDeclaredField("mToken");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(defaultAdapter);
                Method declaredMethod2 = iBluetoothManager.getClass().getDeclaredMethod("updateBleAppCount", IBinder.class, Boolean.TYPE, String.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(iBluetoothManager, obj, Boolean.FALSE, str);
                declaredMethod2.invoke(iBluetoothManager, obj, Boolean.TRUE, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean releaseAllScanClient() {
        Object iBluetoothGatt;
        Method declaredMethod;
        boolean z;
        try {
            Object iBluetoothManager = getIBluetoothManager(BluetoothAdapter.getDefaultAdapter());
            if (iBluetoothManager == null || (iBluetoothGatt = getIBluetoothGatt(iBluetoothManager)) == null) {
                return false;
            }
            Class cls = Integer.TYPE;
            Method declaredMethod2 = getDeclaredMethod(iBluetoothGatt, "unregisterClient", (Class<?>[]) new Class[]{cls});
            try {
                declaredMethod = getDeclaredMethod(iBluetoothGatt, "stopScan", (Class<?>[]) new Class[]{cls, Boolean.TYPE});
                z = false;
            } catch (Exception unused) {
                declaredMethod = getDeclaredMethod(iBluetoothGatt, "stopScan", (Class<?>[]) new Class[]{Integer.TYPE});
                z = true;
            }
            for (int i = 0; i <= 40; i++) {
                if (!z) {
                    try {
                        declaredMethod.invoke(iBluetoothGatt, Integer.valueOf(i), Boolean.FALSE);
                    } catch (Exception unused2) {
                    }
                }
                if (z) {
                    try {
                        declaredMethod.invoke(iBluetoothGatt, Integer.valueOf(i));
                    } catch (Exception unused3) {
                    }
                }
                try {
                    declaredMethod2.invoke(iBluetoothGatt, Integer.valueOf(i));
                } catch (Exception unused4) {
                }
            }
            declaredMethod.setAccessible(false);
            declaredMethod2.setAccessible(false);
            getDeclaredMethod(iBluetoothGatt, "unregAll", (Class<?>[]) new Class[0]).invoke(iBluetoothGatt, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void unPairAllLeDevice() {
        unPairLeDevice(Constants.STR_EMPTY);
    }

    public static void unPairBRDevice(String str) {
        Log.d(TAG, "unPairBRDevice address:" + str);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                if (bluetoothDevice.getAddress().equals(str) && bluetoothDevice.getType() != 2) {
                    unpairDevice2(bluetoothDevice);
                }
            }
        }
    }

    public static void unPairLeDevice(String str) {
        Log.d(TAG, "unPairLeDevice address:" + str);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                if (pv2.h(str) || bluetoothDevice.getAddress().equals(str)) {
                    if (bluetoothDevice.getType() == 2) {
                        unpairDevice2(bluetoothDevice);
                    }
                }
            }
        }
    }

    public static void unpairDevice(String str) {
        unpairDevice(getBluetoothDeviceByMac(str));
    }

    public static void unpairDevice2(BluetoothDevice bluetoothDevice) {
        Log.i(TAG, "unpairDevice2:" + bluetoothDevice);
        BluetoothJieLiTools bluetoothJieLiTools = BluetoothJieLiTools.getInstance();
        if (bluetoothJieLiTools.isConnectedDevice(bluetoothDevice)) {
            bluetoothJieLiTools.disconnectBtDevice(bluetoothDevice);
        }
        if (bluetoothJieLiTools.isConnectedByProfile(bluetoothDevice)) {
            bluetoothJieLiTools.disconnectByProfiles(bluetoothDevice);
        }
        boolean zTryUnPair = bluetoothJieLiTools.tryUnPair(bluetoothDevice);
        if (!zTryUnPair) {
            zTryUnPair = bluetoothJieLiTools.unPair(bluetoothDevice);
        }
        if (!zTryUnPair) {
            unpairDevice(bluetoothDevice);
        }
        bluetoothJieLiTools.getBluetoothManager().clearHistoryRecords();
    }

    public static boolean checkAndBondDevice(String str) {
        try {
            return checkAndBondDevice(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void unpairDevice(BluetoothDevice bluetoothDevice) {
        try {
            bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
        } catch (Exception e) {
            Log.d("unpairDevice", e.toString());
        }
    }

    public static Field getDeclaredField(Object obj, String str) throws NoSuchFieldException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    public static Method getDeclaredMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public static boolean isOnbond(String str) {
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            return isOnbond(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str));
        }
        return false;
    }
}
