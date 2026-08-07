package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class y92 extends p1 {
    private static final int[] i = {1, 10, 34, 70, 126};
    private static final int[] j = {4, 20, 48, 81};
    private static final int[] k = {0, 161, 961, 2015, 2715};
    private static final int[] l = {0, 336, 1036, 1516};
    private static final int[] m = {8, 6, 4, 3, 1};
    private static final int[] n = {2, 4, 6, 8};
    private static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List g = new ArrayList();
    private final List h = new ArrayList();

    private static void r(Collection collection, zy1 zy1Var) {
        if (zy1Var == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zy1 zy1Var2 = (zy1) it.next();
            if (zy1Var2.b() == zy1Var.b()) {
                zy1Var2.e();
                return;
            }
        }
        collection.add(zy1Var);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025 A[PHI: r6 r7
      0x0025: PHI (r6v7 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:23:0x0041, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x0025: PHI (r7v11 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:23:0x0041, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[PHI: r6 r7
      0x002a: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x002d A[PHI: r6 r7
      0x002d: PHI (r6v4 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002d: PHI (r7v4 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x009c  */
    /* JADX WARN: Code duplicated, block: B:69:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00af  */
    /* JADX WARN: Code duplicated, block: B:74:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00be  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    private void s(boolean z, int i2) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iD = dh1.d(m());
        int iD2 = dh1.d(k());
        boolean z6 = true;
        if (z) {
            if (iD > 12) {
                z3 = true;
                z2 = false;
            } else if (iD < 4) {
                z2 = true;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iD2 > 12) {
                z5 = true;
                z4 = false;
            } else if (iD2 < 4) {
                z4 = true;
                z5 = false;
            } else {
                z4 = false;
                z5 = false;
            }
        } else {
            if (iD > 11) {
                z3 = true;
                z2 = false;
            } else if (iD < 5) {
                z2 = true;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iD2 > 10) {
                z5 = true;
                z4 = false;
            } else if (iD2 < 4) {
                z4 = true;
                z5 = false;
            } else {
                z4 = false;
                z5 = false;
            }
        }
        int i3 = (iD + iD2) - i2;
        boolean z7 = (iD & 1) == z;
        boolean z8 = (iD2 & 1) == 1;
        if (i3 != 1) {
            if (i3 == -1) {
                if (z7) {
                    if (z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else {
                    if (!z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z4 = true;
                }
            } else {
                if (i3 != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z7) {
                    if (!z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (iD < iD2) {
                        z5 = true;
                    } else {
                        z4 = true;
                        z3 = true;
                    }
                } else if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z6) {
                if (!z3) {
                    throw NotFoundException.getNotFoundInstance();
                }
                p1.o(m(), n());
            }
            if (z3) {
                p1.h(m(), n());
            }
            if (z4) {
                if (!z5) {
                    throw NotFoundException.getNotFoundInstance();
                }
                p1.o(k(), n());
            }
            if (z5) {
                p1.h(k(), l());
            }
        }
        if (z7) {
            if (z8) {
                throw NotFoundException.getNotFoundInstance();
            }
            z3 = true;
        } else {
            if (!z8) {
                throw NotFoundException.getNotFoundInstance();
            }
            z5 = true;
        }
        z6 = z2;
        if (z6) {
            if (!z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            p1.o(m(), n());
        }
        if (z3) {
            p1.h(m(), n());
        }
        if (z4) {
            if (!z5) {
                throw NotFoundException.getNotFoundInstance();
            }
            p1.o(k(), n());
        }
        if (z5) {
            p1.h(k(), l());
        }
    }

    private static boolean t(zy1 zy1Var, zy1 zy1Var2) {
        int iA = (zy1Var.a() + (zy1Var2.a() * 16)) % 79;
        int iC = (zy1Var.d().c() * 9) + zy1Var2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    private static kh2 u(zy1 zy1Var, zy1 zy1Var2) {
        String strValueOf = String.valueOf((((long) zy1Var.b()) * 4537077) + ((long) zy1Var2.b()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        nh2[] nh2VarArrA = zy1Var.d().a();
        nh2[] nh2VarArrA2 = zy1Var2.d().a();
        return new kh2(String.valueOf(sb.toString()), null, new nh2[]{nh2VarArrA[0], nh2VarArrA[1], nh2VarArrA2[0], nh2VarArrA2[1]}, BarcodeFormat.RSS_14);
    }

    private x50 v(uh uhVar, mn0 mn0Var, boolean z) throws NotFoundException {
        int[] iArrI = i();
        iArrI[0] = 0;
        iArrI[1] = 0;
        iArrI[2] = 0;
        iArrI[3] = 0;
        iArrI[4] = 0;
        iArrI[5] = 0;
        iArrI[6] = 0;
        iArrI[7] = 0;
        if (z) {
            nw1.g(uhVar, mn0Var.b()[0], iArrI);
        } else {
            nw1.f(uhVar, mn0Var.b()[1] + 1, iArrI);
            int i2 = 0;
            for (int length = iArrI.length - 1; i2 < length; length--) {
                int i3 = iArrI[i2];
                iArrI[i2] = iArrI[length];
                iArrI[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float fD = dh1.d(iArrI) / i4;
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i5 = 0; i5 < iArrI.length; i5++) {
            float f = iArrI[i5] / fD;
            int i6 = (int) (0.5f + f);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArrM[i7] = i6;
                fArrN[i7] = f - i6;
            } else {
                iArrK[i7] = i6;
                fArrL[i7] = f - i6;
            }
        }
        s(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            int i10 = iArrM[length2];
            i8 = (i8 * 9) + i10;
            i9 += i10;
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            int i13 = iArrK[length3];
            i11 = (i11 * 9) + i13;
            i12 += i13;
        }
        int i14 = i8 + (i11 * 3);
        if (!z) {
            if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i15 = (10 - i12) / 2;
            int i16 = n[i15];
            return new x50((aa2.b(iArrK, 9 - i16, false) * j[i15]) + aa2.b(iArrM, i16, true) + l[i15], i14);
        }
        if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i17 = (12 - i9) / 2;
        int i18 = m[i17];
        return new x50((aa2.b(iArrM, i18, false) * i[i17]) + aa2.b(iArrK, 9 - i18, true) + k[i17], i14);
    }

    private zy1 w(uh uhVar, boolean z, int i2, Map map) {
        try {
            mn0 mn0VarY = y(uhVar, i2, z, x(uhVar, 0, z));
            if (map != null) {
                e43.a(map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK));
            }
            x50 x50VarV = v(uhVar, mn0VarY, true);
            x50 x50VarV2 = v(uhVar, mn0VarY, false);
            return new zy1((x50VarV.b() * 1597) + x50VarV2.b(), x50VarV.a() + (x50VarV2.a() * 4), mn0VarY);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] x(uh uhVar, int i2, boolean z) throws NotFoundException {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iG = uhVar.g();
        boolean z2 = false;
        while (i2 < iG) {
            z2 = !uhVar.c(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < iG) {
            if (uhVar.c(i2) ^ z2) {
                iArrJ[i4] = iArrJ[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (p1.p(iArrJ)) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i4--;
                }
                iArrJ[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private mn0 y(uh uhVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        int iG;
        int i3;
        boolean zC = uhVar.c(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && (uhVar.c(i4) ^ zC)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i6;
        int iQ = p1.q(iArrJ, o);
        int i7 = iArr[1];
        if (z) {
            int iG2 = (uhVar.g() - 1) - i5;
            iG = (uhVar.g() - 1) - i7;
            i3 = iG2;
        } else {
            iG = i7;
            i3 = i5;
        }
        return new mn0(iQ, new int[]{i5, iArr[1]}, i3, iG, i2);
    }

    @Override // defpackage.nw1, defpackage.cd2
    public void b() {
        this.g.clear();
        this.h.clear();
    }

    @Override // defpackage.nw1
    public kh2 c(int i2, uh uhVar, Map map) throws NotFoundException {
        r(this.g, w(uhVar, false, i2, map));
        uhVar.j();
        r(this.h, w(uhVar, true, i2, map));
        uhVar.j();
        for (zy1 zy1Var : this.g) {
            if (zy1Var.c() > 1) {
                for (zy1 zy1Var2 : this.h) {
                    if (zy1Var2.c() > 1 && t(zy1Var, zy1Var2)) {
                        return u(zy1Var, zy1Var2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
