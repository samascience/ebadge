package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class lm3 extends km3 {
    public lm3(mm3 mm3Var) {
        this.f = (int) mm3Var.d();
        this.e = (int) mm3Var.b();
        this.d = mm3Var.a();
    }

    public byte[] e() {
        byte[] bArr = new byte[f()];
        bArr[0] = -86;
        bArr[1] = 85;
        int i = this.e;
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        int i2 = this.f;
        bArr[4] = (byte) (i2 & 255);
        bArr[5] = (byte) ((i2 >> 8) & 255);
        System.arraycopy(this.d, 0, bArr, 6, i);
        return bArr;
    }

    public int f() {
        return this.e + 6;
    }

    public void g(long j) {
        this.b = 2;
        this.d = new byte[this.e];
        int i = 0;
        for (int i2 = 0; i2 < this.e; i2++) {
            this.d[i2] = (byte) (j >> i);
            i += 8;
        }
    }

    public void h(byte[] bArr) {
        this.b = 5;
        this.d = bArr;
        this.e = bArr.length;
    }

    public lm3() {
    }
}
