package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import defpackage.hu3;

/* JADX INFO: loaded from: classes.dex */
final class p extends hu3 {
    final /* synthetic */ b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(b bVar, Looper looper) {
        super(looper);
        this.a = bVar;
    }

    private static final void a(Message message) {
        q qVar = (q) message.obj;
        qVar.b();
        qVar.e();
    }

    private static final boolean b(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.a.C.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || ((i == 4 && !this.a.s()) || message.what == 5)) && !this.a.isConnecting()) {
            a(message);
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.a.z = new ConnectionResult(message.arg2);
            if (b.a0(this.a)) {
                b bVar = this.a;
                if (!bVar.A) {
                    bVar.b0(3, null);
                    return;
                }
            }
            b bVar2 = this.a;
            ConnectionResult connectionResult = bVar2.z != null ? bVar2.z : new ConnectionResult(8);
            this.a.p.a(connectionResult);
            this.a.G(connectionResult);
            return;
        }
        if (i2 == 5) {
            b bVar3 = this.a;
            ConnectionResult connectionResult2 = bVar3.z != null ? bVar3.z : new ConnectionResult(8);
            this.a.p.a(connectionResult2);
            this.a.G(connectionResult2);
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.a.p.a(connectionResult3);
            this.a.G(connectionResult3);
            return;
        }
        if (i2 == 6) {
            this.a.b0(5, null);
            b bVar4 = this.a;
            if (bVar4.u != null) {
                bVar4.u.a(message.arg2);
            }
            this.a.H(message.arg2);
            b.Z(this.a, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.a.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((q) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
