package com.beken.beken_ota.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import defpackage.ci0;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String k = "a";
    private Context a;
    private String b;
    private BluetoothLeService c;
    private BluetoothAdapter d;
    private UUID e = UUID.fromString("f000ffc1-0451-4000-b000-000000000000");
    private UUID f = UUID.fromString("f000ffc2-0451-4000-b000-000000000000");
    private BluetoothGattCharacteristic g = null;
    private BluetoothGattCharacteristic h = null;
    private final ServiceConnection i;
    private final BroadcastReceiver j;

    /* JADX INFO: renamed from: com.beken.beken_ota.ble.a$a, reason: collision with other inner class name */
    class ServiceConnectionC0056a implements ServiceConnection {
        ServiceConnectionC0056a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.c = ((BluetoothLeService.b) iBinder).a();
            if (a.this.c.l()) {
                Log.e(a.k, "initial finish");
                a.this.c.i(a.this.b);
            } else {
                Log.e(a.k, "init fail");
                EventBus.getDefault().post(new ci0(400));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.w(a.k, "Service disconnect");
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothManager bluetoothManager = (BluetoothManager) a.this.a.getSystemService("bluetooth");
            try {
                a.this.d = bluetoothManager.getAdapter();
            } catch (NullPointerException unused) {
                Log.e(a.k, "NullPointerException adapter is null");
            }
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                a.this.d.getState();
            }
            if ("com.example.bluetooth.le.ACTION_GATT_CONNECTED".equals(action)) {
                if (a.this.c != null) {
                    Log.e(a.k, "do discover");
                    a.this.c.o();
                    return;
                }
                return;
            }
            if ("com.example.bluetooth.le.ACTION_GATT_DISCONNECTED".equals(action)) {
                EventBus.getDefault().post(new ci0(404));
                return;
            }
            if ("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED".equals(action)) {
                Log.d(a.k, "ACTION_GATT_SERVICES_DISCOVERED");
                a aVar = a.this;
                aVar.i(aVar.c.k());
                return;
            }
            if ("com.example.bluetooth.le.ACTION_DATA_AVAILABLE".equals(action)) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("com.example.bluetooth.le.EXTRA_DATA_BYTE");
                String stringExtra = intent.getStringExtra("com.example.bluetooth.le.EXTRA_UUID");
                if (stringExtra.equals(BluetoothLeService.k.toString())) {
                    Log.e(a.k, "notify block data come");
                    EventBus.getDefault().post(new ci0(403, byteArrayExtra));
                    return;
                } else {
                    if (stringExtra.equals(BluetoothLeService.j.toString())) {
                        Log.e(a.k, "notify identfy data come");
                        return;
                    }
                    return;
                }
            }
            if ("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED_FAIL".equals(action)) {
                if (a.this.c != null) {
                    Log.w(a.k, "discovered fail and ready to disconnect");
                    a.this.c.j();
                    return;
                }
                return;
            }
            if ("com.example.bluetooth.le.ENABLE_NOTIFY_2".equals(action)) {
                Log.e(a.k, "ACTION_GATT_ENABLE_2");
                EventBus.getDefault().post(new ci0(401));
            }
        }
    }

    public a(Context context, String str) {
        ServiceConnectionC0056a serviceConnectionC0056a = new ServiceConnectionC0056a();
        this.i = serviceConnectionC0056a;
        b bVar = new b();
        this.j = bVar;
        this.a = context;
        this.b = str;
        this.a.bindService(new Intent(this.a, (Class<?>) BluetoothLeService.class), serviceConnectionC0056a, 1);
        this.a.registerReceiver(bVar, j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List list) {
        this.g = null;
        this.h = null;
        if (list == null) {
            Log.e(k, "gattService is null");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : ((BluetoothGattService) it.next()).getCharacteristics()) {
                String string = bluetoothGattCharacteristic.getUuid().toString();
                if (string.equals(this.e.toString())) {
                    this.g = bluetoothGattCharacteristic;
                } else if (string.equals(this.f.toString())) {
                    this.h = bluetoothGattCharacteristic;
                }
            }
        }
        if (this.g != null && this.h != null) {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.c.m(this.h, true)) {
                Log.e(k, "uuid all match");
                return;
            }
        }
        Log.e(k, "disover service fail");
    }

    private static IntentFilter j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_GATT_CONNECTED");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_GATT_DISCONNECTED");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_DATA_AVAILABLE");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_DATA_WRITE_FAIL");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_DATA_WRITE_SUCCESS");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED_FAIL");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_NOTIFY_SUCCESS");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_NOTIFY_FAIL");
        intentFilter.addAction("com.example.bluetooth.le.ENABLE_NOTIFY_1");
        intentFilter.addAction("com.example.bluetooth.le.ENABLE_NOTIFY_2");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        return intentFilter;
    }

    public void k() {
        this.a.unregisterReceiver(this.j);
        this.a.unbindService(this.i);
        BluetoothLeService bluetoothLeService = this.c;
        if (bluetoothLeService != null) {
            bluetoothLeService.j();
        }
        this.c = null;
    }

    public boolean l(byte[] bArr) {
        BluetoothLeService bluetoothLeService = this.c;
        if (bluetoothLeService != null) {
            return bluetoothLeService.p(bArr);
        }
        return false;
    }

    public boolean m(int i) {
        BluetoothLeService bluetoothLeService = this.c;
        if (bluetoothLeService != null) {
            return bluetoothLeService.n(i);
        }
        return false;
    }
}
