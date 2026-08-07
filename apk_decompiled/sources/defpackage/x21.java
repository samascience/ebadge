package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
class x21 implements ks2 {
    private final InputStream a;
    private final h33 b;

    public x21(InputStream inputStream, h33 h33Var) {
        p31.f(inputStream, "input");
        p31.f(h33Var, "timeout");
        this.a = inputStream;
        this.b = h33Var;
    }

    @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // defpackage.ks2
    public long read(fo foVar, long j) throws IOException {
        p31.f(foVar, "sink");
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        try {
            this.b.f();
            im2 im2VarL0 = foVar.L0(1);
            int i = this.a.read(im2VarL0.a, im2VarL0.c, (int) Math.min(j, 8192 - im2VarL0.c));
            if (i != -1) {
                im2VarL0.c += i;
                long j2 = i;
                foVar.I0(foVar.size() + j2);
                return j2;
            }
            if (im2VarL0.b != im2VarL0.c) {
                return -1L;
            }
            foVar.a = im2VarL0.b();
            jm2.b(im2VarL0);
            return -1L;
        } catch (AssertionError e) {
            if (hu1.c(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // defpackage.ks2
    public h33 timeout() {
        return this.b;
    }

    public String toString() {
        return "source(" + this.a + ')';
    }
}
