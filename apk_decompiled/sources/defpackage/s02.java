package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s02 {
    private static BluetoothAdapter f;
    private static BluetoothLeScanner g;
    private static Context h;
    private static volatile s02 i;
    private List b;
    private ScanSettings c;
    private t02 d;
    private boolean a = false;
    private final ScanCallback e = new a();

    class a extends ScanCallback {
        a() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List list) {
            if (s02.this.d != null) {
                s02.this.d.onBatchScanResults(list);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            String str;
            if (i == 1) {
                str = "Fails to start scan as BLE scan with the same settings is already started by the app.";
            } else if (i == 2) {
                str = "Fails to start scan as app cannot be registered.";
            } else if (i != 3) {
                str = i != 4 ? "UNKNOWN_ERROR" : "Fails to start power optimized scan as this feature is not supported.";
            } else {
                str = "Fails to start scan due an internal error";
            }
            if (s02.this.d != null) {
                s02.this.d.onScanFailed(str);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            if (s02.this.d != null) {
                s02.this.d.onScanResult(scanResult);
            }
        }
    }

    public s02(Context context) {
        h = context;
        this.b = new ArrayList();
        this.c = new ScanSettings.Builder().setScanMode(2).build();
    }

    public static s02 b(Context context) {
        BluetoothManager bluetoothManager;
        if (i == null) {
            synchronized (s02.class) {
                try {
                    if (i == null) {
                        i = new s02(context);
                        Context context2 = h;
                        if (context2 != null && (bluetoothManager = (BluetoothManager) context2.getSystemService("bluetooth")) != null) {
                            BluetoothAdapter adapter = bluetoothManager.getAdapter();
                            f = adapter;
                            if (adapter != null) {
                                g = adapter.getBluetoothLeScanner();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    private boolean c() {
        return e("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean d() {
        return e("android.permission.BLUETOOTH_SCAN");
    }

    private boolean e(String str) {
        return h.checkSelfPermission(str) == 0;
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 31;
    }

    protected boolean g() {
        BluetoothAdapter bluetoothAdapter = f;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.isEnabled();
        }
        this.d.onScanFailed("BluetoothAdapter is Null.");
        return false;
    }

    public boolean h() {
        return this.a;
    }

    public void i(t02 t02Var) {
        this.d = t02Var;
    }

    public void j() {
        if (!g()) {
            this.d.onScanFailed("Bluetooth is not turned on.");
            return;
        }
        if (f()) {
            if (!d()) {
                this.d.onScanFailed("Android 12 needs to dynamically request bluetooth scan permission.");
                return;
            }
        } else if (!c()) {
            this.d.onScanFailed("Android 6 to 12 requires dynamic request location permission.");
            return;
        }
        if (this.a) {
            this.d.onScanFailed("Currently scanning, please close the current scan and scan again.");
            return;
        }
        BluetoothLeScanner bluetoothLeScanner = g;
        if (bluetoothLeScanner == null) {
            this.d.onScanFailed("BluetoothLeScanner is Null.");
        } else {
            bluetoothLeScanner.startScan(this.b, this.c, this.e);
            this.a = true;
        }
    }

    public void k() {
        if (!this.a) {
            this.d.onScanFailed("Not currently scanning, your stop has no effect.");
            return;
        }
        BluetoothLeScanner bluetoothLeScanner = g;
        if (bluetoothLeScanner == null) {
            this.d.onScanFailed("BluetoothLeScanner is Null.");
        } else {
            bluetoothLeScanner.stopScan(this.e);
            this.a = false;
        }
    }
}
