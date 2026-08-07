package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t90 {
    private static final int[] a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};
    private static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static void a(nh2[] nh2VarArr, nh2[] nh2VarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            nh2VarArr[iArr[i]] = nh2VarArr2[i];
        }
    }

    public static ny1 b(th thVar, Map map, boolean z) {
        wh whVarA = thVar.a();
        List listC = c(z, whVarA);
        if (listC.isEmpty()) {
            whVarA = whVarA.clone();
            whVarA.k();
            listC = c(z, whVarA);
        }
        return new ny1(whVarA, listC);
    }

    private static List c(boolean z, wh whVar) {
        int iC;
        float fD;
        ArrayList<nh2[]> arrayList = new ArrayList();
        int iMax = 0;
        int i = 0;
        loop0: while (true) {
            int i2 = i;
            while (iMax < whVar.g()) {
                nh2[] nh2VarArrF = f(whVar, iMax, i);
                if (nh2VarArrF[0] == null && nh2VarArrF[3] == null) {
                    if (i2 == 0) {
                        break;
                    }
                    for (nh2[] nh2VarArr : arrayList) {
                        nh2 nh2Var = nh2VarArr[1];
                        if (nh2Var != null) {
                            iMax = (int) Math.max(iMax, nh2Var.d());
                        }
                        nh2 nh2Var2 = nh2VarArr[3];
                        if (nh2Var2 != null) {
                            iMax = Math.max(iMax, (int) nh2Var2.d());
                        }
                    }
                    iMax += 5;
                    i = 0;
                } else {
                    arrayList.add(nh2VarArrF);
                    if (!z) {
                        break loop0;
                    }
                    nh2 nh2Var3 = nh2VarArrF[2];
                    if (nh2Var3 != null) {
                        iC = (int) nh2Var3.c();
                        fD = nh2VarArrF[2].d();
                    } else {
                        iC = (int) nh2VarArrF[4].c();
                        fD = nh2VarArrF[4].d();
                    }
                    iMax = (int) fD;
                    i = iC;
                    i2 = 1;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    private static int[] d(wh whVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (whVar.d(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (whVar.d(i, i2) ^ z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                int i8 = length - 1;
                if (i6 != i8) {
                    i6++;
                } else {
                    if (g(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i9 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || g(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    private static nh2[] e(wh whVar, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        boolean z;
        int i6;
        int i7;
        nh2[] nh2VarArr = new nh2[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i) {
                z = false;
                break;
            }
            int[] iArrD = d(whVar, i4, i8, i2, false, iArr, iArr2);
            if (iArrD != null) {
                int i9 = i8;
                int[] iArr3 = iArrD;
                while (i9 > 0) {
                    int i10 = i9 - 1;
                    int[] iArrD2 = d(whVar, i4, i10, i2, false, iArr, iArr2);
                    if (iArrD2 == null) {
                        break;
                    }
                    iArr3 = iArrD2;
                    i9 = i10;
                }
                float f = i9;
                nh2VarArr[0] = new nh2(iArr3[0], f);
                nh2VarArr[1] = new nh2(iArr3[1], f);
                z = true;
                i8 = i9;
                break;
            }
            i8 += 5;
        }
        int i11 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) nh2VarArr[0].c(), (int) nh2VarArr[1].c()};
            int i12 = i11;
            int i13 = 0;
            while (true) {
                if (i12 >= i) {
                    i6 = i13;
                    i7 = i12;
                    break;
                }
                i6 = i13;
                i7 = i12;
                int[] iArrD3 = d(whVar, iArr4[0], i12, i2, false, iArr, iArr2);
                if (iArrD3 != null && Math.abs(iArr4[0] - iArrD3[0]) < 5 && Math.abs(iArr4[1] - iArrD3[1]) < 5) {
                    iArr4 = iArrD3;
                    i13 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i13 = i6 + 1;
                }
                i12 = i7 + 1;
            }
            i11 = i7 - (i6 + 1);
            float f2 = i11;
            nh2VarArr[2] = new nh2(iArr4[0], f2);
            nh2VarArr[3] = new nh2(iArr4[1], f2);
        }
        if (i11 - i8 < 10) {
            for (i5 = 0; i5 < 4; i5++) {
                nh2VarArr[i5] = null;
            }
        }
        return nh2VarArr;
    }

    private static nh2[] f(wh whVar, int i, int i2) {
        int iG = whVar.g();
        int iJ = whVar.j();
        nh2[] nh2VarArr = new nh2[8];
        a(nh2VarArr, e(whVar, iG, iJ, i, i2, c), a);
        nh2 nh2Var = nh2VarArr[4];
        if (nh2Var != null) {
            i2 = (int) nh2Var.c();
            i = (int) nh2VarArr[4].d();
        }
        a(nh2VarArr, e(whVar, iG, iJ, i, i2, d), b);
        return nh2VarArr;
    }

    private static float g(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
