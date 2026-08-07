package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class wi1 extends InputStream {
    private final oy0 a;
    private final InputStream b;
    private byte[] c;
    private int d;
    private final int e;

    public wi1(oy0 oy0Var, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.a = oy0Var;
        this.b = inputStream;
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }

    private void n() {
        byte[] bArr = this.c;
        if (bArr != null) {
            this.c = null;
            oy0 oy0Var = this.a;
            if (oy0Var != null) {
                oy0Var.r(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.c != null ? this.e - this.d : this.b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        n();
        this.b.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        if (this.c == null) {
            this.b.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.c == null && this.b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this.c;
        if (bArr == null) {
            return this.b.read();
        }
        int i = this.d;
        int i2 = i + 1;
        this.d = i2;
        int i3 = bArr[i] & 255;
        if (i2 >= this.e) {
            n();
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        if (this.c == null) {
            this.b.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long j2;
        if (this.c != null) {
            int i = this.e;
            int i2 = this.d;
            j2 = i - i2;
            if (j2 > j) {
                this.d = i2 + ((int) j);
                return j;
            }
            n();
            j -= j2;
        } else {
            j2 = 0;
        }
        return j > 0 ? j2 + this.b.skip(j) : j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.c;
        if (bArr2 != null) {
            int i3 = this.e;
            int i4 = this.d;
            int i5 = i3 - i4;
            if (i2 > i5) {
                i2 = i5;
            }
            System.arraycopy(bArr2, i4, bArr, i, i2);
            int i6 = this.d + i2;
            this.d = i6;
            if (i6 >= this.e) {
                n();
            }
            return i2;
        }
        return this.b.read(bArr, i, i2);
    }
}
