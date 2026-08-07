package defpackage;

import androidx.camera.core.a0;

/* JADX INFO: loaded from: classes.dex */
public final class i33 implements a0 {
    private final long d;
    private final a0 e;

    public i33(long j, a0 a0Var) {
        b52.b(j >= 0, "Timeout must be non-negative.");
        this.d = j;
        this.e = a0Var;
    }

    @Override // androidx.camera.core.a0
    public long b() {
        return this.d;
    }

    @Override // androidx.camera.core.a0
    public a0.c c(a0.b bVar) {
        a0.c cVarC = this.e.c(bVar);
        return (b() <= 0 || bVar.b() < b() - cVarC.b()) ? cVarC : a0.c.d;
    }
}
