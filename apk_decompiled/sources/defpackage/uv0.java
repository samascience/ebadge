package defpackage;

import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes4.dex */
public final class uv0 implements ks2 {
    private byte a;
    private final fd2 b;
    private final Inflater c;
    private final d21 d;
    private final CRC32 e;

    public uv0(ks2 ks2Var) {
        p31.f(ks2Var, SocialConstants.PARAM_SOURCE);
        fd2 fd2Var = new fd2(ks2Var);
        this.b = fd2Var;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new d21((so) fd2Var, inflater);
        this.e = new CRC32();
    }

    private final void n(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        p31.e(str2, "format(this, *args)");
        throw new IOException(str2);
    }

    private final void u() throws IOException {
        this.b.B0(10L);
        byte bE0 = this.b.b.e0(3L);
        boolean z = ((bE0 >> 1) & 1) == 1;
        if (z) {
            y(this.b.b, 0L, 10L);
        }
        n("ID1ID2", 8075, this.b.readShort());
        this.b.a(8L);
        if (((bE0 >> 2) & 1) == 1) {
            this.b.B0(2L);
            if (z) {
                y(this.b.b, 0L, 2L);
            }
            long jX0 = this.b.b.x0() & 65535;
            this.b.B0(jX0);
            if (z) {
                y(this.b.b, 0L, jX0);
            }
            this.b.a(jX0);
        }
        if (((bE0 >> 3) & 1) == 1) {
            long jN = this.b.n((byte) 0);
            if (jN == -1) {
                throw new EOFException();
            }
            if (z) {
                y(this.b.b, 0L, jN + 1);
            }
            this.b.a(jN + 1);
        }
        if (((bE0 >> 4) & 1) == 1) {
            long jN2 = this.b.n((byte) 0);
            if (jN2 == -1) {
                throw new EOFException();
            }
            if (z) {
                y(this.b.b, 0L, jN2 + 1);
            }
            this.b.a(jN2 + 1);
        }
        if (z) {
            n("FHCRC", this.b.x0(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private final void w() throws IOException {
        n("CRC", this.b.o0(), (int) this.e.getValue());
        n("ISIZE", this.b.o0(), (int) this.c.getBytesWritten());
    }

    private final void y(fo foVar, long j, long j2) {
        im2 im2Var = foVar.a;
        p31.c(im2Var);
        while (true) {
            int i = im2Var.c;
            int i2 = im2Var.b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            im2Var = im2Var.f;
            p31.c(im2Var);
        }
        while (j2 > 0) {
            int i3 = (int) (((long) im2Var.b) + j);
            int iMin = (int) Math.min(im2Var.c - i3, j2);
            this.e.update(im2Var.a, i3, iMin);
            j2 -= (long) iMin;
            im2Var = im2Var.f;
            p31.c(im2Var);
            j = 0;
        }
    }

    @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    @Override // defpackage.ks2
    public long read(fo foVar, long j) throws IOException {
        p31.f(foVar, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        if (this.a == 0) {
            u();
            this.a = (byte) 1;
        }
        if (this.a == 1) {
            long size = foVar.size();
            long j2 = this.d.read(foVar, j);
            if (j2 != -1) {
                y(foVar, size, j2);
                return j2;
            }
            this.a = (byte) 2;
        }
        if (this.a == 2) {
            w();
            this.a = (byte) 3;
            if (!this.b.H()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // defpackage.ks2
    public h33 timeout() {
        return this.b.timeout();
    }
}
