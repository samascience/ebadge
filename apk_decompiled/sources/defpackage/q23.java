package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class q23 {
    private final Object a = new Object();
    private final Map b = new ConcurrentHashMap();
    private final ReferenceQueue c = new ReferenceQueue();

    private static final class a {
        static final q23 a = new q23();
    }

    q23() {
    }

    public static q23 a() {
        return a.a;
    }

    private void b() {
        while (true) {
            SoftReference softReference = (SoftReference) this.c.poll();
            if (softReference == null) {
                return;
            } else {
                this.b.remove(softReference);
            }
        }
    }

    public SoftReference c(io ioVar) {
        SoftReference softReference = new SoftReference(ioVar, this.c);
        this.b.put(softReference, Boolean.TRUE);
        b();
        return softReference;
    }
}
