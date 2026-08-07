package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public final class y53 implements Iterator, k81 {
    private final ar0 a;
    private final List b = new ArrayList();
    private Iterator c;

    public y53(Iterator it, ar0 ar0Var) {
        this.a = ar0Var;
        this.c = it;
    }

    private final void a(Object obj) {
        Iterator it = (Iterator) this.a.invoke(obj);
        if (it != null && it.hasNext()) {
            this.b.add(this.c);
            this.c = it;
        } else {
            while (!this.c.hasNext() && !this.b.isEmpty()) {
                this.c = (Iterator) j.O(this.b);
                j.z(this.b);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object next = this.c.next();
        a(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
