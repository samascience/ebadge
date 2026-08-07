package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class yo implements o9 {
    @Override // defpackage.o9
    public int a() {
        return 1;
    }

    @Override // defpackage.o9
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // defpackage.o9
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i) {
        return new byte[i];
    }

    @Override // defpackage.o9
    public String getTag() {
        return "ByteArrayPool";
    }
}
