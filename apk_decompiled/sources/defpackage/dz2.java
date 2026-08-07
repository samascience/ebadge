package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class dz2 {
    public BluetoothAdapter a;
    public BluetoothManager b;

    private static class a {
        private static dz2 a = new dz2();
    }

    private boolean a(Context context) {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.b = bluetoothManager;
        if (bluetoothManager == null) {
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.a = adapter;
        if (adapter == null) {
            return false;
        }
        dd1.a("SystemBleCheck", "该设备支持蓝牙4.0");
        return true;
    }

    public static dz2 b() {
        return a.a;
    }

    private boolean d() {
        BluetoothAdapter bluetoothAdapter = this.a;
        if (bluetoothAdapter == null) {
            return false;
        }
        return bluetoothAdapter.isEnabled();
    }

    public void c(Context context) {
        if (a(context)) {
            return;
        }
        dd1.b("SystemBleCheck", "该设备不支持低功耗蓝牙");
        Toast.makeText(context, "该设备不支持低功耗蓝牙", 0).show();
    }

    public void e(Context context, boolean z) {
        if (d()) {
            dd1.a("SystemBleCheck", "手机蓝牙状态已开");
            return;
        }
        if (z) {
            dd1.a("SystemBleCheck", "直接打开手机蓝牙");
            this.a.enable();
        } else {
            dd1.a("SystemBleCheck", "提示用户去打开手机蓝牙");
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
