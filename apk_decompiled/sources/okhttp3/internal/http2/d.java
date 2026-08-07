package okhttp3.internal.http2;

import defpackage.fo;
import defpackage.hx0;
import defpackage.nn2;
import defpackage.p31;
import defpackage.pa3;
import defpackage.ro;
import defpackage.y70;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Closeable {
    public static final a g = new a(null);
    private static final Logger h = Logger.getLogger(hx0.class.getName());
    private final ro a;
    private final boolean b;
    private final fo c;
    private int d;
    private boolean e;
    private final okhttp3.internal.http2.a.b f;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public d(ro roVar, boolean z) {
        p31.f(roVar, "sink");
        this.a = roVar;
        this.b = z;
        fo foVar = new fo();
        this.c = foVar;
        this.d = 16384;
        this.f = new okhttp3.internal.http2.a.b(0, false, foVar, 3, null);
    }

    private final void t0(int i, long j) {
        while (j > 0) {
            long jMin = Math.min(this.d, j);
            j -= jMin;
            C(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.a.b0(this.c, jMin);
        }
    }

    public final void C(int i, int i2, int i3, int i4) {
        Logger logger = h;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(hx0.a.c(false, i, i2, i3, i4));
        }
        if (i2 > this.d) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.d + ": " + i2).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw new IllegalArgumentException(("reserved bit set: " + i).toString());
        }
        pa3.b0(this.a, i2);
        this.a.I(i3 & 255);
        this.a.I(i4 & 255);
        this.a.F(i & Integer.MAX_VALUE);
    }

    public final synchronized void D(int i, ErrorCode errorCode, byte[] bArr) {
        try {
            p31.f(errorCode, "errorCode");
            p31.f(bArr, "debugData");
            if (this.e) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            C(0, bArr.length + 8, 7, 0);
            this.a.F(i);
            this.a.F(errorCode.getHttpCode());
            if (!(bArr.length == 0)) {
                this.a.u0(bArr);
            }
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void V(boolean z, int i, List list) {
        p31.f(list, "headerBlock");
        if (this.e) {
            throw new IOException("closed");
        }
        this.f.g(list);
        long size = this.c.size();
        long jMin = Math.min(this.d, size);
        int i2 = size == jMin ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        C(i, (int) jMin, 1, i2);
        this.a.b0(this.c, jMin);
        if (size > jMin) {
            t0(i, size - jMin);
        }
    }

    public final int a0() {
        return this.d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.e = true;
        this.a.close();
    }

    public final synchronized void e0(boolean z, int i, int i2) {
        if (this.e) {
            throw new IOException("closed");
        }
        C(0, 8, 6, z ? 1 : 0);
        this.a.F(i);
        this.a.F(i2);
        this.a.flush();
    }

    public final synchronized void flush() {
        if (this.e) {
            throw new IOException("closed");
        }
        this.a.flush();
    }

    public final synchronized void g0(int i, int i2, List list) {
        p31.f(list, "requestHeaders");
        if (this.e) {
            throw new IOException("closed");
        }
        this.f.g(list);
        long size = this.c.size();
        int iMin = (int) Math.min(((long) this.d) - 4, size);
        long j = iMin;
        C(i, iMin + 4, 5, size == j ? 4 : 0);
        this.a.F(i2 & Integer.MAX_VALUE);
        this.a.b0(this.c, j);
        if (size > j) {
            t0(i, size - j);
        }
    }

    public final synchronized void j0(int i, ErrorCode errorCode) {
        p31.f(errorCode, "errorCode");
        if (this.e) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        C(i, 4, 3, 0);
        this.a.F(errorCode.getHttpCode());
        this.a.flush();
    }

    public final synchronized void k0(nn2 nn2Var) {
        int i;
        try {
            p31.f(nn2Var, "settings");
            if (this.e) {
                throw new IOException("closed");
            }
            int i2 = 0;
            C(0, nn2Var.i() * 6, 4, 0);
            while (i2 < 10) {
                if (nn2Var.f(i2)) {
                    if (i2 != 4) {
                        i = i2 != 7 ? i2 : 4;
                    } else {
                        i = 3;
                    }
                    this.a.B(i);
                    this.a.F(nn2Var.a(i2));
                }
                i2++;
            }
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m0(int i, long j) {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        C(i, 4, 8, 0);
        this.a.F((int) j);
        this.a.flush();
    }

    public final synchronized void n(nn2 nn2Var) {
        try {
            p31.f(nn2Var, "peerSettings");
            if (this.e) {
                throw new IOException("closed");
            }
            this.d = nn2Var.e(this.d);
            if (nn2Var.b() != -1) {
                this.f.e(nn2Var.b());
            }
            C(0, 0, 4, 1);
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void u() {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            if (this.b) {
                Logger logger = h;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(pa3.t(">> CONNECTION " + hx0.b.hex(), new Object[0]));
                }
                this.a.v0(hx0.b);
                this.a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void w(boolean z, int i, fo foVar, int i2) {
        if (this.e) {
            throw new IOException("closed");
        }
        y(i, z ? 1 : 0, foVar, i2);
    }

    public final void y(int i, int i2, fo foVar, int i3) {
        C(i, i3, 0, i2);
        if (i3 > 0) {
            ro roVar = this.a;
            p31.c(foVar);
            roVar.b0(foVar, i3);
        }
    }
}
