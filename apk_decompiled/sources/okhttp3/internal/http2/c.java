package okhttp3.internal.http2;

import com.tencent.open.SocialConstants;
import defpackage.c31;
import defpackage.fo;
import defpackage.ga2;
import defpackage.h33;
import defpackage.hx0;
import defpackage.ks2;
import defpackage.nn2;
import defpackage.p31;
import defpackage.pa3;
import defpackage.so;
import defpackage.y70;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Closeable {
    public static final a e = new a(null);
    private static final Logger f;
    private final so a;
    private final boolean b;
    private final b c;
    private final okhttp3.internal.http2.a.C0154a d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final Logger a() {
            return c.f;
        }

        public final int b(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i3 + " > remaining length " + i);
        }

        private a() {
        }
    }

    public static final class b implements ks2 {
        private final so a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;

        public b(so soVar) {
            p31.f(soVar, SocialConstants.PARAM_SOURCE);
            this.a = soVar;
        }

        private final void u() throws IOException {
            int i = this.d;
            int iJ = pa3.J(this.a);
            this.e = iJ;
            this.b = iJ;
            int iD = pa3.d(this.a.readByte(), 255);
            this.c = pa3.d(this.a.readByte(), 255);
            a aVar = c.e;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(hx0.a.c(true, this.d, this.b, iD, this.c));
            }
            int i2 = this.a.readInt() & Integer.MAX_VALUE;
            this.d = i2;
            if (iD == 9) {
                if (i2 != i) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iD + " != TYPE_CONTINUATION");
            }
        }

        public final void C(int i) {
            this.b = i;
        }

        public final void D(int i) {
            this.f = i;
        }

        public final void V(int i) {
            this.d = i;
        }

        @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final int n() {
            return this.e;
        }

        @Override // defpackage.ks2
        public long read(fo foVar, long j) throws IOException {
            p31.f(foVar, "sink");
            while (true) {
                int i = this.e;
                if (i != 0) {
                    long j2 = this.a.read(foVar, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.e -= (int) j2;
                    return j2;
                }
                this.a.a(this.f);
                this.f = 0;
                if ((this.c & 4) != 0) {
                    return -1L;
                }
                u();
            }
        }

        @Override // defpackage.ks2
        public h33 timeout() {
            return this.a.timeout();
        }

        public final void w(int i) {
            this.c = i;
        }

        public final void y(int i) {
            this.e = i;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.http2.c$c, reason: collision with other inner class name */
    public interface InterfaceC0159c {
        void a();

        void b(boolean z, int i, int i2, List list);

        void c(boolean z, int i, so soVar, int i2);

        void d(int i, long j);

        void e(boolean z, int i, int i2);

        void f(int i, int i2, int i3, boolean z);

        void g(int i, ErrorCode errorCode);

        void h(boolean z, nn2 nn2Var);

        void i(int i, int i2, List list);

        void j(int i, ErrorCode errorCode, ByteString byteString);
    }

    static {
        Logger logger = Logger.getLogger(hx0.class.getName());
        p31.e(logger, "getLogger(Http2::class.java.name)");
        f = logger;
    }

    public c(so soVar, boolean z) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        this.a = soVar;
        this.b = z;
        b bVar = new b(soVar);
        this.c = bVar;
        this.d = new okhttp3.internal.http2.a.C0154a(bVar, 4096, 0, 4, null);
    }

    private final void C(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i4 = this.a.readInt();
        int i5 = this.a.readInt();
        int i6 = i - 8;
        ErrorCode errorCodeA = ErrorCode.Companion.a(i5);
        if (errorCodeA == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i5);
        }
        ByteString byteStringX = ByteString.EMPTY;
        if (i6 > 0) {
            byteStringX = this.a.x(i6);
        }
        interfaceC0159c.j(i4, errorCodeA, byteStringX);
    }

    private final List D(int i, int i2, int i3, int i4) throws IOException {
        this.c.y(i);
        b bVar = this.c;
        bVar.C(bVar.n());
        this.c.D(i2);
        this.c.w(i3);
        this.c.V(i4);
        this.d.k();
        return this.d.e();
    }

    private final void V(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        int iD = (i2 & 8) != 0 ? pa3.d(this.a.readByte(), 255) : 0;
        if ((i2 & 32) != 0) {
            e0(interfaceC0159c, i3);
            i -= 5;
        }
        interfaceC0159c.b(z, i3, -1, D(e.b(i, i2, iD), iD, i2, i3));
    }

    private final void a0(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            throw new IOException("TYPE_PING length != 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        interfaceC0159c.e((i2 & 1) != 0, this.a.readInt(), this.a.readInt());
    }

    private final void e0(InterfaceC0159c interfaceC0159c, int i) {
        int i2 = this.a.readInt();
        interfaceC0159c.f(i, i2 & Integer.MAX_VALUE, pa3.d(this.a.readByte(), 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }

    private final void g0(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i == 5) {
            if (i3 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            e0(interfaceC0159c, i3);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i + " != 5");
        }
    }

    private final void j0(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iD = (i2 & 8) != 0 ? pa3.d(this.a.readByte(), 255) : 0;
        interfaceC0159c.i(i3, this.a.readInt() & Integer.MAX_VALUE, D(e.b(i - 4, i2, iD), iD, i2, i3));
    }

    private final void k0(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i + " != 4");
        }
        if (i3 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i4 = this.a.readInt();
        ErrorCode errorCodeA = ErrorCode.Companion.a(i4);
        if (errorCodeA != null) {
            interfaceC0159c.g(i3, errorCodeA);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i4);
    }

    private final void m0(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i3 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i2 & 1) != 0) {
            if (i != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            interfaceC0159c.a();
            return;
        }
        if (i % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i);
        }
        nn2 nn2Var = new nn2();
        c31 c31VarJ = ga2.j(ga2.k(0, i), 6);
        int iA = c31VarJ.a();
        int iB = c31VarJ.b();
        int iC = c31VarJ.c();
        if ((iC > 0 && iA <= iB) || (iC < 0 && iB <= iA)) {
            while (true) {
                int iE = pa3.e(this.a.readShort(), 65535);
                int i4 = this.a.readInt();
                if (iE != 2) {
                    if (iE == 3) {
                        iE = 4;
                    } else if (iE != 4) {
                        if (iE == 5 && (i4 < 16384 || i4 > 16777215)) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i4);
                        }
                    } else {
                        if (i4 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iE = 7;
                    }
                } else if (i4 != 0 && i4 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                nn2Var.h(iE, i4);
                if (iA != iB) {
                    iA += iC;
                }
            }
        }
        interfaceC0159c.h(false, nn2Var);
    }

    private final void t0(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i);
        }
        long jF = pa3.f(this.a.readInt(), 2147483647L);
        if (jF == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        interfaceC0159c.d(i3, jF);
    }

    private final void y(InterfaceC0159c interfaceC0159c, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iD = (i2 & 8) != 0 ? pa3.d(this.a.readByte(), 255) : 0;
        interfaceC0159c.c(z, i3, this.a, e.b(i, i2, iD));
        this.a.a(iD);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public final boolean u(boolean z, InterfaceC0159c interfaceC0159c) throws IOException {
        p31.f(interfaceC0159c, "handler");
        try {
            this.a.B0(9L);
            int iJ = pa3.J(this.a);
            if (iJ > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iJ);
            }
            int iD = pa3.d(this.a.readByte(), 255);
            int iD2 = pa3.d(this.a.readByte(), 255);
            int i = this.a.readInt() & Integer.MAX_VALUE;
            Logger logger = f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(hx0.a.c(true, i, iJ, iD, iD2));
            }
            if (z && iD != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + hx0.a.b(iD));
            }
            switch (iD) {
                case 0:
                    y(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 1:
                    V(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 2:
                    g0(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 3:
                    k0(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 4:
                    m0(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 5:
                    j0(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 6:
                    a0(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 7:
                    C(interfaceC0159c, iJ, iD2, i);
                    return true;
                case 8:
                    t0(interfaceC0159c, iJ, iD2, i);
                    return true;
                default:
                    this.a.a(iJ);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void w(InterfaceC0159c interfaceC0159c) throws IOException {
        p31.f(interfaceC0159c, "handler");
        if (this.b) {
            if (!u(true, interfaceC0159c)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        so soVar = this.a;
        ByteString byteString = hx0.b;
        ByteString byteStringX = soVar.x(byteString.size());
        Logger logger = f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(pa3.t("<< CONNECTION " + byteStringX.hex(), new Object[0]));
        }
        if (p31.a(byteString, byteStringX)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + byteStringX.utf8());
    }
}
