package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import defpackage.ek2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class l extends ek2 {
    private final PendingIntent a;
    private Context b;
    private Context c;
    private long d;
    private final long e;

    l(PendingIntent pendingIntent, ScanSettings scanSettings) {
        this.a = pendingIntent;
        this.e = scanSettings.i();
    }

    void a(Context context) {
        this.b = context;
    }

    @Override // defpackage.ek2
    public void onBatchScanResults(List list) {
        Context context = this.b;
        if (context == null) {
            context = this.c;
        }
        if (context == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.d > (jElapsedRealtime - this.e) + 5) {
            return;
        }
        this.d = jElapsedRealtime;
        try {
            Intent intent = new Intent();
            intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1);
            intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList<>(list));
            intent.setExtrasClassLoader(ScanResult.class.getClassLoader());
            this.a.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    @Override // defpackage.ek2
    public void onScanFailed(int i) {
        Context context = this.b;
        if (context == null) {
            context = this.c;
        }
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("android.bluetooth.le.extra.ERROR_CODE", i);
            this.a.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    @Override // defpackage.ek2
    public void onScanResult(int i, ScanResult scanResult) {
        Context context = this.b;
        if (context == null) {
            context = this.c;
        }
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", i);
            intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList<>(Collections.singletonList(scanResult)));
            this.a.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    l(PendingIntent pendingIntent, ScanSettings scanSettings, Service service) {
        this.a = pendingIntent;
        this.e = scanSettings.i();
        this.c = service;
    }
}
