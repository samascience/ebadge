package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class e53 implements rm2 {
    private final rm2 a;
    private final ar0 b;

    public static final class a implements Iterator, k81 {
        private final Iterator a;

        a() {
            this.a = e53.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return e53.this.b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e53(rm2 rm2Var, ar0 ar0Var) {
        p31.f(rm2Var, "sequence");
        p31.f(ar0Var, "transformer");
        this.a = rm2Var;
        this.b = ar0Var;
    }

    @Override // defpackage.rm2
    public Iterator iterator() {
        return new a();
    }
}
