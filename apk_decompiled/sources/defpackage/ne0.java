package defpackage;

import androidx.camera.core.impl.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ne0 {
    private static ie0 a(List list) {
        if (list.isEmpty()) {
            return null;
        }
        ie0 ie0Var = (ie0) list.get(0);
        Integer numValueOf = Integer.valueOf(ie0Var.b());
        Integer numValueOf2 = Integer.valueOf(ie0Var.a());
        for (int i = 1; i < list.size(); i++) {
            ie0 ie0Var2 = (ie0) list.get(i);
            numValueOf = c(numValueOf, Integer.valueOf(ie0Var2.b()));
            numValueOf2 = b(numValueOf2, Integer.valueOf(ie0Var2.a()));
            if (numValueOf == null || numValueOf2 == null) {
                return null;
            }
        }
        return new ie0(numValueOf.intValue(), numValueOf2.intValue());
    }

    private static Integer b(Integer num, Integer num2) {
        if (num.equals(0)) {
            return num2;
        }
        if (num2.equals(0) || num.equals(num2)) {
            return num;
        }
        return null;
    }

    private static Integer c(Integer num, Integer num2) {
        if (num.equals(0)) {
            return num2;
        }
        if (num2.equals(0)) {
            return num;
        }
        if (num.equals(2) && !num2.equals(1)) {
            return num2;
        }
        if ((!num2.equals(2) || num.equals(1)) && !num.equals(num2)) {
            return null;
        }
        return num;
    }

    public static ie0 d(Set set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((d0) it.next()).k());
        }
        return a(arrayList);
    }
}
