package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class np0 implements ks2 {
    private final ks2 delegate;

    public np0(ks2 ks2Var) {
        p31.f(ks2Var, "delegate");
        this.delegate = ks2Var;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final ks2 m340deprecated_delegate() {
        return this.delegate;
    }

    @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final ks2 delegate() {
        return this.delegate;
    }

    @Override // defpackage.ks2
    public long read(fo foVar, long j) {
        p31.f(foVar, "sink");
        return this.delegate.read(foVar, j);
    }

    @Override // defpackage.ks2
    public h33 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
