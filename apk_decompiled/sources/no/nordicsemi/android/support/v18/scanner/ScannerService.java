package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import defpackage.ek2;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ScannerService extends Service {
    private final Object a = new Object();
    private HashMap b;
    private Handler c;

    private void a(List list, ScanSettings scanSettings, PendingIntent pendingIntent, int i) {
        l lVar = new l(pendingIntent, scanSettings, this);
        synchronized (this.a) {
            this.b.put(Integer.valueOf(i), lVar);
        }
        try {
            b.a().c(list, scanSettings, lVar, this.c);
        } catch (Exception e) {
            Log.w("ScannerService", "Starting scanning failed", e);
        }
    }

    private void b(int i) {
        ek2 ek2Var;
        boolean zIsEmpty;
        synchronized (this.a) {
            ek2Var = (ek2) this.b.remove(Integer.valueOf(i));
            zIsEmpty = this.b.isEmpty();
        }
        if (ek2Var == null) {
            return;
        }
        try {
            b.a().d(ek2Var);
        } catch (Exception e) {
            Log.w("ScannerService", "Stopping scanning failed", e);
        }
        if (zIsEmpty) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new HashMap();
        this.c = new Handler();
    }

    @Override // android.app.Service
    public void onDestroy() {
        b bVarA = b.a();
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            try {
                bVarA.d((ek2) it.next());
            } catch (Exception unused) {
            }
        }
        this.b.clear();
        this.b = null;
        this.c = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        boolean zContainsKey;
        boolean zIsEmpty;
        if (intent != null) {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT");
            int intExtra = intent.getIntExtra("no.nordicsemi.android.support.v18.REQUEST_CODE", 0);
            boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_START", false);
            if (pendingIntent == null) {
                synchronized (this.a) {
                    zIsEmpty = this.b.isEmpty();
                }
                if (zIsEmpty) {
                    stopSelf();
                }
                return 2;
            }
            synchronized (this.a) {
                zContainsKey = this.b.containsKey(Integer.valueOf(intExtra));
            }
            if (booleanExtra && !zContainsKey) {
                List parcelableArrayListExtra = intent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
                ScanSettings scanSettingsA = (ScanSettings) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
                if (parcelableArrayListExtra == null) {
                    parcelableArrayListExtra = Collections.emptyList();
                }
                if (scanSettingsA == null) {
                    scanSettingsA = new ScanSettings.b().a();
                }
                a(parcelableArrayListExtra, scanSettingsA, pendingIntent, intExtra);
            } else if (!booleanExtra && zContainsKey) {
                b(intExtra);
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }
}
