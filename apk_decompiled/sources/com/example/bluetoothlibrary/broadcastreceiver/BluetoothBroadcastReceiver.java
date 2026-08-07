package com.example.bluetoothlibrary.broadcastreceiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.example.bluetoothlibrary.model.SearchDevice;
import defpackage.cw1;
import defpackage.dd1;
import defpackage.e43;
import defpackage.yu1;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    private yu1 a;
    private cw1 b;
    private List c;
    private List d;

    public void a(yu1 yu1Var) {
        this.a = yu1Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(action, "android.bluetooth.adapter.action.STATE_CHANGED")) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0)) {
                case 10:
                    dd1.a("BluetoothBroadcastReceiver", "蓝牙已关闭");
                    List list = this.c;
                    if (list != null) {
                        Iterator it = list.iterator();
                        if (it.hasNext()) {
                            e43.a(it.next());
                            throw null;
                        }
                        return;
                    }
                    return;
                case 11:
                    dd1.a("BluetoothBroadcastReceiver", "蓝牙正在打开...");
                    List list2 = this.c;
                    if (list2 != null) {
                        Iterator it2 = list2.iterator();
                        if (it2.hasNext()) {
                            e43.a(it2.next());
                            throw null;
                        }
                        return;
                    }
                    return;
                case 12:
                    dd1.a("BluetoothBroadcastReceiver", "蓝牙已打开");
                    List list3 = this.c;
                    if (list3 != null) {
                        Iterator it3 = list3.iterator();
                        if (it3.hasNext()) {
                            e43.a(it3.next());
                            throw null;
                        }
                        return;
                    }
                    return;
                case 13:
                    dd1.a("BluetoothBroadcastReceiver", "蓝牙正在关闭...");
                    List list4 = this.c;
                    if (list4 != null) {
                        Iterator it4 = list4.iterator();
                        if (it4.hasNext()) {
                            e43.a(it4.next());
                            throw null;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        if (TextUtils.equals(action, "android.bluetooth.device.action.BOND_STATE_CHANGED")) {
            switch (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getBondState()) {
                case 10:
                    dd1.a("BluetoothBroadcastReceiver", "已解绑");
                    List list5 = this.d;
                    if (list5 != null) {
                        Iterator it5 = list5.iterator();
                        if (it5.hasNext()) {
                            e43.a(it5.next());
                            throw null;
                        }
                        return;
                    }
                    return;
                case 11:
                    dd1.a("BluetoothBroadcastReceiver", "正在绑定...");
                    List list6 = this.d;
                    if (list6 != null) {
                        Iterator it6 = list6.iterator();
                        if (it6.hasNext()) {
                            e43.a(it6.next());
                            throw null;
                        }
                        return;
                    }
                    return;
                case 12:
                    dd1.a("BluetoothBroadcastReceiver", "已绑定");
                    List list7 = this.d;
                    if (list7 != null) {
                        Iterator it7 = list7.iterator();
                        if (it7.hasNext()) {
                            e43.a(it7.next());
                            throw null;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        if (TextUtils.equals(action, "android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
            Log.d("广播", "开始扫描");
            yu1 yu1Var = this.a;
            if (yu1Var != null) {
                yu1Var.a();
                return;
            }
            return;
        }
        if (TextUtils.equals(action, "android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
            Log.d("广播", "完成扫描");
            yu1 yu1Var2 = this.a;
            if (yu1Var2 != null) {
                yu1Var2.b();
                return;
            }
            return;
        }
        if (TextUtils.equals(action, "android.bluetooth.device.action.FOUND")) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            SearchDevice searchDevice = new SearchDevice(bluetoothDevice, intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE), null);
            dd1.a("BTManager", "扫描到设备：" + bluetoothDevice.getName() + "-->" + bluetoothDevice.getAddress());
            yu1 yu1Var3 = this.a;
            if (yu1Var3 != null) {
                yu1Var3.d(searchDevice);
                return;
            }
            return;
        }
        if (TextUtils.equals(action, "android.bluetooth.device.action.PAIRING_REQUEST")) {
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            dd1.a("BTManager", "请求配对 -->" + bluetoothDevice2.getName() + "-->" + bluetoothDevice2.getAddress());
            return;
        }
        if (TextUtils.equals(action, "android.bluetooth.device.action.ACL_CONNECTED")) {
            BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            cw1 cw1Var = this.b;
            if (cw1Var != null) {
                cw1Var.a(bluetoothDevice3);
                return;
            }
            return;
        }
        if (TextUtils.equals(action, "android.bluetooth.device.action.ACL_DISCONNECTED")) {
            BluetoothDevice bluetoothDevice4 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            cw1 cw1Var2 = this.b;
            if (cw1Var2 != null) {
                cw1Var2.b(bluetoothDevice4);
                return;
            }
            return;
        }
        if (!TextUtils.equals(action, "android.bluetooth.adapter.action.SCAN_MODE_CHANGED") && "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            if (intExtra == 0) {
                Log.d("CallMusicActivity", "有设备与手机连断开连接");
            } else {
                if (intExtra != 2) {
                    return;
                }
                Log.d("CallMusicActivity", "有设备与手机连接成功");
            }
        }
    }
}
