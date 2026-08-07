package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import defpackage.a52;
import defpackage.hu3;
import defpackage.ou3;
import defpackage.w10;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class a0 extends e {
    private final HashMap f = new HashMap();
    private final Context g;
    private volatile Handler h;
    private final z i;
    private final w10 j;
    private final long k;
    private final long l;

    a0(Context context, Looper looper) {
        z zVar = new z(this, null);
        this.i = zVar;
        this.g = context.getApplicationContext();
        this.h = new hu3(looper, zVar);
        this.j = w10.a();
        this.k = 5000L;
        this.l = 300000L;
    }

    @Override // com.google.android.gms.common.internal.e
    protected final void d(ou3 ou3Var, ServiceConnection serviceConnection, String str) {
        a52.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            try {
                y yVar = (y) this.f.get(ou3Var);
                if (yVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + ou3Var.toString());
                }
                if (!yVar.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + ou3Var.toString());
                }
                yVar.f(serviceConnection, str);
                if (yVar.i()) {
                    this.h.sendMessageDelayed(this.h.obtainMessage(0, ou3Var), this.k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.e
    protected final boolean f(ou3 ou3Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zJ;
        a52.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            try {
                y yVar = (y) this.f.get(ou3Var);
                if (yVar == null) {
                    yVar = new y(this, ou3Var);
                    yVar.d(serviceConnection, serviceConnection, str);
                    yVar.e(str, executor);
                    this.f.put(ou3Var, yVar);
                } else {
                    this.h.removeMessages(0, ou3Var);
                    if (yVar.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + ou3Var.toString());
                    }
                    yVar.d(serviceConnection, serviceConnection, str);
                    int iA = yVar.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(yVar.b(), yVar.c());
                    } else if (iA == 2) {
                        yVar.e(str, executor);
                    }
                }
                zJ = yVar.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zJ;
    }
}
