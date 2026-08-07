package defpackage;

import com.google.zxing.ReaderException;

/* JADX INFO: loaded from: classes3.dex */
final class a83 {
    private static final int[] c = {1, 1, 2};
    private final y73 a = new y73();
    private final z73 b = new z73();

    a83() {
    }

    kh2 a(int i, uh uhVar, int i2) {
        int[] iArrN = b83.n(uhVar, i2, false, c);
        try {
            return this.b.b(i, uhVar, iArrN);
        } catch (ReaderException unused) {
            return this.a.b(i, uhVar, iArrN);
        }
    }
}
