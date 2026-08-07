package com.beken.beken_ota;

import android.R;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.baji.protocol.model.ProtocolConstants;
import defpackage.ra0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BLEScanActivity extends AppCompatActivity implements View.OnClickListener {
    private ra0 a;
    private ra0 b;
    private BluetoothAdapter c;
    private Handler e;
    private Button f;
    private Button g;
    private ListView h;
    private ListView i;
    private BluetoothLeScanner j;
    private ScanCallback k;
    private ScanSettings l;
    private List m;
    private boolean d = false;
    private AdapterView.OnItemClickListener n = new a();
    private Runnable o = new b();

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) adapterView.getItemAtPosition(i);
            if (bluetoothDevice == null) {
                return;
            }
            BLEScanActivity.this.L(false);
            Intent intent = new Intent(BLEScanActivity.this, (Class<?>) OTAFunctionActivity.class);
            intent.putExtra("DEVICE_NAME", bluetoothDevice.getName());
            intent.putExtra("DEVICE_ADDRESS", bluetoothDevice.getAddress());
            intent.putExtra("OTA_TYPE", 1);
            BLEScanActivity.this.startActivityForResult(intent, 3);
        }
    }

    class b implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BLEScanActivity.this.g.performClick();
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BLEScanActivity.this.j.stopScan(BLEScanActivity.this.k);
            BLEScanActivity.this.runOnUiThread(new a());
        }
    }

    class c extends ScanCallback {

        class a implements Runnable {
            final /* synthetic */ BluetoothDevice a;

            a(BluetoothDevice bluetoothDevice) {
                this.a = bluetoothDevice;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.getBondState() != 12) {
                    BLEScanActivity.this.b.a(this.a);
                    BLEScanActivity.this.b.notifyDataSetChanged();
                }
            }
        }

        c() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.e("ScanResult - Results", ((ScanResult) it.next()).toString());
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            Log.e("Scan Failed", "Error Code: " + i);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            BLEScanActivity.this.runOnUiThread(new a(scanResult.getDevice()));
        }
    }

    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        if (z) {
            Set<BluetoothDevice> bondedDevices = this.c.getBondedDevices();
            if (bondedDevices.size() > 0) {
                Iterator<BluetoothDevice> it = bondedDevices.iterator();
                while (it.hasNext()) {
                    this.a.a(it.next());
                    this.a.notifyDataSetChanged();
                }
            }
            Handler handler = new Handler();
            this.e = handler;
            handler.postDelayed(this.o, ProtocolConstants.CONNECTION_TIMEOUT_MS);
            this.j = this.c.getBluetoothLeScanner();
            this.l = new ScanSettings.Builder().setScanMode(2).build();
            this.m = new ArrayList();
            new IntentFilter("android.bluetooth.device.action.FOUND").addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            this.j.startScan(this.m, this.l, this.k);
            this.d = true;
        } else {
            this.j.stopScan(this.k);
            this.d = false;
        }
        invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 111 && i2 == 0) {
            finish();
        } else if (i == 3 && i2 == 404) {
            new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme.Holo.Dialog)).setTitle("Oops").setMessage("BLE disconnect").setPositiveButton("ok", new d()).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.ble_scan_start_button) {
            this.d = true;
            this.a.b();
            this.b.b();
            L(true);
            invalidateOptionsMenu();
            this.f.setEnabled(false);
            return;
        }
        if (id == R$id.ble_scan_stop_button) {
            this.d = false;
            L(false);
            invalidateOptionsMenu();
            this.f.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_ble_scan);
        this.f = (Button) findViewById(R$id.ble_scan_start_button);
        this.g = (Button) findViewById(R$id.ble_scan_stop_button);
        this.h = (ListView) findViewById(R$id.ble_paired_listview);
        this.i = (ListView) findViewById(R$id.ble_new_device_listview);
        this.g.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.c = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        this.h.setOnItemClickListener(this.n);
        this.i.setOnItemClickListener(this.n);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R$menu.actionbar, menu);
        if (this.d) {
            menu.findItem(R$id.menu_running).setActionView(R$layout.working_progressbar);
            return true;
        }
        menu.findItem(R$id.menu_running).setActionView((View) null);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.c.isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 111);
        }
        this.b = new ra0(getLayoutInflater());
        this.a = new ra0(getLayoutInflater());
        this.i.setAdapter((ListAdapter) this.b);
        this.h.setAdapter((ListAdapter) this.a);
        this.k = new c();
        this.f.callOnClick();
    }
}
