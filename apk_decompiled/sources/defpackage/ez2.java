package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class ez2 {
    public BluetoothAdapter a;

    private static class a {
        private static ez2 a = new ez2();
    }

    private boolean a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.a = defaultAdapter;
        if (defaultAdapter == null) {
            return false;
        }
        dd1.a("SystemBtCheck", "该设备支持蓝牙3.0");
        return true;
    }

    public static ez2 b() {
        return a.a;
    }

    private boolean d() {
        BluetoothAdapter bluetoothAdapter = this.a;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.isEnabled();
        }
        dd1.b("SystemBtCheck", "isEnable-->bluetooth3Adapter == null");
        return false;
    }

    public void c(Context context) {
        if (a()) {
            return;
        }
        dd1.b("SystemBtCheck", "该设备不支持蓝牙");
        Toast.makeText(context, "该设备不支持蓝牙", 0).show();
    }

    public void e(Context context, boolean z) {
        if (d()) {
            dd1.a("SystemBtCheck", "手机蓝牙状态已开");
            return;
        }
        if (z) {
            dd1.a("SystemBtCheck", "直接打开手机蓝牙");
            this.a.enable();
        } else {
            dd1.a("SystemBtCheck", "提示用户去打开手机蓝牙");
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
