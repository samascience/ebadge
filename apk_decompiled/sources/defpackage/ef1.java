package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ef1 {
    private final int a;
    private final int b;

    protected ef1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i, byte[] bArr);

    public final int d() {
        return this.a;
    }

    public boolean e() {
        return false;
    }

    public ef1 f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        char c;
        int i = this.a;
        byte[] bArrC = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrC = c(i2, bArrC);
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = bArrC[i3] & 255;
                if (i4 < 64) {
                    c = '#';
                } else if (i4 < 128) {
                    c = '+';
                } else {
                    c = i4 < 192 ? '.' : ' ';
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
