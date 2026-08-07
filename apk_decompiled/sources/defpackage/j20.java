package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class j20 implements rm2 {
    private final AtomicReference a;

    public j20(rm2 rm2Var) {
        p31.f(rm2Var, "sequence");
        this.a = new AtomicReference(rm2Var);
    }

    @Override // defpackage.rm2
    public Iterator iterator() {
        rm2 rm2Var = (rm2) this.a.getAndSet(null);
        if (rm2Var != null) {
            return rm2Var.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
