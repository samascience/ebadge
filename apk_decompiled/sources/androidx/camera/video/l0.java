package androidx.camera.video;

import defpackage.b52;

/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {
    l0() {
    }

    static l0 d(long j, long j2, b bVar) {
        b52.b(j >= 0, "duration must be positive value.");
        b52.b(j2 >= 0, "bytes must be positive value.");
        return new k(j, j2, bVar);
    }

    public abstract b a();

    public abstract long b();

    public abstract long c();
}
