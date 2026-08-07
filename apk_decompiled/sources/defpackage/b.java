package defpackage;

import java.io.EOFException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    private static final byte[] a = um3.a("0123456789abcdef");

    public static final fo.a a(fo foVar, fo.a aVar) {
        p31.f(foVar, "<this>");
        p31.f(aVar, "unsafeCursor");
        fo.a aVarG = f.g(aVar);
        if (aVarG.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVarG.a = foVar;
        aVarG.b = true;
        return aVarG;
    }

    public static final byte[] b() {
        return a;
    }

    public static final String c(fo foVar, long j) throws EOFException {
        p31.f(foVar, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (foVar.e0(j2) == 13) {
                String strS = foVar.s(j2);
                foVar.a(2L);
                return strS;
            }
        }
        String strS2 = foVar.s(j);
        foVar.a(1L);
        return strS2;
    }

    public static final int d(fo foVar, qx1 qx1Var, boolean z) {
        int i;
        int i2;
        im2 im2Var;
        int i3;
        int i4;
        p31.f(foVar, "<this>");
        p31.f(qx1Var, "options");
        im2 im2Var2 = foVar.a;
        if (im2Var2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = im2Var2.a;
        int i5 = im2Var2.b;
        int i6 = im2Var2.c;
        int[] iArrF = qx1Var.f();
        im2 im2Var3 = im2Var2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int i10 = iArrF[i8];
            int i11 = i8 + 2;
            int i12 = iArrF[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (im2Var3 == null) {
                break;
            }
            if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & 255;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == iArrF[i11]) {
                        i2 = iArrF[i11 + i10];
                        if (i == i6) {
                            im2Var3 = im2Var3.f;
                            p31.c(im2Var3);
                            i = im2Var3.b;
                            bArr = im2Var3.a;
                            i6 = im2Var3.c;
                            if (im2Var3 == im2Var2) {
                                im2Var3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            int i15 = i11 + (i10 * (-1));
            while (true) {
                int i16 = i5 + 1;
                int i17 = i11 + 1;
                if ((bArr[i5] & 255) != iArrF[i11]) {
                    return i7;
                }
                boolean z2 = i17 == i15;
                if (i16 == i6) {
                    p31.c(im2Var3);
                    im2 im2Var4 = im2Var3.f;
                    p31.c(im2Var4);
                    i4 = im2Var4.b;
                    byte[] bArr2 = im2Var4.a;
                    i3 = im2Var4.c;
                    if (im2Var4 != im2Var2) {
                        im2Var = im2Var4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        im2Var = null;
                    }
                } else {
                    im2Var = im2Var3;
                    i3 = i6;
                    i4 = i16;
                }
                if (z2) {
                    i2 = iArrF[i17];
                    i = i4;
                    i6 = i3;
                    im2Var3 = im2Var;
                    break;
                }
                i5 = i4;
                i6 = i3;
                im2Var3 = im2Var;
                i11 = i17;
            }
            if (i2 >= 0) {
                return i2;
            }
            i8 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i7;
    }

    public static /* synthetic */ int e(fo foVar, qx1 qx1Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return d(foVar, qx1Var, z);
    }
}
