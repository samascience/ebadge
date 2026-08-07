package xfkj.fitpro.activity.ota.jieli;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.blankj.utilcode.util.o;
import com.jieli.bluetooth_connect.impl.BluetoothManager;

/* JADX INFO: loaded from: classes4.dex */
public class BluetoothJieLiTools {
    private static BluetoothJieLiTools instance;
    private final String TAG = "BluetoothJieLiTools";
    private final BluetoothManager bluetoothManager = new BluetoothManager(o.a(), null);

    public static synchronized BluetoothJieLiTools getInstance() {
        try {
            if (instance == null) {
                instance = new BluetoothJieLiTools();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    public boolean disconnectBtDevice(BluetoothDevice bluetoothDevice) {
        try {
            this.bluetoothManager.disconnectBtDevice(bluetoothDevice);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean disconnectByProfiles(BluetoothDevice bluetoothDevice) {
        try {
            return this.bluetoothManager.disconnectByProfiles(bluetoothDevice);
        } catch (Exception unused) {
            return false;
        }
    }

    public BluetoothManager getBluetoothManager() {
        return this.bluetoothManager;
    }

    public boolean isConnectedByProfile(BluetoothDevice bluetoothDevice) {
        try {
            return this.bluetoothManager.isConnectedByProfile(bluetoothDevice) == 2;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isConnectedDevice(BluetoothDevice bluetoothDevice) {
        try {
            return this.bluetoothManager.isConnectedDevice(bluetoothDevice);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isPaired(BluetoothDevice bluetoothDevice) {
        try {
            return this.bluetoothManager.isPaired(bluetoothDevice);
        } catch (Exception unused) {
            return false;
        }
    }

    public void syncEdrConnectionStatus(BluetoothDevice bluetoothDevice) {
        boolean zStartConnectByBreProfiles;
        if (bluetoothDevice == null) {
            Log.d("BluetoothJieLiTools", "syncEdrConnectionStatus mEdrDevice is null");
            return;
        }
        int iIsConnectedByProfile = getBluetoothManager().isConnectedByProfile(bluetoothDevice);
        if (iIsConnectedByProfile == 2) {
            getBluetoothManager().setActivityBluetoothDevice(bluetoothDevice);
            zStartConnectByBreProfiles = false;
        } else {
            zStartConnectByBreProfiles = getBluetoothManager().startConnectByBreProfiles(bluetoothDevice);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("syncEdrConnectionStatus: 尝试连接，结果 = ");
        sb.append(zStartConnectByBreProfiles ? "设备开始连接" : "设备连接失败");
        sb.append(";phoneEdrStatus:");
        sb.append(iIsConnectedByProfile);
        Log.i("BluetoothJieLiTools", sb.toString());
    }

    public boolean tryUnPair(BluetoothDevice bluetoothDevice) {
        try {
            return this.bluetoothManager.tryToUnPair(bluetoothDevice);
        } catch (Exception e) {
            Log.d("BluetoothJieLiTools", "unPair" + e);
            return false;
        }
    }

    public boolean unPair(BluetoothDevice bluetoothDevice) {
        try {
            return this.bluetoothManager.unPair(bluetoothDevice);
        } catch (Exception e) {
            Log.d("BluetoothJieLiTools", "unPair" + e);
            return false;
        }
    }
}
