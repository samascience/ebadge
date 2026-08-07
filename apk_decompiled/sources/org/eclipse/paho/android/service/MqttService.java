package org.eclipse.paho.android.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import defpackage.e43;
import defpackage.fl1;
import defpackage.oc1;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"Registered"})
public class MqttService extends Service implements fl1 {
    private String a;
    org.eclipse.paho.android.service.b c;
    private b d;
    private c f;
    private boolean b = false;
    private volatile boolean e = true;
    private Map g = new ConcurrentHashMap();

    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MqttService.this.b("MqttService", "Internal network status receive.");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) MqttService.this.getSystemService("power")).newWakeLock(1, "MQTT");
            wakeLockNewWakeLock.acquire();
            MqttService.this.b("MqttService", "Reconnect for Network recovery.");
            if (MqttService.this.g()) {
                MqttService.this.b("MqttService", "Online,reconnect.");
                MqttService.this.i();
            } else {
                MqttService.this.h();
            }
            wakeLockNewWakeLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Iterator it = this.g.values().iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    private void j() {
        if (this.d == null) {
            b bVar = new b();
            this.d = bVar;
            registerReceiver(bVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k(String str, String str2, String str3) {
        if (this.a == null || !this.b) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("MqttService.callbackAction", "trace");
        bundle.putString("MqttService.traceSeverity", str);
        bundle.putString("MqttService.traceTag", str2);
        bundle.putString("MqttService.errorMessage", str3);
        f(this.a, Status.ERROR, bundle);
    }

    private void l() {
        b bVar = this.d;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.d = null;
        }
    }

    @Override // defpackage.fl1
    public void a(String str, String str2) {
        k("error", str, str2);
    }

    @Override // defpackage.fl1
    public void b(String str, String str2) {
        k("debug", str, str2);
    }

    @Override // defpackage.fl1
    public void c(String str, String str2, Exception exc) {
        if (this.a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("MqttService.callbackAction", "trace");
            bundle.putString("MqttService.traceSeverity", "exception");
            bundle.putString("MqttService.errorMessage", str2);
            bundle.putSerializable("MqttService.exception", exc);
            bundle.putString("MqttService.traceTag", str);
            f(this.a, Status.ERROR, bundle);
        }
    }

    public Status e(String str, String str2) {
        return this.c.a(str, str2) ? Status.OK : Status.ERROR;
    }

    void f(String str, Status status, Bundle bundle) {
        Intent intent = new Intent("MqttService.callbackToActivity.v0");
        if (str != null) {
            intent.putExtra("MqttService.clientHandle", str);
        }
        intent.putExtra("MqttService.callbackStatus", status);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        oc1.b(this).d(intent);
    }

    public boolean g() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && this.e;
    }

    void i() {
        b("MqttService", "Reconnect to server, client size=" + this.g.size());
        Iterator it = this.g.values().iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f.a(intent.getStringExtra("MqttService.activityToken"));
        return this.f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f = new c(this);
        this.c = new org.eclipse.paho.android.service.a(this, this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Iterator it = this.g.values().iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
        if (this.f != null) {
            this.f = null;
        }
        l();
        org.eclipse.paho.android.service.b bVar = this.c;
        if (bVar != null) {
            bVar.close();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        j();
        return 1;
    }
}
