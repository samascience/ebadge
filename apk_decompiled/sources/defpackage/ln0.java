package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class ln0 implements rm2 {
    private final rm2 a;
    private final boolean b;
    private final ar0 c;

    public static final class a implements Iterator, k81 {
        private final Iterator a;
        private int b = -1;
        private Object c;

        a() {
            this.a = ln0.this.a.iterator();
        }

        private final void a() {
            while (this.a.hasNext()) {
                Object next = this.a.next();
                if (((Boolean) ln0.this.c.invoke(next)).booleanValue() == ln0.this.b) {
                    this.c = next;
                    this.b = 1;
                    return;
                }
            }
            this.b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b == -1) {
                a();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.c;
            this.c = null;
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ln0(rm2 rm2Var, boolean z, ar0 ar0Var) {
        p31.f(rm2Var, "sequence");
        p31.f(ar0Var, "predicate");
        this.a = rm2Var;
        this.b = z;
        this.c = ar0Var;
    }

    @Override // defpackage.rm2
    public Iterator iterator() {
        return new a();
    }
}
