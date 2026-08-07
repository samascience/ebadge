package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.location.LocationManager;
import android.os.Build;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.PermissionUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.a;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.c;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.i;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ak {
    private static long a = 0;
    private static int b = 0;
    private static long c = 0;
    private static int d = 3000;

    public static boolean a(BluetoothDevice bluetoothDevice) {
        return q(bluetoothDevice);
    }

    public static boolean b(String str) {
        try {
            return a(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(BluetoothDevice bluetoothDevice, int i) {
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

    public static BluetoothDevice d(String str) {
        try {
            if (rv2.f(str) || !BluetoothAdapter.checkBluetoothAddress(str)) {
                return null;
            }
            return BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int e(String str) {
        if (!p()) {
            return -1;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) tg3.n().getSystemService("bluetooth");
        BluetoothDevice remoteDevice = bluetoothManager.getAdapter().getRemoteDevice(str);
        if (remoteDevice != null && PermissionUtils.r()) {
            return bluetoothManager.getConnectionState(remoteDevice, 7);
        }
        return 0;
    }

    public static int f(String str) {
        BluetoothManager bluetoothManager;
        BluetoothAdapter adapter;
        if (!p() || (bluetoothManager = (BluetoothManager) i.a().getSystemService("bluetooth")) == null || (adapter = bluetoothManager.getAdapter()) == null) {
            return -1;
        }
        try {
            BluetoothDevice remoteDevice = adapter.getRemoteDevice(str);
            if (remoteDevice == null || !PermissionUtils.r()) {
                return 0;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - a < 100) {
                yc1.a("BleUtils", "getInternalConnectionState is called with interval " + b);
                return b;
            }
            int connectionState = bluetoothManager.getConnectionState(remoteDevice, 7);
            a = jCurrentTimeMillis;
            if (connectionState == 2) {
                connectionState = 1;
            }
            b = connectionState;
            return connectionState;
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public static boolean g(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            return bluetoothDevice.getType() == 1 || bluetoothDevice.getType() == 3;
        }
        return false;
    }

    public static boolean h() {
        a.a();
        return (rv2.h(ug3.e()) || e20.f != 0 || e20.d == 1) ? false : true;
    }

    public static boolean i() {
        if (c.a()) {
            return o();
        }
        return false;
    }

    public static boolean j() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.isEnabled();
        }
        return false;
    }

    public static boolean k() {
        LocationManager locationManager = (LocationManager) tg3.n().getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    public static boolean l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - c <= ((long) d);
        c = jCurrentTimeMillis;
        return z;
    }

    public static boolean m(BluetoothDevice bluetoothDevice) {
        try {
            if (Build.VERSION.SDK_INT < 31 || PermissionUtils.v("android.permission.BLUETOOTH_CONNECT")) {
                return bluetoothDevice != null && bluetoothDevice.getBondState() == 12;
            }
            PermissionUtils.A("android.permission.BLUETOOTH_CONNECT").B();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean n(String str) {
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            return m(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str));
        }
        return false;
    }

    public static boolean o() {
        return j() && k();
    }

    public static boolean p() {
        return tg3.n().getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean q(BluetoothDevice bluetoothDevice) {
        try {
            if (bluetoothDevice == null) {
                yc1.a("BleUtils", "device is null");
                return false;
            }
            if (bluetoothDevice.getBondState() != 10) {
                yc1.a("BleUtils", "device is bond");
                return false;
            }
            if (l()) {
                yc1.a("BleUtils", "pair is fast");
                return false;
            }
            yc1.a("BleUtils", "pair:" + bluetoothDevice.getAddress());
            boolean zC = bluetoothDevice.getType() == 3 ? c(bluetoothDevice, 1) : false;
            return !zC ? bluetoothDevice.createBond() : zC;
        } catch (Exception unused) {
            return false;
        }
    }
}
