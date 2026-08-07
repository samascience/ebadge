package defpackage;

import android.bluetooth.BluetoothGatt;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class uy {
    public static boolean a(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            return false;
        }
        try {
            Method method = bluetoothGatt.getClass().getMethod("refresh", null);
            if (method != null) {
                return ((Boolean) method.invoke(bluetoothGatt, null)).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            Log.i("Config", "An exception occured while refreshing device");
            return false;
        }
    }
}
