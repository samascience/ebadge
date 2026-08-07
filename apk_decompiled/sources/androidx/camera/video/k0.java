package androidx.camera.video;

import defpackage.b52;
import defpackage.fy1;
import defpackage.ry;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class k0 implements AutoCloseable {
    private final AtomicBoolean a;
    private final Recorder b;
    private final long c;
    private final fy1 d;
    private final boolean e;
    private final ry f;

    k0(Recorder recorder, long j, fy1 fy1Var, boolean z, boolean z2) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.a = atomicBoolean;
        ry ryVarB = ry.b();
        this.f = ryVarB;
        this.b = recorder;
        this.c = j;
        this.d = fy1Var;
        this.e = z;
        if (z2) {
            atomicBoolean.set(true);
        } else {
            ryVarB.c("stop");
        }
    }

    private void D(int i, Throwable th) {
        this.f.a();
        if (this.a.getAndSet(true)) {
            return;
        }
        this.b.F0(this, i, th);
    }

    static k0 n(r rVar, long j) {
        b52.h(rVar, "The given PendingRecording cannot be null.");
        return new k0(rVar.e(), j, rVar.d(), rVar.g(), true);
    }

    static k0 u(r rVar, long j) {
        b52.h(rVar, "The given PendingRecording cannot be null.");
        return new k0(rVar.e(), j, rVar.d(), rVar.g(), false);
    }

    public void C() {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        D(0, null);
    }

    protected void finalize() throws Throwable {
        try {
            this.f.d();
            D(10, new RuntimeException("Recording stopped due to being garbage collected."));
        } finally {
            super.finalize();
        }
    }

    fy1 w() {
        return this.d;
    }

    long y() {
        return this.c;
    }
}
