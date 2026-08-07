package defpackage;

import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes4.dex */
public abstract class tw0 {
    private static final int[] a;
    private static final int[] b;
    private static final int[] c;
    private static final long[] d;

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = "0123456789abcdef".charAt(i2 & 15) | ("0123456789abcdef".charAt(i2 >> 4) << '\b');
        }
        a = iArr;
        int[] iArr2 = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = CHexConver.b.charAt(i3 & 15) | (CHexConver.b.charAt(i3 >> 4) << '\b');
        }
        b = iArr2;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i5)] = i6;
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < CHexConver.b.length()) {
            iArr3[CHexConver.b.charAt(i7)] = i8;
            i7++;
            i8++;
        }
        c = iArr3;
        long[] jArr = new long[256];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i10)] = i11;
            i10++;
            i11++;
        }
        int i12 = 0;
        while (i < CHexConver.b.length()) {
            jArr[CHexConver.b.charAt(i)] = i12;
            i++;
            i12++;
        }
        d = jArr;
    }

    public static final int[] a() {
        return a;
    }
}
