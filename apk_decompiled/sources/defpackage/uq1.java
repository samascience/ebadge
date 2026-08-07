package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
public class uq1 extends m20 {
    static final String j = fd1.f("NetworkStateTracker");
    private final ConnectivityManager g;
    private b h;
    private a i;

    private class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            fd1.c().a(uq1.j, "Network broadcast received", new Throwable[0]);
            uq1 uq1Var = uq1.this;
            uq1Var.d(uq1Var.g());
        }
    }

    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            fd1.c().a(uq1.j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            uq1 uq1Var = uq1.this;
            uq1Var.d(uq1Var.g());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            fd1.c().a(uq1.j, "Network connection lost", new Throwable[0]);
            uq1 uq1Var = uq1.this;
            uq1Var.d(uq1Var.g());
        }
    }

    public uq1(Context context, w03 w03Var) {
        super(context, w03Var);
        this.g = (ConnectivityManager) this.b.getSystemService("connectivity");
        if (j()) {
            this.h = new b();
        } else {
            this.i = new a();
        }
    }

    private static boolean j() {
        return true;
    }

    @Override // defpackage.m20
    public void e() {
        if (!j()) {
            fd1.c().a(j, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        try {
            fd1.c().a(j, "Registering network callback", new Throwable[0]);
            this.g.registerDefaultNetworkCallback(this.h);
        } catch (IllegalArgumentException | SecurityException e) {
            fd1.c().b(j, "Received exception while registering network callback", e);
        }
    }

    @Override // defpackage.m20
    public void f() {
        if (!j()) {
            fd1.c().a(j, "Unregistering broadcast receiver", new Throwable[0]);
            this.b.unregisterReceiver(this.i);
            return;
        }
        try {
            fd1.c().a(j, "Unregistering network callback", new Throwable[0]);
            this.g.unregisterNetworkCallback(this.h);
        } catch (IllegalArgumentException | SecurityException e) {
            fd1.c().b(j, "Received exception while unregistering network callback", e);
        }
    }

    tq1 g() {
        NetworkInfo activeNetworkInfo = this.g.getActiveNetworkInfo();
        boolean z = false;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zI = i();
        boolean zA = x10.a(this.g);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z = true;
        }
        return new tq1(z2, zI, zA, z);
    }

    @Override // defpackage.m20
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public tq1 b() {
        return g();
    }

    boolean i() {
        try {
            NetworkCapabilities networkCapabilities = this.g.getNetworkCapabilities(this.g.getActiveNetwork());
            return networkCapabilities != null && networkCapabilities.hasCapability(16);
        } catch (SecurityException e) {
            fd1.c().b(j, "Unable to validate active network", e);
            return false;
        }
    }
}
