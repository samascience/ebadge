package androidx.camera.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class d0 extends l {
    private final AtomicBoolean d;

    d0(v vVar) {
        super(vVar);
        this.d = new AtomicBoolean(false);
    }

    @Override // androidx.camera.core.l, androidx.camera.core.v, java.lang.AutoCloseable
    public void close() {
        if (this.d.getAndSet(true)) {
            return;
        }
        super.close();
    }
}
