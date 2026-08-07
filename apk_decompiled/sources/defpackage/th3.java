package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class th3 {
    public static final th3 a = new th3();

    private th3() {
    }

    public final String a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        }
        if ((1004 > i || i >= 1007) && (1015 > i || i >= 3000)) {
            return null;
        }
        return "Code " + i + " is reserved and may not be used.";
    }

    public final void b(fo.a aVar, byte[] bArr) {
        p31.f(aVar, "cursor");
        p31.f(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = aVar.e;
            int i2 = aVar.f;
            int i3 = aVar.g;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
        } while (aVar.u() != -1);
    }

    public final void c(int i) {
        String strA = a(i);
        if (strA == null) {
            return;
        }
        p31.c(strA);
        throw new IllegalArgumentException(strA.toString());
    }
}
