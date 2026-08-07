package com.onmicro.omtoolbox.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import defpackage.ed1;
import defpackage.oc1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BleService extends Service {
    private BluetoothManager c;
    private BluetoothAdapter d;
    private BluetoothGatt e;
    private f f;
    private String j;
    private boolean k;
    private boolean l;
    public int a = 0;
    private int b = 0;
    private final Object g = new Object();
    public List h = new ArrayList();
    private byte[] i = null;
    private int m = 2;
    private Handler n = new a();
    private BluetoothAdapter.LeScanCallback o = new b();
    private BluetoothGattCallback p = new c();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BroadcastReceiver f305q = new d();
    private final IBinder r = new e();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                BleService bleService = BleService.this;
                bleService.w(bleService.j, BleService.this.l);
            } else {
                if (i != 2) {
                    return;
                }
                if (BleService.this.d != null && BleService.this.k) {
                    BleService.this.d.stopLeScan(BleService.this.o);
                    BleService.this.k = false;
                }
                BleService.this.n.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    class b implements BluetoothAdapter.LeScanCallback {
        b() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice == null || !bluetoothDevice.getAddress().equals(BleService.this.j)) {
                return;
            }
            BleService.this.n.sendEmptyMessage(2);
        }
    }

    class c extends BluetoothGattCallback {
        c() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BleService.this.t("ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                BleService.this.t("ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            BleService.this.b = 0;
            if (BleService.this.h.isEmpty()) {
                return;
            }
            BleService bleService = BleService.this;
            bleService.i = (byte[]) bleService.h.get(0);
            BleService.this.h.remove(0);
            BleService.this.q();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 2) {
                ed1.b("BleService", "STATE_CONNECTED");
                BleService bleService = BleService.this;
                bleService.a = 2;
                bleService.b = 0;
                BleService.this.u("ACTION_GATT_CONNECTED", String.valueOf(i2));
                BleService.this.e.discoverServices();
                return;
            }
            if (i2 == 0) {
                ed1.b("BleService", "STATE_DISCONNECTED " + BleService.this.l);
                BleService bleService2 = BleService.this;
                bleService2.a = 0;
                bleService2.v();
                BleService.this.u("ACTION_GATT_DISCONNECTED", String.valueOf(i2));
                if (BleService.this.l) {
                    BleService.this.n.sendEmptyMessageDelayed(1, 500L);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            BleService.this.s("ACTION_READ_RSSI", i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            ed1.b("BleService", "onServicesDiscovered:" + i);
            if (i == 0) {
                BleService.this.u("ACTION_GATT_SERVICES_DISCOVERED", String.valueOf(i));
            }
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice;
            String action = intent.getAction();
            action.hashCode();
            if (!action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED") && (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) != null) {
                    int bondState = bluetoothDevice.getBondState();
                    if (bondState == 12) {
                        ed1.b("BleService", "已配对");
                        return;
                    } else if (bondState == 11) {
                        ed1.b("BleService", "正在配对");
                        return;
                    } else {
                        if (bondState == 10) {
                            ed1.b("BleService", "配对失败");
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) != 10) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                    ed1.b("BleService", "STATE_ON");
                    if (BleService.this.l) {
                        BleService.this.n.sendEmptyMessageDelayed(1, 1000L);
                        return;
                    }
                    return;
                }
                return;
            }
            ed1.b("BleService", "STATE_OFF");
            if (BleService.this.k) {
                BleService.this.d.stopLeScan(BleService.this.o);
                BleService.this.k = false;
            }
            BleService.this.n.removeMessages(2);
            BleService.this.n.removeMessages(1);
            BleService bleService = BleService.this;
            if (bleService.a == 2) {
                bleService.a = 0;
                bleService.u("ACTION_GATT_DISCONNECTED", "ble_state_off");
            }
            BleService.this.v();
        }
    }

    public class e extends Binder {
        public e() {
        }
    }

    class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            byte[] byteArrayExtra = intent.getByteArrayExtra("value");
            if (byteArrayExtra != null && "ACTION_SEND_DATA_TO_BLE".equals(action)) {
                BleService.this.r(byteArrayExtra, false);
            }
        }
    }

    private void A() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("ACTION_READ_RSSI");
        registerReceiver(this.f305q, intentFilter);
        this.f = new f();
        oc1.b(this).c(this.f, z());
    }

    private void B() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.d.startLeScan(this.o);
    }

    private void C() {
        if (this.f != null) {
            oc1.b(this).e(this.f);
        }
        unregisterReceiver(this.f305q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        byte[] bArr = this.i;
        if (bArr != null) {
            int length = bArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(byte[] bArr, boolean z) {
        ed1.b("BleService", "mConnState:" + this.a + ", ble_status:" + this.b);
        if (this.a == 2) {
            if (this.b != 0) {
                if (z) {
                    return;
                }
                this.h.add(bArr);
                return;
            }
            this.b = 1;
            if (this.h.isEmpty()) {
                this.i = bArr;
            } else {
                this.i = (byte[]) this.h.get(0);
                if (!z) {
                    this.h.add(bArr);
                }
                this.h.remove(0);
            }
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, int i) {
        Intent intent = new Intent(str);
        intent.putExtra("rssi", i);
        oc1.b(this).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2) {
        Intent intent = new Intent(str);
        intent.putExtra("status", str2);
        oc1.b(this).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        BluetoothGatt bluetoothGatt = this.e;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.e = null;
        }
    }

    private void y() {
        if (this.c == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.c = bluetoothManager;
            if (bluetoothManager == null) {
                return;
            }
        }
        this.d = this.c.getAdapter();
    }

    private IntentFilter z() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_SEND_DATA_TO_BLE");
        return intentFilter;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.r;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        y();
        A();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C();
        x(false);
        this.n.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void w(String str, boolean z) {
        BluetoothAdapter bluetoothAdapter;
        synchronized (this.g) {
            try {
                this.l = z;
                if (this.a != 2 && (bluetoothAdapter = this.d) != null && bluetoothAdapter.isEnabled() && !TextUtils.isEmpty(str)) {
                    BluetoothDevice remoteDevice = this.d.getRemoteDevice(str);
                    if (remoteDevice == null) {
                        B();
                    } else {
                        v();
                        this.j = remoteDevice.getAddress();
                        this.a = 1;
                        BluetoothGatt bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.p);
                        this.e = bluetoothGattConnectGatt;
                        if (bluetoothGattConnectGatt == null) {
                            this.a = 0;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x(boolean z) {
        synchronized (this.g) {
            try {
                this.l = z;
                BluetoothGatt bluetoothGatt = this.e;
                if (bluetoothGatt == null) {
                    this.a = 0;
                    u("ACTION_GATT_DISCONNECTED", Constants.STR_EMPTY);
                } else if (this.a == 2) {
                    bluetoothGatt.disconnect();
                } else {
                    v();
                    u("ACTION_GATT_DISCONNECTED", Constants.STR_EMPTY);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
