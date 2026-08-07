package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import defpackage.a52;
import defpackage.ou3;
import defpackage.su3;

/* JADX INFO: loaded from: classes.dex */
final class z implements Handler.Callback {
    final /* synthetic */ a0 a;

    /* synthetic */ z(a0 a0Var, su3 su3Var) {
        this.a = a0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.a.f) {
                try {
                    ou3 ou3Var = (ou3) message.obj;
                    y yVar = (y) this.a.f.get(ou3Var);
                    if (yVar != null && yVar.i()) {
                        if (yVar.j()) {
                            yVar.g("GmsClientSupervisor");
                        }
                        this.a.f.remove(ou3Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.a.f) {
            try {
                ou3 ou3Var2 = (ou3) message.obj;
                y yVar2 = (y) this.a.f.get(ou3Var2);
                if (yVar2 != null && yVar2.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(ou3Var2), new Exception());
                    ComponentName componentNameB = yVar2.b();
                    if (componentNameB == null) {
                        componentNameB = ou3Var2.b();
                    }
                    if (componentNameB == null) {
                        String strD = ou3Var2.d();
                        a52.g(strD);
                        componentNameB = new ComponentName(strD, "unknown");
                    }
                    yVar2.onServiceDisconnected(componentNameB);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
