package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;
import no.nordicsemi.android.support.v18.scanner.b;

/* JADX INFO: loaded from: classes3.dex */
public final class ft1 {
    private static ek2 b;
    private static boolean c;
    private static boolean d;
    public static final ft1 a = new ft1();
    private static final ek2 e = new a();

    public static final class a extends ek2 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            ft1.a.c();
        }

        @Override // defpackage.ek2
        public void onBatchScanResults(List list) {
            p31.f(list, "results");
            ek2 ek2Var = ft1.b;
            if (ek2Var != null) {
                ek2Var.onBatchScanResults(list);
            }
        }

        @Override // defpackage.ek2
        public void onScanFailed(int i) {
            ek2 ek2Var = ft1.b;
            if (ek2Var != null) {
                ek2Var.onScanFailed(i);
            }
            if (i == 2) {
                ft1.a.b();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: et1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ft1.a.b();
                    }
                }, 3000L);
            }
        }

        @Override // defpackage.ek2
        public void onScanResult(int i, ScanResult scanResult) {
            p31.f(scanResult, "result");
            ek2 ek2Var = ft1.b;
            if (ek2Var != null) {
                ek2Var.onScanResult(i, scanResult);
            }
            Log.d("TAG", "onScanResult:" + scanResult.a().getAddress() + ft1.b);
        }
    }

    private ft1() {
    }

    public final void b() {
        if (!c || d) {
            return;
        }
        b bVarA = b.a();
        p31.e(bVarA, "getScanner(...)");
        bVarA.d(e);
        d = true;
        Log.d("BluetoothScanHelper", "扫描已暂停");
    }

    public final void c() {
        if (!d || b == null) {
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            d = false;
            return;
        }
        ScanSettings scanSettingsA = new ScanSettings.b().d(false).j(2).k(false).a();
        p31.e(scanSettingsA, "build(...)");
        b bVarA = b.a();
        p31.e(bVarA, "getScanner(...)");
        try {
            bVarA.b(null, scanSettingsA, e);
            d = false;
            Log.d("BluetoothScanHelper", "扫描已恢复");
        } catch (IllegalStateException e2) {
            d = false;
            Log.e("BluetoothScanHelper", "恢复扫描失败", e2);
        }
    }

    public final void d(ek2 ek2Var) {
        p31.f(ek2Var, "listener");
        b = ek2Var;
    }

    public final void e() {
        if (!c || d) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                c = false;
                d = false;
                return;
            }
            ScanSettings scanSettingsA = new ScanSettings.b().d(false).j(2).k(false).a();
            p31.e(scanSettingsA, "build(...)");
            b bVarA = b.a();
            p31.e(bVarA, "getScanner(...)");
            try {
                ek2 ek2Var = e;
                bVarA.d(ek2Var);
                bVarA.b(null, scanSettingsA, ek2Var);
                c = true;
                d = false;
            } catch (IllegalStateException unused) {
                c = false;
                d = false;
            }
        }
    }

    public final void f() {
        if (c) {
            b bVarA = b.a();
            p31.e(bVarA, "getScanner(...)");
            bVarA.d(e);
            c = false;
            d = false;
            b = null;
        }
    }
}
