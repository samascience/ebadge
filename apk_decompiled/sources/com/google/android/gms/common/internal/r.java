package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import defpackage.a52;
import defpackage.gt3;

/* JADX INFO: loaded from: classes.dex */
public final class r extends gt3 {
    private b c;
    private final int d;

    public r(b bVar, int i) {
        this.c = bVar;
        this.d = i;
    }

    @Override // defpackage.fy0
    public final void m(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // defpackage.fy0
    public final void t(int i, IBinder iBinder, Bundle bundle) {
        a52.h(this.c, "onPostInitComplete can be called only once per call to getRemoteService");
        this.c.I(i, iBinder, bundle, this.d);
        this.c = null;
    }

    @Override // defpackage.fy0
    public final void v(int i, IBinder iBinder, zzj zzjVar) {
        b bVar = this.c;
        a52.h(bVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        a52.g(zzjVar);
        b.V(bVar, zzjVar);
        t(i, iBinder, zzjVar.a);
    }
}
