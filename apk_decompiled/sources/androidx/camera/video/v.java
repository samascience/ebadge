package androidx.camera.video;

import android.util.Size;
import defpackage.b52;
import defpackage.eh0;
import defpackage.ie0;
import defpackage.vd3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class v {
    private final List a;
    private final o b;

    v(List list, o oVar) {
        b52.b((list.isEmpty() && oVar == o.a) ? false : true, "No preferred quality and fallback strategy.");
        this.a = Collections.unmodifiableList(new ArrayList(list));
        this.b = oVar;
    }

    private void a(List list, Set set) {
        if (list.isEmpty() || set.containsAll(list)) {
            return;
        }
        androidx.camera.core.x.a("QualitySelector", "Select quality by fallbackStrategy = " + this.b);
        o oVar = this.b;
        if (oVar == o.a) {
            return;
        }
        b52.j(oVar instanceof o.b, "Currently only support type RuleStrategy");
        o.b bVar = (o.b) this.b;
        List listB = s.b();
        s sVarB = bVar.b() == s.f ? (s) listB.get(0) : bVar.b() == s.e ? (s) listB.get(listB.size() - 1) : bVar.b();
        b52.i(listB.indexOf(sVarB) != -1);
        ArrayList arrayList = new ArrayList();
        for (int i = r4 - 1; i >= 0; i--) {
            s sVar = (s) listB.get(i);
            if (list.contains(sVar)) {
                arrayList.add(sVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = r4 + 1; i2 < listB.size(); i2++) {
            s sVar2 = (s) listB.get(i2);
            if (list.contains(sVar2)) {
                arrayList2.add(sVar2);
            }
        }
        androidx.camera.core.x.a("QualitySelector", "sizeSortedQualities = " + listB + ", fallback quality = " + sVarB + ", largerQualities = " + arrayList + ", smallerQualities = " + arrayList2);
        int iC = bVar.c();
        if (iC != 0) {
            if (iC == 1) {
                set.addAll(arrayList);
                set.addAll(arrayList2);
                return;
            }
            if (iC == 2) {
                set.addAll(arrayList);
                return;
            }
            if (iC != 3) {
                if (iC == 4) {
                    set.addAll(arrayList2);
                    return;
                }
                throw new AssertionError("Unhandled fallback strategy: " + this.b);
            }
            set.addAll(arrayList2);
            set.addAll(arrayList);
        }
    }

    private static void b(s sVar) {
        b52.b(s.a(sVar), "Invalid quality: " + sVar);
    }

    private static void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            b52.b(s.a(sVar), "qualities contain invalid quality: " + sVar);
        }
    }

    public static v d(s sVar) {
        return e(sVar, o.a);
    }

    public static v e(s sVar, o oVar) {
        b52.h(sVar, "quality cannot be null");
        b52.h(oVar, "fallbackStrategy cannot be null");
        b(sVar);
        return new v(Collections.singletonList(sVar), oVar);
    }

    public static v f(List list, o oVar) {
        b52.h(list, "qualities cannot be null");
        b52.h(oVar, "fallbackStrategy cannot be null");
        b52.b(!list.isEmpty(), "qualities cannot be empty");
        c(list);
        return new v(list, oVar);
    }

    private static Size h(vd3 vd3Var) {
        eh0.c cVarK = vd3Var.k();
        return new Size(cVarK.k(), cVarK.h());
    }

    public static Map i(m0 m0Var, ie0 ie0Var) {
        HashMap map = new HashMap();
        for (s sVar : m0Var.c(ie0Var)) {
            vd3 vd3VarD = m0Var.d(sVar, ie0Var);
            Objects.requireNonNull(vd3VarD);
            map.put(sVar, h(vd3VarD));
        }
        return map;
    }

    List g(List list) {
        if (list.isEmpty()) {
            androidx.camera.core.x.k("QualitySelector", "No supported quality on the device.");
            return new ArrayList();
        }
        androidx.camera.core.x.a("QualitySelector", "supportedQualities = " + list);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (s sVar : this.a) {
            if (sVar == s.f) {
                linkedHashSet.addAll(list);
                break;
            }
            if (sVar == s.e) {
                ArrayList arrayList = new ArrayList(list);
                Collections.reverse(arrayList);
                linkedHashSet.addAll(arrayList);
                break;
            }
            if (list.contains(sVar)) {
                linkedHashSet.add(sVar);
            } else {
                androidx.camera.core.x.k("QualitySelector", "quality is not supported and will be ignored: " + sVar);
            }
        }
        a(list, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public String toString() {
        return "QualitySelector{preferredQualities=" + this.a + ", fallbackStrategy=" + this.b + "}";
    }
}
