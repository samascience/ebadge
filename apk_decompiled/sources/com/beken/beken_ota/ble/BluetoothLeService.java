package com.beken.beken_ota.ble;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import defpackage.ci0;
import java.util.List;
import java.util.UUID;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothLeService extends Service {
    private static final String h = "BluetoothLeService";
    static final UUID i = UUID.fromString("f000ffc0-0451-4000-b000-000000000000");
    static final UUID j = UUID.fromString("f000ffc1-0451-4000-b000-000000000000");
    static final UUID k = UUID.fromString("f000ffc2-0451-4000-b000-000000000000");
    private static int l = 0;
    private BluetoothManager a;
    private BluetoothAdapter b;
    private String c;
    private BluetoothGatt d;
    private BluetoothGattCharacteristic e;
    private final BluetoothGattCallback f = new a();
    private final IBinder g = new b();

    class a extends BluetoothGattCallback {
        a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BluetoothLeService.this.g("com.example.bluetooth.le.ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                BluetoothLeService.this.g("com.example.bluetooth.le.ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 2) {
                Log.e(BluetoothLeService.h, "Connected to GATT server");
                BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_GATT_CONNECTED");
            } else if (i2 == 0) {
                BluetoothLeService.this.c = null;
                BluetoothLeService.this.h();
                Log.e(BluetoothLeService.h, "Disconnected from GATT server");
                BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_GATT_DISCONNECTED");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            if (i != 0) {
                Log.w(BluetoothLeService.h, "onDescriptorRead is not success");
                BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_NOTIFY_FAIL");
                return;
            }
            byte[] value = bluetoothGattDescriptor.getValue();
            if (value == null || value.length <= 0) {
                Log.w(BluetoothLeService.h, "onDescriptorRead data length wrong");
                BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_NOTIFY_FAIL");
                return;
            }
            StringBuilder sb = new StringBuilder(value.length);
            for (byte b : value) {
                sb.append(String.format("%02X ", Byte.valueOf(b)));
            }
            Intent intent = new Intent("com.example.bluetooth.le.ACTION_NOTIFY_SUCCESS");
            intent.putExtra("com.example.bluetooth.le.EXTRA_DATA", sb.toString());
            BluetoothLeService.this.sendBroadcast(intent);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            if (i != 0) {
                Log.w(BluetoothLeService.h, "onDescriptorWrite is not success");
                return;
            }
            byte[] value = bluetoothGattDescriptor.getValue();
            if (value == null || value.length <= 0) {
                return;
            }
            BluetoothLeService.this.f("com.example.bluetooth.le.ENABLE_NOTIFY_2");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            Log.e(BluetoothLeService.h, "mtu " + i + " " + i2);
            super.onMtuChanged(bluetoothGatt, i, i2);
            if (i2 == 0) {
                EventBus.getDefault().post(new ci0(405, i));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            super.onReliableWriteCompleted(bluetoothGatt, i);
            BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_DATA_WRITE_SUCCESS");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED");
            } else {
                BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED_FAIL");
            }
        }
    }

    public class b extends Binder {
        public b() {
        }

        public BluetoothLeService a() {
            return BluetoothLeService.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        sendBroadcast(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intent intent = new Intent(str);
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value != null && value.length > 0) {
            intent.putExtra("com.example.bluetooth.le.EXTRA_DATA", new StringBuilder(value.length).toString());
            intent.putExtra("com.example.bluetooth.le.EXTRA_DATA_BYTE", bluetoothGattCharacteristic.getValue());
            intent.putExtra("com.example.bluetooth.le.EXTRA_UUID", bluetoothGattCharacteristic.getUuid().toString());
        }
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        BluetoothGatt bluetoothGatt = this.d;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        this.d = null;
    }

    public boolean i(String str) {
        if (this.b == null || str == null) {
            Log.e(h, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        String str2 = this.c;
        if (str2 != null && str.equals(str2) && this.d != null) {
            String str3 = h;
            Log.e(str3, "Trying to use an existing mBluetoothGatt for connection.");
            this.d.disconnect();
            if (this.d.connect()) {
                return true;
            }
            Log.e(str3, "Gatt connect fail_2");
            return false;
        }
        BluetoothDevice remoteDevice = this.b.getRemoteDevice(str);
        if (remoteDevice == null) {
            Log.e(h, "Device not found.  Unable to connect.");
            return false;
        }
        BluetoothGatt bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.f, 2);
        this.d = bluetoothGattConnectGatt;
        if (bluetoothGattConnectGatt == null) {
            Log.e(h, "Bluetoothgatt object is null");
            return false;
        }
        this.c = str;
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.d.connect()) {
            return true;
        }
        Log.e(h, "Gatt connect fail_1");
        return false;
    }

    public void j() {
        if (this.b == null || this.d == null) {
            Log.w(h, "BluetoothAdapter not initialized");
            return;
        }
        Log.i(h, "disconnect() called disconnect");
        this.c = null;
        this.d.disconnect();
    }

    public List k() {
        BluetoothGatt bluetoothGatt = this.d;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public boolean l() {
        if (this.a == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.a = bluetoothManager;
            if (bluetoothManager == null) {
                Log.w(h, "Unable to initialize BluetoothManager.");
                return false;
            }
        }
        BluetoothAdapter adapter = this.a.getAdapter();
        this.b = adapter;
        if (adapter != null) {
            return true;
        }
        Log.w(h, "Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public boolean m(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGatt bluetoothGatt;
        if (this.b == null || (bluetoothGatt = this.d) == null) {
            Log.w(h, "BluetoothAdapter not initialized");
            return false;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        if (z) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            return this.d.writeDescriptor(descriptor);
        }
        descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        return this.d.writeDescriptor(descriptor);
    }

    boolean n(int i2) {
        BluetoothGatt bluetoothGatt = this.d;
        if (bluetoothGatt == null) {
            return false;
        }
        bluetoothGatt.requestMtu(i2);
        return false;
    }

    public void o() {
        BluetoothGatt bluetoothGatt = this.d;
        if (bluetoothGatt == null || bluetoothGatt.discoverServices()) {
            return;
        }
        Log.e(h, "start discoverServices fail");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.g;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        h();
        return super.onUnbind(intent);
    }

    public boolean p(byte[] bArr) {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.d;
        if (bluetoothGatt == null || (service = bluetoothGatt.getService(i)) == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(j);
        this.e = characteristic;
        if (characteristic == null) {
            Log.w(h, "mBluetoothGattCharateristic is null");
            return false;
        }
        characteristic.setWriteType(1);
        this.e.setValue(bArr);
        return this.d.writeCharacteristic(this.e);
    }
}
