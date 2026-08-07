package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q01 {
    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Image data cannot be null");
        }
        return ks1.h(r52.a, ks1.m(bArr.length), bArr, r52.b);
    }
}
