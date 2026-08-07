package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class qp implements qg2 {
    private final byte[] a;

    public qp(byte[] bArr) {
        this.a = (byte[]) z42.d(bArr);
    }

    @Override // defpackage.qg2
    public void a() {
    }

    @Override // defpackage.qg2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.a;
    }

    @Override // defpackage.qg2
    public int o() {
        return this.a.length;
    }

    @Override // defpackage.qg2
    public Class p() {
        return byte[].class;
    }
}
