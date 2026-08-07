package defpackage;

import androidx.camera.core.impl.CameraInternal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class tu {
    public static final tu c = new a().b(0).a();
    public static final tu d = new a().b(1).a();
    private final LinkedHashSet a;
    private final String b;

    public static final class a {
        private final LinkedHashSet a = new LinkedHashSet();
        private String b;

        public tu a() {
            return new tu(this.a, this.b);
        }

        public a b(int i) {
            b52.j(i != -1, "The specified lens facing is invalid.");
            this.a.add(new ra1(i));
            return this;
        }
    }

    tu(LinkedHashSet linkedHashSet, String str) {
        this.a = linkedHashSet;
        this.b = str;
    }

    public LinkedHashSet a(LinkedHashSet linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((CameraInternal) it.next()).a());
        }
        List listB = b(arrayList);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            CameraInternal cameraInternal = (CameraInternal) it2.next();
            if (listB.contains(cameraInternal.a())) {
                linkedHashSet2.add(cameraInternal);
            }
        }
        return linkedHashSet2;
    }

    public List b(List list) {
        List arrayList = new ArrayList(list);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            arrayList = ((wt) it.next()).b(Collections.unmodifiableList(arrayList));
        }
        arrayList.retainAll(list);
        return arrayList;
    }

    public LinkedHashSet c() {
        return this.a;
    }

    public Integer d() {
        Integer num = null;
        for (wt wtVar : this.a) {
            if (wtVar instanceof ra1) {
                Integer numValueOf = Integer.valueOf(((ra1) wtVar).c());
                if (num == null) {
                    num = numValueOf;
                } else if (!num.equals(numValueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    public CameraInternal e(LinkedHashSet linkedHashSet) {
        Iterator it = a(linkedHashSet).iterator();
        if (it.hasNext()) {
            return (CameraInternal) it.next();
        }
        throw new IllegalArgumentException("No available camera can be found");
    }
}
