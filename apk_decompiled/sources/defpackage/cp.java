package defpackage;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class cp extends InputStream {
    protected final ByteBuffer a;

    public cp(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.remaining();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.a.hasRemaining()) {
            return this.a.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (!this.a.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i2, this.a.remaining());
        this.a.get(bArr, i, iMin);
        return iMin;
    }
}
