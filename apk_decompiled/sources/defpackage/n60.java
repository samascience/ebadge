package defpackage;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class n60 extends OutputStream {
    protected final DataOutput a;

    public n60(DataOutput dataOutput) {
        this.a = dataOutput;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.a.write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
    }
}
