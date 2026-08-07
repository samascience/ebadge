package defpackage;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class x70 implements z10 {
    @Override // defpackage.z10
    public y10 a(Context context, y10.a aVar) {
        boolean z = q30.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new w70(context, aVar) : new es1();
    }
}
