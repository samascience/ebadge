package defpackage;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.x;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zf2 {
    private static final double h = Math.sqrt(2.3703703703703702d);
    private final Size a;
    private final Rational b;
    private final Rational c;
    private final Set d;
    private final tw2 e;
    private final zt f;
    private final Map g;

    private static class a implements Comparator {
        private final Rational a;
        private final boolean b;

        a(Rational rational, boolean z) {
            this.a = rational;
            this.b = z;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Rational rational, Rational rational2) {
            float fC = zf2.c(rational, this.a);
            float fC2 = zf2.c(rational2, this.a);
            return this.b ? Float.compare(fC2, fC) : Float.compare(fC, fC2);
        }
    }

    zf2(CameraInternal cameraInternal, Set set) {
        this(y43.m(cameraInternal.h().d()), cameraInternal.n(), set);
    }

    private boolean A(Rational rational, Size size) {
        if (this.b.equals(rational) || ra.a(size, rational)) {
            return false;
        }
        return b(this.b.floatValue(), rational.floatValue(), M(size).floatValue());
    }

    private boolean B(Size size, Size size2) {
        return A(M(size), size2);
    }

    private boolean C() {
        Iterator it = k().iterator();
        while (it.hasNext()) {
            if (!ra.a((Size) it.next(), this.c)) {
                return true;
            }
        }
        return false;
    }

    private static List D(List list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    static Rect E(Rect rect) {
        return new Rect(rect.top, rect.left, rect.bottom, rect.right);
    }

    private List F(List list, boolean z) {
        Map mapW = w(list);
        ArrayList<Rational> arrayList = new ArrayList(mapW.keySet());
        J(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Rational rational : arrayList) {
            if (!rational.equals(ra.c) && !rational.equals(ra.a)) {
                List list2 = (List) mapW.get(rational);
                Objects.requireNonNull(list2);
                arrayList2.addAll(H(rational, list2, z));
            }
        }
        return arrayList2;
    }

    private List G(List list) {
        ArrayList arrayList = new ArrayList();
        if (C()) {
            arrayList.addAll(H(this.b, list, false));
        }
        arrayList.addAll(H(this.c, list, false));
        arrayList.addAll(F(list, false));
        if (arrayList.isEmpty()) {
            arrayList.addAll(F(list, true));
        }
        x.a("ResolutionsMerger", "Parent resolutions: " + arrayList);
        return arrayList;
    }

    private List H(Rational rational, List list, boolean z) {
        List<Size> listF = f(rational, list);
        K(listF);
        HashSet hashSet = new HashSet(listF);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            List listU = u((d0) it.next());
            if (!z) {
                listU = d(rational, listU);
            }
            if (listU.isEmpty()) {
                return new ArrayList();
            }
            listF = e(listU, listF);
            hashSet.retainAll(o(listU, listF));
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : listF) {
            if (!hashSet.contains(size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    private boolean I() {
        boolean z;
        wf2 wf2VarH;
        Iterator it = this.d.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            d0 d0Var = (d0) it.next();
            if (!d0Var.q(false) && (d0Var instanceof r) && (wf2VarH = ((r) d0Var).H(null)) != null) {
                z = true;
                if (wf2VarH.a() == 1) {
                    break;
                }
            }
        }
        return z;
    }

    private void J(List list) {
        Collections.sort(list, new a(L(this.a), true));
    }

    static void K(List list) {
        Collections.sort(list, new m00(true));
    }

    private static Rational L(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    private static Rational M(Size size) {
        Rational rational = ra.a;
        if (ra.a(size, rational)) {
            return rational;
        }
        Rational rational2 = ra.c;
        return ra.a(size, rational2) ? rational2 : L(size);
    }

    private boolean b(float f, float f2, float f3) {
        if (f == f2 || f2 == f3) {
            return false;
        }
        if (f > f2) {
            return f2 < f3;
        }
        return f2 > f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float c(Rational rational, Rational rational2) {
        float fFloatValue = rational.floatValue();
        float fFloatValue2 = rational2.floatValue();
        return fFloatValue > fFloatValue2 ? fFloatValue2 / fFloatValue : fFloatValue / fFloatValue2;
    }

    private List d(Rational rational, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (!A(rational, size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    static List e(Collection collection, List list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (z(collection, size)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    static List f(Rational rational, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (ra.a(size, rational)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    private static Rational g(Size size) {
        return ((double) size.getWidth()) / ((double) size.getHeight()) > h ? ra.c : ra.a;
    }

    private List h() {
        return this.f.j(34);
    }

    private List i() {
        return this.f.n(34);
    }

    private static Rect j(Rational rational, Size size) {
        RectF rectF;
        RectF rectF2;
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rationalL = L(size);
        if (rational.floatValue() == rationalL.floatValue()) {
            rectF2 = new RectF(0.0f, 0.0f, width, height);
        } else {
            if (rational.floatValue() > rationalL.floatValue()) {
                float f = width;
                float fFloatValue = f / rational.floatValue();
                float f2 = (height - fFloatValue) / 2.0f;
                rectF = new RectF(0.0f, f2, f, fFloatValue + f2);
            } else {
                float f3 = height;
                float fFloatValue2 = rational.floatValue() * f3;
                float f4 = (width - fFloatValue2) / 2.0f;
                rectF = new RectF(f4, 0.0f, fFloatValue2 + f4, f3);
            }
            rectF2 = rectF;
        }
        Rect rect = new Rect();
        rectF2.round(rect);
        return rect;
    }

    private Set k() {
        HashSet hashSet = new HashSet();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            hashSet.addAll(u((d0) it.next()));
        }
        return hashSet;
    }

    static Rect l(Size size, Size size2) {
        return j(L(size2), size);
    }

    private static Rational m(Rational rational) {
        Rational rational2 = ra.a;
        if (rational.equals(rational2)) {
            return ra.c;
        }
        if (rational.equals(ra.c)) {
            return rational2;
        }
        throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + rational);
    }

    static List o(Collection collection, List list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        List<Size> listD = D(list);
        ArrayList arrayList = new ArrayList();
        for (Size size : listD) {
            if (y(collection, size)) {
                arrayList.add(size);
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    private Pair s(Rect rect, d0 d0Var, boolean z) {
        Size sizeP;
        if (z) {
            sizeP = q(y43.m(rect), d0Var);
        } else {
            Size sizeM = y43.m(rect);
            sizeP = p(sizeM, d0Var);
            rect = l(sizeM, sizeP);
        }
        return new Pair(rect, sizeP);
    }

    private static Rational t(Size size) {
        Rational rationalG = g(size);
        x.a("ResolutionsMerger", "The closer aspect ratio to the sensor size (" + size + ") is " + rationalG + FileUtils.FILE_EXTENSION_SEPARATOR);
        return rationalG;
    }

    private List u(d0 d0Var) {
        if (!this.d.contains(d0Var)) {
            throw new IllegalArgumentException("Invalid child config: " + d0Var);
        }
        if (this.g.containsKey(d0Var)) {
            List list = (List) this.g.get(d0Var);
            Objects.requireNonNull(list);
            return list;
        }
        List listM = this.e.m(d0Var);
        this.g.put(d0Var, listM);
        return listM;
    }

    private static List v(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((Integer) pair.first).equals(34)) {
                return Arrays.asList((Size[]) pair.second);
            }
        }
        return new ArrayList();
    }

    private Map w(List list) {
        List arrayList;
        HashMap map = new HashMap();
        Rational rational = ra.a;
        map.put(rational, new ArrayList());
        Rational rational2 = ra.c;
        map.put(rational2, new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(rational);
        arrayList2.add(rational2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.getHeight() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        arrayList = null;
                        break;
                    }
                    Rational rational3 = (Rational) it2.next();
                    if (ra.a(size, rational3)) {
                        arrayList = (List) map.get(rational3);
                        break;
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    Rational rationalL = L(size);
                    arrayList2.add(rationalL);
                    map.put(rationalL, arrayList);
                }
                arrayList.add(size);
            }
        }
        return map;
    }

    static boolean x(Size size, Size size2) {
        return size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth();
    }

    private static boolean y(Collection collection, Size size) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (x((Size) it.next(), size)) {
                return false;
            }
        }
        return true;
    }

    private static boolean z(Collection collection, Size size) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!x((Size) it.next(), size)) {
                return true;
            }
        }
        return false;
    }

    List n(s sVar) {
        List listI = i();
        if (I()) {
            ArrayList arrayList = new ArrayList(listI);
            arrayList.addAll(h());
            listI = arrayList;
        }
        List list = (List) sVar.f(r.u, null);
        if (list != null) {
            listI = v(list);
        }
        return G(listI);
    }

    Size p(Size size, d0 d0Var) {
        List<Size> listU = u(d0Var);
        for (Size size2 : listU) {
            if (!B(size, size2) && !x(size2, size)) {
                return size2;
            }
        }
        for (Size size3 : listU) {
            if (!x(size3, size)) {
                return size3;
            }
        }
        return size;
    }

    Size q(Size size, d0 d0Var) {
        Iterator it = u(d0Var).iterator();
        while (it.hasNext()) {
            Size sizeM = y43.m(l((Size) it.next(), size));
            if (!x(sizeM, size)) {
                return sizeM;
            }
        }
        return size;
    }

    Pair r(d0 d0Var, Rect rect, int i, boolean z) {
        boolean z2;
        if (y43.i(i)) {
            rect = E(rect);
            z2 = true;
        } else {
            z2 = false;
        }
        Pair pairS = s(rect, d0Var, z);
        Rect rectE = (Rect) pairS.first;
        Size sizeO = (Size) pairS.second;
        if (z2) {
            sizeO = y43.o(sizeO);
            rectE = E(rectE);
        }
        return new Pair(rectE, sizeO);
    }

    private zf2(Size size, zt ztVar, Set set) {
        this(size, ztVar, set, new tw2(ztVar, size));
    }

    zf2(Size size, zt ztVar, Set set, tw2 tw2Var) {
        this.g = new HashMap();
        this.a = size;
        Rational rationalT = t(size);
        this.b = rationalT;
        this.c = m(rationalT);
        this.f = ztVar;
        this.d = set;
        this.e = tw2Var;
    }
}
