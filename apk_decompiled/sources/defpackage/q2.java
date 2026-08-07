package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class q2 extends ng {
    private static final byte[] e = new byte[0];
    private int a;
    private int b;
    private boolean c;
    private final byte[] d;

    public q2(int i, int i2, boolean z, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = (bArr == null || bArr.length == 0) ? e : Arrays.copyOf(bArr, bArr.length);
    }

    public int a() {
        return gi0.a(this.a, this.b);
    }

    public boolean b(byte[] bArr) {
        if (bArr == null || bArr.length < 6 || this.a != (bArr[3] & 255) || this.b != (bArr[5] & 255)) {
            return false;
        }
        byte[] bArr2 = this.d;
        if (bArr2.length == 0) {
            return true;
        }
        if (bArr.length < bArr2.length + 8) {
            return false;
        }
        int i = 0;
        while (true) {
            byte[] bArr3 = this.d;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr3[i] != bArr[i + 8]) {
                return false;
            }
            i++;
        }
    }

    public boolean c() {
        return this.c;
    }

    public String toString() {
        return "AckEvent{command=" + this.a + ", commandKey=" + this.b + ", isSuccess=" + this.c + ", subKeyLen=" + this.d.length + '}';
    }
}
