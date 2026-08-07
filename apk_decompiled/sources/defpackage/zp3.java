package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class zp3 extends Handler {
    final /* synthetic */ p91 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zp3(p91 p91Var, Looper looper) {
        super(looper);
        this.a = p91Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ym3.b("handleMessage !!");
        q91 q91Var = (q91) p91.h.get(message.getData().getString("listenerKey"));
        ym3.b("handleMessage listener = " + q91Var);
        if (q91Var != null) {
            q91Var.a(message.what, message.obj.toString());
        }
    }
}
