package defpackage;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes4.dex */
public final class f90 implements er2 {
    private final ro a;
    private final Deflater b;
    private boolean c;

    public f90(ro roVar, Deflater deflater) {
        p31.f(roVar, "sink");
        p31.f(deflater, "deflater");
        this.a = roVar;
        this.b = deflater;
    }

    private final void n(boolean z) throws IOException {
        im2 im2VarL0;
        int iDeflate;
        fo foVarB = this.a.b();
        while (true) {
            im2VarL0 = foVarB.L0(1);
            if (z) {
                try {
                    Deflater deflater = this.b;
                    byte[] bArr = im2VarL0.a;
                    int i = im2VarL0.c;
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                Deflater deflater2 = this.b;
                byte[] bArr2 = im2VarL0.a;
                int i2 = im2VarL0.c;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                im2VarL0.c += iDeflate;
                foVarB.I0(foVarB.size() + ((long) iDeflate));
                this.a.M();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (im2VarL0.b == im2VarL0.c) {
            foVarB.a = im2VarL0.b();
            jm2.b(im2VarL0);
        }
    }

    @Override // defpackage.er2
    public void b0(fo foVar, long j) throws IOException {
        p31.f(foVar, SocialConstants.PARAM_SOURCE);
        f.b(foVar.size(), 0L, j);
        while (j > 0) {
            im2 im2Var = foVar.a;
            p31.c(im2Var);
            int iMin = (int) Math.min(j, im2Var.c - im2Var.b);
            this.b.setInput(im2Var.a, im2Var.b, iMin);
            n(false);
            long j2 = iMin;
            foVar.I0(foVar.size() - j2);
            int i = im2Var.b + iMin;
            im2Var.b = i;
            if (i == im2Var.c) {
                foVar.a = im2Var.b();
                jm2.b(im2Var);
            }
            j -= j2;
        }
    }

    @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        u();
        th = null;
        try {
            this.b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // defpackage.er2, java.io.Flushable
    public void flush() throws IOException {
        n(true);
        this.a.flush();
    }

    @Override // defpackage.er2
    public h33 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.a + ')';
    }

    public final void u() throws IOException {
        this.b.finish();
        n(false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f90(er2 er2Var, Deflater deflater) {
        this(hu1.a(er2Var), deflater);
        p31.f(er2Var, "sink");
        p31.f(deflater, "deflater");
    }
}
