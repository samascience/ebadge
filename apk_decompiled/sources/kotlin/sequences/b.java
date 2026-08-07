package kotlin.sequences;

import defpackage.ar0;
import defpackage.k81;
import defpackage.p31;
import defpackage.rm2;
import defpackage.yq0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
final class b implements rm2 {
    private final yq0 a;
    private final ar0 b;

    public static final class a implements Iterator, k81 {
        private Object a;
        private int b = -2;

        a() {
        }

        private final void a() {
            Object objInvoke;
            if (this.b == -2) {
                objInvoke = b.this.a.invoke();
            } else {
                ar0 ar0Var = b.this.b;
                Object obj = this.a;
                p31.c(obj);
                objInvoke = ar0Var.invoke(obj);
            }
            this.a = objInvoke;
            this.b = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < 0) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b < 0) {
                a();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.a;
            p31.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(yq0 yq0Var, ar0 ar0Var) {
        p31.f(yq0Var, "getInitialValue");
        p31.f(ar0Var, "getNextValue");
        this.a = yq0Var;
        this.b = ar0Var;
    }

    @Override // defpackage.rm2
    public Iterator iterator() {
        return new a();
    }
}
