package com.beken.beken_ota;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.g3;
import defpackage.q30;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String d = "MainActivity";
    private Button a;
    private Button b;
    private BluetoothAdapter c = null;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 111 && i2 == 0) {
            Toast.makeText(this, "Please enable your BT and re-run this program.", 1).show();
            finish();
        } else if (i == 111 && i2 == -1) {
            Toast.makeText(this, "Bluetooth Enable", 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.button_ble_mode) {
            startActivityForResult(new Intent(this, (Class<?>) BLEScanActivity.class), 113);
        } else if (id == R$id.button_br_mode) {
            startActivityForResult(new Intent(this, (Class<?>) BRScanActivity.class), 114);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_main);
        int iA = q30.a(this, "android.permission.ACCESS_COARSE_LOCATION");
        int iA2 = q30.a(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (iA != 0 || iA2 != 0) {
            g3.s(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
        }
        this.b = (Button) findViewById(R$id.button_ble_mode);
        this.a = (Button) findViewById(R$id.button_br_mode);
        this.b.setOnClickListener(this);
        this.a.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 112) {
            return;
        }
        if (iArr[0] != 0) {
            Log.e(d, "location denied");
        }
        if (iArr[1] != 0) {
            Log.e(d, "storage denied");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        this.c = adapter;
        if (adapter == null) {
            Toast.makeText(this, "Bluetooth is not available.", 1).show();
            finish();
        } else {
            if (adapter.isEnabled()) {
                return;
            }
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 111);
        }
    }
}
