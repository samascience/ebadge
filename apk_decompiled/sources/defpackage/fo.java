package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baji.protocol.model.ProtocolConstants;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.d;
import okio.ByteString;
import okio.SegmentedByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class fo implements so, ro, Cloneable, ByteChannel {
    public im2 a;
    private long b;

    public static final class a implements Closeable {
        public fo a;
        public boolean b;
        private im2 c;
        public byte[] e;
        public long d = -1;
        public int f = -1;
        public int g = -1;

        public final void C(im2 im2Var) {
            this.c = im2Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.a = null;
            C(null);
            this.d = -1L;
            this.e = null;
            this.f = -1;
            this.g = -1;
        }

        public final im2 n() {
            return this.c;
        }

        public final int u() {
            long j = this.d;
            fo foVar = this.a;
            p31.c(foVar);
            if (j == foVar.size()) {
                throw new IllegalStateException("no more bytes");
            }
            long j2 = this.d;
            return y(j2 == -1 ? 0L : j2 + ((long) (this.g - this.f)));
        }

        public final long w(long j) {
            fo foVar = this.a;
            if (foVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long size = foVar.size();
            if (j <= size) {
                if (j < 0) {
                    throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                }
                long j2 = size - j;
                while (j2 > 0) {
                    im2 im2Var = foVar.a;
                    p31.c(im2Var);
                    im2 im2Var2 = im2Var.g;
                    p31.c(im2Var2);
                    int i = im2Var2.c;
                    long j3 = i - im2Var2.b;
                    if (j3 > j2) {
                        im2Var2.c = i - ((int) j2);
                        break;
                    }
                    foVar.a = im2Var2.b();
                    jm2.b(im2Var2);
                    j2 -= j3;
                }
                C(null);
                this.d = j;
                this.e = null;
                this.f = -1;
                this.g = -1;
            } else if (j > size) {
                long j4 = j - size;
                boolean z = true;
                while (j4 > 0) {
                    im2 im2VarL0 = foVar.L0(1);
                    int iMin = (int) Math.min(j4, 8192 - im2VarL0.c);
                    im2VarL0.c += iMin;
                    j4 -= (long) iMin;
                    if (z) {
                        C(im2VarL0);
                        this.d = size;
                        this.e = im2VarL0.a;
                        int i2 = im2VarL0.c;
                        this.f = i2 - iMin;
                        this.g = i2;
                        z = false;
                    }
                }
            }
            foVar.I0(j);
            return size;
        }

        public final int y(long j) {
            im2 im2VarC;
            fo foVar = this.a;
            if (foVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j < -1 || j > foVar.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + foVar.size());
            }
            if (j == -1 || j == foVar.size()) {
                C(null);
                this.d = j;
                this.e = null;
                this.f = -1;
                this.g = -1;
                return -1;
            }
            long size = foVar.size();
            im2 im2VarN = foVar.a;
            long j2 = 0;
            if (n() != null) {
                long j3 = this.d;
                int i = this.f;
                im2 im2VarN2 = n();
                p31.c(im2VarN2);
                long j4 = j3 - ((long) (i - im2VarN2.b));
                if (j4 > j) {
                    im2VarC = im2VarN;
                    im2VarN = n();
                    size = j4;
                } else {
                    im2VarC = n();
                    j2 = j4;
                }
            } else {
                im2VarC = im2VarN;
            }
            if (size - j > j - j2) {
                while (true) {
                    p31.c(im2VarC);
                    int i2 = im2VarC.c;
                    int i3 = im2VarC.b;
                    if (j < ((long) (i2 - i3)) + j2) {
                        break;
                    }
                    j2 += (long) (i2 - i3);
                    im2VarC = im2VarC.f;
                }
            } else {
                while (size > j) {
                    p31.c(im2VarN);
                    im2VarN = im2VarN.g;
                    p31.c(im2VarN);
                    size -= (long) (im2VarN.c - im2VarN.b);
                }
                j2 = size;
                im2VarC = im2VarN;
            }
            if (this.b) {
                p31.c(im2VarC);
                if (im2VarC.d) {
                    im2 im2VarF = im2VarC.f();
                    if (foVar.a == im2VarC) {
                        foVar.a = im2VarF;
                    }
                    im2VarC = im2VarC.c(im2VarF);
                    im2 im2Var = im2VarC.g;
                    p31.c(im2Var);
                    im2Var.b();
                }
            }
            C(im2VarC);
            this.d = j;
            p31.c(im2VarC);
            this.e = im2VarC.a;
            int i4 = im2VarC.b + ((int) (j - j2));
            this.f = i4;
            int i5 = im2VarC.c;
            this.g = i5;
            return i5 - i4;
        }
    }

    public static final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return fo.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            fo.this.I(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            p31.f(bArr, "data");
            fo.this.Z(bArr, i, i2);
        }
    }

    public static /* synthetic */ a A0(fo foVar, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = f.d();
        }
        return foVar.y0(aVar);
    }

    @Override // defpackage.so
    public void B0(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public final fo C() {
        fo foVar = new fo();
        if (size() != 0) {
            im2 im2Var = this.a;
            p31.c(im2Var);
            im2 im2VarD = im2Var.d();
            foVar.a = im2VarD;
            im2VarD.g = im2VarD;
            im2VarD.f = im2VarD;
            for (im2 im2Var2 = im2Var.f; im2Var2 != im2Var; im2Var2 = im2Var2.f) {
                im2 im2Var3 = im2VarD.g;
                p31.c(im2Var3);
                p31.c(im2Var2);
                im2Var3.c(im2Var2.d());
            }
            foVar.I0(size());
        }
        return foVar;
    }

    public final fo D(fo foVar, long j, long j2) {
        p31.f(foVar, "out");
        f.b(size(), j, j2);
        if (j2 != 0) {
            foVar.I0(foVar.size() + j2);
            im2 im2Var = this.a;
            while (true) {
                p31.c(im2Var);
                int i = im2Var.c;
                int i2 = im2Var.b;
                if (j < i - i2) {
                    break;
                }
                j -= (long) (i - i2);
                im2Var = im2Var.f;
            }
            while (j2 > 0) {
                p31.c(im2Var);
                im2 im2VarD = im2Var.d();
                int i3 = im2VarD.b + ((int) j);
                im2VarD.b = i3;
                im2VarD.c = Math.min(i3 + ((int) j2), im2VarD.c);
                im2 im2Var2 = foVar.a;
                if (im2Var2 == null) {
                    im2VarD.g = im2VarD;
                    im2VarD.f = im2VarD;
                    foVar.a = im2VarD;
                } else {
                    p31.c(im2Var2);
                    im2 im2Var3 = im2Var2.g;
                    p31.c(im2Var3);
                    im2Var3.c(im2VarD);
                }
                j2 -= (long) (im2VarD.c - im2VarD.b);
                im2Var = im2Var.f;
                j = 0;
            }
        }
        return this;
    }

    @Override // defpackage.so
    public long D0() throws EOFException {
        int i;
        if (size() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            im2 im2Var = this.a;
            p31.c(im2Var);
            byte[] bArr = im2Var.a;
            int i3 = im2Var.b;
            int i4 = im2Var.c;
            while (i3 < i4) {
                byte b2 = bArr[i3];
                if (b2 >= 48 && b2 <= 57) {
                    i = b2 - 48;
                } else if (b2 >= 97 && b2 <= 102) {
                    i = b2 - 87;
                } else {
                    if (b2 < 65 || b2 > 70) {
                        if (i2 != 0) {
                            z = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + f.k(b2));
                    }
                    i = b2 - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new fo().c0(j).I(b2).G0());
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.a = im2Var.b();
                jm2.b(im2Var);
            } else {
                im2Var.b = i3;
            }
            if (z) {
                break;
            }
        } while (this.a != null);
        I0(size() - ((long) i2));
        return j;
    }

    @Override // defpackage.so
    public InputStream E0() {
        return new b();
    }

    public String F0(long j, Charset charset) throws EOFException {
        p31.f(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return Constants.STR_EMPTY;
        }
        im2 im2Var = this.a;
        p31.c(im2Var);
        int i = im2Var.b;
        if (((long) i) + j > im2Var.c) {
            return new String(p0(j), charset);
        }
        int i2 = (int) j;
        String str = new String(im2Var.a, i, i2, charset);
        int i3 = im2Var.b + i2;
        im2Var.b = i3;
        this.b -= j;
        if (i3 == im2Var.c) {
            this.a = im2Var.b();
            jm2.b(im2Var);
        }
        return str;
    }

    @Override // defpackage.so
    public byte[] G() {
        return p0(size());
    }

    public String G0() {
        return F0(this.b, gx.b);
    }

    @Override // defpackage.so
    public boolean H() {
        return this.b == 0;
    }

    public int H0() throws EOFException {
        int i;
        int i2;
        int i3;
        if (size() == 0) {
            throw new EOFException();
        }
        byte bE0 = e0(0L);
        if ((bE0 & 128) == 0) {
            i = bE0 & 127;
            i3 = 0;
            i2 = 1;
        } else if ((bE0 & 224) == 192) {
            i = bE0 & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bE0 & 240) == 224) {
            i = bE0 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bE0 & 248) != 240) {
                a(1L);
                return 65533;
            }
            i = bE0 & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (size() < j) {
            throw new EOFException("size < " + i2 + ": " + size() + " (to read code point prefixed 0x" + f.k(bE0) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bE1 = e0(j2);
            if ((bE1 & 192) != 128) {
                a(j2);
                return 65533;
            }
            i = (i << 6) | (bE1 & 63);
        }
        a(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 > i || i >= 57344) && i >= i3) {
            return i;
        }
        return 65533;
    }

    public final void I0(long j) {
        this.b = j;
    }

    @Override // defpackage.so
    public int J(qx1 qx1Var) throws EOFException {
        p31.f(qx1Var, "options");
        int iE = defpackage.b.e(this, qx1Var, false, 2, null);
        if (iE == -1) {
            return -1;
        }
        a(qx1Var.e()[iE].size());
        return iE;
    }

    public final ByteString J0() {
        if (size() <= 2147483647L) {
            return K0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // defpackage.so
    public long K(ByteString byteString) {
        p31.f(byteString, "targetBytes");
        return j0(byteString, 0L);
    }

    public final ByteString K0(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        f.b(size(), 0L, i);
        im2 im2Var = this.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            p31.c(im2Var);
            int i5 = im2Var.c;
            int i6 = im2Var.b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            im2Var = im2Var.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        im2 im2Var2 = this.a;
        int i7 = 0;
        while (i2 < i) {
            p31.c(im2Var2);
            bArr[i7] = im2Var2.a;
            i2 += im2Var2.c - im2Var2.b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = im2Var2.b;
            im2Var2.d = true;
            i7++;
            im2Var2 = im2Var2.f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // defpackage.ro
    public long L(ks2 ks2Var) {
        p31.f(ks2Var, SocialConstants.PARAM_SOURCE);
        long j = 0;
        while (true) {
            long j2 = ks2Var.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public final im2 L0(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        im2 im2Var = this.a;
        if (im2Var != null) {
            p31.c(im2Var);
            im2 im2Var2 = im2Var.g;
            p31.c(im2Var2);
            return (im2Var2.c + i > 8192 || !im2Var2.e) ? im2Var2.c(jm2.c()) : im2Var2;
        }
        im2 im2VarC = jm2.c();
        this.a = im2VarC;
        im2VarC.g = im2VarC;
        im2VarC.f = im2VarC;
        return im2VarC;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public fo v0(ByteString byteString) {
        p31.f(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public fo u0(byte[] bArr) {
        p31.f(bArr, SocialConstants.PARAM_SOURCE);
        return Z(bArr, 0, bArr.length);
    }

    @Override // defpackage.so
    public String O(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jG0 = g0((byte) 10, 0L, j2);
        if (jG0 != -1) {
            return defpackage.b.c(this, jG0);
        }
        if (j2 < size() && e0(j2 - 1) == 13 && e0(j2) == 10) {
            return defpackage.b.c(this, j2);
        }
        fo foVar = new fo();
        D(foVar, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + foVar.f0().hex() + (char) 8230);
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public fo Z(byte[] bArr, int i, int i2) {
        p31.f(bArr, SocialConstants.PARAM_SOURCE);
        long j = i2;
        f.b(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            im2 im2VarL0 = L0(1);
            int iMin = Math.min(i3 - i, 8192 - im2VarL0.c);
            int i4 = i + iMin;
            d.d(bArr, im2VarL0.a, im2VarL0.c, i, i4);
            im2VarL0.c += iMin;
            i = i4;
        }
        I0(size() + j);
        return this;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public fo I(int i) {
        im2 im2VarL0 = L0(1);
        byte[] bArr = im2VarL0.a;
        int i2 = im2VarL0.c;
        im2VarL0.c = i2 + 1;
        bArr[i2] = (byte) i;
        I0(size() + 1);
        return this;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public fo C0(long j) {
        boolean z;
        if (j == 0) {
            return I(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return S("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < ProtocolConstants.CONNECTION_TIMEOUT_MS) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < 1000000) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < 1000000000 ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        im2 im2VarL0 = L0(i);
        byte[] bArr = im2VarL0.a;
        int i2 = im2VarL0.c + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = defpackage.b.b()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        im2VarL0.c += i;
        I0(size() + ((long) i));
        return this;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public fo c0(long j) {
        if (j == 0) {
            return I(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        im2 im2VarL0 = L0(i);
        byte[] bArr = im2VarL0.a;
        int i2 = im2VarL0.c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = defpackage.b.b()[(int) (15 & j)];
            j >>>= 4;
        }
        im2VarL0.c += i;
        I0(size() + ((long) i));
        return this;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public fo F(int i) {
        im2 im2VarL0 = L0(4);
        byte[] bArr = im2VarL0.a;
        int i2 = im2VarL0.c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        im2VarL0.c = i2 + 4;
        I0(size() + 4);
        return this;
    }

    @Override // defpackage.so
    public long T(er2 er2Var) {
        p31.f(er2Var, "sink");
        long size = size();
        if (size > 0) {
            er2Var.b0(this, size);
        }
        return size;
    }

    public fo T0(long j) {
        im2 im2VarL0 = L0(8);
        byte[] bArr = im2VarL0.a;
        int i = im2VarL0.c;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        im2VarL0.c = i + 8;
        I0(size() + 8);
        return this;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public fo B(int i) {
        im2 im2VarL0 = L0(2);
        byte[] bArr = im2VarL0.a;
        int i2 = im2VarL0.c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        im2VarL0.c = i2 + 2;
        I0(size() + 2);
        return this;
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public fo A() {
        return this;
    }

    public fo V0(String str, int i, int i2, Charset charset) {
        p31.f(str, "string");
        p31.f(charset, "charset");
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        if (p31.a(charset, gx.b)) {
            return Y0(str, i, i2);
        }
        String strSubstring = str.substring(i, i2);
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        p31.e(bytes, "this as java.lang.String).getBytes(charset)");
        return Z(bytes, 0, bytes.length);
    }

    public fo W0(String str, Charset charset) {
        p31.f(str, "string");
        p31.f(charset, "charset");
        return V0(str, 0, str.length(), charset);
    }

    @Override // defpackage.so
    public void X(fo foVar, long j) throws EOFException {
        p31.f(foVar, "sink");
        if (size() >= j) {
            foVar.b0(this, j);
        } else {
            foVar.b0(this, size());
            throw new EOFException();
        }
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public fo S(String str) {
        p31.f(str, "string");
        return Y0(str, 0, str.length());
    }

    @Override // defpackage.so
    public String Y(Charset charset) {
        p31.f(charset, "charset");
        return F0(this.b, charset);
    }

    public fo Y0(String str, int i, int i2) {
        char cCharAt;
        p31.f(str, "string");
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                im2 im2VarL0 = L0(1);
                byte[] bArr = im2VarL0.a;
                int i3 = im2VarL0.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = im2VarL0.c;
                int i6 = (i3 + i) - i5;
                im2VarL0.c = i5 + i6;
                I0(size() + ((long) i6));
            } else {
                if (cCharAt2 < 2048) {
                    im2 im2VarL1 = L0(2);
                    byte[] bArr2 = im2VarL1.a;
                    int i7 = im2VarL1.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    im2VarL1.c = i7 + 2;
                    I0(size() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    im2 im2VarL2 = L0(3);
                    byte[] bArr3 = im2VarL2.a;
                    int i8 = im2VarL2.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    im2VarL2.c = i8 + 3;
                    I0(size() + 3);
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        I(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        im2 im2VarL3 = L0(4);
                        byte[] bArr4 = im2VarL3.a;
                        int i11 = im2VarL3.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        im2VarL3.c = i11 + 4;
                        I0(size() + 4);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public fo Z0(int i) {
        if (i < 128) {
            I(i);
        } else if (i < 2048) {
            im2 im2VarL0 = L0(2);
            byte[] bArr = im2VarL0.a;
            int i2 = im2VarL0.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            im2VarL0.c = i2 + 2;
            I0(size() + 2);
        } else if (55296 <= i && i < 57344) {
            I(63);
        } else if (i < 65536) {
            im2 im2VarL1 = L0(3);
            byte[] bArr2 = im2VarL1.a;
            int i3 = im2VarL1.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            im2VarL1.c = i3 + 3;
            I0(size() + 3);
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + f.l(i));
            }
            im2 im2VarL2 = L0(4);
            byte[] bArr3 = im2VarL2.a;
            int i4 = im2VarL2.c;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            im2VarL2.c = i4 + 4;
            I0(size() + 4);
        }
        return this;
    }

    @Override // defpackage.so
    public void a(long j) throws EOFException {
        while (j > 0) {
            im2 im2Var = this.a;
            if (im2Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, im2Var.c - im2Var.b);
            long j2 = iMin;
            I0(size() - j2);
            j -= j2;
            int i = im2Var.b + iMin;
            im2Var.b = i;
            if (i == im2Var.c) {
                this.a = im2Var.b();
                jm2.b(im2Var);
            }
        }
    }

    @Override // defpackage.ro
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public fo M() {
        return this;
    }

    @Override // defpackage.so
    public fo b() {
        return this;
    }

    @Override // defpackage.er2
    public void b0(fo foVar, long j) {
        im2 im2Var;
        p31.f(foVar, SocialConstants.PARAM_SOURCE);
        if (foVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        f.b(foVar.size(), 0L, j);
        while (j > 0) {
            im2 im2Var2 = foVar.a;
            p31.c(im2Var2);
            int i = im2Var2.c;
            im2 im2Var3 = foVar.a;
            p31.c(im2Var3);
            if (j < i - im2Var3.b) {
                im2 im2Var4 = this.a;
                if (im2Var4 != null) {
                    p31.c(im2Var4);
                    im2Var = im2Var4.g;
                } else {
                    im2Var = null;
                }
                if (im2Var != null && im2Var.e) {
                    if ((((long) im2Var.c) + j) - ((long) (im2Var.d ? 0 : im2Var.b)) <= 8192) {
                        im2 im2Var5 = foVar.a;
                        p31.c(im2Var5);
                        im2Var5.g(im2Var, (int) j);
                        foVar.I0(foVar.size() - j);
                        I0(size() + j);
                        return;
                    }
                }
                im2 im2Var6 = foVar.a;
                p31.c(im2Var6);
                foVar.a = im2Var6.e((int) j);
            }
            im2 im2Var7 = foVar.a;
            p31.c(im2Var7);
            long j2 = im2Var7.c - im2Var7.b;
            foVar.a = im2Var7.b();
            im2 im2Var8 = this.a;
            if (im2Var8 == null) {
                this.a = im2Var7;
                im2Var7.g = im2Var7;
                im2Var7.f = im2Var7;
            } else {
                p31.c(im2Var8);
                im2 im2Var9 = im2Var8.g;
                p31.c(im2Var9);
                im2Var9.c(im2Var7).a();
            }
            foVar.I0(foVar.size() - j2);
            I0(size() + j2);
            j -= j2;
        }
    }

    @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final byte e0(long j) {
        f.b(size(), j, 1L);
        im2 im2Var = this.a;
        if (im2Var == null) {
            p31.c(null);
            throw null;
        }
        if (size() - j < j) {
            long size = size();
            while (size > j) {
                im2Var = im2Var.g;
                p31.c(im2Var);
                size -= (long) (im2Var.c - im2Var.b);
            }
            p31.c(im2Var);
            return im2Var.a[(int) ((((long) im2Var.b) + j) - size)];
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (im2Var.c - im2Var.b)) + j2;
            if (j3 > j) {
                p31.c(im2Var);
                return im2Var.a[(int) ((((long) im2Var.b) + j) - j2)];
            }
            im2Var = im2Var.f;
            p31.c(im2Var);
            j2 = j3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof fo) {
            fo foVar = (fo) obj;
            if (size() == foVar.size()) {
                if (size() == 0) {
                    return true;
                }
                im2 im2Var = this.a;
                p31.c(im2Var);
                im2 im2Var2 = foVar.a;
                p31.c(im2Var2);
                int i = im2Var.b;
                int i2 = im2Var2.b;
                long j = 0;
                while (j < size()) {
                    long jMin = Math.min(im2Var.c - i, im2Var2.c - i2);
                    long j2 = 0;
                    while (j2 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (im2Var.a[i] == im2Var2.a[i2]) {
                            j2++;
                            i = i3;
                            i2 = i4;
                        }
                    }
                    if (i == im2Var.c) {
                        im2Var = im2Var.f;
                        p31.c(im2Var);
                        i = im2Var.b;
                    }
                    if (i2 == im2Var2.c) {
                        im2Var2 = im2Var2.f;
                        p31.c(im2Var2);
                        i2 = im2Var2.b;
                    }
                    j += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.so
    public ByteString f0() {
        return x(size());
    }

    @Override // defpackage.ro, defpackage.er2, java.io.Flushable
    public void flush() {
    }

    public long g0(byte b2, long j, long j2) {
        im2 im2Var;
        int i;
        long size = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > size()) {
            j2 = size();
        }
        if (j == j2 || (im2Var = this.a) == null) {
            return -1L;
        }
        if (size() - j < j) {
            size = size();
            while (size > j) {
                im2Var = im2Var.g;
                p31.c(im2Var);
                size -= (long) (im2Var.c - im2Var.b);
            }
            while (size < j2) {
                byte[] bArr = im2Var.a;
                int iMin = (int) Math.min(im2Var.c, (((long) im2Var.b) + j2) - size);
                i = (int) ((((long) im2Var.b) + j) - size);
                while (i < iMin) {
                    if (bArr[i] != b2) {
                        i++;
                    }
                }
                size += (long) (im2Var.c - im2Var.b);
                im2Var = im2Var.f;
                p31.c(im2Var);
                j = size;
            }
            return -1L;
        }
        while (true) {
            long j3 = ((long) (im2Var.c - im2Var.b)) + size;
            if (j3 > j) {
                break;
            }
            im2Var = im2Var.f;
            p31.c(im2Var);
            size = j3;
        }
        while (size < j2) {
            byte[] bArr2 = im2Var.a;
            int iMin2 = (int) Math.min(im2Var.c, (((long) im2Var.b) + j2) - size);
            i = (int) ((((long) im2Var.b) + j) - size);
            while (i < iMin2) {
                if (bArr2[i] != b2) {
                    i++;
                }
            }
            size += (long) (im2Var.c - im2Var.b);
            im2Var = im2Var.f;
            p31.c(im2Var);
            j = size;
        }
        return -1L;
        return ((long) (i - im2Var.b)) + size;
    }

    public int hashCode() {
        im2 im2Var = this.a;
        if (im2Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = im2Var.c;
            for (int i3 = im2Var.b; i3 < i2; i3++) {
                i = (i * 31) + im2Var.a[i3];
            }
            im2Var = im2Var.f;
            p31.c(im2Var);
        } while (im2Var != this.a);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public long j0(ByteString byteString, long j) {
        int i;
        int i2;
        p31.f(byteString, "targetBytes");
        long size = 0;
        if (j < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        im2 im2Var = this.a;
        if (im2Var == null) {
            return -1L;
        }
        if (size() - j < j) {
            size = size();
            while (size > j) {
                im2Var = im2Var.g;
                p31.c(im2Var);
                size -= (long) (im2Var.c - im2Var.b);
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (size < size()) {
                    byte[] bArr = im2Var.a;
                    i = (int) ((((long) im2Var.b) + j) - size);
                    int i3 = im2Var.c;
                    while (true) {
                        if (i >= i3) {
                            size += (long) (im2Var.c - im2Var.b);
                            im2Var = im2Var.f;
                            p31.c(im2Var);
                            j = size;
                        } else {
                            byte b4 = bArr[i];
                            if (b4 == b2 || b4 == b3) {
                                i2 = im2Var.b;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = byteString.internalArray$okio();
            while (size < size()) {
                byte[] bArr2 = im2Var.a;
                i = (int) ((((long) im2Var.b) + j) - size);
                int i4 = im2Var.c;
                while (true) {
                    if (i < i4) {
                        byte b5 = bArr2[i];
                        int length = bArrInternalArray$okio.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                i++;
                            } else if (b5 == bArrInternalArray$okio[i5]) {
                                i2 = im2Var.b;
                            } else {
                                i5++;
                            }
                        }
                    } else {
                        size += (long) (im2Var.c - im2Var.b);
                        im2Var = im2Var.f;
                        p31.c(im2Var);
                        j = size;
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j2 = ((long) (im2Var.c - im2Var.b)) + size;
            if (j2 > j) {
                break;
            }
            im2Var = im2Var.f;
            p31.c(im2Var);
            size = j2;
        }
        if (byteString.size() == 2) {
            byte b6 = byteString.getByte(0);
            byte b7 = byteString.getByte(1);
            while (size < size()) {
                byte[] bArr3 = im2Var.a;
                i = (int) ((((long) im2Var.b) + j) - size);
                int i6 = im2Var.c;
                while (true) {
                    if (i >= i6) {
                        size += (long) (im2Var.c - im2Var.b);
                        im2Var = im2Var.f;
                        p31.c(im2Var);
                        j = size;
                    } else {
                        byte b8 = bArr3[i];
                        if (b8 == b6 || b8 == b7) {
                            i2 = im2Var.b;
                        } else {
                            i++;
                        }
                    }
                }
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
        while (size < size()) {
            byte[] bArr4 = im2Var.a;
            i = (int) ((((long) im2Var.b) + j) - size);
            int i7 = im2Var.c;
            while (true) {
                if (i < i7) {
                    byte b9 = bArr4[i];
                    int length2 = bArrInternalArray$okio2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            i++;
                        } else if (b9 == bArrInternalArray$okio2[i8]) {
                            i2 = im2Var.b;
                        } else {
                            i8++;
                        }
                    }
                } else {
                    size += (long) (im2Var.c - im2Var.b);
                    im2Var = im2Var.f;
                    p31.c(im2Var);
                    j = size;
                }
            }
        }
        return -1L;
        return ((long) (i - i2)) + size;
    }

    public OutputStream k0() {
        return new c();
    }

    public boolean m0(long j, ByteString byteString) {
        p31.f(byteString, "bytes");
        return t0(j, byteString, 0, byteString.size());
    }

    @Override // defpackage.so
    public String n0() {
        return O(Long.MAX_VALUE);
    }

    @Override // defpackage.so
    public int o0() {
        return f.h(readInt());
    }

    @Override // defpackage.so
    public byte[] p0(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        p31.f(byteBuffer, "sink");
        im2 im2Var = this.a;
        if (im2Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), im2Var.c - im2Var.b);
        byteBuffer.put(im2Var.a, im2Var.b, iMin);
        int i = im2Var.b + iMin;
        im2Var.b = i;
        this.b -= (long) iMin;
        if (i == im2Var.c) {
            this.a = im2Var.b();
            jm2.b(im2Var);
        }
        return iMin;
    }

    @Override // defpackage.so
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        im2 im2Var = this.a;
        p31.c(im2Var);
        int i = im2Var.b;
        int i2 = im2Var.c;
        int i3 = i + 1;
        byte b2 = im2Var.a[i];
        I0(size() - 1);
        if (i3 == i2) {
            this.a = im2Var.b();
            jm2.b(im2Var);
        } else {
            im2Var.b = i3;
        }
        return b2;
    }

    @Override // defpackage.so
    public void readFully(byte[] bArr) throws EOFException {
        p31.f(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int iW0 = w0(bArr, i, bArr.length - i);
            if (iW0 == -1) {
                throw new EOFException();
            }
            i += iW0;
        }
    }

    @Override // defpackage.so
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        im2 im2Var = this.a;
        p31.c(im2Var);
        int i = im2Var.b;
        int i2 = im2Var.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = im2Var.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        I0(size() - 4);
        if (i5 == i2) {
            this.a = im2Var.b();
            jm2.b(im2Var);
        } else {
            im2Var.b = i5;
        }
        return i6;
    }

    @Override // defpackage.so
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        im2 im2Var = this.a;
        p31.c(im2Var);
        int i = im2Var.b;
        int i2 = im2Var.c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = im2Var.a;
        int i3 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (((long) bArr[i3]) & 255);
        I0(size() - 8);
        if (i4 == i2) {
            this.a = im2Var.b();
            jm2.b(im2Var);
        } else {
            im2Var.b = i4;
        }
        return j2;
    }

    @Override // defpackage.so
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        im2 im2Var = this.a;
        p31.c(im2Var);
        int i = im2Var.b;
        int i2 = im2Var.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = im2Var.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        I0(size() - 2);
        if (i5 == i2) {
            this.a = im2Var.b();
            jm2.b(im2Var);
        } else {
            im2Var.b = i5;
        }
        return (short) i6;
    }

    @Override // defpackage.so
    public boolean request(long j) {
        return this.b >= j;
    }

    @Override // defpackage.so
    public String s(long j) throws EOFException {
        return F0(j, gx.b);
    }

    public final long size() {
        return this.b;
    }

    public boolean t0(long j, ByteString byteString, int i, int i2) {
        p31.f(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || size() - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (e0(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.ks2
    public h33 timeout() {
        return h33.e;
    }

    public String toString() {
        return J0().toString();
    }

    public final void u() throws EOFException {
        a(size());
    }

    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public fo clone() {
        return C();
    }

    public int w0(byte[] bArr, int i, int i2) {
        p31.f(bArr, "sink");
        f.b(bArr.length, i, i2);
        im2 im2Var = this.a;
        if (im2Var == null) {
            return -1;
        }
        int iMin = Math.min(i2, im2Var.c - im2Var.b);
        byte[] bArr2 = im2Var.a;
        int i3 = im2Var.b;
        d.d(bArr2, bArr, i, i3, i3 + iMin);
        im2Var.b += iMin;
        I0(size() - ((long) iMin));
        if (im2Var.b == im2Var.c) {
            this.a = im2Var.b();
            jm2.b(im2Var);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        p31.f(byteBuffer, SocialConstants.PARAM_SOURCE);
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            im2 im2VarL0 = L0(1);
            int iMin = Math.min(i, 8192 - im2VarL0.c);
            byteBuffer.get(im2VarL0.a, im2VarL0.c, iMin);
            i -= iMin;
            im2VarL0.c += iMin;
        }
        this.b += (long) iRemaining;
        return iRemaining;
    }

    @Override // defpackage.so
    public ByteString x(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        if (j < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new ByteString(p0(j));
        }
        ByteString byteStringK0 = K0((int) j);
        a(j);
        return byteStringK0;
    }

    @Override // defpackage.so
    public short x0() {
        return f.j(readShort());
    }

    public final long y() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        im2 im2Var = this.a;
        p31.c(im2Var);
        im2 im2Var2 = im2Var.g;
        p31.c(im2Var2);
        int i = im2Var2.c;
        if (i < 8192 && im2Var2.e) {
            size -= (long) (i - im2Var2.b);
        }
        return size;
    }

    public final a y0(a aVar) {
        p31.f(aVar, "unsafeCursor");
        return defpackage.b.a(this, aVar);
    }

    @Override // defpackage.so
    public long z0() {
        return f.i(readLong());
    }

    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(fo.this.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (fo.this.size() > 0) {
                return fo.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return fo.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            p31.f(bArr, "sink");
            return fo.this.w0(bArr, i, i2);
        }
    }

    @Override // defpackage.ks2
    public long read(fo foVar, long j) {
        p31.f(foVar, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j > size()) {
            j = size();
        }
        foVar.b0(this, j);
        return j;
    }
}
