package defpackage;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
final class hy1 implements er2 {
    private final OutputStream a;
    private final h33 b;

    public hy1(OutputStream outputStream, h33 h33Var) {
        p31.f(outputStream, "out");
        p31.f(h33Var, "timeout");
        this.a = outputStream;
        this.b = h33Var;
    }

    @Override // defpackage.er2
    public void b0(fo foVar, long j) throws IOException {
        p31.f(foVar, SocialConstants.PARAM_SOURCE);
        f.b(foVar.size(), 0L, j);
        while (j > 0) {
            this.b.f();
            im2 im2Var = foVar.a;
            p31.c(im2Var);
            int iMin = (int) Math.min(j, im2Var.c - im2Var.b);
            this.a.write(im2Var.a, im2Var.b, iMin);
            im2Var.b += iMin;
            long j2 = iMin;
            j -= j2;
            foVar.I0(foVar.size() - j2);
            if (im2Var.b == im2Var.c) {
                foVar.a = im2Var.b();
                jm2.b(im2Var);
            }
        }
    }

    @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // defpackage.er2, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    @Override // defpackage.er2
    public h33 timeout() {
        return this.b;
    }

    public String toString() {
        return "sink(" + this.a + ')';
    }
}
