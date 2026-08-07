package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import defpackage.e43;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
class f extends Handler {
    private final WeakReference a;

    f(b bVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference(bVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        b bVar = (b) this.a.get();
        if (bVar == null) {
            return;
        }
        if (message.what == -1) {
            bVar.invalidateSelf();
            return;
        }
        Iterator it = bVar.h.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }
}
