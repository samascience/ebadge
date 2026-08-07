package defpackage;

import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends ng {
    private final boolean a;
    private final List b;

    public /* synthetic */ g0(boolean z, List list, int i, y70 y70Var) {
        this(z, (i & 2) != 0 ? j.j() : list);
    }

    public g0(boolean z, List list) {
        p31.f(list, "failureList");
        this.a = z;
        this.b = list;
    }
}
