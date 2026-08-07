package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f1 implements Iterator, k81 {
    private int a;
    private Object b;

    private final boolean d() {
        this.a = 3;
        a();
        return this.a == 1;
    }

    protected abstract void a();

    protected final void b() {
        this.a = 2;
    }

    protected final void c(Object obj) {
        this.b = obj;
        this.a = 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.a;
        if (i == 0) {
            return d();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.a;
        if (i == 1) {
            this.a = 0;
            return this.b;
        }
        if (i == 2 || !d()) {
            throw new NoSuchElementException();
        }
        this.a = 0;
        return this.b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
