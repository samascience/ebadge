package defpackage;

import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class mp0 implements er2 {
    private final er2 a;

    public mp0(er2 er2Var) {
        p31.f(er2Var, "delegate");
        this.a = er2Var;
    }

    @Override // defpackage.er2
    public void b0(fo foVar, long j) {
        p31.f(foVar, SocialConstants.PARAM_SOURCE);
        this.a.b0(foVar, j);
    }

    @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // defpackage.er2, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // defpackage.er2
    public h33 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.a + ')';
    }
}
