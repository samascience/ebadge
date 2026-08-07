package defpackage;

import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes4.dex */
public final class d21 implements ks2 {
    private final so a;
    private final Inflater b;
    private int c;
    private boolean d;

    public d21(so soVar, Inflater inflater) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        p31.f(inflater, "inflater");
        this.a = soVar;
        this.b = inflater;
    }

    private final void w() {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.a.a(remaining);
    }

    @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }

    public final long n(fo foVar, long j) throws IOException {
        p31.f(foVar, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        try {
            im2 im2VarL0 = foVar.L0(1);
            int iMin = (int) Math.min(j, 8192 - im2VarL0.c);
            u();
            int iInflate = this.b.inflate(im2VarL0.a, im2VarL0.c, iMin);
            w();
            if (iInflate > 0) {
                im2VarL0.c += iInflate;
                long j2 = iInflate;
                foVar.I0(foVar.size() + j2);
                return j2;
            }
            if (im2VarL0.b == im2VarL0.c) {
                foVar.a = im2VarL0.b();
                jm2.b(im2VarL0);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // defpackage.ks2
    public long read(fo foVar, long j) throws IOException {
        p31.f(foVar, "sink");
        do {
            long jN = n(foVar, j);
            if (jN > 0) {
                return jN;
            }
            if (this.b.finished() || this.b.needsDictionary()) {
                return -1L;
            }
        } while (!this.a.H());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // defpackage.ks2
    public h33 timeout() {
        return this.a.timeout();
    }

    public final boolean u() {
        if (!this.b.needsInput()) {
            return false;
        }
        if (this.a.H()) {
            return true;
        }
        im2 im2Var = this.a.b().a;
        p31.c(im2Var);
        int i = im2Var.c;
        int i2 = im2Var.b;
        int i3 = i - i2;
        this.c = i3;
        this.b.setInput(im2Var.a, i2, i3);
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d21(ks2 ks2Var, Inflater inflater) {
        this(hu1.b(ks2Var), inflater);
        p31.f(ks2Var, SocialConstants.PARAM_SOURCE);
        p31.f(inflater, "inflater");
    }
}
