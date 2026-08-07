package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import defpackage.vs3;

/* JADX INFO: loaded from: classes.dex */
final class f0 extends vs3 {
    private final /* synthetic */ d0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f0(d0 d0Var, Looper looper) {
        super(looper);
        this.a = d0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((e0) message.obj).b(this.a);
        } else {
            if (i == 2) {
                throw ((RuntimeException) message.obj);
            }
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            Log.w("GACStateManager", sb.toString());
        }
    }
}
