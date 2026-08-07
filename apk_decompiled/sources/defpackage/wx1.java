package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class wx1 {
    private int a;
    private int b = -1;
    private byte[] c;
    private int d;

    public void a() {
        this.d = 0;
        this.a = 0;
        this.b = -1;
        this.c = null;
    }

    public int b(byte[] bArr) {
        int length = bArr.length - 2;
        short[] sArr = {0, -24575};
        int i = 65535;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2];
            for (int i4 = 0; i4 < 8; i4++) {
                i = (sArr[((i ^ i3) == true ? 1 : 0) & 1] & 65535) ^ (i >> 1);
                i3 >>= 1;
            }
        }
        return i;
    }

    public void c(byte[] bArr, int i) {
        int length = bArr.length;
        bArr[length - 2] = (byte) (i & 255);
        bArr[length - 1] = (byte) ((i >> 8) & 255);
    }

    public void d(byte[] bArr, int i) {
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i >> 8) & 255);
    }

    public int e() {
        return this.b;
    }

    public byte[] f() {
        int iG = g();
        byte[] bArrH = h(iG);
        this.b = iG;
        return bArrH;
    }

    public int g() {
        return this.b + 1;
    }

    public byte[] h(int i) {
        int length = this.c.length;
        if (length > 16) {
            length = i + 1 == this.a ? length - (i * 16) : 16;
        }
        byte[] bArr = new byte[20];
        for (int i2 = 0; i2 < 20; i2++) {
            bArr[i2] = -1;
        }
        System.arraycopy(this.c, i * 16, bArr, 2, length);
        d(bArr, i);
        int iB = b(bArr);
        c(bArr, iB);
        vx1.a("ota packet ---> index : " + i + " total : " + this.a + " crc : " + iB + " content : " + ga.a(bArr, ":"));
        return bArr;
    }

    public int i() {
        return this.d;
    }

    public boolean j() {
        int i = this.a;
        return i > 0 && this.b + 1 < i;
    }

    public boolean k() {
        float fG = g();
        float f = this.a;
        vx1.a("invalidate progress: " + fG + " -- " + f);
        int iFloor = (int) Math.floor((double) ((fG / f) * 100.0f));
        if (iFloor == this.d) {
            return false;
        }
        this.d = iFloor;
        return true;
    }

    public boolean l() {
        return this.b + 1 == this.a;
    }

    public void m(byte[] bArr) {
        a();
        this.c = bArr;
        int length = bArr.length;
        if (length % 16 == 0) {
            this.a = length / 16;
        } else {
            this.a = (int) Math.floor((length / 16) + 1);
        }
    }
}
