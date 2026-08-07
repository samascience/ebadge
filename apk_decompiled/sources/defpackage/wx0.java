package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class wx0 extends uu0 {
    private wh e;

    public wx0(ef1 ef1Var) {
        super(ef1Var);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008c A[PHI: r4
      0x008c: PHI (r4v5 int) = (r4v4 int), (r4v8 int), (r4v8 int) binds: [B:32:0x006c, B:34:0x0070, B:35:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    private static int[][] i(byte[] bArr, int i, int i2, int i3, int i4) {
        char c;
        char c2 = 2;
        boolean z = true;
        int i5 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i2, i);
        int i6 = 0;
        while (i6 < i2) {
            int i7 = i6 << 3;
            int i8 = i4 - 8;
            if (i7 > i8) {
                i7 = i8;
            }
            int i9 = i5;
            while (i9 < i) {
                int i10 = i9 << 3;
                int i11 = i3 - 8;
                if (i10 > i11) {
                    i10 = i11;
                }
                int i12 = (i7 * i3) + i10;
                int i13 = i5;
                int i14 = i13;
                int i15 = i14;
                int i16 = 255;
                while (i13 < 8) {
                    for (int i17 = 0; i17 < 8; i17++) {
                        int i18 = bArr[i12 + i17] & 255;
                        i14 += i18;
                        if (i18 < i16) {
                            i16 = i18;
                        }
                        if (i18 > i15) {
                            i15 = i18;
                        }
                    }
                    if (i15 - i16 > 24) {
                        while (true) {
                            i13++;
                            i12 += i3;
                            if (i13 < 8) {
                                for (int i19 = 0; i19 < 8; i19++) {
                                    i14 += bArr[i12 + i19] & 255;
                                }
                            }
                        }
                    }
                    i13++;
                    i12 += i3;
                    z = true;
                }
                boolean z2 = z;
                int i20 = i14 >> 6;
                if (i15 - i16 <= 24) {
                    i20 = i16 / 2;
                    if (i6 <= 0 || i9 <= 0) {
                        c = 2;
                    } else {
                        int[] iArr2 = iArr[i6 - 1];
                        int i21 = i9 - 1;
                        c = 2;
                        int i22 = ((iArr2[i9] + (iArr[i6][i21] * 2)) + iArr2[i21]) / 4;
                        if (i16 < i22) {
                            i20 = i22;
                        }
                    }
                } else {
                    c = 2;
                }
                iArr[i6][i9] = i20;
                i9++;
                z = z2;
                c2 = c;
                i5 = 0;
            }
            i6++;
            c2 = c2;
            i5 = 0;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, wh whVar) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 > i7) {
                i6 = i7;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i8 << 3;
                int i10 = i3 - 8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int iK = k(i8, 2, i - 3);
                int iK2 = k(i5, 2, i2 - 3);
                int i11 = 0;
                for (int i12 = -2; i12 <= 2; i12++) {
                    int[] iArr2 = iArr[iK2 + i12];
                    i11 += iArr2[iK - 2] + iArr2[iK - 1] + iArr2[iK] + iArr2[iK + 1] + iArr2[iK + 2];
                }
                l(bArr, i10, i6, i11 / 25, i3, whVar);
            }
        }
    }

    private static int k(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    private static void l(byte[] bArr, int i, int i2, int i3, int i4, wh whVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    whVar.l(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    @Override // defpackage.uu0, defpackage.sh
    public sh a(ef1 ef1Var) {
        return new wx0(ef1Var);
    }

    @Override // defpackage.uu0, defpackage.sh
    public wh b() {
        wh whVar = this.e;
        if (whVar != null) {
            return whVar;
        }
        ef1 ef1VarE = e();
        int iD = ef1VarE.d();
        int iA = ef1VarE.a();
        if (iD < 40 || iA < 40) {
            this.e = super.b();
        } else {
            byte[] bArrB = ef1VarE.b();
            int i = iD >> 3;
            if ((iD & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = iA >> 3;
            if ((iA & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] iArrI = i(bArrB, i2, i4, iD, iA);
            wh whVar2 = new wh(iD, iA);
            j(bArrB, i2, i4, iD, iA, iArrI, whVar2);
            this.e = whVar2;
        }
        return this.e;
    }
}
