package com.luck.picture.lib.io;

import defpackage.w9;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class BufferedInputStreamWrap extends FilterInputStream {
    private volatile byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;

    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561759L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public BufferedInputStreamWrap(InputStream inputStream) {
        this(inputStream, 65536);
    }

    private int n(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.d;
        if (i != -1) {
            int i2 = this.e - i;
            int i3 = this.c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArrB = w9.c().b(i3);
                    System.arraycopy(bArr, 0, bArrB, 0, bArr.length);
                    this.a = bArrB;
                    w9.c().e(bArr);
                    bArr = bArrB;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.e - this.d;
                this.e = i4;
                this.d = 0;
                this.b = 0;
                int i5 = inputStream.read(bArr, i4, bArr.length - i4);
                int i6 = this.e;
                if (i5 > 0) {
                    i6 += i5;
                }
                this.b = i6;
                return i5;
            }
        }
        int i7 = inputStream.read(bArr);
        if (i7 > 0) {
            this.d = -1;
            this.e = 0;
            this.b = i7;
        }
        return i7;
    }

    private static IOException u() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream = ((FilterInputStream) this).in;
        if (this.a != null && inputStream != null) {
            return (this.b - this.e) + inputStream.available();
        }
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.a != null) {
            w9.c().e(this.a);
            this.a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.c = Math.max(this.c, i);
        this.d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw u();
        }
        if (this.e >= this.b && n(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.a && (bArr = this.a) == null) {
            throw u();
        }
        int i = this.b;
        int i2 = this.e;
        if (i - i2 <= 0) {
            return -1;
        }
        this.e = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.a == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.d;
        if (-1 == i) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.c);
        }
        this.e = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.a;
        if (bArr == null) {
            throw u();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw u();
        }
        int i = this.b;
        int i2 = this.e;
        if (i - i2 >= j) {
            this.e = (int) (((long) i2) + j);
            return j;
        }
        long j2 = ((long) i) - ((long) i2);
        this.e = i;
        if (this.d == -1 || j > this.c) {
            return j2 + inputStream.skip(j - j2);
        }
        if (n(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.b;
        int i4 = this.e;
        if (i3 - i4 >= j - j2) {
            this.e = (int) ((((long) i4) + j) - j2);
            return j;
        }
        long j3 = (j2 + ((long) i3)) - ((long) i4);
        this.e = i3;
        return j3;
    }

    BufferedInputStreamWrap(InputStream inputStream, int i) {
        super(inputStream);
        this.d = -1;
        this.a = w9.c().b(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int iMin;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            throw u();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i4 = this.e;
            int i5 = this.b;
            if (i4 < i5) {
                int iMin2 = Math.min(i5 - i4, i2);
                System.arraycopy(bArr2, this.e, bArr, i, iMin2);
                this.e += iMin2;
                if (iMin2 == i2 || inputStream.available() == 0) {
                    return iMin2;
                }
                i += iMin2;
                i3 = i2 - iMin2;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.d == -1 && i3 >= bArr2.length) {
                    iMin = inputStream.read(bArr, i, i3);
                    if (iMin == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (n(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.a && (bArr2 = this.a) == null) {
                        throw u();
                    }
                    iMin = Math.min(this.b - this.e, i3);
                    System.arraycopy(bArr2, this.e, bArr, i, iMin);
                    this.e += iMin;
                }
                i3 -= iMin;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += iMin;
            }
        } else {
            throw u();
        }
    }
}
