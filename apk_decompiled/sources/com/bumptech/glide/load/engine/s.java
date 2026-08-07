package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import defpackage.qg2;

/* JADX INFO: loaded from: classes.dex */
class s {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((qg2) message.obj).a();
            return true;
        }
    }

    s() {
    }

    synchronized void a(qg2 qg2Var, boolean z) {
        try {
            if (this.a || z) {
                this.b.obtainMessage(1, qg2Var).sendToTarget();
            } else {
                this.a = true;
                qg2Var.a();
                this.a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
