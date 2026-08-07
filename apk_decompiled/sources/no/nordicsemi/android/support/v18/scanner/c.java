package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.os.Handler;
import android.os.SystemClock;
import defpackage.ek2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class c extends no.nordicsemi.android.support.v18.scanner.b {
    private final m b = new m();

    static class b extends no.nordicsemi.android.support.v18.scanner.b.a {
        private final ScanCallback n;

        class a extends ScanCallback {
            private long a;

            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d(List list) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (this.a > (jElapsedRealtime - b.this.g.i()) + 5) {
                    return;
                }
                this.a = jElapsedRealtime;
                b.this.h(((c) no.nordicsemi.android.support.v18.scanner.b.a()).g(list));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(int i) {
                if (!b.this.g.l() || b.this.g.b() == 1) {
                    b.this.f(i);
                    return;
                }
                b.this.g.a();
                no.nordicsemi.android.support.v18.scanner.b bVarA = no.nordicsemi.android.support.v18.scanner.b.a();
                try {
                    bVarA.d(b.this.h);
                } catch (Exception unused) {
                }
                try {
                    b bVar = b.this;
                    bVarA.c(bVar.f, bVar.g, bVar.h, bVar.i);
                } catch (Exception unused2) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(android.bluetooth.le.ScanResult scanResult, int i) {
                b.this.g(i, ((c) no.nordicsemi.android.support.v18.scanner.b.a()).f(scanResult));
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(final List list) {
                b.this.i.post(new Runnable() { // from class: no.nordicsemi.android.support.v18.scanner.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d(list);
                    }
                });
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(final int i) {
                b.this.i.post(new Runnable() { // from class: no.nordicsemi.android.support.v18.scanner.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e(i);
                    }
                });
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(final int i, final android.bluetooth.le.ScanResult scanResult) {
                b.this.i.post(new Runnable() { // from class: no.nordicsemi.android.support.v18.scanner.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f(scanResult, i);
                    }
                });
            }
        }

        private b(boolean z, boolean z2, List list, ScanSettings scanSettings, ek2 ek2Var, Handler handler) {
            super(z, z2, list, scanSettings, ek2Var, handler);
            this.n = new a();
        }
    }

    c() {
    }

    @Override // no.nordicsemi.android.support.v18.scanner.b
    void c(List list, ScanSettings scanSettings, ek2 ek2Var, Handler handler) {
        b bVar;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            throw new IllegalStateException("BT le scanner not available");
        }
        boolean zIsOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
        boolean zIsOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
        synchronized (this.b) {
            if (this.b.c(ek2Var)) {
                throw new IllegalArgumentException("scanner already started with given callback");
            }
            bVar = new b(zIsOffloadedScanBatchingSupported, zIsOffloadedFilteringSupported, list, scanSettings, new o(ek2Var), handler);
            this.b.a(bVar);
        }
        bluetoothLeScanner.startScan((!list.isEmpty() && zIsOffloadedFilteringSupported && scanSettings.m()) ? i(list) : null, j(defaultAdapter, scanSettings, false), bVar.n);
    }

    @Override // no.nordicsemi.android.support.v18.scanner.b
    void e(ek2 ek2Var) {
        b bVar;
        BluetoothLeScanner bluetoothLeScanner;
        synchronized (this.b) {
            bVar = (b) this.b.d(ek2Var);
        }
        if (bVar == null) {
            return;
        }
        bVar.d();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return;
        }
        bluetoothLeScanner.stopScan(bVar.n);
    }

    abstract ScanResult f(android.bluetooth.le.ScanResult scanResult);

    ArrayList g(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((android.bluetooth.le.ScanResult) it.next()));
        }
        return arrayList;
    }

    android.bluetooth.le.ScanFilter h(ScanFilter scanFilter) {
        android.bluetooth.le.ScanFilter.Builder builder = new android.bluetooth.le.ScanFilter.Builder();
        builder.setServiceUuid(scanFilter.i(), scanFilter.j()).setManufacturerData(scanFilter.e(), scanFilter.c(), scanFilter.d());
        if (scanFilter.a() != null) {
            builder.setDeviceAddress(scanFilter.a());
        }
        if (scanFilter.b() != null) {
            builder.setDeviceName(scanFilter.b());
        }
        if (scanFilter.h() != null) {
            builder.setServiceData(scanFilter.h(), scanFilter.f(), scanFilter.g());
        }
        return builder.build();
    }

    ArrayList i(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(h((ScanFilter) it.next()));
        }
        return arrayList;
    }

    abstract android.bluetooth.le.ScanSettings j(BluetoothAdapter bluetoothAdapter, ScanSettings scanSettings, boolean z);
}
