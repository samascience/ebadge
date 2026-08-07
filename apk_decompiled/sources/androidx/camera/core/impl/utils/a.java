package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
class a extends FilterOutputStream {
    final OutputStream a;
    private ByteOrder b;

    a(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.a = outputStream;
        this.b = byteOrder;
    }

    public void C(long j) throws IOException {
        w((int) j);
    }

    public void D(int i) throws IOException {
        y((short) i);
    }

    public void n(ByteOrder byteOrder) {
        this.b = byteOrder;
    }

    public void u(int i) throws IOException {
        this.a.write(i);
    }

    public void w(int i) throws IOException {
        ByteOrder byteOrder = this.b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.a.write(i & 255);
            this.a.write((i >>> 8) & 255);
            this.a.write((i >>> 16) & 255);
            this.a.write((i >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.a.write((i >>> 24) & 255);
            this.a.write((i >>> 16) & 255);
            this.a.write((i >>> 8) & 255);
            this.a.write(i & 255);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.a.write(bArr);
    }

    public void y(short s) throws IOException {
        ByteOrder byteOrder = this.b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.a.write(s & 255);
            this.a.write((s >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.a.write((s >>> 8) & 255);
            this.a.write(s & 255);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
    }
}
