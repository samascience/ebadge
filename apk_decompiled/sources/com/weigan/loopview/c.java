package com.weigan.loopview;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
final class c extends Handler {
    final LoopView a;

    c(LoopView loopView) {
        this.a = loopView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.a.invalidate();
        } else if (i == 2000) {
            this.a.i(LoopView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.a.f();
        }
    }
}
