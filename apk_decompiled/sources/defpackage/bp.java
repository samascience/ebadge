package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bp {
    byte[] a;
    int b = 0;

    public bp(int i) {
        this.a = null;
        this.a = new byte[i];
    }

    public bp a(byte b) {
        return d(this.b, b);
    }

    void b(int i) {
        byte[] bArr = this.a;
        if (i > bArr.length) {
            int length = (bArr.length << 1) + 2;
            if (i <= length) {
                i = length;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, this.b);
            this.a = bArr2;
        }
    }

    public byte[] c() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, 0, bArr, 0, i);
        return bArr;
    }

    public bp d(int i, byte b) {
        return e(i, new byte[]{b}, 1);
    }

    public bp e(int i, byte[] bArr, int i2) {
        int i3 = this.b;
        if (i > i3 || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        b(i3 + i2);
        byte[] bArr2 = this.a;
        System.arraycopy(bArr2, i, bArr2, i + i2, this.b - i);
        System.arraycopy(bArr, 0, this.a, i, i2);
        this.b += i2;
        return this;
    }

    public String toString() {
        return uw0.a(this.a);
    }
}
