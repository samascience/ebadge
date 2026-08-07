package defpackage;

import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public final class d81 extends hm0 {
    private final RandomAccessFile e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d81(boolean z, RandomAccessFile randomAccessFile) {
        super(z);
        p31.f(randomAccessFile, "randomAccessFile");
        this.e = randomAccessFile;
    }

    @Override // defpackage.hm0
    protected synchronized void D() {
        this.e.close();
    }

    @Override // defpackage.hm0
    protected synchronized int V(long j, byte[] bArr, int i, int i2) {
        p31.f(bArr, "array");
        this.e.seek(j);
        int i3 = 0;
        while (i3 < i2) {
            int i4 = this.e.read(bArr, i, i2 - i3);
            if (i4 == -1) {
                if (i3 != 0) {
                    break;
                }
                return -1;
            }
            i3 += i4;
        }
        return i3;
    }

    @Override // defpackage.hm0
    protected synchronized long a0() {
        return this.e.length();
    }
}
