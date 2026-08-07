package defpackage;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class uw2 {
    private final int a;
    private final int b;
    private final Rational c;
    private final boolean d;

    uw2(zt ztVar, Rational rational) {
        this.a = ztVar.a();
        this.b = ztVar.f();
        this.c = rational;
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        this.d = z;
    }

    private static Size a(Size size, int i, int i2, int i3) {
        return (size == null || !e(i, i2, i3)) ? size : new Size(size.getHeight(), size.getWidth());
    }

    private static Rational b(Size size, List list) {
        if (size == null) {
            return null;
        }
        for (Rational rational : tw2.k(list)) {
            if (ra.a(size, rational)) {
                return rational;
            }
        }
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational c(r rVar, List list) {
        if (rVar.L()) {
            return tw2.n(rVar.O(), this.d);
        }
        Size sizeD = d(rVar);
        if (sizeD != null) {
            return b(sizeD, list);
        }
        return null;
    }

    private Size d(r rVar) {
        return a(rVar.A(null), rVar.U(0), this.b, this.a);
    }

    private static boolean e(int i, int i2, int i3) {
        int iA = pu.a(pu.b(i), i3, 1 == i2);
        return iA == 90 || iA == 270;
    }

    List f(List list, d0 d0Var) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<Size> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new m00(true));
        ArrayList arrayList2 = new ArrayList();
        r rVar = (r) d0Var;
        Size sizeI = rVar.i(null);
        Size size = (Size) arrayList.get(0);
        if (sizeI == null || ir2.c(size) < ir2.c(sizeI)) {
            sizeI = size;
        }
        Size sizeD = d(rVar);
        Size size2 = ir2.c;
        int iC = ir2.c(size2);
        if (ir2.c(sizeI) < iC) {
            size2 = ir2.a;
        } else if (sizeD != null && ir2.c(sizeD) < iC) {
            size2 = sizeD;
        }
        for (Size size3 : arrayList) {
            if (ir2.c(size3) <= ir2.c(sizeI) && ir2.c(size3) >= ir2.c(size2) && !arrayList2.contains(size3)) {
                arrayList2.add(size3);
            }
        }
        if (arrayList2.isEmpty()) {
            throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + size2 + "\nmaxSize = " + sizeI + "\ninitial size list: " + arrayList);
        }
        Rational rationalC = c(rVar, arrayList2);
        if (sizeD == null) {
            sizeD = rVar.v(null);
        }
        ArrayList arrayList3 = new ArrayList();
        new HashMap();
        if (rationalC == null) {
            arrayList3.addAll(arrayList2);
            if (sizeD != null) {
                tw2.q(arrayList3, sizeD, true);
            }
        } else {
            Map mapO = tw2.o(arrayList2);
            if (sizeD != null) {
                Iterator it = mapO.keySet().iterator();
                while (it.hasNext()) {
                    tw2.q((List) mapO.get((Rational) it.next()), sizeD, true);
                }
            }
            ArrayList arrayList4 = new ArrayList(mapO.keySet());
            Collections.sort(arrayList4, new ra.a(rationalC, this.c));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                for (Size size4 : (List) mapO.get((Rational) it2.next())) {
                    if (!arrayList3.contains(size4)) {
                        arrayList3.add(size4);
                    }
                }
            }
        }
        return arrayList3;
    }
}
