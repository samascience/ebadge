package com.baidu.location.d;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.f;
import defpackage.ar3;
import defpackage.dq3;
import defpackage.fq3;
import defpackage.jq3;
import defpackage.mp3;
import defpackage.p91;
import defpackage.qq3;
import defpackage.r91;
import defpackage.ro3;
import defpackage.so3;
import defpackage.to3;
import defpackage.vq3;
import defpackage.xq3;
import defpackage.zm3;
import defpackage.zq3;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class a extends Service implements r91 {
    static HandlerC0053a g;
    private static long h;
    public static long i;
    Messenger a = null;
    private Looper b = null;
    private HandlerThread c = null;
    private boolean d = true;
    private int e = 0;
    private boolean f = true;

    /* JADX INFO: renamed from: com.baidu.location.d.a$a, reason: collision with other inner class name */
    public static class HandlerC0053a extends Handler {
        private final WeakReference a;

        public HandlerC0053a(Looper looper, a aVar) {
            super(looper);
            this.a = new WeakReference(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) this.a.get();
            if (aVar == null) {
                return;
            }
            if (f.e) {
                int i = message.what;
                if (i == 11) {
                    aVar.e(message);
                } else if (i == 12) {
                    aVar.i(message);
                } else if (i == 15) {
                    aVar.l(message);
                } else if (i == 22) {
                    qq3.s().m(message);
                } else if (i == 41) {
                    qq3.s().H();
                } else if (i == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i == 406) {
                    dq3.c().m();
                } else if (i == 705) {
                    ro3.b().h(message.getData().getBoolean("foreground"));
                }
            }
            if (message.what == 1) {
                aVar.h();
            }
            if (message.what == 0) {
                aVar.d();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        zm3.b().c(f.b());
        to3.a();
        try {
            ar3.b().h();
        } catch (Exception unused) {
        }
        dq3.c().h();
        mp3.f().B();
        so3.h().o();
        qq3.s().v();
        jq3.c().k();
        this.e = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        ro3.b().d(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        mp3.f().X();
        jq3.c().l();
        ar3.b().i();
        so3.h().q();
        qq3.s().y();
        dq3.c().j();
        if (this.f) {
            zq3.p();
        }
        ro3.b().i();
        try {
            xq3.a().d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.e = 4;
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.d) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Message message) {
        ro3.b().j(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Message message) {
        ro3.b().n(message);
    }

    @Override // defpackage.r91
    public void a(Context context) {
        p91.w(f.b()).z(true);
        try {
            fq3.J = context.getPackageName();
        } catch (Exception unused) {
        }
        h = System.currentTimeMillis();
        HandlerThread handlerThreadA = vq3.a();
        this.c = handlerThreadA;
        if (handlerThreadA != null) {
            this.b = handlerThreadA.getLooper();
        }
        g = this.b == null ? new HandlerC0053a(Looper.getMainLooper(), this) : new HandlerC0053a(this.b, this);
        i = System.currentTimeMillis();
        this.a = new Messenger(g);
        g.sendEmptyMessage(0);
        this.e = 1;
        Log.d("baidu_location_service", "baidu location service start 1229 version ...20211229_1650..." + Process.myPid());
    }

    @Override // defpackage.r91
    public double b() {
        return 9.293000221252441d;
    }

    @Override // android.app.Service, defpackage.r91
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            to3.i = extras.getString("key");
            to3.h = extras.getString("sign");
            this.d = extras.getBoolean("kill_process");
            extras.getBoolean("cache_exception");
        }
        return this.a.getBinder();
    }

    @Override // android.app.Service, defpackage.r91
    public void onDestroy() {
        try {
            g.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.f = false;
            h();
            Process.killProcess(Process.myPid());
        }
        this.e = 3;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this, new WeakReference(this)), 1000L);
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    @Override // android.app.Service, defpackage.r91
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }

    @Override // android.app.Service, defpackage.r91
    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }
}
