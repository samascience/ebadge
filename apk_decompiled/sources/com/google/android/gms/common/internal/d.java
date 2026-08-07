package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a52;
import defpackage.vs3;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Handler.Callback {
    private final a a;
    private final Handler h;
    private final ArrayList b = new ArrayList();
    private final ArrayList c = new ArrayList();
    private final ArrayList d = new ArrayList();
    private volatile boolean e = false;
    private final AtomicInteger f = new AtomicInteger(0);
    private boolean g = false;
    private final Object i = new Object();

    public interface a {
        Bundle d();

        boolean isConnected();
    }

    public d(Looper looper, a aVar) {
        this.a = aVar;
        this.h = new vs3(looper, this);
    }

    public final void a() {
        this.e = false;
        this.f.incrementAndGet();
    }

    public final void b() {
        this.e = true;
    }

    public final void c(ConnectionResult connectionResult) {
        int i = 0;
        a52.j(Looper.myLooper() == this.h.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            try {
                ArrayList arrayList = new ArrayList(this.d);
                int i2 = this.f.get();
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c = (com.google.android.gms.common.api.c.InterfaceC0078c) obj;
                    if (this.e && this.f.get() == i2) {
                        if (this.d.contains(interfaceC0078c)) {
                            interfaceC0078c.d(connectionResult);
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(Bundle bundle) {
        boolean z = true;
        a52.j(Looper.myLooper() == this.h.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.i) {
            try {
                a52.i(!this.g);
                this.h.removeMessages(1);
                this.g = true;
                if (this.c.size() != 0) {
                    z = false;
                }
                a52.i(z);
                ArrayList arrayList = new ArrayList(this.b);
                int i = this.f.get();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    com.google.android.gms.common.api.c.b bVar = (com.google.android.gms.common.api.c.b) obj;
                    if (!this.e || !this.a.isConnected() || this.f.get() != i) {
                        break;
                    } else if (!this.c.contains(bVar)) {
                        bVar.b(bundle);
                    }
                }
                this.c.clear();
                this.g = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(int i) {
        a52.j(Looper.myLooper() == this.h.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            try {
                this.g = true;
                ArrayList arrayList = new ArrayList(this.b);
                int i2 = this.f.get();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    com.google.android.gms.common.api.c.b bVar = (com.google.android.gms.common.api.c.b) obj;
                    if (!this.e || this.f.get() != i2) {
                        break;
                    } else if (this.b.contains(bVar)) {
                        bVar.a(i);
                    }
                }
                this.c.clear();
                this.g = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(com.google.android.gms.common.api.c.b bVar) {
        a52.g(bVar);
        synchronized (this.i) {
            try {
                if (this.b.contains(bVar)) {
                    String strValueOf = String.valueOf(bVar);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 62);
                    sb.append("registerConnectionCallbacks(): listener ");
                    sb.append(strValueOf);
                    sb.append(" is already registered");
                    Log.w("GmsClientEvents", sb.toString());
                } else {
                    this.b.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.a.isConnected()) {
            Handler handler = this.h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void g(com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        a52.g(interfaceC0078c);
        synchronized (this.i) {
            try {
                if (this.d.contains(interfaceC0078c)) {
                    String strValueOf = String.valueOf(interfaceC0078c);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 67);
                    sb.append("registerConnectionFailedListener(): listener ");
                    sb.append(strValueOf);
                    sb.append(" is already registered");
                    Log.w("GmsClientEvents", sb.toString());
                } else {
                    this.d.add(interfaceC0078c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        a52.g(interfaceC0078c);
        synchronized (this.i) {
            try {
                if (!this.d.remove(interfaceC0078c)) {
                    String strValueOf = String.valueOf(interfaceC0078c);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 57);
                    sb.append("unregisterConnectionFailedListener(): listener ");
                    sb.append(strValueOf);
                    sb.append(" not found");
                    Log.w("GmsClientEvents", sb.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i);
            Log.wtf("GmsClientEvents", sb.toString(), new Exception());
            return false;
        }
        com.google.android.gms.common.api.c.b bVar = (com.google.android.gms.common.api.c.b) message.obj;
        synchronized (this.i) {
            try {
                if (this.e && this.a.isConnected() && this.b.contains(bVar)) {
                    bVar.b(this.a.d());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
