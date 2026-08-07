package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import defpackage.gy0;

/* JADX INFO: loaded from: classes.dex */
public final class s implements ServiceConnection {
    private final int a;
    final /* synthetic */ b b;

    public s(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b bVar = this.b;
        if (iBinder == null) {
            b.W(bVar, 16);
            return;
        }
        synchronized (bVar.n) {
            try {
                b bVar2 = this.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof gy0)) ? new n(iBinder) : (gy0) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b.X(0, null, this.a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.b.n) {
            this.b.o = null;
        }
        Handler handler = this.b.l;
        handler.sendMessage(handler.obtainMessage(6, this.a, 1));
    }
}
