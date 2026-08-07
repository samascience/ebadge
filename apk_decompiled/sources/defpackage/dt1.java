package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class dt1 {
    private static final String n = "dt1";
    private static final UUID o = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private BluetoothAdapter a;
    private String e;
    private Context f;
    private BluetoothDevice g;
    private Thread h;
    private Thread i;
    private boolean j;
    private BluetoothSocket b = null;
    private OutputStream c = null;
    private InputStream d = null;
    private Runnable k = new a();
    private BroadcastReceiver l = new b();
    private Runnable m = new c();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (dt1.this.j) {
                try {
                    int iAvailable = dt1.this.d.available();
                    if (iAvailable > 0) {
                        Log.i(dt1.n, "start read");
                        byte[] bArr = new byte[iAvailable];
                        dt1.this.d.read(bArr, 0, iAvailable);
                        EventBus.getDefault().post(new ci0(203, bArr));
                        Log.i(dt1.n, "read success");
                    }
                } catch (IOException e) {
                    Log.e(dt1.n, e.toString());
                } catch (NullPointerException e2) {
                    Log.e(dt1.n, e2.toString());
                }
            }
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.device.action.ACL_DISCONNECTED") && pv2.b(((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress(), dt1.this.e)) {
                EventBus.getDefault().post(new ci0(202));
                Log.e(dt1.n, "ACTION_ACL_DISCONNECTED");
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dt1 dt1Var = dt1.this;
            dt1Var.g = dt1Var.a.getRemoteDevice(dt1.this.e);
            try {
                dt1 dt1Var2 = dt1.this;
                dt1Var2.b = dt1Var2.g.createInsecureRfcommSocketToServiceRecord(dt1.o);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dt1.this.b.connect();
                EventBus.getDefault().post(new ci0(201));
            } catch (IOException e2) {
                try {
                    dt1.this.b.close();
                    Log.e(dt1.n, "IOException:" + e2.toString());
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                e2.printStackTrace();
            }
        }
    }

    public dt1(Context context, String str) {
        this.a = null;
        this.f = context;
        this.e = str;
        this.a = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        this.f.registerReceiver(this.l, o());
    }

    private static IntentFilter o() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.UUID");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        return intentFilter;
    }

    public void k() {
        Thread thread = new Thread(this.m);
        this.i = thread;
        thread.start();
    }

    public void l() {
        if (this.i.isAlive()) {
            this.i.interrupt();
            this.i = null;
        }
        OutputStream outputStream = this.c;
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.b.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.j = false;
    }

    public void m() {
        try {
            this.c.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean n() {
        BluetoothSocket bluetoothSocket = this.b;
        return bluetoothSocket != null && bluetoothSocket.isConnected();
    }

    public void p() {
        this.j = false;
        this.f.unregisterReceiver(this.l);
    }

    public boolean q(byte[] bArr) {
        if (this.c == null) {
            return false;
        }
        try {
            String str = n;
            Log.i(str, "start write");
            this.c.write(bArr);
            Log.i(str, "start success");
            return true;
        } catch (IOException e) {
            Log.e(n, e.toString());
            return false;
        } catch (NullPointerException e2) {
            Log.e(n, e2.toString());
            return false;
        }
    }

    public boolean r() {
        if (!this.b.isConnected()) {
            return false;
        }
        try {
            this.c = this.b.getOutputStream();
            this.d = this.b.getInputStream();
            this.j = true;
            Thread thread = new Thread(this.k);
            this.h = thread;
            thread.start();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
