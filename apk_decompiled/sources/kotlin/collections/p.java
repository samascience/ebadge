package kotlin.collections;

import defpackage.p31;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class p extends o {
    public static void u(List list) {
        p31.f(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void v(List list, Comparator comparator) {
        p31.f(list, "<this>");
        p31.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
