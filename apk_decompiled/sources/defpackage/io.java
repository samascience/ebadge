package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes.dex */
public class io {
    private static final int[] c = {8000, 8000, 2000, 2000};
    private static final int[] d = {4000, 4000, 200, 200};
    protected final AtomicReferenceArray a;
    protected final AtomicReferenceArray b;

    public io() {
        this(4, 4);
    }

    public final byte[] a(int i) {
        return b(i, 0);
    }

    public byte[] b(int i, int i2) {
        int iF = f(i);
        if (i2 < iF) {
            i2 = iF;
        }
        byte[] bArr = (byte[]) this.a.getAndSet(i, null);
        return (bArr == null || bArr.length < i2) ? e(i2) : bArr;
    }

    public final char[] c(int i) {
        return d(i, 0);
    }

    public char[] d(int i, int i2) {
        int iH = h(i);
        if (i2 < iH) {
            i2 = iH;
        }
        char[] cArr = (char[]) this.b.getAndSet(i, null);
        return (cArr == null || cArr.length < i2) ? g(i2) : cArr;
    }

    protected byte[] e(int i) {
        return new byte[i];
    }

    protected int f(int i) {
        return c[i];
    }

    protected char[] g(int i) {
        return new char[i];
    }

    protected int h(int i) {
        return d[i];
    }

    public void i(int i, byte[] bArr) {
        this.a.set(i, bArr);
    }

    public void j(int i, char[] cArr) {
        this.b.set(i, cArr);
    }

    protected io(int i, int i2) {
        this.a = new AtomicReferenceArray(i);
        this.b = new AtomicReferenceArray(i2);
    }
}
