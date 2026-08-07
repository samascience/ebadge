package com.baidu.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import defpackage.r91;

/* JADX INFO: loaded from: classes.dex */
public class f extends Service {
    public static Context d = null;
    public static boolean e = false;
    public static boolean f = false;
    r91 a = null;
    r91 b = null;
    r91 c = null;

    public static float a() {
        return 9.293f;
    }

    public static Context b() {
        return d;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        r91 r91Var = this.c;
        if (r91Var != null) {
            return r91Var.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        if (e) {
            Log.d("baidu_location_service", "baidu location service can not start again ...20190306..." + Process.myPid());
            return;
        }
        d = getApplicationContext();
        System.currentTimeMillis();
        this.b = new com.baidu.location.d.a();
        r91 r91Var = this.a;
        if (r91Var == null || r91Var.b() < this.b.b()) {
            this.c = this.b;
            this.a = null;
        } else {
            this.c = this.a;
            this.b = null;
        }
        e = true;
        this.c.a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        e = false;
        r91 r91Var = this.c;
        if (r91Var != null) {
            r91Var.onDestroy();
        }
        if (f) {
            stopForeground(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("command", 0);
                if (intExtra == 1) {
                    startForeground(intent.getIntExtra("id", 0), (Notification) intent.getParcelableExtra("notification"));
                    f = true;
                } else if (intExtra == 2) {
                    stopForeground(intent.getBooleanExtra("removenotify", true));
                    f = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        r91 r91Var = this.c;
        if (r91Var == null) {
            return 2;
        }
        return r91Var.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        r91 r91Var = this.c;
        if (r91Var != null) {
            r91Var.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return false;
    }
}
