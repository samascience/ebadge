package defpackage;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ls1 {
    public static byte[] a(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int i = 0;
        for (byte[] bArr4 : bArr) {
            int length2 = bArr4.length;
            int i2 = 0;
            while (i2 < length2) {
                bArr3[i] = bArr4[i2];
                i2++;
                i++;
            }
        }
        return bArr3;
    }

    public static float b(float f, int i) {
        return new BigDecimal(f).setScale(i, 3).floatValue();
    }

    public static String c(Number number, int i, int i2) {
        return d(String.valueOf(number), i, i2);
    }

    public static String d(String str, int i, int i2) {
        return new BigDecimal(str).setScale(i, i2).toPlainString();
    }
}
