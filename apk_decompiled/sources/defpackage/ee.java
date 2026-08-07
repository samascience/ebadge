package defpackage;

import android.bluetooth.BluetoothDevice;
import xfkj.fitpro.activity.ota.jieli.BluetoothJieLiTools;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ee {
    public static void a(String str, String str2) {
        try {
            if (pv2.h(str2)) {
                return;
            }
            BluetoothDevice bluetoothDeviceD = ak.d(str2);
            if (ak.g(bluetoothDeviceD) && ak.m(bluetoothDeviceD)) {
                BluetoothJieLiTools.getInstance().syncEdrConnectionStatus(bluetoothDeviceD);
            }
            if (pv2.b(str, str2)) {
                ak.b(str2);
            } else {
                ak.b(str2);
            }
        } catch (Exception unused) {
        }
    }
}
