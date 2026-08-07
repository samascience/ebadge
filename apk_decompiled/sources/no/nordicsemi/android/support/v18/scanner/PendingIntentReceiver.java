package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baji.protocol.model.ProtocolConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class PendingIntentReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PendingIntent pendingIntent;
        h.a aVarO;
        if (context == null || intent == null || (pendingIntent = (PendingIntent) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT")) == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
        android.bluetooth.le.ScanSettings scanSettings = (android.bluetooth.le.ScanSettings) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
        if (parcelableArrayListExtra == null || scanSettings == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_BATCHING", true);
        boolean booleanExtra2 = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_FILTERING", true);
        boolean booleanExtra3 = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_CALLBACK_TYPES", true);
        long longExtra = intent.getLongExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_LOST_TIMEOUT", ProtocolConstants.CONNECTION_TIMEOUT_MS);
        long longExtra2 = intent.getLongExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_LOST_INTERVAL", ProtocolConstants.CONNECTION_TIMEOUT_MS);
        int intExtra = intent.getIntExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_MODE", 1);
        int intExtra2 = intent.getIntExtra("no.nordicsemi.android.support.v18.EXTRA_NUM_OF_MATCHES", 3);
        b bVarA = b.a();
        h hVar = (h) bVarA;
        ArrayList arrayListM = hVar.m(parcelableArrayListExtra);
        ScanSettings scanSettingsN = hVar.n(scanSettings, booleanExtra, booleanExtra2, booleanExtra3, longExtra, longExtra2, intExtra, intExtra2);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean zIsOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
        boolean zIsOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
        synchronized (bVarA) {
            try {
                try {
                    aVarO = hVar.o(pendingIntent);
                    if (aVarO == null) {
                        h.a aVar = new h.a(zIsOffloadedScanBatchingSupported, zIsOffloadedFilteringSupported, arrayListM, scanSettingsN, new l(pendingIntent, scanSettingsN));
                        hVar.k(pendingIntent, aVar);
                        aVarO = aVar;
                    }
                } catch (IllegalStateException unused) {
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVarO.n.a(context);
        ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT");
        if (parcelableArrayListExtra2 != null) {
            ArrayList arrayListG = hVar.g(parcelableArrayListExtra2);
            if (scanSettingsN.i() > 0) {
                aVarO.h(arrayListG);
            } else if (!arrayListG.isEmpty()) {
                aVarO.g(intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1), (ScanResult) arrayListG.get(0));
            }
        } else {
            int intExtra3 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", 0);
            if (intExtra3 != 0) {
                aVarO.f(intExtra3);
            }
        }
        aVarO.n.a(null);
    }
}
