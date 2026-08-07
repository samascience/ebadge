package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import defpackage.vs3;

/* JADX INFO: loaded from: classes.dex */
final class b0 extends vs3 {
    private final /* synthetic */ v a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b0(v vVar, Looper looper) {
        super(looper);
        this.a = vVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.a.A();
            return;
        }
        if (i == 2) {
            this.a.u();
            return;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Unknown message id: ");
        sb.append(i);
        Log.w("GoogleApiClientImpl", sb.toString());
    }
}
