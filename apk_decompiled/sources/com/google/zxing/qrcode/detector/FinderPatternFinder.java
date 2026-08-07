package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import defpackage.nh2;
import defpackage.nn0;
import defpackage.oh2;
import defpackage.wh;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FinderPatternFinder {
    private final wh a;
    private boolean c;
    private final List b = new ArrayList();
    private final int[] d = new int[5];

    private static final class CenterComparator implements Serializable, Comparator<d> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            if (dVar2.h() != dVar.h()) {
                return dVar2.h() - dVar.h();
            }
            float fAbs = Math.abs(dVar2.i() - this.average);
            float fAbs2 = Math.abs(dVar.i() - this.average);
            if (fAbs < fAbs2) {
                return 1;
            }
            return fAbs == fAbs2 ? 0 : -1;
        }
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<d> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            float fAbs = Math.abs(dVar2.i() - this.average);
            float fAbs2 = Math.abs(dVar.i() - this.average);
            if (fAbs < fAbs2) {
                return -1;
            }
            return fAbs == fAbs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(wh whVar, oh2 oh2Var) {
        this.a = whVar;
    }

    private static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArrH = h();
        int i12 = 0;
        while (i >= i12 && i2 >= i12 && this.a.d(i2 - i12, i - i12)) {
            iArrH[2] = iArrH[2] + 1;
            i12++;
        }
        if (i >= i12 && i2 >= i12) {
            while (i >= i12 && i2 >= i12 && !this.a.d(i2 - i12, i - i12)) {
                int i13 = iArrH[1];
                if (i13 > i3) {
                    break;
                }
                iArrH[1] = i13 + 1;
                i12++;
            }
            if (i >= i12 && i2 >= i12 && iArrH[1] <= i3) {
                while (i >= i12 && i2 >= i12 && this.a.d(i2 - i12, i - i12)) {
                    int i14 = iArrH[0];
                    if (i14 > i3) {
                        break;
                    }
                    iArrH[0] = i14 + 1;
                    i12++;
                }
                if (iArrH[0] > i3) {
                    return false;
                }
                int iG = this.a.g();
                int iJ = this.a.j();
                int i15 = 1;
                while (true) {
                    i5 = i + i15;
                    if (i5 >= iG || (i11 = i2 + i15) >= iJ || !this.a.d(i11, i5)) {
                        break;
                    }
                    iArrH[2] = iArrH[2] + 1;
                    i15++;
                }
                if (i5 < iG && i2 + i15 < iJ) {
                    while (true) {
                        i6 = i + i15;
                        if (i6 >= iG || (i9 = i2 + i15) >= iJ || this.a.d(i9, i6) || (i10 = iArrH[3]) >= i3) {
                            break;
                        }
                        iArrH[3] = i10 + 1;
                        i15++;
                    }
                    if (i6 < iG && i2 + i15 < iJ && iArrH[3] < i3) {
                        while (true) {
                            int i16 = i + i15;
                            if (i16 >= iG || (i7 = i2 + i15) >= iJ || !this.a.d(i7, i16) || (i8 = iArrH[4]) >= i3) {
                                break;
                            }
                            iArrH[4] = i8 + 1;
                            i15++;
                        }
                        int i17 = iArrH[4];
                        if (i17 < i3 && Math.abs(((((iArrH[0] + iArrH[1]) + iArrH[2]) + iArrH[3]) + i17) - i4) < i4 * 2 && g(iArrH)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private float c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        wh whVar = this.a;
        int iJ = whVar.j();
        int[] iArrH = h();
        int i8 = i;
        while (i8 >= 0 && whVar.d(i8, i2)) {
            iArrH[2] = iArrH[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !whVar.d(i8, i2)) {
            int i9 = iArrH[1];
            if (i9 > i3) {
                break;
            }
            iArrH[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && iArrH[1] <= i3) {
            while (i8 >= 0 && whVar.d(i8, i2) && (i7 = iArrH[0]) <= i3) {
                iArrH[0] = i7 + 1;
                i8--;
            }
            if (iArrH[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < iJ && whVar.d(i10, i2)) {
                iArrH[2] = iArrH[2] + 1;
                i10++;
            }
            if (i10 == iJ) {
                return Float.NaN;
            }
            while (i10 < iJ && !whVar.d(i10, i2) && (i6 = iArrH[3]) < i3) {
                iArrH[3] = i6 + 1;
                i10++;
            }
            if (i10 != iJ && iArrH[3] < i3) {
                while (i10 < iJ && whVar.d(i10, i2) && (i5 = iArrH[4]) < i3) {
                    iArrH[4] = i5 + 1;
                    i10++;
                }
                int i11 = iArrH[4];
                if (i11 < i3 && Math.abs(((((iArrH[0] + iArrH[1]) + iArrH[2]) + iArrH[3]) + i11) - i4) * 5 < i4 && g(iArrH)) {
                    return a(iArrH, i10);
                }
            }
        }
        return Float.NaN;
    }

    private float d(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        wh whVar = this.a;
        int iG = whVar.g();
        int[] iArrH = h();
        int i8 = i;
        while (i8 >= 0 && whVar.d(i2, i8)) {
            iArrH[2] = iArrH[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !whVar.d(i2, i8)) {
            int i9 = iArrH[1];
            if (i9 > i3) {
                break;
            }
            iArrH[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && iArrH[1] <= i3) {
            while (i8 >= 0 && whVar.d(i2, i8) && (i7 = iArrH[0]) <= i3) {
                iArrH[0] = i7 + 1;
                i8--;
            }
            if (iArrH[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < iG && whVar.d(i2, i10)) {
                iArrH[2] = iArrH[2] + 1;
                i10++;
            }
            if (i10 == iG) {
                return Float.NaN;
            }
            while (i10 < iG && !whVar.d(i2, i10) && (i6 = iArrH[3]) < i3) {
                iArrH[3] = i6 + 1;
                i10++;
            }
            if (i10 != iG && iArrH[3] < i3) {
                while (i10 < iG && whVar.d(i2, i10) && (i5 = iArrH[4]) < i3) {
                    iArrH[4] = i5 + 1;
                    i10++;
                }
                int i11 = iArrH[4];
                if (i11 < i3 && Math.abs(((((iArrH[0] + iArrH[1]) + iArrH[2]) + iArrH[3]) + i11) - i4) * 5 < i4 * 2 && g(iArrH)) {
                    return a(iArrH, i10);
                }
            }
        }
        return Float.NaN;
    }

    private int f() {
        if (this.b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean g(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    private int[] h() {
        int[] iArr = this.d;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean j() {
        int size = this.b.size();
        float fAbs = 0.0f;
        int i = 0;
        float fI = 0.0f;
        for (d dVar : this.b) {
            if (dVar.h() >= 2) {
                i++;
                fI += dVar.i();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = fI / size;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(((d) it.next()).i() - f);
        }
        return fAbs <= fI * 0.05f;
    }

    private d[] k() throws NotFoundException {
        int size = this.b.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fI = 0.0f;
        if (size > 3) {
            Iterator it = this.b.iterator();
            float f = 0.0f;
            float f2 = 0.0f;
            while (it.hasNext()) {
                float fI2 = ((d) it.next()).i();
                f += fI2;
                f2 += fI2 * fI2;
            }
            float f3 = size;
            float f4 = f / f3;
            float fSqrt = (float) Math.sqrt((f2 / f3) - (f4 * f4));
            Collections.sort(this.b, new FurthestFromAverageComparator(f4));
            float fMax = Math.max(0.2f * f4, fSqrt);
            int i = 0;
            while (i < this.b.size() && this.b.size() > 3) {
                if (Math.abs(((d) this.b.get(i)).i() - f4) > fMax) {
                    this.b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.b.size() > 3) {
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                fI += ((d) it2.next()).i();
            }
            Collections.sort(this.b, new CenterComparator(fI / this.b.size()));
            List list = this.b;
            list.subList(3, list.size()).clear();
        }
        return new d[]{(d) this.b.get(0), (d) this.b.get(1), (d) this.b.get(2)};
    }

    final nn0 e(Map map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int iG = this.a.g();
        int iJ = this.a.j();
        int i = (iG * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean zJ = false;
        while (i2 < iG && !zJ) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < iJ) {
                if (this.a.d(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (g(iArr) && i(iArr, i2, i3, z2)) {
                    if (this.c) {
                        zJ = j();
                    } else {
                        int iF = f();
                        int i5 = iArr[2];
                        if (iF > i5) {
                            i2 += (iF - i5) - 2;
                            i3 = iJ - 1;
                        }
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i4 = 0;
                    i = 2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i4 = 3;
                }
                i3++;
            }
            if (g(iArr) && i(iArr, i2, iJ, z2)) {
                i = iArr[0];
                if (this.c) {
                    zJ = j();
                }
            }
            i2 += i;
        }
        d[] dVarArrK = k();
        nh2.e(dVarArrK);
        return new nn0(dVarArrK);
    }

    protected final boolean i(int[] iArr, int i, int i2, boolean z) {
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i2);
        float fD = d(i, iA, iArr[2], i3);
        if (!Float.isNaN(fD)) {
            int i4 = (int) fD;
            float fC = c(iA, i4, iArr[2], i3);
            if (!Float.isNaN(fC) && (!z || b(i4, (int) fC, iArr[2], i3))) {
                float f = i3 / 7.0f;
                for (int i5 = 0; i5 < this.b.size(); i5++) {
                    d dVar = (d) this.b.get(i5);
                    if (dVar.f(f, fD, fC)) {
                        this.b.set(i5, dVar.g(fD, fC, f));
                        return true;
                    }
                }
                this.b.add(new d(fC, fD, f));
                return true;
            }
        }
        return false;
    }
}
