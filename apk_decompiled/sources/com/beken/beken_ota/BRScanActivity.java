package com.beken.beken_ota;

import android.R;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.g3;
import defpackage.q30;
import defpackage.ra0;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BRScanActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String o = "BRScanActivity";
    private ra0 a;
    private ra0 b;
    private ra0 c;
    private BluetoothAdapter d;
    private Button f;
    private Button g;
    private ListView h;
    private ListView i;
    private ListView j;
    private ArrayList k;
    private ArrayList l;
    private boolean e = false;
    private AdapterView.OnItemClickListener m = new a();
    private final BroadcastReceiver n = new c();

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) adapterView.getItemAtPosition(i);
            if (bluetoothDevice == null) {
                return;
            }
            Intent intent = new Intent(BRScanActivity.this, (Class<?>) OTAFunctionActivity.class);
            BRScanActivity.this.g.callOnClick();
            try {
                Thread.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            intent.putExtra("DEVICE_NAME", bluetoothDevice.getName());
            intent.putExtra("DEVICE_ADDRESS", bluetoothDevice.getAddress());
            if (bluetoothDevice.getType() == 2) {
                intent.putExtra("OTA_TYPE", 1);
            } else {
                intent.putExtra("OTA_TYPE", 2);
            }
            BRScanActivity.this.startActivityForResult(intent, 2);
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.bluetooth.device.action.FOUND".equals(action)) {
                if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    BRScanActivity.this.f.setEnabled(true);
                    BRScanActivity.this.e = false;
                    BRScanActivity.this.invalidateOptionsMenu();
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice.getBondState() != 12) {
                Log.e(BRScanActivity.o, bluetoothDevice.getAddress() + " " + bluetoothDevice.getType());
                if (!BRScanActivity.this.l.contains(bluetoothDevice.getAddress()) && bluetoothDevice.getType() == 2) {
                    BRScanActivity.this.l.add(bluetoothDevice.getAddress());
                    BRScanActivity.this.c.a(bluetoothDevice);
                    BRScanActivity.this.c.notifyDataSetChanged();
                } else {
                    if (BRScanActivity.this.k.contains(bluetoothDevice.getAddress()) || bluetoothDevice.getType() != 1) {
                        return;
                    }
                    BRScanActivity.this.k.add(bluetoothDevice.getAddress());
                    BRScanActivity.this.b.a(bluetoothDevice);
                    BRScanActivity.this.b.notifyDataSetChanged();
                }
            }
        }
    }

    private static IntentFilter O() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        return intentFilter;
    }

    private void P(boolean z) {
        if (this.d.isDiscovering()) {
            this.d.cancelDiscovery();
        }
        if (z) {
            this.k = new ArrayList();
            this.l = new ArrayList();
            this.d.startDiscovery();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 111 && i2 == 0) {
            Toast.makeText(this, "Please enable your BT and re-run this program.", 1).show();
            finish();
            return;
        }
        if (i != 111 || i2 != -1) {
            if (i == 2 && i2 == 202) {
                new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme.Holo.Dialog)).setTitle("Oops").setMessage("Connect disconnect").setPositiveButton("ok", new b()).show();
                return;
            }
            return;
        }
        Toast.makeText(this, "Bluetooth Enable", 0).show();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R$id.br_scan_start_button) {
            if (id == R$id.br_scan_stop_button) {
                Log.e(o, "stop button click");
                this.e = false;
                P(false);
                this.f.setEnabled(true);
                invalidateOptionsMenu();
                return;
            }
            return;
        }
        Set<BluetoothDevice> bondedDevices = this.d.getBondedDevices();
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (!this.l.contains(bluetoothDevice.getAddress()) && bluetoothDevice.getType() == 2) {
                    this.l.add(bluetoothDevice.getAddress());
                    this.c.a(bluetoothDevice);
                    this.c.notifyDataSetChanged();
                } else if (!this.k.contains(bluetoothDevice.getAddress()) && bluetoothDevice.getType() == 1) {
                    this.k.add(bluetoothDevice.getAddress());
                    this.b.a(bluetoothDevice);
                    this.b.notifyDataSetChanged();
                }
            }
        }
        this.e = true;
        P(true);
        Log.e(o, "button click");
        this.f.setEnabled(false);
        invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_br_scan);
        this.f = (Button) findViewById(R$id.br_scan_start_button);
        this.g = (Button) findViewById(R$id.br_scan_stop_button);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h = (ListView) findViewById(R$id.br_paired_listview);
        this.i = (ListView) findViewById(R$id.br_new_device_listview);
        this.j = (ListView) findViewById(R$id.ble_new_device_listview_2);
        this.d = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        this.h.setOnItemClickListener(this.m);
        this.i.setOnItemClickListener(this.m);
        this.j.setOnItemClickListener(this.m);
        int iA = q30.a(this, "android.permission.ACCESS_COARSE_LOCATION");
        int iA2 = q30.a(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (iA != 0 || iA2 != 0) {
            g3.s(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION"}, 112);
        }
        this.k = new ArrayList();
        this.l = new ArrayList();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R$menu.actionbar, menu);
        if (this.e) {
            menu.findItem(R$id.menu_running).setActionView(R$layout.working_progressbar);
            return true;
        }
        menu.findItem(R$id.menu_running).setActionView((View) null);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.n);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 112) {
            return;
        }
        if (iArr[0] != 0) {
            Log.e(o, "storage denied");
            Toast.makeText(this, "permission request fail", 1).show();
            finish();
        }
        if (iArr[1] != 0) {
            Log.e(o, "location denied");
            Toast.makeText(this, "permission request fail", 1).show();
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.b = new ra0(getLayoutInflater());
        this.a = new ra0(getLayoutInflater());
        this.c = new ra0(getLayoutInflater());
        this.i.setAdapter((ListAdapter) this.b);
        this.h.setAdapter((ListAdapter) this.a);
        this.j.setAdapter((ListAdapter) this.c);
        registerReceiver(this.n, O());
        int iA = q30.a(this, "android.permission.ACCESS_COARSE_LOCATION");
        int iA2 = q30.a(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (iA == 0 || iA2 == 0) {
            if (!this.d.isEnabled()) {
                if (this.d.isEnabled()) {
                    return;
                }
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 111);
            } else {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.f.callOnClick();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
