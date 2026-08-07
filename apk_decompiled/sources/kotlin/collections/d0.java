package kotlin.collections;

import defpackage.p31;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d0 extends c0 {
    public static Set d() {
        return EmptySet.INSTANCE;
    }

    public static final Set e(Set set) {
        p31.f(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : b0.c(set.iterator().next());
        }
        return b0.d();
    }

    public static Set f(Object... objArr) {
        p31.f(objArr, "elements");
        return h.F(objArr);
    }
}
