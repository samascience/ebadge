package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class w70 implements y10 {
    private final Context a;
    final y10.a b;
    boolean c;
    private boolean d;
    private final BroadcastReceiver e = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            w70 w70Var = w70.this;
            boolean z = w70Var.c;
            w70Var.c = w70Var.i(context);
            if (z != w70.this.c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + w70.this.c);
                }
                w70 w70Var2 = w70.this;
                w70Var2.b.a(w70Var2.c);
            }
        }
    }

    w70(Context context, y10.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    private void j() {
        if (this.d) {
            return;
        }
        this.c = i(this.a);
        try {
            this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    private void k() {
        if (this.d) {
            this.a.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    boolean i(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) z42.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // defpackage.bb1
    public void onDestroy() {
    }

    @Override // defpackage.bb1
    public void onStart() {
        j();
    }

    @Override // defpackage.bb1
    public void onStop() {
        k();
    }
}
