package defpackage;

import java.io.OutputStream;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class zo extends OutputStream {
    public static final byte[] f = new byte[0];
    private final io a;
    private final LinkedList b;
    private int c;
    private byte[] d;
    private int e;

    public zo() {
        this((io) null);
    }

    public static zo V(byte[] bArr, int i) {
        return new zo(null, bArr, i);
    }

    private void n() {
        int length = this.c + this.d.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this.c = length;
        int iMax = Math.max(length >> 1, 1000);
        if (iMax > 131072) {
            iMax = 131072;
        }
        this.b.add(this.d);
        this.d = new byte[iMax];
        this.e = 0;
    }

    public byte[] C(int i) {
        this.e = i;
        return t0();
    }

    public byte[] D() {
        n();
        return this.d;
    }

    public byte[] a0() {
        return this.d;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public int e0() {
        return this.e;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public void g0() {
        byte[] bArr;
        j0();
        io ioVar = this.a;
        if (ioVar == null || (bArr = this.d) == null) {
            return;
        }
        ioVar.i(2, bArr);
        this.d = null;
    }

    public void j0() {
        this.c = 0;
        this.e = 0;
        if (this.b.isEmpty()) {
            return;
        }
        this.b.clear();
    }

    public byte[] k0() {
        j0();
        return this.d;
    }

    public void m0(int i) {
        this.e = i;
    }

    public byte[] t0() {
        int i = this.c + this.e;
        if (i == 0) {
            return f;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.b) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this.d, 0, bArr, i2, this.e);
        int i3 = i2 + this.e;
        if (i3 == i) {
            if (!this.b.isEmpty()) {
                j0();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
    }

    public void u(int i) {
        if (this.e >= this.d.length) {
            n();
        }
        byte[] bArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void w(int i) {
        int i2 = this.e;
        int i3 = i2 + 2;
        byte[] bArr = this.d;
        if (i3 >= bArr.length) {
            u(i >> 16);
            u(i >> 8);
            u(i);
            return;
        }
        int i4 = i2 + 1;
        this.e = i4;
        bArr[i2] = (byte) (i >> 16);
        int i5 = i2 + 2;
        this.e = i5;
        bArr[i4] = (byte) (i >> 8);
        this.e = i2 + 3;
        bArr[i5] = (byte) i;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void y(int i) {
        int i2 = this.e;
        int i3 = i2 + 1;
        byte[] bArr = this.d;
        if (i3 >= bArr.length) {
            u(i >> 8);
            u(i);
            return;
        }
        int i4 = i2 + 1;
        this.e = i4;
        bArr[i2] = (byte) (i >> 8);
        this.e = i2 + 2;
        bArr[i4] = (byte) i;
    }

    public zo(io ioVar) {
        this(ioVar, 500);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int iMin = Math.min(this.d.length - this.e, i2);
            if (iMin > 0) {
                System.arraycopy(bArr, i, this.d, this.e, iMin);
                i += iMin;
                this.e += iMin;
                i2 -= iMin;
            }
            if (i2 <= 0) {
                return;
            } else {
                n();
            }
        }
    }

    public zo(int i) {
        this(null, i);
    }

    public zo(io ioVar, int i) {
        this.b = new LinkedList();
        this.a = ioVar;
        this.d = ioVar == null ? new byte[i > 131072 ? 131072 : i] : ioVar.a(2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        u(i);
    }

    private zo(io ioVar, byte[] bArr, int i) {
        this.b = new LinkedList();
        this.a = null;
        this.d = bArr;
        this.e = i;
    }
}
