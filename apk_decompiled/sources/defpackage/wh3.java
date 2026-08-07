package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class wh3 implements Closeable {
    private final boolean a;
    private final ro b;
    private final Random c;
    private final boolean d;
    private final boolean e;
    private final long f;
    private final fo g;
    private final fo h;
    private boolean i;
    private dj1 j;
    private final byte[] k;
    private final fo.a l;

    public wh3(boolean z, ro roVar, Random random, boolean z2, boolean z3, long j) {
        p31.f(roVar, "sink");
        p31.f(random, "random");
        this.a = z;
        this.b = roVar;
        this.c = random;
        this.d = z2;
        this.e = z3;
        this.f = j;
        this.g = new fo();
        this.h = roVar.b();
        this.k = z ? new byte[4] : null;
        this.l = z ? new fo.a() : null;
    }

    private final void u(int i, ByteString byteString) throws IOException {
        if (this.i) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.h.I(i | 128);
        if (this.a) {
            this.h.I(size | 128);
            Random random = this.c;
            byte[] bArr = this.k;
            p31.c(bArr);
            random.nextBytes(bArr);
            this.h.u0(this.k);
            if (size > 0) {
                long size2 = this.h.size();
                this.h.v0(byteString);
                fo foVar = this.h;
                fo.a aVar = this.l;
                p31.c(aVar);
                foVar.y0(aVar);
                this.l.y(size2);
                th3.a.b(this.l, this.k);
                this.l.close();
            }
        } else {
            this.h.I(size);
            this.h.v0(byteString);
        }
        this.b.flush();
    }

    public final void C(ByteString byteString) throws IOException {
        p31.f(byteString, "payload");
        u(10, byteString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        dj1 dj1Var = this.j;
        if (dj1Var != null) {
            dj1Var.close();
        }
    }

    public final void n(int i, ByteString byteString) {
        ByteString byteStringF0 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                th3.a.c(i);
            }
            fo foVar = new fo();
            foVar.B(i);
            if (byteString != null) {
                foVar.v0(byteString);
            }
            byteStringF0 = foVar.f0();
        }
        try {
            u(8, byteStringF0);
        } finally {
            this.i = true;
        }
    }

    public final void w(int i, ByteString byteString) throws IOException {
        p31.f(byteString, "data");
        if (this.i) {
            throw new IOException("closed");
        }
        this.g.v0(byteString);
        int i2 = i | 128;
        if (this.d && byteString.size() >= this.f) {
            dj1 dj1Var = this.j;
            if (dj1Var == null) {
                dj1Var = new dj1(this.e);
                this.j = dj1Var;
            }
            dj1Var.n(this.g);
            i2 = i | 192;
        }
        long size = this.g.size();
        this.h.I(i2);
        int i3 = this.a ? 128 : 0;
        if (size <= 125) {
            this.h.I(i3 | ((int) size));
        } else if (size <= 65535) {
            this.h.I(i3 | 126);
            this.h.B((int) size);
        } else {
            this.h.I(i3 | 127);
            this.h.T0(size);
        }
        if (this.a) {
            Random random = this.c;
            byte[] bArr = this.k;
            p31.c(bArr);
            random.nextBytes(bArr);
            this.h.u0(this.k);
            if (size > 0) {
                fo foVar = this.g;
                fo.a aVar = this.l;
                p31.c(aVar);
                foVar.y0(aVar);
                this.l.y(0L);
                th3.a.b(this.l, this.k);
                this.l.close();
            }
        }
        this.h.b0(this.g, size);
        this.b.A();
    }

    public final void y(ByteString byteString) throws IOException {
        p31.f(byteString, "payload");
        u(9, byteString);
    }
}
