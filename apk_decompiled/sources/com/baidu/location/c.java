package com.baidu.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.tencent.connect.common.Constants;
import defpackage.an3;
import defpackage.ce;
import defpackage.dp3;
import defpackage.e43;
import defpackage.fq3;
import defpackage.p91;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c implements dp3.b {
    private static boolean G = false;
    private boolean A;
    private dp3 B;
    private boolean C;
    private boolean D;
    private boolean E;
    private ServiceConnection F;
    private LocationClientOption c;
    private LocationClientOption d;
    private Context f;
    private a h;
    private final Messenger i;
    private Boolean x;
    private Boolean y;
    private Boolean z;
    private long a = 0;
    private String b = null;
    private boolean e = false;
    private Messenger g = null;
    private ArrayList j = null;
    private ArrayList k = null;
    private BDLocation l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private b p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f215q = false;
    private final Object r = new Object();
    private long s = 0;
    private long t = 0;
    private String u = null;
    private boolean v = false;
    private boolean w = true;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends Handler {
        private final WeakReference a;

        a(Looper looper, c cVar) {
            super(looper);
            this.a = new WeakReference(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = (c) this.a.get();
            if (cVar == null) {
                return;
            }
            int i = message.what;
            boolean z = true;
            if (i == 21) {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                if (!cVar.D && cVar.C && bDLocation.g() == 66) {
                    return;
                }
                if (!cVar.D && cVar.C) {
                    cVar.D = true;
                    return;
                }
                if (!cVar.D) {
                    cVar.D = true;
                }
                cVar.j(message, 21);
                return;
            }
            try {
                if (i == 303) {
                    Bundle data2 = message.getData();
                    int i2 = data2.getInt("loctype");
                    int i3 = data2.getInt("diagtype");
                    byte[] byteArray = data2.getByteArray("diagmessage");
                    if (i2 <= 0 || i3 <= 0 || byteArray == null || cVar.k == null) {
                        return;
                    }
                    Iterator it = cVar.k.iterator();
                    while (it.hasNext()) {
                        ((ce) it.next()).b(i2, i3, new String(byteArray, Constants.ENC_UTF_8));
                    }
                    return;
                }
                if (i == 406) {
                    Bundle data3 = message.getData();
                    byte[] byteArray2 = data3.getByteArray("mac");
                    String str = byteArray2 != null ? new String(byteArray2, Constants.ENC_UTF_8) : null;
                    int i4 = data3.getInt("hotspot", -1);
                    if (cVar.k != null) {
                        Iterator it2 = cVar.k.iterator();
                        while (it2.hasNext()) {
                            ((ce) it2.next()).a(str, i4);
                        }
                        return;
                    }
                    return;
                }
                if (i == 701) {
                    cVar.k((BDLocation) message.obj);
                    return;
                }
                if (i == 1300) {
                    cVar.y(message);
                    return;
                }
                if (i == 1400) {
                    cVar.D(message);
                    return;
                }
                if (i != 54) {
                    z = false;
                    if (i != 55) {
                        if (i == 703) {
                            Bundle data4 = message.getData();
                            int i5 = data4.getInt("id", 0);
                            if (i5 > 0) {
                                cVar.h(i5, (Notification) data4.getParcelable("notification"));
                                return;
                            }
                            return;
                        }
                        if (i == 704) {
                            cVar.p(message.getData().getBoolean("removenotify"));
                            return;
                        }
                        switch (i) {
                            case 1:
                                cVar.f();
                                break;
                            case 2:
                                cVar.r();
                                break;
                            case 3:
                                cVar.i(message);
                                break;
                            case 4:
                                cVar.H();
                                break;
                            case 5:
                                cVar.s(message);
                                break;
                            case 6:
                                cVar.I(message);
                                break;
                            default:
                                super.handleMessage(message);
                                break;
                        }
                        return;
                    }
                    if (!cVar.c.h) {
                        return;
                    }
                } else if (!cVar.c.h) {
                    return;
                }
                cVar.f215q = z;
            } catch (Exception unused) {
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this.r) {
                try {
                    c.this.o = false;
                    if (c.this.g != null && c.this.i != null) {
                        if (c.this.j == null || c.this.j.size() < 1) {
                            if (c.this.k != null) {
                                if (c.this.k.size() < 1) {
                                }
                            }
                            return;
                        }
                        if (!c.this.n) {
                            c.this.h.obtainMessage(4).sendToTarget();
                            return;
                        }
                        if (c.this.p == null) {
                            c cVar = c.this;
                            cVar.p = cVar.new b();
                        }
                        c.this.h.postDelayed(c.this.p, c.this.c.d);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* synthetic */ b(c cVar, g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.baidu.location.c$c, reason: collision with other inner class name */
    private class C0052c extends Thread {
        private C0052c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (c.this.z.booleanValue()) {
                    if (c.this.B == null) {
                        c.this.B = new dp3(c.this.f, c.this.d, c.this, null);
                    }
                    if (c.this.d.D == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                        c.this.B.t();
                        c.this.B.u();
                    }
                }
                c.this.h.obtainMessage(1).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* synthetic */ C0052c(c cVar, g gVar) {
            this();
        }
    }

    public c(Context context) throws Exception {
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.f = null;
        Boolean bool = Boolean.FALSE;
        this.x = bool;
        this.y = bool;
        this.z = Boolean.TRUE;
        this.B = null;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = new g(this);
        x();
        this.f = context;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle B() {
        if (this.c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.f);
        bundle.putString("coorType", this.c.a);
        bundle.putString("addrType", this.c.b);
        bundle.putBoolean("openGPS", this.c.c);
        bundle.putBoolean("location_change_notify", this.c.h);
        bundle.putInt("scanSpan", this.c.d);
        bundle.putBoolean("enableSimulateGps", this.c.j);
        bundle.putInt("timeOut", this.c.e);
        bundle.putInt("priority", this.c.g);
        bundle.putBoolean("map", this.x.booleanValue());
        bundle.putBoolean("import", this.y.booleanValue());
        bundle.putBoolean("needDirect", this.c.n);
        bundle.putBoolean("isneedaptag", this.c.o);
        bundle.putBoolean("isneedpoiregion", this.c.f214q);
        bundle.putBoolean("isneedregular", this.c.r);
        bundle.putBoolean("isneedaptagd", this.c.p);
        bundle.putBoolean("isneedaltitude", this.c.s);
        bundle.putBoolean("isneednewrgc", this.c.t);
        bundle.putInt("autoNotifyMaxInterval", this.c.b());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.f());
        bundle.putInt("autoNotifyMinDistance", this.c.e());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.c());
        bundle.putInt("wifitimeout", this.c.A);
        bundle.putInt("wfnum", an3.a().c);
        bundle.putBoolean("ischeckper", an3.a().b);
        bundle.putFloat("wfsm", (float) an3.a().e);
        bundle.putDouble("gnmcrm", an3.a().h);
        bundle.putInt("gnmcon", an3.a().i);
        bundle.putInt("iupl", an3.a().j);
        bundle.putInt("lpcs", an3.a().g);
        bundle.putInt("hpdts", an3.a().f123q);
        bundle.putInt("oldts", an3.a().r);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        ce ceVar = (ce) obj;
        ArrayList arrayList = this.k;
        if (arrayList == null || !arrayList.contains(ceVar)) {
            return;
        }
        this.k.remove(ceVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.g == null) {
            return;
        }
        g gVar = null;
        if ((System.currentTimeMillis() - this.s > 3000 || !this.c.h || this.n) && (!this.v || System.currentTimeMillis() - this.t > 20000 || this.n)) {
            Message messageObtain = Message.obtain((Handler) null, 22);
            if (this.n) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isWaitingLocTag", this.n);
                this.n = false;
                messageObtain.setData(bundle);
            }
            try {
                messageObtain.replyTo = this.i;
                this.g.send(messageObtain);
                this.a = System.currentTimeMillis();
                this.m = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized (this.r) {
            try {
                LocationClientOption locationClientOption = this.c;
                if (locationClientOption != null && locationClientOption.d >= 1000 && !this.o) {
                    if (this.p == null) {
                        this.p = new b(this, gVar);
                    }
                    this.h.postDelayed(this.p, this.c.d);
                    this.o = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        e43.a(obj);
        ArrayList arrayList = this.j;
        if (arrayList == null || !arrayList.contains(null)) {
            return;
        }
        this.j.remove((Object) null);
    }

    public static void a0(boolean z) {
        G = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.e) {
            return;
        }
        if (this.z.booleanValue()) {
            boolean zX = fq3.x(this.f);
            if (this.d.h()) {
                zX = true;
            }
            if (zX) {
                try {
                    new h(this).start();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.d.h()) {
            return;
        }
        this.z = Boolean.FALSE;
        this.b = this.f.getPackageName();
        this.u = this.b + "_bdls_v2.9";
        Intent intent = new Intent(this.f, (Class<?>) f.class);
        try {
            intent.putExtra("debug_dev", this.A);
        } catch (Exception unused2) {
        }
        if (this.c == null) {
            this.c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.c.l);
        intent.putExtra("kill_process", this.c.m);
        try {
            this.f.bindService(intent, this.F, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.e = false;
        }
    }

    private void g(int i) {
        if (this.l.c() == null) {
            this.l.x(this.c.a);
        }
        if (this.m || ((this.c.h && this.l.g() == 61) || this.l.g() == 66 || this.l.g() == 67 || this.v || this.l.g() == 161)) {
            ArrayList arrayList = this.j;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    throw null;
                }
            }
            ArrayList arrayList2 = this.k;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((ce) it2.next()).c(this.l);
                }
            }
            if (this.l.g() == 66 || this.l.g() == 67) {
                return;
            }
            this.m = false;
            this.t = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra("notification", notification);
            intent.putExtra("id", i);
            intent.putExtra("command", 1);
            this.f.startForegroundService(intent);
            this.E = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Message message) {
        Object obj;
        this.n = false;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) obj;
        if (this.c.i(locationClientOption)) {
            return;
        }
        g gVar = null;
        if (this.c.d != locationClientOption.d) {
            try {
                synchronized (this.r) {
                    try {
                        if (this.o) {
                            this.h.removeCallbacks(this.p);
                            this.o = false;
                        }
                        if (locationClientOption.d >= 1000 && !this.o) {
                            if (this.p == null) {
                                this.p = new b(this, gVar);
                            }
                            this.h.postDelayed(this.p, locationClientOption.d);
                            this.o = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.c = new LocationClientOption(locationClientOption);
        if (this.g == null) {
            return;
        }
        try {
            Message messageObtain = Message.obtain((Handler) null, 15);
            messageObtain.replyTo = this.i;
            messageObtain.setData(B());
            this.g.send(messageObtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message, int i) {
        if (this.e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.l = bDLocation;
                if (bDLocation.g() == 61) {
                    this.s = System.currentTimeMillis();
                }
                if (this.l.g() == 61 || this.l.g() == 161) {
                    an3.a().c(this.l.f(), this.l.i(), this.l.c());
                }
                g(i);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(BDLocation bDLocation) {
        if (this.w) {
            return;
        }
        this.l = bDLocation;
        if (!this.D && bDLocation.g() == 161) {
            this.C = true;
            an3.a().c(bDLocation.f(), bDLocation.i(), bDLocation.c());
        }
        ArrayList arrayList = this.j;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        ArrayList arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((ce) it2.next()).c(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra("command", 2);
            this.f.startService(intent);
            this.E = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!this.e || this.g == null) {
            return;
        }
        Message messageObtain = Message.obtain((Handler) null, 12);
        messageObtain.replyTo = this.i;
        try {
            this.g.send(messageObtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f.unbindService(this.F);
            if (this.E) {
                try {
                    this.f.stopService(new Intent(this.f, (Class<?>) f.class));
                } catch (Exception unused) {
                }
                this.E = false;
            }
        } catch (Exception unused2) {
        }
        synchronized (this.r) {
            try {
                if (this.o) {
                    this.h.removeCallbacks(this.p);
                    this.o = false;
                }
            } catch (Exception unused3) {
            }
        }
        this.g = null;
        this.n = false;
        this.v = false;
        this.e = false;
        this.C = false;
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        e43.a(obj);
        if (this.j == null) {
            this.j = new ArrayList();
        }
        if (this.j.contains(null)) {
            return;
        }
        this.j.add(null);
    }

    private void x() throws Exception {
        if (G) {
            return;
        }
        Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
        throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        ce ceVar = (ce) obj;
        if (this.k == null) {
            this.k = new ArrayList();
        }
        if (this.k.contains(ceVar)) {
            return;
        }
        this.k.add(ceVar);
    }

    public void Y(ce ceVar) {
        if (ceVar == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.h.obtainMessage(1300);
        messageObtainMessage.obj = ceVar;
        messageObtainMessage.sendToTarget();
    }

    @Override // dp3.b
    public void a(BDLocation bDLocation) {
        if ((!this.D || this.C) && bDLocation != null) {
            Message messageObtainMessage = this.h.obtainMessage(701);
            messageObtainMessage.obj = bDLocation;
            messageObtainMessage.sendToTarget();
        }
    }

    public void b0(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.b() > 0) {
            locationClientOption.r(0);
            locationClientOption.o(true);
        }
        this.d = new LocationClientOption(locationClientOption);
        Message messageObtainMessage = this.h.obtainMessage(3);
        messageObtainMessage.obj = locationClientOption;
        messageObtainMessage.sendToTarget();
    }

    public void c0() {
        this.w = false;
        p91.w(this.f.getApplicationContext()).z(G);
        an3.a().d(this.f, this.d, null);
        new C0052c(this, null).start();
    }

    public void d0() {
        this.w = true;
        this.h.obtainMessage(2).sendToTarget();
        this.B = null;
    }

    public void f0(ce ceVar) {
        if (ceVar == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.h.obtainMessage(1400);
        messageObtainMessage.obj = ceVar;
        messageObtainMessage.sendToTarget();
    }
}
