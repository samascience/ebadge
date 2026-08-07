package com.phy.ota_demo.basic;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import defpackage.r02;

/* JADX INFO: loaded from: classes.dex */
public abstract class PhyActivity extends BasicActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        finish();
    }

    protected void back(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: n02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I(view);
            }
        });
    }

    protected void backAndFinish(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: m02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.J(view);
            }
        });
    }

    protected void exitTheProgram() {
        r02.a().b();
    }

    protected abstract int getLayout();

    protected boolean hasAccessFineLocation() {
        return hasPermission("android.permission.ACCESS_FINE_LOCATION");
    }

    protected boolean hasBluetoothConnect() {
        return hasPermission("android.permission.BLUETOOTH_CONNECT");
    }

    protected boolean hasBluetoothScan() {
        return hasPermission("android.permission.BLUETOOTH_SCAN");
    }

    protected boolean hasCoarseLocation() {
        return hasPermission("android.permission.ACCESS_COARSE_LOCATION");
    }

    protected boolean hasPermission(String str) {
        return checkSelfPermission(str) == 0;
    }

    protected boolean hasStorage() {
        return hasPermission("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    protected boolean isAndroid11() {
        return Build.VERSION.SDK_INT >= 30;
    }

    protected boolean isAndroid12() {
        return Build.VERSION.SDK_INT >= 31;
    }

    protected boolean isOpenBluetooth() {
        BluetoothAdapter adapter;
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) {
            return false;
        }
        return adapter.isEnabled();
    }

    protected boolean isOpenLocation() {
        LocationManager locationManager = (LocationManager) getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    protected boolean isStorageManager() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return false;
    }

    protected void jumpActivity(Class<?> cls) {
        startActivity(new Intent(this.context, cls));
    }

    protected void jumpActivityFinish(Class<?> cls) {
        startActivity(new Intent(this.context, cls));
        finish();
    }

    protected abstract void onCreate();

    @Override // com.phy.ota_demo.basic.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        onRegister();
        super.onCreate(bundle);
        setStatusBar(false);
        setContentView(getLayout());
        onCreate();
    }

    protected void onRegister() {
    }

    protected void setStatusBar(boolean z) {
        View decorView = getWindow().getDecorView();
        if (z) {
            decorView.setSystemUiVisibility(9216);
        } else {
            decorView.setSystemUiVisibility(1280);
        }
    }

    protected void showMsg(CharSequence charSequence) {
        Toast.makeText(r02.a, charSequence, 0).show();
    }
}
