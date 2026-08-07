package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.text.TextUtils;
import defpackage.b52;
import defpackage.ie0;
import defpackage.ke0;
import defpackage.re0;
import defpackage.zs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class d2 {
    private final zs a;
    private final re0 b;
    private final boolean c;

    static final class a {
        static ie0 a(zs zsVar) {
            Long l = (Long) zsVar.a(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (l != null) {
                return ke0.b(l.longValue());
            }
            return null;
        }
    }

    d2(zs zsVar) {
        this.a = zsVar;
        this.b = re0.a(zsVar);
        int[] iArr = (int[]) zsVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean z = false;
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 18) {
                    z = true;
                    break;
                }
            }
        }
        this.c = z;
    }

    private static boolean a(ie0 ie0Var, ie0 ie0Var2) {
        b52.j(ie0Var2.e(), "Fully specified range is not actually fully specified.");
        if (ie0Var.b() == 2 && ie0Var2.b() == 1) {
            return false;
        }
        if (ie0Var.b() == 2 || ie0Var.b() == 0 || ie0Var.b() == ie0Var2.b()) {
            return ie0Var.a() == 0 || ie0Var.a() == ie0Var2.a();
        }
        return false;
    }

    private static boolean b(ie0 ie0Var, ie0 ie0Var2, Set set) {
        if (set.contains(ie0Var2)) {
            return a(ie0Var, ie0Var2);
        }
        androidx.camera.core.x.a("DynamicRangeResolver", String.format("Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  %s\nCandidate dynamic range:\n  %s", ie0Var, ie0Var2));
        return false;
    }

    private static ie0 c(ie0 ie0Var, Collection collection, Set set) {
        if (ie0Var.b() == 1) {
            return null;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ie0 ie0Var2 = (ie0) it.next();
            b52.h(ie0Var2, "Fully specified DynamicRange cannot be null.");
            int iB = ie0Var2.b();
            b52.j(ie0Var2.e(), "Fully specified DynamicRange must have fully defined encoding.");
            if (iB != 1 && b(ie0Var, ie0Var2, set)) {
                return ie0Var2;
            }
        }
        return null;
    }

    private static boolean e(ie0 ie0Var) {
        return Objects.equals(ie0Var, ie0.c);
    }

    private static boolean f(ie0 ie0Var) {
        return ie0Var.b() == 2 || (ie0Var.b() != 0 && ie0Var.a() == 0) || (ie0Var.b() == 0 && ie0Var.a() != 0);
    }

    private ie0 h(ie0 ie0Var, Set set, Set set2, Set set3, String str) {
        ie0 ie0VarA;
        if (ie0Var.e()) {
            if (set.contains(ie0Var)) {
                return ie0Var;
            }
            return null;
        }
        int iB = ie0Var.b();
        int iA = ie0Var.a();
        if (iB == 1 && iA == 0) {
            ie0 ie0Var2 = ie0.d;
            if (set.contains(ie0Var2)) {
                return ie0Var2;
            }
            return null;
        }
        ie0 ie0VarC = c(ie0Var, set2, set);
        if (ie0VarC != null) {
            androidx.camera.core.x.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from existing attached surface.\n%s\n->\n%s", str, ie0Var, ie0VarC));
            return ie0VarC;
        }
        ie0 ie0VarC2 = c(ie0Var, set3, set);
        if (ie0VarC2 != null) {
            androidx.camera.core.x.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from concurrently bound use case.\n%s\n->\n%s", str, ie0Var, ie0VarC2));
            return ie0VarC2;
        }
        ie0 ie0Var3 = ie0.d;
        if (b(ie0Var, ie0Var3, set)) {
            androidx.camera.core.x.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s to no compatible HDR dynamic ranges.\n%s\n->\n%s", str, ie0Var, ie0Var3));
            return ie0Var3;
        }
        if (iB == 2 && (iA == 10 || iA == 0)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (Build.VERSION.SDK_INT >= 33) {
                ie0VarA = a.a(this.a);
                if (ie0VarA != null) {
                    linkedHashSet.add(ie0VarA);
                }
            } else {
                ie0VarA = null;
            }
            linkedHashSet.add(ie0.f);
            ie0 ie0VarC3 = c(ie0Var, linkedHashSet, set);
            if (ie0VarC3 != null) {
                androidx.camera.core.x.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from %s 10-bit supported dynamic range.\n%s\n->\n%s", str, ie0VarC3.equals(ie0VarA) ? "recommended" : "required", ie0Var, ie0VarC3));
                return ie0VarC3;
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ie0 ie0Var4 = (ie0) it.next();
            b52.j(ie0Var4.e(), "Candidate dynamic range must be fully specified.");
            if (!ie0Var4.equals(ie0.d) && a(ie0Var, ie0Var4)) {
                androidx.camera.core.x.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from validated dynamic range constraints or supported HDR dynamic ranges.\n%s\n->\n%s", str, ie0Var, ie0Var4));
                return ie0Var4;
            }
        }
        return null;
    }

    private ie0 i(Set set, Set set2, Set set3, androidx.camera.core.impl.d0 d0Var, Set set4) {
        ie0 ie0VarK = d0Var.k();
        ie0 ie0VarH = h(ie0VarK, set4, set2, set3, d0Var.K());
        if (ie0VarH == null) {
            throw new IllegalArgumentException(String.format("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  %s\nRequested dynamic range:\n  %s\nSupported dynamic ranges:\n  %s\nConstrained set of concurrent dynamic ranges:\n  %s", d0Var.K(), ie0VarK, TextUtils.join("\n  ", set), TextUtils.join("\n  ", set4)));
        }
        j(set4, ie0VarH, this.b);
        return ie0VarH;
    }

    private static void j(Set set, ie0 ie0Var, re0 re0Var) {
        b52.j(!set.isEmpty(), "Cannot update already-empty constraints.");
        Set setB = re0Var.b(ie0Var);
        if (setB.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet(set);
        set.retainAll(setB);
        if (set.isEmpty()) {
            throw new IllegalArgumentException(String.format("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  %s\nConstraints:\n  %s\nExisting constraints:\n  %s", ie0Var, TextUtils.join("\n  ", setB), TextUtils.join("\n  ", hashSet)));
        }
    }

    boolean d() {
        return this.c;
    }

    Map g(List list, List list2, List list3) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((androidx.camera.core.impl.a) it.next()).c());
        }
        Set setC = this.b.c();
        HashSet hashSet = new HashSet(setC);
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            j(hashSet, (ie0) it2.next(), this.b);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) list2.get(((Integer) it3.next()).intValue());
            ie0 ie0VarK = d0Var.k();
            if (e(ie0VarK)) {
                arrayList3.add(d0Var);
            } else if (f(ie0VarK)) {
                arrayList2.add(d0Var);
            } else {
                arrayList.add(d0Var);
            }
        }
        HashMap map = new HashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList<androidx.camera.core.impl.d0> arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        for (androidx.camera.core.impl.d0 d0Var2 : arrayList4) {
            ie0 ie0VarI = i(setC, linkedHashSet, linkedHashSet2, d0Var2, hashSet);
            map.put(d0Var2, ie0VarI);
            if (!linkedHashSet.contains(ie0VarI)) {
                linkedHashSet2.add(ie0VarI);
            }
        }
        return map;
    }
}
