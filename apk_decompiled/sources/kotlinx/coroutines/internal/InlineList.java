package kotlinx.coroutines.internal;

import defpackage.ar0;
import defpackage.p31;
import defpackage.y70;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class InlineList<E> {
    private final Object holder;

    private /* synthetic */ InlineList(Object obj) {
        this.holder = obj;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InlineList m138boximpl(Object obj) {
        return new InlineList(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <E> Object m139constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ Object m140constructorimpl$default(Object obj, int i, y70 y70Var) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m139constructorimpl(obj);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m141equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && p31.a(obj, ((InlineList) obj2).m147unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m142equalsimpl0(Object obj, Object obj2) {
        return p31.a(obj, obj2);
    }

    /* JADX INFO: renamed from: forEachReversed-impl, reason: not valid java name */
    public static final void m143forEachReversedimpl(Object obj, ar0 ar0Var) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ar0Var.invoke(obj);
            return;
        }
        p31.d(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                ar0Var.invoke(arrayList.get(size));
            }
        }
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m144hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m145plusFjFbRPM(Object obj, E e) {
        if (obj == null) {
            return m139constructorimpl(e);
        }
        if (obj instanceof ArrayList) {
            p31.d(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e);
            return m139constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return m139constructorimpl(arrayList);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m146toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m141equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m144hashCodeimpl(this.holder);
    }

    public String toString() {
        return m146toStringimpl(this.holder);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m147unboximpl() {
        return this.holder;
    }
}
