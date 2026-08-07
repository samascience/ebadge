package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class yd0 implements rm2, zd0 {
    private final rm2 a;
    private final int b;

    public static final class a implements Iterator, k81 {
        private final Iterator a;
        private int b;

        a(yd0 yd0Var) {
            this.a = yd0Var.a.iterator();
            this.b = yd0Var.b;
        }

        private final void a() {
            while (this.b > 0 && this.a.hasNext()) {
                this.a.next();
                this.b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public yd0(rm2 rm2Var, int i) {
        p31.f(rm2Var, "sequence");
        this.a = rm2Var;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // defpackage.zd0
    public rm2 a(int i) {
        int i2 = this.b + i;
        return i2 < 0 ? new yd0(this, i) : new yd0(this.a, i2);
    }

    @Override // defpackage.rm2
    public Iterator iterator() {
        return new a(this);
    }
}
