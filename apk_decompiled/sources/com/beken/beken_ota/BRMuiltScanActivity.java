package com.beken.beken_ota;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.g3;
import defpackage.pv2;
import defpackage.q30;
import defpackage.ra0;
import defpackage.sm1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BRMuiltScanActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String w = "BRMuiltScanActivity";
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
    private EditText n;
    private String o;
    private EditText p;
    e u;
    f v;
    private boolean e = false;
    private AdapterView.OnItemClickListener m = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Integer f216q = -80;
    private Handler r = new Handler();
    boolean s = false;
    private final BroadcastReceiver t = new d();

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        }
    }

    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Log.e(BRMuiltScanActivity.w, "afterTextChanged:" + editable.toString());
            BRMuiltScanActivity.this.o = editable.toString();
            if (pv2.h(BRMuiltScanActivity.this.o) || BRMuiltScanActivity.this.b == null) {
                return;
            }
            BRMuiltScanActivity bRMuiltScanActivity = BRMuiltScanActivity.this;
            bRMuiltScanActivity.p = (EditText) bRMuiltScanActivity.findViewById(R$id.edt_filter_rssi);
            ArrayList arrayList = new ArrayList();
            ArrayList<BluetoothDevice> arrayListC = BRMuiltScanActivity.this.b.c();
            for (BluetoothDevice bluetoothDevice : arrayListC) {
                if (bluetoothDevice.getName().toLowerCase().contains(BRMuiltScanActivity.this.o.toLowerCase())) {
                    arrayList.add(bluetoothDevice);
                }
            }
            arrayListC.clear();
            arrayListC.addAll(arrayList);
            BRMuiltScanActivity.this.b.notifyDataSetChanged();
            BRMuiltScanActivity.this.f.callOnClick();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.e(BRMuiltScanActivity.w, "beforeTextChanged:" + ((Object) charSequence) + ";start:" + i + ";after:" + i3 + ";count:" + i2);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.e(BRMuiltScanActivity.w, "onTextChanged:" + ((Object) charSequence) + ";start:" + i + ";before:" + i2 + ";count:" + i3);
        }
    }

    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            if (pv2.h(string) || pv2.b(string, "-")) {
                return;
            }
            BRMuiltScanActivity.this.f216q = Integer.valueOf(0 - Math.abs(Integer.valueOf(editable.toString()).intValue()));
            BRMuiltScanActivity.this.b.c().clear();
            BRMuiltScanActivity.this.b.notifyDataSetChanged();
            BRMuiltScanActivity.this.f.callOnClick();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class d extends BroadcastReceiver {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.e(BRMuiltScanActivity.w, "reset status");
                sm1.d().c();
                BRMuiltScanActivity.this.s = false;
            }
        }

        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.bluetooth.device.action.FOUND".equals(action)) {
                if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    BRMuiltScanActivity.this.f.setEnabled(true);
                    BRMuiltScanActivity.this.invalidateOptionsMenu();
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE);
            Log.e(BRMuiltScanActivity.w, "rssi:" + ((int) shortExtra) + ";" + bluetoothDevice.getAddress());
            String name = bluetoothDevice.getName();
            if (pv2.h(name)) {
                Log.e(BRMuiltScanActivity.w, "name is empty address:" + bluetoothDevice.toString());
                return;
            }
            if (bluetoothDevice.getBondState() != 12) {
                if (bluetoothDevice.getType() == 2) {
                    Log.e(BRMuiltScanActivity.w, "ble device:" + bluetoothDevice.toString() + ";name:" + name);
                    if (shortExtra >= BRMuiltScanActivity.this.f216q.intValue() - 10) {
                        BRMuiltScanActivity bRMuiltScanActivity = BRMuiltScanActivity.this;
                        if (bRMuiltScanActivity.s) {
                            return;
                        }
                        bRMuiltScanActivity.s = true;
                        sm1.d().a(bluetoothDevice.getAddress());
                        BRMuiltScanActivity.this.r.postDelayed(new a(), 20000L);
                        return;
                    }
                    Log.e(BRMuiltScanActivity.w, "ble signal is weak:" + ((int) shortExtra) + ";" + bluetoothDevice.getName() + ";address:" + bluetoothDevice.getAddress());
                    return;
                }
                if (BRMuiltScanActivity.this.k.contains(bluetoothDevice.getAddress()) || bluetoothDevice.getType() != 1) {
                    return;
                }
                if (shortExtra < BRMuiltScanActivity.this.f216q.intValue()) {
                    Log.e(BRMuiltScanActivity.w, "classic signal is weak:" + ((int) shortExtra) + ";" + bluetoothDevice.getName() + ";address:" + bluetoothDevice.getAddress());
                    return;
                }
                if (!pv2.h(BRMuiltScanActivity.this.o) && !name.toLowerCase().contains(BRMuiltScanActivity.this.o.toLowerCase())) {
                    Log.e(BRMuiltScanActivity.w, "name no match:" + bluetoothDevice.toString() + ";name:" + name);
                    return;
                }
                Log.e(BRMuiltScanActivity.w, bluetoothDevice.getAddress() + " " + bluetoothDevice.getType() + ";name:" + name + ";rssi:" + ((int) shortExtra));
                BRMuiltScanActivity.this.k.add(bluetoothDevice.getAddress());
                BRMuiltScanActivity.this.b.a(bluetoothDevice);
                BRMuiltScanActivity.this.b.notifyDataSetChanged();
                if (BRMuiltScanActivity.this.e) {
                    BRMuiltScanActivity.this.e = false;
                    BRMuiltScanActivity.this.Z();
                    BRMuiltScanActivity.this.v.a(bluetoothDevice);
                    BRMuiltScanActivity.this.r.postDelayed(BRMuiltScanActivity.this.v, 3000L);
                }
            }
        }
    }

    private class e implements Runnable {
        private e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(BRMuiltScanActivity.w, "auto scanning device");
            BRMuiltScanActivity.this.U();
        }

        /* synthetic */ e(BRMuiltScanActivity bRMuiltScanActivity, a aVar) {
            this();
        }
    }

    private class f implements Runnable {
        BluetoothDevice a;

        private f() {
        }

        public void a(BluetoothDevice bluetoothDevice) {
            this.a = bluetoothDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(BRMuiltScanActivity.this, (Class<?>) OTAMuiltFunctionActivity.class);
            intent.putExtra("DEVICE_NAME", this.a.getName());
            intent.putExtra("DEVICE_ADDRESS", this.a.getAddress());
            intent.putExtra("OTA_TYPE", 2);
            BRMuiltScanActivity.this.startActivityForResult(intent, 2);
        }

        /* synthetic */ f(BRMuiltScanActivity bRMuiltScanActivity, a aVar) {
            this();
        }
    }

    public BRMuiltScanActivity() {
        a aVar = null;
        this.u = new e(this, aVar);
        this.v = new f(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.e = true;
        W(true);
        Log.e(w, "button click");
        this.f.setEnabled(false);
        invalidateOptionsMenu();
        X();
    }

    private static IntentFilter V() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        return intentFilter;
    }

    private void W(boolean z) {
        if (this.d.isDiscovering()) {
            this.d.cancelDiscovery();
        }
        if (z) {
            this.k = new ArrayList();
            this.l = new ArrayList();
            this.d.startDiscovery();
        }
    }

    private void X() {
        this.r.postDelayed(this.u, 15000L);
    }

    private void Y() {
        this.r.removeCallbacks(this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        Log.e(w, "stop button click");
        this.e = false;
        W(false);
        this.f.setEnabled(true);
        invalidateOptionsMenu();
        Y();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 111 && i2 == 0) {
            Toast.makeText(this, "Please enable your BT and re-run this program.", 1).show();
            finish();
        } else if (i == 111 && i2 == -1) {
            Toast.makeText(this, "Bluetooth Enable", 0).show();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.br_scan_start_button) {
            U();
        } else if (id == R$id.br_scan_stop_button) {
            this.r.removeCallbacks(this.v);
            Z();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_br_muilt_scan);
        this.f = (Button) findViewById(R$id.br_scan_start_button);
        this.g = (Button) findViewById(R$id.br_scan_stop_button);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h = (ListView) findViewById(R$id.br_paired_listview);
        this.i = (ListView) findViewById(R$id.br_new_device_listview);
        this.j = (ListView) findViewById(R$id.ble_new_device_listview_2);
        EditText editText = (EditText) findViewById(R$id.edt_filter_name);
        this.n = editText;
        this.o = editText.getText().toString();
        this.n.addTextChangedListener(new b());
        EditText editText2 = (EditText) findViewById(R$id.edt_filter_rssi);
        this.p = editText2;
        this.f216q = Integer.valueOf(0 - Integer.valueOf(editText2.getText().toString()).intValue());
        this.p.addTextChangedListener(new c());
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
        this.g.callOnClick();
        Y();
        this.r.removeCallbacks(this.v);
        unregisterReceiver(this.t);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 112) {
            return;
        }
        if (iArr[0] != 0) {
            Log.e(w, "storage denied");
            Toast.makeText(this, "permission request fail", 1).show();
            finish();
        }
        if (iArr[1] != 0) {
            Log.e(w, "location denied");
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
        registerReceiver(this.t, V());
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
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
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
