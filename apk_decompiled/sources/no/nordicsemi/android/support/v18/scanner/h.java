package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class h extends g {
    private final HashMap c = new HashMap();

    static class a extends b.a {
        final l n;

        a(boolean z, boolean z2, List list, ScanSettings scanSettings, l lVar) {
            super(z, z2, list, scanSettings, lVar, new Handler());
            this.n = lVar;
        }
    }

    h() {
    }

    @Override // no.nordicsemi.android.support.v18.scanner.c
    ScanResult f(android.bluetooth.le.ScanResult scanResult) {
        return new ScanResult(scanResult.getDevice(), (((scanResult.getDataStatus() << 5) | (scanResult.isLegacy() ? 16 : 0)) | (scanResult.isConnectable() ? 1 : 0)) == true ? 1 : 0, scanResult.getPrimaryPhy(), scanResult.getSecondaryPhy(), scanResult.getAdvertisingSid(), scanResult.getTxPower(), scanResult.getRssi(), scanResult.getPeriodicAdvertisingInterval(), n.h(scanResult.getScanRecord() != null ? scanResult.getScanRecord().getBytes() : null), scanResult.getTimestampNanos());
    }

    @Override // no.nordicsemi.android.support.v18.scanner.c
    android.bluetooth.le.ScanSettings j(BluetoothAdapter bluetoothAdapter, ScanSettings scanSettings, boolean z) {
        android.bluetooth.le.ScanSettings.Builder builder = new android.bluetooth.le.ScanSettings.Builder();
        if (z || (bluetoothAdapter.isOffloadedScanBatchingSupported() && scanSettings.k())) {
            builder.setReportDelay(scanSettings.i());
        }
        if (z || scanSettings.l()) {
            builder.setCallbackType(scanSettings.b()).setMatchMode(scanSettings.f()).setNumOfMatches(scanSettings.g());
        }
        builder.setScanMode(scanSettings.j()).setLegacy(scanSettings.c()).setPhy(scanSettings.h());
        return builder.build();
    }

    void k(PendingIntent pendingIntent, a aVar) {
        synchronized (this.c) {
            this.c.put(pendingIntent, aVar);
        }
    }

    ScanFilter l(android.bluetooth.le.ScanFilter scanFilter) {
        ScanFilter.b bVar = new ScanFilter.b();
        bVar.b(scanFilter.getDeviceAddress()).c(scanFilter.getDeviceName()).i(scanFilter.getServiceUuid(), scanFilter.getServiceUuidMask()).e(scanFilter.getManufacturerId(), scanFilter.getManufacturerData(), scanFilter.getManufacturerDataMask());
        if (scanFilter.getServiceDataUuid() != null) {
            bVar.g(scanFilter.getServiceDataUuid(), scanFilter.getServiceData(), scanFilter.getServiceDataMask());
        }
        return bVar.a();
    }

    ArrayList m(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(l((android.bluetooth.le.ScanFilter) it.next()));
        }
        return arrayList;
    }

    ScanSettings n(android.bluetooth.le.ScanSettings scanSettings, boolean z, boolean z2, boolean z3, long j, long j2, int i, int i2) {
        return new ScanSettings.b().d(scanSettings.getLegacy()).h(scanSettings.getPhy()).c(scanSettings.getCallbackType()).j(scanSettings.getScanMode()).i(scanSettings.getReportDelayMillis()).k(z).m(z2).l(z3).f(j, j2).e(i).g(i2).a();
    }

    a o(PendingIntent pendingIntent) {
        synchronized (this.c) {
            try {
                if (!this.c.containsKey(pendingIntent)) {
                    return null;
                }
                a aVar = (a) this.c.get(pendingIntent);
                if (aVar != null) {
                    return aVar;
                }
                throw new IllegalStateException("Scanning has been stopped");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
