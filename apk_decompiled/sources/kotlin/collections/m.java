package kotlin.collections;

import defpackage.p31;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m extends l {
    public static int t(Iterable iterable, int i) {
        p31.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
