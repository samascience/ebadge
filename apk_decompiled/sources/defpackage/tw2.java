package defpackage;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.r;
import androidx.camera.core.x;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tw2 {
    private final zt a;
    private final int b;
    private final int c;
    private final Rational d;
    private final uw2 e;

    public tw2(zt ztVar, Size size) {
        this.a = ztVar;
        this.b = ztVar.a();
        this.c = ztVar.f();
        Rational rationalH = size != null ? h(size) : i(ztVar);
        this.d = rationalH;
        this.e = new uw2(ztVar, rationalH);
    }

    private static LinkedHashMap a(List list, qa qaVar, Rational rational) {
        return b(o(list), qaVar, rational);
    }

    private static LinkedHashMap b(Map map, qa qaVar, Rational rational) {
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        Rational rationalN = n(qaVar.b(), z);
        if (qaVar.a() == 0) {
            Rational rationalN2 = n(qaVar.b(), z);
            for (Rational rational2 : new ArrayList(map.keySet())) {
                if (!rational2.equals(rationalN2)) {
                    map.remove(rational2);
                }
            }
        }
        ArrayList<Rational> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList, new ra.a(rationalN, rational));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Rational rational3 : arrayList) {
            linkedHashMap.put(rational3, (List) map.get(rational3));
        }
        return linkedHashMap;
    }

    private List c(List list, wf2 wf2Var, int i) {
        if (wf2Var.a() != 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.a.j(i));
        Collections.sort(arrayList, new m00(true));
        return arrayList;
    }

    private static void d(LinkedHashMap linkedHashMap, Size size) {
        int iC = ir2.c(size);
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            List<Size> list = (List) linkedHashMap.get((Rational) it.next());
            ArrayList arrayList = new ArrayList();
            for (Size size2 : list) {
                if (ir2.c(size2) <= iC) {
                    arrayList.add(size2);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
    }

    private static List e(List list, vf2 vf2Var, int i, int i2, int i3) {
        if (vf2Var == null) {
            return list;
        }
        List listA = vf2Var.a(new ArrayList(list), pu.a(pu.b(i), i2, i3 == 1));
        if (list.containsAll(listA)) {
            return listA;
        }
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    private static void f(LinkedHashMap linkedHashMap, yf2 yf2Var) {
        if (yf2Var == null) {
            return;
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            g((List) linkedHashMap.get((Rational) it.next()), yf2Var);
        }
    }

    private static void g(List list, yf2 yf2Var) {
        if (list.isEmpty()) {
            return;
        }
        int iB = yf2Var.b();
        if (yf2Var.equals(yf2.c)) {
            return;
        }
        Size sizeA = yf2Var.a();
        if (iB == 0) {
            s(list, sizeA);
            return;
        }
        if (iB == 1) {
            q(list, sizeA, true);
            return;
        }
        if (iB == 2) {
            q(list, sizeA, false);
        } else if (iB == 3) {
            r(list, sizeA, true);
        } else {
            if (iB != 4) {
                return;
            }
            r(list, sizeA, false);
        }
    }

    private Rational h(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational i(zt ztVar) {
        List listN = ztVar.n(256);
        if (listN.isEmpty()) {
            return null;
        }
        Size size = (Size) Collections.max(listN, new m00());
        return new Rational(size.getWidth(), size.getHeight());
    }

    private List j(List list, int i) {
        List listL = l(list, i);
        if (listL == null) {
            listL = this.a.n(i);
        }
        ArrayList arrayList = new ArrayList(listL);
        Collections.sort(arrayList, new m00(true));
        if (arrayList.isEmpty()) {
            x.k("SupportedOutputSizesCollector", "The retrieved supported resolutions from camera info internal is empty. Format is " + i + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        return arrayList;
    }

    static List k(List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ra.a);
        arrayList.add(ra.c);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList.contains(rational)) {
                Iterator it2 = arrayList.iterator();
                do {
                    if (!it2.hasNext()) {
                        arrayList.add(rational);
                        break;
                    }
                } while (!ra.a(size, (Rational) it2.next()));
            }
        }
        return arrayList;
    }

    private List l(List list, int i) {
        Size[] sizeArr;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (((Integer) pair.first).intValue() == i) {
                    sizeArr = (Size[]) pair.second;
                }
            }
            sizeArr = null;
        } else {
            sizeArr = null;
        }
        if (sizeArr == null) {
            return null;
        }
        return Arrays.asList(sizeArr);
    }

    static Rational n(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                return z ? ra.a : ra.b;
            }
            if (i == 1) {
                return z ? ra.c : ra.d;
            }
            x.c("SupportedOutputSizesCollector", "Undefined target aspect ratio: " + i);
        }
        return null;
    }

    static Map o(List list) {
        HashMap map = new HashMap();
        Iterator it = k(list).iterator();
        while (it.hasNext()) {
            map.put((Rational) it.next(), new ArrayList());
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Size size = (Size) it2.next();
            for (Rational rational : map.keySet()) {
                if (ra.a(size, rational)) {
                    ((List) map.get(rational)).add(size);
                }
            }
        }
        return map;
    }

    public static List p(wf2 wf2Var, List list, Size size, int i, Rational rational, int i2, int i3) {
        LinkedHashMap linkedHashMapA = a(list, wf2Var.b(), rational);
        if (size != null) {
            d(linkedHashMapA, size);
        }
        f(linkedHashMapA, wf2Var.d());
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMapA.values().iterator();
        while (it.hasNext()) {
            for (Size size2 : (List) it.next()) {
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
        }
        return e(arrayList, wf2Var.c(), i, i2, i3);
    }

    static void q(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = (Size) list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void r(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Size size2 = (Size) list.get(i);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void s(List list, Size size) {
        boolean zContains = list.contains(size);
        list.clear();
        if (zContains) {
            list.add(size);
        }
    }

    public List m(d0 d0Var) {
        r rVar = (r) d0Var;
        List listO = rVar.o(null);
        if (listO != null) {
            return listO;
        }
        wf2 wf2VarH = rVar.H(null);
        List listJ = j(rVar.l(null), d0Var.p());
        if (wf2VarH == null) {
            return this.e.f(listJ, d0Var);
        }
        Size sizeI = ((r) d0Var).i(null);
        int iU = rVar.U(0);
        if (!d0Var.q(false)) {
            listJ = c(listJ, wf2VarH, d0Var.p());
        }
        return p(rVar.m(), listJ, sizeI, iU, this.d, this.b, this.c);
    }
}
