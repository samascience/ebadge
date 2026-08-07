package defpackage;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class d83 extends Reader {
    protected final oy0 a;
    protected InputStream b;
    protected byte[] c;
    protected int d;
    protected int e;
    protected final boolean f;
    protected char g = 0;
    protected int h;
    protected int i;
    protected final boolean j;
    protected char[] k;

    public d83(oy0 oy0Var, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        this.a = oy0Var;
        this.b = inputStream;
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.j = inputStream != null;
    }

    private void C() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void D(int i, int i2) throws CharConversionException {
        int i3 = this.i + i;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.h + ", byte #" + i3 + ")");
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

    private boolean u(int i) throws IOException {
        byte[] bArr;
        InputStream inputStream = this.b;
        if (inputStream == null || (bArr = this.c) == null) {
            return false;
        }
        this.i += this.e - i;
        if (i > 0) {
            int i2 = this.d;
            if (i2 > 0) {
                System.arraycopy(bArr, i2, bArr, 0, i);
                this.d = 0;
            }
            this.e = i;
        } else {
            this.d = 0;
            int i3 = inputStream.read(bArr);
            if (i3 < 1) {
                this.e = 0;
                if (i3 < 0) {
                    if (this.j) {
                        n();
                    }
                    return false;
                }
                C();
            }
            this.e = i3;
        }
        while (true) {
            int i4 = this.e;
            if (i4 >= 4) {
                return true;
            }
            InputStream inputStream2 = this.b;
            byte[] bArr2 = this.c;
            int i5 = inputStream2.read(bArr2, i4, bArr2.length - i4);
            if (i5 < 1) {
                if (i5 < 0) {
                    if (this.j) {
                        n();
                    }
                    D(this.e, 4);
                }
                C();
            }
            this.e += i5;
        }
    }

    private void w(char[] cArr, int i, int i2) {
        throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(cArr.length)));
    }

    private void y(int i, int i2, String str) throws CharConversionException {
        int i3 = (this.i + this.d) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.h + i2) + ", byte #" + i3 + ")");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            this.b = null;
            n();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() {
        if (this.k == null) {
            this.k = new char[1];
        }
        if (read(this.k, 0, 1) < 1) {
            return -1;
        }
        return this.k[0];
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws CharConversionException {
        int i3;
        int i4;
        int i5;
        if (this.c == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i < 0 || i + i2 > cArr.length) {
            w(cArr, i, i2);
        }
        int i6 = i2 + i;
        char c = this.g;
        if (c != 0) {
            i3 = i + 1;
            cArr[i] = c;
            this.g = (char) 0;
        } else {
            int i7 = this.e - this.d;
            if (i7 < 4 && !u(i7)) {
                if (i7 == 0) {
                    return -1;
                }
                D(this.e - this.d, 4);
            }
            i3 = i;
        }
        int i8 = this.e - 4;
        while (i3 < i6) {
            int i9 = this.d;
            if (i9 > i8) {
                break;
            }
            if (this.f) {
                byte[] bArr = this.c;
                i4 = (bArr[i9] << 8) | (bArr[i9 + 1] & 255);
                i5 = (bArr[i9 + 3] & 255) | ((bArr[i9 + 2] & 255) << 8);
            } else {
                byte[] bArr2 = this.c;
                int i10 = (bArr2[i9] & 255) | ((bArr2[i9 + 1] & 255) << 8);
                i4 = (bArr2[i9 + 3] << 8) | (bArr2[i9 + 2] & 255);
                i5 = i10;
            }
            this.d = i9 + 4;
            if (i4 != 0) {
                int i11 = 65535 & i4;
                int i12 = i5 | ((i11 - 1) << 16);
                if (i11 > 16) {
                    y(i12, i3 - i, String.format(" (above 0x%08x)", 1114111));
                }
                int i13 = i3 + 1;
                cArr[i3] = (char) ((i12 >> 10) + 55296);
                int i14 = (i12 & 1023) | 56320;
                if (i13 >= i6) {
                    this.g = (char) i12;
                    i3 = i13;
                    break;
                }
                i5 = i14;
                i3 = i13;
            }
            cArr[i3] = (char) i5;
            i3++;
        }
        int i15 = i3 - i;
        this.h += i15;
        return i15;
    }
}
