package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class xo implements n9 {
    @Override // defpackage.n9
    public int a() {
        return 1;
    }

    @Override // defpackage.n9
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // defpackage.n9
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i) {
        return new byte[i];
    }

    @Override // defpackage.n9
    public String getTag() {
        return "ByteArrayPool";
    }
}
