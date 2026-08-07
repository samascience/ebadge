package com.google.zxing.datamatrix.detector;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.zxing.NotFoundException;
import com.jieli.jl_rcsp.constant.WatchConstant;
import defpackage.dh1;
import defpackage.hi3;
import defpackage.lv0;
import defpackage.nh2;
import defpackage.u90;
import defpackage.wh;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Detector {
    private final wh a;
    private final hi3 b;

    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<b> {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    private static final class b {
        private final nh2 a;
        private final nh2 b;
        private final int c;

        nh2 a() {
            return this.a;
        }

        nh2 b() {
            return this.b;
        }

        int c() {
            return this.c;
        }

        public String toString() {
            return this.a + WatchConstant.FAT_FS_ROOT + this.b + JsonPointer.SEPARATOR + this.c;
        }

        private b(nh2 nh2Var, nh2 nh2Var2, int i) {
            this.a = nh2Var;
            this.b = nh2Var2;
            this.c = i;
        }
    }

    public Detector(wh whVar) {
        this.a = whVar;
        this.b = new hi3(whVar);
    }

    private nh2 a(nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4, int i) {
        float f = i;
        float fD = d(nh2Var, nh2Var2) / f;
        float fD2 = d(nh2Var3, nh2Var4);
        nh2 nh2Var5 = new nh2(nh2Var4.c() + (((nh2Var4.c() - nh2Var3.c()) / fD2) * fD), nh2Var4.d() + (fD * ((nh2Var4.d() - nh2Var3.d()) / fD2)));
        float fD3 = d(nh2Var, nh2Var3) / f;
        float fD4 = d(nh2Var2, nh2Var4);
        nh2 nh2Var6 = new nh2(nh2Var4.c() + (((nh2Var4.c() - nh2Var2.c()) / fD4) * fD3), nh2Var4.d() + (fD3 * ((nh2Var4.d() - nh2Var2.d()) / fD4)));
        if (f(nh2Var5)) {
            return (f(nh2Var6) && Math.abs(h(nh2Var3, nh2Var5).c() - h(nh2Var2, nh2Var5).c()) > Math.abs(h(nh2Var3, nh2Var6).c() - h(nh2Var2, nh2Var6).c())) ? nh2Var6 : nh2Var5;
        }
        if (f(nh2Var6)) {
            return nh2Var6;
        }
        return null;
    }

    private nh2 b(nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4, int i, int i2) {
        float fD = d(nh2Var, nh2Var2) / i;
        float fD2 = d(nh2Var3, nh2Var4);
        nh2 nh2Var5 = new nh2(nh2Var4.c() + (((nh2Var4.c() - nh2Var3.c()) / fD2) * fD), nh2Var4.d() + (fD * ((nh2Var4.d() - nh2Var3.d()) / fD2)));
        float fD3 = d(nh2Var, nh2Var3) / i2;
        float fD4 = d(nh2Var2, nh2Var4);
        nh2 nh2Var6 = new nh2(nh2Var4.c() + (((nh2Var4.c() - nh2Var2.c()) / fD4) * fD3), nh2Var4.d() + (fD3 * ((nh2Var4.d() - nh2Var2.d()) / fD4)));
        if (f(nh2Var5)) {
            return (f(nh2Var6) && Math.abs(i - h(nh2Var3, nh2Var5).c()) + Math.abs(i2 - h(nh2Var2, nh2Var5).c()) > Math.abs(i - h(nh2Var3, nh2Var6).c()) + Math.abs(i2 - h(nh2Var2, nh2Var6).c())) ? nh2Var6 : nh2Var5;
        }
        if (f(nh2Var6)) {
            return nh2Var6;
        }
        return null;
    }

    private static int d(nh2 nh2Var, nh2 nh2Var2) {
        return dh1.c(nh2.b(nh2Var, nh2Var2));
    }

    private static void e(Map map, nh2 nh2Var) {
        Integer num = (Integer) map.get(nh2Var);
        map.put(nh2Var, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean f(nh2 nh2Var) {
        return nh2Var.c() >= 0.0f && nh2Var.c() < ((float) this.a.j()) && nh2Var.d() > 0.0f && nh2Var.d() < ((float) this.a.g());
    }

    private static wh g(wh whVar, nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4, int i, int i2) {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return lv0.b().c(whVar, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, nh2Var.c(), nh2Var.d(), nh2Var4.c(), nh2Var4.d(), nh2Var3.c(), nh2Var3.d(), nh2Var2.c(), nh2Var2.d());
    }

    private b h(nh2 nh2Var, nh2 nh2Var2) {
        int iC = (int) nh2Var.c();
        int iD = (int) nh2Var.d();
        int iC2 = (int) nh2Var2.c();
        int iD2 = (int) nh2Var2.d();
        int i = 0;
        boolean z = Math.abs(iD2 - iD) > Math.abs(iC2 - iC);
        if (z) {
            iD = iC;
            iC = iD;
            iD2 = iC2;
            iC2 = iD2;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iD2 - iD);
        int i2 = (-iAbs) / 2;
        int i3 = iD < iD2 ? 1 : -1;
        int i4 = iC >= iC2 ? -1 : 1;
        boolean zD = this.a.d(z ? iD : iC, z ? iC : iD);
        while (iC != iC2) {
            boolean zD2 = this.a.d(z ? iD : iC, z ? iC : iD);
            if (zD2 != zD) {
                i++;
                zD = zD2;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (iD == iD2) {
                    break;
                }
                iD += i3;
                i2 -= iAbs;
            }
            iC += i4;
        }
        return new b(nh2Var, nh2Var2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u90 c() throws NotFoundException {
        nh2 nh2Var;
        nh2 nh2Var2;
        wh whVarG;
        nh2[] nh2VarArrC = this.b.c();
        nh2 nh2Var3 = nh2VarArrC[0];
        nh2 nh2Var4 = nh2VarArrC[1];
        nh2 nh2Var5 = nh2VarArrC[2];
        nh2 nh2Var6 = nh2VarArrC[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(nh2Var3, nh2Var4));
        arrayList.add(h(nh2Var3, nh2Var5));
        arrayList.add(h(nh2Var4, nh2Var6));
        arrayList.add(h(nh2Var5, nh2Var6));
        nh2 nh2Var7 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap map = new HashMap();
        e(map, bVar.a());
        e(map, bVar.b());
        e(map, bVar2.a());
        e(map, bVar2.b());
        nh2 nh2Var8 = null;
        nh2 nh2Var9 = null;
        for (Map.Entry entry : map.entrySet()) {
            nh2 nh2Var10 = (nh2) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                nh2Var8 = nh2Var10;
            } else if (nh2Var7 == null) {
                nh2Var7 = nh2Var10;
            } else {
                nh2Var9 = nh2Var10;
            }
        }
        if (nh2Var7 == null || nh2Var8 == null || nh2Var9 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        nh2[] nh2VarArr = {nh2Var7, nh2Var8, nh2Var9};
        nh2.e(nh2VarArr);
        nh2 nh2Var11 = nh2VarArr[0];
        nh2 nh2Var12 = nh2VarArr[1];
        nh2 nh2Var13 = nh2VarArr[2];
        if (!map.containsKey(nh2Var3)) {
            nh2Var = nh2Var3;
        } else if (map.containsKey(nh2Var4)) {
            nh2Var = !map.containsKey(nh2Var5) ? nh2Var5 : nh2Var6;
        } else {
            nh2Var = nh2Var4;
        }
        int iC = h(nh2Var13, nh2Var).c();
        int iC2 = h(nh2Var11, nh2Var).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i2 = iC2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            nh2 nh2VarB = b(nh2Var12, nh2Var11, nh2Var13, nh2Var, i, i2);
            if (nh2VarB != null) {
                nh2Var = nh2VarB;
            }
            int iC3 = h(nh2Var13, nh2Var).c();
            int iC4 = h(nh2Var11, nh2Var).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            int i3 = iC3;
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            nh2Var2 = nh2Var13;
            whVarG = g(this.a, nh2Var13, nh2Var12, nh2Var11, nh2Var, i3, iC4);
        } else {
            nh2 nh2VarA = a(nh2Var12, nh2Var11, nh2Var13, nh2Var, Math.min(i2, i));
            if (nh2VarA != null) {
                nh2Var = nh2VarA;
            }
            int iMax = Math.max(h(nh2Var13, nh2Var).c(), h(nh2Var11, nh2Var).c());
            int i4 = iMax + 1;
            int i5 = (i4 & 1) == 1 ? iMax + 2 : i4;
            whVarG = g(this.a, nh2Var13, nh2Var12, nh2Var11, nh2Var, i5, i5);
            nh2Var2 = nh2Var13;
        }
        return new u90(whVarG, new nh2[]{nh2Var2, nh2Var12, nh2Var11, nh2Var});
    }
}
