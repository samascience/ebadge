package defpackage;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class dp extends OutputStream {
    protected final ByteBuffer a;

    public dp(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.a.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.a.put(bArr, i, i2);
    }
}
