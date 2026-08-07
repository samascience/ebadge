package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class jr1 extends lr1 {
    private byte[] z0;

    public jr1(oy0 oy0Var, int i, mp mpVar) {
        super(oy0Var, i, mpVar);
        this.z0 = ez1.f;
    }

    @Override // defpackage.lr1
    protected byte q4(int i) {
        return this.z0[i];
    }

    @Override // defpackage.lr1
    protected byte r4() {
        byte[] bArr = this.z0;
        int i = this.r;
        this.r = i + 1;
        return bArr[i];
    }

    @Override // defpackage.lr1
    protected int s4() {
        byte[] bArr = this.z0;
        int i = this.r;
        this.r = i + 1;
        return bArr[i] & 255;
    }
}
