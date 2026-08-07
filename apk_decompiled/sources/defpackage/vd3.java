package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class vd3 implements eh0 {
    public static vd3 h(int i, int i2, List list, List list2) {
        b52.b(!list2.isEmpty(), "Should contain at least one VideoProfile.");
        return new xd(i, i2, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)), !list.isEmpty() ? (eh0.a) list.get(0) : null, (eh0.c) list2.get(0));
    }

    public static vd3 i(eh0 eh0Var) {
        return h(eh0Var.a(), eh0Var.b(), eh0Var.c(), eh0Var.d());
    }

    public abstract eh0.a j();

    public abstract eh0.c k();
}
