package defpackage;

import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class uh3 implements Closeable {
    private final boolean a;
    private final so b;
    private final a c;
    private final boolean d;
    private final boolean e;
    private boolean f;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private final fo l;
    private final fo m;
    private hj1 n;
    private final byte[] o;
    private final fo.a p;

    public interface a {
        void c(ByteString byteString);

        void d(String str);

        void e(ByteString byteString);

        void g(ByteString byteString);

        void h(int i, String str);
    }

    public uh3(boolean z, so soVar, a aVar, boolean z2, boolean z3) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        p31.f(aVar, "frameCallback");
        this.a = z;
        this.b = soVar;
        this.c = aVar;
        this.d = z2;
        this.e = z3;
        this.l = new fo();
        this.m = new fo();
        this.o = z ? null : new byte[4];
        this.p = z ? null : new fo.a();
    }

    private final void C() throws IOException {
        int i = this.g;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + pa3.Q(i));
        }
        y();
        if (this.k) {
            hj1 hj1Var = this.n;
            if (hj1Var == null) {
                hj1Var = new hj1(this.e);
                this.n = hj1Var;
            }
            hj1Var.n(this.m);
        }
        if (i == 1) {
            this.c.d(this.m.G0());
        } else {
            this.c.c(this.m.f0());
        }
    }

    private final void D() throws IOException {
        while (!this.f) {
            w();
            if (!this.j) {
                return;
            } else {
                u();
            }
        }
    }

    private final void u() throws ProtocolException, EOFException {
        short s;
        String strG0;
        long j = this.h;
        if (j > 0) {
            this.b.X(this.l, j);
            if (!this.a) {
                fo foVar = this.l;
                fo.a aVar = this.p;
                p31.c(aVar);
                foVar.y0(aVar);
                this.p.y(0L);
                th3 th3Var = th3.a;
                fo.a aVar2 = this.p;
                byte[] bArr = this.o;
                p31.c(bArr);
                th3Var.b(aVar2, bArr);
                this.p.close();
            }
        }
        switch (this.g) {
            case 8:
                long size = this.l.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.l.readShort();
                    strG0 = this.l.G0();
                    String strA = th3.a.a(s);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    s = 1005;
                    strG0 = Constants.STR_EMPTY;
                }
                this.c.h(s, strG0);
                this.f = true;
                return;
            case 9:
                this.c.e(this.l.f0());
                return;
            case 10:
                this.c.g(this.l.f0());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + pa3.Q(this.g));
        }
    }

    private final void w() throws IOException {
        boolean z;
        if (this.f) {
            throw new IOException("closed");
        }
        long jH = this.b.timeout().h();
        this.b.timeout().b();
        try {
            int iD = pa3.d(this.b.readByte(), 255);
            this.b.timeout().g(jH, TimeUnit.NANOSECONDS);
            int i = iD & 15;
            this.g = i;
            boolean z2 = (iD & 128) != 0;
            this.i = z2;
            boolean z3 = (iD & 8) != 0;
            this.j = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (iD & 64) != 0;
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.d) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.k = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iD & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iD & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iD2 = pa3.d(this.b.readByte(), 255);
            boolean z5 = (iD2 & 128) != 0;
            if (z5 == this.a) {
                throw new ProtocolException(this.a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = iD2 & 127;
            this.h = j;
            if (j == 126) {
                this.h = pa3.e(this.b.readShort(), 65535);
            } else if (j == 127) {
                long j2 = this.b.readLong();
                this.h = j2;
                if (j2 < 0) {
                    throw new ProtocolException("Frame length 0x" + pa3.R(this.h) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.j && this.h > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                so soVar = this.b;
                byte[] bArr = this.o;
                p31.c(bArr);
                soVar.readFully(bArr);
            }
        } catch (Throwable th) {
            this.b.timeout().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void y() throws IOException {
        while (!this.f) {
            long j = this.h;
            if (j > 0) {
                this.b.X(this.m, j);
                if (!this.a) {
                    fo foVar = this.m;
                    fo.a aVar = this.p;
                    p31.c(aVar);
                    foVar.y0(aVar);
                    this.p.y(this.m.size() - this.h);
                    th3 th3Var = th3.a;
                    fo.a aVar2 = this.p;
                    byte[] bArr = this.o;
                    p31.c(bArr);
                    th3Var.b(aVar2, bArr);
                    this.p.close();
                }
            }
            if (this.i) {
                return;
            }
            D();
            if (this.g != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + pa3.Q(this.g));
            }
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        hj1 hj1Var = this.n;
        if (hj1Var != null) {
            hj1Var.close();
        }
    }

    public final void n() {
        w();
        if (this.j) {
            u();
        } else {
            C();
        }
    }
}
