package defpackage;

import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class fd2 implements so {
    public final ks2 a;
    public final fo b;
    public boolean c;

    public fd2(ks2 ks2Var) {
        p31.f(ks2Var, SocialConstants.PARAM_SOURCE);
        this.a = ks2Var;
        this.b = new fo();
    }

    @Override // defpackage.so
    public void B0(long j) throws EOFException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // defpackage.so
    public long D0() throws EOFException {
        B0(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            byte bE0 = this.b.e0(i);
            if ((bE0 < 48 || bE0 > 57) && ((bE0 < 97 || bE0 > 102) && (bE0 < 65 || bE0 > 70))) {
                if (i != 0) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bE0, kotlin.text.a.a(kotlin.text.a.a(16)));
                p31.e(string, "toString(this, checkRadix(radix))");
                sb.append(string);
                throw new NumberFormatException(sb.toString());
            }
            i = i2;
        }
        return this.b.D0();
    }

    @Override // defpackage.so
    public InputStream E0() {
        return new a();
    }

    @Override // defpackage.so
    public byte[] G() {
        this.b.L(this.a);
        return this.b.G();
    }

    @Override // defpackage.so
    public boolean H() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.b.H() && this.a.read(this.b, 8192L) == -1;
    }

    @Override // defpackage.so
    public int J(qx1 qx1Var) throws EOFException {
        p31.f(qx1Var, "options");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iD = b.d(this.b, qx1Var, true);
            if (iD != -2) {
                if (iD == -1) {
                    break;
                }
                this.b.a(qx1Var.e()[iD].size());
                return iD;
            }
        } while (this.a.read(this.b, 8192L) != -1);
        return -1;
    }

    @Override // defpackage.so
    public long K(ByteString byteString) {
        p31.f(byteString, "targetBytes");
        return w(byteString, 0L);
    }

    @Override // defpackage.so
    public String O(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jU = u((byte) 10, 0L, j2);
        if (jU != -1) {
            return b.c(this.b, jU);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.b.e0(j2 - 1) == 13 && request(1 + j2) && this.b.e0(j2) == 10) {
            return b.c(this.b, j2);
        }
        fo foVar = new fo();
        fo foVar2 = this.b;
        foVar2.D(foVar, 0L, Math.min(32, foVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.b.size(), j) + " content=" + foVar.f0().hex() + (char) 8230);
    }

    @Override // defpackage.so
    public long T(er2 er2Var) {
        p31.f(er2Var, "sink");
        long j = 0;
        while (this.a.read(this.b, 8192L) != -1) {
            long jY = this.b.y();
            if (jY > 0) {
                j += jY;
                er2Var.b0(this.b, jY);
            }
        }
        if (this.b.size() <= 0) {
            return j;
        }
        long size = j + this.b.size();
        fo foVar = this.b;
        er2Var.b0(foVar, foVar.size());
        return size;
    }

    @Override // defpackage.so
    public void X(fo foVar, long j) throws EOFException {
        p31.f(foVar, "sink");
        try {
            B0(j);
            this.b.X(foVar, j);
        } catch (EOFException e) {
            foVar.L(this.b);
            throw e;
        }
    }

    @Override // defpackage.so
    public String Y(Charset charset) {
        p31.f(charset, "charset");
        this.b.L(this.a);
        return this.b.Y(charset);
    }

    @Override // defpackage.so
    public void a(long j) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.b.size() == 0 && this.a.read(this.b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.b.size());
            this.b.a(jMin);
            j -= jMin;
        }
    }

    @Override // defpackage.so
    public fo b() {
        return this.b;
    }

    @Override // defpackage.ks2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.close();
        this.b.u();
    }

    @Override // defpackage.so
    public ByteString f0() {
        this.b.L(this.a);
        return this.b.f0();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    public long n(byte b) {
        return u(b, 0L, Long.MAX_VALUE);
    }

    @Override // defpackage.so
    public String n0() {
        return O(Long.MAX_VALUE);
    }

    @Override // defpackage.so
    public int o0() throws EOFException {
        B0(4L);
        return this.b.o0();
    }

    @Override // defpackage.so
    public byte[] p0(long j) throws EOFException {
        B0(j);
        return this.b.p0(j);
    }

    @Override // defpackage.ks2
    public long read(fo foVar, long j) {
        p31.f(foVar, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.b.size() == 0 && this.a.read(this.b, 8192L) == -1) {
            return -1L;
        }
        return this.b.read(foVar, Math.min(j, this.b.size()));
    }

    @Override // defpackage.so
    public byte readByte() throws EOFException {
        B0(1L);
        return this.b.readByte();
    }

    @Override // defpackage.so
    public void readFully(byte[] bArr) throws EOFException {
        p31.f(bArr, "sink");
        try {
            B0(bArr.length);
            this.b.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.b.size() > 0) {
                fo foVar = this.b;
                int iW0 = foVar.w0(bArr, i, (int) foVar.size());
                if (iW0 == -1) {
                    throw new AssertionError();
                }
                i += iW0;
            }
            throw e;
        }
    }

    @Override // defpackage.so
    public int readInt() throws EOFException {
        B0(4L);
        return this.b.readInt();
    }

    @Override // defpackage.so
    public long readLong() throws EOFException {
        B0(8L);
        return this.b.readLong();
    }

    @Override // defpackage.so
    public short readShort() throws EOFException {
        B0(2L);
        return this.b.readShort();
    }

    @Override // defpackage.so
    public boolean request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.b.size() < j) {
            if (this.a.read(this.b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.so
    public String s(long j) throws EOFException {
        B0(j);
        return this.b.s(j);
    }

    @Override // defpackage.ks2
    public h33 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "buffer(" + this.a + ')';
    }

    public long u(byte b, long j, long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jG0 = this.b.g0(b, j, j2);
            if (jG0 != -1) {
                return jG0;
            }
            long size = this.b.size();
            if (size >= j2 || this.a.read(this.b, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
        return -1L;
    }

    public long w(ByteString byteString, long j) {
        p31.f(byteString, "targetBytes");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jJ0 = this.b.j0(byteString, j);
            if (jJ0 != -1) {
                return jJ0;
            }
            long size = this.b.size();
            if (this.a.read(this.b, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    @Override // defpackage.so
    public ByteString x(long j) throws EOFException {
        B0(j);
        return this.b.x(j);
    }

    @Override // defpackage.so
    public short x0() throws EOFException {
        B0(2L);
        return this.b.x0();
    }

    @Override // defpackage.so
    public long z0() throws EOFException {
        B0(8L);
        return this.b.z0();
    }

    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            fd2 fd2Var = fd2.this;
            if (fd2Var.c) {
                throw new IOException("closed");
            }
            return (int) Math.min(fd2Var.b.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EOFException {
            fd2.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            fd2 fd2Var = fd2.this;
            if (fd2Var.c) {
                throw new IOException("closed");
            }
            if (fd2Var.b.size() == 0) {
                fd2 fd2Var2 = fd2.this;
                if (fd2Var2.a.read(fd2Var2.b, 8192L) == -1) {
                    return -1;
                }
            }
            return fd2.this.b.readByte() & 255;
        }

        public String toString() {
            return fd2.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            p31.f(bArr, "data");
            if (!fd2.this.c) {
                f.b(bArr.length, i, i2);
                if (fd2.this.b.size() == 0) {
                    fd2 fd2Var = fd2.this;
                    if (fd2Var.a.read(fd2Var.b, 8192L) == -1) {
                        return -1;
                    }
                }
                return fd2.this.b.w0(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        p31.f(byteBuffer, "sink");
        if (this.b.size() == 0 && this.a.read(this.b, 8192L) == -1) {
            return -1;
        }
        return this.b.read(byteBuffer);
    }
}
