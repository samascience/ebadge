package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class x92 extends ef1 {
    private final byte[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public x92(int i, int i2, int[] iArr) {
        super(i, i2);
        this.d = i;
        this.e = i2;
        this.f = 0;
        this.g = 0;
        int i3 = i * i2;
        this.c = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.c[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    @Override // defpackage.ef1
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i = this.d;
        if (iD == i && iA == this.e) {
            return this.c;
        }
        int i2 = iD * iA;
        byte[] bArr = new byte[i2];
        int i3 = (this.g * i) + this.f;
        if (iD == i) {
            System.arraycopy(this.c, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < iA; i4++) {
            System.arraycopy(this.c, i3, bArr, i4 * iD, iD);
            i3 += this.d;
        }
        return bArr;
    }

    @Override // defpackage.ef1
    public byte[] c(int i, byte[] bArr) {
        if (i < 0 || i >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.c, ((i + this.g) * this.d) + this.f, bArr, 0, iD);
        return bArr;
    }
}
